/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class DevisService extends CommandeService{
    protected int idDevisService;
    protected Date dateDevis ;
    protected float totale;

    public DevisService() {
    }

    public DevisService(Date dateDevis, float totale, Utilisateur utilisateur, ServiceT service, java.sql.Date dateRequis, String statusCommande) {
        super(utilisateur, service, dateRequis, statusCommande);
        this.dateDevis = dateDevis;
        this.totale = totale;
    }

    public DevisService(Date dateDevis, float totale, Utilisateur utilisateur, ServiceT service, java.sql.Date dateRequis, String statusCommande, String nomService, Float prixService, int idService, java.sql.Date dateCommandeService) {
        super(utilisateur, service, dateRequis, statusCommande, nomService, prixService, idService, dateCommandeService);
        this.dateDevis = dateDevis;
        this.totale = totale;
    }
    
    

    public DevisService(int idDevisService, Date dateDevis, float totale, int idCommandeService, Utilisateur utilisateur, ServiceT service, java.sql.Date dateRequis, String statusCommande) {
        super(idCommandeService, utilisateur, service, dateRequis, statusCommande);
        this.idDevisService = idDevisService;
        this.dateDevis = dateDevis;
        this.totale = totale;
    }

    public int getIdDevisService() {
        return idDevisService;
    }

    public Date getDateDevis() {
        return dateDevis;
    }

    public float getTotale() {
        return totale;
    }

    public void setIdDevisService(int idDevisService) {
        this.idDevisService = idDevisService;
    }

    public void setDateDevis(Date dateDevis) {
        this.dateDevis = dateDevis;
    }

    public void setTotale(float totale) {
        this.totale = totale;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idDevisService;
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
        final DevisService other = (DevisService) obj;
        if (this.idDevisService != other.idDevisService) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DevisService{" + "dateDevis=" + dateDevis + ", totale=" + totale + '}';
    }
    
    
    
    
}
