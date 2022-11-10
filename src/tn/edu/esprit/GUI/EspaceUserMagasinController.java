/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Article;
import tn.edu.esprit.entities.CategorieArticle;
import tn.edu.esprit.entities.Magasin;
import tn.edu.esprit.services.ArticleService;
import tn.edu.esprit.services.CategorieService;
import tn.edu.esprit.services.ServiceMagasin;
import tn.edu.esprit.tools.DataS;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class EspaceUserMagasinController implements Initializable {
  Connection cnx = DataS.getInstance().getConnection();
    CategorieService sc = new CategorieService(cnx);
    ServiceMagasin sm = new ServiceMagasin(cnx);
    ArticleService sa = new ArticleService(cnx);
    @FXML
    private TextField SearchMagasin;
    @FXML
    private TableView<Article> tableArticle;
    @FXML
    private TableColumn<Article, Integer> IdArticle;
    @FXML
    private TableColumn<Article, String> NomArticle;
    @FXML
    private TableColumn<Article, String> MarqueArticle;
    @FXML
    private TableColumn<Article, String> TypeArticle;
    @FXML
    private TableColumn<Article, Integer> DispArticle;
    @FXML
    private TableColumn<Article, String> CouleurArticle;
    @FXML
    private TableColumn<Article, Float> PrixArticle;
    @FXML
    private TableColumn<Article, String> TailleArticle;
    @FXML
    private TableColumn<Article, String> DiscripArticcle;
    @FXML
    private TableColumn<Article, String> FicheArticle;
    @FXML
    private TableView<Magasin> TabMagasin;
    @FXML
    private TableColumn<Magasin, Integer> IdmTab;
    @FXML
    private TableColumn<Magasin, String> nommtab;
    @FXML
    private TableColumn<Magasin, String> AdressMtab;
    @FXML
    private TableColumn<Magasin, String> EmailMTab;
    @FXML
    private TableColumn<Magasin, String> TelMTab;
    @FXML
    private ComboBox<CategorieArticle> catList;
    @FXML
    private TextField searchmagasin;
    @FXML
    private Label errSel;
    @FXML
    private Button dx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        catList.getItems().addAll(sc.getAll());
         AfficherArticle(sa.getAll());
         AfficherMagasin ();
    }    

    @FXML
    private void search2(ActionEvent event) {
                AfficherArticle(sa.getAllForCateg(catList.getValue().getIdCategorie()));

    }
    
    
    void AfficherArticle(ObservableList<Article>  list){
           // ObservableList<Article>  list  = sa.getAll();
        IdArticle.setCellValueFactory(new PropertyValueFactory<Article, Integer>("idArticle"));
        NomArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("nomArticle"));
        MarqueArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("marqueArticle"));
        TypeArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("typeArticle"));
        DispArticle.setCellValueFactory(new PropertyValueFactory<Article, Integer>("disponibiliteArticle"));
        CouleurArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("couleurArticle"));
        PrixArticle.setCellValueFactory(new PropertyValueFactory<Article, Float>("prixArticle"));
        TailleArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("tailleArticle"));
        DiscripArticcle.setCellValueFactory(new PropertyValueFactory<Article, String>("descriptionArticle"));
        FicheArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("ficheTechnique"));
        tableArticle.setItems(list);
        FilteredList<Article> filteredData = new FilteredList<>(list, b -> true);
		SearchMagasin.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getNomArticle().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                                else if (m.getTypeArticle().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getCouleurArticle().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getMarqueArticle().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getDescriptionArticle().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                                else if (m.getTypeArticle().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
				else return String.valueOf(m.getPrixArticle()).contains(lowerCaseFilter); // Does not match.           
	});
		});
                SortedList<Article> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(tableArticle.comparatorProperty());
		
		tableArticle.setItems(sortedData);
    
    }
    
    
        void AfficherMagasin (){
            ObservableList<Magasin>  list  = sm.getAll();
        IdmTab.setCellValueFactory(new PropertyValueFactory<Magasin, Integer>("idMagasin"));
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
    private void getProduct(ActionEvent event) {
         errSel.setText(""); 
        Magasin m = new Magasin();
        try {
         m  = TabMagasin.getSelectionModel().getSelectedItem();  
         AfficherArticle(sa.getAllForMagasin(m.getIdMagasin()));
        } catch (Exception e) {
          errSel.setText("Selectionne un magasin"); 
        }
        
         
    }

    @FXML
    private void deconnexion(ActionEvent event)  {
               dx.getScene().getWindow().hide();
               try{
               Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
               Stage mainStage = new Stage();
               Scene scene = new Scene(root);
               mainStage.setScene(scene);
               mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
}
