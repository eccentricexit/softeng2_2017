package com.ed.engsoft.test;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.ed.engsoft.Aviao;
import com.ed.engsoft.Helicoptero;
import com.ed.engsoft.TorreDeControle;

public class TorreDeControleTest {	

	TorreDeControle torreDeControle;
	Scanner scanner;
	@Before
	public void setUp() throws Exception {
		scanner = new Scanner(System.in);
		torreDeControle = new TorreDeControle(scanner);
	}	
	
	@Test
	public void testAdicionarAeronave() {
		int countMapa = torreDeControle.aeronaves.size();
		int countLista = torreDeControle.listarAvioes().size();
		
		String codAviao = "TEST001";
		Aviao aviaoTeste = new Aviao(scanner,codAviao);
		
		torreDeControle.adicionarAeronave(aviaoTeste.cod, aviaoTeste);		
		assertEquals(torreDeControle.listarAvioes().size(),countLista+1);
		assertEquals(torreDeControle.aeronaves.size(),countMapa+1);
		assertEquals(torreDeControle.aeronaves.containsKey(codAviao),true);
		
		
		countLista = torreDeControle.listarHelicopteros().size();
		
		String codHeli = "TEST002";
		Helicoptero helicopteroTeste = new Helicoptero(scanner,codHeli);
		
		torreDeControle.adicionarAeronave(helicopteroTeste.cod, helicopteroTeste);		
		
		assertEquals(torreDeControle.listarHelicopteros().size(),countLista+1);
		assertEquals(torreDeControle.aeronaves.size(),countMapa+2);
		assertEquals(torreDeControle.aeronaves.containsKey(codHeli),true);
	}	

	
	@Test
	public void testRemoverAeronave() {		
		String codAviao = "TEST001";
		Aviao aviaoTeste = new Aviao(scanner,codAviao);

		String codHeli = "TEST002";
		Helicoptero helicopteroTeste = new Helicoptero(scanner,codHeli);
		
		torreDeControle.adicionarAeronave(aviaoTeste.cod, aviaoTeste);		
		torreDeControle.adicionarAeronave(helicopteroTeste.cod, helicopteroTeste);	
		
		assertEquals(torreDeControle.listarHelicopteros().size(),1);		
		assertEquals(torreDeControle.listarAvioes().size(),1);
		
		torreDeControle.removerAeronave(aviaoTeste.cod);		
		torreDeControle.removerAeronave(helicopteroTeste.cod);
		
		assertEquals(0,torreDeControle.listarHelicopteros().size());		
		assertEquals(0,torreDeControle.listarAvioes().size());
	}

		

}
