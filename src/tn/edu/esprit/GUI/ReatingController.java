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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.services.ServicesAvisCours;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReatingController implements Initializable {

    @FXML
    private Label notreat;
    @FXML
    private RadioButton gr1;
    @FXML
    private ToggleGroup grating;
    @FXML
    private RadioButton gr3;
    @FXML
    private RadioButton gr2;
    @FXML
    private RadioButton gr4;
    @FXML
    private RadioButton gr5;
    @FXML
    private TextArea idc;
    @FXML
    private ImageView omg;
String notte;
    @FXML
    private TextArea textComm;
    @FXML
    private Button retour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickbtn(ActionEvent event) throws IOException {
        
           if(gr1.isSelected()){
            notte="1";
        }else if(gr2.isSelected()){
            notte="2";
        }else if(gr3.isSelected()){
            notte="3";
        }else if(gr4.isSelected()){
            notte="4";
        }else if(gr5.isSelected()){
            notte="5";
        }
           
           ServicesAvisCours ss = new ServicesAvisCours();
                   AvisCours chh = new AvisCours(Integer.parseInt(notte),1,NewFXMain.cc.getIdCours(),textComm.getText());

           ss.ajouter(chh);
           TrayNotification tray = new TrayNotification();
              AnimationType type = AnimationType.POPUP;
              tray.setAnimationType(type);
              tray.setTitle("Notification");
              tray.setMessage("Avis bien ajouté");
              tray.setNotificationType(NotificationType.SUCCESS);
              tray.showAndDismiss(Duration.millis(3000));
           
              textComm.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AcceuilUtilisateur.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
           
    }

    @FXML
    private void retour1(ActionEvent event) throws IOException {
           gr3.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AcceuilUtilisateur.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
          
        
    }
    
    
    
}
