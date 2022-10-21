/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.edu.services;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface IServiceCategorieArticle  <C> {
    
    public void ajouter(C c);
    public void modifier(C c);
    public void supprimer(int id);
    public C getOne(int id);
    public List<C> getAll();
    
}
