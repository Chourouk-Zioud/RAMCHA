/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVAFX;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.services.ServicesCours;
import tn.edu.esprit.tools.DataBase;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouterCoursController implements Initializable {
    
    @FXML
    private TextField ajout_nom_cours;
    @FXML
    private TextField ajout_sujet_cours;
    @FXML
    private Button ajout_enregistrer_cours;
    @FXML
    private ComboBox<String> ajout_niveau_cours;
     ObservableList<String> list = FXCollections.observableArrayList(" Level 1","Level 2","Level 3","Level 4","Level 5");
   // observableList<String> list = FXCollections.observaleArrayList("");
    @FXML
    private ComboBox<String > ajout_categorie_cours;
   ObservableList<String> list1 = FXCollections.observableArrayList("Travaux manuelles","Marketing","Santé");
    @FXML
    private Button ajout_cours_annule1;
    @FXML
    private Label champ_nom_cours;
    @FXML
    private Label champ_nom_categorie;
    @FXML
    private Label champ_nom_niveau;
    @FXML
    private Label champ_sujet_cours;
  
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     // loadDataBase();
      
         ajout_niveau_cours.setItems(list);
            ajout_categorie_cours.setItems(list1);
            champ_nom_cours.setVisible(false);
            champ_nom_categorie.setVisible(false);
            champ_nom_niveau.setVisible(false);
            champ_sujet_cours.setVisible(false);

         
    }    
    ObservableList<Cours> listeCours = FXCollections.observableArrayList();

    @FXML
    private void enregistrer_cours(ActionEvent event) throws IOException {
        if (ajout_nom_cours.getText().isEmpty()|| ajout_sujet_cours.getText().isEmpty() ||
                 ajout_enregistrer_cours.getText().isEmpty() || ajout_niveau_cours.getValue().isEmpty() ){
        champ_nom_cours.setVisible(true);
        champ_nom_categorie.setVisible(true);
        champ_nom_niveau.setVisible(true);
        champ_sujet_cours.setVisible(true);
       
    }
     else {
           try{
        ServicesCours ff = new ServicesCours();
        Cours cou = new Cours(ajout_nom_cours.getText(),ajout_categorie_cours.getValue(),ajout_sujet_cours.getText(),ajout_niveau_cours.getValue());
        ff.ajouter(cou);

        
        
        ajout_nom_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }   catch(Exception e)
              {        champ_nom_cours.setVisible(true);
                   champ_nom_categorie.setVisible(true);
        champ_nom_niveau.setVisible(true);
        champ_sujet_cours.setVisible(true);
       
                 System.out.println(e);
              }}}

    @FXML
    private void choicecat(ActionEvent event) {
    }

    @FXML
    private void choiceniveau(ActionEvent event) {
    }

    @FXML
    private void ajout_cours_annulee(ActionEvent event) throws IOException {
             ajout_sujet_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
        
    

    
}  
