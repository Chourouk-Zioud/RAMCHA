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
import java.sql.Connection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.activation.DataSource;
import org.mindrot.jbcrypt.BCrypt;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.tools.DataS;
import nl.captcha.Captcha;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class InscrireController implements Initializable {

    @FXML
    private AnchorPane pane_inscr;

    @FXML
    private TextField txt_cin;

    @FXML
    private TextField txt_nom;

    @FXML
    private TextField txt_prenom;

    @FXML
    private DatePicker daten;

    @FXML
    private TextField txt_adresse;

    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_num;

    @FXML
    private TextField txt_email;

    @FXML
    private Button btn_inscri;
    @FXML
    private Button as;
    @FXML
    private PasswordField txt_mdp;
    @FXML
    private ImageView cap;
    @FXML
    private TextField code;
    @FXML
    private Label label1;
    @FXML
    private Button rest;
    @FXML
    private TextField image;
    @FXML
    private Button up;
    @FXML
    private ImageView im;
    

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        captcha = setCaptcha();
        
         
    }

    public Captcha setCaptcha() {
        Captcha captcha = new Captcha.Builder(250, 200)
                .addText()
                .addBackground()
                .addNoise()
                .gimp()
                .addBorder()
                .build();

        System.out.println(captcha.getImage());
        Image image = SwingFXUtils.toFXImage(captcha.getImage(), null);

        cap.setImage(image);

        return captcha;
    }
    Captcha captcha;

    @FXML
    private void inscr(ActionEvent event) {
        ServiceUtilisateur su = new ServiceUtilisateur();
        LocalDate date50 = java.time.LocalDate.now();

        boolean isNumeric = txt_cin.getText().matches("[+-]?\\d*(\\.\\d+)?");
        boolean codet = txt_code.getText().matches("[+-]?\\d*(\\.\\d+)?");
        boolean numt = txt_num.getText().matches("[+-]?\\d*(\\.\\d+)?");
        java.sql.Date date1 = null;
        LocalDate date2 = null;
        
        try {
            date1 = new java.sql.Date(daten.getValue().getYear() - 1900, daten.getValue().getMonthValue() - 1, daten.getValue().getDayOfMonth());
            date2 = date1.toLocalDate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        long diff = ChronoUnit.YEARS.between(date2, date50);

        if (txt_nom.getText().equals("") || txt_prenom.getText().equals("") || txt_adresse.getText().equals("") || txt_code.getText().equals("") || txt_num.getText().equals("") || txt_email.getText().equals("") || txt_mdp.getText().equals("")) {
            Alert alert = new Alert (AlertType.WARNING, "Remplissez tous les champs !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();

        } else if (!isNumeric) {
            Alert alert = new Alert (AlertType.WARNING, "Entrez un numéro de cin valide !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            
            } else if (!codet) {
                Alert alert = new Alert (AlertType.WARNING, "Verifiez votre code Postal !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
          
            } else if (!numt) {
                Alert alert = new Alert (AlertType.WARNING, "Verifiez votre numéro de téléphone !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
                
  
        }/* else if (txt_cin.getText().length()<8 || txt_cin.getText().length()>8){
                Alert alert = new Alert (AlertType.WARNING, "Verifiez votre CIN !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }*/
        else if (txt_num.getText().length()<8 || txt_num.getText().length()>8){
                Alert alert = new Alert (AlertType.WARNING, "Vérifier numéro du telephone !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }/*
        else if (code.getText().length()<4 || code.getText().length()>4){
                Alert alert = new Alert (AlertType.WARNING, "Verifiez le code postal !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }*/
            else if (diff<12) {
            Alert alert = new Alert (AlertType.WARNING, "Verifier votre date de naissnance !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        
        }else if(su.testNum(txt_prenom.getText())==1 || su.testNum(txt_nom.getText())==1){
            Alert alert = new Alert (AlertType.WARNING, "Verifier votre nom et prenom !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
       

        } else if (su.validerEmail(txt_email.getText())) {
             Alert alert = new Alert (AlertType.WARNING, "Verifier votre email !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            
           
        } else if (su.checkEmailExist(txt_email.getText())) {
             Alert alert = new Alert (AlertType.WARNING, "L'email exite déja !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            
        } else if (!captcha.isCorrect(code.getText())) {
            Alert alert = new Alert (AlertType.WARNING, "Captcha non valide !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
            
            
            captcha = setCaptcha();
            code.setText("");
        } else {
            if (captcha.isCorrect(code.getText())) {

                
                String mdp = txt_mdp.getText();
                mdp = BCrypt.hashpw(mdp, BCrypt.gensalt(13));
                mdp = mdp.replaceFirst("a", "y");
                Utilisateur u = new Utilisateur(txt_cin.getText(), txt_nom.getText(), txt_prenom.getText(), date1, txt_adresse.getText(), Integer.parseInt(txt_code.getText()), txt_num.getText(), txt_email.getText(), mdp, image.getText());
                Connection cnx = DataS.getInstance().getConnection();
                System.out.print(u);
                su.ajouter(u);
          Alert alert = new Alert (AlertType.CONFIRMATION, "Votre inscription est effectué avec succès !", javafx.scene.control.ButtonType.OK);
         alert.showAndWait();
                as.getScene().getWindow().hide();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    Stage mainStage = new Stage();
                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @FXML
    private void annuleri(ActionEvent event) {
        as.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void reinit(ActionEvent event) {
        captcha = setCaptcha();
        code.setText("");
    }

    @FXML
    private void uploadi(ActionEvent event) {
        Image img =new Image (image.getText());
        im.setImage(img);
    }
    


}
