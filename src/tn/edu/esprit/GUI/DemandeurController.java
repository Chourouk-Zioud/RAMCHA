/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Demandeur;
import tn.edu.esprit.entities.Prestateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.tools.DataS;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class DemandeurController implements Initializable {

    @FXML
    private Button retourd;

    @FXML
    private TableView<Demandeur> tabvd;
    @FXML
    private TableColumn<Demandeur, String> cind;
    @FXML
    private TableColumn<Demandeur, String> nomd;
    @FXML
    private TableColumn<Demandeur, String> prenomd;
    @FXML
    private TableColumn<Demandeur, String> dated;
    @FXML
    private TableColumn<Demandeur, String> addd;
    @FXML
    private TableColumn<Demandeur, Integer> postd;
    @FXML
    private TableColumn<Demandeur, String> numd;
    @FXML
    private TableColumn<Demandeur, String> logind;
    @FXML
    private TableColumn<Demandeur, String> passwd;
    @FXML
    private TableColumn<Demandeur, String> libd;
    @FXML
    private Button suppd;
    @FXML
    private Button mod;
    @FXML
    private TextField ml;
    @FXML
    private TextField cherd;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx = DataS.getInstance().getConnection();
        ServiceUtilisateur su = new ServiceUtilisateur();
        ObservableList<Demandeur> list = (ObservableList<Demandeur>) su.getAllD();

        cind.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("cinUser"));
        nomd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("nomUser"));
        prenomd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("prenomUser"));
        dated.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("ddnUser"));
        addd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("adressUser"));
        postd.setCellValueFactory(new PropertyValueFactory<Demandeur, Integer>("codePostalUser"));
        numd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("numUser"));
        logind.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("loginUser"));
        passwd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("passwUser"));
        libd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("libelleDemande"));
        
        System.out.println(list);
        tabvd.setItems(list);
        
        
        FilteredList<Demandeur> filteredData = new FilteredList<>(list, b -> true);
        cherd.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(d -> {
                if (newValue == null || newValue.isEmpty()) {
					return true;
				}
                String lowerCaseFilter = newValue.toLowerCase();
                           if (d.getCinUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                          else if (d.getNomUser().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
                          else if (d.getPrenomUser().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
                       
                          else if (d.getAdressUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                
                          else if (String.valueOf(d.getCodePostalUser()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                          
                          else if (d.getNumUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                          else if (d.getLibelleDemande().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                          else return (String.valueOf(d.getDdnUser()).indexOf(lowerCaseFilter)!=-1);
					
	});
		});
        SortedList<Demandeur> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(tabvd.comparatorProperty());
        tabvd.setItems(sortedData);  
        
    
    }    

    @FXML
    private void retourD(ActionEvent event)  {
                retourd.getScene().getWindow().hide();
                try {
              Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void deleteD(ActionEvent event)  {
                Utilisateur u = tabvd.getSelectionModel().getSelectedItem();
        ServiceUtilisateur su = new ServiceUtilisateur();
        
        su.supprimer(u.getIdUser());
        suppd.getScene().getWindow().hide();
        try{
        Parent root = FXMLLoader.load(getClass().getResource("demandeur.fxml"));
               Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        Alert alert = new Alert (AlertType.CONFIRMATION, "Demandeur supprimé avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
     
       
    }


    @FXML
    private void modifierD(ActionEvent event) throws IOException {
        Utilisateur u =  tabvd.getSelectionModel().getSelectedItem();
        Demandeur d = new Demandeur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        d.setIdUser(u.getIdUser());
        System.out.println(u.getIdUser());
        d.setLibelleDemande(ml.getText().toString());
        su.modifierD(d);
        mod.getScene().getWindow().hide();
        try{
        Parent root = FXMLLoader.load(getClass().getResource("demandeur.fxml"));
               Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                Alert alert = new Alert (AlertType.CONFIRMATION, "Demandeur modifié avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
     
    }
    
}
