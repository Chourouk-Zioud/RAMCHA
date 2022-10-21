/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramcha1;

import java.sql.Connection;
import java.util.List;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Chapitre;
import tn.edu.esprit.entites.Cours;
import tn.edu.esprit.services.ServicesAvisCours;
import tn.edu.esprit.services.ServicesChapitre;
import tn.edu.esprit.services.ServicesCours;
import tn.edu.esprit.tools.DataBase;

/**
 *
 * @author asus
 */
public class Ramcha1 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       Connection cnx =DataBase.getInstance().getConnection();
       //Cours tech = new Cours ("math","L","gh","huk",3);
      // Cours tp = new Cours ("phy","gg","ghyy","ghh",12);
      // Cours tp1 = new Cours(1,"a","hhh","ghyy","ghh");
         Cours oo = new Cours("nn","nn","ynn","nn");
       //Chapitre c= new Chapitre(1,"chapitre 2", "fr", "dadadada",tp1);
      // Cours tp5= new Cours( 2,"dadaad", "aa","aa", "aa");
        AvisCours hh= new AvisCours(2,11,2,"hhjkkll");
       ServicesAvisCours ac = new ServicesAvisCours();
       AvisCours hh1= new AvisCours(1,6,11,2,"aggfaaaaaaaaaaaaaaaaaa");
       ac.ajouter(hh);
      // ac.ajouter(hh);
       ac.modifier(hh1);
     // sc.affecter_chapitreTocour(1, 2);
       //sc.getCourChapitres(1);
     //  sc.ajouter(oo);
      //sc.getAll();
      // sc.supprimer(3);
       //sc.getOne(2);
     // sc.modifier(c);
    }
    
}
