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
public class AjouterAvisController implements Initializable {

    @FXML
    private TextArea commentaire_avis;
    @FXML
    private TextField rate_avis;
    @FXML
    private Button enregistrer_avis;
    @FXML
    private Button annuler_avis;
    @FXML
    private Label ajout_rate_erreur;
    @FXML
    private Label ajout_commentaire_erreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ajout_rate_erreur.setVisible(false);
            ajout_commentaire_erreur.setVisible(false);
    }    

    @FXML
    private void enregistrer_aviss(ActionEvent event) throws IOException {
        if (commentaire_avis.getText().isEmpty()|| rate_avis.getText().isEmpty() 
                  ){
        ajout_rate_erreur.setVisible(true);
        ajout_commentaire_erreur.setVisible(true);
        
       
    }
     else {
           try{
           ServicesAvisCours ff11 = new ServicesAvisCours();
                   System.out.println(NewFXMain.vv);
        AvisCours chh = new AvisCours(Integer.parseInt(rate_avis.getText()),1,NewFXMain.cc.getIdCours(), commentaire_avis.getText());
       
   //AvisCours hh1= new AvisCours(1,6,11,NewFXMain.vv.getIdCour(),"aggfaaaaaaaaaaaaaaaaaa");
        ff11.ajouter(chh);

        
        
        commentaire_avis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    } catch(Exception e)
              {        ajout_rate_erreur.setVisible(true);
                   System.out.println(e);
              }}}

    @FXML
    private void annuler_aviss(ActionEvent event) throws IOException {
         commentaire_avis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }
    
}
