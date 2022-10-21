/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramchaa.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
public class MenuController implements Initializable {

    @FXML
    private AnchorPane pane_menu;
    @FXML
    private Button prest;
    @FXML
    private Button dem;
    @FXML
    private TableView<Utilisateur> tvm;
    @FXML
    private TableColumn<Utilisateur, String> cid;
    @FXML
    private TableColumn<Utilisateur, String> nid;
    @FXML
    private TableColumn<Utilisateur, String> pid;
    @FXML
    private TableColumn<Utilisateur, String> did;
    @FXML
    private TableColumn<Utilisateur, String> aid;
    @FXML
    private TableColumn<Utilisateur, Integer> coid;
    
    @FXML
    private TableColumn<Utilisateur, String> lid;
    @FXML
    private TableColumn<Utilisateur, String> pasid;
    @FXML
    private TableColumn<Utilisateur, String> nuid;
    @FXML
    private Button supp;
    private TextField cina;
    private TextField noma;
    private TextField prenoma;
    private TextField datea;
    private TextField adressa;
    private TextField codepa;
    private TextField numa;
    private TextField logina;
    private TextField passa;
    @FXML
    private Button modfm;
    @FXML
    private TextField sal;
    @FXML
    private TextField po;
    @FXML
    private TextField dip;
    @FXML
    private TextField exp;
    @FXML
    private Button ajoutep;
    @FXML
    private Button ajoutd;
    @FXML
    private TextField disp;
    @FXML
    private TextField libelle;
    @FXML
    private Button dx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Connection cnx = DataR.getInstance().getConnection();
        ServiceUtilisateur su = new ServiceUtilisateur();
        ObservableList<Utilisateur> list = su.getAll();

        cid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("cinUser"));
        nid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("nomUser"));
        pid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("prenomUser"));
        did.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("ddnUser"));
        aid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("adressUser"));
        coid.setCellValueFactory(new PropertyValueFactory<Utilisateur, Integer>("codePostalUser"));
        nuid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("numUser"));
        lid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("loginUser"));
        pasid.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("passwUser"));

        System.out.println(list);

        tvm.setItems(list);
    }    

    @FXML
    private void goprest(ActionEvent event)  {
        
               prest.getScene().getWindow().hide();
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
    private void godem(ActionEvent event)  {
               dem.getScene().getWindow().hide();
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
    private void delete(ActionEvent event) {
        
        Utilisateur u = tvm.getSelectionModel().getSelectedItem();
        ServiceUtilisateur su = new ServiceUtilisateur();
        
        su.supprimer(u.getIdUser());
        
        try{
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
    private void selectionne(MouseEvent event) {
        int i = tvm.getSelectionModel().getSelectedIndex();
        if (i <= -1){
            return;
        }
        cina.setText(cid.getCellData(i).toString());
        noma.setText(nid.getCellData(i).toString());
        prenoma.setText(pid.getCellData(i).toString());
        datea.setText(did.getCellData(i).toString());       
        adressa.setText(aid.getCellData(i).toString());
       
        String a = Integer.toString(coid.getCellData(i));
        
        codepa.setText(a.toString());
        numa.setText(nuid.getCellData(i).toString());
        logina.setText(lid.getCellData(i).toString());
        passa.setText(pasid.getCellData(i).toString());
    }

    @FXML
    private void modifeiru(ActionEvent event) {
           /*  Utilisateur u = tvm.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifieru.fxml"));
        Parent root = loader.load();
        
        ModifieruController mu = loader.getController();
        mu.init(u);
        
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()) .getScene().getWindow();
        window.setScene(scene);
        window.show();
*/
    }

    @FXML
    private void ajouterp(ActionEvent event) {
        
        Utilisateur u = tvm.getSelectionModel().getSelectedItem();
        Prestateur p = new Prestateur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        p.setRole("prestateur");
        p.setSalaireP(sal.getText().toString());
        p.setPosteP(po.getText().toString());
        p.setDiplomeP(dip.getText().toString());
        p.setExperP(exp.getText().toString());
        p.setDiplomeP(dip.getText().toString());
        p.setIdUser(u.getIdUser());
        
        su.ajouterP(p);
        
        
    }

    @FXML
    private void ajouterd(ActionEvent event) {
        Utilisateur u = tvm.getSelectionModel().getSelectedItem();
        Demandeur d = new Demandeur();
        ServiceUtilisateur su = new ServiceUtilisateur();
        d.setRole("demandeur");
        d.setLibelleDemande(libelle.getText().toString());
        d.setIdUser(u.getIdUser());
        
        su.ajouterD(d);
    }

    @FXML
    private void deconnexion(ActionEvent event)  {
               dx.getScene().getWindow().hide();
               try{
              Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
               } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }

   
    
}
