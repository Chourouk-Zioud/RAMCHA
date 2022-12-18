/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

//import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
//import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.TypeCours;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.services.ServicesCours;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class AcceuilUtilisateurController implements Initializable {

    @FXML
    private ScrollPane cardLayout;
    @FXML
    private HBox cardLayout1;
    private List<TypeCours> Récemmentajouté;
    @FXML
    private GridPane bookContainer;

     private List<TypeCours> Recommandation;
    @FXML
    private TextField rech;
   @FXML
    private TableView<Cours> tab_aff;
    @FXML
    private TableColumn<Cours, String> nom_cours;
    @FXML
    private TableColumn<Cours, String> categorie;
    @FXML
    private TableColumn<Cours, String> sujet ;
    @FXML
    private TableColumn<Cours, String> niveau;
        ServicesCours sc = new ServicesCours();
    @FXML
    private HBox raterr;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
          Cours css = new Cours();
        ObservableList<Cours>  list  =  sc.getAll();
        nom_cours.setCellValueFactory(new PropertyValueFactory<Cours, String>("nomCours"));
        categorie.setCellValueFactory(new PropertyValueFactory<Cours, String>("categoriesCours"));
             sujet.setCellValueFactory(new PropertyValueFactory<Cours, String>("sujetCours"));
                     niveau.setCellValueFactory(new PropertyValueFactory<Cours, String>("niveauCours"));
    
         System.out.println(list);
         tab_aff.setItems(list);
         FilteredList<Cours> filteredData = new FilteredList<>(list, b -> true);
        
        // 2. Set the filter Predicate whenever the filter changes.
        rech.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cs -> {
                // If filter text is empty, display all persons.
                                
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (cs.getNomCours().toLowerCase().contains(lowerCaseFilter) ) {
                    return true; // Filter matches first name.
                } else if (cs.getCategoriesCours().toLowerCase().contains(lowerCaseFilter) ){
                    return true; // Filter matches last name.
                }
                          else if (cs.getSujetCours().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    }
                     else if (cs.getNiveauCours().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                    }
                return false;
                             
      
                                
    });
        });
                SortedList<Cours> sortedData = new SortedList<>(filteredData);
        
        // 4. Bind the SortedList comparator to the TableView comparator.
        //       Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tab_aff.comparatorProperty());
        
        // 5. Add sorted (and filtered) data to the table.
        tab_aff.setItems(sortedData);
        Récemmentajouté =new ArrayList<>(Récemmentajouté());
        Recommandation = new ArrayList<>(typeCours());
        int column =0;
        int row=1;
           try {
        for(int i=0; i<Récemmentajouté.size();i++){
        FXMLLoader fxmlLoader =new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("card.fxml"));
      
                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
              cardController.setData(Récemmentajouté.get(i));
                 cardLayout1.getChildren().add(cardBox);
        }  
       for(TypeCours tc : Recommandation ){
        FXMLLoader fxmlLoader =new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Recommandation.fxml"));
      
                VBox recommandationBox = fxmlLoader.load();
                RecommandationController recommandationController = fxmlLoader.getController();
              recommandationController.setData(tc);
              
              if (column == 6){
              column= 0;
              ++row;
              }
                 bookContainer.add(recommandationBox,column++,row);
                 GridPane.setMargin(recommandationBox,new javafx.geometry.Insets(10));
        
              /*  CardController = fxmlloader.getController();
                CardController.setData(Récemmentajouté.get(i));*/
             
            } 
           }catch (IOException ex) {
                //Logger.getLogger(AcceuilUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
               ex.printStackTrace();
            }
    
        }
        
        
    private List<TypeCours> Récemmentajouté(){
    List<TypeCours> ls =new ArrayList<>();
    TypeCours tc = new TypeCours();
    tc.setName("Design");
    tc.setImagSrc("design.jpg");
    ls.add(tc);
    
    tc = new TypeCours();
    tc.setName("Musique");
    tc.setImagSrc("Musique.jpg");
    ls.add(tc);
    
      tc = new TypeCours();
    tc.setName("Photographie");
    tc.setImagSrc("Photographie.jpg");
    ls.add(tc);
      
          tc = new TypeCours();
    tc.setName("Marketing");
    tc.setImagSrc("Marketing.jpg");
    ls.add(tc);
    
    
    
    return ls;
    }
    private List<TypeCours> typeCours(){
       List<TypeCours> ls =new ArrayList<>();
    TypeCours tc = new TypeCours();
    tc.setName("Developpement personel");
    tc.setImagSrc("developpement personelle.jpg");
    ls.add(tc);
    
    tc = new TypeCours();
    tc.setName("Business");
    tc.setImagSrc("Business.jpg");
    ls.add(tc);
    
      tc = new TypeCours();
    tc.setName("Informatique");
    tc.setImagSrc("informatique.jpg");
    ls.add(tc);
      
          tc = new TypeCours();
    tc.setName("Développement");
    tc.setImagSrc("Developement web.jpg");
    ls.add(tc);
      return ls;
    }

    @FXML
    private void rateee(MouseEvent event) throws IOException {
        
        
         NewFXMainClass.cc = tab_aff.getSelectionModel().getSelectedItem();

         rech.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("Reating.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void retourrrr(MouseEvent event) throws IOException {
         rech.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
    
  
    
    
}
