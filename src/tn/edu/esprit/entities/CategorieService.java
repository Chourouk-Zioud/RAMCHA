/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Array;
import java.util.Objects;

/**
 *
 * @author eya
 */
public class CategorieService {
    private int idCategorieService;
    private String nomCategorieService;
    private String descriptionCategorieService;

    public CategorieService() {
    }

    public CategorieService(int idCategorieService, String nomCategorieService, String descriptionCategorieService) {
        this.idCategorieService = idCategorieService;
        this.nomCategorieService = nomCategorieService;
        this.descriptionCategorieService = descriptionCategorieService;
    }

    public CategorieService(String nomCategorieService, String descriptionCategorieService) {
        this.nomCategorieService = nomCategorieService;
        this.descriptionCategorieService = descriptionCategorieService;
    }

    public CategorieService(int idCategorieService) {
        this.idCategorieService = idCategorieService;
    }

    public int getIdCategorieService() {
        return idCategorieService;
    }

    public void setIdCategorieService(int idCategorieService) {
        this.idCategorieService = idCategorieService;
    }

    public String getNomCategorieService() {
        return nomCategorieService;
    }

    public void setNomCategorieService(String nomCategorieService) {
        this.nomCategorieService = nomCategorieService;
    }

    public String getDescriptionCategorieService() {
        return descriptionCategorieService;
    }

    public void setDescriptionCategorieService(String descriptionCategorieService) {
        this.descriptionCategorieService = descriptionCategorieService;
    }


    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idCategorieService;
        hash = 41 * hash + Objects.hashCode(this.nomCategorieService);
        hash = 41 * hash + Objects.hashCode(this.descriptionCategorieService);
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
        final CategorieService other = (CategorieService) obj;
        if (this.idCategorieService != other.idCategorieService) {
            return false;
        }
        if (!Objects.equals(this.nomCategorieService, other.nomCategorieService)) {
            return false;
        }
        if (!Objects.equals(this.descriptionCategorieService, other.descriptionCategorieService)) {
            return false;
        }
      
        return true;
    }

    @Override
    public String toString() {
        return nomCategorieService ;
    }

    

    
    
    
}
