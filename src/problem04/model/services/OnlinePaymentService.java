package problem04.model.services;

public interface OnlinePaymentService {

	double paymentFee(double amount);
	double interest(double amount, int month);
	
}