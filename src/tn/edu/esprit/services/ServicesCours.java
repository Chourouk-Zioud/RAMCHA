/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.tools.DataS;



/**
 *
 * @author asus
 */
public class ServicesCours implements IServicesFormation <Cours> {
    
    Connection cnx;
        Cours c=new Cours();
    
     public ServicesCours(){
      this.cnx =DataS.getInstance().getConnection();
     } 
     
    @Override
    public void ajouter(Cours F) {
          try {
            String req = "INSERT INTO `cours_first`(`nomCours`, `categorieCours`, `sujetCours`, `niveauCours`) VALUES ('"+ F.getNomCours()+"','"+ F.getCategoriesCours()+"','"+ F.getSujetCours()+"','"+ F.getNiveauCours()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("cours Ajouté avec succés");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    
        public void affecter_chapitreTocour(int idCour , int idChapitre) {
            ServicesChapitre cc = new ServicesChapitre();
          try {
              if (getOne(idCour) != null && cc.getOne(idChapitre)!= null ){
                  System.out.println("e");
            String req = "INSERT INTO `cours_chapitre`(`idCours`, `IdChapitre`) VALUES ('"+ idCour+"','"+ idChapitre+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("chapitre affecter to cour");}
              else {
                  System.out.println("Cour or chapitre n'existe pas");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }

    @Override
    public void modifier(Cours f) {
          try {
            String req="UPDATE `cours_first` SET `nomCours`=?,`categorieCours`=?,`sujetCours`=?,`niveauCours`=? where idfirst="+f.getIdCours() ;
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, f.getNomCours());
            st.setString(2, f.getCategoriesCours());
            st.setString(3, f.getSujetCours());
            st.setString(4, f.getNiveauCours());
            st.executeUpdate();
            System.out.println("cours Modifier avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
       
    }

    @Override
    public void supprimer(int idCours) {
         try {
            String req = "DELETE FROM `cours_first` WHERE Idfirst="+idCours;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("cours supprimer avec succés");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }

    @Override
    public Cours getOne(int id) {
                String rep = "SELECT * FROM `Cours_first` WHERE idfirst="+id;
       Cours cs = new Cours();
        Statement stm;
        
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);
           
            while (rs.next()) {
                
                cs.setIdCours(rs.getInt(1));
                cs.setNomCours(rs.getString("nomCours"));
                cs.setCategoriesCours(rs.getString("categorieCours"));
                cs.setSujetCours(rs.getString("sujetCours"));
                cs.setNiveauCours(rs.getString("niveauCours"));
            }
         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(cs);

        return cs;
        
    }

    @Override
    public  ObservableList<Cours> getAll() {
           String rep = "SELECT * FROM `cours_first`" ;
           ObservableList<Cours> cours =  FXCollections.observableArrayList();
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
                Cours cr = new Cours();
               
               cr.setIdCours(rs.getInt(1));
               cr.setNomCours(rs.getString("nomCours"));
               cr.setCategoriesCours(rs.getString("categorieCours"));
               cr.setSujetCours(rs.getString("sujetCours"));
               cr.setNiveauCours(rs.getString("niveauCours"));
               
              
               List<Chapitre> ch = getAllChap(cr.getIdCours());
               
                
                cours.add(cr);
            
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            System.out.println(cours);

        return cours;
      
    }
    
        public List<Chapitre> getCourChapitres(int idCours) {
            getOne(idCours);
           String rep = "SELECT `idCours`, `IdChapitre` FROM `cours_chapitre` WHERE `idCours` ="+idCours ;
          List<Chapitre> ch = FXCollections.observableArrayList();
       
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rep);

            while (rs.next()) {
              Cours cr = new Cours();
              ServicesChapitre cc = new ServicesChapitre();
            Chapitre c = new Chapitre();
            c = cc.getOne(rs.getInt(2));
               
                System.out.println(c);    
                ch.add(c);
            
                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
     //   System.out.println(ch);

        return ch;
      
    }
    
   public List<Chapitre> getAllChap(int id)
   {
        List<Chapitre> list = new ArrayList<>();
        try {
            String req = "Select idfirst_id,idChapitre,nomChapitre,langueChapitre,typeChapitre from Chapitre where idfirst_id="+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
                Cours c = getOne(rs.getInt("idfirst_id"));
               
                Chapitre p = new Chapitre( rs.getInt("idChapitre"),rs.getString("nomChapitre"),rs.getString("langueChapitre"),rs.getString("typeChapitre"),c);
              
                list.add(p);
            }
                  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         System.out.println("chapitre="+list);

        return list;
   }

    @Override
    public List<AvisCours> getAll(int idCours) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void ImportExel()
    {
         ObservableList<Cours> list = getAll();
         
         try {
   PrintWriter pw= new PrintWriter(new File("Cours_table.csv"));
   StringBuilder sb=new StringBuilder();
   sb.append("Nom Cour");
   sb.append(",");
   sb.append("Categorie");
   sb.append(",");
   sb.append("Sujet");
     sb.append(",");
    sb.append("Niveau");
   sb.append("\n");
   
             for (Cours c : list) {
                sb.append(c.getNomCours());
                    sb.append(",");
                    sb.append(c.getCategoriesCours());
                    sb.append(",");
                    sb.append(c.getSujetCours());
                      sb.append(",");
                     sb.append(c.getNiveauCours());
                    sb.append("\n"); 
             }
  
   pw.write(sb.toString());
   pw.close();
   System.out.println("finished");
   } catch (Exception e) {
      // TODO: handle exception
   }
    }
    
        public int testNom(String n)
    {
        for (Cours c : getAll()) {
            if (c.getNomCours().equals(n))
                return 1;
        }
    return 0;}
    
    public int testMn(String n)
    {
       
            if (n.startsWith("-"))
                return 1;
        
    return 0;}
    
    }

