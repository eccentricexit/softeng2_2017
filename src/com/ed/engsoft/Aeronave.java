package com.ed.engsoft;

import java.util.Scanner;

public abstract class Aeronave {
	
	public static String EM_VOO = "em voo";
	public static int OPERATION_FAIL_CODE = -1;
	public static int OPERATION_SUCCESS_CODE = 0;
	
	protected Scanner scanner;
	public String cod;
	protected boolean emVoo = false;
	public boolean isEmVoo() {
		return emVoo;
	}

	public boolean isTripulada() {
		return tripulada;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	protected boolean tripulada = false;
	protected boolean commanding = true;
	
	protected String localizacao;
	protected int tripulacao = 0;
	 
	
	public Aeronave(Scanner scanner,String cod,String localizacaoInicial){
		this.scanner = scanner;
		this.cod = cod;
		this.localizacao = localizacaoInicial;
	}
	
	
	private void printOptions() {		
		System.out.println("Selecione uma opção.");
		System.out.println("1-Embarcar tripulantes aeronave.");
		System.out.println("2-Decolar aeronave.");
		System.out.println("3-Pousar aeronave.");
		System.out.println("4-Desembarcar tripulantes aeronave.");
		System.out.println("5-Mostrar localização da aeronave.");
		System.out.println("6-Mostrar quantas pessoas estao na aeronave.");
		System.out.println("0-Voltar.");
		System.out.println();
	}
	
	public int decolar() {
		if (emVoo) {
			System.out.println("Impossível decolar, aeronave em vôo.");
			System.out.println();
			return OPERATION_FAIL_CODE;
		}
		if (!tripulada) {
			System.out.println("Embarque tripulantes antes.");
			System.out.println();
			return OPERATION_FAIL_CODE;
		}
		emVoo = true;
		localizacao = EM_VOO;
		System.out.println("Operação concluída.");
		System.out.println();
		return 0;
	}	
	
	public int desembarcar() {
		if (emVoo) {
			System.out.println("Impossível desembarcar, aeronave em vôo.");
			System.out.println();
			return OPERATION_FAIL_CODE;
		}
		if (!tripulada) {
			System.out.println("Não há ninguém na aeronave.");
			System.out.println();
			return OPERATION_FAIL_CODE;
		}
		tripulada = false;	
		tripulacao = 0;
		System.out.println("Operação concluída.");
		System.out.println();
		return OPERATION_SUCCESS_CODE;
	}
		
	public int embarcar(){
		if (emVoo) {
			System.out.println("Impossível embarcar, aeronave em vôo.");
			System.out.println();
			return OPERATION_FAIL_CODE;
		}
		if (tripulada) {
			System.out.println("Aeronave já tripulada.");
			System.out.println();
			return OPERATION_FAIL_CODE;
		}
		tripulada = true;
		System.out.println("Operação concluída.");
		System.out.println();
		return OPERATION_SUCCESS_CODE;
	}
	
	public int pousar(){
		if (!emVoo) {
			System.out.println("Impossível pousar, aeronave não está em vôo.");
			System.out.println();
			return OPERATION_FAIL_CODE;
		}			
		emVoo = false;
		System.out.println("Operação concluída.");
		System.out.println();
		return OPERATION_SUCCESS_CODE;
	}
	
	protected void command() {
		System.out.println("Controlando a aeronave " + cod);
		int option;
		while (commanding) {			
			printOptions();
			try {
				option = Integer.parseInt(scanner.nextLine());
				execute(option);
			} catch (NumberFormatException e) {
				System.out.println("Digite um número inteiro apenas.");
				System.out.println();
			}
		}
	}
	
	private void execute(int option) {
		switch (option) {
		case 1: {
			embarcar();
			break;
		}
		case 2: {
			decolar();
			break;
		}
		case 3: {
			pousar();
			break;
		}
		case 4: {
			desembarcar();
			break;
		}
		case 5: {
			mostrarPosicao();
			break;
		}
		case 6:{
			mostrarContagemTripulacao();
			break;
		}
		case 0: {
			commanding = false;
			break;
		}
		default:
			System.out.println("Opção não disponível.");
			System.out.println();
			break;
		}
	}
	
	
	public void mostrarContagemTripulacao() {
		System.out.println("Pessoas na aeronave: "+tripulacao);
		System.out.println();
	}

	public void mostrarPosicao(){
		System.out.println("A aeronave está "+localizacao);
		System.out.println();
	}
	
	public int getTripulacao() {
		return tripulacao;
	}	
	
}
