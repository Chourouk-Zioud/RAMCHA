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
public class CategorieArticle {
    private int idCategorie;
    private  String libelle;
    private  String discription;

    public CategorieArticle() {
    }

    public CategorieArticle(int idCategorie, String libelle, String discription) {
        this.idCategorie = idCategorie;
        this.libelle = libelle;
        this.discription = discription;
    }

    public CategorieArticle(String libelle, String discription) {
        this.libelle = libelle;
        this.discription = discription;
    }

    @Override
    public String toString() {
        return libelle ;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    
    
}
