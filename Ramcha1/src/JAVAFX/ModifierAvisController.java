/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVAFX;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.services.ServicesAvisCours;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierAvisController implements Initializable {

    @FXML
    private TextArea commentaire_avis;
    @FXML
    private TextField modifier_rate_avis;
    @FXML
    private Button modifier_enregistrer_avis;
    @FXML
    private Button modifier_annuler_avis;
    @FXML
    private Label modif_rate_erreur;
    @FXML
    private Label modif_commentaire_erreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        modif_rate_erreur.setVisible(false);
            modif_commentaire_erreur.setVisible(false);
    }    

    @FXML
    private void modifier_enregistrer_aviss(ActionEvent event) throws IOException {
        if (commentaire_avis.getText().isEmpty()|| modifier_rate_avis.getText().isEmpty() ){
        modif_rate_erreur.setVisible(true);
        modif_commentaire_erreur.setVisible(true);
       
    }
     else {
           try{
           ServicesAvisCours vv1 = new ServicesAvisCours();
        AvisCours acous = new AvisCours(NewFXMain.vv.getIdAvisCours(), Integer.parseInt(modifier_rate_avis.getText()),commentaire_avis.getText());
        vv1.modifier(acous);
        commentaire_avis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }catch(Exception e)
              {        modif_rate_erreur.setVisible(true);
                 // modif_commentaire_erreur.setVisible(true);
              
  System.out.println(e);
              }}}

    @FXML
    private void modifier_annuler_aviss(ActionEvent event) throws IOException {
          modifier_rate_avis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageAvise.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
    
}
