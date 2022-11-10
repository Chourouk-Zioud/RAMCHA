package tn.edu.esprit.services;
import java.util.List;
import tn.edu.esprit.entities.CategorieService;
import tn.edu.esprit.entities.ServiceT;




public interface Iservicesgest <T> {
     public void ajouter(ServiceT t , int idCat);
    public void modifier(T t );
    public void supprimer(int id);
    public T getOne(int idService);
    public List<T> getAll() ;
    public void ajoutercate(CategorieService t);
    public void notifierClient();
    
}
