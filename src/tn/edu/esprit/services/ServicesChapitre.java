/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static javafx.scene.input.KeyCode.F;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.tools.DataS;


/**
 *
 * @author asus
 */
public class ServicesChapitre implements IServicesFormation <Chapitre>{
    Connection cnx;
    Chapitre ch= new Chapitre();
    
    public  ServicesChapitre (){

    this.cnx=DataS.getInstance().getConnection();
     }

    @Override
    public void ajouter(Chapitre  f) {
           try {
            String req = "INSERT INTO `chapitre`( `nomChapitre`, `langueChapitre`, `typeChapitre`) VALUES ('"+f.getNomChapitre()+"','"+f.getLangueChapitre()+"','"+f.getTypeChapitre()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("success ajout chapitre");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
      
    }

    @Override
    public void modifier(Chapitre f) {
      try {
            String req="UPDATE `chapitre` SET `nomChapitre`=?,`langueChapitre`=?,`typeChapitre`=? WHERE `idChapitre`="+f.getIdChapitre() ;
            PreparedStatement st = cnx.prepareStatement(req);
            
            st.setString(1, f.getNomChapitre());
            st.setString(2, f.getLangueChapitre());
            st.setString(3, f.getTypeChapitre());
            st.executeUpdate();
            System.out.println("chapitre Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

    }

    @Override
    public void supprimer(int id) {
         try {
            String req = "DELETE FROM `chapitre` WHERE `IdChapitre` ="+id;
         Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("chapitre supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }

    @Override
    public Chapitre getOne(int id) {
             String rep = "SELECT * FROM chapitre WHERE idChapitre="+id;
        Statement stm;
        Chapitre cp = new Chapitre();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                
                cp.setIdChapitre(rs.getInt(1));
                cp.setNomChapitre(rs.getString("nomChapitre"));
                cp.setLangueChapitre(rs.getString("langueChapitre"));
                cp.setTypeChapitre(rs.getString("typeChapitre"));
       
    
                
            }
  

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cp;
    }

    
    
    @Override
    public ObservableList<Chapitre> getAll(){
        String rep = "SELECT * FROM `chapitre`" ;
       ObservableList<Chapitre> chapitre =  FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);  

            while (rs.next()) {
                Chapitre chp = new Chapitre();
                
                chp.setIdChapitre(rs.getInt("IdChapitre"));
                chp.setNomChapitre(rs.getString("nomChapitre"));
                chp.setLangueChapitre(rs.getString("langueChapitre"));
                chp.setTypeChapitre(rs.getString("typeChapitre"));
              ServicesCours c= new ServicesCours();
                Cours co = new Cours();
                co=c.getOne(rs.getInt("idfirst_id"));
                chp.setCours(co);
                chapitre.add(chp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         System.out.println(chapitre);
        return chapitre;
      
    }

    
    /*public List<Chapitre> getAllChap() {
       
    }*/

    public List<Chapitre> getAllChap()
   {
        List<Chapitre> list = new ArrayList<>();
        try {
            String req = "Select * from Chapitre";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
                
               
                Chapitre p = new Chapitre( rs.getInt("idChapitre"),rs.getString("nomChapitre"),rs.getString("langueChapitre"),rs.getString("typeChapitre"),null);
               // System.out.println("p="+p);
                list.add(p);
            }
                  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
   }

    public int testNom(String n)
    {
        for (Chapitre c : getAll()) {
            if (c.getNomChapitre().equals(n))
                return 1;
        }
    return 0;}
    
    public int testMn(String n)
    {
       
            if (n.startsWith("-"))
                return 1;
        
    return 0;}
    
    @Override
    public List<AvisCours> getAll(int idCours) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

 

   
}
    
    
    
    

 
    
    
    

