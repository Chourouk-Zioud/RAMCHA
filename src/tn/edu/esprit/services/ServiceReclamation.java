/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author chalg
 */
public class ServiceReclamation implements IServiceReclamation<Reclamation>{

    Connection cnx ;

    public ServiceReclamation(){
    this.cnx= DataSource.getInstance().getConnection();
    }
    
    @Override
    public void ajouter(Reclamation r) {
        try {
            String req = "INSERT INTO `reclamation`(`refReclamation`,`idUser`, `objetReclamation`, `descriptionReclamation`, `suiviReclamation`, `dateReclamation`) VALUES ('"+r.getRefReclamation()+"','"+r.getIdUser()+"','"+r.getObjetReclamation()+"','"+r.getDescriptionReclamation()+"','"+r.getSuiviReclamation()+"','"+r.getDateReclamation()+"')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Reclamation r) {
        try {
            String req = "UPDATE `reclamation` SET `idUser`=?,`refReclamation`=?,`objetReclamation`=?,`descriptionReclamation`=?,`suiviReclamation`=?,`dateReclamation`=? WHERE `IdReclamation` ="+r.getIdReclamation();
            PreparedStatement stm = cnx.prepareStatement(req);
            
            stm.setInt(1, r.getIdUser());
            stm.setString(2, r.getRefReclamation());
            stm.setString(3, r.getObjetReclamation());
            stm.setString(4, r.getDescriptionReclamation());
            stm.setString(5, r.getSuiviReclamation());
            stm.setDate(6, (Date) r.getDateReclamation());
            //stm.setInt(7, r.getIdReclamation());
            //r.setIdReclamation(id);
            
            stm.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `reclamation` WHERE `IdReclamation` ="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Reclamation getOne(int id) {
        String req = "SELECT `refReclamation`, `objetReclamation`, `descriptionReclamation`, `suiviReclamation`, `dateReclamation` FROM `reclamation` WHERE `IdReclamation` ="+id;
        Statement stm;
        Reclamation rc = new Reclamation();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()){
                rc.setRefReclamation(rs.getString("refReclamation"));
                rc.setObjetReclamation(rs.getString("objetReclamation"));
                rc.setDescriptionReclamation(rs.getString("descriptionReclamation"));
                rc.setSuiviReclamation(rs.getString("suiviReclamation"));
                rc.setDateReclamation(rs.getDate("dateReclamation"));
            }
            System.out.println(rc);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        return rc ;
    }

    @Override
    public List<Reclamation> getAll() {
        String req = "SELECT * FROM `reclamation`";
        ArrayList<Reclamation> reclamations = new ArrayList();
        Statement stm;
        
        try {
            stm = this.cnx.createStatement();
            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                Reclamation rc = new Reclamation();
                rc.setRefReclamation(rs.getString("refReclamation"));
                rc.setObjetReclamation(rs.getString("objetReclamation"));
                rc.setDescriptionReclamation(rs.getString("descriptionReclamation"));
                rc.setSuiviReclamation(rs.getString("suiviReclamation"));
                rc.setDateReclamation(rs.getDate("dateReclamation"));
                reclamations.add(rc);
                }
            System.out.println(reclamations);
            }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    return reclamations; 
    }
    
}
