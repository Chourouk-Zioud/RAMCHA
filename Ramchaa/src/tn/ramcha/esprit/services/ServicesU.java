
package tn.ramcha.esprit.services;

import java.util.List;
import tn.ramcha.esprit.entities.Utilisateur;

public interface ServicesU <U,P,D,A>{
    
    public void ajouter(U u);
    public void modifier(U u);
    public U getOne(int id);
    public List<U> getAll();
    
    public void supprimer(int id);
    
    public void modifierRole(U u);
    
    public void ajouterP(P p);
    public void modifierP(P p);
    public P getOneP (int id); 
    public List<P> getAllP();
    
    public void ajouterD(D d);
    public void modifierD(D d);
    public D getOneD (int id);
    public List<D> getAllD();
  
    
    public void modifierA (A a);
    public A getOneA(int id);
    
    public boolean validerLog(String Email, String mdp);
    public Utilisateur validerMail(String Email);
    public boolean test_Password(String password);
    
    public void modifierSd (U u);
}