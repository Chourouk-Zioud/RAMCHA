/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.services.CruCat;
import tn.edu.esprit.services.CruSer;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class AjouServiceController implements Initializable {
CruCat cccr = new CruCat();
                CruSer gg=new CruSer();
                

    @FXML
    private TextField txtNomService;
    @FXML
    private Label err_nom_ser;
    @FXML
    private TextField txtprixService;
    @FXML
    private DatePicker datedebSer;
    @FXML
    private DatePicker datefebSer;
    @FXML
    private TextArea descrser;
    @FXML
    private ComboBox<String> cmbnbreouvrier;
    ObservableList<String> list1=FXCollections.observableArrayList("1","2","3","4","5","6","7","8");
    @FXML
    private ComboBox<CategorieService> categoser;
    
    ObservableList<CategorieService> list=cccr.getAll();
    
    @FXML
    private Button ajputt;
    private Label non_dispo;
    String query;
    Connection cnx;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    @FXML
    private Label err_prix_service;
    @FXML
    private Label err_nbre_ouvrier;
    @FXML
    private Label err_datedebut_service;
    @FXML
    private Label err_datefin_service;
    @FXML
    private Label err_categorie_service_ajout;
    @FXML
    private Label err_disponibilite_service;
    @FXML
    private Label champNonvamild;
        @FXML
    private Label champNonvamild1;
    @FXML
    private ImageView omg;
    @FXML
    private VBox chosenServiceCard;
    @FXML
    private Label nomappLable;
    @FXML
    private ComboBox<String> dispocombobox;
    ObservableList<String> list5=FXCollections.observableArrayList("Disponible","Non-disponible");
    /**
     * Initializes the controller class.
     */
    
     
    public int testNum(String s){
        if (s.contains("1") == true)
        return 1;
        if (s.contains("2") == true)
        return 1;
        if (s.contains("3") == true)
        return 1;
        if (s.contains("4") == true)
        return 1;
        if (s.contains("5") == true)
        return 1;
        if (s.contains("6") == true)
        return 1;
        if (s.contains("7") == true)
        return 1;
        if (s.contains("8") == true)
        return 1;
        if (s.contains("9") == true)
        return 1;
        if (s.contains("0") == true)
        return 1;
        
        return 0;
    }
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
         loadDataBaseS();
                   champNonvamild.setVisible(false);
                   champNonvamild1.setVisible(false);

  err_nom_ser.setVisible(false);
  err_prix_service.setVisible(false);
  err_nbre_ouvrier.setVisible(false);
  err_datedebut_service.setVisible(false);
  err_datefin_service.setVisible(false);
  err_categorie_service_ajout.setVisible(false);
  err_disponibilite_service.setVisible(false);
  categoser.setItems(list);
  cmbnbreouvrier.setItems(list1);
  dispocombobox.setItems(list5);
           
 }    
    ObservableList<ServiceT> listeService = FXCollections.observableArrayList();

    @FXML
    private void ajouter_servv(ActionEvent event) throws IOException {
           champNonvamild.setVisible(false);
                   champNonvamild1.setVisible(false);

  err_nom_ser.setVisible(false);
  err_prix_service.setVisible(false);
  err_nbre_ouvrier.setVisible(false);
  err_datedebut_service.setVisible(false);
  err_datefin_service.setVisible(false);
  err_categorie_service_ajout.setVisible(false);
  err_disponibilite_service.setVisible(false);
  
        int tt = 0;
        try {
            
       
        if(testNum(txtNomService.getText()) ==1 )
        {
          champNonvamild.setVisible(true);
          tt =1;
          
        }
        if(Float.parseFloat(txtprixService.getText()) < 0 )
            {
          champNonvamild1.setVisible(true);
          tt =1;
          
        }
     } catch (Exception e) {
        }
        
      if (txtNomService.getText().isEmpty()|| txtprixService.getText().isEmpty() ||
                 cmbnbreouvrier.getValue().isEmpty() || datedebSer.getValue().equals(0) || datefebSer.getValue().equals(0) || descrser.getText().isEmpty() ||  categoser.getValue().equals(0)){
        err_nom_ser.setVisible(true);
        err_prix_service.setVisible(true);
        err_nbre_ouvrier.setVisible(true);
        err_datedebut_service.setVisible(true);
        err_datefin_service.setVisible(true);
        err_categorie_service_ajout.setVisible(true);
        err_disponibilite_service.setVisible(true);
    }
       else {
          try{
        Date date1 =new Date (datedebSer.getValue().getYear()-1900,datedebSer.getValue().getMonthValue(),datedebSer.getValue().getDayOfMonth());
                Date date2 =new Date (datefebSer.getValue().getYear()-1900,datefebSer.getValue().getMonthValue(),datefebSer.getValue().getDayOfMonth());
           //  gg.ajouter=(new ServiceT(txtNomService.getText(),cmbnbreouvrier.getSelectionModel().getSelectedItem(), txtprixService.getText(),descrser.getText(),));
              ServiceT tte = new ServiceT(txtNomService.getText(), Integer.parseInt(cmbnbreouvrier.getValue()), Float.parseFloat(txtprixService.getText()), descrser.getText(), date1, date2, (dispocombobox.getValue()), categoser.getValue());
   if(tt == 0)
              gg.ajouter(tte,categoser.getValue().getIdCategorieService());
              gg.sendSmsvalide();
   
  
  
   
           descrser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AfficherService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
      catch(Exception e)
              {
              System.out.println(e);}
    }}

    @FXML
    private void datedeb(ActionEvent event) {
        LocalDate ld=datedebSer.getValue();
        
    }

    @FXML
    private void datefin(ActionEvent event) {
        LocalDate ld=datefebSer.getValue();
    }


    private void loadDataBaseS() {
        
       
 
        
    }

    @FXML
    private void annulerser(ActionEvent event) throws IOException {
               descrser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AfficherService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
    }
    
}
