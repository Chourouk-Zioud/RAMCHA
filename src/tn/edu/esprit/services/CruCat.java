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
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.tools.DataS;

/**
 *
 * @author eya
 */
public class CruCat implements Iservicesgest <CategorieService> {
    Connection cnx;
        CategorieService k=new CategorieService ();
        
        public CruCat() {
        this.cnx = DataS.getInstance().getConnection();
    }


    @Override
     public void ajoutercate(CategorieService t){
         try {
            String req ="INSERT INTO `categorieservice`( `nomCategorieService`,`descriptionCategorieService`)VALUES ('"+t.getNomCategorieService()+"','"+t.getDescriptionCategorieService()+"')";
    Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
          }
    }

    @Override
    public void modifier(CategorieService t ) {
         try {
            String req="UPDATE `categorieservice` SET nomCategorieService=?, descriptionCategorieService=?where idCategorieService=?" ;
            PreparedStatement stm = cnx.prepareStatement(req);
    
            stm.setString(1, t.getNomCategorieService());
            stm.setString(2, t.getDescriptionCategorieService());
            stm.setInt(3, t.getIdCategorieService());
       stm.executeUpdate();
            System.out.println(" Catégorie Service  Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void supprimer(int id) {
        String s = Integer.toString(id);
        try {
            String req = "DELETE FROM `categorieservice` WHERE idCategorieService="+s;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Categorie supprimé avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }  
    }

    @Override
    public CategorieService getOne(int id) {

         CategorieService mm = new CategorieService ();
       String rep = "SELECT * FROM `categrorieservice` WHERE `idCategorieService` ="+id;
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
             while (rs.next()) {
                
                 mm.setIdCategorieService(rs.getInt("IdCategorieService"));
                 mm.setNomCategorieService(rs.getString("NomCategorieService"));
                 mm.setDescriptionCategorieService(rs.getString("descriptionCategorieService"));
                  return mm;
         }  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mm;
             
    }

    @Override
    public ObservableList<CategorieService> getAll() {
       String rep = "SELECT * FROM `categorieservice`";
      ObservableList<CategorieService> categorieService =  FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
              
             CategorieService c = new CategorieService();
                 c.setIdCategorieService(rs.getInt("idCategorieService"));
                 c.setNomCategorieService(rs.getString("NomCategorieService"));
                 c.setDescriptionCategorieService(rs.getString("descriptionCategorieService"));
                
                 categorieService.add(c);
                  System.out.println(c);
    }
        }
    
  catch (SQLException ex) {
            System.out.println(ex.getMessage());
}
        return categorieService;
    }

    @Override
    public void ajouter(ServiceT t, int idCat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifierClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    

   
}
