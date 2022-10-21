/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramchaa.GUI;

import java.io.IOException;
import java.net.URL;

import java.time.LocalDate;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.ramcha.esprit.entities.Utilisateur;
import tn.ramcha.esprit.services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class ModifieruController implements Initializable {

    @FXML
    private TextField cinmo;
    @FXML
    private TextField nommo;
    @FXML
    private TextField prenommo;
    @FXML
    private TextField addmo;
    @FXML
    private TextField codmo;
    @FXML
    private TextField nummo;
    @FXML
    private TextField mpmo;
    @FXML
    private Button anulmo;
    @FXML
    private Button mod;
    @FXML
    private TextField adrmo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void init(Utilisateur u) {
      /*  cinmo.setText(u.getCinUser());
        nommo.setText(u.getNomUser());
        prenommo.setText(u.getPrenomUser());  
        adrmo.setText(u.getAdressUser());
        String a = Integer.toString(u.getCodePostalUser());
        codmo.setText(a);
        nummo.setText(u.getNumUser());
        addmo.setText(u.getLoginUser());
        mpmo.setText(u.getNumUser());
        
       */
    }

    @FXML
    private void annulerm(ActionEvent event) {
    }

    @FXML
    private void modiferm(ActionEvent event) throws IOException {
        /*ServiceUtilisateur su = new ServiceUtilisateur();
        Utilisateur u = new Utilisateur(cinmo.getText(),nommo.getText(),prenommo.getText(),adrmo.getText(),Integer.parseInt(codmo.getText()),nummo.getText(),addmo.getText(),mpmo.getText());
        su.modifierSd(u);
        
                Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
    */
    }
}
