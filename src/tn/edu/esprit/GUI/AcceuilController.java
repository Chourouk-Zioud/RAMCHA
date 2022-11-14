/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.services.ServiceUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.BURLYWOOD;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class AcceuilController implements Initializable {

    private BarChart<String, Integer> chart;
    private Button x;
    @FXML
    private Button service_cours;
    @FXML
    private Button service_chapitre;
    @FXML
    private Button sevice_avis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int a =0;
        int b =0;
        int c =0;
        ServiceUtilisateur su = new ServiceUtilisateur();
        a= su.countu(a);
        
        b= su.countp(b);
        
        c= su.countd(c);
        

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Utilisateur");       
        series1.getData().add(new XYChart.Data("", a));
             
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Prestateur");
        series2.getData().add(new XYChart.Data("", b));
        
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Demandeur");
        series3.getData().add(new XYChart.Data("", c));
        
        chart.getData().addAll(series1, series2, series3);
        chart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");
    }    

    private void retourstat(ActionEvent event) {
             x.getScene().getWindow().hide();
      
       
        
    }

    @FXML
    private void service_courss(ActionEvent event) {
    }

    @FXML
    private void service_chapitres(ActionEvent event) {
    }

    @FXML
    private void service_aviss(ActionEvent event) {
    }
    
}
