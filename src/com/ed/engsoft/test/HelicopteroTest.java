package com.ed.engsoft.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.ed.engsoft.Aeronave;
import com.ed.engsoft.Helicoptero;

public class HelicopteroTest {

	Helicoptero heliTeste;
	@Before
	public void setUp() throws Exception {
		heliTeste = new Helicoptero(new Scanner(System.in),"test_heli");
	}

	@Test
	public void testEmbarcar() {		
		heliTeste.embarcar();
		assertEquals(heliTeste.getTripulacao(), Helicoptero.TRIPULACAO_DO_HELICOPTERO);
		assertEquals(heliTeste.isTripulada(), true);
	}
	
	@Test
	public void testDecolar(){
		heliTeste.embarcar();
		heliTeste.decolar();
		assertEquals(heliTeste.isEmVoo(),true);
		assertEquals(heliTeste.getLocalizacao(), Aeronave.EM_VOO);
	}
	
	@Test
	public void testPousar(){
		heliTeste.embarcar();
		heliTeste.decolar();
		heliTeste.pousar();
		assertEquals(heliTeste.isEmVoo(), false);
		assertEquals(heliTeste.getLocalizacao(),Helicoptero.NO_HELIPORTO);
	}
	
	@Test
	public void testDesembarcar(){
		heliTeste.embarcar();
		heliTeste.desembarcar();
		assertEquals(heliTeste.isTripulada(), false);		
	}
	
	
	
	@Test
	public void testEmbarcarEmVoo() {		
		heliTeste.embarcar();
		heliTeste.decolar();
		assertEquals(heliTeste.embarcar(), Aeronave.OPERATION_FAIL_CODE);
	}
	
	
	@Test
	public void testDecolarSemTripulacao() {		
		assertEquals(heliTeste.decolar(),Aeronave.OPERATION_FAIL_CODE);
		assertNotEquals(heliTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertEquals(heliTeste.isEmVoo(), false);
	}
	
	@Test
	public void testDecolarEmVoo(){
		heliTeste.embarcar();
		heliTeste.decolar();
		assertEquals(heliTeste.decolar(),Aeronave.OPERATION_FAIL_CODE);
	}
	
	@Test
	public void testDesembarcarEmVoo() {		
		heliTeste.embarcar();
		heliTeste.decolar();
		assertEquals(heliTeste.desembarcar(), Aeronave.OPERATION_FAIL_CODE);
		assertNotEquals(heliTeste.getTripulacao(),0);
	}
	
	@Test
	public void testLocalizacaoEmVoo(){
		heliTeste.embarcar();
		heliTeste.decolar();
		
		assertEquals(heliTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertNotEquals(heliTeste.getLocalizacao(),Helicoptero.NO_HELIPORTO);
	}
	
	@Test
	public void testPousoNoHeliporto(){
		assertNotEquals(heliTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertEquals(heliTeste.getLocalizacao(),Helicoptero.NO_HELIPORTO);
		
		heliTeste.embarcar();
		heliTeste.decolar();
		heliTeste.pousar();
		
		assertNotEquals(heliTeste.getLocalizacao(), Aeronave.EM_VOO);
		assertEquals(heliTeste.getLocalizacao(),Helicoptero.NO_HELIPORTO);
	}
	
	@Test
	public void testContagemDeTripulantesAposEmbarque(){
		assertNotEquals(heliTeste.getTripulacao(), Helicoptero.TRIPULACAO_DO_HELICOPTERO);
		heliTeste.embarcar();
		assertEquals(heliTeste.getTripulacao(), Helicoptero.TRIPULACAO_DO_HELICOPTERO);
	}
	
	@Test
	public void testContagemDeTripulantesAposDesembarque(){
		heliTeste.embarcar();
		assertEquals(heliTeste.getTripulacao(), Helicoptero.TRIPULACAO_DO_HELICOPTERO);
		heliTeste.desembarcar();
		assertEquals(heliTeste.getTripulacao(), 0);
	}
		
	

}
