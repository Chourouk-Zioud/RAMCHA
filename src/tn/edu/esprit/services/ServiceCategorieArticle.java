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
import tn.edu.esprit.entities.CategorieArticle;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author LENOVO
 */
public class ServiceCategorieArticle implements IServiceCategorieArticle<CategorieArticle>{
        
        Connection cnx ;
        public ServiceCategorieArticle(){
    this.cnx= DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(CategorieArticle c) {
         try{
            String req = "INSERT INTO `categoriearticle`( `nomCategorieArticle`, `iconeCategorieArticle`) VALUES ('"+c.getNomCategorieArticle()+"','"+c.getIconeCategorieArticle()+"')";       
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
    }

    @Override
    public void modifier(CategorieArticle c) {
         try {
            
            String req= "UPDATE `categoriearticle` SET `nomCategorieArticle`=?,`iconeCategorieArticle`=?  WHERE `idCategorieArticle`="+c.getIdCategorieArticle(); 
            PreparedStatement stm = cnx.prepareStatement(req);
            
            stm.setString(1, c.getNomCategorieArticle());
            stm.setString(2, c.getIconeCategorieArticle());
           
            
        stm.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM  `categoriearticle` WHERE  `idCategorieArticle` ="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public CategorieArticle getOne(int id) {
        
        String req = "SELECT * FROM `categoriearticle` where idCategorieArticle = "+id;
        Statement stm;
        CategorieArticle car = new CategorieArticle();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()){
                car.setIconeCategorieArticle(rs.getString("iconeCategorieArticle"));
                car.setNomCategorieArticle(rs.getString("nomCategorieArticle"));     
            }
            System.out.println(car);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        return car ;
        
    }

    @Override
    public List<CategorieArticle> getAll() {
        
        String req = "SELECT * FROM categoriearticle";
        ArrayList<CategorieArticle> categoriearticles = new ArrayList();
        Statement stm;
        
        try {
            stm = this.cnx.createStatement();
            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                CategorieArticle car = new CategorieArticle();
             
                car.setNomCategorieArticle(rs.getString("NomCategorieArticle"));
                car.setIconeCategorieArticle(rs.getString("iconeCategorieArticle"));


                categoriearticles.add(car);
                }
                System.out.println(categoriearticles);
            }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    return categoriearticles; 
    }
       
       
    }
    
    
