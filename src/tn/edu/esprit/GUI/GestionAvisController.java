/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Avis;
import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.services.ServiceAvis;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class GestionAvisController implements Initializable {
  Connection cnx = DataS.getInstance().getConnection();
    ServiceAvis sa = new ServiceAvis(cnx);
    @FXML
    private TableView<Avis> tabAvis;
    @FXML
    private TableColumn<Avis, String> detailsAvis;
    @FXML
    private TableColumn<Avis, Integer> noteAvis;
    @FXML
    private TableColumn<Avis, Integer> ArticleAvis;
    @FXML
    private TableColumn<Avis, Integer> userAvis;
    @FXML
    private ComboBox<Integer> selAvis;
    @FXML
    private TextField searchavis;
    @FXML
    private Label ErrSel;
        private Integer[] a = {1,2,3,4};
    @FXML
    private Text userinfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selAvis.getItems().setAll(a);
        AfficherAvis(sa.getAll());
        userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());
    }    

    @FXML
    private void retourAvvis(ActionEvent event) throws IOException {
                 searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void ajouterAvis(ActionEvent event) throws IOException {
        MainKais.role = "admin";
                     searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AjouterAvisArticle.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
    }

    @FXML
    private void ModifierAvis(ActionEvent event) {
                                 try {
                  MainKais.avis = tabAvis.getSelectionModel().getSelectedItem();
                  if (MainKais.avis != null) {
                 searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifeirAvis.fxml"));
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
    private void SuppAvis(ActionEvent event) {
                             try {
                  MainKais.avis = tabAvis.getSelectionModel().getSelectedItem();
                  if (MainKais.avis != null) {
                 searchavis.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("SupprimerAvis.fxml"));
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
    private void AvisArt(ActionEvent event) {
        AfficherAvis(sa.getAllArticle(selAvis.getValue()));
    }
    

            void AfficherAvis(ObservableList<Avis>  list){
                
        detailsAvis.setCellValueFactory(new PropertyValueFactory<Avis, String>("detailAvisService"));
        noteAvis.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("noteService"));
        ArticleAvis.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("idArticle"));
        userAvis.setCellValueFactory(new PropertyValueFactory<Avis, Integer>("idUser"));
              tabAvis.setItems(list);
        FilteredList<Avis> filteredData = new FilteredList<>(list, b -> true);
		searchavis.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getDetailAvisService().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                  
				else return String.valueOf(m.getNoteService()).contains(lowerCaseFilter); // Does not match.           
	});
		});
                SortedList<Avis> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(tabAvis.comparatorProperty());
		
		tabAvis.setItems(sortedData);
    
    }

    @FXML
    private void acualiser(ActionEvent event) {
        AfficherAvis(sa.getAll());
    }
    
}
