/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.edu.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Article;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author LENOVO
 */
public class ServiceArticle implements IServiceArticle<Article>{

    Connection cnx ;

    public ServiceArticle(){
    this.cnx= DataSource.getInstance().getConnection();
    }
    
    @Override
    public void ajouter(Article a) {
        try{
            String req = "INSERT INTO `article`(`nomArticle`, `prixArticle`, `marqueArticle`, `disponibiliteArticle`, `imageArticle`, `videoArticle`, `descriptionArticle`, `ficheTechnique`, `tailleArticle`, `typeArticle`, `couleurArticle`,`idMagasin`,`idCategorieArticle`) VALUES ('"+a.getNomArticle()+"','"+a.getPrixArticle()+"','"+a.getMarqueArticle()+"','"+a.getDisponibiliteArticle()+"','"+a.getImageArticle()+"','"+a.getVideoArticle()+"','"+a.getDescriptionArticle()+"','"+a.getFicheTechnique()+"','"+a.getTailleArticle()+"','"+a.getTypeArticle()+"','"+a.getCouleurArticle()+"','"+a.getIdMagasin()+"','"+a.getIdCategorieArticle()+"')";            
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    @Override
    public void modifier(Article a) {
        try {
            
            String req = "UPDATE `article` SET  `nomArticle`=?,`prixArticle`=?,`marqueArticle`=?,`disponibiliteArticle`=?,`imageArticle`=?,`videoArticle`=?,`descriptionArticle`=?,`ficheTechnique`=?,`tailleArticle`=?,`typeArticle`=?,`couleurArticle`=?,`idCategorieArticle`=?,`idMagasin`=? WHERE `idArticle`= "+a.getIdArticle();
            PreparedStatement stm = cnx.prepareStatement(req);
            
            stm.setString(1, a.getNomArticle());
            stm.setFloat(2, a.getPrixArticle());
            stm.setString(3, a.getMarqueArticle());
            stm.setBoolean(4, a.getDisponibiliteArticle());
            stm.setString(5, a.getImageArticle());
            stm.setString(6, a.getVideoArticle());
            stm.setString(7, a.getDescriptionArticle());
            stm.setString(8, a.getFicheTechnique());
            stm.setString(9, a.getTailleArticle());
            stm.setString(10, a.getTypeArticle());
            stm.setString(11, a.getCouleurArticle());
            stm.setInt(12,a.getIdCategorieArticle());
            stm.setInt (13,a.getIdMagasin());
            
            stm.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `article` WHERE `IdArticle` ="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Article getOne(int id) {
        String req = "SELECT * FROM `article` where idArticle = "+id;
        Statement stm;
        Article ar = new Article();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()){
                ar.setCouleurArticle(rs.getString("couleurArticle"));
                ar.setDescriptionArticle(rs.getString("descriptionArticle"));
                ar.setDisponibiliteArticle(rs.getBoolean("disponibiliteArticle"));
                ar.setFicheTechnique(rs.getString("ficheTechnique"));
                ar.setImageArticle(rs.getString("imageArticle"));
                ar.setMarqueArticle(rs.getString("marqueArticle"));
                ar.setNomArticle(rs.getString("nomArticle"));
                ar.setPrixArticle(rs.getFloat("prixArticle"));
                ar.setTailleArticle(rs.getString("tailleArticle"));
                ar.setTypeArticle(rs.getString("typeArticle"));
                ar.setVideoArticle(rs.getString("videoArticle"));
                ar.setIdMagasin(rs.getInt("idMagasin"));
                ar.setIdCategorieArticle(rs.getInt("idCategorieArticle"));
            }
            System.out.println(ar);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        return ar ;
    }

    @Override
    public List<Article> getAll() {
        String req = "SELECT * FROM article";
        ArrayList<Article> articles = new ArrayList();
        Statement stm;
        
        try {
            stm = this.cnx.createStatement();
            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                Article ar = new Article();
                ar.setCouleurArticle(rs.getString("couleurArticle"));
                ar.setDescriptionArticle(rs.getString("descriptionArticle"));
                ar.setDisponibiliteArticle(rs.getBoolean("disponibiliteArticle"));
                ar.setFicheTechnique(rs.getString("ficheTechnique"));
                ar.setImageArticle(rs.getString("imageArticle"));
                ar.setMarqueArticle(rs.getString("marqueArticle"));
                ar.setNomArticle(rs.getString("nomArticle"));
                ar.setPrixArticle(rs.getFloat("prixArticle"));
                ar.setTailleArticle(rs.getString("tailleArticle"));
                ar.setTypeArticle(rs.getString("typeArticle"));
                ar.setVideoArticle(rs.getString("videoArticle"));
                ar.setIdCategorieArticle(rs.getInt("idCategorieArticle"));
                ar.setIdMagasin(rs.getInt("idMagasin"));


                articles.add(ar);
                }
                System.out.println(articles);
            }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    return articles; 
    }
       
    
}
