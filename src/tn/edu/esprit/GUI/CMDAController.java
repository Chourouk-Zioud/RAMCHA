/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Article;
import tn.edu.esprit.entities.CommandeArticle;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;
import tn.edu.esprit.tools.DataS;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CMDAController implements Initializable {

    @FXML
    private Text wrongLog;

    @FXML
    private javafx.scene.control.Button retourcmd;

    @FXML
    private javafx.scene.control.Button cmmanderarticlecmd;


    @FXML
    private Text text1cmd;

    @FXML
    private Text text2cmd;

    @FXML
    private ChoiceBox<String> modelivraisoncmd;

    @FXML
    private Label ppp;
    @FXML
    private TableView<Article> tableauarticle;
    @FXML
    private TableColumn<Article, String> nomproduit;
    @FXML
    private TableColumn<Article, Float> prixarticle;

    int idAr;

    String[] a = {"A domicile", "Au travail"};
    @FXML
    private Text erreur;
    @FXML
    private ImageView imgser;
    @FXML
    private Text userinfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx = DataS.getInstance().getConnection();
        CommandeServices sca = new CommandeServices();
        ObservableList<Article> k = sca.getAllArticle();

        nomproduit.setCellValueFactory(new PropertyValueFactory<Article, String>("nomArticle"));
        prixarticle.setCellValueFactory(new PropertyValueFactory<Article, Float>("prixArticle"));
        tableauarticle.setItems(k);

        modelivraisoncmd.getItems().addAll(a);

        tableauarticle.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Utilisateur us = NewFXMainClass.us;
        userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());


    }

    @FXML
    private void RETOUR20(ActionEvent event) throws IOException {
        ppp.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("CMD.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void afficherarticle() {
        Connection cnx = DataS.getInstance().getConnection();
        CommandeServices scs = new CommandeServices();
        ObservableList<Article> k = scs.getAllArticle();

        nomproduit.setCellValueFactory(new PropertyValueFactory<Article, String>("nomArticle"));
        prixarticle.setCellValueFactory(new PropertyValueFactory<Article, Float>("prixArticle"));
        System.out.println(k);
        tableauarticle.setItems(k);

    }

    @FXML
    private void C_ARTICLE(ActionEvent event) throws IOException {

        Utilisateur us = NewFXMainClass.us;
        us.getIdUser();
        ArrayList<Article> b = new ArrayList();
        Article a = tableauarticle.getSelectionModel().getSelectedItem();
        //modelivraisoncmd.getValue().toString();
        b.add(a);
        CommandeArticle y = new CommandeArticle();
        y.setArticle(a);
        y.setModeLivraison(modelivraisoncmd.getValue());
        CommandeServices z = new CommandeServices();
        try {
            if (modelivraisoncmd.getValue().length() == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Enter le mode de livraison !!", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
            } else {
                z.ajouterCommandeArticle(y, us, b);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Commande enregistrée avec succés !", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                ppp.getScene().getWindow().hide();
                Parent root1 = FXMLLoader.load(getClass().getResource("DEVISA.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root1);
                mainStage.setScene(scene);
                mainStage.show();
            }
        } catch (java.lang.NullPointerException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Enter le mode de livraison !", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();
        }

    }

    @FXML
    private void idArt(MouseEvent event) {
    }

}
