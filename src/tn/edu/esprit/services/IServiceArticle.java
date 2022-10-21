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
public interface IServiceArticle <A> {
    
    public void ajouter(A a);
    public void modifier(A a);
    public void supprimer(int id);
    public A getOne(int id);
    public List<A> getAll();

}
