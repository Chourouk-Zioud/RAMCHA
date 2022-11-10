/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.edu.esprit.entities.Article;
import tn.edu.esprit.entities.CommandeArticle;
import tn.edu.esprit.entities.CommandeService;
import tn.edu.esprit.entities.Devis;
import tn.edu.esprit.entities.DevisService;
import tn.edu.esprit.entities.Facture;
import tn.edu.esprit.entities.FactureService;
import tn.edu.esprit.entities.GenerateQRCode;
import tn.edu.esprit.entities.ServiceT;
import tn.edu.esprit.entities.Utilisateur;
import tn.edu.esprit.tools.DataS;

/**
 *
 * @author ASUS
 */
public class CommandeServices implements Commande {

    Connection cnx;

    public CommandeServices() {
        this.cnx = DataS.getInstance().getConnection();
    }

    //////////////////////////ARTICLE//////////////////////////////////////
    /*===================================================*/
    public int selectid() {
        int p = 0;
        try {
            String req = "SELECT * FROM commandearticle WHERE idCommande=(SELECT max(idCommande) FROM commandearticle) ";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                p = rs.getInt("idCommande");
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return p;
    }

    public int selectIdDevis() {
        int p = 0;
        try {
            String req = "SELECT * FROM devis WHERE idDevis=(SELECT max(idDevis) FROM devis) ";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                p = rs.getInt("idDevis");
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return p;
    }

    public void ajouterArticle(CommandeArticle t, Utilisateur u, ArrayList<Article> a) {
        //Article j = new Article();
        int p = selectid();
        a.forEach((j) -> {
            try {
                String raq = "INSERT INTO `commandearticle_article_utilisateur`(`idArticle`, `idCommande`, `idUtilisateur`) VALUES (" + j.getIdArticle() + "," + p + "," + u.getIdUser() + ")";
                Statement stm = cnx.createStatement();
                stm.executeUpdate(raq);
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        });
    }

    @Override
    public void ajouterCommandeArticle(CommandeArticle t, Utilisateur u, ArrayList<Article> a) {
        try {
            String req = "INSERT INTO `commandearticle`(`modeLivraison`, `statusLivraison`) VALUES ('" + t.getModeLivraison() + "','" + t.getStatusLivraison() + "')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        ajouterArticle(t, u, a);
    }

    /*===================================================*/
    @Override
    public void modifierCommandeArticleUtilisateur(CommandeArticle t) {
        try {

            String raq = "UPDATE `commandearticle` SET `modeLivraison`='" + t.getModeLivraison() + "' WHERE idCommande =" + t.getIdCommande();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(raq);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    /*===================================================*/
    @Override
    public void supprimerCommandeArticle(CommandeArticle t) {
        try {
            String raq = "DELETE FROM `commandearticle_article_utilisateur` WHERE idCommande=" + t.getIdCommande();
            String req = "DELETE FROM `commandearticle` WHERE idCommande= " + t.getIdCommande();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(raq);
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    /*===================================================*/
    @Override
    public ObservableList<CommandeArticle> getCommande(int id) {
        String req = "SELECT * FROM commandearticle_article_utilisateur WHERE idUtilisateur=" + id;
        Statement stm;
        ObservableList<CommandeArticle> m = FXCollections.observableArrayList();
        ArrayList a = new ArrayList();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                String v = "SELECT * FROM commandearticle WHERE idCommande = " + rs.getInt("idCommande");
                try {
                    stm = this.cnx.createStatement();
                    ResultSet v1 = stm.executeQuery(v);
                    while (v1.next()) {
                        CommandeArticle t = new CommandeArticle();
                        t.setModeLivraison(v1.getString("modeLivraison"));
                        t.setDateCommande(v1.getDate("dateCommande"));
                        t.setStatusLivraison(v1.getString("statusLivraison"));
                        t.setIdCommande(rs.getInt("idCommande"));
                        try {
                            ResultSet v2 = stm.executeQuery(req);
                            while (v2.next()) {
                                String v10 = "SELECT * FROM article WHERE idArticle = " + rs.getInt("idArticle");
                                try {
                                    stm = this.cnx.createStatement();
                                    ResultSet v3 = stm.executeQuery(v10);
                                    while (v3.next()) {
                                        t.setNomArticle(v3.getString("nomArticle"));
                                        t.setPrixArticle(v3.getFloat("prixArticle"));
                                        t.setIdArticle(v3.getInt("idArticle"));
                                    }
                                } catch (SQLException ex) {
                                    System.out.println(ex);
                                }
                            }
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                        m.add(t);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);

        }
        System.out.print(m);
        return m;
    }

    /*===================================================*/
    @Override
    public ObservableList<Article> getAllArticle() {
        String rq = "SELECT * FROM article";
        ObservableList<Article> l = FXCollections.observableArrayList();
        Statement stm;

        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rq);
            while (rs.next()) {
                Article s = new Article();
                s.setNomArticle(rs.getString("nomArticle"));
                s.setPrixArticle(rs.getInt("prixArticle"));
                s.setIdArticle(rs.getInt("idArticle"));
                l.add(s);

            }

        } catch (SQLException ex) {
            System.out.print(ex);

        }
        return l;
    }

    /*===================================================*/
    public Utilisateur selectUtilisateur(int id) {
        Utilisateur f = new Utilisateur();
        Statement stm;
        String v = "SELECT * FROM utilisateur WHERE idUser =" + id;
        try {
            stm = this.cnx.createStatement();
            ResultSet v1 = stm.executeQuery(v);
            while (v1.next()) {
                f.setNomUser(v1.getString("nomUser"));
                f.setPrenomUser(v1.getString("prenomUser"));
                f.setIdUser(v1.getInt("idUser"));
                f.setAdressUser(v1.getString("adressUser"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return f;
    }

    public Article selectArticle(int id) {
        Article f = new Article();
        Statement stm;
        String v = "SELECT * FROM article WHERE idArticle =" + id;
        try {
            stm = this.cnx.createStatement();
            ResultSet v1 = stm.executeQuery(v);
            while (v1.next()) {
                f.setNomArticle(v1.getString("nomArticle"));
                f.setPrixArticle(v1.getFloat("prixArticle"));
                f.setIdArticle(v1.getInt("idArticle"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return f;
    }

    public CommandeArticle selectCommande(int id) {
        String v = "SELECT * FROM commandearticle WHERE idCommande = " + id;
        Statement stm;
        CommandeArticle t = new CommandeArticle();
        try {
            stm = this.cnx.createStatement();
            ResultSet v1 = stm.executeQuery(v);
            while (v1.next()) {
                t.setModeLivraison(v1.getString("modeLivraison"));
                t.setDateCommande(v1.getDate("dateCommande"));
                t.setStatusLivraison(v1.getString("statusLivraison"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return t;
    }

    public ArrayList getArticle(int id) {
        ArrayList<Integer> a = new ArrayList();
        String req = "SELECT * FROM `commandearticle_article_utilisateur` WHERE idUtilisateur = " + id;
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                a.add(rs.getInt("idArticle"));
            }

        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return a;
    }

    @Override
    public float calculerTotaleHT(int z) {
        float q = 0;
        ArrayList<Integer> a = new ArrayList();
        a = getArticle(z);
        ArrayList<Float> n = new ArrayList();
        Statement stm;
        for (Integer j : a) {
            String req = "SELECT * FROM `article` WHERE `idArticle`=" + j;
            try {
                stm = this.cnx.createStatement();
                ResultSet rs = stm.executeQuery(req);
                while (rs.next()) {
                    q += rs.getFloat("prixArticle");
                }
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        }
        return q;
    }

    //////////////////////////SERVICE//////////////////////////////////////

    /*===================================================*/
    public int selectidS() {
        int p = 0;
        try {
            String req = "SELECT * FROM commandeservice WHERE idCommandeService=(SELECT max(idCommandeService) FROM commandeservice) ";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                p = rs.getInt("idCommandeService");
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        //System.out.println(p);

        return p;
    }

    public void ajouterService(ServiceT s, CommandeService a) {
        int z = selectidS();
        try {
            String raq = "INSERT INTO `commandeservice_service_utilisateur`(`idService`, `idUtilisateur`, `idCommandeService`) VALUES (" + s.getIdService() + "," + a.getUtilisateur().getIdUser() + "," + z + ")";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(raq);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public void ajouterCommandeService(ServiceT s, Utilisateur u, CommandeService a) {
        try {
            String req = "INSERT INTO `commandeservice`(`dateRequis`,`statusCommande`,`nbjour`) VALUES ('" + a.getDateRequis() + "','" + a.getStatusCommande() + "'," + a.getNbjour() + ")";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        ajouterService(s, a);
    }

    /*===================================================*/
    @Override
    public void modfierCommanderServiceClient(CommandeService a) {
        try {
            String raq = "UPDATE `commandeservice` SET `dateRequis`='" + a.getDateRequis() + "',`nbjour`=" + a.getNbjour() + " WHERE idCommandeService =" + a.getIdCommandeService();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(raq);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    /*===================================================*/
    @Override
    public void supprimerCommandeService(CommandeService a) {
        try {
            String raq = "DELETE FROM `commandeservice_service_utilisateur` WHERE idCommandeService=" + a.getIdCommandeService();
            String req = "DELETE FROM `commandeservice` WHERE `idCommandeService` = " + a.getIdCommandeService();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(raq);
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    /*===================================================*/
    @Override
    public ObservableList<CommandeService> getCommandeS(int id) {
        String req = "SELECT * FROM commandeservice_service_utilisateur WHERE idUtilisateur=" + id;
        Statement stm;
        ObservableList<CommandeService> m = FXCollections.observableArrayList();
        ArrayList a = new ArrayList();
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                String v = "SELECT * FROM commandeservice WHERE idCommandeService = " + rs.getInt("idCommandeService");
                try {
                    stm = this.cnx.createStatement();
                    ResultSet v1 = stm.executeQuery(v);
                    while (v1.next()) {
                        CommandeService t = new CommandeService();
                        t.setIdCommandeService(v1.getInt("idCommandeService"));
                        t.setDateRequis(v1.getDate("dateRequis"));
                        t.setDateCommandeService(v1.getDate("dateCommandeService"));
                        t.setStatusCommande(v1.getString("statusCommande"));
                        t.setNbjour(v1.getInt("nbjour"));
                        try {
                            ResultSet v2 = stm.executeQuery(req);
                            while (v2.next()) {
                                String v10 = "SELECT * FROM service WHERE idService = " + rs.getInt("idService");
                                try {
                                    stm = this.cnx.createStatement();
                                    ResultSet v3 = stm.executeQuery(v10);
                                    while (v3.next()) {
                                        t.setNomService(v3.getString("nomService"));
                                        t.setPrixService(v3.getFloat("prixService"));
                                        t.setIdService(v3.getInt("idService"));
                                    }
                                } catch (SQLException ex) {
                                    System.out.println(ex);
                                }
                            }
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                        m.add(t);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);

        }
        System.out.print(m);
        return m;
    }

    /*===================================================*/
    @Override
    public ObservableList<ServiceT> getAllService() {
        String rq = "SELECT * FROM service ";
        ObservableList<ServiceT> l = FXCollections.observableArrayList();
        Statement stm;

        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(rq);
            while (rs.next()) {
                ServiceT s = new ServiceT();
                s.setNomService(rs.getString("nomService"));
                s.setPrixService(rs.getInt("prixService"));
                s.setIdService(rs.getInt("idService"));
                l.add(s);

            }

        } catch (SQLException ex) {
            System.out.print(ex);

        }
        return l;
    }

    /*===================================================*/
    public ServiceT getService(int id) {
        ServiceT k = new ServiceT();
        String req = "SELECT * FROM service WHERE idService =" + id;
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                k.setNomService(rs.getString("nomService"));
                k.setPrixService(rs.getFloat("prixService"));
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return k;
    }

    public CommandeService getCommandeService(int id) {
        CommandeService m = new CommandeService();
        String req = "SELECT * FROM commandeservice WHERE idCommandeService =" + id;
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                m.setDateCommandeService(rs.getDate("dateCommandeService"));
                m.setDateRequis(rs.getDate("dateRequis"));
                m.setStatusCommande(rs.getString("statusCommande"));
                m.setNbjour(rs.getInt("nbjour"));
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return m;

    }

    public int selectIdDevisService() {
        int p = 0;
        try {
            String req = "SELECT * FROM devisservice WHERE idDevisService=(SELECT max(idDevisService) FROM devisservice) ";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                p = rs.getInt("idDevisService");
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return p;
    }

////////////////////////// DEVIS //////////////////////////////////////////
    @Override
    public void ajouterDevisArticle(Devis a) {
        int k = selectid();
        try {
            String req = "INSERT INTO `devis`(`totalHT`, `total`, `idCommande`) VALUES (" + a.getTotaleHT() + "," + a.getTotale() + "," + k + ")";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public void ajouterDevisService(DevisService d) {
        int k = selectidS();
        try {
            String req = "INSERT INTO `devisservice`(`total`,`idCommandeSevice`) VALUES (" + d.getTotale() + "," + k + ")";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public void genererDevisArticlePDF(int id) {
        int i = 0;
        try {
            String file_name = "C:\\Users\\ASUS\\Desktop\\Devis\\test.pdf";
            Document document = new Document();
            String req = "SELECT * FROM commandearticle_article_utilisateur WHERE idUtilisateur=" + id;
            Statement stm;
            //Statement a;
            int x = 0;
            ArrayList<Article> l = new ArrayList();
            Utilisateur f = new Utilisateur();
            Article b = new Article();
            CommandeArticle t = new CommandeArticle();
            ArrayList<String> liste = new ArrayList();
            Paragraph para = null;
            try {
                stm = this.cnx.createStatement();
                ResultSet rs = stm.executeQuery(req);
                while (rs.next()) {
                    int h = rs.getInt("idArticle");
                    b = selectArticle(h);
                    l.add(b);
                    t.setIdCommande(rs.getInt("idCommande"));
                    t = selectCommande(rs.getInt("idCommande"));
                    x = rs.getInt("idUtilisateur");
                    f = selectUtilisateur(id);

                    para = new Paragraph("Liste des Article : \n" + l);
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            float y = calculerTotaleHT(x);
            float j = (float) (y * 1.2) + 7;
            Paragraph par = new Paragraph("Total hors TVA : " + y + " DT \n"
                    + "Frais de livraison : 7 DT \n"
                    + "Total : " + j + " DT");

            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            ObservableList<CommandeArticle> k = FXCollections.observableArrayList();
            try {
                document.add(Image.getInstance("D:\\Ramcha\\ramcha\\RamchaCommande\\src\\tn\\edu\\esprit\\GUI\\307967906_1554365234997361_1384103615953836273_n.png"));
            } catch (BadElementException ex) {
                Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.add(para);
            document.add(par);
            document.close();
            Devis a = new Devis();
            a.setTotaleHT(y);
            a.setTotale(j);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void genererDevisServicePDF(int id) {
        int i = 0;
        try {
            String file_name = "C:\\Users\\ASUS\\Desktop\\Devis\\DevisService.pdf";
            Document document = new Document();
            String req = "SELECT * FROM commandeservice_service_utilisateur WHERE idUtilisateur=" + id;
            Statement stm;
            ServiceT y = new ServiceT();
            Utilisateur t = new Utilisateur();
            CommandeService n = new CommandeService();
            try {
                stm = this.cnx.createStatement();
                ResultSet rs = stm.executeQuery(req);
                while (rs.next()) {
                    int h = rs.getInt("idService");
                    y = getService(h);
                    t = selectUtilisateur(id);
                    int f = rs.getInt("idCommandeService");
                    n = getCommandeService(f);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            Paragraph para = null;
            para = new Paragraph("Service demandé : " + y.getNomService() + "\n"
                    + "Date du commande : " + n.getDateCommandeService() + "\n"
                    + "Date requis : " + n.getDateRequis() + "\n"
                    + "Nombre de jours : " + n.getNbjour() + "\n"
                    + "Prix du service ( par jour ) : " + y.getPrixService() + "\n"
                    + "Total : " + y.getPrixService() * n.getNbjour() + "\n");
            document.open();
            document.add(para);
            document.close();
            DevisService d = new DevisService();
            d.setTotale(y.getPrixService() * n.getNbjour());
            ajouterDevisService(d);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //////////////////////////// FACTURE ///////////////////////////////
    @Override
    public void ajouterFactureArticle(Facture a) {
        int l = selectid();
        int k = selectIdDevis();
        try {
            String req = "INSERT INTO `facture`(`facturePDF`, `idDevis`, `idCommande`, `total`) VALUES ('" + a.getFacturePDF() + "'," + k + "," + l + "," + a.getTotale() + ")";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public void ajouterFactureService(FactureService a) {
        int l = selectidS();
        int k = selectIdDevisService();
        try {
            String req = "INSERT INTO `factureservice`(`factureServicePDF`, `idDevisService`, `idCommandeService`, `total`) VALUES ('" + a.getFacturePDF() + "'," + k + "," + l + "," + a.getTotale() + ")";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public void genererFactureArticlePDF(int id) {
        int i = 0;
        try {
            String file_name = "C:\\Users\\ASUS\\Desktop\\Facture\\FactureArticle.pdf";
            Document document = new Document();
            //Utilisateur f = selectUtilisateur();
            String req = "SELECT * FROM commandearticle_article_utilisateur WHERE idUtilisateur=" + id;
            Statement stm;
            //Statement a;
            int x = 0;
            ArrayList<Article> l = new ArrayList();
            Utilisateur f = new Utilisateur();
            Article b = new Article();
            CommandeArticle t = new CommandeArticle();
            ArrayList<String> liste = new ArrayList();
            Paragraph para = null;
            try {
                stm = this.cnx.createStatement();
                ResultSet rs = stm.executeQuery(req);
                while (rs.next()) {
                    int h = rs.getInt("idArticle");
                    b = selectArticle(h);
                    l.add(b);
                    t.setIdCommande(rs.getInt("idCommande"));
                    t = selectCommande(rs.getInt("idCommande"));
                    x = rs.getInt("idUtilisateur");
                    f = selectUtilisateur(id);

                    para = new Paragraph("Nom et prenom du demondeur : " + f.getNomUser() + " " + f.getPrenomUser() + "\n"
                            + "Adresse du demandeur : " + f.getAdressUser() + "n"
                            + "Liste des Article : \n" + l // b.getNomArticle() + "\n    Prix : " + b.getPrixArticle() + "\n"
                            + "Autre details de commande : \n"
                            + "    Mode de livraison : " + t.getModeLivraison() + "\n"
                            + "    Date de commande : " + t.getDateCommande() + "\n");
                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            float y = calculerTotaleHT(x);
            float j = (float) (y * 1.2) + 7;
            Paragraph par = new Paragraph("Total hors TVA : " + y + " DT \n"
                    + "Frais de livraison : 7 DT \n"
                    + "Total : " + j + " DT");

            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            ObservableList<CommandeArticle> k = FXCollections.observableArrayList();
            try {
                document.add(Image.getInstance("D:\\Ramcha\\ramcha\\RamchaCommande\\src\\tn\\edu\\esprit\\GUI\\307967906_1554365234997361_1384103615953836273_n.png"));
            } catch (BadElementException ex) {
                Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.add(para);
            document.add(par);
            document.close();
            Facture m = new Facture();
            //m.setFacturePDF(document);
            m.setTotale(j);
            ajouterFactureArticle(m);
            GenerateQRCode u = new GenerateQRCode();
            String q = "Nom et prenom du demondeur : " + f.getNomUser() + " " + f.getPrenomUser() + "\n"
                    + "Adresse du demandeur : " + f.getAdressUser() + "n"
                    + "Liste des Article : \n" + l
                    + "Autre details de commande : \n"
                    + "    Mode de livraison : " + t.getModeLivraison() + "\n"
                    + "    Date de commande : " + t.getDateCommande() + "\n"
                    + "Total hors TVA : " + y + " DT \n"
                    + "Frais de livraison : 7 DT \n"
                    + "Total : " + j + " DT";
            File myObj = new File("D:\\Ramcha\\ramcha\\RamchaCommande\\src\\tn\\edu\\esprit\\GUI\\QRArticle.jpg");
            u.createQRImage(myObj, q, 500, "png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriterException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void genererFactureServicePDF(int id) {
        int i = 0;
        FactureService e = new FactureService();
        try {
            String file_name = "C:\\Users\\ASUS\\Desktop\\Facture\\FactureService.pdf";
            Document document = new Document();
            String req = "SELECT * FROM commandeservice_service_utilisateur WHERE idUtilisateur=" + id;
            Statement stm;
            ServiceT y = new ServiceT();
            Utilisateur t = new Utilisateur();
            CommandeService n = new CommandeService();
            try {
                stm = this.cnx.createStatement();
                ResultSet rs = stm.executeQuery(req);
                while (rs.next()) {
                    int h = rs.getInt("idService");
                    y = getService(h);
                    t = selectUtilisateur(id);
                    int f = rs.getInt("idCommandeService");
                    n = getCommandeService(f);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            Paragraph para = null;
            para = new Paragraph("Nom et prénom du demandeur : " + t.getNomUser() + " " + t.getPrenomUser() + "\n"
                    + "Adress du demandeur : " + t.getAdressUser() + "\n"
                    + "Service demandé : " + y.getNomService() + "\n"
                    + "Date du commande : " + n.getDateCommandeService() + "\n"
                    + "Date requis : " + n.getDateRequis() + "\n"
                    + "Nombre de jours : " + n.getNbjour() + "\n"
                    + "Prix du service ( par jour ) : " + y.getPrixService() + "\n"
                    + "Total : " + y.getPrixService() * n.getNbjour() + "\n"
                    + "Status de la commande : " + n.getStatusCommande());
            document.open();
            document.add(para);

            document.close();
            e.setFacturePDF(document);
            e.setTotale(y.getPrixService() * n.getNbjour());
            ajouterFactureService(e);
            //genererQRCodeFactureService(file_name);
            String m = "Nom et prénom du demandeur : " + t.getNomUser() + " " + t.getPrenomUser() + "\n"
                    + "Adress du demandeur : " + t.getAdressUser() + "\n"
                    + "Service demandé : " + y.getNomService() + "\n"
                    + "Date du commande : " + n.getDateCommandeService() + "\n"
                    + "Date requis : " + n.getDateRequis() + "\n"
                    + "Nombre de jours : " + n.getNbjour() + "\n"
                    + "Prix du service ( par jour ) : " + y.getPrixService() + "\n"
                    + "Total : " + y.getPrixService() * n.getNbjour() + "\n"
                    + "Status de la commande : " + n.getStatusCommande();
            File myObj = new File("D:\\Ramcha\\ramcha\\RamchaCommande\\src\\tn\\edu\\esprit\\GUI\\QRService.jpg");
            GenerateQRCode u = new GenerateQRCode();
            u.createQRImage(myObj, m, 500, "png");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriterException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CommandeServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //////////////////////////ADMIN////////////////////////////////////////
    @Override
    public ObservableList<CommandeService> getAllCommandeSer() {
        ObservableList<CommandeService> f = FXCollections.observableArrayList();
        String req = "SELECT * FROM commandeservice";
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                CommandeService p = new CommandeService();
                p.setIdCommandeService(v1.getInt("idCommandeService"));
                p.setDateCommandeService(v1.getDate("dateCommandeService"));
                p.setNbjour(v1.getInt("nbjour"));
                p.setStatusCommande(v1.getString("statusCommande"));
                p.setDateRequis(v1.getDate("dateRequis"));
                f.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return f;
    }

    @Override
    public ObservableList<CommandeArticle> getAllCommandeArt() {
        ObservableList<CommandeArticle> f = FXCollections.observableArrayList();
        String req = "SELECT * FROM commandearticle";
        Statement stm;
        try {
            stm = this.cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                CommandeArticle p = new CommandeArticle();
                p.setIdCommande(v1.getInt("idCommande"));
                p.setDateCommande(v1.getDate("dateCommande"));
                p.setStatusLivraison(v1.getString("statusLivraison"));
                p.setModeLivraison(v1.getString("modeLivraison"));
                f.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return f;
    }

    @Override
    public void modifierCommandeArticleAdmin(CommandeArticle a) {
        try {
            String raq = "UPDATE `commandearticle` SET `statusLivraison`='" + a.getStatusLivraison() + "' WHERE idCommande =" + a.getIdCommande();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(raq);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public void modifierCommandeServiceAdmin(CommandeService a) {
        try {
            String raq = "UPDATE `commandeservice` SET `statusCommande`='" + a.getStatusCommande() + "' WHERE idCommandeService =" + a.getIdCommandeService();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(raq);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }

    @Override
    public ObservableList<Facture> getAllFactureArt() {
        ObservableList<Facture> f = FXCollections.observableArrayList();
        String res = "SELECT * FROM `facture`";
        Statement stm;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(res);
            while (v1.next()) {
                Facture p = new Facture();

                //p.setIdFacture(v1.getInt("idFacture"));
                p.setDateFacture(v1.getDate("dateFacture"));
                p.setTotale(v1.getFloat("total"));
                f.add(p);
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }

        return f;
    }

    @Override
    public ObservableList<FactureService> getAllFactureSer() {
        ObservableList<FactureService> f = FXCollections.observableArrayList();
        String req = "SELECT * FROM `factureservice`";
        Statement stm;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                FactureService p = new FactureService();

                //p.setIdFactureService(v1.getInt("idFactureService"));
                p.setDateFacture(v1.getDate("dateFacture"));
                p.setTotale(v1.getFloat("total"));

                f.add(p);
            }

        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return f;
    }

    ////////////////////////// Calcul des commandes ////////////////////////////////////////
    @Override
    public int calculCommandeArticleTraitement(int a) {
        String req = "SELECT * FROM commandearticle";
        Statement stm;
        a = 0;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                if (v1.getString("statusLivraison").equals("En cours de traitement")) {
                    a++;
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return a;
    }

    @Override
    public int calculCommandeArticleLivraison(int a) {
        String req = "SELECT * FROM commandearticle";
        Statement stm;
        a = 0;

        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                if (v1.getString("statusLivraison").equals("En cours de livraison")) {
                    a++;
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return a;
    }

    @Override
    public int calculCommandeArticleTraitee(int a) {
        String req = "SELECT * FROM commandearticle";
        Statement stm;
        a = 0;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                if (v1.getString("statusLivraison").equals("Deja traité")) {
                    a++;
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return a;
    }

    @Override
    public int calculCommandeServiceTraitement(int a) {
        String req = "SELECT * FROM commandeservice";
        Statement stm;
        a = 0;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                if (v1.getString("statusCommande").equals("en cours de traitement")) {
                    a++;
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return a;
    }

    @Override
    public int calculCommandeServiceLivraison(int a) {
        String req = "SELECT * FROM commandeservice";
        Statement stm;
        a = 0;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                if (v1.getString("statusCommande").equals("En cours de livraison")) {
                    a++;
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return a;
    }

    @Override
    public int calculCommandeServiceTraitee(int a) {
        String req = "SELECT * FROM commandeservice";
        Statement stm;
        a = 0;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                if (v1.getString("statusCommande").equals("Deja traité")) {
                    a++;
                }
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return a;
    }

    public Utilisateur selectinfouser(String a){
        Utilisateur u = new Utilisateur();
        String req = "SELECT * FROM utilisateur WHERE loginUser='"+a+"'";
        Statement stm;
        try {
            stm = cnx.createStatement();
            ResultSet v1 = stm.executeQuery(req);
            while (v1.next()) {
                u.setIdUser(v1.getInt("idUser"));
                u.setNomUser(v1.getString("nomUser"));
                u.setPrenomUser(v1.getString("prenomUser"));
            }
        } catch (SQLException ex) {
            System.out.print(ex);
        }

        
        return u;
    }
    
}
