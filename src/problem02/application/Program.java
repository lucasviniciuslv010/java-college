package problem02.application;

import java.util.Locale;
import java.util.Scanner;

import problem02.model.entities.Account;
import problem02.model.exceptions.BusinessException;

/*
Fazer um programa para ler os dados de uma conta bancária e depois realizar um
saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
saque da conta.
*/

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter account data:");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdrawal limit: ");
			double withdrawalLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawalLimit);
			
			System.out.println();
			System.out.print("Enter a withdrawal amount: ");
			double amount = sc.nextDouble();
			
			account.withdrawal(amount);
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
			
		} catch (BusinessException e) {
			System.out.println("Withdrawal error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}

	}

}