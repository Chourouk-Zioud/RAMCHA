/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.entities.Article;
import tn.edu.esprit.entities.Magasin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.edu.esprit.GUI.NewFXMainClass;
import tn.edu.esprit.entities.Utilisateur;

/**
 *
 * @author Chourouk Zioud
 */
public class ArticleService {
        Connection cnx;

    public ArticleService(Connection cnx) {
        this.cnx = cnx;
    }
   public void ajouter(Article m) {
       Utilisateur us = new Utilisateur();
               
        try {
            String req = "INSERT INTO `article`(`nomArticle`, `marqueArticle`, `typeArticle`, `disponibiliteArticle`, `couleurArticle`, `prixArticle`, `tailleArticle`, `descriptionArticle`, `screenshot`,`IdidMagasin`, `idCategorieArticle`) VALUES ('"+m.getNomArticle()+"','"+m.getMarqueArticle()+"','"+m.getTypeArticle()+"','"+m.getDisponibiliteArticle()+"','"+m.getCouleurArticle()+"','"+m.getPrixArticle()+"','"+m.getTailleArticle()+"','"+m.getDescriptionArticle()+"','"+m.getScreenshot()+"','"+m.getIdMagasin()+"','"+m.getIdCategorieArticle()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Produit Ajouter avec succés");
            MailService sem = new MailService();
            sem.sendEmail(us.getLoginUser(), "Ajouter Article", "un nouvelle Article a ete Ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void supprimer(int id) {
            System.out.println(id);
                try {
            String req = "DELETE FROM `article` WHERE `idArticle`="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Article supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
        
        public void modifier(Article m) {
          
      try {
            String req="UPDATE `article` SET `nomArticle`=?,`marqueArticle`=?,`typeArticle`=?,`disponibiliteArticle`=?,`couleurArticle`=?,`prixArticle`=?,`tailleArticle`=?,`descriptionArticle`=?,`screenshot`=?,`IdidMagasin`=?,`idCategorieArticle`=? WHERE `idArticle`="+m.getIdArticle();
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, m.getNomArticle());
            st.setString(2, m.getMarqueArticle());
            st.setString(3, m.getTypeArticle());
            st.setString(4, m.getDisponibiliteArticle());
             st.setString(5, m.getCouleurArticle());
              st.setFloat(6, m.getPrixArticle());
              st.setString(7, m.getTailleArticle());
              st.setString(8, m.getDescriptionArticle());
              st.setString(9, m.getScreenshot());
              st.setInt(10, m.getIdMagasin());
              st.setInt(11, m.getIdCategorieArticle());
            st.executeUpdate();
            System.out.println("Article Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  }
    public ObservableList<Article> getAll() {
         String rep = "SELECT * FROM `article`";
        ObservableList<Article> l = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Article m = new  Article();
                m.setIdArticle(rs.getInt(1));
                m.setNomArticle(rs.getString(2));
                m.setMarqueArticle(rs.getString(3));
                m.setTypeArticle(rs.getString(4));
                m.setDisponibiliteArticle(rs.getString(5));
                m.setCouleurArticle(rs.getString(6));
                m.setPrixArticle(rs.getFloat(7));
                m.setTailleArticle(rs.getString(8));
                m.setDescriptionArticle(rs.getString(9));
                m.setScreenshot(rs.getString(10));
                m.setIdMagasin(rs.getInt(11));
                m.setIdCategorieArticle(rs.getInt(12));


                l.add(m);
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(l+"\n");
        return l;
    }
    
        public ObservableList<Article> getAllForMagasin(int id) {
         String rep = "SELECT * FROM `article` WHERE `IdidMagasin` ="+id;
        ObservableList<Article> l = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Article m = new  Article();
                m.setIdArticle(rs.getInt(1));
                m.setNomArticle(rs.getString(2));
                m.setMarqueArticle(rs.getString(3));
                m.setTypeArticle(rs.getString(4));
                m.setDisponibiliteArticle(rs.getString(5));
                m.setCouleurArticle(rs.getString(6));
                m.setPrixArticle(rs.getFloat(7));
                m.setTailleArticle(rs.getString(8));
                m.setDescriptionArticle(rs.getString(9));
                m.setScreenshot(rs.getString(10));
                m.setIdMagasin(rs.getInt(11));
                m.setIdCategorieArticle(rs.getInt(12));


                l.add(m);
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(l+"\n");
        return l;
    }
                public ObservableList<Article> getAllForCateg(int id) {
         String rep = "SELECT * FROM `article` WHERE `idCategorieArticle` ="+id;
        ObservableList<Article> l = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Article m = new  Article();
                m.setIdArticle(rs.getInt(1));
                m.setNomArticle(rs.getString(2));
                m.setMarqueArticle(rs.getString(3));
                m.setTypeArticle(rs.getString(4));
                m.setDisponibiliteArticle(rs.getString(5));
                m.setCouleurArticle(rs.getString(6));
                m.setPrixArticle(rs.getFloat(7));
                m.setTailleArticle(rs.getString(8));
                m.setDescriptionArticle(rs.getString(9));
                m.setScreenshot(rs.getString(10));
                m.setIdMagasin(rs.getInt(11));
                m.setIdCategorieArticle(rs.getInt(12));


                l.add(m);
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(l+"\n");
        return l;
    }
    
    public Article getOne(int id) {
         String rep = "SELECT * FROM `magasin` WHERE `idMagasin` ="+id;
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Article m = new  Article();
                m.setIdArticle(rs.getInt(1));
                m.setNomArticle(rs.getString(2));
                m.setMarqueArticle(rs.getString(3));
                m.setTypeArticle(rs.getString(4));
                m.setDisponibiliteArticle(rs.getString(5));
                m.setCouleurArticle(rs.getString(6));
                m.setPrixArticle(rs.getFloat(7));
                m.setTailleArticle(rs.getString(8));
                m.setDescriptionArticle(rs.getString(9));
                m.setScreenshot(rs.getString(10));
                m.setIdMagasin(rs.getInt(11));
                m.setIdCategorieArticle(rs.getInt(12));
                System.out.println(m);

                return m;
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
