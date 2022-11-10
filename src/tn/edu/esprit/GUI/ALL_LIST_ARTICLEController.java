/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CommandeArticle;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ALL_LIST_ARTICLEController implements Initializable {

    @FXML
    private AnchorPane anchor1;
    @FXML
    private Label label;
    @FXML
    private TableView<CommandeArticle> tablistarticle;
    @FXML
    private Button retourlistarticle;
    @FXML
    private Button supparticleadmin;
    @FXML
    private Button modstatusarticleadmin;
    @FXML
    private ChoiceBox<String> statusarticleadmin;
    @FXML
    private Label text1;
    @FXML
    private TableColumn<CommandeArticle, Date> datecmd;
    @FXML
    private TableColumn<CommandeArticle, String> statuscmd;
    @FXML
    private TableColumn<CommandeArticle, String> modlivcmd;

    String[] a = {"Deja traité", "En cours de livraison"};
    @FXML
    private Text erreur;
    @FXML
    private ImageView imgser1;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CommandeServices cs = new CommandeServices();
        ObservableList<CommandeArticle> ca = cs.getAllCommandeArt();

        datecmd.setCellValueFactory(new PropertyValueFactory<CommandeArticle, Date>("dateCommande"));
        statuscmd.setCellValueFactory(new PropertyValueFactory<CommandeArticle, String>("statusLivraison"));
        modlivcmd.setCellValueFactory(new PropertyValueFactory<CommandeArticle, String>("modeLivraison"));

        tablistarticle.setItems(ca);
        statusarticleadmin.getItems().addAll(a);
        Utilisateur us = NewFXMainClass.us;
        userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());

    }

    @FXML
    private void tablistarticleclick(MouseEvent event) {
        CommandeArticle u = tablistarticle.getSelectionModel().getSelectedItem();
        statusarticleadmin.setValue(u.getStatusLivraison());
    }

    @FXML
    private void tablistarticle(SortEvent<?> event) {
    }

    @FXML
    private void RETOUR500(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("Admincontrol.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void supparticleadminclick(ActionEvent event) throws IOException {
        CommandeArticle u = tablistarticle.getSelectionModel().getSelectedItem();
        CommandeServices su = new CommandeServices();

        su.supprimerCommandeArticle(u);

        Parent root = FXMLLoader.load(getClass().getResource("ALL_LIST_ARTICLE.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

        Alert alert = new Alert(AlertType.CONFIRMATION, "Commande supprimer avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void modstatusarticleadminclick(ActionEvent event) throws IOException {
        CommandeArticle a = tablistarticle.getSelectionModel().getSelectedItem();
        CommandeServices su = new CommandeServices();

        if (a.getStatusLivraison().equals("Deja traité")) {

            Alert alert = new Alert(AlertType.WARNING, "Cette commande est déja traité ( pas de modification) !!", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        } else {
            try {
                if (statusarticleadmin.getValue().toString().equals("")) {

                    Alert alert = new Alert(AlertType.WARNING, "Donner la status de la commande!", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();

                } else {
                    a.setStatusLivraison(statusarticleadmin.getValue().toString());

                    su.modifierCommandeArticleAdmin(a);
                    Parent root = FXMLLoader.load(getClass().getResource("ALL_LIST_ARTICLE.fxml"));
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    Alert alert = new Alert(AlertType.CONFIRMATION, "Commande modifier avec succés !", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();
                }
            } catch (java.lang.NullPointerException x) {

                Alert alert = new Alert(AlertType.WARNING, "Donner la status de la commande!", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();

            }

        }

    }

}
