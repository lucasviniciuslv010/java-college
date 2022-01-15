package problem10.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
que ele obteve em uma urna de votação separados por vírgula.
Você deve fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada candidato.
*/

public class Program {

	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("files//votes.txt"))) {
		
			Map<String, Integer> votes = new LinkedHashMap<String, Integer>();
			
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name);
					votes.put(name, votesSoFar + count);
				} else {
					votes.put(name, count);
				}
				
			}
			
			for (String key : votes.keySet()) {
				System.out.println(key + ": " + votes.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}