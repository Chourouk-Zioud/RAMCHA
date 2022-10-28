
package tn.ramcha.esprit.entities;

import java.sql.Date;

public class Admin extends Utilisateur {

    public Admin() {
    }

    public Admin(String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        super(cinUser, nomUser, prenomUser, ddnUser, adressUser, codePostalUser, numUser, loginUser, passwUser);
    }

    public Admin(int idUser, String cinUser, String nomUser, String prenomUser, Date ddnUser, String adressUser, int codePostalUser, String numUser, String loginUser, String passwUser) {
        super(idUser, cinUser, nomUser, prenomUser, ddnUser, adressUser, codePostalUser, numUser, loginUser, passwUser);
    }


     @Override
    public String toString() {
       return super.toString();
    }
}
