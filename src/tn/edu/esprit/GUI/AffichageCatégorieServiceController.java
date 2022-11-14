/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import static java.util.Collections.list;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.services.CruCat;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class AffichageCatégorieServiceController implements Initializable {
 CruCat cccat = new CruCat();
    @FXML
    private TableView<CategorieService> table_cat;
    @FXML
    private TableColumn<CategorieService ,String> nom_categorie;
    @FXML
    private TableColumn<CategorieService, String> desc_cat;
    @FXML
    private Button supp_cate;
    @FXML
    private TextField rech_cat;
    @FXML
    private Button gotoajoucateg;
    @FXML
    private Button mod;
    @FXML
    private Button Serll;
    @FXML
    private VBox chosenServiceCard;
    @FXML
    private Label nomappLable;
    @FXML
    private ImageView omg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieService  kk = new CategorieService() ;
        ObservableList<CategorieService>  list  = (ObservableList<CategorieService>) cccat.getAll();
        nom_categorie.setCellValueFactory(new PropertyValueFactory<CategorieService, String>("nomCategorieService"));
        desc_cat.setCellValueFactory(new PropertyValueFactory<CategorieService, String>("descriptionCategorieService"));
        System.out.println(list);
         table_cat.setItems(list);
          FilteredList<CategorieService> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rech_cat.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(mm -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (mm.getNomCategorieService().toLowerCase().contains(lowerCaseFilter) ) {
					return true; // Filter matches first name.
				} else if (mm.getDescriptionCategorieService().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
                                return false;
                           // Does not match.
                                
	});
		});
                SortedList<CategorieService> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table_cat.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table_cat.setItems(sortedData);
    }    
    
    

    @FXML
    private void supprimer_cat(ActionEvent event) {
        int  ww = table_cat.getSelectionModel().getSelectedItem().getIdCategorieService();
               
              cccat.supprimer(ww);
              
         ObservableList<CategorieService>  list  = (ObservableList<CategorieService>) cccat.getAll();
        nom_categorie.setCellValueFactory(new PropertyValueFactory<CategorieService, String>("nomCategorieService"));
       desc_cat.setCellValueFactory(new PropertyValueFactory<CategorieService, String>("descriptionCategorieService"));
             
         System.out.println(list);
         table_cat.setItems(list);
    }

    @FXML
    private void gotocat(ActionEvent event) throws IOException {
                rech_cat.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterCatégorie.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void GotomodCat(ActionEvent event) throws IOException {
         NewFXMainClass.modcat = table_cat.getSelectionModel().getSelectedItem();

              rech_cat.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierCategorieService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void goToserv(ActionEvent event) throws IOException {
               rech_cat.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AfficherService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
         
    
    
}
