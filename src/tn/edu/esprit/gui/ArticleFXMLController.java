/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.*;
import tn.esprit.edu.services.*;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class ArticleFXMLController implements Initializable {

    @FXML
    private Button buttonUpdateAr;
    @FXML
    private Button buttonDeleteAr;
    @FXML
    private Button buttonAddAr;
    @FXML
    private Button buttonShowAr;
    @FXML
    private TextField TFIdArticle;
    @FXML
    private TextField TFNomArticle;
    @FXML
    private TextField TFMarqueArticle;
    @FXML
    private TextField TFDisponibilitéArticle;
    @FXML
    private TextField TFPrixArticle;
    @FXML
    private TextField TFidCategorieArticle;
    @FXML
    private TextField TFidMagasin;
    @FXML
    private TextField TFTypeArticle;
    @FXML
    private TextField TFCouleurArticle;
    @FXML
    private TextField TFtailleArticle;
    @FXML
    private TextField TFdescriptionArticle;
    @FXML
    private TextField TFficheTechnique;
    @FXML
    private TextField TFimageArticle;
    @FXML
    private TextField TFvideoArticle;
    @FXML
    private TableColumn<?, ?> COLIdArticle;
    @FXML
    private TableColumn<?, ?> COLNom;
    @FXML
    private TableColumn<?, ?> COLMarque;
    @FXML
    private TableColumn<?, ?> COLDisponibilité;
    @FXML
    private TableColumn<?, ?> COLPrix;
    @FXML
    private TableColumn<?, ?> COLidMagasin;
    @FXML
    private TableColumn<?, ?> COLidCategorie;
    @FXML
    private TableColumn<?, ?> COLType;
    @FXML
    private TableColumn<?, ?> COLCouleur;
    @FXML
    private TableColumn<?, ?> COLtaille;
    @FXML
    private TableColumn<?, ?> COLdescription;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    private void ShowArticle(ActionEvent event) {
    }
    
    @FXML
    private void AddArticle(ActionEvent event) {
        ServiceArticle sa = new ServiceArticle();
        Article a = new Article();
        a.setIdArticle(2);
        a.setNomArticle("ok");
        a.setMarqueArticle("ok");
        a.setDisponibiliteArticle(true);
        a.setPrixArticle(1111);
        a.setIdCategorieArticle(1);
        a.setIdMagasin(1);
        a.setTypeArticle("ok");
        a.setCouleurArticle("ok");
        a.setTailleArticle("ok");
        a.setDescriptionArticle("ok");
       
        sa.ajouter(a);
    }
    
    @FXML
    private void UpdateArticle(ActionEvent event) {
    }

    @FXML
    private void DeleteArticle(ActionEvent event) {
    }

}
