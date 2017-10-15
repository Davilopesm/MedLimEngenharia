package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PacienteDAO extends DAO {
    
    private static PacienteDAO instance;
    private static Connection myCONN;
   

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
    public static boolean salvarPaciente(String nome, float CPF, float RG, String endereco, float telefone){
        String salvar = "INSERT INTO paciente (nome,CPF,RG,endereco,telefone) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt;
        try{
            pstmt = myCONN.prepareStatement(salvar);
            pstmt.setString(1, nome);
            pstmt.setFloat(2, CPF);
            pstmt.setFloat(3, RG);
            pstmt.setString(4, endereco);
            pstmt.setFloat(5, telefone);
            pstmt.executeUpdate();           
            return true;
        }
        catch(SQLException ex){
            return false;
        }
    }
}
    
    
  
