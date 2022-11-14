/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import model.TypeCours;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CardController implements Initializable {

    @FXML
    private HBox box;
    @FXML
    private ImageView imagSrc;
    @FXML
    private Label name;
    private String []colors = {"B9E5FF","BDB2FE","FB9AA8","FF5056"};
    
    public void setData(TypeCours tc){
       Image image= new Image(getClass().getResourceAsStream(tc.getImagSrc())) ;
                  imagSrc.setImage(image);
                  name.setText(tc.getName());
        box.setStyle("-fx-background-color: #"+ colors[(int)(Math.random()*colors.length)]+";" + " -fx-background-radius: 15;" + "-fx-effect: dropShadown(three-pass-box, rgba(0,0,0,0.1),10,0 ,0 ,10);");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
    