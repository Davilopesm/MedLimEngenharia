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
        testGetInstance();
        String nome = "Fabio do Prado";
        long CPF = 43098179805L;
        long RG = 426075006;
        String endereco = "Paulinia";
        String telefone = "(19)992487631";
        boolean result = PacienteDAO.salvarPaciente(nome, CPF, RG, endereco, telefone);
        if(result == true){
            System.out.println("Deu certo");
        }
        else{
            fail("Deu ruim");
        }
        
    }
    
    @Test
    public void testBuscarPaciente(){
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
    
}
