/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Magasin;
import tn.edu.esprit.services.ServiceMagasin;
import tn.edu.esprit.tools.DataS;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author Chourouk Zioud
 */
public class AjouterMagasinController implements Initializable {
    Connection cnx = DataS.getInstance().getConnection();
    ServiceMagasin sm = new ServiceMagasin(cnx);
    
    @FXML
    private TextField NomMagasin;
    @FXML
    private TextField EmailMagasin;
    @FXML
    private TextField Adressemagasin;
    @FXML
    private TextField TelephoneMagasin;
    @FXML
    private Label ErrNom;
    @FXML
    private Label ErrEmail;
    @FXML
    private Label ErrTel;
    @FXML
    private Label ErrAdre;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        InsializeLabel ();
        userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());
    }    

    @FXML
    private void Enregistremagasin(ActionEvent event) throws IOException {
        InsializeLabel ();
        int x = 0;
        ServiceUtilisateur su = new ServiceUtilisateur();
        boolean numt = TelephoneMagasin.getText().matches("[+-]?\\d*(\\.\\d+)?");
        
        if (NomMagasin.getText().equals("")){
        ErrNom.setVisible(true);
        ErrNom.setText("ChampObligatoire");
        x=1;
        }
          if (sm.testNom(NomMagasin.getText())==1){
        ErrNom.setVisible(true);
        ErrNom.setText("Nom deja exist");
        x=1;
        }
          
          
        if (EmailMagasin.getText().equals("")){
        ErrEmail.setVisible(true);
        ErrEmail.setText("ChampObligatoire");
        x=1;
        }else if (su.validerEmail(EmailMagasin.getText())) {
             Alert alert = new Alert (Alert.AlertType.WARNING, "Verifier votre email !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        x=1;  
        }
        
        
        
        if (Adressemagasin.getText().equals("")){
        ErrAdre.setVisible(true);
        ErrAdre.setText("ChampObligatoire");
        x=1;
        }
        
        
        
        if (TelephoneMagasin.getText().equals("")){
        ErrTel.setVisible(true);
        ErrTel.setText("Champ Obligatoire");
        x=1;
        }else if (!numt) {
                Alert alert = new Alert (Alert.AlertType.WARNING, "Verifiez votre numéro de téléphone !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        x=1;
        }else if (TelephoneMagasin.getText().length()<8 || TelephoneMagasin.getText().length()>8){
                Alert alert = new Alert (Alert.AlertType.WARNING, "Vérifier numéro du telephone !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        x=1;
        }
        
        
        
        
        
        
        if (x == 0)
        {
        Magasin m = new Magasin(NomMagasin.getText(), Adressemagasin.getText(), EmailMagasin.getText(), TelephoneMagasin.getText());
        sm.ajouter(m);
         NomMagasin.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("GestionMagasin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }
    }

    @FXML
    private void retourAjout(ActionEvent event) throws IOException {
            NomMagasin.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("GestionMagasin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
    
    public void InsializeLabel (){
            ErrNom.setVisible(false);
            ErrEmail.setVisible(false);
            ErrTel.setVisible(false);
            ErrAdre.setVisible(false);
    }
    
}
