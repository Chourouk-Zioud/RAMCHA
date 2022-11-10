/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.services.ServicesAvisCours;
import tn.edu.esprit.services.ServicesCours;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AffichageAvisController implements Initializable {
ServicesAvisCours avc = new ServicesAvisCours();
    @FXML
    private TextField recherche_Avis;
    private TableColumn<AvisCours, Integer> nom_avis_cours;
    @FXML
    private TableColumn<AvisCours, Integer> rate;
    @FXML
    private TableColumn<AvisCours, String> commentaire;
    @FXML
    private Button sup2;
    @FXML
    private TableView<AvisCours> tab_aff2;
    @FXML
    private Button aviss;
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
    private TableColumn<Cours, String> niveau1;
    @FXML
    private Button ajout_avis;
    @FXML
    private Button modifier_avis;
    @FXML
    private Button acceuil_avis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Cours css = new Cours();
             ServicesCours sc = new ServicesCours();

        ObservableList<Cours>  list1  =  sc.getAll();
        nom_cours.setCellValueFactory(new PropertyValueFactory<Cours, String>("nomCours"));
        categorie.setCellValueFactory(new PropertyValueFactory<Cours, String>("categoriesCours"));
             sujet.setCellValueFactory(new PropertyValueFactory<Cours, String>("sujetCours"));
                     niveau.setCellValueFactory(new PropertyValueFactory<Cours, String>("niveauCours"));
    
         System.out.println(list1);
         tab_aff.setItems(list1);
//        ServicesCours op=new ServicesCours();
//         AvisCours av = new AvisCours();
//        ObservableList<AvisCours>  list  =  (ObservableList<AvisCours>) avc.getAll();
//      // Cours dd= op
//        nom_avis_cours.setCellValueFactory(new PropertyValueFactory<AvisCours, Integer>("idCour"));
//        rate.setCellValueFactory(new PropertyValueFactory<AvisCours, Integer>("rate"));
//         commentaire.setCellValueFactory(new PropertyValueFactory<AvisCours, String>("commentaire"));
//         
//    
//         System.out.println(list);
//       
//         tab_aff2.setItems(list);
//        
//        // 2. Set the filter Predicate whenever the filter changes.
//             FilteredList<AvisCours> filteredData = new FilteredList<>(list, b -> true);
//		
//		// 2. Set the filter Predicate whenever the filter changes.
//		recherche_Avis.textProperty().addListener((observable, oldValue, newValue) -> {
//			filteredData.setPredicate(a -> {
//				// If filter text is empty, display all persons.
//								
//				if (newValue == null || newValue.isEmpty()) {
//					return true;
//				}
//				
//				// Compare first name and last name of every person with filter text.
//				String lowerCaseFilter = newValue.toLowerCase();
//				
//				if (a.getCommentaire().toLowerCase().contains(lowerCaseFilter) ) {
//					return true; // Filter matches first name.
//                                }
//				
//				else return String.valueOf(a.getRate()).contains(lowerCaseFilter); // Does not match.
//                                
//	});
//		});
//                SortedList<AvisCours> sortedData = new SortedList<>(filteredData);
//		
//		// 4. Bind the SortedList comparator to the TableView comparator.
//		// 	  Otherwise, sorting the TableView would have no effect.
//		sortedData.comparatorProperty().bind(tab_aff2.comparatorProperty());
//		
//		// 5. Add sorted (and filtered) data to the table.
//		tab_aff2.setItems(sortedData);
//        
    }    

    @FXML
    private void delete2(ActionEvent event) throws IOException {
                       int  ghof = tab_aff2.getSelectionModel().getSelectedItem(). getIdAvisCours();
               
              avc.supprimer(ghof);
              
                   ServicesCours op=new ServicesCours();
         AvisCours av = new AvisCours();
        ObservableList<AvisCours>  list  =  (ObservableList<AvisCours>) avc.getAll();
      // Cours dd= op
     
        rate.setCellValueFactory(new PropertyValueFactory<AvisCours, Integer>("rate"));
         commentaire.setCellValueFactory(new PropertyValueFactory<AvisCours, String>("commentaire"));
         
    
         System.out.println(list);
       
         tab_aff2.setItems(list);
         
         
    }  

    @FXML
    private void getCourAvis(ActionEvent event) {
                               int  ghof = tab_aff.getSelectionModel().getSelectedItem(). getIdCours();
                            
                               
                                 ObservableList<AvisCours>  list  =  (ObservableList<AvisCours>) avc.getAll(ghof);
      // Cours dd= op
  
        rate.setCellValueFactory(new PropertyValueFactory<AvisCours, Integer>("rate"));
         commentaire.setCellValueFactory(new PropertyValueFactory<AvisCours, String>("commentaire"));
         
    
         System.out.println(list);
       
         tab_aff2.setItems(list);
        
        // 2. Set the filter Predicate whenever the filter changes.
             FilteredList<AvisCours> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		recherche_Avis.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(a -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (a.getCommentaire().toLowerCase().contains(lowerCaseFilter) ) {
					return true; // Filter matches first name.
                                }
				
				else return String.valueOf(a.getRate()).contains(lowerCaseFilter); // Does not match.
                                
	});
		});
                SortedList<AvisCours> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tab_aff2.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tab_aff2.setItems(sortedData);
        

        
    }

    @FXML
    private void ajout_aviss(ActionEvent event) throws IOException {
                             NewFXMain.cc = tab_aff.getSelectionModel().getSelectedItem();

         recherche_Avis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void modifier_aviss(ActionEvent event) throws IOException {
        
        
              recherche_Avis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void acceuil_aviss(ActionEvent event) throws IOException {
         recherche_Avis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("Acceuil1.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
    }
        
        
    
    

