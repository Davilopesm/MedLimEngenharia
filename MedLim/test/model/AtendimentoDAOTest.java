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
public class AtendimentoDAOTest {
    
    public AtendimentoDAOTest() {
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
        AtendimentoDAO result = AtendimentoDAO.getInstance();
        if(result != null){
            System.out.println("Deu bom");
        }
        else{
            fail("Deu ruim");
        }

    }

    @Test
    public void testConsultarPacienteExiste() {
        testGetInstance();
        System.out.println("consultarPacienteExiste");
        long CPFPaciente = 43098179805L;
        boolean result = AtendimentoDAO.consultarPacienteExiste(CPFPaciente);
        if(result == true){
          System.out.println("Deu bom");  
        }
        else{
            fail("Deu ruim.");
        }
    }

    @Test
    public void testConsultarMedicoExiste() {
        testGetInstance();
        System.out.println("consultarPacienteExiste");
        String nomeMedico = "Jorge Canvas";
        boolean result = AtendimentoDAO.consultarMedicoExiste(nomeMedico);
        if(result == true){
          System.out.println("Deu bom");  
        }
        else{
            fail("Deu ruim");
        }
    }

    @Test
    public void testHorarioUsado() {
        testGetInstance();
        System.out.println("horarioUsado");
        String nomeMedico = "Jorge Canvas";
        String data = "31-10-2017";
        String horario = "16:00";
        boolean result = AtendimentoDAO.horarioUsado(nomeMedico, data, horario);
        if(result != true){
            System.out.println("Deu bom");  
        }
        else{
            fail("Deu ruim.");
        }   
    }

    @Test
    public void testHorariosVagos() {
        testGetInstance();
        System.out.println("horariosVagos");
        String nomeMedico = "Jorge Canvas";
        String data = "31-10-2017";
        String[] result = AtendimentoDAO.horariosVagos(nomeMedico, data);
        if(result != null){
            System.out.println("Deu bom");  
        }
        else{
            fail("Deu ruim.");
        }   
        

    }

    @Test
    public void testSalvarConsulta() {
        testGetInstance();
        System.out.println("salvarConsulta");
        long CPFPaciente = 43098179805L;
        String nomeMedico = "Jorge Canvas";
        String data = "31-10-2017";
        String horario = "16:00";
        boolean result = AtendimentoDAO.salvarConsulta(CPFPaciente, nomeMedico, data, horario);
        if(result == true){
            System.out.println("Deu bom");  
        }
        else{
            fail("Deu ruim.");
        }   
    }

    @Test
    public void testDeletarConsulta() {
        testGetInstance();
        System.out.println("deletarConsulta");
        long CPFPaciente = 43098179805L;
        String data = "31-10-2017";
        String horario = "16:00";
        boolean result = AtendimentoDAO.deletarConsulta(CPFPaciente, data, horario);
        if(result == true){
            System.out.println("Deu bom");  
        }
        else{
            fail("Deu ruim.");
        }   
    }
    
    
    
}
