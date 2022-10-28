package tn.ramcha.esprit.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.DatatypeConverter;
import tn.ramcha.esprit.entities.Admin;
import tn.ramcha.esprit.entities.Demandeur;
import tn.ramcha.esprit.entities.Prestateur;
import tn.ramcha.esprit.entities.Utilisateur;
import tn.ramcha.esprit.tools.DataR;

public class ServiceUtilisateur implements ServicesU<Utilisateur,Prestateur,Demandeur,Admin> {

    Connection cnx;

    public ServiceUtilisateur() {
        this.cnx = DataR.getInstance().getConnection();
    }

    @Override
    public void ajouter(Utilisateur u) {
        try {
            String req = "INSERT INTO `utilisateur`(`idUser`,`cinUser`,`nomUser`,`prenomUser`,`ddnUser`,`adressUser`,`codePostalUser`,`numUser`,`loginUser`,`passwUser`) VALUES (" +u.getIdUser()+ ",'"  + u.getCinUser() + "','" + u.getNomUser()
                    + "','" + u.getPrenomUser() + "','" + u.getDdnUser() + "','" + u.getAdressUser() + "'," + u.getCodePostalUser() + ",'" + u.getNumUser() + "','" + u.getLoginUser() + "','" + u.getPasswUser()+  "')";
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
            String req = "UPDATE Utilisateur SET cinUser=?, nomUser=?,prenomUser=?, ddnUser=?, adressUser=?, codePostalUser=? , numUser=? , loginUser=? , passwUser=?    where idUser=" + u.getIdUser();
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
     public void modifierSd (Utilisateur u){
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
     
    
    java.util.Scanner entree =   new java.util.Scanner(System.in);
    @Override
    public void modifierRole(Utilisateur u) {
        try {
            String req = "UPDATE `utilisateur` SET `role`=? WHERE idUser=" +u.getIdUser();
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
                if (p.getRole() ==("prestateur"))
                {   
            String req = "UPDATE utilisateur SET salaireP='"+ p.getSalaireP() +"' ,posteP='"+ p.getPosteP()+"' ,diplomeP='"+ p.getDiplomeP()+"' ,experP='"+p.getExperP() +"' ,dispoP='"+ p.getDispoP() + ",' ,role='"+ p.getRole() +"' WHERE idUser=" + p.getIdUser() ;
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
       public void modifierP(Prestateur p){
        try {
           String rep = "SELECT role FROM `utilisateur` WHERE role='prestateur'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("role");
                if (role.equals("prestateur"))
                {   
            String req ="UPDATE utilisateur SET salaireP=?, posteP=?, diplomeP=?, experP=?, dispoP=? WHERE idUser=" + p.getIdUser() ;
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
                     Utilisateur util= new Utilisateur();
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
        ObservableList<Utilisateur> utilisateurs =FXCollections.observableArrayList();
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
                    
                utilisateurs.add(uu);
                System.out.println(uu + "\n");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return utilisateurs;
    }
    
  
   @Override
    public List<Prestateur> getAllP(){
         String rep = "SELECT * FROM `utilisateur`";
        ObservableList<Prestateur> prestateurs = FXCollections.observableArrayList();
        

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
               
               String role = rs.getString("role");
               if(role.equals("prestateur")){
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
     public Prestateur getOneP (int id){
         
        String rep = "SELECT * FROM `utilisateur` WHERE idUser=" + id;
        Prestateur p= new Prestateur();
        

        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
                
               String role = rs.getString("role");
               if(role.equals("prestateur")){
                
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
                
                System.out.println("Prestatuer :" +p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return p;
     }

     
    @Override
    public void ajouterD(Demandeur d){
               
        try {
           String rep = "SELECT role FROM `utilisateur` WHERE idUser=" +d.getIdUser();
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("role");
                      if (d.getRole() ==("demandeur"))
                {   
            String req = "UPDATE utilisateur SET libelleDemande='" + d.getLibelleDemande() + ",' ,role='"+ d.getRole()+"' WHERE idUser=" + d.getIdUser() ;
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
    public void modifierD(Demandeur d){
        try {
            String req ="UPDATE utilisateur SET libelleDemande= '" + d.getLibelleDemande() + "' WHERE idUser=" + d.getIdUser() ;
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
        public Demandeur getOneD (int id){
        String rep = "SELECT * FROM `utilisateur` WHERE idUser=" + id;
        Demandeur d = new Demandeur();
        
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
                
               String role = rs.getString("role");
               if(role.equals("demandeur")){
                
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
       public List<Demandeur> getAllD(){
           String rep = "SELECT * FROM `utilisateur`";
        ObservableList<Demandeur> demandeurs = FXCollections.observableArrayList();
        
        Statement stm;
        try {

            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
               
               String role = rs.getString("role");
               if(role.equals("demandeur")){
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
       public void modifierA (Admin a){
           
           try {
           String rep = "SELECT role FROM `utilisateur` WHERE role='admin'";
           Statement stm = this.cnx.createStatement();
           ResultSet rs = stm.executeQuery(rep);
            
            while (rs.next()) {
                String role = rs.getString("role");
                if (role.equals("admin"))
                {   
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
       public Admin getOneA (int id){
           
         String rep = "SELECT * FROM `utilisateur` WHERE idUser=" + id;
        Admin a = new Admin();
        
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
                
            while (rs.next()) {
                
               String role = rs.getString("role");
               if(role.equals("admin")){
                
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
     public boolean validerLog(String Email, String mdp){
        
         String selectL="SELECT * FROM `utilisateur` WHERE loginUser= ? and passwUser = ?";
        try {
             PreparedStatement pr = cnx.prepareStatement(selectL);
            pr.setString(1,Email);
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
                Utilisateur.current_user=u;
                
                return true;
            }
                
            }catch(SQLException e) {
                System.err.println(e.getMessage());
            }                
    return false;
    }
     
    @Override
     public Utilisateur validerMail(String Email){
        
         String selectL="SELECT * FROM `utilisateur` WHERE loginUser=?";
        try {
             PreparedStatement pr = cnx.prepareStatement(selectL);
            pr.setString(1,Email);
         
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
                Utilisateur.current_user=u;
                
                return u;
            }
                
            }catch(SQLException e) {
                System.err.println(e.getMessage());
            }                
    return null;
    }
     public String crypter_password(String password) {
        String hashValue = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();

        } catch (NoSuchAlgorithmException e) {
        }

     //   return hashValue;
     return hashValue;
    
    }
     
    @Override
         public boolean test_Password(String password) {

        int nombre_Maj = 0;
        int nombre_Entier = 0;
        int nombre_Min = 0;

        int ascii;

        for (int i = 0; i < password.length(); i++) {
            ascii = password.charAt(i);

            if ((ascii >= 65) && (ascii <= 90)) {
                nombre_Maj++;
            }
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                nombre_Entier++;
            }
            if ((ascii >= 97) && (ascii <= 122)) {
                nombre_Min++;
            }

        }
        if ((nombre_Entier >= 1) && (nombre_Maj >= 1) && (nombre_Min >= 1) && (password.length() >= 8)) {
            return true;
        }
        return false;

    }

  
}
