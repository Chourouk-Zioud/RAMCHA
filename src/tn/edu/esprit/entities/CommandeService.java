/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class CommandeService {
    private int idCommandeService;
    private Utilisateur utilisateur;
    private ServiceT service;
    private Date dateRequis;
    private String statusCommande;
    private String nomService;
    private Float prixService;
    private int idService;
    private Date dateCommandeService;
    private int nbjour;

    public CommandeService(int idCommandeService, Utilisateur utilisateur, ServiceT service, Date dateRequis, String statusCommande, String nomService, Float prixService, int idService, Date dateCommandeService) {
        this.idCommandeService = idCommandeService;
        this.utilisateur = utilisateur;
        this.service = service;
        this.dateRequis = dateRequis;
        this.statusCommande = statusCommande;
        this.nomService = nomService;
        this.prixService = prixService;
        this.idService = idService;
        this.dateCommandeService = dateCommandeService;
    }

    public CommandeService(Utilisateur utilisateur, ServiceT service, Date dateRequis, String statusCommande, String nomService, Float prixService, int idService, Date dateCommandeService) {
        this.utilisateur = utilisateur;
        this.service = service;
        this.dateRequis = dateRequis;
        this.statusCommande = statusCommande;
        this.nomService = nomService;
        this.prixService = prixService;
        this.idService = idService;
        this.dateCommandeService = dateCommandeService;
    }

    public CommandeService(Utilisateur utilisateur, ServiceT service, Date dateRequis, String statusCommande) {
        this.utilisateur = utilisateur;
        this.service = service;
        this.dateRequis = dateRequis;
        this.statusCommande = statusCommande;
    }

    public CommandeService(int idCommandeService, Utilisateur utilisateur, ServiceT service, Date dateRequis, String statusCommande) {
        this.idCommandeService = idCommandeService;
        this.utilisateur = utilisateur;
        this.service = service;
        this.dateRequis = dateRequis;
        this.statusCommande = statusCommande;
    }

    public int getNbjour() {
        return nbjour;
    }

    public void setNbjour(int nbjour) {
        this.nbjour = nbjour;
    }

    
    
    
    public Date getDateCommandeService() {
        return dateCommandeService;
    }

    public void setDateCommandeService(Date dateCommandeService) {
        this.dateCommandeService = dateCommandeService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public Float getPrixService() {
        return prixService;
    }

    public void setPrixService(Float prixService) {
        this.prixService = prixService;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public CommandeService() {
    }

    
    
    
    
    public String getStatusCommande() {
        return statusCommande;
    }

    public void setStatusCommande(String statusCommande) {
        this.statusCommande = statusCommande;
    }

    

    public int getIdCommandeService() {
        return idCommandeService;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public ServiceT getService() {
        return service;
    }

    public Date getDateRequis() {
        return dateRequis;
    }

    public void setIdCommandeService(int idCommandeService) {
        this.idCommandeService = idCommandeService;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setService(ServiceT service) {
        this.service = service;
    }

    public void setDateRequis(Date dateRequis) {
        this.dateRequis = dateRequis;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idCommandeService;
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
        final CommandeService other = (CommandeService) obj;
        if (this.idCommandeService != other.idCommandeService) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CommandeService{" + "idCommandeService=" + idCommandeService + ", , service=" + service + ", dateRequis=" + dateRequis + '}';
    }
    
    
}
