/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.entities.CategorieArticle;
import tn.edu.esprit.entities.Magasin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Chourouk Zioud
 */
public class CategorieService {
        Connection cnx;

    public CategorieService(Connection cnx) {
        this.cnx = cnx;
    }
    
     public void ajouter(CategorieArticle c) {
        try {
            String req = "INSERT INTO `categoriearticle`(`libelle`, `discription`) VALUES ('"+c.getLibelle()+"','"+c.getDiscription()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Categorie Ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimer(int id) {
                try {
            String req = "DELETE FROM `categoriearticle` WHERE `idCategorie`="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("categoriearticle supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
        public CategorieArticle getOne(int id) {
      String rep = "SELECT * FROM categoriearticle WHERE `idCategorie`="+id;
      
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
               //    System.out.println("dddd");
                CategorieArticle m=new CategorieArticle();
                m.setIdCategorie(rs.getInt(1));
                m.setLibelle(rs.getString(2));
                m.setDiscription(rs.getString(3));
                 
                System.out.println(m);
                return m;    
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
        return null;
    }
        
            public ObservableList<CategorieArticle> getAll() {
         String rep = "SELECT * FROM `categoriearticle`";
        ObservableList<CategorieArticle> l = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                CategorieArticle m = new  CategorieArticle();
                m.setIdCategorie(rs.getInt(1));
                m.setLibelle(rs.getString(2));
                m.setDiscription(rs.getString(3));
           
                
                l.add(m);
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(l+"\n");
        return l;
    }
            
                    
        public void modifier(CategorieArticle m) {
          
      try {
            String req="UPDATE `categoriearticle` SET `libelle`=?,`discription`=? WHERE `idCategorie`="+m.getIdCategorie();
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, m.getLibelle());
            st.setString(2, m.getDiscription());

            st.executeUpdate();
            System.out.println("Magasin Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  }

}
