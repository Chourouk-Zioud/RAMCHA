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
import tn.edu.esprit.services.ExcelService;
import tn.edu.esprit.services.ServiceMagasin;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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
 * @author Chourouk Zioud
 */
public class GestionArticlesController implements Initializable {
  Connection cnx = DataS.getInstance().getConnection();
    CategorieService sc = new CategorieService(cnx);
    ServiceMagasin sm = new ServiceMagasin(cnx);
    ArticleService sa = new ArticleService(cnx);
    @FXML
    private TableView<Article> tableArticle;
    @FXML
    private TableColumn<Article, String> NomArticle;
    @FXML
    private TableColumn<Article, String> MarqueArticle;
    @FXML
    private TableColumn<Article, String> TypeArticle;
    @FXML
    private TableColumn<Article, String> DispArticle;
    @FXML
    private TableColumn<Article, String> CouleurArticle;
    @FXML
    private TableColumn<Article, Float> PrixArticle;
    @FXML
    private TableColumn<Article, String> TailleArticle;
    @FXML
    private TableColumn<Article, String> DiscripArticcle;
    @FXML
    private TextField searchArticle;
    @FXML
    private ComboBox<Magasin> MagsinList;
    @FXML
    private ComboBox<CategorieArticle> catList;
    @FXML
    private Label errSelArt;
    @FXML
    private ImageView imageV;
    @FXML
    private Label ErrSel;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AfficherArticle(sa.getAll());
         MagsinList.getItems().addAll(sm.getAll());
               catList.getItems().addAll(sc.getAll());
               userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());
    }    

    @FXML
    private void ajouterArticle(ActionEvent event) throws IOException {
           searchArticle.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("AjouterArticle.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
  
    @FXML
    private void modifeirArticle(ActionEvent event) throws IOException {
        try {
            
                 Main.art = tableArticle.getSelectionModel().getSelectedItem();
                  if(Main.art != null){
                   searchArticle.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("ModifierArticle.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                     }
            else
                errSelArt.setText("Aucun article Selectionnée");
        } catch (Exception e) {
        }
                 
    }

    @FXML
    private void supprimerarticle(ActionEvent event) throws IOException {
        try {
            Main.art = tableArticle.getSelectionModel().getSelectedItem();
            if(Main.art != null){
                   searchArticle.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("SupprimerArticle.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
            }
            else
                errSelArt.setText("Aucun article Selectionnée");
        } catch (Exception e) {
        }
                  
    }

    @FXML
    private void searchbutt(ActionEvent event) {
        
        if (MagsinList.getValue() == null) {
            Alert alert = new Alert (Alert.AlertType.WARNING, "Veuillez selectionner un magasin !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }
        else
            AfficherArticle(sa.getAllForMagasin(MagsinList.getValue().getIdMagasin()));
    }

    @FXML
    private void actualiserbtn(ActionEvent event) {
        AfficherArticle(sa.getAll());
        
               ObservableList<Article>  list  = sa.getAll();
        NomArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("nomArticle"));
        MarqueArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("marqueArticle"));
        TypeArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("typeArticle"));
        DispArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("disponibiliteArticle"));
        CouleurArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("couleurArticle"));
        PrixArticle.setCellValueFactory(new PropertyValueFactory<Article, Float>("prixArticle"));
        TailleArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("tailleArticle"));
        DiscripArticcle.setCellValueFactory(new PropertyValueFactory<Article, String>("descriptionArticle"));
        //FicheArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("screenshot"));
 
        tableArticle.setItems(list);
    }
    
    
       void AfficherArticle(ObservableList<Article>  list){
        NomArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("nomArticle"));
        MarqueArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("marqueArticle"));
        TypeArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("typeArticle"));
        DispArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("disponibiliteArticle"));
        CouleurArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("couleurArticle"));
        PrixArticle.setCellValueFactory(new PropertyValueFactory<Article, Float>("prixArticle"));
        TailleArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("tailleArticle"));
        DiscripArticcle.setCellValueFactory(new PropertyValueFactory<Article, String>("descriptionArticle"));
        //FicheArticle.setCellValueFactory(new PropertyValueFactory<Article, String>("screenshot"));
        tableArticle.setItems(list);
        FilteredList<Article> filteredData = new FilteredList<>(list, b -> true);
		// 2. Set the filter Predicate whenever the filter changes.
		searchArticle.textProperty().addListener((observable, oldValue, newValue) -> {
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

    @FXML
    private void search2(ActionEvent event) {
        
        if (catList.getValue()== null) {
            Alert alert = new Alert (Alert.AlertType.WARNING, "Veuillez selectionner une categorie !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        }
        else
            
        AfficherArticle(sa.getAllForCateg(catList.getValue().getIdCategorie()));
    }

    @FXML
    private void gomagasin(ActionEvent event) throws IOException {
                searchArticle.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionMagasin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void goCateg(ActionEvent event) throws IOException {
                searchArticle.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionCategorie.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void excel(ActionEvent event) {
        try {
           ExcelService x = new ExcelService();  
           x.ExcelCreator();
        } catch (Exception e) {
        }
       
        
    }

    @FXML
    private void retour(ActionEvent event)  {
        searchArticle.getScene().getWindow().hide();
        try{
        Parent root = FXMLLoader.load(getClass().getResource("GestionMagasin.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
        } catch(Exception ex){
        System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void imageget(ActionEvent event) {
        
        Article article = new Article();
          try {
                  article = tableArticle.getSelectionModel().getSelectedItem();
                  if (article != null) {
                      Image img = new Image(article.getScreenshot());
              imageV.setImage(img);
            }
                  else
                       ErrSel.setText("Aucun Article Selectionné");
    
        } catch (Exception e) {
        }
        
        
    }
    
}
