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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ClientController implements Initializable {

    @FXML
    private Text lab;
    @FXML
    private Button aa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consulterservice(ActionEvent event) throws IOException {
        lab.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("View1.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void passercommande(ActionEvent event) throws IOException {
        lab.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("CMD.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void consulterformation(ActionEvent event) throws IOException {
        lab.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("AcceuilUtilisateur.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void deconnexion(ActionEvent event) throws IOException {
        lab.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void espaceUser(ActionEvent event) throws IOException {
        lab.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("EspaceUserMagasin.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void reclamation(ActionEvent event) throws IOException {
        lab.getScene().getWindow().hide();;
        MainKais.role = "user";
        aa.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AjouterREclamation.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show(); 
    }

    @FXML
    private void rate(ActionEvent event) throws IOException {
        lab.getScene().getWindow().hide();;
        MainKais.role = "user";
        aa.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AjouterAvisArticle.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show(); 
    }
    
}
