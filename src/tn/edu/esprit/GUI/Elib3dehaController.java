/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.services.CruSer;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class Elib3dehaController implements Initializable {

    @FXML
    private Label testlaba;
    @FXML
    private Label testlaba1;
    @FXML
    private Label local;
    @FXML
    private Label tel;
    @FXML
    private ImageView imgqrcode;
    @FXML
    private WebView infopage;
    @FXML
    private Label testlaba11;
    @FXML
    private Label local1;
    @FXML
    private Label tel1;
    @FXML
    private ImageView imgqrcode1;
    @FXML
    private WebView infopage1;
    @FXML
    private Label testlaba12;
    @FXML
    private Label local2;
    @FXML
    private Label tel2;
    @FXML
    private ImageView imgqrcode2;
    @FXML
    private WebView infopage2;
    @FXML
    private Label testlaba13;
    @FXML
    private ImageView imgqrcode3;
    @FXML
    private WebView infopage3;
    @FXML
    private Label testlaba14;
    @FXML
    private Label local4;
    @FXML
    private WebView infopage4;
    @FXML
    private Label dispo;
    @FXML
    private VBox chosenServiceCard;
    @FXML
    private Label nomappLable;
    @FXML
    private ImageView omg;
    @FXML
    private Button reser1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = "http://facebook.com";
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
        } catch (WriterException ex) {

        }
        
        imgqrcode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
    }    

   
    
    
       public void inflateUI(ServiceT service) throws FileNotFoundException, IOException {
        testlaba1.setText(service.getNomService());
        testlaba14.setText(service.getDescriptionService());
        local4.setText(String.valueOf(service.getPrixService()));
        dispo.setText(service.getDisponibiliteService());
   //     txtdes.setText(service.getTeam_Desciption());
    //    txtpass.setText(service.getPassword());
     //   Image i = new Image(team.getLogo());
     //       view.setImage(i);
      }

    @FXML
    private void reservbt(ActionEvent event) throws IOException {
                tel.getScene().getWindow().hide();;

        Parent root = FXMLLoader.load(getClass().getResource("CMDSER.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }
}
