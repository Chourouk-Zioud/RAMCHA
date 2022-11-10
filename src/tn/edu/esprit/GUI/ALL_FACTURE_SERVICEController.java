/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.edu.esprit.entities.Facture;
import tn.edu.esprit.entities.FactureService;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;
import tn.edu.esprit.tools.DataS;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ALL_FACTURE_SERVICEController implements Initializable {

    @FXML
    private AnchorPane anchor1;
    @FXML
    private ImageView imgser;
    @FXML
    private Label label;
    @FXML
    private TableView<FactureService> tabfactureservice;
    @FXML
    private Button retourfactureservice;
    @FXML
    private TableColumn<FactureService, Date> datefactureser;
    @FXML
    private TableColumn<FactureService, Float> totalser;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
Connection cnx = DataS.getInstance().getConnection();

        CommandeServices sd = new CommandeServices();
        ObservableList<FactureService> p = sd.getAllFactureSer();

        datefactureser.setCellValueFactory(new PropertyValueFactory<FactureService, Date>("dateFacture"));
        totalser.setCellValueFactory(new PropertyValueFactory<FactureService, Float>("totale"));

        tabfactureservice.setItems(p);
        Utilisateur us = NewFXMainClass.us;
        userinfo.setText(us.getNomUser() + " " + us.getPrenomUser());

    }    

    @FXML
    private void tabfactureserviceclick(MouseEvent event) {
    }


    @FXML
    private void retourfactureservice(ActionEvent event) throws IOException {
        label.getScene().getWindow().hide();;
                Parent root1 = FXMLLoader.load(getClass().getResource("Admincontrol.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root1);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
}
