/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import java.io.File;
import java.io.IOException;
import static java.lang.ProcessBuilder.Redirect.to;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import static javafx.scene.input.KeyCode.C;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class VideoController implements Initializable {

      private String path;
      private MediaPlayer mediaPlayer;
      
      @FXML
      private MediaView mediaView;
    @FXML
    private Button lireVideo;
    @FXML
    private Button pauseVideo;
    @FXML
    private Button stopvideo;
    @FXML
    private Button speedVideo;
    @FXML
    private Button slowVedio;
    @FXML
    private Button backVideo;
    @FXML
    private Button skipvideo;
      @FXML
    private Slider progressBar;
       @FXML
    private Slider volumeSlider;
          @FXML
    private Button ret;
      
    @FXML
      public void choisir(ActionEvent event){
    //   FileChooser fileChooser = new FileChooser(); 
     //  File file = fileChooser.showOpenDialog(null);
     //  System.out.println(file);
   
       
       
      }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File file =  new File("D:\\Ramcha\\ramcha\\RamchaCommande\\src\\tn\\edu\\esprit\\GUI\\vd.mp4");

       path = file.toURI ().toString(); //"C:/Users/asus/Downloads/vd";     
        System.out.println(path);
        // System.out.println(path);
       if(path != null){
         Media media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        
        DoubleProperty widthProp = mediaView.fitWidthProperty();
        DoubleProperty heightProp = mediaView.fitHeightProperty();
        
        widthProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        heightProp.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        
          volumeSlider.setValue(mediaPlayer.getVolume()*100);
            volumeSlider.valueProperty().addListener((Observable observable) -> {
                mediaPlayer.setVolume(volumeSlider.getValue()/100);
         });
            /* @Override
             public void invalidated(Observable observable) {
                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             }
            });*/
         mediaPlayer.currentTimeProperty().addListener((ObservableValue<? extends javafx.util.Duration> observable, javafx.util.Duration oldValue, javafx.util.Duration newValue) -> {
             progressBar.setValue(newValue.toSeconds());
         } /* @Override
         public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
         }*/ );
        progressBar.setOnMousePressed((MouseEvent event1) -> {
            mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
         }); 
        progressBar.setOnMouseDragged((MouseEvent event1) -> {
            mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
         });
                       mediaPlayer.setOnReady(() -> {
                           javafx.util.Duration total = media.getDuration();
                           progressBar.setMax(total.toSeconds());
         }); 
          
            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    javafx.util.Duration total = media.getDuration();
                    progressBar.setMax(total.toSeconds());
                }
            });
        
        mediaPlayer.play();
       
       }
        
       
    }    

    @FXML
    private void lire(ActionEvent event) {
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }

    @FXML
    private void pause(ActionEvent event) {
        mediaPlayer.pause();
    }

    @FXML
    private void stop(ActionEvent event) {
        mediaPlayer.stop();
    }

    @FXML
    private void speed(ActionEvent event) {
        mediaPlayer.setRate(0.5);
    }

    @FXML
    private void slow(ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    @FXML
    private void back10(ActionEvent event) {
         mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-10)));
        
    }

    @FXML
    private void skip10(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(10)));
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
         
              lireVideo.getScene().getWindow().hide();
              Parent root = FXMLLoader.load(getClass().getResource("AcceuilUtilisateur.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
    }

  
    
}
