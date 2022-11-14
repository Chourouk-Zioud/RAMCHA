/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.services.CruCat;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class AjouterCatégorieController implements Initializable {
CruCat bb=new CruCat();
    @FXML
    private TextField nomcat;
    @FXML
    private TextArea descrcat;
    @FXML
    private Button ajocat;
    @FXML
    private Button annu_cat;
    @FXML
    private Label err_nomcat_ser;
    @FXML
    private Label nomcatser;
    @FXML
    private Label err_desc_catser;
    @FXML
    private VBox chosenServiceCard;
    @FXML
    private Label nomappLable;
    @FXML
    private ImageView omg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        err_nomcat_ser.setVisible(false);
           err_desc_catser.setVisible(false);
    }
         ObservableList<CategorieService> listeCategorie = FXCollections.observableArrayList();
       

    @FXML
    private void ajouter_cat(ActionEvent event) throws IOException {
        if (nomcat.getText().isEmpty()|| descrcat.getText().isEmpty() ){
        err_nomcat_ser.setVisible(true);
        err_desc_catser.setVisible(true);
        
    }
     else {
           try{
        
        
        CategorieService ccccs = new CategorieService(nomcat.getText(),descrcat.getText());
        bb.ajoutercate(ccccs);
        nomcat.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AffichageCatégorieService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }   catch(Exception e)
              {        nomcatser.setVisible(true);
               System.out.println(e);

              }}}

    private void loadDataBaseS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void annulercat(ActionEvent event) throws IOException {
        nomcat.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AffichageCatégorieService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }
    
}
