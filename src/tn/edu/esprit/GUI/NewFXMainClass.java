/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.services.ServiceUtilisateur;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;

import javafx.stage.Stage;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.entities.Utilisateur;

/**
 *
 * @author chayma
 */
public class NewFXMainClass extends Application {
        static Utilisateur us = new Utilisateur();
        static ServiceUtilisateur su = new ServiceUtilisateur();
        static TableView<ServiceT> tabservice = new TableView();
        static ServiceT serrvicet = new ServiceT();
        static CategorieService modcat = new CategorieService();
        static Cours cc = new Cours();
        static AvisCours vv = new AvisCours();
        static Chapitre nam = new Chapitre();
        

    @Override
    public void start(Stage stage){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
                } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
