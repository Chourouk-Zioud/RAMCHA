/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.TypeCours;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class RecommandationController implements Initializable {

    @FXML
    private ImageView cours11;
    @FXML
    private Label name1;
    @FXML
    private VBox recommandationBox;
    @FXML
    private VBox BookBox;
    @FXML
    private Button ii;
    @FXML
    private Button imp;
    
    
    public void setData(TypeCours tc){
    Image image = new Image(getClass().getResourceAsStream(tc.getImagSrc()));
    cours11.setImage(image);
    name1.setText(tc.getName());
    
    
    
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(MouseEvent event) throws IOException {
           name1.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("Video.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
          
    }

    @FXML
    private void go(ActionEvent event) throws IOException {
            name1.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("Video.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

    @FXML
    private void Imprimer(ActionEvent event) {
        
        
        //imprimer
    }
    
}
