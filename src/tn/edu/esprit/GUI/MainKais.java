/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Avis;
import tn.edu.esprit.entities.Reclamation;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Reponse;

/**
 *
 * @author Kais Chalghoumi
 */
public class MainKais extends Application {
    static Reclamation rec = new Reclamation();
    static Avis avis = new Avis();
    static Reponse rep = new Reponse();
    static String role;
    @Override
    public void start(Stage stage) throws IOException {
   Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
