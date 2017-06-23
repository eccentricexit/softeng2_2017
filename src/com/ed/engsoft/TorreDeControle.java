package com.ed.engsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TorreDeControle {
	public Map<String, Aeronave> aeronaves = new HashMap<>();

	private static final int OPCAO_INVALIDA = -1;
	private static final int NENHUMA_AERONAVE_REGISTRADA = -2;
	private static final int AERONAVE_INEXISTENTE = -3;
	private static final int AERONAVE_JA_REGISTRADA = -4;

	private Scanner scanner;
	private boolean running = true;

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
			menuAdicionarAeronave();
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
			menuRemoverAeronave();
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

	private void menuAdicionarAeronave() {
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
			else {
				tipoAeronave = OPCAO_INVALIDA;
			}

		}

		System.out.println("Aeronave salva.");
		System.out.println();
	}

	private void listarAeronaves() {
		if (!aeronaves.isEmpty())
			for (String key : aeronaves.keySet())
				System.out.println(key + " - " + aeronaves.get(key).getClass().getSimpleName());
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

	private void menuRemoverAeronave() {
		System.out.println("Digite o código da aeronave a ser removida.");
		String key = scanner.nextLine();

		switch (removerAeronave(key)) {
			case (NENHUMA_AERONAVE_REGISTRADA): {
				System.out.println("Não há nenhuma aeronave registrada.");				
				break;
			}
			case (AERONAVE_INEXISTENTE):{
				System.out.println("Aeronave de código " + key + " não disponível");				
				break;
			}
			default:{
				System.out.println("Aeronave de código " + key + " removida");				
			}
		}
		
		System.out.println();
	}
	
	public ArrayList<Aviao> listarAvioes(){
		ArrayList<Aviao> avioes = new ArrayList<>();
		for(Aeronave aeronave : aeronaves.values())
			if(aeronave instanceof Aviao)
				avioes.add((Aviao)aeronave);
		
		
		return avioes;
	}
	
	public ArrayList<Helicoptero> listarHelicopteros(){
		ArrayList<Helicoptero> helicopteros = new ArrayList<>();
		for(Aeronave helicoptero : aeronaves.values())
			if(helicoptero instanceof Helicoptero)
				helicopteros.add((Helicoptero)helicoptero);
		
		return helicopteros;
	}
	
	public int adicionarAeronave(String key,Aeronave aeronave){
		if(aeronaves.containsKey(key))
			return AERONAVE_JA_REGISTRADA;
		
		aeronaves.put(key, aeronave);
		return 1;
	}	
	

	public int removerAeronave(String key) {
		if (aeronaves.isEmpty()){
			return NENHUMA_AERONAVE_REGISTRADA;
		}
		
		if (!aeronaves.containsKey(key)){
			return AERONAVE_INEXISTENTE;
		}

		aeronaves.remove(key);
		return 1;
	}

}
