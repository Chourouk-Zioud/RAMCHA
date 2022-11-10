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
public class Article {
    private int idArticle ;
    private String nomArticle ;          
    private String marqueArticle ;
    private String typeArticle ;
    private int disponibiliteArticle ;
    private String couleurArticle ;
    private float prixArticle ;
    private String tailleArticle ;
    private String descriptionArticle ;
    private String ficheTechnique ;

    

    private int idMagasin ;
    private int idCategorieArticle ;

    public Article() {
    }

    public Article(int idArticle, String nomArticle, String marqueArticle, String typeArticle, int disponibiliteArticle, String couleurArticle, float prixArticle, String tailleArticle, String descriptionArticle, String ficheTechnique, int idMagasin, int idCategorieArticle) {
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.marqueArticle = marqueArticle;
        this.typeArticle = typeArticle;
        this.disponibiliteArticle = disponibiliteArticle;
        this.couleurArticle = couleurArticle;
        this.prixArticle = prixArticle;
        this.tailleArticle = tailleArticle;
        this.descriptionArticle = descriptionArticle;
        this.ficheTechnique = ficheTechnique;
        this.idMagasin = idMagasin;
        this.idCategorieArticle = idCategorieArticle;
    }

    public Article(String nomArticle, String marqueArticle, String typeArticle, int disponibiliteArticle, String couleurArticle, float prixArticle, String tailleArticle, String descriptionArticle, String ficheTechnique, int idMagasin, int idCategorieArticle) {
        this.nomArticle = nomArticle;
        this.marqueArticle = marqueArticle;
        this.typeArticle = typeArticle;
        this.disponibiliteArticle = disponibiliteArticle;
        this.couleurArticle = couleurArticle;
        this.prixArticle = prixArticle;
        this.tailleArticle = tailleArticle;
        this.descriptionArticle = descriptionArticle;
        this.ficheTechnique = ficheTechnique;
        this.idMagasin = idMagasin;
        this.idCategorieArticle = idCategorieArticle;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getMarqueArticle() {
        return marqueArticle;
    }

    public void setMarqueArticle(String marqueArticle) {
        this.marqueArticle = marqueArticle;
    }

    public String getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(String typeArticle) {
        this.typeArticle = typeArticle;
    }

    public int getDisponibiliteArticle() {
        return disponibiliteArticle;
    }

    public void setDisponibiliteArticle(int disponibiliteArticle) {
        this.disponibiliteArticle = disponibiliteArticle;
    }

    public String getCouleurArticle() {
        return couleurArticle;
    }

    public void setCouleurArticle(String couleurArticle) {
        this.couleurArticle = couleurArticle;
    }

    public float getPrixArticle() {
        return prixArticle;
    }

    public void setPrixArticle(float prixArticle) {
        this.prixArticle = prixArticle;
    }

    public String getTailleArticle() {
        return tailleArticle;
    }

    public void setTailleArticle(String tailleArticle) {
        this.tailleArticle = tailleArticle;
    }

    public String getDescriptionArticle() {
        return descriptionArticle;
    }

    public void setDescriptionArticle(String descriptionArticle) {
        this.descriptionArticle = descriptionArticle;
    }

    public String getFicheTechnique() {
        return ficheTechnique;
    }

    public void setFicheTechnique(String ficheTechnique) {
        this.ficheTechnique = ficheTechnique;
    }

    public int getIdMagasin() {
        return idMagasin;
    }

    public void setIdMagasin(int idMagasin) {
        this.idMagasin = idMagasin;
    }

    public int getIdCategorieArticle() {
        return idCategorieArticle;
    }

    public void setIdCategorieArticle(int idCategorieArticle) {
        this.idCategorieArticle = idCategorieArticle;
    }

    //@Override
    //public String toString() {
    //    return "Article{" + "idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", marqueArticle=" + marqueArticle + ", typeArticle=" + typeArticle + ", disponibiliteArticle=" + disponibiliteArticle + ", couleurArticle=" + couleurArticle + ", prixArticle=" + prixArticle + ", tailleArticle=" + tailleArticle + ", descriptionArticle=" + descriptionArticle + ", ficheTechnique=" + ficheTechnique + ", idMagasin=" + idMagasin + ", idCategorieArticle=" + idCategorieArticle + '}';
    //}

   @Override
    public String toString() {
        return nomArticle;
    }

   
}
