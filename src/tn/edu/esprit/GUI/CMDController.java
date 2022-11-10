/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Utilisateur;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class CMDController implements Initializable {

    @FXML
    private AnchorPane anchor1;

    @FXML
    private Text wrongLog;

    @FXML
    private ImageView imgser;

    @FXML
    private javafx.scene.control.Button M_S_SR;
    @FXML
    private javafx.scene.control.Button M_S_AR;
    @FXML
    private javafx.scene.control.Button cmdSER;
    @FXML
    private javafx.scene.control.Button cmdAR;
    @FXML
    private Text userinfo;
    @FXML
    private javafx.scene.control.Button cmdAR1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                Utilisateur us = NewFXMainClass.us;

        userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());
    }

  

    @FXML
    private void M_S_SR(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("MOD_S.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void M_S_AR(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("MOD_A.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void cmdSR(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("CMDSER.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void cmdAR(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("CMDA.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void retourcmdaa(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

}
