/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import com.itextpdf.text.Document;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Facture extends Devis{
    /*INSERT INTO `facture`(`idFacture`, `dateFacture`, `facturePDF`, `idDevis`, `idCommande`)*/
    private int idFacture;
    private Date dateFacture;
    private Document facturePDF;

    public Facture(Date dateFacture, Document facturePDF, int idDevis, Date dateDevis, float totaleHT, float totale) {
        super(idDevis, dateDevis, totaleHT, totale);
        this.dateFacture = dateFacture;
        this.facturePDF = facturePDF;
    }

    public Facture(Date dateFacture, Document facturePDF, Date dateDevis, float totaleHT, float totale, Article article, String modeLivraison, Date dateCommande, Utilisateur utilisateur) {
        super(dateDevis, totaleHT, totale, article, modeLivraison, dateCommande, utilisateur);
        this.dateFacture = dateFacture;
        this.facturePDF = facturePDF;
    }

    public Facture(int idFacture, Date dateFacture, Document facturePDF, int idDevis, Date dateDevis, float totaleHT, float totale, int idCommande, Article article, String modeLivraison, Date dateCommande, Utilisateur utilisateur) {
        super(idDevis, dateDevis, totaleHT, totale, idCommande, article, modeLivraison, dateCommande, utilisateur);
        this.idFacture = idFacture;
        this.dateFacture = dateFacture;
        this.facturePDF = facturePDF;
    }

    public Facture() {
    }

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Document getFacturePDF() {
        return facturePDF;
    }

    public void setFacturePDF(Document facturePDF) {
        this.facturePDF = facturePDF;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idFacture;
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
        final Facture other = (Facture) obj;
        if (this.idFacture != other.idFacture) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "dateFacture=" + dateFacture + ", facturePDF=" + facturePDF + '}';
    }
    
    
    
}
