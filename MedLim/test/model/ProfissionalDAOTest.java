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
    public void testBuscarTecnicoAtualizar() {
        testGetInstance();
        System.out.println("buscarTecnicoAtualizar");
        long CPF = 43098179805L;
        String[] result = ProfissionalDAO.buscarTecnicoAtualizar(CPF);
        if(result != null){
            System.out.println("Sucesso");
        }
        else{
            fail("The test case is a prototype.");
        }
    }

    @Test
    public void testBuscarMedicoAtualizar() {
        testGetInstance();
        System.out.println("buscarMedicoAtualizar");
        long CPF = 430795805L;
        String[] result = ProfissionalDAO.buscarMedicoAtualizar(CPF);
        if(result != null){
            System.out.println("Sucesso");
        }
        else{
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void testAtualizarTecnico() {
        System.out.println("atualizarTecnico");
        long CPF = 0L;
        String novoNome = "Adamastor";
        long novoCPF = 0L;
        long novoRG = 0L;
        String novoEndereco = "Texas";
        String novoTelefone = "19992235433";
        String novoCargo = "Jobster";
        boolean result = ProfissionalDAO.atualizarTecnico(CPF, novoNome, novoCPF, novoRG, novoEndereco, novoTelefone, novoCargo);
        if(result){
            System.out.println(result);            
        }
        else{
            fail("Deu Ruim");
        }
    }
    
     @Test
    public void testAtualizarMedico() {
        System.out.println("atualizarMedico");
        long CPF = 0L;
        String novoNome = "Adamastor";
        long novoCPF = 1L;
        long novoRG = 1L;
        String novoEndereco = "Texas";
        String novoTelefone = "19992235433";
        long novoCRM = 777;
        boolean result = ProfissionalDAO.atualizarMedico(CPF, novoNome, novoCPF, novoRG, novoEndereco, novoTelefone, novoCRM);
        if(result){
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

    @Test
    public void testBuscarUmProfissionalTecnico() {
        System.out.println("buscarUmProfissionalTecnico");
        testGetInstance();
        long CPF = 0L;
        ResultSet result = ProfissionalDAO.buscarUmProfissionalTecnico(CPF);
        if(result != null){
            System.out.println("Deu bom");
        }
        else{
            fail("Deu ruim");
        }
    }

    @Test
    public void testBuscarProfissionalTecnico() {
        System.out.println("buscarUmProfissionalTecnico");
        testGetInstance();
        ResultSet result = ProfissionalDAO.buscarProfissionalTecnico();
        if(result != null){
            System.out.println("Deu bom");
        }
        else{
            fail("Deu ruim");
        }
    }

    


   
    
    
}
