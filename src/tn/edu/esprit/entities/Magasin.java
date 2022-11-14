/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Chourouk Zioud
 */
public class Magasin {
        private int idMagasin;
        private String nomMagasin;
        private String adresseMagasin;
        private String emailMagasin;
        private String telMagasin; 

    public Magasin() {
    }

    public Magasin(int idMagasin, String nomMagasin, String adresseMagasin, String emailMagasin, String telMagasin) {
        this.idMagasin = idMagasin;
        this.nomMagasin = nomMagasin;
        this.adresseMagasin = adresseMagasin;
        this.emailMagasin = emailMagasin;
        this.telMagasin = telMagasin;
    }

    public Magasin(String nomMagasin, String adresseMagasin, String emailMagasin, String telMagasin) {
        this.nomMagasin = nomMagasin;
        this.adresseMagasin = adresseMagasin;
        this.emailMagasin = emailMagasin;
        this.telMagasin = telMagasin;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public String getNomMagasin() {
        return nomMagasin;
    }

    public void setNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    public String getAdresseMagasin() {
        return adresseMagasin;
    }

    public void setAdresseMagasin(String adresseMagasin) {
        this.adresseMagasin = adresseMagasin;
    }

    public String getEmailMagasin() {
        return emailMagasin;
    }

    public void setEmailMagasin(String emailMagasin) {
        this.emailMagasin = emailMagasin;
    }

    public String getTelMagasin() {
        return telMagasin;
    }

    public void setTelMagasin(String telMagasin) {
        this.telMagasin = telMagasin;
    }

    @Override
    public String toString() {
        return nomMagasin;
    }
        
       
    
}
