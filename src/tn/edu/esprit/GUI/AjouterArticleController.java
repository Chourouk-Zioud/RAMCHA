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
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chourouk Zioud
 */
public class AjouterArticleController implements Initializable {
  Connection cnx = DataS.getInstance().getConnection();
    CategorieService sc = new CategorieService(cnx);
    ServiceMagasin sm = new ServiceMagasin(cnx);
    ArticleService sa = new ArticleService(cnx);
    @FXML
    private TextField NomArt;
    @FXML
    private TextField MarqArt;
    @FXML
    private TextField TypeArt;
    @FXML
    private ColorPicker CouleurArt;
    @FXML
    private TextArea FicheArtc;
    @FXML
    private TextField TailleArt;
    @FXML
    private TextArea DiscArt;
    @FXML
    private ComboBox<Magasin> MagasainSel;
    @FXML
    private ComboBox<CategorieArticle> CatSelect;
    @FXML
    private Label ErrTaille;
    @FXML
    private Label ErrMarq;
    @FXML
    private Label ErrType;
    @FXML
    private Label ErrCouleur;
    @FXML
    private Label ErrFiche;
    @FXML
    private Label ErrDiscrip;
    @FXML
    private Label ErrMagasin;
    @FXML
    private Label ErrCateg;
    @FXML
    private Label errNom;
    @FXML
    private TextField PrixArt;
    @FXML
    private Label ErrPrix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                     init();
               MagasainSel.getItems().addAll(sm.getAll());
               CatSelect.getItems().addAll(sc.getAll());
    }    

    @FXML
    private void EnrgArticl(ActionEvent event) throws IOException {
        init();
        int x = 0;
        try {
             Float tes = Float.valueOf(PrixArt.getText());
        } catch (Exception e) {
              ErrPrix.setVisible(true);
        ErrPrix.setText("Prix Non valid");
        }
       
        
        if (NomArt.getText().equals("")){
        errNom.setVisible(true);
        errNom.setText("Champ Obligatoire");
        x=1;
        }
        if (PrixArt.getText().equals("")){
        ErrPrix.setVisible(true);
        ErrPrix.setText("Champ Obligatoire");
        x=1;
        }
        if (MarqArt.getText().equals("")){
        ErrMarq.setVisible(true);
        ErrMarq.setText("Champ Obligatoire");
        x=1;
        }
        if (TypeArt.getText().equals("")){
        ErrType.setVisible(true);
        ErrType.setText("Champ Obligatoire");
        x=1;
        }
        if (CouleurArt.getValue() == null){
        ErrCouleur.setVisible(true);
        ErrCouleur.setText("Champ Obligatoire");
        x=1;
        }
        if (TailleArt.getText().equals("")){
        ErrTaille.setVisible(true);
        ErrTaille.setText("Champ Obligatoire");
        x=1;
        }
        if (FicheArtc.getText().equals("")){
        ErrFiche.setVisible(true);
        ErrFiche.setText("Champ Obligatoire");
        x=1;
        }
        if (DiscArt.getText().equals("")){
        ErrDiscrip.setVisible(true);
        ErrDiscrip.setText("Champ Obligatoire");
        x=1;
        }
        if (MagasainSel.getValue() == null){
        ErrMagasin.setVisible(true);
        ErrMagasin.setText("Champ Obligatoire");
        x=1;
        }
        if (CatSelect.getValue() == null){
        ErrCateg.setVisible(true);
        ErrCateg.setText("Champ Obligatoire");
        x=1;
        }
        if(x == 0){
        Article a = new Article(NomArt.getText(), MarqArt.getText(), TypeArt.getText(), 1, CouleurArt.getValue().toString(),Float.valueOf(PrixArt.getText()), TailleArt.getText(), DiscArt.getText(), FicheArtc.getText(), MagasainSel.getValue().getIdMagasin(),CatSelect.getValue().getIdCategorie());
        sa.ajouter(a);
         MagasainSel.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("GestionArticles.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        }
    }

    @FXML
    private void retourArtc(ActionEvent event) throws IOException {
              MagasainSel.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("GestionArticles.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
    
    void init(){
     ErrTaille.setVisible(false);
   ErrMarq.setVisible(false);
   ErrType.setVisible(false);
   ErrCouleur.setVisible(false);
   ErrFiche.setVisible(false);
   ErrDiscrip.setVisible(false);
   ErrCateg.setVisible(false);
   errNom.setVisible(false);
   ErrMagasin.setVisible(false);
   ErrPrix.setVisible(false);
    }
    
}
