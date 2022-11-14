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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Utilisateur;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FactureArticleController implements Initializable {

    @FXML
    private Button retour999;
    @FXML
    private Text wrongLog;
    @FXML
    private Label ppp;
    @FXML
    private Label stts;
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
        int i = 0;
        while(i<1){
            try{
                ppp.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("FactureArticle.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
            }catch(Exception e){
                
            }
            i++;
        }
                Utilisateur us = NewFXMainClass.us;

                userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());

        
    }    

    @FXML
    private void RETOUR90(ActionEvent event) throws IOException {
        ppp.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("CMD.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
    }
    
}
