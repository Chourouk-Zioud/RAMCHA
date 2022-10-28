/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramchaa.GUI;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.ramcha.esprit.entities.Utilisateur;
import tn.ramcha.esprit.services.ServiceUtilisateur;


/**
 * FXML Controller class
 *
 * @author chayma
 */
public class LoginController implements Initializable {
    
    @FXML
    private AnchorPane pane_login;

    @FXML
    private Button btn_insc;

    @FXML
    private TextField txt_usern;

    @FXML
    private PasswordField txt_usermp;

    @FXML
    private Button btn_login;
    
    @FXML
    private Label wronglog;

    @FXML
    private Label wrongLog;
    
     
      
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

      Connection cnx;

 

    @FXML
    private void inscrire(ActionEvent event) throws IOException {
        
              btn_insc.getScene().getWindow().hide();
              try{
              Parent root = FXMLLoader.load(getClass().getResource("inscrire.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
              } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void checkLogin(ActionEvent event)  {
        
           String loginUser = txt_usern.getText();
          String passwUser = txt_usermp.getText();
          
          ServiceUtilisateur service = new ServiceUtilisateur();
          
          boolean t=service.validerLog(loginUser, passwUser);
          
          if(t == false){
              Alert alert = new Alert(AlertType.INFORMATION);

             alert.setTitle("Information Dialog");

              alert.setHeaderText(null);

              alert.setContentText("Verifier vos coordonnées ");

               alert.show();
          }else{
              btn_login.getScene().getWindow().hide();
              try{
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
              } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
          }
    
    
    }
    
    

}
