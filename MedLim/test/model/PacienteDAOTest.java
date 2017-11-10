/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Davi
 */
public class PacienteDAOTest {
    
    public PacienteDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        PacienteDAO.getInstance();              
    }

    @Test
    public void testSalvarPaciente() {
        System.out.println("salvarPaciente");
        testGetInstance();
        String nome = "Fabio do Prado";
        long CPF = 43098179805L;
        long RG = 426075006;
        String endereco = "Paulinia";
        String telefone = "(19)992487631";
        boolean result = PacienteDAO.salvarPaciente(nome, CPF, RG, endereco, telefone);
        if(result){
            System.out.println("Deu certo");
        }
        else{
            fail("Deu ruim");
        }
        
    }
    
    @Test
    public void testBuscarPaciente(){
        System.out.println("buscarPaciente");
        testGetInstance();
        ResultSet result = null; 
        result = PacienteDAO.buscarPaciente();
        if(result != null){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }
    
    @Test
    public void testBuscarUmPaciente(){
        System.out.println("buscarUmPaciente");
        testGetInstance();
        ResultSet result = null; 
        result = PacienteDAO.buscarUmPaciente(43098179805L);
        if(result != null){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }
    
    @Test
    public void testAtualizarHistorico() {
        testGetInstance();
        System.out.println("buscarHistorico");
        long CPF = 0L;
        String teste = "Fala chapa";
        boolean result = PacienteDAO.atualizarHistorico(CPF, teste);
        if(result){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }
    
      
    @Test
    public void testBuscarHistorico() {
        System.out.println("buscarHistorico");
        long CPF = 0L;
        String result = PacienteDAO.buscarHistorico(CPF);
        if(result != null){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }
   
    
    @Test
    public void testAtualizarPaciente() {
        System.out.println("atualizarPaciente");
        long CPF = 43098179805L;
        String novoNome = "Adamastor";
        long novoCPF = 0L;
        long novoRG = 0L;
        String novoEndereco = "Texas";
        String novoTelefone = "19992235433";
        boolean result = PacienteDAO.atualizarPaciente(CPF, novoNome, novoCPF, novoRG, novoEndereco, novoTelefone);
        if(result){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }
    
    @Test
    public void testDeletarPaciente() {
        System.out.println("deletarPaciente");
        long CPF = 0L;
        boolean result = PacienteDAO.deletarPaciente(CPF);
        if(result){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }

  

    
    
}
