/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.GUI;

import tn.edu.esprit.services.ServiceUtilisateur;
import tn.edu.esprit.entities.Email;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.mindrot.jbcrypt.BCrypt;
import static org.mindrot.jbcrypt.BCrypt.checkpw;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.tools.DataS;

import javafx.scene.image.ImageView;
import tn.edu.esprit.services.CommandeServices;

/**
 * FXML Controller class
 *
 * @author chayma
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane pane_login;

    @FXML
    private Button btn_insc;

    @FXML
    private TextField txt_usern;

    @FXML
    private PasswordField txt_usermp;

    @FXML
    private Button btn_login;

    @FXML
    private Label wronglog;

    @FXML
    private Label wrongLog;

    static int IdOfUser;
    @FXML
    private CheckBox check;
    @FXML
    private TextField txt_f;
    @FXML
    private Button mdpoub;
    

   
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

    }

    Connection cnx;

    public LoginController() {
        this.cnx = DataS.getInstance().getConnection();
    }

    @FXML
    private void inscrire(ActionEvent event) throws IOException {

        btn_insc.getScene().getWindow().hide();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("inscrire.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void checkLogin(ActionEvent event) throws SQLException, IOException {

        String role = null;
        if (txt_usern.getText().equals("") || txt_usermp.getText().equals("")) {
         Alert alert = new Alert (AlertType.WARNING, "Completez vos coordonnées !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();

        } else {

            ServiceUtilisateur su = new ServiceUtilisateur();
            Utilisateur ss = su.Login(txt_usern.getText());

            if (ss == null) {
                Alert alert = new Alert (AlertType.WARNING, "Verifiez vos coordonnées !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
               

            } else {
                Utilisateur u = new Utilisateur();
                System.out.print(ss.getPasswUser());
                u.setLoginUser(txt_usern.getText());
                u.setPasswUser(txt_usermp.getText());
                if (BCrypt.checkpw(u.getPasswUser(), ss.getPasswUser().replaceFirst("y", "a"))) {

                    String rep = "SELECT * FROM `utilisateur` WHERE loginUser='" + ss.getLoginUser() + "'";
                    try {
                        Statement stm = this.cnx.createStatement();
                        ResultSet rs = stm.executeQuery(rep);

                        while (rs.next()) {
                            role = rs.getString("role");
                        }
                        if (role.equals("demandeur")) {

                            btn_login.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();

                        } else if (role.equals("prestateur")) {
                            Parent root;

                            btn_login.getScene().getWindow().hide();
                            root = FXMLLoader.load(getClass().getResource("client.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();

                        } else if (role.equals("user")) {
                            Parent root;

                            btn_login.getScene().getWindow().hide();
                            root = FXMLLoader.load(getClass().getResource("client.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();

                        } else if (role.equals("admin")) {

                            Parent root;

                            btn_login.getScene().getWindow().hide();
                            root = FXMLLoader.load(getClass().getResource("dashbord.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();

                        } else {
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("Votre compte n'est pas vérifié ");
                            alert.show();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    System.out.print("problem");
                }
            }
            CommandeServices cs = new CommandeServices();
            NewFXMainClass.us = cs.selectinfouser(txt_usern.getText());
        }
        
    }

    @FXML
    private void change(ActionEvent event) {
        if (check.isSelected()) {
            txt_f.setText(txt_usermp.getText());
            txt_f.setVisible(true);
            txt_usermp.setVisible(false);
            return;
        }
        txt_usermp.setText(txt_f.getText());
        txt_usermp.setVisible(true);
        txt_f.setVisible(false);
    }

   

    @FXML
    private void pwoublier(ActionEvent event) throws SQLException {
        
        ServiceUtilisateur su = new ServiceUtilisateur();
        Utilisateur u = su.selectUser(txt_usern.getText());
        String mailFrom = "shaimahajkacem@gmail.com";////////taper adresse mail
        String password = "xbspxerfvlwteyxj"; ////////taper Mot de passe SMTP 
        String mailTo = txt_usern.getText();
        String subject = "Recupération du mot de passe";
        String message = "Votre nouveau mot de passe est : " + u.getNomUser() + u.getPrenomUser();
        Email mailer = new Email();
        try {
            mailer.sendEmail(mailFrom, password, mailTo,
                    subject, message);
            Alert alert = new Alert (AlertType.CONFIRMATION, "Consultez votre email, un nouveau mot de passe est envoyé !", javafx.scene.control.ButtonType.OK);
        alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        su.updateUser(u.getIdUser(), u);

    }

}
