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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
public class PrestateurController implements Initializable {

    @FXML
    private Button retourp;
    @FXML
    private TableColumn<Prestateur, String> cp;
    @FXML
    private TableColumn<Prestateur, String> npp;
    @FXML
    private TableColumn<Prestateur, String> pp;
    @FXML
    private TableColumn<Prestateur, String> dp;
    @FXML
    private TableColumn<Prestateur, String> ap;
    @FXML
    private TableColumn<Prestateur, Integer>cpp;
    @FXML
    private TableColumn<Prestateur, String> nump;
    @FXML
    private TableColumn<Prestateur, String>lp;
    @FXML
    private TableColumn<Prestateur, String>pasp;
    @FXML
    private TableColumn<Prestateur, String> sp;
    @FXML
    private TableColumn<Prestateur, String>pop;
    @FXML
    private TableColumn<Prestateur, String> exp;
    @FXML
    private TableColumn<Prestateur, String>dip;
    @FXML
    private TableView<Prestateur> vp;
    @FXML
    private TableColumn<Prestateur, String> dap;
    @FXML
    private Button supp;
    @FXML
    private Button modifp;
    @FXML
    private TextField ssm;
    private TextField dism;
    @FXML
    private TextField posm;
    @FXML
    private TextField dipm;
    @FXML
    private TextField exm;
    @FXML
    private TextField cherp;
    @FXML
    private ChoiceBox<String> dispo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Connection cnx = DataS.getInstance().getConnection();
        ServiceUtilisateur su = new ServiceUtilisateur();
        ObservableList<Prestateur> list = (ObservableList<Prestateur>) su.getAllP();
        
        

        cp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("cinUser"));
        npp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("nomUser"));
        pp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("prenomUser"));
        dap.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("ddnUser"));
        ap.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("adressUser"));
        cpp.setCellValueFactory(new PropertyValueFactory<Prestateur, Integer>("codePostalUser"));
        nump.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("numUser"));
        lp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("loginUser"));
        pasp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("passwUser"));
        sp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("salaireP"));
        pop.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("posteP"));
        dp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("diplomeP"));
        exp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("experP"));
        dip.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("dispoP"));
        
        System.out.println(list);
        vp.setItems(list);
        
        String[] a = {"Disponible","Non disponible"};
        dispo.getItems().addAll(a);
        //dispo.setValue("hh");
        
        FilteredList<Prestateur> filteredData = new FilteredList<>(list, b -> true);
        cherp.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(p -> {
                if (newValue == null || newValue.isEmpty()) {
					return true;
				}
                String lowerCaseFilter = newValue.toLowerCase();
                if (p.getSalaireP().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
		                 }
                          else if (p.getPosteP().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
                          else if (p.getCinUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                          else if (p.getNomUser().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
                          else if (p.getPrenomUser().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
                          else if (p.getAdressUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                          else if (p.getDiplomeP().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
                          else if (p.getExperP().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                  
                          else return (p.getDispoP().toLowerCase().contains(lowerCaseFilter) ); 
					
	});
		});
        SortedList<Prestateur> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(vp.comparatorProperty());
        vp.setItems(sortedData);  
        
    }    

    @FXML
    private void retourP(ActionEvent event)  {
        
        retourp.getScene().getWindow().hide();
        try {
              Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }
         catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void supprimerp(ActionEvent event)  {
        Utilisateur u = vp.getSelectionModel().getSelectedItem();
        ServiceUtilisateur su = new ServiceUtilisateur();
        
        su.supprimer(u.getIdUser());
        
        supp.getScene().getWindow().hide();
        
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Prestateur.fxml"));
               Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                Alert alert = new Alert (AlertType.CONFIRMATION, "Prestateur supprimé avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
     
    }


    @FXML
    private void modiferp(ActionEvent event)  {
        boolean sal = ssm.getText().matches("[+-]?\\d*(\\.\\d+)?");
        
        if (!sal) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le salaire !");
            alert.show();
        }
            else{
        
        Utilisateur u =  vp.getSelectionModel().getSelectedItem();
        Prestateur p = new Prestateur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        p.setIdUser(u.getIdUser());
        System.out.println(u.getIdUser());
        
        p.setSalaireP(ssm.getText().toString());
        p.setPosteP(posm.getText().toString());
        p.setDiplomeP(dipm.getText().toString());
        p.setExperP(exm.getText().toString());
        p.setDispoP(dispo.getValue().toString());
        su.modifierP(p);
        
        
        modifp.getScene().getWindow().hide();
       
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Prestateur.fxml"));
               Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                Alert alert = new Alert (AlertType.CONFIRMATION, "Prestateur modifié avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
                    }
    }

    @FXML
    private void test(MouseEvent event) {
        Prestateur p =  vp.getSelectionModel().getSelectedItem();
        dispo.setValue(p.getDispoP());
        ssm.setText(p.getSalaireP());
        posm.setText(p.getPosteP());
        dipm.setText(p.getDiplomeP());
        exm.setText(p.getExperP());
        
    }
    
}
