package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Davi
 */
public class LoginDAO extends DAO {
    
    private static LoginDAO instance;
    private static Connection myCONN;
    private static String sql;
    private static PreparedStatement pstmt;

    private LoginDAO() {
    }

    public static LoginDAO getInstance() {
        if (instance == null) {
            instance = new LoginDAO();
            myCONN = instance.getConnection();
        }
        return instance;
    }
    
    public static boolean checarLogin(String login, String senha){
        sql = "select * from login where (login,senha)=(?,?)";

        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
               pstmt.close();
               return true;                             
            }
            else{
               pstmt.close();
               return false;             
            }

        }catch(SQLException ex){
            return false;
        }
    }
    
    public static boolean checarProfissionalCPF(long CPF){
        sql = "SELECT * FROM profissional WHERE CPF=?"; 
      
        ResultSet rs;
        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPF);
            rs = pstmt.executeQuery();
            while(rs.next()){
                return true;
            }          
        }
        catch(SQLException ex){
            return false;
        }   
        return false;
       
    }
    
    public static boolean criarLogin(long CPF, String login, String senha){
        sql = "INSERT INTO login (CPF, login, senha) VALUES (?,?,?)";     
        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPF);
            pstmt.setString(2, login);
            pstmt.setString(3, senha);
    
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            return false;            
        }
    }
        
}
