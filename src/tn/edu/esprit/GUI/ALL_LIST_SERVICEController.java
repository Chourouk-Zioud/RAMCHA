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
import tn.edu.esprit.entities.CommandeService;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ALL_LIST_SERVICEController implements Initializable {

    @FXML
    private AnchorPane anchor1;
    @FXML
    private ImageView imgser;
    @FXML
    private Label label;
    @FXML
    private TableView<CommandeService> tablistservice;
    @FXML
    private Button retourlistservice;
    @FXML
    private Button suppserviceadmin;
    @FXML
    private Button modstatusserviceadmin;
    @FXML
    private ChoiceBox<String> statusserviceadmin;
    @FXML
    private Label text1;

    String[] a = {"Deja traité", "En cours de livraison"};
    @FXML
    private TableColumn<CommandeService, Date> datecmdser;
    @FXML
    private TableColumn<CommandeService, Date> datereqser;
    @FXML
    private TableColumn<CommandeService, Integer> nbjourser;
    @FXML
    private TableColumn<CommandeService, String> statuscmdser;
    @FXML
    private Text erreur;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statusserviceadmin.getItems().addAll(a);
        CommandeServices cs = new CommandeServices();
        ObservableList<CommandeService> k = cs.getAllCommandeSer();

        datecmdser.setCellValueFactory(new PropertyValueFactory<CommandeService, Date>("dateCommandeService"));
        datereqser.setCellValueFactory(new PropertyValueFactory<CommandeService, Date>("dateRequis"));
        statuscmdser.setCellValueFactory(new PropertyValueFactory<CommandeService, String>("statusCommande"));
        nbjourser.setCellValueFactory(new PropertyValueFactory<CommandeService, Integer>("nbjour"));

        tablistservice.setItems(k);
        Utilisateur us = NewFXMainClass.us;
        userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());


    }

    @FXML
    private void tablistserviceclick(MouseEvent event) {
        CommandeService u = tablistservice.getSelectionModel().getSelectedItem();
        statusserviceadmin.setValue(u.getStatusCommande());
    }

    @FXML
    private void tablistservice(SortEvent<?> event) {
    }

    @FXML
    private void RETOUR5005(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("Admincontrol.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void suppserviceadminclick(ActionEvent event) throws IOException {

        CommandeService u = tablistservice.getSelectionModel().getSelectedItem();
        CommandeServices su = new CommandeServices();

        su.supprimerCommandeService(u);

        Parent root = FXMLLoader.load(getClass().getResource("ALL_LIST_SERVICE.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Commande supprimer avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    private void modstatusserviceadminclick(ActionEvent event) throws IOException {
        CommandeService a = tablistservice.getSelectionModel().getSelectedItem();
        CommandeServices su = new CommandeServices();

        if (a.getStatusCommande().equals("Deja traité")) {
            
            Alert alert = new Alert(AlertType.WARNING, "Cette commande est déja traité ( pas de modification) !", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
        } else {
            try {
                if (statusserviceadmin.getValue().toString().equals("")) {
                   
                    Alert alert = new Alert(AlertType.WARNING, "Donner le status de la commande !", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                } else {
                    a.setStatusCommande(statusserviceadmin.getValue().toString());
                    su.modifierCommandeServiceAdmin(a);
                    Parent root = FXMLLoader.load(getClass().getResource("ALL_LIST_SERVICE.fxml"));
                    Scene scene = new Scene(root);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Commande modifier avec succés !", javafx.scene.control.ButtonType.OK);
                    alert.showAndWait();
                }

            } catch (java.lang.NullPointerException x) {
                Alert alert = new Alert(AlertType.WARNING, "Donner le status de la commande !", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
            }

        }

    }

}
