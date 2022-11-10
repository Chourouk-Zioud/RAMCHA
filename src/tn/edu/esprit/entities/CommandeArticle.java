/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.util.ArrayList;
import java.util.Date;
import tn.edu.esprit.entities.Article;

public class CommandeArticle {
    
    private int idCommande;
    private Article article;
    private String modeLivraison;
    private String statusLivraison = "En cours de traitement";
    private Date dateCommande;
    private Utilisateur utilisateur;
    private String nomArticle;
    private float prixArticle;

    
    private int idArticle;
    
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }
    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public float getPrixArticle() {
        return prixArticle;
    }

    public void setPrixArticle(float prixArticle) {
        this.prixArticle = prixArticle;
    }

    public CommandeArticle() {
    }

    public CommandeArticle(int idCommande, Article article, String modeLivraison, Date dateCommande, Utilisateur utilisateur) {
        this.idCommande = idCommande;
        this.article = article;
        this.modeLivraison = modeLivraison;
        this.dateCommande = dateCommande;
        this.utilisateur = utilisateur;
    }

    public CommandeArticle(Article article, String modeLivraison, Date dateCommande, Utilisateur utilisateur) {
        this.article = article;
        this.modeLivraison = modeLivraison;
        this.dateCommande = dateCommande;
        this.utilisateur = utilisateur;
    }

    public int getArticle() {
        return article.getIdArticle();
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getUtilisateur() {
        return utilisateur.getIdUser();
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    

    public int getIdCommande() {
        return idCommande;
    }

    public String getModeLivraison() {
        return modeLivraison;
    }

    public String getStatusLivraison() {
        return statusLivraison;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    

    public void setModeLivraison(String modeLivraison) {
        this.modeLivraison = modeLivraison;
    }

    public void setStatusLivraison(String statusLivraison) {
        this.statusLivraison = statusLivraison;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.idCommande;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CommandeArticle other = (CommandeArticle) obj;
        if (this.idCommande != other.idCommande) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande{modeLivraison=" + modeLivraison + ", statusLivraison=" + statusLivraison + ", dateCommande=" + dateCommande + '}';
    }

}
