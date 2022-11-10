/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entites;

import static java.util.Collections.list;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author asus
 */
public class Cours {
    private int idCours;
    private String nomCours;
    private String categoriesCours;
    private String sujetCours;
    private String niveauCours;
    //public Chapitre Chapitre;
    //int  idChapitre;
    
   

    public Cours() {
    }

    public Cours(int idCours, String nomCours, String categoriesCours, String sujetCours, String niveauCours) {
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.categoriesCours = categoriesCours;
        this.sujetCours = sujetCours;
        this.niveauCours = niveauCours;
        
    }

    public Cours(String nomCours, String categoriesCours, String sujetCours, String niveauCours) {
        this.nomCours = nomCours;
        this.categoriesCours = categoriesCours;
        this.sujetCours = sujetCours;
        this.niveauCours = niveauCours;
    }
    

    public Cours(String nomCours, String categoriesCours, String sujetCours, String niveauCours, List<Chapitre> chapitre) {
        this.nomCours = nomCours;
        this.categoriesCours = categoriesCours;
        this.sujetCours = sujetCours;
        this.niveauCours = niveauCours;
        
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getCategoriesCours() {
        return categoriesCours;
    }

    public void setCategoriesCours(String categoriesCours) {
        this.categoriesCours = categoriesCours;
    }

    public String getSujetCours() {
        return sujetCours;
    }

    public void setSujetCours(String sujetCours) {
        this.sujetCours = sujetCours;
    }

    public String getNiveauCours() {
        return niveauCours;
    }

    public void setNiveauCours(String niveauCours) {
        this.niveauCours = niveauCours;
    }

  

 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idCours;
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
        final Cours other = (Cours) obj;
        if (this.idCours != other.idCours) {
            return false;
        }
        if (!Objects.equals(this.nomCours, other.nomCours)) {
            return false;
        }
        if (!Objects.equals(this.categoriesCours, other.categoriesCours)) {
            return false;
        }
        if (!Objects.equals(this.sujetCours, other.sujetCours)) {
            return false;
        }
        if (!Objects.equals(this.niveauCours, other.niveauCours)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return nomCours;
    }
    

    
    
    }

   

   

   

   
    
    

