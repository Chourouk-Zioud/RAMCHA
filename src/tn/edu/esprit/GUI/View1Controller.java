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
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.services.CruSer;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class View1Controller implements Initializable {

    @FXML
    private TableView<ServiceT> tableaux_services1;
    @FXML
    private TableColumn<ServiceT, String> nom_ser1;
    @FXML
    private TableColumn<ServiceT, Integer> nbr_ouv_ser1;
    @FXML
    private TableColumn<ServiceT, Float> prix_ser1;
    @FXML
    private TableColumn<ServiceT, String> desc_ser1;
    @FXML
    private TableColumn<ServiceT, Date> date_deb_ser1;
    @FXML
    private TableColumn<ServiceT, Date> Date_fin_ser1;
    @FXML
    private TableColumn<ServiceT, String> Disponibilite_ser1;
        CruSer ccs = new CruSer();
    @FXML
    private TextField searchrest1;
    @FXML
    private Button btSearch1;
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
        nom_ser1.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("nomService"));
        nbr_ouv_ser1.setCellValueFactory(new PropertyValueFactory<ServiceT, Integer>("nbreOuvrier"));
             prix_ser1.setCellValueFactory(new PropertyValueFactory<ServiceT, Float>("prixService"));
                     desc_ser1.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("descriptionService"));
    date_deb_ser1.setCellValueFactory(new PropertyValueFactory<ServiceT, Date>("dateDebutService"));
    Date_fin_ser1.setCellValueFactory(new PropertyValueFactory<ServiceT, Date>("dateFinService"));
    Disponibilite_ser1.setCellValueFactory(new PropertyValueFactory<ServiceT, String>("disponibiliteService"));
         System.out.println(list);
         tableaux_services1.setItems(list);
            FilteredList<ServiceT> filteredData = new FilteredList<>(list, b -> true);
		
            	// 2. Set the filter Predicate whenever the filter changes.
		searchrest1.textProperty().addListener((observable, oldValue, newValue) -> {
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
		sortedData.comparatorProperty().bind(tableaux_services1.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableaux_services1.setItems(sortedData);
                setCellValueFromTableTOTextField ();
        // TODO
    }    
    
     Stage stage = new Stage();
        private void setCellValueFromTableTOTextField () {

    tableaux_services1.setOnMousePressed (new EventHandler<MouseEvent> (){
        @Override
        public void handle (MouseEvent e) {
            ServiceT selectedForEdit = tableaux_services1.getSelectionModel().getSelectedItem();
             if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
            Stage home=new Stage ();
              try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("elib3deha.fxml"));
            Parent parent = loader.load();

            Elib3dehaController controller = (Elib3dehaController) loader.getController();
           controller.inflateUI(selectedForEdit);
                               nomappLable.getScene().getWindow().hide();;


            Stage stage = new Stage();
           
            stage.setScene(new Scene(parent));
            stage.show();
           /// search();

           
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }                  
      }
         
   
   

        }
        });
       
}

    @FXML
    private void searchact2(KeyEvent event) {
    }

    @FXML
    private void btnsearch(ActionEvent event) {
    }
}
