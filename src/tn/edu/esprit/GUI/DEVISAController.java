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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DEVISAController implements Initializable {

    @FXML
    private Text wrongLog;
    @FXML
    private Button devisdevisA;
    @FXML
    private Button facturedevisA;
    @FXML
    private Button retourdeviA;
    @FXML
    private Text msg;
    @FXML
    private ImageView imgser;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //msg.setText("Commande enregistrée avec succés");
                Utilisateur us = NewFXMainClass.us;

        userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());

    }    

    @FXML
    private void RETOUR40(ActionEvent event) throws IOException {
         wrongLog.getScene().getWindow().hide();;
                Parent root1 = FXMLLoader.load(getClass().getResource("CMD.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root1);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void devisarticlepdf(ActionEvent event) {
        CommandeServices p = new CommandeServices();
                Utilisateur us = NewFXMainClass.us;

        p.genererDevisArticlePDF(us.getIdUser());
        

    }

    @FXML
    private void avoirfacturearticle(ActionEvent event) throws IOException {
        CommandeServices p = new CommandeServices();
                Utilisateur us = NewFXMainClass.us;

        p.genererFactureArticlePDF(us.getIdUser());
        wrongLog.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("FactureArticle.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();

    }
    
}
