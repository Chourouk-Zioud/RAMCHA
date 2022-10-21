
package tn.ramcha.esprit.entities;

import java.sql.Date;

public class Demandeur extends Utilisateur {
   
    private String libelleDemande;
    private String role; 
    

    public Demandeur() {
    }

    public Demandeur(String libelleDemande) {
        this.libelleDemande = libelleDemande;
    }
    

    public Demandeur(String libelleDemande, String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        super(cinUser, nomUser, prenomUser, ddnUser, adressUser, codePostalUser, numUser, loginUser, passwUser);
        this.libelleDemande = libelleDemande;
    }

    public Demandeur(String libelleDemande, int idUser, String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        super(idUser, cinUser, nomUser, prenomUser, ddnUser, adressUser, codePostalUser, numUser, loginUser, passwUser);
        this.libelleDemande = libelleDemande;
    }

    public String getLibelleDemande() {
        return libelleDemande;
    }

    public void setLibelleDemande(String libelleDemande) {
        this.libelleDemande = libelleDemande;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
 

    @Override
    public String toString() {
        return super.toString() + ", libelleDemande=" + libelleDemande ;
    }
    
    
}
