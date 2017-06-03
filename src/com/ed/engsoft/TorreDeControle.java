package com.ed.engsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TorreDeControle {
	private static final int OPCAO_INVALIDA = -1;
	Scanner scanner;
	Map<String, Aeronave> aeronaves = new HashMap<>();
	boolean running = true;

	public TorreDeControle(Scanner scanner) {
		this.scanner = scanner;
		System.out.println("Bem vindo a torre de controle.");
	}

	public void run() {
		int option;
		while (running) {
			printOptions();
			try {
				option = Integer.parseInt(scanner.nextLine());
				execute(option);
			} catch (NumberFormatException e) {
				System.out.println("Digite um número inteiro apenas.");
			}
		}
		System.out.println("Saindo.");
	}

	private void execute(int option) {
		switch (option) {
		case 1: {
			adicionarAeronave();
			break;
		}
		case 2: {
			listarAeronaves();
			break;
		}
		case 3: {
			comandarAeronave();
			break;
		}
		case 4: {
			removerAeronave();
			break;
		}
		case 0: {
			running = false;
			break;
		}
		default:
			System.out.println("Opção não disponível.");
			System.out.println();
			break;
		}

	}
	
	private void printOptions() {
		System.out.println("Selecione uma opção.");
		System.out.println("1-Adicionar aeronave");
		System.out.println("2-Listar aeronaves");
		System.out.println("3-Comandar aeronave");
		System.out.println("4-Remover aeronave");
		System.out.println("0-Sair");
	}
	

	private void adicionarAeronave() {
		System.out.println("Digite o código da aeronave e pressione enter.");
		String cod = scanner.nextLine();
		System.out.println();			

		int tipoAeronave = OPCAO_INVALIDA;
		while (tipoAeronave == OPCAO_INVALIDA) {
			System.out.println("Escolha uma das opções:");
			System.out.println("1-Avião comercial");
			System.out.println("2-Helicoptero privado");
			
			try {
				tipoAeronave = Integer.parseInt(scanner.nextLine());					
			} catch (NumberFormatException e) {
				System.out.println("Digite um número inteiro apenas.");
			}
			
			if (tipoAeronave == 1)
				aeronaves.put(cod, new Aviao(scanner, cod));
			else if (tipoAeronave == 2)
				aeronaves.put(cod, new Helicoptero(scanner, cod));
			else{
				tipoAeronave = OPCAO_INVALIDA;
			}
				
		}					

		System.out.println("Aeronave salva.");
		System.out.println();
	}

	private void listarAeronaves() {
		if (!aeronaves.isEmpty())
			for (String key : aeronaves.keySet())
				System.out.println(key+" - "+aeronaves.get(key).getClass().getSimpleName());
		else
			System.out.println("Nenhuma aeronave cadastrada.");
		System.out.println();
	}

	private void comandarAeronave() {
		if (aeronaves.isEmpty()) {
			System.out.println("Registre uma aeronave antes.");
			System.out.println();
			return;
		}
		System.out.println("Digite o código da aeronave.");
		String key = scanner.nextLine();
		if (!aeronaves.containsKey(key))
			System.out.println("Aeronave de código " + key + " não disponível");
		else
			aeronaves.get(key).command();
		System.out.println();		
	}
	
	private void removerAeronave() {
		if (aeronaves.isEmpty()) {
			System.out.println("Registre uma aeronave antes.");
			System.out.println();
			return;
		}
		System.out.println("Digite o código da aeronave a ser removida.");
		String key = scanner.nextLine();
		if (!aeronaves.containsKey(key))
			System.out.println("Aeronave de código " + key + " não disponível");
		else {
			aeronaves.remove(key);
			System.out.println("Aeronave de código " + key + " removida");
		}
		System.out.println();
		
	}
		

}
