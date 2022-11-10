/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.services.CategorieService;
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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Chourouk Zioud
 */
public class SupprimerCategController implements Initializable {
    Connection cnx = DataS.getInstance().getConnection();
    CategorieService sc = new CategorieService(cnx);
    @FXML
    private Button ConfirmeSupp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ConfirmeSupp(ActionEvent event) throws IOException 
    {
                sc.supprimer(Main.cat.getIdCategorie());
              ConfirmeSupp.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionCategorie.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void retourSupp(ActionEvent event) throws IOException {
                  ConfirmeSupp.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionCategorie.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
}
