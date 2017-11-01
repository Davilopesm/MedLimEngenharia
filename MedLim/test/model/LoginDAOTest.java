/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Davi
 */
public class LoginDAOTest {
    
    public LoginDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checarLogin method, of class LoginDAO.
     */
    @Test
    public void testChecarLogin() {
        String login = "admin";
        String senha = "admin";
        
        try{//converter para hash q senha
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            senha = encoder.encode(digest.digest());
	}
        catch(NoSuchAlgorithmException ns){
            
	}
        
        LoginDAO.getInstance();
        boolean result = LoginDAO.checarLogin(login, senha);
        if(result){
            System.out.println("Deu certo");
        }
        else{
            fail("Deu Ruim");
        }
        
    }
    
}
