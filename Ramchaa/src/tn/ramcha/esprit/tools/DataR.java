
package tn.ramcha.esprit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataR {
    
    private Connection cnx;
    private static DataR instance;
    
    private String url = "jdbc:mysql://localhost:3306/ramcha";
    private String user = "root";
    private String password = "";
    
    private DataR(){
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static DataR getInstance(){
        if(instance == null){
            instance = new DataR();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return this.cnx;
    }
 
    
}
