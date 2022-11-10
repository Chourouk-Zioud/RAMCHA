/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import tn.edu.esprit.services.ServiceUtilisateur;
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class DashbordController implements Initializable {

    @FXML
    private LineChart<String, Integer> lineChart;
    @FXML
    private PieChart piechart;
    @FXML
    private Label lu;
    @FXML
    private Label lp;
    @FXML
    private Label ld;
    @FXML
    private Button da;
    @FXML
    private Button dastat;
    @FXML
    private Button dadec;
    @FXML
    private Button gocmdadmin;
    @FXML
    private Button goadminservice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      iniLineChart();
      iniPieChart();
       int a =0;
        int b =0;
        int c =0;
        ServiceUtilisateur su = new ServiceUtilisateur();
        a= su.countu(a);
        lu.setText(""+a);
        b= su.countp(b);
        lp.setText(""+b);
        c= su.countd(c);
        ld.setText(""+c);
    }    
    
    
    
    private void iniLineChart(){
          XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("Lundi",19));
        series.getData().add(new XYChart.Data("Mardi",10));
        series.getData().add(new XYChart.Data("Mercredi",16));
        series.getData().add(new XYChart.Data("Jeudi",18));
        series.getData().add(new XYChart.Data("Vendredi",11));
        series.getData().add(new XYChart.Data("Samedi",9));
        series.getData().add(new XYChart.Data("Dimanche",9));
        lineChart.getData().addAll(series);
        lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color: transparent;");
        series.getNode().setStyle("-fx-stroke: #556B2F");
    }
    
    private void iniPieChart(){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Services",40),
        new PieChart.Data("Articles",30),
        new PieChart.Data("Formations",20),
        new PieChart.Data("Livraison",10)
         
        );
        
        piechart.setData(pieChartData);
        
        
    }

    @FXML
    private void stat(ActionEvent event) {
              
        try {
            Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void decon(ActionEvent event) {
              dadec.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void menu(ActionEvent event) {
               da.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gocmdadmin(ActionEvent event) {
                       da.getScene().getWindow().hide();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Admincontrol.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void goadminservice(ActionEvent event) {
         da.getScene().getWindow().hide();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherService.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gotoformations(ActionEvent event) {
        da.getScene().getWindow().hide();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("Acceuil1.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void gomagasin(ActionEvent event) throws IOException {
        da.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("GestionMagasin.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    private void goreclamation(ActionEvent event) throws IOException {
        da.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
        Stage mainStage = new Stage();
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
