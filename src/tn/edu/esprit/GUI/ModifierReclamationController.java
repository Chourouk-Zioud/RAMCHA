/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.services.ServiceReclamation;
import tn.edu.esprit.tools.DataS;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author Kais Chalghoumi
 */
public class ModifierReclamationController implements Initializable {
  Connection cnx = DataS.getInstance().getConnection();
  ServiceReclamation sr = new ServiceReclamation(cnx);
    @FXML
    private TextField NomRec;
    @FXML
    private TextField prenomRec;
    @FXML
    private TextField EmailRec;
    @FXML
    private TextField TelRec;
    @FXML
    private TextArea DescRec;
    @FXML
    private ComboBox<String> ServicereclameSel;
    @FXML
    private Label ErrNom;
    @FXML
    private Label ErrPrenom;
    @FXML
    private Label ErrEmail;
    @FXML
    private Label ErrTel;
    @FXML
    private Label ErrDesc;
    @FXML
    private Label ErrService;
        private String[] a = {"Service Article", "Service de vente", "Service Comminication","Service Avis"};
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      init();
      NomRec.setText(MainKais.rec.getNom());
      prenomRec.setText(MainKais.rec.getPrenom());
      EmailRec.setText(MainKais.rec.getEmail());
      TelRec.setText(MainKais.rec.getNumero_mobile());
      DescRec.setText(MainKais.rec.getDescription());
      ServicereclameSel.setValue(MainKais.rec.getNomServcie());
      userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());
    }    

    @FXML
    private void retourReclamation(ActionEvent event) throws IOException {
               DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void saveREclamation(ActionEvent event) throws IOException {
           init();
        ServiceUtilisateur su = new ServiceUtilisateur();
        boolean isNumeric = EmailRec.getText().matches("[+-]?\\d*(\\.\\d+)?");
        boolean numt = TelRec.getText().matches("[+-]?\\d*(\\.\\d+)?");
        
        int x = 0;
       if (NomRec.getText().equals("")){
              ErrNom.setVisible(true);
              ErrNom.setText("Champ Obligatoire");
        x=1;
        }
        if (prenomRec.getText().equals("")){
              ErrPrenom.setVisible(true);
              ErrPrenom.setText("Champ Obligatoire");
        x=1;
        }
         if (EmailRec.getText().equals("")){
              ErrEmail.setVisible(true);
              ErrEmail.setText("Champ Obligatoire");
        x=1;
        }else if (su.validerEmail(EmailRec.getText())) {
             Alert alert = new Alert (Alert.AlertType.WARNING, "Verifier votre email !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        x=1;  
        }
         
           if (TelRec.getText().equals("")){
              ErrTel.setVisible(true);
              ErrTel.setText("Champ Obligatoire");
        x=1;
        }else if (!numt) {
                Alert alert = new Alert (Alert.AlertType.WARNING, "Verifiez votre numéro de téléphone !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        x=1;
        }else if (TelRec.getText().length()<8 || TelRec.getText().length()>8){
                Alert alert = new Alert (Alert.AlertType.WARNING, "Vérifier numéro du telephone !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        x=1;
        }
             if (DescRec.getText().equals("")){
              ErrDesc.setVisible(true);
              ErrDesc.setText("Champ Obligatoire");
        x=1;
        }
                   if (ServicereclameSel.getValue() == null){
              ErrService.setVisible(true);
              ErrService.setText("Selectinnée un service");
        x=1;
        }
                   
                   
                   if (x == 0 )
                   {
               LocalDateTime now = LocalDateTime.now(); 
              Date d2 = new Date(1999, 1, 1);
              Date d1 = new Date(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
              Reclamation r = new Reclamation(MainKais.rec.getIdReclamation(),NomRec.getText(), prenomRec.getText(), EmailRec.getText(), "screenshoot", TelRec.getText(), d1, d2, DescRec.getText(), "Non traiter", ServicereclameSel.getValue());
              sr.modifier(r);
              DescRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                   }
    }
    
        public void init(){
            ErrNom.setVisible(false);
            ErrPrenom.setVisible(false);
            ErrEmail.setVisible(false);
            ErrTel.setVisible(false);
            ErrDesc.setVisible(false);
            ErrService.setVisible(false);
    }
    
}
