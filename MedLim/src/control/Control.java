package control;

import java.sql.ResultSet;
import java.util.List;
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
    
    public static ResultSet buscarPaciente(){
        PacienteDAO.getInstance();  
        ResultSet rs = PacienteDAO.buscarPaciente();
        return rs;
    }
    
    public static ResultSet buscarUmPaciente(long CPF){
        PacienteDAO.getInstance();  
        ResultSet rs = PacienteDAO.buscarUmPaciente(CPF);
        return rs;
    }
       
        
    
}
