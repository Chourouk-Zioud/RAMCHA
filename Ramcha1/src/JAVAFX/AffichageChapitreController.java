/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JAVAFX;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.services.ServicesChapitre;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AffichageChapitreController implements Initializable {

  ServicesChapitre cha = new ServicesChapitre ();
    @FXML
    private TableView<Chapitre> tab_aff1;
    @FXML
    private TableColumn<Chapitre, String> nom_chapitre;
    @FXML
    private TableColumn<Chapitre, String> langue;
    @FXML
    private TableColumn<Chapitre, String> type ;
    @FXML
    private javafx.scene.control.TextField recherche_chapitre;
    @FXML
    private javafx.scene.control.Button sup1;
    @FXML
    private Button add_chapitre;
    @FXML
    private Button modifcation_chapitre;
    @FXML
    private Button Acceuil_chapitre;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
     Chapitre ch = new Chapitre();
        ObservableList<Chapitre>  list  =  (ObservableList<Chapitre>) cha.getAll();
        nom_chapitre.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("nomChapitre"));
        langue.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("langueChapitre"));
        type.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("typeChapitre"));
                    
    
         System.out.println(list);
         tab_aff1.setItems(list);
         FilteredList<Chapitre> filteredData = new FilteredList<>(list, b -> true);
        
        // 2. Set the filter Predicate whenever the filter changes.
        recherche_chapitre.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cp-> {
                // If filter text is empty, display all persons.
                                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (cp.getNomChapitre().toLowerCase().contains(lowerCaseFilter) ) {
                    return true; // Filter matches first name.
                } else if (cp.getLangueChapitre().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches last name.
                }
                          else if (cp.getTypeChapitre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    }
                return false;
                             
      
                                
    });
        });
                SortedList<Chapitre> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        //       Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tab_aff1.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        tab_aff1.setItems(sortedData);
    }
 

    @FXML
    private void delete1(ActionEvent event) {
          int  ghof = tab_aff1.getSelectionModel().getSelectedItem().getIdChapitre();
               System.out.println(ghof);
              cha.supprimer(ghof);
              
                        ObservableList<Chapitre>  list  = (ObservableList<Chapitre>) cha.getAll();
        
     nom_chapitre.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("nomChapitre"));
        langue.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("langueChapitre"));
             type.setCellValueFactory(new PropertyValueFactory<Chapitre, String>("typeChapitre"));
         System.out.println(list);
         tab_aff1.setItems(list);
         
        
        
    }

    @FXML
    private void add_chapitres(ActionEvent event) throws IOException {
        recherche_chapitre.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterChapitre.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
        
    }

    @FXML
    private void modification_chapitres(ActionEvent event) throws IOException {
               NewFXMain.nam = tab_aff1.getSelectionModel().getSelectedItem();

        
        
              recherche_chapitre.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierChapitre.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }

    @FXML
    private void Acceuil_chapitres(ActionEvent event) throws IOException {
         modifcation_chapitre.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
}
