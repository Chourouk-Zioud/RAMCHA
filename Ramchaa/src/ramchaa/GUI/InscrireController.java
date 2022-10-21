/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramchaa.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.activation.DataSource;
import tn.ramcha.esprit.entities.Utilisateur;
import tn.ramcha.esprit.services.ServiceUtilisateur;
import tn.ramcha.esprit.tools.DataR;

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
    private TextField txt_mdp;


    @FXML
    private Button btn_inscri;
    @FXML
    private Button as;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void inscr(ActionEvent event) {
        
 
        java.sql.Date date1 = new java.sql.Date(daten.getValue().getYear() - 1900, daten.getValue().getMonthValue() - 1, daten.getValue().getDayOfMonth());
        Utilisateur u = new Utilisateur(txt_cin.getText(), txt_nom.getText(), txt_prenom.getText(),date1,txt_adresse.getText(),Integer.parseInt(txt_code.getText()),txt_num.getText(),txt_email.getText(),txt_mdp.getText());
        Connection cnx = DataR.getInstance().getConnection();
        ServiceUtilisateur su = new ServiceUtilisateur();
        su.ajouter(u);
               
                as.getScene().getWindow().hide();
                try {
                 Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
                } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void annuleri(ActionEvent event)  {
                 as.getScene().getWindow().hide();
                 try{
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
                 } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
  
    
    
    
}
