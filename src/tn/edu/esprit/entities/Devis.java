/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;
import tn.edu.esprit.entities.Article;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class Devis extends CommandeArticle {
    private int idDevis;
    private Date dateDevis ;
    private float totaleHT;
    private float totale;
    
    public Devis(){
    }

    public Devis(int idDevis, Date dateDevis, float totaleHT, float totale) {
        this.idDevis = idDevis;
        this.dateDevis = dateDevis;
        this.totaleHT = totaleHT;
        this.totale = totale;
    }

    public Devis(Date dateDevis, float totaleHT, float totale, Article article, String modeLivraison, Date dateCommande, Utilisateur utilisateur) {
        super(article, modeLivraison, dateCommande, utilisateur);
        this.dateDevis = dateDevis;
        this.totaleHT = totaleHT;
        this.totale = totale;
    }

    public Devis(int idDevis, Date dateDevis, float totaleHT, float totale, int idCommande, Article article, String modeLivraison, Date dateCommande, Utilisateur utilisateur) {
        super(idCommande, article, modeLivraison, dateCommande, utilisateur);
        this.idDevis = idDevis;
        this.dateDevis = dateDevis;
        this.totaleHT = totaleHT;
        this.totale = totale;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idDevis;
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
        final Devis other = (Devis) obj;
        if (this.idDevis != other.idDevis) {
            return false;
        }
        return true;
    }


    
  
    
    
    
    public int getIdDevis() {
        return idDevis;
    }

    public Date getDateDevis() {
        return dateDevis;
    }

    public float getTotaleHT() {
        return totaleHT;
    }

    public float getTotale() {
        return totale;
    }

    public void setIdDevis(int idDevis) {
        this.idDevis = idDevis;
    }

    public void setDateDevis(Date dateDevis) {
        this.dateDevis = dateDevis;
    }

    public void setTotaleHT(float totaleHT) {
        this.totaleHT = totaleHT;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    @Override
    public String toString() {
        return "Devis{" + "idDevis=" + idDevis + ", dateDevis=" + dateDevis + ", totaleHT=" + totaleHT + ", totale=" + totale + '}';
    }
  
    

    
    
    
    

}
