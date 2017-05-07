package com.ed.engsoft;

import java.util.Scanner;

public class Aviao {

	private static final String EM_VOO = "em vôo";
	private static final String EM_ESPERA = "em espera";
	private boolean tripulada = false;
	private boolean commanding = true;
	private String status;
	private String cod;
	Scanner scanner;

	public Aviao(Scanner scanner, String cod) {
		status = EM_ESPERA;
		this.scanner = scanner;
		this.cod = cod;		
	}

	public void command() {
		System.out.println("Controlando a aeronave " + cod);
		int option;
		while (commanding) {			
			printOptions();
			try {
				option = Integer.parseInt(scanner.nextLine());
				execute(option);
			} catch (NumberFormatException e) {
				System.out.println("Digite um número inteiro apenas.");
			}
		}

	}

	private void execute(int option) {
		switch (option) {
		case 1: {
			if (status.equals(EM_VOO)) {
				System.out.println("Impossível embarcar, aeronave em vôo.");
				break;
			}
			if (tripulada) {
				System.out.println("Aeronave já tripulada.");
				break;
			}
			tripulada = true;

			break;
		}
		case 2: {
			if (status.equals(EM_VOO)) {
				System.out.println("Impossível decolar, aeronave em vôo.");
				break;
			}
			if (!tripulada) {
				System.out.println("Embarque tripulantes antes.");
				break;
			}
			status = EM_VOO;
			break;
		}
		case 3: {
			if (status.equals(EM_ESPERA)) {
				System.out.println("Impossível pousar, aeronave não está em vôo.");
				break;
			}			
			status = EM_ESPERA;
			break;
		}
		case 4: {
			if (status.equals(EM_VOO)) {
				System.out.println("Impossível desembarcar, aeronave em vôo.");
				break;
			}
			if (!tripulada) {
				System.out.println("Não há ninguém na aeronave.");
				break;
			}
			tripulada = false;
			break;
		}
		case 0: {
			commanding = false;
			break;
		}
		default:
			System.out.println("Opção não disponível.");
			break;
		}
	}

	private void printOptions() {		
		System.out.println("Selecione uma opção.");
		System.out.println("1-Embarcar tripulantes aeronave.");
		System.out.println("2-Decolar aeronave.");
		System.out.println("3-Pousar aeronave.");
		System.out.println("4-Desembarcar tripulantes aeronave.");
		System.out.println("0-Voltar.");
	}

	public boolean canRemove() {
		return status.equals(EM_ESPERA);
	}

	public String getStatus() {
		return EM_ESPERA;
	}

}
