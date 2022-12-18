/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import com.twilio.Twilio;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.tools.DataS;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author eya
 */
public class CruSer implements Iservicesgest <ServiceT>{
     Connection cnx;
        
        public CruSer() {
        this.cnx = DataS.getInstance().getConnection();
    }
        
        public CruSer(Connection cnx) {
        this.cnx = cnx;
    }

    @Override
    public void ajouter(ServiceT t , int idCat) {
            try{
         String req = "INSERT INTO `service`(`nomService`, `nbreOuvrier`, `prixService`, `descriptionService`, `dateDebutService`, `dateFinService`, `disponibiliteService`, `idCategorieService`) VALUES ('"+t.getNomService()+"','"+t.getNbreOuvrier()+"','"+t.getPrixService()+"','"+t.getDescriptionService()+"','"+t.getDateDebutService()+"','"+t.getDateFinService()+"','"+t.getDisponibiliteService()+"','"+idCat+"')";
           Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Service ajouté avec succés");
          }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
        
}

    @Override
    public void modifier(ServiceT t) {
     
              try {
            String req="UPDATE Service SET nomService=?, nbreOuvrier=?,prixService=?,descriptionService=?, dateDebutService=?, dateFinService=?, disponibiliteService=?  where idService=?";
            PreparedStatement stm = cnx.prepareStatement(req);
            
            stm.setString(1, t.getNomService());
            stm.setInt(2, t.getNbreOuvrier());
            stm.setFloat(3, t.getPrixService());
            stm.setString(4, t.getDescriptionService());
            stm.setDate(5, (Date) t.getDateDebutService());
            stm.setDate(6, (Date) t.getDateFinService());
            stm.setString(7, t.getDisponibiliteService());
            stm.setObject(8, t.getIdService());
            
           
            stm.executeUpdate();
            System.out.println("Service Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
              
    }  
    
    public static final String ACCOUNT_SID = "ACfb6bcee89f7deb403c1cf20e5e1a9e4d";
    public static final String AUTH_TOKEN = "a75de7b98bb5acf982d09800fcc50011";

    public void sendSmsvalide() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message msg = Message.creator(new PhoneNumber("+21656522975"),new PhoneNumber("+15099023873"),("Un nouveau service est ajouter \n Consulter notre application pour plus détails")).create();
    
    }

     @Override
    public void supprimer(int idService) {
              String s = Integer.toString(idService);
                try {
            String req = "DELETE FROM `Service` WHERE idService="+s;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("service supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }  
}
    @Override
    public void notifierClient() {
        String k = "SELECT * FROM utilisateur";
        try{
            Statement st = cnx.createStatement();
         ResultSet rs = st.executeQuery(k);
         while(rs.next()){
             sendSmsvalide();
         }
        }catch(Exception e){
            System.out.print(e);
        }
        
        
    }
    

    @Override
    public ServiceT getOne(int idService) {
        String s = Integer.toString(idService);
        String rep = "SELECT * FROM `Service` WHERE idService=" +s;
        ServiceT ser = new ServiceT();
        Statement stm;
        CruCat cc = new CruCat();
        
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
             while (rs.next()) {
               CategorieService cs = cc.getOne(rs.getInt("idCategorieService"));
            ser.setCategorieService(cs);
            ser.setIdService(rs.getInt("idService"));
            ser.setNomService(rs.getNString("nomService"));
            ser.setNbreOuvrier(rs.getInt("nbreOuvrier"));
            ser.setPrixService(rs.getFloat("prixService"));
            ser.setDescriptionService(rs.getString("DescriptionService"));
            ser.setDateDebutService(rs.getDate("dateDebutService"));
            ser.setDateFinService(rs.getDate("dateFinService"));
            
            ser.setDisponibiliteService(rs.getString("disponibiliteService"));
             }
    } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ser;
        }

    @Override
    public ObservableList<ServiceT> getAll () {
       
        String rep = "SELECT * FROM `service`";
         ObservableList<ServiceT> servicesT =  FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
             
            ServiceT s = new ServiceT();
            s.setIdService(rs.getInt("idService"));
            s.setNomService(rs.getString("nomService"));
            s.setNbreOuvrier(rs.getInt("nbreOuvrier"));
            s.setPrixService(rs.getFloat("prixService"));
            s.setDescriptionService(rs.getString("descriptionService"));
            s.setDateDebutService(rs.getDate("dateDebutService"));
            s.setDateFinService(rs.getDate("dateFinService"));
            s.setDisponibiliteService(rs.getString("disponibiliteService"));
            CruCat qq = new CruCat ();
          
            s.setCategorieService(qq.getOne(rs.getInt("idCategorieService")));
             

                servicesT.add(s);
                System.out.println(s);
                System.out.println(qq.getOne(rs.getInt("idCategorieService")));

            }
        
    }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
   
}
            return servicesT;
    } 

    @Override
    public void ajoutercate(CategorieService t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

