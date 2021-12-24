package problem09.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import problem09.model.entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new FileReader("files//log.txt"))) {
			
			Set<LogEntry> logs = new HashSet<>();
			
			String line;
			while ((line = br.readLine()) != null) {
				
				String[] fields = line.split(" ");
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				logs.add(new LogEntry(userName, moment));
				
			}
			
			System.out.println("Total users: " + logs.size());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}