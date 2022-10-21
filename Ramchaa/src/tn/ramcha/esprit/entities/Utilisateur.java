
package tn.ramcha.esprit.entities;

import java.sql.Date;




public class Utilisateur {
    
    protected int idUser;
    protected String cinUser;
    protected String nomUser;
    protected String prenomUser;
    protected Date ddnUser;
    protected String adressUser;
    protected int codePostalUser;
    protected String numUser;   
    protected String loginUser;
    protected String passwUser;

    public static Utilisateur current_user; 
    public Utilisateur() {
    }

    public Utilisateur(String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        this.cinUser = cinUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.ddnUser = ddnUser;
        this.adressUser = adressUser;
        this.codePostalUser = codePostalUser;
        this.numUser = numUser;
        this.loginUser = loginUser;
   
    }
        public Utilisateur(String cinUser, String nomUser, String prenomUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        this.cinUser = cinUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        
        this.adressUser = adressUser;
        this.codePostalUser = codePostalUser;
        this.numUser = numUser;
        this.loginUser = loginUser;
   
    }

    public Utilisateur(int idUser, String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        this.idUser = idUser;
        this.cinUser = cinUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.ddnUser = ddnUser;
        this.adressUser = adressUser;
        this.codePostalUser = codePostalUser;
        this.numUser = numUser;
        this.loginUser = loginUser;
        this.passwUser = passwUser;
  
    }

    public int getIdUser() {
        return idUser;
    }

    public String getCinUser() {
        return cinUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public Date getDdnUser() {
        return ddnUser;
    }

    public String getAdressUser() {
        return adressUser;
    }

    public int getCodePostalUser() {
        return codePostalUser;
    }

    public String getNumUser() {
        return numUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public String getPasswUser() {
        return passwUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setCinUser(String cinUser) {
        this.cinUser = cinUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public void setDdnUser(Date ddnUser) {
        this.ddnUser = ddnUser;
    }

    public void setAdressUser(String adressUser) {
        this.adressUser = adressUser;
    }

    public void setCodePostalUser(int codePostalUser) {
        this.codePostalUser = codePostalUser;
    }

    public void setNumUser(String numUser) {
        this.numUser = numUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public void setPasswUser(String passwUser) {
        this.passwUser = passwUser;
    }





    @Override
    public String toString() {
        return  "cinUser=" + cinUser + ", nomUser=" + nomUser + ", prenomUser=" + prenomUser + ", ddnUser=" + ddnUser + ", adressUser=" + adressUser + ", codePostalUser=" + codePostalUser + ", numUser=" + numUser + ", loginUser=" + loginUser + ", passwUser=" + passwUser  ;
    }

 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idUser;
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }
   
    
}
