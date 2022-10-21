/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author chalg
 */
public class Reclamation {
    
    private int idReclamation;
    private int idUser;
    private String refReclamation;
    private String objetReclamation;
    private String descriptionReclamation;
    private String suiviReclamation;
    private Date dateReclamation;
    private Utilisateur utilisateur;
    
    
    public Reclamation(){
    }

    
    public Reclamation(int idUser,String refRectionlamation,String objetReclamation,String descriptionReclamation,String suiviReclamation,Date dateReclamation){
        
        this.idUser = idUser;
        this.refReclamation = refReclamation;
        this.objetReclamation = objetReclamation;
        this.descriptionReclamation = descriptionReclamation;
        this.suiviReclamation = suiviReclamation;
        this.dateReclamation = dateReclamation;
        /****/
    }
    
    public Reclamation(int idReclamation,int idUser,String refRectionlamation,String objetReclamation,String descriptionReclamation,String suiviReclamation,Date dateReclamation){
        
        this.idReclamation = idReclamation ;
        this.idUser = idUser;
        this.objetReclamation = refReclamation;
        this.objetReclamation = objetReclamation;
        this.descriptionReclamation = descriptionReclamation;
        this.suiviReclamation = suiviReclamation;
        this.dateReclamation = dateReclamation;
        //this.utilisateur = utilisateur;
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    public String getRefReclamation() {
        return refReclamation;
    }

    public void setRefReclamation(String refReclamation) {
        this.refReclamation = refReclamation;
    }

    public String getObjetReclamation() {
        return objetReclamation;
    }

    public void setObjetReclamation(String objetReclamation) {
        this.objetReclamation = objetReclamation;
    }

    public String getDescriptionReclamation() {
        return descriptionReclamation;
    }

    public void setDescriptionReclamation(String descriptionReclamation) {
        this.descriptionReclamation = descriptionReclamation;
    }

    public String getSuiviReclamation() {
        return suiviReclamation;
    }

    public void setSuiviReclamation(String suiviReclamation) {
        this.suiviReclamation = suiviReclamation;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "refReclamation=" + refReclamation + ", objetReclamation=" + objetReclamation + ", descriptionReclamation=" + descriptionReclamation + ", suiviReclamation=" + suiviReclamation + ", dateReclamation=" + dateReclamation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idReclamation;
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
        final Reclamation other = (Reclamation) obj;
        if (this.idReclamation != other.idReclamation) {
            return false;
        }
        return true;
    }
    
}
