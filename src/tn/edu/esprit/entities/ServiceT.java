/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import tn.edu.esprit.services.CruCat;

/**
 *
 * @author eya
 */
public class ServiceT {

    public static void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void addAll(List<ServiceT> data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ServiceT get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int idService;
    private String nomService;
    private int nbreOuvrier;
    private float prixService;
   /** private */
    private String descriptionService;
    private Date dateDebutService;
    private Date dateFinService;
    private String disponibiliteService;
    public CategorieService categorieservice;
    int IdCategorieService;

    CruCat cc = new CruCat();
    
    public ServiceT() {
    }

    public ServiceT(int idService, String nomService, int nbreOuvrier, float prixService, String descriptionService, Date dateDebutService, Date dateFinService, String disponibiliteService, int categorieservice) {
        this.idService = idService;
        this.nomService = nomService;
        this.nbreOuvrier = nbreOuvrier;
        this.prixService = prixService;
        this.descriptionService = descriptionService;
        this.dateDebutService = dateDebutService;
        this.dateFinService = dateFinService;
        this.disponibiliteService = disponibiliteService;
        this.IdCategorieService = categorieservice;
       // this.categorieservice = cc.getOne(IdCategorieService);
    }
    


    public ServiceT(String nomService, int nbreOuvrier, float prixService, String descriptionService, Date dateDebutService, Date dateFinService, String disponibiliteService, CategorieService categorieservice) {
        this.nomService = nomService;
        this.nbreOuvrier = nbreOuvrier;
        this.prixService = prixService;
        this.descriptionService = descriptionService;
        this.dateDebutService = dateDebutService;
        this.dateFinService = dateFinService;
        this.disponibiliteService = disponibiliteService;
      this.IdCategorieService = categorieservice.getIdCategorieService();
    }

    public ServiceT(int idService, String nomService, int nbreOuvrier, float prixService, String descriptionService, Date dateDebutService, Date dateFinService, String disponibiliteService) {
        this.idService = idService;
        this.nomService = nomService;
        this.nbreOuvrier = nbreOuvrier;
        this.prixService = prixService;
        this.descriptionService = descriptionService;
        this.dateDebutService = dateDebutService;
        this.dateFinService = dateFinService;
        this.disponibiliteService = disponibiliteService;
        //this.IdCategorieService = categorieservice;
       // this.categorieservice = cc.getOne(IdCategorieService);
    }

   

    public ServiceT(int idService) {
        this.idService = idService;
    }

   

    

    public int getIdService() {
        return idService;
    }

    public String getNomService() {
        return nomService;
    }

    public int getNbreOuvrier() {
        return nbreOuvrier;
    }

    public float getPrixService() {
        return prixService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public Date getDateDebutService() {
        return dateDebutService;
    }

    public Date getDateFinService() {
        return dateFinService;
    }

    public String getDisponibiliteService() {
        return disponibiliteService;
    }

    public CategorieService getCategorieService() {
        return categorieservice;
    }

    public CategorieService getCategorieservice() {
        return categorieservice;
    }

    public void setCategorieservice(CategorieService categorieservice) {
        this.categorieservice = categorieservice;
    }

    public int getIdCategorieService() {
        return IdCategorieService;
    }

    public void setIdCategorieService(int IdCategorieService) {
        this.IdCategorieService = IdCategorieService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public void setNbreOuvrier(int nbreOuvrier) {
        this.nbreOuvrier = nbreOuvrier;
    }

    public void setPrixService(float prixService) {
        this.prixService = prixService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public void setDateDebutService(Date dateDebutService) {
        this.dateDebutService = dateDebutService;
    }

    public void setDateFinService(Date dateFinService) {
        this.dateFinService = dateFinService;
    }

    public void setDisponibiliteService(String disponibiliteService) {
        this.disponibiliteService = disponibiliteService;
    }

    public void setCategorieService(CategorieService CategorieService) {
        this.categorieservice = categorieservice;
    }

    //@Override
    //public String toString() {
    //    return "ServiceT{" + "idService=" + idService + ", nomService=" + nomService + ", nbreOuvrier=" + nbreOuvrier + ", prixService=" + prixService + ", descriptionService=" + descriptionService + ", dateDebutService=" + dateDebutService + ", dateFinService=" + dateFinService + ", disponibiliteService=" + disponibiliteService + ", categorieservice=" + categorieservice + '}';
    //}

    @Override
    public String toString() {
        return nomService;
    }

 



    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idService;
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
        final ServiceT other = (ServiceT) obj;
        if (this.idService != other.idService) {
            return false;
        }
        if (this.nbreOuvrier != other.nbreOuvrier) {
            return false;
        }
        if (Float.floatToIntBits(this.prixService) != Float.floatToIntBits(other.prixService)) {
            return false;
        }
        if (!Objects.equals(this.nomService, other.nomService)) {
            return false;
        }
        if (!Objects.equals(this.descriptionService, other.descriptionService)) {
            return false;
        }
        if (!Objects.equals(this.disponibiliteService, other.disponibiliteService)) {
            return false;
        }
        if (!Objects.equals(this.dateDebutService, other.dateDebutService)) {
            return false;
        }
        if (!Objects.equals(this.dateFinService, other.dateFinService)) {
            return false;
        }
        if (!Objects.equals(this.categorieservice, other.categorieservice)) {
            return false;
        }
        return true;
    }

    public String getImgSrc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    

   

    
    
}
