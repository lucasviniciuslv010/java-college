package problem03.model.services;

import problem03.model.entities.CarRental;
import problem03.model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;

	private TaxService taxService;
	
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long start = carRental.getStart().getTime();
		long finish = carRental.getFinish().getTime();
		double hours = (double) (finish - start) / 1000 / 60 / 60;
		
		double basicPayment = 0.0;
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours);
		} else {
			basicPayment = pricePerDay * Math.ceil(hours/24);
		}
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
	}
	
}