/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Article;
import tn.edu.esprit.entities.CommandeArticle;
import tn.edu.esprit.entities.CommandeService;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;
import tn.edu.esprit.tools.DataS;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MOD_SController implements Initializable {

    @FXML
    private Text wrongLog;
    @FXML
    private Text text1SUPA;
    @FXML
    private Button retourMODS;
    @FXML
    private Button modifierMODS;
    @FXML
    private TableView<CommandeService> MODSLIST;
    @FXML
    private Button supprimerMODS;
    @FXML
    private Text text2MODS;
    @FXML
    private DatePicker dateMODS;
    @FXML
    private TableColumn<CommandeService, Date> datecmdser;
    @FXML
    private TableColumn<CommandeService, String> serviceser;
    @FXML
    private TableColumn<CommandeService, Float> prixser;
    @FXML
    private TableColumn<CommandeService, Date> daterequis;
    @FXML
    private TableColumn<CommandeService, String> sttser;
    @FXML
    private TableColumn<CommandeService, Integer> nbjour;
    @FXML
    private ProgressBar progressbarser;
    @FXML
    private Label sttsser;
    @FXML
    private Spinner<Integer> nbjours;
    @FXML
    private Text erreur;
    @FXML
    private ImageView imgser;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx = DataS.getInstance().getConnection();
        CommandeServices scs = new CommandeServices();
        Utilisateur us = NewFXMainClass.us;
        ObservableList<CommandeService> k = scs.getCommandeS(us.getIdUser());
        datecmdser.setCellValueFactory(new PropertyValueFactory<CommandeService, Date>("dateCommandeService"));
        serviceser.setCellValueFactory(new PropertyValueFactory<CommandeService, String>("nomService"));
        prixser.setCellValueFactory(new PropertyValueFactory<CommandeService, Float>("prixService"));
        daterequis.setCellValueFactory(new PropertyValueFactory<CommandeService, Date>("dateRequis"));
        sttser.setCellValueFactory(new PropertyValueFactory<CommandeService, String>("statusCommande"));
        nbjour.setCellValueFactory(new PropertyValueFactory<CommandeService, Integer>("nbjour"));

        //System.out.print(k);
        MODSLIST.setItems(k);
        //CommandeService a = MODSLIST.getSelectionModel().getSelectedItem();
        progressbarser.setProgress(0);
        SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.nbjours.setValueFactory(gradesValueFactory);
         userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());

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
    private void V_MODS(ActionEvent event) throws IOException {
        java.sql.Date date1 = new java.sql.Date(dateMODS.getValue().getYear() - 1900, dateMODS.getValue().getMonthValue() - 1, dateMODS.getValue().getDayOfMonth());
        CommandeService u = MODSLIST.getSelectionModel().getSelectedItem();
        CommandeServices a = new CommandeServices();

        LocalDate date2 = java.time.LocalDate.now();
        LocalDate date3 = date1.toLocalDate();
        try {
            if (nbjours.getValue() <= 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Entre le nombre de jours ( >0 )!!", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
            } else if (date2.isAfter(date3)) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Entrer une date valide", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
            } else {
                if (u.getStatusCommande().equals("Deja traité")) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Commande déja traité ( pas de modification )!", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();
                } else {
                    u.setDateRequis(date1);
                    u.setNbjour(nbjours.getValue().intValue());
                    a.modfierCommanderServiceClient(u);
                    Parent root = FXMLLoader.load(getClass().getResource("MOD_S.fxml"));
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Commande modifier avec succés !", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();
                }
            }
        } catch (java.lang.NullPointerException x) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Entrer un nombre de jours suppérieur à 0", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void SUPP_MODS(ActionEvent event) throws IOException {
        CommandeService u = MODSLIST.getSelectionModel().getSelectedItem();
        CommandeServices su = new CommandeServices();
        su.supprimerCommandeService(u);
        Parent root = FXMLLoader.load(getClass().getResource("MOD_S.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Commande supprimer avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
    }
    @FXML
    private void progser(MouseEvent event) {
        CommandeService q = MODSLIST.getSelectionModel().getSelectedItem();

        if (q.getStatusCommande().equals("en cours de traitement")) {
            progressbarser.setProgress(0);
            sttsser.setText("Commande en cours de traitement");
        } else if (q.getStatusCommande().equals("En cours de livraison")) {
            progressbarser.setProgress(0.5);
            sttsser.setText("Commande en cours de  livraison");
        } else if (q.getStatusCommande().equals("Deja traité")) {
            progressbarser.setProgress(1);
            sttsser.setText("Commande déja traitée");
        }
        dateMODS.setValue(q.getDateRequis().toLocalDate());
        SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, q.getNbjour());
        nbjours.setValueFactory(gradesValueFactory);

    }

}
