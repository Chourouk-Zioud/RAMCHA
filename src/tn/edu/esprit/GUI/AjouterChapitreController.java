/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

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
public class AjouterChapitreController implements Initializable {

    @FXML
    private TextField nom_chapitre;
    @FXML
    private ComboBox<String> langue_chapitre;
     ObservableList<String> list_langue = FXCollections.observableArrayList(" Arabe","Francais","Anglais");
    @FXML
    private ComboBox<String> type_chapitre;
    ObservableList<String> list_type = FXCollections.observableArrayList("PDF","videos");
    @FXML
    private Button enregistre_chapitre;
    @FXML
    private Button annuler_chapitre;
    @FXML
    private Label ajout_nom_erreur;
    @FXML
    private Label ajout_langue_erreur;
    @FXML
    private Label ajout_type_erreur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            langue_chapitre.setItems(list_langue);
            type_chapitre.setItems(list_type);
             ajout_nom_erreur.setVisible(false);
            ajout_langue_erreur.setVisible(false);
            ajout_type_erreur.setVisible(false);
         
    }    
      ObservableList<Chapitre> listeChapitre = FXCollections.observableArrayList();

    @FXML
    private void enregistre_chapitres(ActionEvent event) throws IOException {
        int x = 0;
         ServicesChapitre ffs = new ServicesChapitre();
         if (nom_chapitre.getText().isEmpty()|| langue_chapitre.getValue().isEmpty() ||
                 type_chapitre.getValue().isEmpty() ){
        ajout_nom_erreur.setVisible(true);
        ajout_langue_erreur.setVisible(true);
        ajout_type_erreur.setVisible(true);
           x =1;
        }
       if (ffs.testNom(nom_chapitre.getText()) == 1)
       {
           ajout_nom_erreur.setVisible(true);
           ajout_nom_erreur.setText("NomDejaExist");
           x =1;
       }
     if (ffs.testMn(nom_chapitre.getText()) == 1)
       {
           ajout_nom_erreur.setVisible(true);
           ajout_nom_erreur.setText("Nom Non acceptable");
           x =1;
       }
     else {
           try{
        
        Chapitre cous = new Chapitre(nom_chapitre.getText(),langue_chapitre.getValue(),type_chapitre.getValue());
        System.out.println(cous);
        if(x == 0){
        ffs.ajouter(cous);

        
        
        type_chapitre.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageChapitre.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }
        
    }catch(Exception e)
              {        ajout_nom_erreur.setVisible(true);
                 System.out.println(e);
              }}}

    @FXML
    private void annuler_chapitres(ActionEvent event) throws IOException {
        type_chapitre.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageChapitre.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }
    
}
