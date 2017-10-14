package control;

import model.*;

/**
 *
 * @author ScrumTeam
 */
public class Control {
    
    public static boolean fazerLogin(String login, String senha){
        LoginDAO.getInstance();                
        return LoginDAO.checarLogin(login, senha) == true;        
    }
        
    
}
