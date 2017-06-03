package com.ed.engsoft.test;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

import com.ed.engsoft.TorreDeControle;

public class TorreDeControleTest {

	TorreDeControle torreDeControle;
	
	
	@Before
	public void setUp() throws Exception {
		torreDeControle = new TorreDeControle(new Scanner(System.in));
	}
	
	@Test
	public void testOpcaoInvalida() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAdicionarAviao() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAdicionarHelicoptero() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAdicionarAeronave_opcaoInvalida() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRemoverAeronave() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRemoverAeronaveNaoDisponivel() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testListarAeronaves() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testComandarAeronave() {
		fail("Not yet implemented");
	}
	
	@Test
	public void printOptions(){
		fail("Not yet implemented");
	}
	

}
