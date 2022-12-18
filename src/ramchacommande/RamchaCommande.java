/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramchacommande;

import com.google.zxing.WriterException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import tn.edu.esprit.entities.Article;
import tn.edu.esprit.entities.CommandeArticle;
import tn.edu.esprit.entities.CommandeService;
import tn.edu.esprit.entities.Devis;
import tn.edu.esprit.entities.DevisService;
import tn.edu.esprit.entities.GenerateQRCode;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.services.CommandeServices;

import tn.edu.esprit.tools.DataS;

/**
 *
 * @author ASUS
 */
public class RamchaCommande {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws WriterException, IOException {
        Connection cnx = DataS.getInstance().getConnection();
        Article a = new Article();
        a.setIdArticle(10);
        Article b = new Article();
        b.setIdArticle(54);
        Article c = new Article();
        ArrayList article = new ArrayList();
        article.add(a);
        article.add(b);
        article.add(c);
        Article e = new Article();
        c.setIdArticle(55);
        Date date1 = new Date(2022 - 1900, 5, 7);
        //Utilisateur u1 = new Utilisateur(1, 55, "sarra", "zitoun", "ben arous", 2013, "achrefzitoun0@gmail.com", "26977557", date1);
        //Utilisateur u2 = new Utilisateur(6, 956, "achref", "zitoun", "ben arous", 2013, "achref.zitoun@esprit.tn", "26977557", date1);
        CommandeArticle c1 = new CommandeArticle();
        CommandeArticle c2 = new CommandeArticle();
        c1.setModeLivraison("A domicile");
        //c1.setUtilisateur(u2);
        Devis d = new Devis();
        c1.setIdCommande(34);

        CommandeServices su = new CommandeServices();
        //su.ajouterCommandeArticle(c1,u1,article);
        //su.modifierCommandeArticleAdmin(c1,u2);
        //su.supprimerCommandeArticle(c1);
        //su.getAll();
        //Service s1 = new Service();
        //s1.setIdService(2);
        CommandeService c3 = new CommandeService();
        c3.setDateRequis(date1);
        //c3.setUtilisateur(u1);
        c3.setIdCommandeService(6);

        CommandeServices sv = new CommandeServices();
        //sv.ajouterCommandeService(s1, u1, c3);
        //sv.modifierCommandeServiceAdmin(c3);
        //sv.supprimerCommandeService(c3);
        //sv.getOne(8);

        //sd.ajouterDevisArticle(c1);
        //sd.ajouterDevisService(c3);
        //sd.getOneArticle(0);
        //sd.getOneService(1);
        //sv.genererFactureServicePDF(1);
        String m = "Nom et prénom du demandeur : " + "\n"
                    + "Adress du demandeur : " + "\n"
                    + "Service demandé : " + "\n"
                    + "Date du commande : " + "\n"
                    + "Date requis : " + "\n"
                    + "Nombre de jours : " +"\n"
                    + "Prix du service ( par jour ) : " +"\n"
                    + "Total : " + "\n"
                    + "Status de la commande : " ;
            File myObj = new File("C:\\Users\\ASUS\\Desktop\\Facture\\QRService.jpg");
            GenerateQRCode u = new GenerateQRCode();
            u.createQRImage(myObj, m, 500, "jpg");
            
            
            
            
            
            
            
            
            
            
            
            
    }

}
