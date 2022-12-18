/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SortEvent;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MOD_AController implements Initializable {

    @FXML
    private Button retourMODA;
    @FXML
    private Button validerMODA;
    @FXML
    private Text wrongLog;
    @FXML
    private Text text1MODA;
    @FXML
    private Text text2MODA;
    @FXML
    private Label ppp;
    @FXML
    private TableView<CommandeArticle> MODALIST;
    @FXML
    private Button supprimerMODA;
    @FXML
    private TableColumn<CommandeArticle, Date> datecommande;
    @FXML
    private TableColumn<CommandeArticle, String> statuscommande;
    @FXML
    private TableColumn<CommandeArticle, String> livraisoncommande;

    Connection cnx;
    @FXML
    private TableColumn<CommandeArticle, String> article;
    @FXML
    private TableColumn<CommandeArticle, Float> prixarticle2;
    @FXML
    private ChoiceBox<String> modmodcmd;
    @FXML
    private ProgressBar progressbar;
    @FXML
    private Label stts;
    @FXML
    private Text erreur;
    @FXML
    private ImageView imgser;
    @FXML
    private Text userinfo;

    public MOD_AController() {
        this.cnx = DataS.getInstance().getConnection();
    }
    String[] a = {"A domicile", "Au travail"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx = DataS.getInstance().getConnection();
        CommandeServices sca = new CommandeServices();
                Utilisateur us = NewFXMainClass.us;

        ObservableList<CommandeArticle> k = sca.getCommande(us.getIdUser());
        datecommande.setCellValueFactory(new PropertyValueFactory<CommandeArticle, Date>("dateCommande"));
        statuscommande.setCellValueFactory(new PropertyValueFactory<CommandeArticle, String>("statusLivraison"));
        livraisoncommande.setCellValueFactory(new PropertyValueFactory<CommandeArticle, String>("modeLivraison"));
        article.setCellValueFactory(new PropertyValueFactory<CommandeArticle, String>("nomArticle"));
        prixarticle2.setCellValueFactory(new PropertyValueFactory<CommandeArticle, Float>("prixArticle"));
        System.out.print(k);
        MODALIST.setItems(k);

        modmodcmd.getItems().addAll(a);
        progressbar.setProgress(0);
                //userinfo.setText(u.getNomUser + " " + u.getPrenomUser);


    }

    @FXML
    private void RETOUR90(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("CMD.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }

    @FXML
    private void V_MODA(ActionEvent event) throws IOException {

        CommandeArticle a = MODALIST.getSelectionModel().getSelectedItem();
        CommandeServices su = new CommandeServices();
        try {
            if (modmodcmd.getValue().toString().equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Enter le mode de livraison !!", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
            } else {
                if (a.getStatusLivraison().equals("Deja traité")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Tu ne peux pas modifier une commande déja traité!", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();
                } else if (a.getStatusLivraison().equals("En cours de livraison")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Tu ne peux pas modifier une commande en train de livraison!", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();

                } else {
                    a.setModeLivraison(modmodcmd.getValue().toString());
                    su.modifierCommandeArticleUtilisateur(a);

                    Parent root = FXMLLoader.load(getClass().getResource("MOD_A.fxml"));
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Commande modifier avec succés !", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();
                }
            }
        } catch (java.lang.NullPointerException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Enter le mode de livraison !!", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

        }

    }

    @FXML
    private void SUPP_MODA(ActionEvent event) throws IOException {
        CommandeArticle u = MODALIST.getSelectionModel().getSelectedItem();
        CommandeServices su = new CommandeServices();

        su.supprimerCommandeArticle(u);

        Parent root = FXMLLoader.load(getClass().getResource("MOD_A.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Commande supprimée avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void progre(MouseEvent event) {
        CommandeArticle q = MODALIST.getSelectionModel().getSelectedItem();

        if (q.getStatusLivraison().equals("En cours de traitement")) {
            progressbar.setProgress(0);
            stts.setText("Commande en cours de traitement");
        } else if (q.getStatusLivraison().equals("En cours de livraison")) {
            progressbar.setProgress(0.5);
            stts.setText("Commande en cours de  livraison");
        } else if (q.getStatusLivraison().equals("Deja traité")) {
            progressbar.setProgress(1);
            stts.setText("Commande déja traitée");
        }
        modmodcmd.setValue(q.getModeLivraison());
    }

}
