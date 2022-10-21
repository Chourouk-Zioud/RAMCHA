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
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.tools.DataBase;

/**
 *
 * @author asus
 */
public class ServicesAvisCours implements IServicesFormation <AvisCours>{
    
    Connection cnx;
    AvisCours ch= new AvisCours();
    
    public  ServicesAvisCours (){
    this.cnx=DataBase.getInstance().getConnection();
     }
    

    @Override
    public void ajouter(AvisCours f) {
        try {
            String req = "INSERT INTO `aviscours`( `rate`,`idUtilisateur`,`idCours`,`commentaire`) VALUES ('"+f.getRate()+"','"+f.getIdUtilisateur()+"','"+f.getIdCour()+"','"+f.getCommentaire()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("avis ajoute avec succes ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifier(AvisCours f) {
         try {
            String req="UPDATE `AvisCours` SET `rate`='"+f.getRate()+"',`commentaire`='"+f.getCommentaire()+"' where idAvisCours="+f.getIdAvisCours() ;
            PreparedStatement st = cnx.prepareStatement(req);
            
          
            st.executeUpdate();
            System.out.println("avis Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `AvisCours` WHERE IdAvisCours ="+id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("avis supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }

    @Override
    public AvisCours getOne(int id) {
             String rep = "SELECT * FROM AvisCours WHERE idAvisCours= "+id;
        
        AvisCours ach =null;
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                AvisCours ac = new AvisCours();
                ac.setIdAvisCours(rs.getInt("IdAvisCours"));
                ac.setRate(rs.getInt("rate"));
                ac.setIdUtilisateur(rs.getInt("idUtilisateur"));
                ac.setCommentaire(rs.getString("commentaire"));
                System.out.println(ac);
               
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ach;
    }

    @Override
    public ObservableList<AvisCours> getAll(int idCours) {
           String rep = "SELECT * FROM `AvisCours` where `idCours` = "+idCours ;
           ServicesCours eya=new ServicesCours();
           eya.getOne(idCours);
           
        ObservableList <AvisCours> aviscours = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);  

            while (rs.next()) {
                AvisCours ac = new AvisCours();
                
                ac.setIdAvisCours(rs.getInt("IdAvisCours"));
                ac.setRate(rs.getInt("rate"));
                ac.setIdUtilisateur(rs.getInt("idUtilisateur"));
                ac.setCommentaire(rs.getString("commentaire"));
                System.out.println(ac);
                aviscours.add(ac);
            }
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return aviscours;
      
    }

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

    @Override
    public List<AvisCours> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    
 
    }
    
    
    

