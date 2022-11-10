/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entites;

/**
 *
 * @author asus
 */
public class AvisCours {
    
    private int idAvisCours;
    private int rate;
   private int IdUtilisateur;
   private int idCour;
private String commentaire;

    public AvisCours(int idAvisCours, int rate, int IdUtilisateur, int idCour, String commentaire) {
        this.idAvisCours = idAvisCours;
        this.rate = rate;
        this.IdUtilisateur = IdUtilisateur;
        this.idCour = idCour;
        this.commentaire = commentaire;
    }

    public AvisCours(int rate, int IdUtilisateur, int idCour, String commentaire) {
        this.rate = rate;
        this.IdUtilisateur = IdUtilisateur;
        this.idCour = idCour;
        this.commentaire = commentaire;
    }

    public AvisCours() {
    }

    public AvisCours(int idAvisCours, int rate, String commentaire) {
        this.idAvisCours = idAvisCours;
        this.rate = rate;
        this.commentaire = commentaire;
    }

     public AvisCours( int rate, String commentaire) {
        this.rate = rate;
        this.commentaire = commentaire;
    }

   
    

    public int getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(int IdUtilisateur) {
        this.IdUtilisateur = IdUtilisateur;
    }

    public int getIdCour() {
        return idCour;
    }

    public void setIdCour(int idCour) {
        this.idCour = idCour;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


    


    public int getIdAvisCours() {
        return idAvisCours;
    }



    public int getRate() {
        return rate;
    }

    

    public void setIdAvisCours(int idAvisCours) {
        this.idAvisCours = idAvisCours;
    }

  

    public void setRate(int rate) {
        this.rate = rate;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idAvisCours;
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
        final AvisCours other = (AvisCours) obj;
        if (this.idAvisCours != other.idAvisCours) {
            return false;
        }
        if (this.rate != other.rate) {
            return false;
        }

       
        return true;
    }

    @Override
    public String toString() {
        return "AvisCours{" + "idAvisCours=" + idAvisCours + ", rate=" + rate + ", IdUtilisateur=" + IdUtilisateur + ", idCour=" + idCour + ", commentaire=" + commentaire + '}';
    }

    



  

    
    
    
}
