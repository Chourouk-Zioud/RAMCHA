/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

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
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;

/**
 *
 * @author asus
 */
public class NewFXMain extends Application {
    
  static  Cours cc = new Cours();
   static Chapitre nam = new Chapitre();
   static AvisCours vv = new AvisCours();
   
     
     @Override
    public void start(Stage stage) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("AcceuilUtilisateur.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) { 
        launch(args);
    }
    
}
