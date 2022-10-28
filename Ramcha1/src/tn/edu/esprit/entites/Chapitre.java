/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entites;

import java.util.Objects;

/**
 *
 * @author asus
 */
public class Chapitre {
    private int idChapitre;
    private String nomChapitre;
    private String langueChapitre;
    private String typeChapitre;
    Cours cours=new Cours();

    public Chapitre() {
    }
    

    public Chapitre(int idChapitre, String nomChapitre, String langueChapitre, String typeChapitre, Cours cours) {
        this.idChapitre = idChapitre;
        this.nomChapitre = nomChapitre;
        this.langueChapitre = langueChapitre;
        this.typeChapitre = typeChapitre;
        this.cours = cours;
    }

    public Chapitre(String nomChapitre, String langueChapitre, String typeChapitre) {
        this.nomChapitre = nomChapitre;
        this.langueChapitre = langueChapitre;
        this.typeChapitre = typeChapitre;
    }

    public Chapitre(int idChapitre, String nomChapitre, String langueChapitre, String typeChapitre) {
        this.idChapitre = idChapitre;
        this.nomChapitre = nomChapitre;
        this.langueChapitre = langueChapitre;
        this.typeChapitre = typeChapitre;
    }
    

    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public String getNomChapitre() {
        return nomChapitre;
    }

    public void setNomChapitre(String nomChapitre) {
        this.nomChapitre = nomChapitre;
    }

    public String getLangueChapitre() {
        return langueChapitre;
    }

    public void setLangueChapitre(String langueChapitre) {
        this.langueChapitre = langueChapitre;
    }

    public String getTypeChapitre() {
        return typeChapitre;
    }

    public void setTypeChapitre(String typeChapitre) {
        this.typeChapitre = typeChapitre;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return nomChapitre ;
    }
    
    
   

   


 


    
    
}
