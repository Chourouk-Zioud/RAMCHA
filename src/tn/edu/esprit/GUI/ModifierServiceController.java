/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.services.CruCat;
import tn.edu.esprit.services.CruSer;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class ModifierServiceController implements Initializable {
CruCat cccr = new CruCat();
                CruSer gg=new CruSer();
                    private ComboBox<CategorieService> categoser;
    ObservableList<CategorieService> list=cccr.getAll();
    @FXML
    private TextField txtNomService;
    @FXML
    private TextField txtPrixServ;
      ObservableList<String> list1=FXCollections.observableArrayList("1","2","3","4","5","6","7","8");
    @FXML
    private ComboBox<String> nbrOuvSer;
    @FXML
    private DatePicker dateDebSer;
    @FXML
    private DatePicker DateFinSr;
    @FXML
    private TextArea DescripSer;
    @FXML
    private ComboBox<CategorieService> CategBox;
    @FXML
    private Label err_nom_ser_modifier;
    @FXML
    private Label err_prix__service_modifier;
    @FXML
    private Label err_nbre_ouvrier_modifier;
    @FXML
    private Label err_datedebut_modifier;
    @FXML
    private Label err_datefin_modifier;
    @FXML
    private Label err_disponibilite_modifier;
    @FXML
    private Label err_categorie_modifier;
    @FXML
    private Button annul_mod_ser;
    @FXML
    private VBox chosenServiceCard;
    @FXML
    private Label nomappLable;
    @FXML
    private ImageView omg;
    @FXML
    private ComboBox<String> dispocombo2;
    ObservableList<String> list6=FXCollections.observableArrayList("Disponible","Non-disponible");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          CategBox.setItems(list);
  nbrOuvSer.setItems(list1);
  dispocombo2.setItems(list6);
  
  txtNomService.setText(NewFXMainClass.serrvicet.getNomService());
  txtPrixServ.setText(String.valueOf(NewFXMainClass.serrvicet.getPrixService()));
  DescripSer.setText(NewFXMainClass.serrvicet.getDescriptionService());
  nbrOuvSer.setValue(String.valueOf(NewFXMainClass.serrvicet.getNbreOuvrier()));
  CategorieService c = cccr.getOne(NewFXMainClass.serrvicet.getIdCategorieService());
        System.out.println(c);
  //dateDebSer.setValue(LocalDate.of(Main.modSer.getDateDebutService().getYear(),Main.modSer.getDateDebutService().getMonth(),Main.modSer.getDateDebutService().getDay()));
          CategBox.setValue(c);
          err_nom_ser_modifier.setVisible(false);
           err_prix__service_modifier.setVisible(false);
            err_nbre_ouvrier_modifier.setVisible(false); 
            err_datedebut_modifier.setVisible(false);
            err_datefin_modifier.setVisible(false); 
            err_disponibilite_modifier.setVisible(false); 
            err_categorie_modifier.setVisible(false); 

    }    

    @FXML
    private void EnrgModifier(ActionEvent event) throws IOException {
         if (txtNomService.getText().isEmpty()|| txtPrixServ.getText().isEmpty() ||
                 nbrOuvSer.getValue().isEmpty() || DescripSer.getText().isEmpty() || CategBox.getValue().equals(0) || dateDebSer.getValue().equals(0) ||  DateFinSr.getValue().equals(0)){
        err_nom_ser_modifier.setVisible(true);
        err_prix__service_modifier.setVisible(true);
        err_nbre_ouvrier_modifier.setVisible(true);
        err_datedebut_modifier.setVisible(true);
        err_datefin_modifier.setVisible(true);
        err_disponibilite_modifier.setVisible(true);
        err_categorie_modifier.setVisible(true);
    }
     else {
           try{
     ServiceT tte = new ServiceT(NewFXMainClass.serrvicet.getIdService(),txtNomService.getText(), Integer.parseInt(nbrOuvSer.getValue()), Float.parseFloat(txtPrixServ.getText()), DescripSer.getText(), NewFXMainClass.serrvicet.getDateDebutService(), NewFXMainClass.serrvicet.getDateFinService(), (dispocombo2.getValue()), CategBox.getValue().getIdCategorieService());
                        gg.modifier(tte);
        nbrOuvSer.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AfficherService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
    catch(Exception e)
              {        err_nom_ser_modifier.setVisible(true);
               System.out.println(e);

              }
    
}
    }

    @FXML
    private void annul_mod_ser2(ActionEvent event) throws IOException {
         txtNomService.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AfficherService.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }




}
