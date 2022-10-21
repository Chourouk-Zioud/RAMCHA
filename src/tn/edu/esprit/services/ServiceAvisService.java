/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.edu.esprit.entities.AvisService;
import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author chalg
 */
public class ServiceAvisService implements IServiceAvisService<AvisService>{
    
    Connection cnx ;

    public ServiceAvisService(){
    this.cnx= DataSource.getInstance().getConnection();
    }
    
    @Override
    public void ajouter(AvisService av) {
        try {
            String req = "INSERT INTO `avisservice`(`idUser`, `idService`, `detailAvisService`, `noteService`) VALUES ('"+av.getIdUser()+"','"+av.getIdService()+"','"+av.getDetailAvisService()+"','"+av.getNoteService()+"')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(AvisService av) {
        try {
            String req = "UPDATE `avisservice` SET `idUser`=?,`idService`=?,`detailAvisService`=?,`noteService`=? WHERE IdAvisService=?";
            PreparedStatement stm = cnx.prepareStatement(req);
            
            stm.setInt(1, av.getIdUser());
            stm.setInt(2, av.getIdService());
            stm.setString(3, av.getDetailAvisService());
            stm.setInt(4, av.getNoteService());
            stm.setInt(5, av.getIdAvisService());
            
            stm.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `avisservice` WHERE `idAvisService` ="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public AvisService getOne(int id) {
        
        String req = "SELECT `idUser`,`idService`, `detailAvisService`,`noteService` FROM `avisservice` WHERE `IdAvisService` ="+id;
        Statement stm;
        AvisService av = new AvisService();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()){
                av.setIdUser(rs.getInt("idUser"));
                av.setIdService(rs.getInt("idService"));
                av.setDetailAvisService(rs.getString("detailAvisService"));
                av.setNoteService(rs.getInt("noteService"));
            }
            System.out.println(av);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        return av ;
    }

    @Override
    public List getAll() {
        String req = "SELECT * FROM `avisservice`";
        ArrayList<AvisService> avisservices = new ArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                AvisService av = new AvisService();
                av.setIdUser(rs.getInt("idUser"));
                av.setIdService(rs.getInt("idService"));
                av.setDetailAvisService(rs.getString("detailAvisService"));
                av.setNoteService(rs.getInt("noteService"));
                avisservices.add(av);
                }
            System.out.println(avisservices);
            }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    return avisservices; 
    }
}
