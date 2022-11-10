/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.CategorieArticle;
import tn.edu.esprit.entities.Magasin;
import tn.edu.esprit.services.CategorieService;
import tn.edu.esprit.tools.DataS;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chourouk Zioud
 */
public class GestionCategorieController implements Initializable {
    Connection cnx = DataS.getInstance().getConnection();
    CategorieService sc = new CategorieService(cnx);
    @FXML
    private TextField libellecatrg;
    @FXML
    private TextArea discCateg;
    @FXML
    private Label ErrLibellCateg;
    @FXML
    private Label errDiscCateg;
    @FXML
    private TableView<CategorieArticle> categTab;
    @FXML
    private TableColumn<CategorieArticle, String> libelletab;
    @FXML
    private TableColumn<CategorieArticle, String> DiscriptionTab;
    @FXML
    private TextField searchcat;
    @FXML
    private Label ajoutSucclabel;
    @FXML
    private Label ErrSrlCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          InitialCat () ;
          AfficherCateg ();
    }    

    @FXML
    private void retourCatg(ActionEvent event) throws IOException {
             searchcat.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("dashbord.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void suppcat(ActionEvent event) throws IOException {
        try {
                  Main.cat = categTab.getSelectionModel().getSelectedItem();
                  if (Main.cat != null) {
                                      searchcat.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("SupprimerCateg.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
                  else
                       ErrSrlCat.setText("Aucun Cat Selectionnée");
    
        } catch (Exception e) {
        }
              
    }

    @FXML
    private void ajoutccat(ActionEvent event) {
                  InitialCat () ;
  int x = 0;
        if (libellecatrg.getText().equals("")){
        ErrLibellCateg.setVisible(true);
        ErrLibellCateg.setText("ChampObligatoire");
        x=1;
        }
        if (discCateg.getText().equals("")){
        errDiscCateg.setVisible(true);
        errDiscCateg.setText("ChampObligatoire");
        x=1;
        }
        
        if(x == 0){
        CategorieArticle c = new CategorieArticle(libellecatrg.getText(), discCateg.getText());
        sc.ajouter(c);
        ajoutSucclabel.setText("Ajout avec success");
        AfficherCateg ();
        }
        
        
        
    }

    @FXML
    private void modfCatg(ActionEvent event) {
         Main.cat = categTab.getSelectionModel().getSelectedItem();
                          InitialCat () ;
                            if (Main.cat != null) {
  int x = 0;
        if (libellecatrg.getText().equals("")){
        ErrLibellCateg.setVisible(true);
        ErrLibellCateg.setText("ChampObligatoire");
        x=1;
        }
        if (discCateg.getText().equals("")){
        errDiscCateg.setVisible(true);
        errDiscCateg.setText("ChampObligatoire");
        x=1;
        }
        
        if(x == 0){
        CategorieArticle c = new CategorieArticle(Main.cat.getIdCategorie(),libellecatrg.getText(), discCateg.getText());
        sc.modifier(c);
        ajoutSucclabel.setText("Modifier avec success");
        AfficherCateg ();
        }
                            }
                            else
                                       ErrSrlCat.setText("Aucun Cat Selectionnée");
                                
    }
    
    
    void InitialCat () {
    errDiscCateg.setVisible(false);
    ErrSrlCat.setText("");
            ErrLibellCateg.setVisible(false);
            ajoutSucclabel.setText("");
    }
    
    void AfficherCateg (){
            ObservableList<CategorieArticle>  list  = sc.getAll();
        libelletab.setCellValueFactory(new PropertyValueFactory<CategorieArticle, String>("libelle"));
        DiscriptionTab.setCellValueFactory(new PropertyValueFactory<CategorieArticle, String>("discription"));
 
        categTab.setItems(list);
        FilteredList<CategorieArticle> filteredData = new FilteredList<>(list, b -> true);
		searchcat.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getLibelle().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                               
				else return (m.getDiscription().toLowerCase().contains(lowerCaseFilter)); // Does not match.           
	});
		});
                SortedList<CategorieArticle> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(categTab.comparatorProperty());
		
		categTab.setItems(sortedData);
    
    }

    @FXML
    private void selectCateg(ActionEvent event) {
        try {
                  Main.cat = categTab.getSelectionModel().getSelectedItem();
                  if(Main.cat != null){
                 libellecatrg.setText(Main.cat.getLibelle());
                 discCateg.setText(Main.cat.getDiscription());}
                  else
                      ErrSrlCat.setText("Aucun Cat Selectionnée");
        } catch (Exception e) {
        }
       
    }

    @FXML
    private void gomagasin(ActionEvent event) throws IOException {
            searchcat.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("GestionMagasin.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
    }


    @FXML
    private void openArticle(ActionEvent event)throws IOException {
                searchcat.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionArticles.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
            
}
