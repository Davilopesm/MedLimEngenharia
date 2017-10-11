package control;

import model.*;

/**
 *
 * @author ScrumTeam
 */
public class Control {
    
    public static void fazerLogin(String login, String senha){
        LoginDAO.getInstance().checarLogin(login, senha);
        
    }
        
    
}
