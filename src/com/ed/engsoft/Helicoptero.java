package com.ed.engsoft;

import java.util.Scanner;

public class Helicoptero extends Aeronave{	
	
	public static final String NO_HELIPORTO = "no heliporto";
	public static final int TRIPULACAO_DO_HELICOPTERO = 5;	

	public Helicoptero(Scanner scanner, String cod) {
		super(scanner, cod,NO_HELIPORTO); 
	}		
	
	public int pousar() {
		if(super.pousar()==Aeronave.OPERATION_SUCCESS_CODE){
			localizacao = NO_HELIPORTO;
			return Aeronave.OPERATION_FAIL_CODE;
		}
		else
			return Aeronave.OPERATION_FAIL_CODE;
	}	

	public int embarcar() {
		if(super.embarcar()==Aeronave.OPERATION_SUCCESS_CODE){
			tripulacao = TRIPULACAO_DO_HELICOPTERO;
			return Aeronave.OPERATION_SUCCESS_CODE;
		}else
			return Aeronave.OPERATION_FAIL_CODE;
	}

	
	

}
