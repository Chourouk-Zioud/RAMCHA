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
import java.sql.Date;
import java.text.SimpleDateFormat;
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
public class MenuController implements Initializable {

    @FXML
    private AnchorPane pane_menu;
    @FXML
    private Button prest;
    @FXML
    private Button dem;
    @FXML
    private TableView<Utilisateur> tvm;
    @FXML
    private TableColumn<Utilisateur, String> cid;
    @FXML
    private TableColumn<Utilisateur, String> nid;
    @FXML
    private TableColumn<Utilisateur, String> pid;
    @FXML
    private TableColumn<Utilisateur, Date> did;
    @FXML
    private TableColumn<Utilisateur, String> aid;
    @FXML
    private TableColumn<Utilisateur, Integer> coid;
    
    @FXML
    private TableColumn<Utilisateur, String> lid;
    @FXML
    private TableColumn<Utilisateur, String> pasid;
    @FXML
    private TableColumn<Utilisateur, String> nuid;
    @FXML
    private Button supp;
    private TextField cina;
    private TextField noma;
    private TextField prenoma;
    private TextField datea;
    private TextField adressa;
    private TextField codepa;
    private TextField numa;
    private TextField logina;
    private TextField passa;
    @FXML
    private Button modfm;
    @FXML
    private TextField sal;
    @FXML
    private TextField po;
    @FXML
    private TextField dip;
    @FXML
    private TextField exp;
    @FXML
    private Button ajoutep;
    @FXML
    private Button ajoutd;
    @FXML
    private ChoiceBox<String> disp;
    @FXML
    private TextField libelle;
    @FXML
    private Button dx;
    @FXML
    private TextField cheru;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Connection cnx = DataS.getInstance().getConnection();
        ServiceUtilisateur su = new ServiceUtilisateur();
        ObservableList<Utilisateur> list = su.getAll();
        
        cid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("cinUser"));
        nid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nomUser"));
        pid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenomUser"));
        did.setCellValueFactory(new PropertyValueFactory<Utilisateur, Date>("ddnUser"));
        aid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("adressUser"));
        coid.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("codePostalUser"));
        nuid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("numUser"));
        lid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("loginUser"));
        pasid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("passwUser"));
        
        System.out.println(list);
        
        tvm.setItems(list);
        String[] a = {"Disponible","Non disponible"};
        disp.getItems().addAll(a);
        
        FilteredList<Utilisateur> filteredData = new FilteredList<>(list, b -> true);
        cheru.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(util -> {
                if (newValue == null || newValue.isEmpty()) {
					return true;
				}
                String lowerCaseFilter = newValue.toLowerCase();
                          if (util.getCinUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                          else if (util.getNomUser().toLowerCase().contains(lowerCaseFilter)) {
					return true; // Filter matches first name.
				}
                          else if (util.getPrenomUser().toLowerCase().contains(lowerCaseFilter)) {
					return true;
				}
                       
                          else if (util.getAdressUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                
                          else if (String.valueOf(util.getCodePostalUser()).indexOf(lowerCaseFilter)!=-1){
				     return true;}
                          
                          else if (util. getNumUser().toLowerCase().contains(lowerCaseFilter) ) {
					return true; 
				} 
                          
                          else return (String.valueOf(util.getDdnUser()).indexOf(lowerCaseFilter)!=-1);
	                      
	});
		});
        SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
        
        sortedData.comparatorProperty().bind(tvm.comparatorProperty());
        tvm.setItems(sortedData);
                
         }
        

        

    @FXML
    private void goprest(ActionEvent event)  {
        
               prest.getScene().getWindow().hide();
               try{
              Parent root = FXMLLoader.load(getClass().getResource("Prestateur.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void godem(ActionEvent event)  {
               dem.getScene().getWindow().hide();
               try{
              Parent root = FXMLLoader.load(getClass().getResource("demandeur.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void delete(ActionEvent event) {
        
        Utilisateur u = tvm.getSelectionModel().getSelectedItem();
        ServiceUtilisateur su = new ServiceUtilisateur();
        
        su.supprimer(u.getIdUser());
        supp.getScene().getWindow().hide();
        
        try{
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
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
    private void modifeiru(ActionEvent event) throws IOException {
            
            NewFXMainClass.us = tvm.getSelectionModel().getSelectedItem();

             modfm.getScene().getWindow().hide();
             Parent root = FXMLLoader.load(getClass().getResource("modifieru.fxml"));
             Stage mainStage = new Stage();
             Scene scene = new Scene(root);
             mainStage.setScene(scene);
             mainStage.show();

    }

    @FXML
    private void ajouterp(ActionEvent event) {
        
       
                          boolean salai = sal.getText().matches("[+-]?\\d*(\\.\\d+)?");

         if( sal.getText().equals("")  || po.getText().equals("") ||dip.getText().equals("") ||exp.getText().equals("") || disp.getValue().toString().equals("") ){
             Alert alert = new Alert (AlertType.WARNING, "Remplissez tous les champs !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
 
}
        
                 else if (!salai){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le salaire !");
            alert.show();
        }
            
         else{
            try{
                
        Utilisateur u = tvm.getSelectionModel().getSelectedItem();
        Prestateur p = new Prestateur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        p.setRole("prestateur");
        p.setSalaireP(sal.getText().toString());
        p.setPosteP(po.getText().toString());
        p.setDiplomeP(dip.getText().toString());
        p.setExperP(exp.getText().toString());
        p.setDispoP(disp.getValue().toString());
        p.setIdUser(u.getIdUser());
        
        su.ajouterP(p);
        
        Alert alert = new Alert (AlertType.CONFIRMATION, "Prestateur ajouté avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        
      
         }
   
    }

    @FXML
    private void ajouterd(ActionEvent event) {
        
          
         if( libelle.getText().equals("")  ){
           Alert alert = new Alert (AlertType.WARNING, "Remplissez le champ !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
         }
         else{
             try{
        Utilisateur u = tvm.getSelectionModel().getSelectedItem();
        Demandeur d = new Demandeur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        d.setRole("demandeur");
        d.setLibelleDemande(libelle.getText().toString());
        d.setIdUser(u.getIdUser());
        
        su.ajouterD(d);
        
        Alert alert = new Alert (AlertType.CONFIRMATION, "Demandeur ajouté avec succés !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
             }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
         }
    }

    @FXML
    private void deconnexion(ActionEvent event)  {
               dx.getScene().getWindow().hide();
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
