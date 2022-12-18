/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.entities.Reponse;
import tn.edu.esprit.services.ServiceReclamation;
import tn.edu.esprit.services.ServiceReponse;
import tn.edu.esprit.tools.DataS;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kais Chalghoumi
 */
public class GestionReponseController implements Initializable {
  Connection cnx = DataS.getInstance().getConnection();
    ServiceReponse sr = new ServiceReponse(cnx);
    ServiceReclamation st = new ServiceReclamation(cnx);
    @FXML
    private TableView<Reponse> tabreponse;
    @FXML
    private TableColumn<Reponse, String> textrep;
    @FXML
    private TableColumn<Reponse, String> statrep;
    @FXML
    private TableColumn<Reponse, Integer> recrrep;
    @FXML
    private ComboBox<Reclamation> selReponse;
    @FXML
    private TextField searchPonse;
    @FXML
    private Label ErrSel;
    @FXML
    private Text userinfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       AfficherReclamation(sr.getAll());
         selReponse.getItems().setAll(st.getAll());
         userinfo.setText(NewFXMainClass.us.getNomUser() + " " + NewFXMainClass.us.getPrenomUser());
               }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
                        searchPonse.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("GestionReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void reoponseget(ActionEvent event) {
        {
            try {
                MainKais.rep = tabreponse.getSelectionModel().getSelectedItem();
                if (MainKais.rep != null) {
                searchPonse.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("StatusReclamation.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show(); 
                }
                else
                    ErrSel.setText("Aucun Rec Selectionnée");
            } catch(Exception ex){
            System.out.println(ex.getMessage());
            }
        }
    }

    @FXML
    private void actualiser(ActionEvent event) {
         AfficherReclamation(sr.getAll());
    }
    
    
    
     void AfficherReclamation(ObservableList<Reponse>  list){
           // ObservableList<Article>  list  = sa.getAll();
        //Idrep.setCellValueFactory(new PropertyValueFactory<Reponse, Integer>("idReponse"));
        textrep.setCellValueFactory(new PropertyValueFactory<Reponse, String>("Text"));
        statrep.setCellValueFactory(new PropertyValueFactory<Reponse, String>("status"));
        recrrep.setCellValueFactory(new PropertyValueFactory<Reponse, Integer>("idReclamation"));
        
        tabreponse.setItems(list);
        FilteredList<Reponse> filteredData = new FilteredList<>(list, b -> true);
		searchPonse.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(m -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (m.getText().toLowerCase().contains(lowerCaseFilter) ) {
					return true; }
                                else if (m.getStatus().toLowerCase().contains(lowerCaseFilter)) {
					return true;}
                            
				else return String.valueOf(m.getIdReclamation()).contains(lowerCaseFilter); // Does not match.           
	});
		});
                SortedList<Reponse> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(tabreponse.comparatorProperty());
		
		tabreponse.setItems(sortedData);
    
    }
    
}


    
