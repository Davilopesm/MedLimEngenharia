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
    
    public static boolean inserirPaciente(String nome, long CPF, long RG, String endereco, float telefone){ 
        PacienteDAO.getInstance();                
        return PacienteDAO.salvarPaciente(nome, CPF, RG, endereco, telefone) == true; 
    }
        
    
}
