/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.entities.Magasin;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class ServiceMagasin {
    Connection cnx;

    public ServiceMagasin() {
    }

    public ServiceMagasin(Connection cnx) {
        this.cnx = cnx;
    }
    
    
    public void ajouter(Magasin m) {
        try {
            String req = "INSERT INTO `magasin`(`nomMagasin`, `adresseMagasin`, `emailMagasin`, `telMagasin`) VALUES ('"+m.getNomMagasin()+"','"+m.getAdresseMagasin()+"','"+m.getEmailMagasin()+"','"+m.getTelMagasin()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Magasin Ajouter avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void supprimer(int id) {
                try {
            String req = "DELETE FROM `magasin` WHERE `idMagasin`="+id;
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("Magasin supprimer avec succés");
             } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
        
        
        public void modifier(Magasin m) {
          
      try {
            String req="UPDATE `magasin` SET `nomMagasin`=?,`adresseMagasin`=?,`emailMagasin`=?,`telMagasin`=? WHERE `idMagasin`="+m.getIdMagasin();
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, m.getNomMagasin());
            st.setString(2, m.getAdresseMagasin());
            st.setString(3, m.getEmailMagasin());
            st.setString(4, m.getTelMagasin());
         
            st.executeUpdate();
            System.out.println("Magasin Modifié avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
  }
    public ObservableList<Magasin> getAll() {
         String rep = "SELECT * FROM `magasin`";
        ObservableList<Magasin> mission = FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Magasin m = new  Magasin();
                m.setIdMagasin(rs.getInt(1));
                m.setNomMagasin(rs.getString(2));
                m.setAdresseMagasin(rs.getString(3));
                m.setEmailMagasin(rs.getString(4));
                m.setTelMagasin(rs.getString(5));
                
                mission.add(m);
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(mission+"\n");
        return mission;
    }
    
    public Magasin getOne(int id) {
         String rep = "SELECT * FROM `magasin` WHERE `idMagasin` ="+id;
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Magasin m = new  Magasin();
                m.setIdMagasin(rs.getInt(1));
                m.setNomMagasin(rs.getString(2));
                m.setAdresseMagasin(rs.getString(3));
                m.setEmailMagasin(rs.getString(4));
                m.setTelMagasin(rs.getString(5));
                System.out.println(m);

                return m;
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    
    
    
 public void pdf(){
    try {
            String file_name = "..\\RAMCHA\\src\\documents\\Liste_Magasins.pdf";
            Document document = new Document();
          Paragraph para = new Paragraph("List des Magasins \n");
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            
            for (Magasin m : getAll()) {
                           para.add( "\n Magasin : nomMagasin=" + m.getNomMagasin() + ", adresseMagasin=" + m.getAdresseMagasin() + ", emailMagasin=" + m.getEmailMagasin() + ", telMagasin=" + m.getTelMagasin() );
    }
 
            document.open();
            document.add(para);
            document.close();
        } catch (FileNotFoundException ex) {
        } catch (DocumentException ex) {
        }
    }
 
 public int testNom(String Nom)
 {
        String rep = "SELECT * FROM `magasin`";
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Magasin m = new  Magasin();
                m.setIdMagasin(rs.getInt(1));
                m.setNomMagasin(rs.getString(2));
                m.setAdresseMagasin(rs.getString(3));
                m.setEmailMagasin(rs.getString(4));
                m.setTelMagasin(rs.getString(5));
                
                if(m.getNomMagasin().equals(Nom))
                {return 1;}
            
    }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

 return 0;
 }
}
