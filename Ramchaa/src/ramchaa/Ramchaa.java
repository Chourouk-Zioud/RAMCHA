
package ramchaa;

import java.sql.Connection;
import java.sql.Date;
import tn.ramcha.esprit.entities.Admin;
import tn.ramcha.esprit.entities.Demandeur;

import tn.ramcha.esprit.entities.Prestateur;

import tn.ramcha.esprit.entities.Utilisateur;
import tn.ramcha.esprit.services.ServiceUtilisateur;
import tn.ramcha.esprit.tools.DataR;



public class Ramchaa {

    public static void main(String[] args) {
        
        
        Connection cnx =DataR.getInstance().getConnection();

        Date date1= new Date(2023-1900,02,12);
        Date date2= new Date (2022-1900,05,07);
        Date date3 = new Date (2022-1900,11,02);
        Utilisateur ut1 = new Utilisateur ("07240005","bb","benbb",date1,"Mourouj",7755,"20879462","icherak@gmail.com","20593656");
        Utilisateur ut2 = new Utilisateur ("87565489","ichraf","benbbee",date2,"megrin",789,"599645","ichraf@gmail.com","26656565");
        Utilisateur ut4 = new Utilisateur ("88889","oussama","aliee",date2,"morneg",7889,"96230155","oussama@gmail.com","963258");
        Utilisateur ut3 = new Utilisateur ("87565489","malek","mej",date1,"ariana",485,"1234","malek@gmail.com","8564");
        Utilisateur ut5 = new Utilisateur ("12345","azert","azert",date3,"Touzeur",1235,"147852","azert@gmail.com","789456");
        Utilisateur ut6 = new Utilisateur ("987654","qsdf","qsdf",date3,"sfax",9999,"987654","qsdf@gmail.com","333344");
        ServiceUtilisateur su= new ServiceUtilisateur();
      
        Admin a = new Admin("444444","44444","q4444",date3,"sfax",9999,"99954","999@gmail.com","444");
        
        Prestateur p2 = new Prestateur("a","a","b","a","a");
        Prestateur p1 = new Prestateur ("ok","ok","ok","ok","ok");
        Demandeur d1 = new Demandeur ("Demandeur Service");
        
     
       
      //su.getOneD(5);
      //su.getAllD();
       
   
      
      //su.supprimer(20);
      
      //ut5.setIdUser(18);
      //su.modifierRole(ut5);
      
      //.setIdUser(16);
      //su.modifier(ut3);
      
      //d1.setIdUser(17);
      //su.modifierD(d1);
      
     // Utilisateur ut8 = new Utilisateur ("888805","oob","okoknbb",date1,"Mourouj",7755,"20879462","icherak@gmail.com","20593656");
      
     // su.ajouter(ut8);
      
       d1.setIdUser(25);
      su.modifierD(d1);
      
    }
    
}
