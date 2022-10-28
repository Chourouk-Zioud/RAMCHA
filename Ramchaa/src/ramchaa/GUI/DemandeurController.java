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
import tn.ramcha.esprit.entities.Demandeur;
import tn.ramcha.esprit.entities.Prestateur;
import tn.ramcha.esprit.entities.Utilisateur;
import tn.ramcha.esprit.services.ServiceUtilisateur;
import tn.ramcha.esprit.tools.DataR;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class DemandeurController implements Initializable {

    @FXML
    private Button retourd;

    @FXML
    private TableView<Demandeur> tabvd;
    @FXML
    private TableColumn<Demandeur, String> cind;
    @FXML
    private TableColumn<Demandeur, String> nomd;
    @FXML
    private TableColumn<Demandeur, String> prenomd;
    @FXML
    private TableColumn<Demandeur, String> dated;
    @FXML
    private TableColumn<Demandeur, String> addd;
    @FXML
    private TableColumn<Demandeur, Integer> postd;
    @FXML
    private TableColumn<Demandeur, String> numd;
    @FXML
    private TableColumn<Demandeur, String> logind;
    @FXML
    private TableColumn<Demandeur, String> passwd;
    @FXML
    private TableColumn<Demandeur, String> libd;
    @FXML
    private Button suppd;
    @FXML
    private Button mod;
    @FXML
    private TextField ml;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection cnx = DataR.getInstance().getConnection();
        ServiceUtilisateur su = new ServiceUtilisateur();
        ObservableList<Demandeur> list = (ObservableList<Demandeur>) su.getAllD();

        cind.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("cinUser"));
        nomd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("nomUser"));
        prenomd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("prenomUser"));
        dated.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("ddnUser"));
        addd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("adressUser"));
        postd.setCellValueFactory(new PropertyValueFactory<Demandeur, Integer>("codePostalUser"));
        numd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("numUser"));
        logind.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("loginUser"));
        passwd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("passwUser"));
        libd.setCellValueFactory(new PropertyValueFactory<Demandeur, String>("libelleDemande"));
        
        System.out.println(list);

        tabvd.setItems(list);
    }    

    @FXML
    private void retourD(ActionEvent event)  {
                retourd.getScene().getWindow().hide();
                try {
              Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void deleteD(ActionEvent event)  {
                Utilisateur u = tabvd.getSelectionModel().getSelectedItem();
        ServiceUtilisateur su = new ServiceUtilisateur();
        
        su.supprimer(u.getIdUser());
        try{
        Parent root = FXMLLoader.load(getClass().getResource("demandeur.fxml"));
               Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
     
       
    }


    @FXML
    private void modifierD(ActionEvent event) throws IOException {
        Utilisateur u =  tabvd.getSelectionModel().getSelectedItem();
        Demandeur d = new Demandeur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        d.setIdUser(u.getIdUser());
        System.out.println(u.getIdUser());
        d.setLibelleDemande(ml.getText().toString());
        su.modifierD(d);
        
        Parent root = FXMLLoader.load(getClass().getResource("demandeur.fxml"));
               Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    
}
