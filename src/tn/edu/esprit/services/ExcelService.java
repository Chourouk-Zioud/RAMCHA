/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import tn.edu.esprit.entities.Article;
import tn.edu.esprit.tools.DataS;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;

/**
 *
 * @author Chourouk Zioud
 */
public class ExcelService {
    public void ExcelCreator(){
        Connection cnx = DataS.getInstance().getConnection();
        ArticleService sm = new ArticleService(cnx);
    try {
   PrintWriter pw= new PrintWriter(new File("..\\RAMCHA\\src\\documents\\Article.csv"));
   StringBuilder sb=new StringBuilder();
   sb.append("ID_Article");
   sb.append(",");
   sb.append("Nom");
   sb.append(",");
   sb.append("Marque");
   sb.append(",");
   sb.append("Typr");
   sb.append(",");
   sb.append("Couleur");
   sb.append(",");
   sb.append("Taille");
   sb.append(",");
   sb.append("Prix");
   sb.append("\n");
        for (Article m : sm.getAll()) {
   sb.append(m.getIdArticle());
   sb.append(",");
   sb.append(m.getNomArticle());
   sb.append(",");
   sb.append(m.getMarqueArticle());
   sb.append(",");
   sb.append(m.getTypeArticle());
   sb.append(",");
   sb.append(m.getCouleurArticle());
   sb.append(",");
   sb.append(m.getTailleArticle());
   sb.append(",");
   sb.append(m.getPrixArticle());
   sb.append("\n");  
        }
   
   
   pw.write(sb.toString());
   pw.close();
   System.out.println("finished");
   } catch (Exception e) {
      // TODO: handle exception
   }
    }
}
