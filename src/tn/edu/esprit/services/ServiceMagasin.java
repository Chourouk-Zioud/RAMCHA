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
import tn.edu.esprit.entities.Magasin;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author LENOVO
 */
public class ServiceMagasin implements  IServiceMagasin <Magasin>{
    
    Connection cnx ;
    public ServiceMagasin(){
    this.cnx= DataSource.getInstance().getConnection();
    }
    
    @Override
    public void ajouter(Magasin m) {
        
         try{
            String req = "INSERT INTO `magasin`( `nomMagasin`, `telMagasin`,`emailMagasin`, `adresseMagasin` ) VALUES ('"+m.getNomMagasin()+"','"+m.getTelMagasin()+"','"+m.getEmailMagasin()+"','"+m.getAdresseMagasin()+"')";       
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       

    @Override
    public void modifier(Magasin m) {
        
        try {
            
            String req= "UPDATE `magasin` SET `nomMagasin`=?,`telMagasin`=?,`emailMagasin`=?,`adresseMagasin`=?  WHERE `IdMagasin`="+m.getIdMagasin(); 
            PreparedStatement stm = cnx.prepareStatement(req);
            
            stm.setString(1, m.getNomMagasin());
            stm.setInt(2, m.getTelMagasin());
            stm.setString(3, m.getEmailMagasin());
            stm.setString(4, m.getAdresseMagasin());
            
        stm.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }

    @Override
    public void supprimer(int id) {
        
        try {
            String req = "DELETE FROM  `magasin` WHERE  `idMagasin` ="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Magasin getOne(int id) {
        
        String req = "SELECT * FROM `magasin` where IdMagasin = "+id;
        Statement stm;
        Magasin m = new Magasin();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()){
                m.setNomMagasin(rs.getString("nomMagasin"));
                m.setTelMagasin(rs.getInt("telMagasin"));
                 m.setEmailMagasin(rs.getString("emailMagasin"));
                  m.setAdresseMagasin(rs.getString("adresseMagasin"));
            }
            System.out.println(m);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        return m ;

    }
        

    @Override
    public List<Magasin> getAll() {
        
         String req = "SELECT * FROM magasin";
        ArrayList<Magasin> magasin = new ArrayList();
        Statement stm;
        
        try {
            stm = this.cnx.createStatement();
            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                Magasin m = new Magasin();
             
                m.setNomMagasin(rs.getString("nomMagasin"));
                m.setTelMagasin(rs.getInt("telMagasin"));
                m.setEmailMagasin(rs.getString("emailMagasin"));
                m.setAdresseMagasin(rs.getString("adresseMagasin"));
                magasin.add(m);
                }
                System.out.println(magasin);
            }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    return magasin; 
    }
    
    
    
 
       
    }

    
    

