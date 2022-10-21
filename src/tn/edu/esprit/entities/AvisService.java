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
public class AvisService {
    
    private int idAvisService ;
    private int idUser ;
    private int idService ;
    private String detailAvisService ;
    private int noteService ;
    private Service service;
    private Utilisateur utilisateur;

public  AvisService() {}

public  AvisService(int idUser,int idService,String detailAvisService,int noteService) {

    this.idUser = idUser ;
    this.idService = idService ;
    this.detailAvisService = detailAvisService ;
    this.noteService = noteService ;
}

public  AvisService(int idAvisService,int idUser,int idService,String detailAvisService,int noteService) {

    this.idAvisService = idAvisService ;
    this.idUser = idUser ;
    this.idService = idService ;
    this.detailAvisService = detailAvisService ;
    this.noteService = noteService ;
}

    public int getIdAvisService() {
        return idAvisService;
    }

    public void setIdAvisService(int idAvisService) {
        this.idAvisService = idAvisService;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getDetailAvisService() {
        return detailAvisService;
    }

    public void setDetailAvisService(String detailAvisService) {
        this.detailAvisService = detailAvisService;
    }

    public int getNoteService() {
        return noteService;
    }

    public void setNoteService(int noteService) {
        this.noteService = noteService;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "AvisService{" + "detailAvisService=" + detailAvisService + ", noteService=" + noteService + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idAvisService;
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
        final AvisService other = (AvisService) obj;
        if (this.idAvisService != other.idAvisService) {
            return false;
        }
        return true;
    }

   
    
}
    
    
    