package problem01.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import problem01.model.entities.Reservation;
import problem01.model.exceptions.DomainException;

/*
Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa não deve aceitar dados
inválidos para a reserva, conforme as seguintes regras:
- As reservas só podem ser feitas para datas futuras
- A data de saída deve ser posterior à data de entrada
*/

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), formatter);
			
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = LocalDate.parse(sc.next(), formatter);
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation updated: " + reservation);
			
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format!");
		} catch (InputMismatchException e) {
			System.out.println("Invalid room number!");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("Unexpected error!");
		}

	}

}