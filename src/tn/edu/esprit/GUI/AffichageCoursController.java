/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.services.ServicesChapitre;
import tn.edu.esprit.services.ServicesCours;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AffichageCoursController implements Initializable {

   
   ServicesCours sc = new ServicesCours();
    ServicesChapitre ch = new ServicesChapitre();
    @FXML
    private TableView<Cours> tab_aff;
    @FXML
    private TableColumn<Cours, String> nom_cours;
    @FXML
    private TableColumn<Cours, String> categorie;
    @FXML
    private TableColumn<Cours, String> sujet ;
    @FXML
    private TableColumn<Cours, String> niveau;
    @FXML
    private AnchorPane tableau;
    @FXML
    private javafx.scene.control.TextField recherche_cours;
    @FXML
    private javafx.scene.control.Button sup;
    @FXML
    private javafx.scene.control.Button ajoutbttn;
      @FXML
    private TableView<Chapitre> tab_aff1;
    @FXML
    private TableColumn<Chapitre, String> nom_chapitre;
    @FXML
    private TableColumn<Chapitre, String> langue;
    @FXML
    private TableColumn<Chapitre, String> type ;
    @FXML
    private ComboBox<Cours> afeectCour;
    @FXML
    private ComboBox<Chapitre> affectChap;
    @FXML
    private javafx.scene.control.Button aff;
    @FXML
    private javafx.scene.control.Button getCourchh;
    @FXML
    private javafx.scene.control.Button acceuil_cours;
    @FXML
    private javafx.scene.control.Button excz;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afeectCour.setItems(sc.getAll());
        affectChap.setItems(ch.getAll());
        
        Cours css = new Cours();
        ObservableList<Cours>  list  =  sc.getAll();
        nom_cours.setCellValueFactory(new PropertyValueFactory<Cours, String>("nomCours"));
        categorie.setCellValueFactory(new PropertyValueFactory<Cours, String>("categoriesCours"));
             sujet.setCellValueFactory(new PropertyValueFactory<Cours, String>("sujetCours"));
                     niveau.setCellValueFactory(new PropertyValueFactory<Cours, String>("niveauCours"));
    
         System.out.println(list);
         tab_aff.setItems(list);
         FilteredList<Cours> filteredData = new FilteredList<>(list, b -> true);
        
        // 2. Set the filter Predicate whenever the filter changes.
        recherche_cours.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cs -> {
                // If filter text is empty, display all persons.
                                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (cs.getNomCours().toLowerCase().contains(lowerCaseFilter) ) {
                    return true; // Filter matches first name.
                } else if (cs.getCategoriesCours().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches last name.
                }
                          else if (cs.getSujetCours().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    }
                     else if (cs.getNiveauCours().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    }
                return false;
                             
      
                                
    });
        });
                SortedList<Cours> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        //       Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tab_aff.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        tab_aff.setItems(sortedData);
    }
   @FXML
    private void deletes(ActionEvent event) {
               int  ghof = tab_aff.getSelectionModel().getSelectedItem(). getIdCours();
               
              sc.supprimer(ghof);
                        ObservableList<Cours>  list  = sc.getAll();
        
     nom_cours.setCellValueFactory(new PropertyValueFactory<Cours, String>("nomCours"));
        categorie.setCellValueFactory(new PropertyValueFactory<Cours, String>("categoriesCours"));
             sujet.setCellValueFactory(new PropertyValueFactory<Cours, String>("sujetCours"));
                     niveau.setCellValueFactory(new PropertyValueFactory<Cours, String>("niveauCours"));
         System.out.println(list);
         tab_aff.setItems(list);
                  FilteredList<Cours> filteredData = new FilteredList<>(list, b -> true);
        
        // 2. Set the filter Predicate whenever the filter changes.
        recherche_cours.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cs -> {
                // If filter text is empty, display all persons.
                                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (cs.getNomCours().toLowerCase().contains(lowerCaseFilter) ) {
                    return true; // Filter matches first name.
                } else if (cs.getCategoriesCours().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches last name.
                }
                          else if (cs.getSujetCours().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    }
                     else if (cs.getNiveauCours().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    }
                return false;
                             
      
                                
    });
        });
                SortedList<Cours> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        //       Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tab_aff.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        tab_aff.setItems(sortedData);
         
    }  

    @FXML
    private void GoToAjoutCour(ActionEvent event) throws IOException {
        
         recherche_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void GoTOModifCour(ActionEvent event) throws IOException {
                     NewFXMain.cc = tab_aff.getSelectionModel().getSelectedItem();

        
        
              recherche_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    private void goajout2(ActionEvent event) throws IOException {
    
         recherche_cours.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterCours.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    private void getCoursChap(ActionEvent event) {
        
           
    }

    @FXML
    private void affectercourchap(ActionEvent event) {
        sc.affecter_chapitreTocour(afeectCour.getValue().getIdCours(), affectChap.getValue().getIdChapitre());
        
    }

    @FXML
    private void getchapitrecour(ActionEvent event) {
            int  ghof = tab_aff.getSelectionModel().getSelectedItem(). getIdCours();
               
               
               ObservableList<Chapitre>  list  =  (ObservableList<Chapitre>) sc.getCourChapitres(ghof);
        nom_chapitre.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("nomChapitre"));
        langue.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("langueChapitre"));
        type.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("typeChapitre"));
     
         tab_aff1.setItems(list);
    }

    @FXML
    private void acceuil_courss(ActionEvent event) throws IOException {
         afeectCour.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("Acceuil1.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }

    @FXML
    private void importexcel(ActionEvent event) {
        
        sc.ImportExel();
    }

    @FXML
    private void ratecour(ActionEvent event) {
    }
}
    

