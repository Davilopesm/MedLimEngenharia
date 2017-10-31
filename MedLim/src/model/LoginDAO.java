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
    
    public static boolean cadastrarLogin(){
        sql = "INSERT INTO login (login, senha) VALUES (?,?)";
        
        String login = "admin";
        String senha = "admin";
        
        try{//converter para hash q senha
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            senha = encoder.encode(digest.digest());
	}
        catch(NoSuchAlgorithmException ns){
            return false;
	}
        
        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
    
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            return false;            
        }
    }
        
}
