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
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.services.ServicesChapitre;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierChapitreController implements Initializable {
    
 ServicesChapitre ff1 = new ServicesChapitre();
    @FXML
    private TextField nom_chapitre_modifier;
    @FXML
    private ComboBox<String> langue_chapitre_modifier;
    @FXML
    private ComboBox<String> type_chapitre_modifier;
    @FXML
    private Button enregistre_chapitre_modifier;
    @FXML
    private Button annuler_chapitre_modifier;
ObservableList<String> list_type = FXCollections.observableArrayList("PDF","videos");
    ObservableList<String> list_langue = FXCollections.observableArrayList(" Arabe","Francais","Anglais");
    @FXML
    private Label modifier_nom_erreur;
    @FXML
    private Label modifier_langue_erreur;
    @FXML
    private Label modifier_type_erreur;
   // observableList<String> list = FXCollections.observaleArrayList("");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             type_chapitre_modifier.setItems(list_type);
            langue_chapitre_modifier.setItems(list_langue);
            
            nom_chapitre_modifier.setText(NewFXMain.nam.getNomChapitre());
            langue_chapitre_modifier.setValue(NewFXMain.nam.getLangueChapitre());
            type_chapitre_modifier.setValue(NewFXMain.nam.getTypeChapitre());
         modifier_nom_erreur.setVisible(false);
            modifier_langue_erreur.setVisible(false);
            modifier_type_erreur.setVisible(false);
        
        // TODO
    }    


    @FXML
    private void enregistre_chapitres_modifier(ActionEvent event) throws IOException {
        
        if (nom_chapitre_modifier.getText().isEmpty()|| langue_chapitre_modifier.getValue().isEmpty() ||
                 type_chapitre_modifier.getValue().isEmpty()  ){
        modifier_nom_erreur.setVisible(true);
        modifier_langue_erreur.setVisible(true);
        modifier_type_erreur.setVisible(true);
       
    }
     else {
           try{
           ServicesChapitre ff1 = new ServicesChapitre();
        Chapitre cous = new Chapitre(NewFXMain.nam.getIdChapitre(),nom_chapitre_modifier.getText(),langue_chapitre_modifier.getValue(),type_chapitre_modifier.getValue());
        ff1.modifier(cous);
        type_chapitre_modifier.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageChapitre.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
              
    }catch(Exception e)
              {        modifier_nom_erreur.setVisible(true);
  System.out.println(e);
              }}}

    @FXML
    private void annuler_chapitres_modifier(ActionEvent event) throws IOException {
        
          type_chapitre_modifier.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageChapitre.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
        
    }
    
}
