/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Magasin;
import tn.edu.esprit.services.ServiceMagasin;
import tn.edu.esprit.tools.DataS;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chourouk Zioud
 */
public class GestionMagasinController implements Initializable {
    Connection cnx = DataS.getInstance().getConnection();
    ServiceMagasin sm = new ServiceMagasin(cnx);
    
    
    @FXML
    private TableView<Magasin> TabMagasin;
    @FXML
    private TableColumn<Magasin, String> nommtab;
    @FXML
    private TableColumn<Magasin, String> AdressMtab;
    @FXML
    private TableColumn<Magasin, String> EmailMTab;
    @FXML
    private TableColumn<Magasin, String> TelMTab;
    @FXML
    private TextField searchmagasin;
    @FXML
    private Button getPdf;
    @FXML
    private Label selMagErr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AfficherMagasin();
    }    
    void AfficherMagasin (){
            ObservableList<Magasin>  list  = sm.getAll();
        //IdmTab.setCellValueFactory(new PropertyValueFactory<Magasin, Integer>("idMagasin"));
        nommtab.setCellValueFactory(new PropertyValueFactory<Magasin, String>("nomMagasin"));
        AdressMtab.setCellValueFactory(new PropertyValueFactory<Magasin, String>("adresseMagasin"));
        EmailMTab.setCellValueFactory(new PropertyValueFactory<Magasin, String>("emailMagasin"));
        TelMTab.setCellValueFactory(new PropertyValueFactory<Magasin, String>("telMagasin"));
 
        TabMagasin.setItems(list);
        FilteredList<Magasin> filteredData = new FilteredList<>(list, b -> true);
		searchmagasin.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getNomMagasin().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                                else if (m.getAdresseMagasin().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getTelMagasin().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getEmailMagasin().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
				else return String.valueOf(m.getIdMagasin()).contains(lowerCaseFilter); // Does not match.           
	});
		});
                SortedList<Magasin> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(TabMagasin.comparatorProperty());
		
		TabMagasin.setItems(sortedData);
    
    }

    @FXML
    private void GoAjoutMagasin(ActionEvent event) throws IOException {
                 searchmagasin.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterMagasin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void SuppMagasinGo(ActionEvent event) throws IOException {
        try {
              Main.mag = TabMagasin.getSelectionModel().getSelectedItem();
                if(Main.mag != null){
              searchmagasin.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("SupprimerMagasin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}
               else
                   selMagErr.setText("Aucun magasin Selectionmée");
        } catch (Exception e) {
        }
           

    }

    @FXML
    private void ModifierMagasinGo(ActionEvent event) throws IOException {
        try {
            
               Main.mag = TabMagasin.getSelectionModel().getSelectedItem();
               if(Main.mag != null){
                          searchmagasin.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("Modifiermagasin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();}
               else
                   selMagErr.setText("Aucun magasin Selectionmée");
                } catch (Exception e) {
        }
    }

    @FXML
    private void openCategGest(ActionEvent event) throws IOException {
               searchmagasin.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionCategorie.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void openarticlegest(ActionEvent event) throws IOException {
                searchmagasin.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionArticles.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void getPdf(ActionEvent event) {
        sm.pdf();
        
    }

    private void espaceUser(ActionEvent event) throws IOException {
        
                      searchmagasin.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("EspaceUserMagasin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void retour(ActionEvent event)  {
               searchmagasin.getScene().getWindow().hide();
               try{
               Parent root = FXMLLoader.load(getClass().getResource("dashbord.fxml"));
               Stage mainStage = new Stage();
               Scene scene = new Scene(root);
               mainStage.setScene(scene);
               mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
}
