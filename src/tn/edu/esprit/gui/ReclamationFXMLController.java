/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.edu.esprit.entities.*;
import tn.edu.esprit.services.ServiceReclamation;
import tn.edu.esprit.tools.DataSource;

/**
 * FXML Controller class
 *
 * @author chalg
 */
public class ReclamationFXMLController implements Initializable {

    @FXML
    private TextField TFrefReclamation;
    @FXML
    private Spinner<Reclamation> TFidUser;
    @FXML
    private TextField TFdateReclamation;
    @FXML
    private TextField TFobjetReclamation;
    @FXML
    private TextField TFsuiviReclamation;
    @FXML
    private TextArea TAdescriptionReclamation;
    @FXML
    private TreeTableView<Reclamation> TVRec;
    @FXML
    private TreeTableColumn<Reclamation, String> COLRefRec;
    @FXML
    private TreeTableColumn<Reclamation, Integer> COLIdUser;
    @FXML
    private TreeTableColumn<Reclamation, Date> COLDateRec;
    @FXML
    private TreeTableColumn<Reclamation, String> COLObjetRec;
    @FXML
    private TreeTableColumn<Reclamation, String> COLDescriptionRec;
    @FXML
    private TreeTableColumn<Reclamation, String> COLEtatRec;
    @FXML
    private Button buttonAddRec;
    @FXML
    private Button bottonDeleteRec;
    @FXML
    private Button buttonUpdateRec;
    @FXML
    private Button buttonShowRec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    Connection cnx ;

    public ReclamationFXMLController(){
    this.cnx= DataSource.getInstance().getConnection();
    }
    
    /*
    public ObservableList<Reclamation> getReclamationList(){
        ObservableList<Reclamation> reclamationList = FXCollections.observableArrayList();
        String req = "SELECT * FROM `reclamation`";
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs=  stm.executeQuery(req);
            Reclamation reclamation ;
            while (rs.next()){
                reclamation = new Reclamation(rs.getInt("idUser"),rs.getString("refReclamation"),rs.getString("objetReclamation"),rs.getString("descriptionReclamation"),rs.getString("suiviReclamation"),rs.getDate("dateReclamation"));
                reclamationList.add(reclamation);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        return reclamationList;
    }
    */
    
    @FXML
    public void ShowReclamation() {
        
        /*
        ObservableList<Reclamation> list = getReclamationList();
        
        COLIdUser.setCellValueFactory(new PropertyValueFactory<Reclamation,Integer>("idUser"));
        COLRefRec.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("refReclamation"));
        COLObjetRec.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("objetReclamation"));
        COLDescriptionRec.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("descriptionReclamation"));
        COLEtatRec.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("suiviReclamation"));
        COLDateRec.setCellValueFactory(new PropertyValueFactory<Reclamation,Date>("dateReclamation"));
        
        TVRec.setItems(list);  */
    }
    
    @FXML
    private void AddReclamation(ActionEvent event) {
        ServiceReclamation sr = new ServiceReclamation();
        //sr.ajouter(new Reclamation(TFidUser.getInt(),TFrefReclamation.getText(),TFobjetReclamation.getText(),TAdescriptionReclamation.getText(),TFsuiviReclamation.getText(),TFdateReclamation.getText()));
        Reclamation re = new Reclamation();
        re.setIdUser(1);
        re.setRefReclamation("ok");
        re.setObjetReclamation("ok");
        re.setDescriptionReclamation("ok");
        re.setSuiviReclamation("ok");
        re.setDateReclamation(java.sql.Date.valueOf("2013-09-04"));
        
        sr.ajouter(re);
    }

    @FXML
    private void DeleteReclamation(ActionEvent event) {
    }

    @FXML
    private void UpdateReclamation(ActionEvent event) {
    }

}



