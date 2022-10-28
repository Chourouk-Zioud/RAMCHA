/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramchaa.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tn.ramcha.esprit.entities.Prestateur;
import tn.ramcha.esprit.entities.Utilisateur;
import tn.ramcha.esprit.services.ServiceUtilisateur;
import tn.ramcha.esprit.tools.DataR;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class PrestateurController implements Initializable {

    @FXML
    private Button retourp;
    @FXML
    private TableColumn<Prestateur, String> cp;
    @FXML
    private TableColumn<Prestateur, String> npp;
    @FXML
    private TableColumn<Prestateur, String> pp;
    @FXML
    private TableColumn<Prestateur, String> dp;
    @FXML
    private TableColumn<Prestateur, String> ap;
    @FXML
    private TableColumn<Prestateur, Integer>cpp;
    @FXML
    private TableColumn<Prestateur, String> nump;
    @FXML
    private TableColumn<Prestateur, String>lp;
    @FXML
    private TableColumn<Prestateur, String>pasp;
    @FXML
    private TableColumn<Prestateur, String> sp;
    @FXML
    private TableColumn<Prestateur, String>pop;
    @FXML
    private TableColumn<Prestateur, String> exp;
    @FXML
    private TableColumn<Prestateur, String>dip;
    @FXML
    private TableView<Prestateur> vp;
    @FXML
    private TableColumn<Prestateur, String> dap;
    @FXML
    private Button supp;
    @FXML
    private Button modifp;
    @FXML
    private TextField ssm;
    @FXML
    private TextField dism;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Connection cnx = DataR.getInstance().getConnection();
        ServiceUtilisateur su = new ServiceUtilisateur();
        ObservableList<Prestateur> list = (ObservableList<Prestateur>) su.getAllP();

        cp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("cinUser"));
        npp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("nomUser"));
        pp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("prenomUser"));
        dap.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("ddnUser"));
        ap.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("adressUser"));
        cpp.setCellValueFactory(new PropertyValueFactory<Prestateur, Integer>("codePostalUser"));
        nump.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("numUser"));
        lp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("loginUser"));
        pasp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("passwUser"));
        sp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("salaireP"));
        pop.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("posteP"));
        dp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("diplomeP"));
        exp.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("experP"));
        dip.setCellValueFactory(new PropertyValueFactory<Prestateur, String>("dispoP"));
        
        System.out.println(list);
        
        vp.setItems(list);
    }    

    @FXML
    private void retourP(ActionEvent event)  {
        
        retourp.getScene().getWindow().hide();
        try {
              Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }
         catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void supprimerp(ActionEvent event)  {
        Utilisateur u = vp.getSelectionModel().getSelectedItem();
        ServiceUtilisateur su = new ServiceUtilisateur();
        
        su.supprimer(u.getIdUser());
        try{
        Parent root = FXMLLoader.load(getClass().getResource("Prestateur.fxml"));
               Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
     
    }


    @FXML
    private void modiferp(ActionEvent event) {
        Utilisateur u = vp.getSelectionModel().getSelectedItem();
        Prestateur p = new Prestateur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        p.setRole("prestateur");
        
      p.setDispoP(dism.getText().toString());
        p.setSalaireP(ssm.getText().toString());
        p.setIdUser(u.getIdUser());
        
        su.modifierP(p);
    }
    
}
