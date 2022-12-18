/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.services.CruSer;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class AfficherServiceController implements Initializable {
        CruSer ccs = new CruSer();
    @FXML
    private TableView<ServiceT> tableaux_services;
    @FXML
    private TableColumn<ServiceT, String> nom_ser;
    @FXML
    private TableColumn<ServiceT, Integer> nbr_ouv_ser;
    @FXML
    private TableColumn<ServiceT, Float> prix_ser;
    @FXML
    private TableColumn<ServiceT, String> desc_ser;
    @FXML
    private TableColumn<ServiceT, Date> date_deb_ser;
    @FXML
    private TableColumn<ServiceT, Date> Date_fin_ser;
    @FXML
    private TableColumn<ServiceT, String> Disponibilite_ser;
    @FXML
    private Button supp_bbt;
    @FXML
    private TextField rech_ser;
    @FXML
    private Button affbutt;
    @FXML
    private Button cattt;
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

        
        
          ObservableList<ServiceT>  list  = ccs.getAll();
        nom_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("nomService"));
        nbr_ouv_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Integer>("nbreOuvrier"));
             prix_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Float>("prixService"));
                     desc_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("descriptionService"));
    date_deb_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Date>("dateDebutService"));
    Date_fin_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Date>("dateFinService"));
    Disponibilite_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("disponibiliteService"));
         System.out.println(list);
         tableaux_services.setItems(list);
         NewFXMainClass.serrvicet = tableaux_services.getSelectionModel().getSelectedItem();
         System.out.print(NewFXMainClass.serrvicet);
         
         FilteredList<ServiceT> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		rech_ser.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(ser -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (ser.getNomService().toLowerCase().contains(lowerCaseFilter) ) {
					return true; // Filter matches first name.
				} else if (ser.getDescriptionService().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
                          else if (ser.getDisponibiliteService().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches last name.
				}
                             
                                else if (String.valueOf(ser.getNbreOuvrier()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                                
                                else if (String.valueOf(ser.getNbreOuvrier()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                                
                                else if (String.valueOf(ser.getDateFinService()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                               
				else return String.valueOf(ser.getDateDebutService()).contains(lowerCaseFilter); // Does not match.
                                
	});
		});
                SortedList<ServiceT> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableaux_services.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableaux_services.setItems(sortedData);
    }    

    @FXML
    private void supprimer_ser(ActionEvent event) {
               int  xx = tableaux_services.getSelectionModel().getSelectedItem().getIdService();
               
              ccs.supprimer(xx);
              
                        ObservableList<ServiceT>  list  = ccs.getAll();
        nom_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("nomService"));
        nbr_ouv_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Integer>("nbreOuvrier"));
             prix_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Float>("prixService"));
                     desc_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("descriptionService"));
    date_deb_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Date>("dateDebutService"));
    Date_fin_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, Date>("dateFinService"));
    Disponibilite_ser.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("disponibiliteService"));
         System.out.println(list);
         tableaux_services.setItems(list);
         
       
    }

    @FXML
    private void goToajoutPage(ActionEvent event) throws IOException {
               rech_ser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void goToModifierPage(ActionEvent event) throws IOException {
         NewFXMainClass.serrvicet = tableaux_services.getSelectionModel().getSelectedItem();
                        rech_ser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();

    }

    @FXML
    private void goTocategcr(ActionEvent event) throws IOException {
         rech_ser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCatégorieService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void retourrr(ActionEvent event) throws IOException {
        rech_ser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("dashbord.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
}
