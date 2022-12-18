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
import tn.edu.esprit.entities.CommandeService;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DEVISSController implements Initializable {

    @FXML
    private Text wrongLog;
    @FXML
    private Button devisdevisS;
    @FXML
    private Button facturedevisS;
    @FXML
    private Button retourdeviS;
    @FXML
    private Text msg;
    @FXML
    private ImageView imgser;
    @FXML
    private Text userinfo;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Utilisateur us = NewFXMainClass.us;
                userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());

    }    

    @FXML
    private void RETOUR100(ActionEvent event) throws IOException {
        wrongLog.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("CMD.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void avoirfactureservice(ActionEvent event) throws IOException {
        CommandeServices cs = new CommandeServices();
                Utilisateur us = NewFXMainClass.us;

        cs.genererFactureServicePDF(us.getIdUser());
        wrongLog.getScene().getWindow().hide();;
        Parent root1 = FXMLLoader.load(getClass().getResource("FactureService.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root1);
        mainStage.setScene(scene);
        mainStage.show();
        
        
    }

    @FXML
    private void avoirdevisservice(ActionEvent event) {
        CommandeServices cs = new CommandeServices();
        Utilisateur us = NewFXMainClass.us;
        cs.genererDevisServicePDF(us.getIdUser());
    }
    
}
