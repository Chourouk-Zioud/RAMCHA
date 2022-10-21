/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;

/**
 *
 * @author chalg
 */
public interface IServiceReclamation <R> {
    
    public void ajouter(R r);
    public void modifier(R r);
    public void supprimer(int id);
    public R getOne(int id);
    public List<R> getAll(); 
    
}
