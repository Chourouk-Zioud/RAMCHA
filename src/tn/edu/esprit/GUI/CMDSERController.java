/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import static java.lang.String.valueOf;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CommandeService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;
import tn.edu.esprit.tools.DataS;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CMDSERController implements Initializable {

    @FXML
    private AnchorPane anchor1;
    @FXML
    private Text wrongLog;
    @FXML
    private Button cmmanderserviceser;
    @FXML
    private Button retourser;
    @FXML
    private Text text1ser;
    @FXML
    private Text text2ser;
    @FXML
    private DatePicker dateser;
    @FXML
    private TableColumn<ServiceT, String> nomService;
    @FXML
    private TableColumn<ServiceT, Float> prixService;
    @FXML
    private TableView<ServiceT> tabservice;
    int idSer;
    @FXML
    private Text text2ser1;
    @FXML
    private Spinner<Integer> nbjours;
    @FXML
    private Label erreur;
    @FXML
    private ImageView imgser1;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx = DataS.getInstance().getConnection();
        CommandeServices scs = new CommandeServices();
        ObservableList<ServiceT> k = scs.getAllService();

        nomService.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("nomService"));
        prixService.setCellValueFactory(new PropertyValueFactory<ServiceT, Float>("prixService"));
        System.out.println(k);

        tabservice.setItems(k);
        SpinnerValueFactory<Integer> gradesValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 0);
        this.nbjours.setValueFactory(gradesValueFactory);
            Utilisateur us = NewFXMainClass.us;

                userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());

    }

    @FXML
    private void C_SERVICE(Event event) throws IOException {
        CommandeServices scs = new CommandeServices();
        CommandeService c = new CommandeService();
        java.sql.Date date1 = null;
        LocalDate date2 = null;
        LocalDate date3 = null;
        c.setStatusCommande("en cours de traitement");
        try{
            date1 = new java.sql.Date(dateser.getValue().getYear() - 1900, dateser.getValue().getMonthValue() - 1, dateser.getValue().getDayOfMonth());
            date2 = java.time.LocalDate.now();
            date3 = date1.toLocalDate();
        }catch (java.lang.NullPointerException e) {
        
            Alert alert = new Alert (AlertType.WARNING, "Remplissez tous les champs !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();

        }
        
        System.out.print(c.getNbjour());
        ServiceT s = new ServiceT();
        int a = idSer(event);

        s.setIdService(idSer);
        Utilisateur us = NewFXMainClass.us;
        us.getIdUser();
        c.setUtilisateur(us);
        int j = nbjours.getValue().intValue();
        try {
            if (date2.isAfter(date3)) {
                Alert alert = new Alert (AlertType.WARNING, "Entrer une date valide !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            } else if (j < 0) {
                Alert alert = new Alert (AlertType.WARNING, "Entrer un nombre de jours suppérieur à 0 !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            } else {
                c.setDateRequis(date1);
                c.setNbjour(nbjours.getValue().intValue());
                scs.ajouterCommandeService(s, us, c);
                wrongLog.getScene().getWindow().hide();
                Alert alert = new Alert (Alert.AlertType.CONFIRMATION, "Commande enregistrée avec succés !", javafx.scene.control.ButtonType.OK);
                alert.showAndWait();
                Parent root = FXMLLoader.load(getClass().getResource("DEVISS.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            }
        } catch (java.lang.NullPointerException e) {
            Alert alert = new Alert (AlertType.WARNING, "Entrer les paramétres du commande !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();

        }
    }

    private void AfficherService(ActionEvent event) {
        Connection cnx = DataS.getInstance().getConnection();
        CommandeServices scs = new CommandeServices();
        ObservableList<ServiceT> k = scs.getAllService();

        nomService.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("nomService"));
        prixService.setCellValueFactory(new PropertyValueFactory<ServiceT, Float>("prixService"));
        System.out.println(k);
        tabservice.setItems(k);
    }

    @FXML
    private void RETOUR30(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("CMD.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private Integer idSer(Event event) {
        try {
            ServiceT clicked_offre = tabservice.getSelectionModel().getSelectedItem();

            idSer = Integer.valueOf(clicked_offre.getIdService());
            System.out.println(idSer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return idSer;
    }

}
