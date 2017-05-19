package com.ed.engsoft.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.ed.engsoft.Aeronave;
import com.ed.engsoft.Aviao;

public class AviaoTest {

	Aviao aviaoTeste;
	@Before
	public void setUp() throws Exception {
		aviaoTeste = new Aviao(new Scanner(System.in),"test_aviao");
	}

	@Test
	public void testEmbarcar() {		
		aviaoTeste.embarcar();
		assertEquals(aviaoTeste.getTripulacao(), Aviao.TRIPULACAO_DO_AVIAO);
		assertEquals(aviaoTeste.isTripulada(), true);
	}
	
	@Test
	public void testDecolar(){
		aviaoTeste.embarcar();
		aviaoTeste.decolar();
		assertEquals(aviaoTeste.isEmVoo(),true);
		assertEquals(aviaoTeste.getLocalizacao(), Aeronave.EM_VOO);
	}
	
	@Test
	public void testPousar(){
		aviaoTeste.embarcar();
		aviaoTeste.decolar();
		aviaoTeste.pousar();
		assertEquals(aviaoTeste.isEmVoo(), false);
		assertEquals(aviaoTeste.getLocalizacao(),Aviao.NA_PISTA);
	}
	
	@Test
	public void testDesembarcar(){
		aviaoTeste.embarcar();
		aviaoTeste.desembarcar();
		assertEquals(aviaoTeste.isTripulada(), false);		
	}
	
	
	
	@Test
	public void testEmbarcarEmVoo() {		
		aviaoTeste.embarcar();
		aviaoTeste.decolar();
		assertEquals(aviaoTeste.embarcar(), Aeronave.OPERATION_FAIL_CODE);
	}
	
	
	@Test
	public void testDecolarSemTripulacao() {		
		assertEquals(aviaoTeste.decolar(),Aeronave.OPERATION_FAIL_CODE);
		assertNotEquals(aviaoTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertEquals(aviaoTeste.isEmVoo(), false);
	}
	
	@Test
	public void testDecolarEmVoo(){
		aviaoTeste.embarcar();
		aviaoTeste.decolar();
		assertEquals(aviaoTeste.decolar(),Aeronave.OPERATION_FAIL_CODE);
	}
	
	@Test
	public void testDesembarcarEmVoo() {		
		aviaoTeste.embarcar();
		aviaoTeste.decolar();
		assertEquals(aviaoTeste.desembarcar(), Aeronave.OPERATION_FAIL_CODE);
		assertNotEquals(aviaoTeste.getTripulacao(),0);
	}
	
	@Test
	public void testLocalizacaoEmVoo(){
		aviaoTeste.embarcar();
		aviaoTeste.decolar();
		
		assertEquals(aviaoTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertNotEquals(aviaoTeste.getLocalizacao(),Aviao.NA_PISTA);
	}
	
	@Test
	public void testPousoNoHeliporto(){
		assertNotEquals(aviaoTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertEquals(aviaoTeste.getLocalizacao(),Aviao.NA_PISTA);
		
		aviaoTeste.embarcar();
		aviaoTeste.decolar();
		aviaoTeste.pousar();
		
		assertNotEquals(aviaoTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertEquals(aviaoTeste.getLocalizacao(),Aviao.NA_PISTA);
	}
	
	@Test
	public void testContagemDeTripulantesAposEmbarque(){
		assertNotEquals(aviaoTeste.getTripulacao(), Aviao.TRIPULACAO_DO_AVIAO);
		aviaoTeste.embarcar();
		assertEquals(aviaoTeste.getTripulacao(), Aviao.TRIPULACAO_DO_AVIAO);
	}
	
	@Test
	public void testContagemDeTripulantesAposDesembarque(){
		aviaoTeste.embarcar();
		assertEquals(aviaoTeste.getTripulacao(), Aviao.TRIPULACAO_DO_AVIAO);
		aviaoTeste.desembarcar();
		assertEquals(aviaoTeste.getTripulacao(), 0);
	}

}
