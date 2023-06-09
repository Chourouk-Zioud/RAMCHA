/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Reponse;
import tn.edu.esprit.services.MailService;
import tn.edu.esprit.services.ServiceReclamation;
import tn.edu.esprit.services.ServiceReponse;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kais Chalghoumi
 */
public class StatusReclamationController implements Initializable {
   Connection cnx = DataS.getInstance().getConnection();
    ServiceReclamation sc = new ServiceReclamation(cnx);
    ServiceReponse sr = new ServiceReponse(cnx);
    MailService ms = new MailService();
    @FXML
    private Label nomPrenomrec;
    @FXML
    private ComboBox<String> selStatus;
    @FXML
    private Label errstatus;
    @FXML
    private Label errMessage;
  private String[] a = {"Tariteé", "En attente"};
    @FXML
    private Button confirmerRe;
    @FXML
    private TextArea mess;
    @FXML
    private Text userinfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       selStatus.getItems().setAll(a);
       nomPrenomrec.setText(MainKais.rec.getNom()+" "+MainKais.rec.getPrenom());
        init();
        userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());
    }    

    @FXML
    private void confirmerRe(ActionEvent event) throws IOException {
           init();
        
        int x = 0;
       if (mess.getText().equals("")){
              errMessage.setVisible(true);
              errMessage.setText("Champ Obligatoire");
        x=1;
        }
        if (selStatus.getValue() == null){
              errstatus.setVisible(true);
              errstatus.setText("Champ Obligatoire");
        x=1;
        }
        if(x == 0){
        sc.modifierStatus(MainKais.rec.getIdReclamation(), selStatus.getValue());
                   Reponse r = new Reponse(mess.getText(), selStatus.getValue(), MainKais.rec.getIdReclamation());
            sr.ajouter(r);
        ms.sendEmail(MainKais.rec.getEmail(), "Reclamation Traiteé", mess.getText());
               confirmerRe.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    }

    @FXML
    private void annulerrec(ActionEvent event) throws IOException {
           confirmerRe.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    void init(){
    errMessage.setVisible(false);
     errstatus.setVisible(false);
    }
}
