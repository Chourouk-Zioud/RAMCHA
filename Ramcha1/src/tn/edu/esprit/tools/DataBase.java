/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tools;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class DataBase {
    private Connection cnx;
    private static DataBase instance;
    private String url = "jdbc:mysql://localhost:3306/ramcha";
    private String user = "root";
    private String password = "";
    
    private DataBase(){
        try {
            cnx = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static DataBase getInstance(){
        if(instance == null){
            instance = new DataBase();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return this.cnx;
    }
    
}
