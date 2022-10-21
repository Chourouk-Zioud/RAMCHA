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
public class CategorieArticle {
    private int idCategorieArticle ;
    private String iconeCategorieArticle; 
    private String nomCategorieArticle ;

public CategorieArticle(){}

public CategorieArticle( String iconeCategorieArticle,String nomCategorieArticle){
     this.iconeCategorieArticle=iconeCategorieArticle;
     this.nomCategorieArticle=nomCategorieArticle;
 }


public CategorieArticle( int idCategorieArticle,String iconeCategorieArticle,String nomCategorieArticle){
     this.idCategorieArticle=idCategorieArticle;
     this.iconeCategorieArticle=iconeCategorieArticle;
     this.nomCategorieArticle=nomCategorieArticle;
    
 }

    public int getIdCategorieArticle() {
        return idCategorieArticle;
    }

    public void setIdCategorieArticle(int idCategorieArticle) {
        this.idCategorieArticle = idCategorieArticle;
    }

    public String getIconeCategorieArticle() {
        return iconeCategorieArticle;
    }

    public void setIconeCategorieArticle(String iconeCategorieArticle) {
        this.iconeCategorieArticle = iconeCategorieArticle;
    }

    public String getNomCategorieArticle() {
        return nomCategorieArticle;
    }

    public void setNomCategorieArticle(String nomCategorieArticle) {
        this.nomCategorieArticle = nomCategorieArticle;
    }

    @Override
    public String toString() {
        return "CategorieArticle{" + "iconeCategorieArticle=" + iconeCategorieArticle + ", nomCategorieArticle=" + nomCategorieArticle + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idCategorieArticle;
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
        final CategorieArticle other = (CategorieArticle) obj;
        if (this.idCategorieArticle != other.idCategorieArticle) {
            return false;
        }
        return true;
    }

   
}



  


