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
 * @author davi
 */
public class ProfissionalDAOTest {
    
    public ProfissionalDAOTest() {
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

    /**
     * Test of getInstance method, of class ProfissionalDAO.
     */
    @Test
    public void testGetInstance() {
       System.out.println("getInstance");
       ProfissionalDAO.getInstance();             
    }

    /**
     * Test of salvarProfissionalTecnico method, of class ProfissionalDAO.
     */
    @Test
    public void testSalvarProfissionalTecnico() {
        testGetInstance();
        String nome = "Jorge Canvas";
        long CPF = 43098179805L;
        long RG = 426075006;
        String endereco = "Paulinia";
        String telefone = "(19)992487631";
        String cargo = "Atendente";
        boolean result = ProfissionalDAO.salvarProfissionalTecnico(nome, CPF, RG, endereco, telefone, cargo);
        if(result){
            System.out.println("Deu certo");
        }
        else{
            fail("Deu ruim");
        }
    }
    
     /**
     * Test of salvarProfissionalTecnico method, of class ProfissionalDAO.
     */
    @Test
    public void testSalvarProfissionalMedico() {
        testGetInstance();
        String nome = "Jorge Canvas";
        long CPF = 430795805L;
        long RG = 42750506;
        String endereco = "Paulinia";
        String telefone = "(19)992487631";
        long CRM = 1234567;
        String area_de_atuacao = "Oncologista";
        boolean result = ProfissionalDAO.salvarProfissionalMedico(nome, CPF, RG, endereco, telefone, CRM, area_de_atuacao);
        if(result){
            System.out.println("Deu certo");
        }
        else{
            fail("Deu ruim");
        }
    }

    /**
     * Test of buscarUmProfissionalMedico method, of class ProfissionalDAO.
     */
    @Test
    public void testBuscarUmProfissionalMedico() {
        testGetInstance();
        ResultSet result = null; 
        result = ProfissionalDAO.buscarUmProfissionalMedico(43098179805L);
        if(result != null){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }

    /**
     * Test of buscarProfissionalMedico method, of class ProfissionalDAO.
     */
    @Test
    public void testBuscarProfissionalMedico() {
        testGetInstance();
        ResultSet result = null; 
        result = ProfissionalDAO.buscarProfissionalMedico();
        if(result != null){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }

    @Test
    public void testDeletarProfissional() {
        System.out.println("deletarProfissional");
        testGetInstance();
        long CPF = 43098179805L;
        boolean result = ProfissionalDAO.deletarProfissional(CPF);
        long CPFTecnico = 430795805L;
        boolean resultTecnico = ProfissionalDAO.deletarProfissional(CPFTecnico);
        if(result && resultTecnico){
            System.out.println("Deu certo");
        }
        else{
            fail("Deu Ruim");
        }
    }
    
    
}
