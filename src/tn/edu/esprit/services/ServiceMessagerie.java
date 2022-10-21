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
import tn.edu.esprit.entities.Messagerie;
import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author chalg
 */
public class ServiceMessagerie implements IServiceMessagerie<Messagerie>{
    
    Connection cnx ;

    public ServiceMessagerie(){
    this.cnx= DataSource.getInstance().getConnection();
    }

    @Override
    public void ajouter(Messagerie m) {
        try {
            String req = "INSERT INTO `messagerie`(`idExpediteur`, `idRecepteur`, `message`, `vu`) VALUES ('"+m.getIdExpediteur()+"','"+m.getIdRecepteur()+"','"+m.getMessage()+"','"+m.isVu()+"')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Messagerie m) {
        try {
            String req = "UPDATE `messagerie` SET `idExpediteur`=?,`idRecepteur`=?,`message`=?,`vu`=? WHERE `IdMessage`=?";
            PreparedStatement stm = cnx.prepareStatement(req);
            
            stm.setInt(1, m.getIdExpediteur());
            stm.setInt(2, m.getIdRecepteur());
            stm.setString(3, m.getMessage());
            stm.setBoolean(4, m.isVu());;
            
            stm.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `messagerie` WHERE `IdMessage` ="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Messagerie getOne(int id) {
        String req = "SELECT `idExpediteur`, `idRecepteur`, `message`, `vu` FROM `messagerie` WHERE IdMessage="+id;
        Statement stm;
        Messagerie rc = new Messagerie();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()){
                rc.setIdExpediteur(rs.getInt("idExpediteur"));
                rc.setIdRecepteur(rs.getInt("idRecepteur"));
                rc.setMessage(rs.getString("message"));
                rc.setVu(rs.getBoolean("vu"));
            }
            System.out.println(rc);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
        return rc ;
    }

    @Override
    public List<Messagerie> getAll() {
        String req = "SELECT * FROM `messagerie`";
        ArrayList<Messagerie> messageries = new ArrayList();
        Statement stm;
        
        try {
            stm = this.cnx.createStatement();
            ResultSet rs=  stm.executeQuery(req);
            while (rs.next()){
                Messagerie msg = new Messagerie();
                msg.setIdExpediteur(rs.getInt("idExpediteur"));
                msg.setIdRecepteur(rs.getInt("idRecepteur"));
                msg.setMessage(rs.getString("message"));
                msg.setVu(rs.getBoolean("vu"));
                messageries.add(msg);
                }
            System.out.println(messageries);
            }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            }
    return messageries; 
    }
    
}
