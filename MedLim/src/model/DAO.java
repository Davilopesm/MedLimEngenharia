package model;

import java.sql.*;

/**
 *
 * @author Davi
 */

public abstract class DAO {
  
    private static Connection con;    
    
    protected Connection getConnection() {
       if (con == null) {
           try {
               con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/medlim", "root", "davi");
           } catch (SQLException e) {
               throw new IllegalStateException("Cannot connect the database!", e);
           }
       }
       return con;
    }
    
    
}
