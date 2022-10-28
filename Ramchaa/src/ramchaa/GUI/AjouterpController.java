/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramchaa.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class AjouterpController implements Initializable {

    @FXML
    private TextField salaire;
    @FXML
    private TextField poste;
    @FXML
    private TextField diplome;
    @FXML
    private TextField exper;
    @FXML
    private TextField dispo;
    @FXML
    private Button ajoutp;
    @FXML
    private Button annuleraj;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterp(ActionEvent event) {
        
    }

    @FXML
    private void annulerajout(ActionEvent event)  {
                
        annuleraj.getScene().getWindow().hide();
        try {
              Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        }  catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
