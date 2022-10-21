/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVAFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.services.ServicesCours;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierCoursController implements Initializable {

    @FXML
    private TextField modif_nom_cours;
    @FXML
    private TextField modif_sujet_cours;
    @FXML
    private Button modif_enregistrer_cours;
    @FXML
    private ComboBox<String> modif_categorie_cours;
    @FXML
    private ComboBox<String> modif_niveau_cours;
     ObservableList<String> list1 = FXCollections.observableArrayList("Travaux manuelles","Marketing","Santé");
    ObservableList<String> list = FXCollections.observableArrayList(" Level 1","Level 2","Level 3","Level 4","Level 5");
    @FXML
    private Button modif_cours_annule;
    @FXML
    private Label modifier_nom_erreur;
    @FXML
    private Label modifier_categorie_erreur;
    @FXML
    private Label modifier_sujet_erreur;
    @FXML
    private Label modifier_niveau_erreur;
   // observableList<String> list = FXCollections.observaleArrayList("");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             modif_niveau_cours.setItems(list);
            modif_categorie_cours.setItems(list1);
            
            modif_nom_cours.setText(NewFXMain.cc.getNomCours());
            modif_sujet_cours.setText(NewFXMain.cc.getSujetCours());
            modif_categorie_cours.setValue(NewFXMain.cc.getCategoriesCours());
            modif_niveau_cours.setValue(NewFXMain.cc.getNiveauCours());
            
            modifier_nom_erreur.setVisible(false);
            modifier_categorie_erreur.setVisible(false);
            modifier_sujet_erreur.setVisible(false);
            modifier_niveau_erreur.setVisible(false);
    }    

    @FXML
    private void enregistrer_modif_cours(ActionEvent event) throws IOException {
         if (modif_nom_cours.getText().isEmpty()|| modif_sujet_cours.getText().isEmpty() ||
                 modif_categorie_cours.getValue().isEmpty() || modif_niveau_cours.getValue().isEmpty() ){
        modifier_nom_erreur.setVisible(true);
        modifier_categorie_erreur.setVisible(true);
        modifier_sujet_erreur.setVisible(true);
        modifier_niveau_erreur.setVisible(true);
       
    }
     else {
           try{
            ServicesCours ff = new ServicesCours();
        Cours cou = new Cours(NewFXMain.cc.getIdCours(),modif_nom_cours.getText(),modif_categorie_cours.getValue(),modif_sujet_cours.getText(),modif_niveau_cours.getValue());
        ff.modifier(cou);
        
            
        modif_sujet_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }catch(Exception e)
              {        modifier_nom_erreur.setVisible(true);
                      
  System.out.println(e);
              }}}

    @FXML
    private void choicecat(ActionEvent event) {
    }

    @FXML
    private void choiceniveau(ActionEvent event) {
    }

    @FXML
    private void modif_cours_annulee(ActionEvent event) throws IOException {
          modif_nom_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
    
}
