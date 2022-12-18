/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
public class TypeCours {
    private String name;
    private String imagSrc;

    public TypeCours() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   

    public String getImagSrc() {
        return imagSrc;
    }

    public void setImagSrc(String imagSrc) {
        this.imagSrc = imagSrc;
    }

    public TypeCours(String name, String imagSrc) {
        this.name = name;
        this.imagSrc = imagSrc;
    }

    
    
}
