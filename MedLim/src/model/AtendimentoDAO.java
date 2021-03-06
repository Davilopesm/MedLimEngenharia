/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Davi
 */
public class AtendimentoDAO extends DAO {
    
    private static AtendimentoDAO instance;
    private static Connection myCONN;
    private static String sql;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
     

    private AtendimentoDAO() {
        
    }
    
     public static AtendimentoDAO getInstance() {
        if (instance == null) {
            instance = new AtendimentoDAO();
            myCONN = instance.getConnection();
        }
        return instance;
    }
     
    public static boolean consultarPacienteExiste(long CPFPaciente){
        sql = "SELECT * FROM paciente WHERE CPF=?"; 
      
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPFPaciente);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                return true;
            }       
        }
        catch(SQLException ex){
            return false;
        } 
        return false;               
    }

    
    public static boolean consultarMedicoExiste(String nomeMedico){
        sql = "SELECT * FROM profissional WHERE nome=?"; 
      
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, nomeMedico);
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
    
    public static boolean horarioUsado(String nomeMedico, String data, String horario){
        sql = "SELECT * FROM consulta WHERE (nome_medico,data,horario)=(?,?,?)"; 
      
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, nomeMedico);
            pstmt.setString(2, data);
            pstmt.setString(3, horario);
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
    
    public static boolean horarioUsadoExame(String data, String horario) {
        sql = "SELECT * FROM exame WHERE (data,horario)=(?,?)"; 
      
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, data);
            pstmt.setString(2, horario);
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


    public static String[] horariosVagos(String nomeMedico, String data) {
        sql = "SELECT * FROM consulta WHERE (nome_medico,data)=(?,?)";        
        
        List<String> listOfString = new ArrayList<String>();

        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, nomeMedico);
            pstmt.setString(2, data);
            rs = pstmt.executeQuery();
            while(rs.next()){
                listOfString.add(rs.getString("horario"));
            }          
        }
        catch(SQLException ex){
            return null;
        }

       String[] retorno = listOfString.toArray(new String[0]);
       return retorno;
    }
    
    public static String[] horariosVagosExame(String data) {
        sql = "SELECT * FROM exame WHERE (data)=(?)";        
        
        List<String> listOfString = new ArrayList<String>();

        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, data);
            rs = pstmt.executeQuery();
            while(rs.next()){
                listOfString.add(rs.getString("horario"));
            }          
        }
        catch(SQLException ex){
            return null;
        }

       String[] retorno = listOfString.toArray(new String[0]);
       return retorno;
    }
       
    
    
     
    public static boolean salvarConsulta(long CPFPaciente, String nomeMedico, String data, String horario){
        sql = "INSERT INTO consulta (CPF_paciente,nome_medico,data,horario) VALUES (?,?,?,?)";
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPFPaciente);
            pstmt.setString(2, nomeMedico);
            pstmt.setString(3, data);
            pstmt.setString(4, horario);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            return false;            
        }
    }
    
    public static boolean salvarExame(long CPFPaciente, String data, String horario) {
        sql = "INSERT INTO exame (CPF_paciente,data,horario) VALUES (?,?,?)";
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPFPaciente);
            pstmt.setString(2, data);
            pstmt.setString(3, horario);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            return false;            
        }
    }
    
    public static ResultSet buscarTodasConsultas()  {
 
      sql = "SELECT * FROM consulta";
 
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        rs = pstmt.executeQuery();  
        return rs;
       
      }
      catch(SQLException ex){
           return null;
      }                    
       
    }
   
    public static ResultSet buscarConsultaMedico(String nomeMedico)  {
 
      sql = "SELECT * FROM consulta WHERE nome_medico=?";
 
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        pstmt.setString(1, nomeMedico);
        rs = pstmt.executeQuery();  
        return rs;
       
      }
      catch(SQLException ex){
           return null;
      }                    
       
    }
     
    public static ResultSet buscarConsultaPaciente(long CPFPaciente)  {
 
      sql = "SELECT * FROM consulta WHERE CPF_paciente=?";
 
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        pstmt.setLong(1, CPFPaciente);
        rs = pstmt.executeQuery();  
        return rs;
       
      }
      catch(SQLException ex){
           return null;
      }                    
       
    }
    
    public static ResultSet buscarTodosExames()  {
 
      sql = "SELECT * FROM exame";
 
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        rs = pstmt.executeQuery();  
        return rs;
       
      }
      catch(SQLException ex){
           return null;
      }                        
    }
    
     
    public static ResultSet buscarExamePaciente(long CPFPaciente)  {
 
      sql = "SELECT * FROM exame WHERE CPF_paciente=?";
 
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        pstmt.setLong(1, CPFPaciente);
        rs = pstmt.executeQuery();  
        return rs;
       
      }
      catch(SQLException ex){
           return null;
      }                    
       
    }
    
    public static boolean deletarConsulta(long CPFPaciente, String data, String horario){
        sql = "DELETE FROM consulta WHERE (CPF_paciente,data,horario) = (?,?,?)";
        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPFPaciente);
            pstmt.setString(2, data);
            pstmt.setString(3, horario);
            pstmt.executeUpdate();  
            return true;              
        }
        catch(SQLException ex){
           return false;
        }                    
    }
    
    
    public static boolean deletarExame(long CPFPaciente, String data, String horario) {
        sql = "DELETE FROM exame WHERE (CPF_paciente,data,horario) = (?,?,?)";
        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPFPaciente);
            pstmt.setString(2, data);
            pstmt.setString(3, horario);
            pstmt.executeUpdate();  
            return true;              
        }
        catch(SQLException ex){
           return false;
        }                    
    
    
    }
    
    
}
