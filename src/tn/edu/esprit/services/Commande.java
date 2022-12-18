/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.ArrayList;
import java.util.Date;
import javafx.collections.ObservableList;
import tn.edu.esprit.entities.Article;
import tn.edu.esprit.entities.CommandeArticle;
import tn.edu.esprit.entities.CommandeService;
import tn.edu.esprit.entities.Devis;
import tn.edu.esprit.entities.DevisService;
import tn.edu.esprit.entities.Facture;
import tn.edu.esprit.entities.FactureService;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.entities.Utilisateur;

/**
 *
 * @author ASUS
 */
public interface Commande {
    
    ///////////////// ARTICLE /////////////////
    
    public void ajouterCommandeArticle(CommandeArticle t, Utilisateur u, ArrayList<Article> a);
    public void modifierCommandeArticleUtilisateur(CommandeArticle t);
    public void supprimerCommandeArticle(CommandeArticle t);
    public ObservableList<CommandeArticle> getCommande(int id);
    public ObservableList<Article> getAllArticle();
     public float calculerTotaleHT(int z);

    //////////////// SERVICE //////////////////
     
    public void ajouterCommandeService(ServiceT s, Utilisateur u, CommandeService a);
    public void modfierCommanderServiceClient ( CommandeService a);
    public void supprimerCommandeService(CommandeService a);
    public ObservableList<CommandeService> getCommandeS(int id);
    public ObservableList<ServiceT> getAllService();
    
    //////////////// Devis //////////////////
    
    public void ajouterDevisArticle(Devis a);
    public void ajouterDevisService(DevisService a);
    public void genererDevisArticlePDF(int id);
    public void genererDevisServicePDF(int id);
    
    //////////////// Facture //////////////////

    public void ajouterFactureArticle(Facture a);
    public void ajouterFactureService(FactureService a);
    public void genererFactureArticlePDF(int id);
    public void genererFactureServicePDF(int id);
    
    //////////////// ADMIN ///////////////////
    
    public ObservableList<CommandeService> getAllCommandeSer();
    public ObservableList<CommandeArticle> getAllCommandeArt();
    public void modifierCommandeArticleAdmin(CommandeArticle a);
    public void modifierCommandeServiceAdmin(CommandeService a);
    public ObservableList<FactureService> getAllFactureSer();
    public ObservableList<Facture> getAllFactureArt();
    
    //////////////// Calcul des commandes ////
    
    public int calculCommandeArticleTraitement(int a);
    public int calculCommandeArticleLivraison(int a);
    public int calculCommandeArticleTraitee(int a);

    public int calculCommandeServiceTraitement(int a);
    public int calculCommandeServiceLivraison(int a);
    public int calculCommandeServiceTraitee(int a);


    
}
