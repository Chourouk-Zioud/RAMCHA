/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.services.ServiceUtilisateur;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import static tn.edu.esprit.GUI.NewFXMainClass.su;
import tn.edu.esprit.entities.Utilisateur;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class ModifieruController implements Initializable {

    ServiceUtilisateur ss = new ServiceUtilisateur();
    
    @FXML
    private TextField nommo;
    @FXML
    private TextField prenommo;
    
    @FXML
    private TextField codmo;
    @FXML
    private TextField nummo;
    @FXML
    private Button anulmo;
    @FXML
    private Button mod;

    @FXML
    private DatePicker ddnmo;

    Utilisateur u = new Utilisateur();
    @FXML
    private TextField adrmo;
    @FXML
    private TextField cinmo;
    @FXML
    private ImageView img;
    
    
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cinmo.setText(NewFXMainClass.us.getCinUser());
        nommo.setText(NewFXMainClass.us.getNomUser());
        prenommo.setText(NewFXMainClass.us.getPrenomUser());
        ddnmo.setValue(NewFXMainClass.us.getDdnUser().toLocalDate());
        adrmo.setText(NewFXMainClass.us.getAdressUser());
        codmo.setText("" + NewFXMainClass.us.getCodePostalUser());
        nummo.setText(NewFXMainClass.us.getNumUser());
        try{
        Image im = new Image(NewFXMainClass.us.getImage());
        img.setImage(im);
        }catch(Exception ex){
            
        }
       
       
    }

    @FXML
    private void annulerm(ActionEvent event) throws IOException {
        anulmo.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void modiferm(ActionEvent event) throws IOException {

        Utilisateur y = new Utilisateur();

        LocalDate date50 = java.time.LocalDate.now();
        
        boolean isNumeric = cinmo.getText().matches("[+-]?\\d*(\\.\\d+)?");
        boolean codet = codmo.getText().matches("[+-]?\\d*(\\.\\d+)?");
        boolean numt = nummo.getText().matches("[+-]?\\d*(\\.\\d+)?");
        java.sql.Date date1 = null;
        LocalDate date2 = null;

        try {
            date1 = new java.sql.Date(ddnmo.getValue().getYear() - 1900, ddnmo.getValue().getMonthValue() - 1, ddnmo.getValue().getDayOfMonth());
            date2 = date1.toLocalDate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.print(date2);
        long diff = ChronoUnit.YEARS.between(date2, date50);
        
        
        if (!isNumeric) {
            Alert alert = new Alert (AlertType.WARNING, "Verifiez votre CIN !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }
        else if (cinmo.getText().length()<8 || cinmo.getText().length()>8){
                Alert alert = new Alert (AlertType.WARNING, "Verifiez votre CIN !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
               
        } 
         else if (nummo.getText().length()<8 || nummo.getText().length()>8){
                Alert alert = new Alert (AlertType.WARNING, "Verifiez votre CIN !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }
        else if (codmo.getText().length()<4 || codmo.getText().length()>4){
                Alert alert = new Alert (AlertType.WARNING, "Verifiez votre CIN !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }
        
        else if (!codet) {
            Alert alert = new Alert (AlertType.WARNING, "Verifiez votre code Postal !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            
           
        } else if (!numt) {
            Alert alert = new Alert (AlertType.WARNING, "Verifiez votre numéro de téléphone !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            
            
        } else if (diff<12) {
            Alert alert = new Alert (AlertType.WARNING, "Verifiez votre date de naissnance !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }else if(su.testNum(nommo.getText())==1 || su.testNum(prenommo.getText())==1){
            Alert alert = new Alert (AlertType.WARNING, "Verifier votre nom et prenom !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
       

        
            

        } else {

            y.setIdUser(NewFXMainClass.us.getIdUser());
            y.setNomUser(nommo.getText());
            y.setPrenomUser(prenommo.getText());
            y.setCinUser(cinmo.getText());
            y.setDdnUser(date1);
            y.setAdressUser(adrmo.getText());
            y.setCodePostalUser(Integer.parseInt(codmo.getText()));
            y.setNumUser(nummo.getText());
            
            System.out.println(y.getDdnUser());
            ss.modifierSpw(y);
            
           
            
            Alert alert = new Alert(AlertType.CONFIRMATION, "Utilisateur modifé avec succés !", javafx.scene.control.ButtonType.OK);
            alert.showAndWait();

            nommo.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        }
    }
   

}
