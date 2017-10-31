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

/**
 *
 * @author davi
 */
public class ProfissionalDAO extends DAO{
    
    private static ProfissionalDAO instance;
    private static Connection myCONN;
    private static String sql;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    private ProfissionalDAO() {
        
    }
    
    public static ProfissionalDAO getInstance() {
        if (instance == null) {
            instance = new ProfissionalDAO();
            myCONN = instance.getConnection();
        }
        return instance;
    }
     
    
    public static boolean salvarProfissionalTecnico(String nome, long CPF, long RG, String endereco, String telefone, String cargo){
        sql = "INSERT INTO profissional (nome,CPF,RG,endereco,telefone,cargo) VALUES (?,?,?,?,?,?)";
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setLong(2, CPF);
            pstmt.setLong(3, RG);
            pstmt.setString(4, endereco);
            pstmt.setString(5, telefone);
            pstmt.setString(6, cargo);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            return false;            
        }
    }     
    
     public static boolean salvarProfissionalMedico(String nome, long CPF, long RG, String endereco, String telefone, long CRM, String area_de_atuacao){
        sql = "INSERT INTO profissional (nome,CPF,RG,endereco,telefone,CRM,areadeatuacao) VALUES (?,?,?,?,?,?,?)";
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setLong(2, CPF);
            pstmt.setLong(3, RG);
            pstmt.setString(4, endereco);
            pstmt.setString(5, telefone);
            pstmt.setLong(6, CRM);
            pstmt.setString(7, area_de_atuacao);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            return false;            
        }
    }

    public static ResultSet buscarUmProfissionalMedico(long CPF)  {
 
      sql = "SELECT * FROM profissional WHERE CPF=?";
 
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        pstmt.setLong(1, CPF);
        rs = pstmt.executeQuery();  
        return rs;
       
      }
      catch(SQLException ex){
        return null;
      }                    
       
    }
    
    public static ResultSet buscarUmProfissionalTecnico(long CPF)  {
 
      sql = "SELECT * FROM profissional WHERE CPF=?";
 
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        pstmt.setLong(1, CPF);
        rs = pstmt.executeQuery();  
        return rs;
       
      }
      catch(SQLException ex){
        return null;
      }                    
       
    }
    
     public static ResultSet buscarProfissionalMedico(){
       
      sql = "SELECT * FROM profissional WHERE cargo IS NULL";

      
      try{
        pstmt = myCONN.prepareStatement(sql);
        rs = pstmt.executeQuery();
      }
      catch(SQLException ex){
           return null;
      }  
      return rs;
    }
     
    public static ResultSet buscarProfissionalTecnico(){
       
      sql = "SELECT * FROM profissional WHERE CRM IS NULL";

      
      try{
        pstmt = myCONN.prepareStatement(sql);
        rs = pstmt.executeQuery();
      }
      catch(SQLException ex){
           return null;
      }  
      return rs;
    }
     
     
    public static boolean deletarProfissional(long CPF){
       
      sql = "DELETE FROM profissional WHERE (CPF)=(?)";
        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPF);
            pstmt.executeUpdate();  
            return true;              
        }
        catch(SQLException ex){
           return false;
        }                    
    }
    
     
     
}
