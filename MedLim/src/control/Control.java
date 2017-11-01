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
        return LoginDAO.checarLogin(login, senha);        
    }
    
    public static boolean criarLogin(){
        LoginDAO.getInstance();                
        LoginDAO.cadastrarLogin();
        return true;
    }
    
    
    
    //FUNÇÕES DE PACIENTE
    public static boolean inserirPaciente(String nome, long CPF, long RG, String endereco, String telefone){ 
        PacienteDAO.getInstance();                
        return PacienteDAO.salvarPaciente(nome, CPF, RG, endereco, telefone); 
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
        return PacienteDAO.deletarPaciente(CPF); 
    }
    
    
    //FUNÇÕES DE PROFISSIONAL
    public static boolean inserirProfissionalTecnico(String nome, long CPF, long RG, String endereco, String telefone, String cargo){ 
        ProfissionalDAO.getInstance();                
        return ProfissionalDAO.salvarProfissionalTecnico(nome, CPF, RG, endereco, telefone, cargo); 
    }
    
    public static boolean inserirProfissionalMedico(String nome, long CPF, long RG, String endereco, String telefone, long CRM, String area_de_atuacao){ 
        ProfissionalDAO.getInstance();                
        return ProfissionalDAO.salvarProfissionalMedico(nome, CPF, RG, endereco, telefone, CRM, area_de_atuacao); 
    }
    
    public static ResultSet buscarUmProfissionalMedico(long CPF){
        ProfissionalDAO.getInstance();  
        ResultSet rs = ProfissionalDAO.buscarUmProfissionalMedico(CPF);
        return rs;
    }
    
    public static ResultSet buscarUmProfissionalTecnico(long CPF){
        ProfissionalDAO.getInstance();  
        ResultSet rs = ProfissionalDAO.buscarUmProfissionalTecnico(CPF);
        return rs;
    }
    
    public static ResultSet buscarProfissionalMedico(){
        ProfissionalDAO.getInstance();  
        ResultSet rs = ProfissionalDAO.buscarProfissionalMedico();
        return rs;
    }
    
    public static ResultSet buscarProfissionalTecnico(){
        ProfissionalDAO.getInstance();  
        ResultSet rs = ProfissionalDAO.buscarProfissionalTecnico();
        return rs;
    }
    
    public static boolean deletarProfissional(long CPF){ 
        ProfissionalDAO.getInstance();                
        return ProfissionalDAO.deletarProfissional(CPF); 
    }
    
    
    //FUNÇÕES DE ATENDIMENTO
    
    public static boolean pacienteExiste(long CPF){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.consultarPacienteExiste(CPF); 
    }   
    
    public static boolean medicoExiste(String nomeMedico){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.consultarMedicoExiste(nomeMedico); 
    }  
    
    public static boolean horarioJaUsado(String nomeMedico, String data, String horario){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.horarioUsado(nomeMedico, data, horario); 
    }  
    
    public static String[] horariosVagos(String nomeMedico, String data) {
        AtendimentoDAO.getInstance();
        return AtendimentoDAO.horariosVagos(nomeMedico, data);
    }
    
    public static boolean agendarConsulta(long CPFPaciente, String nomeMedico, String data, String horario){ 
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.salvarConsulta(CPFPaciente, nomeMedico, data, horario); 
    }  
    
    public static boolean deletarConsulta(long CPFPaciente, String data, String horario){
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.deletarConsulta(CPFPaciente, data, horario); 
    }
    
    public static boolean deletarExame(long CPFPaciente, String data, String horario) {
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.deletarExame(CPFPaciente, data, horario); 
    }
    
    public static ResultSet buscarTodasConsultas() {
        AtendimentoDAO.getInstance();  
        ResultSet rs = AtendimentoDAO.buscarTodasConsultas();
        return rs;
    }

    
    public static ResultSet buscarConsultaMedico(String nomeMedico){
        AtendimentoDAO.getInstance();  
        ResultSet rs = AtendimentoDAO.buscarConsultaMedico(nomeMedico);
        return rs;
    }
    
    public static ResultSet buscarConsultaPaciente(long CPFPaciente){
        AtendimentoDAO.getInstance();  
        ResultSet rs = AtendimentoDAO.buscarConsultaPaciente(CPFPaciente);
        return rs;
    }
    
    public static ResultSet buscarTodosExames() {
        AtendimentoDAO.getInstance();  
        ResultSet rs = AtendimentoDAO.buscarTodosExames();
        return rs;
    }
    
    public static ResultSet buscarExamePaciente(long CPFPaciente) {
        AtendimentoDAO.getInstance();  
        ResultSet rs = AtendimentoDAO.buscarExamePaciente(CPFPaciente);
        return rs;
    }

    public static boolean agendarExame(long CPFPaciente, String data, String horario) {
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.salvarExame(CPFPaciente, data, horario); 
    }

    public static boolean horarioJaUsadoExame(String data, String horario) {
        AtendimentoDAO.getInstance();                
        return AtendimentoDAO.horarioUsadoExame(data, horario); 
    }

    public static String[] horariosVagosExame(String data) {
        AtendimentoDAO.getInstance();
        return AtendimentoDAO.horariosVagosExame(data);
    }

  
 

   


    
        
    
}
