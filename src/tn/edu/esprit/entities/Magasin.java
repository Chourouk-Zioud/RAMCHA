/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author LENOVO
 */
public class Magasin { 
private int idMagasin;
private String nomMagasin;
private String adresseMagasin;
private String emailMagasin;
private int telMagasin; 
  
public Magasin(){}

public Magasin( String nomMagasin,String adresseMagasin,String emailMagasin,int telMagasin){
    this.nomMagasin=nomMagasin;
    this.adresseMagasin = adresseMagasin ;
    this.emailMagasin = emailMagasin ;
    this.telMagasin = telMagasin ;
}

public Magasin(int idMagasin,String nomMagasin,String adresseMagasin,String emailMagasin,int telMagasin){
    this.idMagasin = idMagasin ;
    this.nomMagasin=nomMagasin;
    this.adresseMagasin = adresseMagasin ;
    this.emailMagasin = emailMagasin ;
    this.telMagasin = telMagasin ;
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

    public int getTelMagasin() {
        return telMagasin;
    }

    public void setTelMagasin(int telMagasin) {
        this.telMagasin = telMagasin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idMagasin;
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
        final Magasin other = (Magasin) obj;
        if (this.idMagasin != other.idMagasin) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Magasin{" + "nomMagasin=" + nomMagasin + ", adresseMagasin=" + adresseMagasin + ", emailMagasin=" + emailMagasin + ", telMagasin=" + telMagasin + '}';
    }

    

}


