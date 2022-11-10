/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class Acceuil1Controller implements Initializable {

    @FXML
    private Button service_cours;
    @FXML
    private Button sevice_avis;
    @FXML
    private Button service_chapitre;
    @FXML
    private Button qc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void service_courss(ActionEvent event) throws IOException {
        
        service_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void service_chapitres(ActionEvent event) throws IOException {
                service_cours.getScene().getWindow().hide();

         Parent root = FXMLLoader.load(getClass().getResource("AffichageChapitre.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void service_aviss(ActionEvent event) throws IOException {
                service_cours.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("AffichageAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void retouracc(ActionEvent event) throws IOException {
        
        service_cours.getScene().getWindow().hide();

        Parent root = FXMLLoader.load(getClass().getResource("dashbord.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
    
}
