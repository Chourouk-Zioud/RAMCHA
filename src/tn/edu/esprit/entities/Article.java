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
public class Article {
    
private int idArticle ;
private int idMagasin ;
private int idCategorieArticle ;
private String nomArticle ;          
private String marqueArticle ;
private String typeArticle ;
private Boolean disponibiliteArticle ;
private String couleurArticle ;
private float prixArticle ;
private String tailleArticle ;
private String descriptionArticle ;
private String ficheTechnique ;
private String imageArticle ;
private String videoArticle ;
private CategorieArticle categorie ;
private Magasin magasin ;



public Article(){
}

public Article(String nomArticle,String marqueArticle,String typeArticle,Boolean disponibiliteArticle,String couleurArticle,float prixArticle,String tailleArticle,String descriptionArticle,String ficheTechnique,String imageArticle,String videoArticle,CategorieArticle categorie,Magasin magasin)
{
   this.nomArticle = nomArticle;
   this.marqueArticle = marqueArticle;
   this.typeArticle = typeArticle;
   this.disponibiliteArticle = disponibiliteArticle;
   this.couleurArticle = couleurArticle;
   this.prixArticle = prixArticle;
   this.tailleArticle = tailleArticle ;
   this.descriptionArticle = descriptionArticle;
   this.ficheTechnique = ficheTechnique;
   this.imageArticle = imageArticle;
   this.videoArticle = videoArticle;
   this.categorie = categorie;
   this.magasin = magasin;
    
}

public Article(int idArticle,String nomArticle,String marqueArticle,String typeArticle,Boolean disponibiliteArticle,String couleurArticle,float prixArticle,String tailleArticle,String descriptionArticle,String ficheTechnique,String imageArticle,String videoArticle,CategorieArticle categorie,Magasin magasin)
{
   this.idArticle = idArticle;
   this.nomArticle = nomArticle;
   this.marqueArticle = marqueArticle;
   this.typeArticle = typeArticle;
   this.disponibiliteArticle = disponibiliteArticle;
   this.couleurArticle = couleurArticle;
   this.prixArticle = prixArticle;
   this.tailleArticle = tailleArticle ;
   this.descriptionArticle = descriptionArticle;
   this.ficheTechnique = ficheTechnique;
   this.imageArticle = imageArticle;
   this.videoArticle = videoArticle;
   this.categorie = categorie;
   this.magasin = magasin;
    
}

public Article(String nomArticle,String marqueArticle,String typeArticle,Boolean disponibiliteArticle,String couleurArticle,float prixArticle,String tailleArticle,String descriptionArticle,String ficheTechnique,String imageArticle,String videoArticle,int idCategorieArticle,int idMagasin)
{
   this.nomArticle = nomArticle;
   this.marqueArticle = marqueArticle;
   this.typeArticle = typeArticle;
   this.disponibiliteArticle = disponibiliteArticle;
   this.couleurArticle = couleurArticle;
   this.prixArticle = prixArticle;
   this.tailleArticle = tailleArticle ;
   this.descriptionArticle = descriptionArticle;
   this.ficheTechnique = ficheTechnique;
   this.imageArticle = imageArticle;
   this.videoArticle = videoArticle;
   this.idCategorieArticle = idCategorieArticle;
   this.idMagasin = idMagasin;
   
}
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
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

    public Boolean getDisponibiliteArticle() {
        return disponibiliteArticle;
    }

    public void setDisponibiliteArticle(Boolean disponibiliteArticle) {
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

    public String getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(String imageArticle) {
        this.imageArticle = imageArticle;
    }

    public String getVideoArticle() {
        return videoArticle;
    }

    public void setVideoArticle(String videoArticle) {
        this.videoArticle = videoArticle;
    }

    public CategorieArticle getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieArticle categorie) {
        this.categorie = categorie;
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
    }

    @Override
    public String toString() {
        return "Article{" + "nomArticle=" + nomArticle + ", marqueArticle=" + marqueArticle + ", typeArticle=" + typeArticle + ", disponibiliteArticle=" + disponibiliteArticle + ", couleurArticle=" + couleurArticle + ", prixArticle=" + prixArticle + ", tailleArticle=" + tailleArticle + ", descriptionArticle=" + descriptionArticle + ", ficheTechnique=" + ficheTechnique + ", imageArticle=" + imageArticle + ", videoArticle=" + videoArticle + ", categorie=" + categorie + ", magasin=" + magasin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idArticle;
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
        final Article other = (Article) obj;
        if (this.idArticle != other.idArticle) {
            return false;
        }
        return true;
    }

    
}
