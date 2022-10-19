package teste2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Teste2 {
	public static void main(String[] args) {
		int opcao = 0;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.println("Informe o que deseja fazer:\n [1] Criar arquivo\n [2] Ler arquivo\n [3] Sair");
			opcao = teclado.nextInt();
			
			switch(opcao) {
			
			case 1: salvaArquivo();
			break;
			
			case 2: lerArquivo();
			break;
			
			case 3: System.out.println("Obrigado por usar o programa.");
			break;
			
			default: System.out.println("Opção inválida, tente novamente.");
			break;
				
			}
		}while(opcao != 3);
		
	}

	public static void salvaArquivo() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe o conteúdo do arquivo: ");
		String conteudoArquivo = teclado.nextLine();
		
		System.out.println("Informe o nome do arquivo: ");
		String nomeArquivo = teclado.nextLine();
		
		String caminhoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\teste\\" + nomeArquivo + ".txt";
		
		try {
			FileWriter objEscritor = new FileWriter(caminhoArquivo, false);
			objEscritor.write(conteudoArquivo.toString());
			objEscritor.close();
			
			System.out.println("Arquivo salvo com sucesso em: "+caminhoArquivo);
		}
		catch(IOException e) {
			System.out.println("e.getMessage()");
		}
	}
	
	public static void lerArquivo(){
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Informe o arquivo que deseja ler: ");
		String nomeArquivo = teclado.next();
		
		String caminhoArquivo = "C:\\Users\\" + System.getProperty("user.name").toString() + "\\Desktop\\teste\\" + nomeArquivo + ".txt";
		
		try {
			FileReader arquivoLer = new FileReader(caminhoArquivo);
			BufferedReader leitorArquivo = new BufferedReader(arquivoLer);
			
			String linha = leitorArquivo.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = leitorArquivo.readLine();
			}
			System.out.println("\n");
			leitorArquivo.close();		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
