/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;
import tn.edu.esprit.entites.AvisCours;
import tn.edu.esprit.entites.Chapitre;

/**
 *
 * @author asus
 * @param <F>
 */
public interface IServicesFormation<F> {
      public void ajouter(F f);
    public void modifier(F f);
    public void supprimer(int id );
    public F getOne(int id);
    public List<F> getAll();
    List<AvisCours> getAll(int idCours);
    
    
}
