/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.services.ServiceReclamation;
import tn.edu.esprit.tools.DataS;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kais Chalghoumi
 */
public class GestionReclamationController implements Initializable {
  Connection cnx = DataS.getInstance().getConnection();
  ServiceReclamation sr = new ServiceReclamation(cnx);
    @FXML
    private TableView<Reclamation> tabReclamation;
    @FXML
    private TableColumn<Reclamation, String> nomRec;
    @FXML
    private TableColumn<Reclamation, String> prenomRec;
    @FXML
    private TableColumn<Reclamation, String> emailRec;
    @FXML
    private TableColumn<Reclamation, String> numeroRec;
    @FXML
    private TableColumn<Reclamation, Date> Date_creRec;
    @FXML
    private TableColumn<Reclamation, Date> date_traRec;
    @FXML
    private TableColumn<Reclamation, String> descRec;
    @FXML
    private TableColumn<Reclamation, String> statusRec;

    @FXML
    private TableColumn<Reclamation, String> servRec;
    @FXML
    private TextField searchRec;
    @FXML
    private Label ErrSel;
    @FXML
    private ImageView imageV;
    @FXML
    private Button dx;
    @FXML
    private Text userinfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherReclamation(sr.getAll());
        userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());
    }    

    @FXML
    private void goAjouter(ActionEvent event) throws IOException {
        MainKais.role = "admin";
              searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterREclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void goModifeir(ActionEvent event) throws IOException {

                 try {
                  MainKais.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (MainKais.rec != null) {
                 searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
    }

    @FXML
    private void goSupprimer(ActionEvent event) throws IOException {
                         try {
                  MainKais.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (MainKais.rec != null) {
                 searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("SupprimerReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
    }

    @FXML
    private void ChangerStatus(ActionEvent event) {
        
                         try {
                  MainKais.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (MainKais.rec != null) {
                 searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("StatusReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
    }
    
        void AfficherReclamation(ObservableList<Reclamation>  list){
            
        nomRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nom"));
        prenomRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("prenom"));
        emailRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("email"));
        numeroRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("numero_mobile"));
        Date_creRec.setCellValueFactory(new PropertyValueFactory<Reclamation, Date>("date_creation"));
        date_traRec.setCellValueFactory(new PropertyValueFactory<Reclamation, Date>("date_traitement"));
        descRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("description"));
        statusRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("status"));
        servRec.setCellValueFactory(new PropertyValueFactory<Reclamation, String>("nomServcie"));

        tabReclamation.setItems(list);
        FilteredList<Reclamation> filteredData = new FilteredList<>(list, b -> true);
		// 2. Set the filter Predicate whenever the filter changes.
		searchRec.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getNom().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                                else if (m.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getStatus().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getEmail().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getDescription().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getNomServcie().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
				else return String.valueOf(m.getIdReclamation()).contains(lowerCaseFilter); // Does not match.           
	});
		});
                SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(tabReclamation.comparatorProperty());
		
		tabReclamation.setItems(sortedData);
    
    }

    @FXML
    private void goavis(ActionEvent event) throws IOException {
        
                         searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionAvis.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
    }

    @FXML
    private void goReponse(ActionEvent event) throws IOException {
                      searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReponse.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void imageget(ActionEvent event) {
        
        
          try {
                  MainKais.rec = tabReclamation.getSelectionModel().getSelectedItem();
                  if (MainKais.rec != null) {
                      Image img = new Image(MainKais.rec.getScreenshot());
              imageV.setImage(img);
            }
                  else
                       ErrSel.setText("Aucun Rec Selectionnée");
    
        } catch (Exception e) {
        }
        
        
    }

    private void goUser(ActionEvent event) throws IOException {
               searchRec.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("EspaceUser.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
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
