/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
        String nome = "Will";
        long CPF = 43098179805L;
        long RG = 426075006;
        String endereco = "Valinhos";
        float telefone = 998726323;
        boolean result = PacienteDAO.salvarPaciente(nome, CPF, RG, endereco, telefone);
        if(result == true){
            System.out.println("Deu certo");
        }
        else{
            fail("Deu ruim");
        }
        
    }
    
}
