package control;

import java.sql.ResultSet;
import model.*;

/**
 *
 * @author ScrumTeam
 */
public class Control {
    //FUNÇÃO DE LOGIN
    public static boolean fazerLogin(String login, String senha){
        LoginDAO.getInstance();                
        return LoginDAO.checarLogin(login, senha) == true;        
    }
    
    //FUNÇÕES DE PACIENTE
    public static boolean inserirPaciente(String nome, long CPF, long RG, String endereco, String telefone){ 
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
    
     public static boolean deletarPaciente(long CPF){ 
        PacienteDAO.getInstance();                
        return PacienteDAO.deletarPaciente(CPF) == true; 
    }
    
    
    //FUNÇÕES DE PROFISSIONAL
    public static boolean inserirProfissionalTecnico(String nome, long CPF, long RG, String endereco, String telefone, String cargo){ 
        ProfissionalDAO.getInstance();                
        return ProfissionalDAO.salvarProfissionalTecnico(nome, CPF, RG, endereco, telefone, cargo) == true; 
    }
    
    public static boolean inserirProfissionalMedico(String nome, long CPF, long RG, String endereco, String telefone, long CRM, String area_de_atuacao){ 
        ProfissionalDAO.getInstance();                
        return ProfissionalDAO.salvarProfissionalMedico(nome, CPF, RG, endereco, telefone, CRM, area_de_atuacao) == true; 
    }
    
    public static ResultSet buscarUmProfissionalMedico(long CPF){
        ProfissionalDAO.getInstance();  
        ResultSet rs = ProfissionalDAO.buscarUmProfissionalMedico(CPF);
        return rs;
    }
    
    public static ResultSet buscarProfissionalMedico(){
        ProfissionalDAO.getInstance();  
        ResultSet rs = ProfissionalDAO.buscarProfissionalMedico();
        return rs;
    }
    
    public static boolean deletarProfissional(long CPF){ 
        ProfissionalDAO.getInstance();                
        return ProfissionalDAO.deletarProfissional(CPF) == true; 
    }
    
    
    //FUNÇÕES DE ATENDIMENTO
    
    public static boolean pacienteExiste(long CPF){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.consultarPacienteExiste(CPF) == true; 
    }   
    
    public static boolean medicoExiste(String nomeMedico){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.consultarMedicoExiste(nomeMedico) == true; 
    }  
    
    public static boolean horarioJaUsado(String nomeMedico, String data, String horario){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.horarioUsado(nomeMedico, data, horario) == true; 
    }  
    
    public static String[] horariosVagos(String nomeMedico, String data) {
        AtendimentoDAO.getInstance();
        return AtendimentoDAO.horariosVagos(nomeMedico, data);
    }
    
    public static boolean agendarConsulta(long CPFPaciente, String nomeMedico, String data, String horario){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.salvarConsulta(CPFPaciente, nomeMedico, data, horario) == true; 
    }  


    
        
    
}
