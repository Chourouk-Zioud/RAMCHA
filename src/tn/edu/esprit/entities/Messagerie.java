/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author chalg
 */
public class Messagerie {
    
private int idMessage ;
private int idExpediteur;
private int idRecepteur;
private String message;
private boolean vu;
private Utilisateur expediteur;
private Utilisateur recepteur;


public  Messagerie() {}

public  Messagerie(Utilisateur expediteur,Utilisateur recepteur,String message,boolean vu){
    
    this.expediteur = expediteur ;
    this.recepteur = recepteur ;
    this.message = message ;
    this.vu = vu ;
}

public  Messagerie(int idMessage,Utilisateur expediteur,Utilisateur recepteur,String message,boolean vu){
    
    this.idMessage = idMessage ;
    this.expediteur = expediteur ;
    this.recepteur = recepteur ;
    this.message = message ;
    this.vu = vu ;
}

public  Messagerie(int idMessage,int idExpediteur,int idRecepteur,Utilisateur expediteur,Utilisateur recepteur,String message,boolean vu){
    
    this.idMessage = idMessage ;
    this.idExpediteur = idExpediteur ;
    this.idRecepteur = idRecepteur ;
    this.message = message ;
    this.vu = vu ;
}


    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdExpediteur() {
        return idExpediteur;
    }

    public void setIdExpediteur(int idExpediteur) {
        this.idExpediteur = idExpediteur;
    }

    public int getIdRecepteur() {
        return idRecepteur;
    }

    public void setIdRecepteur(int idRecepteur) {
        this.idRecepteur = idRecepteur;
    }

    public Utilisateur getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(Utilisateur expediteur) {
        this.expediteur = expediteur;
    }

    public Utilisateur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Utilisateur recepteur) {
        this.recepteur = recepteur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isVu() {
        return vu;
    }

    public void setVu(boolean vu) {
        this.vu = vu;
    }

    @Override
    public String toString() {
        return "Messagerie{" + "expediteur=" + expediteur + ", recepteur=" + recepteur + ", message=" + message + ", vu=" + vu + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idMessage;
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
        final Messagerie other = (Messagerie) obj;
        if (this.idMessage != other.idMessage) {
            return false;
        }
        return true;
    }

    

}