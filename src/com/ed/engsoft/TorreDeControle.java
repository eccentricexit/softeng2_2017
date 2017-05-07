package com.ed.engsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TorreDeControle {
	Scanner scanner;
	Map<String, Aviao> avioes = new HashMap<>();
	boolean sair = false;

	public TorreDeControle(Scanner scanner) {
		this.scanner = scanner;
		System.out.println("Bem vindo a torre de controle.");
	}

	public void run() {
		int option;
		while (!sair) {
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
		case 1:{
			System.out.println("Digite o código da aeronave e pressione enter.");
			String cod = scanner.nextLine();
			avioes.put(cod, new Aviao(scanner,cod));
			
			System.out.println("Aeronave salva.");
			System.out.println();
			break;
		}
		case 2:{
			if(!avioes.isEmpty())
			for(String key: avioes.keySet())
				System.out.println(key);
			else
				System.out.println("Nenhuma aeronave cadastrada.");
			System.out.println();
			break;
		}
		case 3:{
			if(avioes.isEmpty()){
				System.out.println("Registre uma aeronave antes.");
				System.out.println();
				break;
			}
			System.out.println("Digite o código da aeronave.");
			String key = scanner.nextLine();
			if(!avioes.containsKey(key))
				System.out.println("Aeronave de código "+key+" não disponível");
			else
				avioes.get(key).command();
			System.out.println();
			break;
		}
		case 4:{
			if(avioes.isEmpty()){
				System.out.println("Registre uma aeronave antes.");
				System.out.println();
				break;
			}
			System.out.println("Digite o código da aeronave a ser removida.");
			String key = scanner.nextLine();
			if(!avioes.containsKey(key))
				System.out.println("Aeronave de código "+key+" não disponível");
			else{
				Aviao aviao = avioes.get(key);
				if(aviao.canRemove()){
					avioes.remove(key);
					System.out.println("Aeronave de código "+key);
				}else
					System.out.println("Aeronave não removida, pois a aeronave está "+aviao.getStatus());
							
			}
			System.out.println();
			break;
		}
		case 0:{
			sair = true;
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

}
