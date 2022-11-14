
package tn.edu.esprit.services;

import java.net.PasswordAuthentication;
import java.util.List;
import tn.edu.esprit.entities.Utilisateur;

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
   
    public void modifierSd (U u);
    
    public Utilisateur Login(String email);
    public boolean checkEmailExist(String email);
    public boolean validerEmail(String s);
    public void modifierSpw (U u);
     public int countu(int util);
      public int countp( int prest);
      public int countd( int deman);
    
       public int testNum(String s);
       public U selectUser(String a);
       public void updateUser(int a, U u);
}