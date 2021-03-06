package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class PacienteDAO extends DAO {
    
    private static PacienteDAO instance;
    private static Connection myCONN;
    private static String sql;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    private PacienteDAO() {
        
    }
    
     public static PacienteDAO getInstance() {
        if (instance == null) {
            instance = new PacienteDAO();
            myCONN = instance.getConnection();
        }
        return instance;
    }
    
    /**
     *
     * @param nome
     * @param CPF
     * @param RG
     * @param endereco
     * @param telefone
     * @return
     */
    public static boolean salvarPaciente(String nome, long CPF, long RG, String endereco, String telefone){
        sql = "INSERT INTO paciente (nome,CPF,RG,endereco,telefone) VALUES (?,?,?,?,?)";
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setString(1, nome);
            pstmt.setLong(2, CPF);
            pstmt.setLong(3, RG);
            pstmt.setString(4, endereco);
            pstmt.setString(5, telefone);
            pstmt.executeUpdate();
            return true;
        }
        catch(SQLException ex){
            return false;            
        }
    }
    
    /**
     *
     * @return
     */
    public static ResultSet buscarPaciente(){
       
      sql = "SELECT * FROM paciente";
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        rs = pstmt.executeQuery();
      }
      catch(SQLException ex){
           return null;
      }  
      return rs;
    }
   
    /**
     *
     * @param CPF
     * @return
     */
    public static ResultSet buscarUmPaciente(long CPF)  {
 
      sql = "SELECT * FROM paciente WHERE CPF=?";
 
      
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
     
    
    public static String buscarHistorico(long CPF)  {
 
      sql = "SELECT * FROM paciente WHERE CPF=?";
      String historico;
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        pstmt.setLong(1, CPF);
        rs = pstmt.executeQuery();  
        while(rs.next()){
            historico = (rs.getString("historico"));
            return historico;
        }          
       
      }
      catch(SQLException ex){
           return null;
      }     
      
      return null;
       
    }
    
    public static boolean atualizarHistorico(long CPF, String historico){
        
      sql = "UPDATE paciente SET historico = ? WHERE CPF = ?";
     
      
      try{
        pstmt = myCONN.prepareStatement(sql);
        pstmt.setLong(2, CPF);
        pstmt.setString(1, historico);
        pstmt.executeUpdate();
        return true;        
      }
      catch(SQLException ex){
           return false;
      }     
     
    }
    
    public static String[] buscarPacienteAtualizar(long CPF){
        sql = "SELECT * FROM paciente WHERE CPF = ?";
        
        String[] dadosRetorno = new String[5];
        
        try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(1, CPF);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                dadosRetorno[0] = rs.getString("nome");
                dadosRetorno[1] = rs.getString("CPF");
                dadosRetorno[2] = rs.getString("RG");
                dadosRetorno[3] = rs.getString("endereco");
                dadosRetorno[4] = rs.getString("telefone");
                return dadosRetorno;
            }
        }
        catch(SQLException ex){
            return null;
        }
        return null;
    }
    
    public static boolean atualizarPaciente(long CPF, String novoNome, long novoCPF, long novoRG, String novoEndereco, String novoTelefone){ 
        sql = "UPDATE paciente SET nome = ?, CPF = ?, RG = ?, endereco = ?, telefone = ? WHERE CPF = ?";
     
      
         try{
            pstmt = myCONN.prepareStatement(sql);
            pstmt.setLong(6, CPF);
            pstmt.setString(1, novoNome);
            pstmt.setLong(2, novoCPF);
            pstmt.setLong(3, novoRG);
            pstmt.setString(4, novoEndereco);
            pstmt.setString(5, novoTelefone);            
            pstmt.executeUpdate();
            return true;        
        }
        catch(SQLException ex){
           return false;
        }     
    }
    
    
    public static boolean deletarPaciente(long CPF){
        
        sql = "DELETE FROM paciente WHERE (CPF)=(?)";
        
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
    
    
  
