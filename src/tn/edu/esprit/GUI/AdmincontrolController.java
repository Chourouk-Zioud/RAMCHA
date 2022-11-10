/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdmincontrolController implements Initializable {

    @FXML
    private AnchorPane anchor1;
    @FXML
    private ImageView imgser;
    @FXML
    private Button adminarticlelist;
    @FXML
    private Button adminfacturearticlelist;
    @FXML
    private Button adminservicelist;
    @FXML
    private Button adminservicefacturelist;
    @FXML
    private Button devisdevisA3;
    @FXML
    private Label label;
    @FXML
    private Text traitementarticle;
    @FXML
    private Text livraisonarticle;
    @FXML
    private Text traiteearticle;
    @FXML
    private Text traitementservice;
    @FXML
    private Text livraisonservice;
    @FXML
    private Text traiteeservice;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CommandeServices cs = new CommandeServices();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
       
        traitementarticle.setText(""+cs.calculCommandeArticleTraitement(a));
        livraisonarticle.setText(""+cs.calculCommandeArticleLivraison(b));
        traiteearticle.setText(""+cs.calculCommandeArticleTraitee(c));
        traitementservice.setText(""+cs.calculCommandeServiceTraitement(d));
        livraisonservice.setText(""+cs.calculCommandeServiceLivraison(e));
        traiteeservice.setText(""+cs.calculCommandeServiceTraitee(f));
        Utilisateur us = NewFXMainClass.us;
        System.out.println(us);
        userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());

    }

    @FXML
    private void openlistarticle(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("ALL_LIST_ARTICLE.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void openfacturearticle(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("ALL_FACTURE_ARTICLE.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void openservicelist(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("ALL_LIST_SERVICE.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void openfactureservice(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("ALL_FACTURE_SERVICE.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();

    }

    @FXML
    private void retouradmindash(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
        Parent root = FXMLLoader.load(getClass().getResource("dashbord.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

}
