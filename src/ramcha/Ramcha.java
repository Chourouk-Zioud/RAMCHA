/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ramcha;

import java.sql.Connection;
import java.util.Date;
import tn.edu.esprit.entities.AvisService;
import tn.edu.esprit.entities.Messagerie;
import tn.edu.esprit.entities.Reclamation;
import tn.edu.esprit.services.ServiceAvisService;
import tn.edu.esprit.services.ServiceMessagerie;
import tn.edu.esprit.services.ServiceReclamation;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author chalg
 */
public class Ramcha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection cnx =DataSource.getInstance().getConnection();
        
        
        /*         ****test reclamation*****
        
        Reclamation re = new Reclamation();
        re.setIdReclamation(2);
        re.setIdUser(2);
        re.setRefReclamation("ok");
        re.setObjetReclamation("ok");
        re.setDescriptionReclamation("ok");
        re.setSuiviReclamation("ok");
        Date date = new Date(2023,4,7);
        re.setDateReclamation(java.sql.Date.valueOf("2013-09-04"));
        
        ServiceReclamation r = new ServiceReclamation();
        //r.ajouter(re);
        r.modifier(re);
        //r.supprimer(2);
        //r.getAll();
        */
        
        /***   ****test avis servive****
        AvisService av = new AvisService();
        av.setIdAvisService(1);
        av.setIdUser(33);
        av.setIdService(22);
        av.setDetailAvisService("ddddd");
        av.setNoteService(110);
        
        ServiceAvisService sa = new ServiceAvisService();
        
        //sa.ajouter(av);
        //sa.modifier(av);
        //sa.supprimer(1);
        //sa.getOne(3);
        //sa.getAll();
        
        */
        
        /***   ****test messagerie****/
        Messagerie msg = new Messagerie();
        msg.setIdExpediteur(13);
        msg.setIdRecepteur(12);
        msg.setMessage("");
        msg.setVu(true);
        
        ServiceMessagerie sm = new ServiceMessagerie();
        
        sm.ajouter(msg);
        //sa.modifier(av);
        //sa.supprimer(1);
        //sa.getOne(3);
        //sa.getAll();
        
        
        
    }
    
}
