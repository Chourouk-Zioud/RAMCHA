
package tn.ramcha.esprit.entities;

import java.sql.Date;


public class Prestateur extends Utilisateur {
    
    
    private String salaireP;
    private String posteP;
    private String diplomeP;
    private String experP;
    private String dispoP;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public Prestateur() {
    }

    public Prestateur(String salaireP, String posteP, String diplomeP, String experP, String dispoP) {
        this.salaireP = salaireP;
        this.posteP = posteP;
        this.diplomeP = diplomeP;
        this.experP = experP;
        this.dispoP = dispoP;
    }

    public Prestateur(String salaireP, String posteP, String diplomeP, String experP, String dispoP, String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        super(cinUser, nomUser, prenomUser, ddnUser, adressUser, codePostalUser, numUser, loginUser, passwUser);
        this.salaireP = salaireP;
        this.posteP = posteP;
        this.diplomeP = diplomeP;
        this.experP = experP;
        this.dispoP = dispoP;
    }

    public Prestateur(String salaireP, String posteP, String diplomeP, String experP, String dispoP, int idUser, String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        super(idUser, cinUser, nomUser, prenomUser, ddnUser, adressUser, codePostalUser, numUser, loginUser, passwUser);
        this.salaireP = salaireP;
        this.posteP = posteP;
        this.diplomeP = diplomeP;
        this.experP = experP;
        this.dispoP = dispoP;
    }




    public String getSalaireP() {
        return salaireP;
    }

    public String getPosteP() {
        return posteP;
    }

    public String getDiplomeP() {
        return diplomeP;
    }

    public String getExperP() {
        return experP;
    }

    public String getDispoP() {
        return dispoP;
    }
    
    public void setSalaireP(String salaireP) {
        this.salaireP = salaireP;
    }

    public void setPosteP(String posteP) {
        this.posteP = posteP;
    }

    public void setDiplomeP(String diplomeP) {
        this.diplomeP = diplomeP;
    }

    public void setExperP(String experP) {
        this.experP = experP;
    }

    public void setDispoP(String dispoP) {
        this.dispoP = dispoP;
    }

    @Override
    public String toString() {
        return super.toString() +", salaireP=" + salaireP + ", posteP=" + posteP + ", diplomeP=" + diplomeP + ", experP=" + experP + ", dispoP=" + dispoP + '}';
    }


}
