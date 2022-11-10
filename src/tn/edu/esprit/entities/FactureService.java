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
public class FactureService extends DevisService{
    /*INSERT INTO `factureservice`(`idFactureService`,
    `factureServicePDF`, `dateFacture`, `idCommandeService`, `idDevisService`) */
        private int idFactureService;
        private Document facturePDF;
        private Date dateFacture;

    public FactureService(Document facturePDF, Date dateFacture, Date dateDevis, float totale, Utilisateur utilisateur, ServiceT service, java.sql.Date dateRequis, String statusCommande) {
        super(dateDevis, totale, utilisateur, service, dateRequis, statusCommande);
        this.facturePDF = facturePDF;
        this.dateFacture = dateFacture;
    }

    public FactureService(Document facturePDF, Date dateFacture, Date dateDevis, float totale, Utilisateur utilisateur, ServiceT service, java.sql.Date dateRequis, String statusCommande, String nomService, Float prixService, int idService, java.sql.Date dateCommandeService) {
        super(dateDevis, totale, utilisateur, service, dateRequis, statusCommande, nomService, prixService, idService, dateCommandeService);
        this.facturePDF = facturePDF;
        this.dateFacture = dateFacture;
    }

    public FactureService(int idFactureService, Document facturePDF, Date dateFacture, int idDevisService, Date dateDevis, float totale, int idCommandeService, Utilisateur utilisateur, ServiceT service, java.sql.Date dateRequis, String statusCommande) {
        super(idDevisService, dateDevis, totale, idCommandeService, utilisateur, service, dateRequis, statusCommande);
        this.idFactureService = idFactureService;
        this.facturePDF = facturePDF;
        this.dateFacture = dateFacture;
    }

    public FactureService() {
    }


    public int getIdFactureService() {
        return idFactureService;
    }

    public void setIdFactureService(int idFactureService) {
        this.idFactureService = idFactureService;
    }

    public Document getFacturePDF() {
        return facturePDF;
    }

    public void setFacturePDF(Document facturePDF) {
        this.facturePDF = facturePDF;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.idFactureService;
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
        final FactureService other = (FactureService) obj;
        if (this.idFactureService != other.idFactureService) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dateFacture=" + dateFacture + "Total" + super.getTotale() +'}';
    }

    
        
        
     
        
}
