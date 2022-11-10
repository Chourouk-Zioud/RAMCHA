/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.services.CruCat;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class ModifierCategorieServiceController implements Initializable {
    CruCat ccccr = new CruCat();
  

    @FXML
    private TextField nomcatser;
    @FXML
    private TextArea desccatser;
    @FXML
    private Button enregcat;
    @FXML
    private Label err_nom_cat_service;
    @FXML
    private Label err_desc_cat_service;
    @FXML
    private Button annul_mod3;
    @FXML
    private VBox chosenServiceCard;
    @FXML
    private Label nomappLable;
    @FXML
    private ImageView omg;

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         err_nom_cat_service.setVisible(false);
           err_desc_cat_service.setVisible(false);
        desccatser.setText(NewFXMainClass.modcat.getDescriptionCategorieService());
    nomcatser.setText(NewFXMainClass.modcat.getNomCategorieService());
  desccatser.setText(String.valueOf(NewFXMainClass.modcat.getDescriptionCategorieService()));
         
    }    

    @FXML
    private void enregcatser(ActionEvent event) throws IOException {
         if (nomcatser.getText().isEmpty()|| desccatser.getText().isEmpty() ){
        err_nom_cat_service.setVisible(true);
        err_desc_cat_service.setVisible(true);
        
    }
     else {
           try{
        
        CategorieService ttte = new CategorieService(NewFXMainClass.modcat.getIdCategorieService(),nomcatser.getText(),desccatser.getText());
        ccccr.modifier(ttte);
        nomcatser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCatégorieService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }catch(Exception e)
              {        err_nom_cat_service.setVisible(true);
               System.out.println(e);

              }
    
}}

    @FXML
    private void annul_mod_cat_ser(ActionEvent event) throws IOException {
          nomcatser.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCatégorieService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
}
