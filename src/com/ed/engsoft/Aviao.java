package com.ed.engsoft;

import java.util.Scanner;

public class Aviao extends Aeronave{	
	public static final String NA_PISTA = "na pista";
	public static final int TRIPULACAO_DO_AVIAO = 120;	
	
	public Aviao(Scanner scanner, String cod) {
		super(scanner, cod,NA_PISTA);		
	}	

	public int pousar() {
		if(super.pousar()==Aeronave.OPERATION_SUCCESS_CODE){
			localizacao = NA_PISTA;
			return Aeronave.OPERATION_FAIL_CODE;
		}
		else
			return Aeronave.OPERATION_FAIL_CODE;
	}	

	public int embarcar() {
		if(super.embarcar()==Aeronave.OPERATION_SUCCESS_CODE){
			tripulacao = TRIPULACAO_DO_AVIAO;
			return Aeronave.OPERATION_SUCCESS_CODE;
		}else
			return Aeronave.OPERATION_FAIL_CODE;
	}


}
