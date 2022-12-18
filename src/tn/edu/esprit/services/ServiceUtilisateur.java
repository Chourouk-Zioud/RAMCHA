package tn.edu.esprit.services;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.net.PasswordAuthentication;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.xml.bind.DatatypeConverter;
import org.mindrot.jbcrypt.BCrypt;
import tn.edu.esprit.entities.Admin;
import tn.edu.esprit.entities.Demandeur;
import tn.edu.esprit.entities.Prestateur;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.ServicesU;
import tn.edu.esprit.tools.DataS;

public class ServiceUtilisateur implements ServicesU<Utilisateur, Prestateur, Demandeur, Admin> {

    Connection cnx;

    public ServiceUtilisateur() {
        this.cnx = DataS.getInstance().getConnection();
    }

   /* @Override
    public void ajouter(Utilisateur u) {
        try {
            String req = "INSERT INTO `utilisateur`(`idUser`,`cinUser`,`nomUser`,`prenomUser`,`ddnUser`,`adressUser`,`codePostalUser`,`numUser`,`loginUser`,`passwUser`) VALUES (" + u.getIdUser() + ",'" + u.getCinUser() + "','" + u.getNomUser()
                    + "','" + u.getPrenomUser() + "','" + u.getDdnUser() + "','" + u.getAdressUser() + "'," + u.getCodePostalUser() + ",'" + u.getNumUser() + "','" + u.getLoginUser() + "','" + u.getPasswUser() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Utilisateur ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    
    @Override
    public void ajouter(Utilisateur u) {
        try {
            String req = "INSERT INTO `utilisateur`(`idUser`,`cinUser`,`nomUser`,`prenomUser`,`ddnUser`,`adressUser`,`codePostalUser`,`numUser`,`loginUser`,`passwUser`,`image_name`) VALUES (" + u.getIdUser() + ",'" + u.getCinUser() + "','" + u.getNomUser()
                    + "','" + u.getPrenomUser() + "','" + u.getDdnUser() + "','" + u.getAdressUser() + "'," + u.getCodePostalUser() + ",'" + u.getNumUser() + "','" + u.getLoginUser() + "','" + u.getPasswUser()+ "','" + u.getImage()+ "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Utilisateur ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Utilisateur u) {
        try {
            String req = "UPDATE Utilisateur SET cinUser=?, nomUser=?, prenomUser=?, ddnUser=?, adressUser=?, codePostalUser=? , numUser=? , loginUser=? , passwUser=?    where idUser=" + u.getIdUser();
            PreparedStatement stm = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete

            stm.setString(1, u.getCinUser());
            stm.setString(2, u.getNomUser());
            stm.setString(3, u.getPrenomUser());
            stm.setDate(4, u.getDdnUser());
            stm.setString(5, u.getAdressUser());
            stm.setInt(6, u.getCodePostalUser());
            stm.setString(7, u.getNumUser());
            stm.setString(8, u.getLoginUser());
            stm.setString(9, u.getPasswUser());

            stm.executeUpdate();
            System.out.println("Utilisateur modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        

    @Override
    public void modifierSd(Utilisateur u) {
        try {
            String req = "UPDATE Utilisateur SET cinUser=?, nomUser=?,prenomUser=?, adressUser=?, codePostalUser=? , numUser=? , loginUser=? , passwUser=?    where idUser=" + u.getIdUser();
            PreparedStatement stm = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete

            stm.setString(1, u.getCinUser());
            stm.setString(2, u.getNomUser());
            stm.setString(3, u.getPrenomUser());
            stm.setString(5, u.getAdressUser());
            stm.setInt(6, u.getCodePostalUser());
            stm.setString(7, u.getNumUser());
            stm.setString(8, u.getLoginUser());
            stm.setString(9, u.getPasswUser());

            stm.executeUpdate();
            System.out.println("Utilisateur modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        

    @Override
    public void modifierSpw(Utilisateur u) {
        try {
            String req = "UPDATE Utilisateur SET cinUser=?, nomUser=?, prenomUser=?, ddnUser=?, adressUser=?, codePostalUser=? , numUser=?  where idUser=" + u.getIdUser();
            PreparedStatement stm = cnx.prepareStatement(req);

            stm.setString(1, u.getCinUser());
            stm.setString(2, u.getNomUser());
            stm.setString(3, u.getPrenomUser());
            stm.setDate(4, u.getDdnUser());
            stm.setString(5, u.getAdressUser());
            stm.setInt(6, u.getCodePostalUser());
            stm.setString(7, u.getNumUser());
            

            stm.executeUpdate();
            System.out.println("Utilisateur modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    java.util.Scanner entree = new java.util.Scanner(System.in);

    @Override
    public void modifierRole(Utilisateur u) {
        try {
            String req = "UPDATE `utilisateur` SET `role`=? WHERE idUser=" + u.getIdUser();
            PreparedStatement stm = cnx.prepareStatement(req);
            Scanner sc = new Scanner(System.in);
            String r = entree.next();
            stm.setString(1, r);
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void ajouterP(Prestateur p) {

        try {
            String rep = "SELECT role FROM `utilisateur`  WHERE idUser=" + p.getIdUser();
            Statement stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                String role = rs.getString("role");
                if (p.getRole() == ("prestateur")) {
                    String req = "UPDATE utilisateur SET salaireP='" + p.getSalaireP() + "' ,posteP='" + p.getPosteP() + "' ,diplomeP='" + p.getDiplomeP() + "' ,experP='" + p.getExperP() + "' ,dispoP='" + p.getDispoP() + ",' ,role='" + p.getRole() + "' WHERE idUser=" + p.getIdUser();
                    PreparedStatement st = cnx.prepareStatement(req);
                    st.executeUpdate(req);
                    System.out.println("Prestateur ajouté avec succées");
                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifierP(Prestateur p) {
        try {
            String rep = "SELECT role FROM `utilisateur` WHERE role='prestateur'";
            Statement stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                String role = rs.getString("role");
                if (role.equals("prestateur")) {
                    String req = "UPDATE utilisateur SET salaireP=?, posteP=?, diplomeP=?, experP=?, dispoP=? WHERE idUser=" + p.getIdUser();
                    PreparedStatement st = cnx.prepareStatement(req);
                    //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete

                    st.setString(1, p.getSalaireP());
                    st.setString(2, p.getPosteP());
                    st.setString(3, p.getDiplomeP());
                    st.setString(4, p.getExperP());
                    st.setString(5, p.getDispoP());
                    st.executeUpdate();
                    System.out.println("Prestateur modifié avec succés");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(int id) {
        try {

            String req = "DELETE FROM `utilisateur` WHERE idUser=" + id + "";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Utilisateur supprimé avec succés!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Utilisateur getOne(int id) {

        String rep = "SELECT * FROM `utilisateur` WHERE idUser=" + id;
        Utilisateur util = new Utilisateur();
        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                util.setIdUser(rs.getInt("idUser"));
                util.setCinUser(rs.getString("cinUser"));
                util.setNomUser(rs.getString("nomUser"));
                util.setPrenomUser(rs.getString("prenomUser"));
                util.setDdnUser(rs.getDate("ddnUser"));
                util.setAdressUser(rs.getString("adressUser"));
                util.setCodePostalUser(rs.getInt("codePostalUser"));
                util.setNumUser(rs.getString("numUser"));
                util.setLoginUser(rs.getString("loginUser"));
                util.setPasswUser(rs.getString("passwUser"));

            }

            System.out.println(util);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return util;
    }

    @Override
    public ObservableList getAll() {
        String rep = "SELECT * FROM `utilisateur`";
        ObservableList<Utilisateur> utilisateurs = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Utilisateur uu = new Utilisateur();
                uu.setIdUser(rs.getInt("idUser"));
                uu.setCinUser(rs.getString("cinUser"));
                uu.setNomUser(rs.getString("nomUser"));
                uu.setPrenomUser(rs.getString("prenomUser"));
                uu.setDdnUser(rs.getDate("ddnUser"));
                uu.setAdressUser(rs.getString("adressUser"));
                uu.setCodePostalUser(rs.getInt("codePostalUser"));
                uu.setNumUser(rs.getString("numUser"));
                uu.setLoginUser(rs.getString("loginUser"));
                uu.setPasswUser(rs.getString("passwUser"));
                uu.setImage(rs.getString("image_name"));

                utilisateurs.add(uu);
                System.out.println(uu + "\n");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return utilisateurs;
    }

    @Override
    public List<Prestateur> getAllP() {
        String rep = "SELECT * FROM `utilisateur`";
        ObservableList<Prestateur> prestateurs = FXCollections.observableArrayList();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {

                String role = rs.getString("role");
                if (role.equals("prestateur")) {
                    Prestateur pp = new Prestateur();
                    pp.setIdUser(rs.getInt("idUser"));
                    pp.setCinUser(rs.getString("cinUser"));
                    pp.setNomUser(rs.getString("nomUser"));
                    pp.setPrenomUser(rs.getString("prenomUser"));
                    pp.setDdnUser(rs.getDate("ddnUser"));
                    pp.setAdressUser(rs.getString("adressUser"));
                    pp.setCodePostalUser(rs.getInt("codePostalUser"));
                    pp.setNumUser(rs.getString("numUser"));
                    pp.setLoginUser(rs.getString("loginUser"));
                    pp.setPasswUser(rs.getString("passwUser"));

                    pp.setSalaireP(rs.getString("salaireP"));
                    pp.setPosteP(rs.getString("posteP"));
                    pp.setDiplomeP(rs.getString("diplomeP"));
                    pp.setExperP(rs.getString("experP"));
                    pp.setDispoP(rs.getString("dispoP"));

                    prestateurs.add(pp);
                    System.out.println("Prestateur : " + pp);

                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prestateurs;

    }

    @Override
    public Prestateur getOneP(int id) {

        String rep = "SELECT * FROM `utilisateur` WHERE idUser=" + id;
        Prestateur p = new Prestateur();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {

                String role = rs.getString("role");
                if (role.equals("prestateur")) {

                    p.setIdUser(rs.getInt("idUser"));
                    p.setCinUser(rs.getString("cinUser"));
                    p.setNomUser(rs.getString("nomUser"));
                    p.setPrenomUser(rs.getString("prenomUser"));
                    p.setDdnUser(rs.getDate("ddnUser"));
                    p.setAdressUser(rs.getString("adressUser"));
                    p.setCodePostalUser(rs.getInt("codePostalUser"));
                    p.setNumUser(rs.getString("numUser"));
                    p.setLoginUser(rs.getString("loginUser"));
                    p.setPasswUser(rs.getString("passwUser"));
                    p.setSalaireP(rs.getString("salaireP"));
                    p.setPosteP(rs.getString("posteP"));
                    p.setDiplomeP(rs.getString("diplomeP"));
                    p.setExperP(rs.getString("experP"));
                    p.setDispoP(rs.getString("dispoP"));

                }

                System.out.println("Prestatuer :" + p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    @Override
    public void ajouterD(Demandeur d) {

        try {
            String rep = "SELECT role FROM `utilisateur` WHERE idUser=" + d.getIdUser();
            Statement stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                String role = rs.getString("role");
                if (d.getRole() == ("demandeur")) {
                    String req = "UPDATE utilisateur SET libelleDemande='" + d.getLibelleDemande() + ",' ,role='" + d.getRole() + "' WHERE idUser=" + d.getIdUser();
                    PreparedStatement st = cnx.prepareStatement(req);
                    st.executeUpdate(req);
                    System.out.println("Demandeur ajouté avec succées");
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifierD(Demandeur d) {
        try {
            String req = "UPDATE utilisateur SET libelleDemande= '" + d.getLibelleDemande() + "' WHERE idUser=" + d.getIdUser();
            PreparedStatement st = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete
            //st.setString(1, d.getLibelleDemande());
            st.executeUpdate();
            System.out.println("Demandeur modifié avec succés");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Demandeur getOneD(int id) {
        String rep = "SELECT * FROM `utilisateur` WHERE idUser=" + id;
        Demandeur d = new Demandeur();

        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {

                String role = rs.getString("role");
                if (role.equals("demandeur")) {

                    d.setIdUser(rs.getInt("idUser"));
                    d.setCinUser(rs.getString("cinUser"));
                    d.setNomUser(rs.getString("nomUser"));
                    d.setPrenomUser(rs.getString("prenomUser"));
                    d.setDdnUser(rs.getDate("ddnUser"));
                    d.setAdressUser(rs.getString("adressUser"));
                    d.setCodePostalUser(rs.getInt("codePostalUser"));
                    d.setNumUser(rs.getString("numUser"));
                    d.setLoginUser(rs.getString("loginUser"));
                    d.setPasswUser(rs.getString("passwUser"));

                    d.setLibelleDemande(rs.getString("libelleDemande"));

                }

                System.out.println("Demandeur :" + d);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return d;
    }

    @Override
    public List<Demandeur> getAllD() {
        String rep = "SELECT * FROM `utilisateur`";
        ObservableList<Demandeur> demandeurs = FXCollections.observableArrayList();

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {

                String role = rs.getString("role");
                if (role.equals("demandeur")) {
                    Demandeur d = new Demandeur();
                    d.setIdUser(rs.getInt("idUser"));
                    d.setCinUser(rs.getString("cinUser"));
                    d.setNomUser(rs.getString("nomUser"));
                    d.setPrenomUser(rs.getString("prenomUser"));
                    d.setDdnUser(rs.getDate("ddnUser"));
                    d.setAdressUser(rs.getString("adressUser"));
                    d.setCodePostalUser(rs.getInt("codePostalUser"));
                    d.setNumUser(rs.getString("numUser"));
                    d.setLoginUser(rs.getString("loginUser"));
                    d.setPasswUser(rs.getString("passwUser"));

                    d.setLibelleDemande(rs.getString("libelleDemande"));

                    demandeurs.add(d);
                    System.out.println("Demandeur : " + d);

                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return demandeurs;

    }

    @Override
    public void modifierA(Admin a) {

        try {
            String rep = "SELECT role FROM `utilisateur` WHERE role='admin'";
            Statement stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                String role = rs.getString("role");
                if (role.equals("admin")) {
                    String req = "UPDATE Utilisateur SET cinUser=?, nomUser=?,prenomUser=?, ddnUser=?, adressUser=?, codePostalUser=? , numUser=? , loginUser=? , passwUser=?  where idUser=" + a.getIdUser();
                    PreparedStatement st = cnx.prepareStatement(req);
                    //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete

                    st.setString(1, a.getCinUser());
                    st.setString(2, a.getNomUser());
                    st.setString(3, a.getPrenomUser());
                    st.setDate(4, a.getDdnUser());
                    st.setString(5, a.getAdressUser());
                    st.setInt(6, a.getCodePostalUser());
                    st.setString(7, a.getNumUser());
                    st.setString(8, a.getLoginUser());
                    st.setString(9, a.getPasswUser());

                    st.executeUpdate();
                    System.out.println("Admin modifié avec succés");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Admin getOneA(int id) {

        String rep = "SELECT * FROM `utilisateur` WHERE idUser=" + id;
        Admin a = new Admin();

        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {

                String role = rs.getString("role");
                if (role.equals("admin")) {

                    a.setIdUser(rs.getInt("idUser"));
                    a.setCinUser(rs.getString("cinUser"));
                    a.setNomUser(rs.getString("nomUser"));
                    a.setPrenomUser(rs.getString("prenomUser"));
                    a.setDdnUser(rs.getDate("ddnUser"));
                    a.setAdressUser(rs.getString("adressUser"));
                    a.setCodePostalUser(rs.getInt("codePostalUser"));
                    a.setNumUser(rs.getString("numUser"));
                    a.setLoginUser(rs.getString("loginUser"));
                    a.setPasswUser(rs.getString("passwUser"));

                }

                System.out.println("Admin :" + a);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @Override
    public boolean validerLog(String Email, String mdp) {

        String selectL = "SELECT * FROM `utilisateur` WHERE loginUser= ? and passwUser = ?";
        try {
            PreparedStatement pr = cnx.prepareStatement(selectL);
            pr.setString(1, Email);
            pr.setString(2, mdp);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                Utilisateur u = new Utilisateur();
                u.setIdUser(rs.getInt("idUser"));
                u.setCinUser(rs.getString("cinUser"));
                u.setNomUser(rs.getString("nomUser"));
                u.setPrenomUser(rs.getString("prenomUser"));
                u.setDdnUser(rs.getDate("ddnUser"));
                u.setAdressUser(rs.getString("adressUser"));
                u.setCodePostalUser(rs.getInt("codePostalUser"));
                u.setNumUser(rs.getString("numUser"));
                u.setLoginUser(rs.getString("loginUser"));
                u.setPasswUser(rs.getString("passwUser"));

                //current user
                Utilisateur.current_user = u;

                return true;
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Utilisateur Login(String email) {

        Utilisateur u = new Utilisateur();

        try {
            String requete = "select * from `utilisateur` where loginUser=" + "'" + email + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            int count = 0;
            while (rs.next()) {
                count++;
                u.setIdUser(rs.getInt("idUser"));
                u.setCinUser(rs.getString("cinUser"));
                u.setNomUser(rs.getString("nomUser"));
                u.setPrenomUser(rs.getString("prenomUser"));
                u.setDdnUser(rs.getDate("ddnUser"));
                u.setAdressUser(rs.getString("adressUser"));
                u.setCodePostalUser(rs.getInt("codePostalUser"));
                u.setNumUser(rs.getString("numUser"));
                u.setLoginUser(rs.getString("loginUser"));
                u.setPasswUser(rs.getString("passwUser"));
            }

            if (count == 0) {
                return null;
            } else {
                return u;
            }
        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean checkEmailExist(String email) {

        int count = 0;

        String requete = "select * from `utilisateur` where loginUser='" + email + "'";
        try {
            Statement st = cnx.createStatement();
            ResultSet rsl = st.executeQuery(requete);
            while (rsl.next()) {
                count++;
            }
            if (count == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }
        return false;
    }

    @Override
    public boolean validerEmail(String s) {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(s);
        if (m.find() && m.group().equals(s)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int countu(int util){
        String req = "select * from utilisateur";
        Statement stm;  
        util = 0;
        try{
            stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                if (rs.getString("role").equals("user")) {
                   util++;
               
            }
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return util;
    }
    
    @Override
        public int countp( int prest) {
        String req = "Select * from utilisateur";
        Statement stm;
        prest = 0;
        

        try {
            stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                if (rs.getString("role").equals("prestateur")) {
                    prest++;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return prest;
    }
        
         @Override
        public int countd( int deman) {
        String req = "Select * from utilisateur";
        Statement stm;
        
        deman = 0;
        

        try {
            stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                 if (rs.getString("role").equals("demandeur")) {
                    deman++;
                } 
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return deman;
    }
        
        @Override
     public int testNum(String s){
        if (s.contains("1") == true)
        return 1;
        if (s.contains("2") == true)
        return 1;
        if (s.contains("3") == true)
        return 1;
        if (s.contains("4") == true)
        return 1;
        if (s.contains("5") == true)
        return 1;
        if (s.contains("6") == true)
        return 1;
        if (s.contains("7") == true)
        return 1;
        if (s.contains("8") == true)
        return 1;
        if (s.contains("9") == true)
        return 1;
        if (s.contains("0") == true)
        return 1;
        
        return 0;
    }
     
     @Override
      public Utilisateur selectUser(String a) {
        String req = "SELECT * FROM utilisateur WHERE loginUser='" + a + "'";
        Utilisateur u = new Utilisateur();
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setNomUser(rs.getString("nomUser"));
                u.setPrenomUser(rs.getString("prenomUser"));
                u.setIdUser(rs.getInt("idUser"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return u;
    }
      
      
    
    @Override
    public void updateUser(int a, Utilisateur u)  {
        String p = u.getNomUser() + u.getPrenomUser();
        //System.out.println(p);
        p = BCrypt.hashpw(p, BCrypt.gensalt(13));
        p = p.replaceFirst("a", "y");
        try {
            String req = "UPDATE `utilisateur` SET `passwUser`=? WHERE idUser=" + a ;
            PreparedStatement st = cnx.prepareStatement(req);
            //Mouch mohem tartib les instruction numero ya3ty indication 3al blasetha fel requete
            st.setString(1, p);
                        st.executeUpdate();

            System.out.print("modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }   

}
