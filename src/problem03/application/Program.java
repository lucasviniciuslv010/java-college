package problem03.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import problem03.model.exceptions.DomainException;
import problem03.model.entities.CarRental;
import problem03.model.entities.Vehicle;
import problem03.model.services.BrazilTaxService;
import problem03.model.services.RentalService;

/*
Uma locadora brasileira de carros cobra um valor por hora para locações de até
12 horas. Porém, se a duração da locação ultrapassar 12 horas, a locação será
cobrada com base em um valor diário. Além do valor da locação, é acrescido no
preço o valor do imposto conforme regras do país que, no caso do Brasil, é 20%
para valores até 100.00, ou 15% para valores acima de 100.00. Fazer um
programa que lê os dados da locação (modelo do carro, instante inicial e final da
locação), bem como o valor por hora e o valor diário de locação. O programa
deve então gerar a nota de pagamento (contendo valor da locação, valor do
imposto e valor total do pagamento) e informar os dados na tela.
*/

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		try {
			
			System.out.println("Enter rental data:");
			System.out.print("Car model: ");
			String carModel = sc.nextLine();
			System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
			Date start = sdf.parse(sc.nextLine());
			System.out.print("Return (dd/MM/yyyy HH:mm): ");
			Date finish = sdf.parse(sc.nextLine());
			
			CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
			
			System.out.println();
			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: ");
			double pricePerDay = sc.nextDouble();
			
			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
			rentalService.processInvoice(carRental);
			
			System.out.println();
			System.out.println("INVOICE:");
			System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
			System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
			System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
			
		} catch(ParseException e) { 
			System.out.println("Invalid date format!");
		} catch(DomainException e) {
			System.out.println("Rental error: " + e.getMessage());
		} catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		} finally {
			sc.close();
		}
		
	}

}