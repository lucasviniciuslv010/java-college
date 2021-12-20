package problem04.model.services;

public class PaypalService implements OnlinePaymentService {

	private static final double FEE_PERCENTAGE = 0.02;
	private static final double MONTHLY_INTEREST = 0.01;
	
	@Override
	public double paymentFee(double amount) {
		return FEE_PERCENTAGE * amount;
	}

	@Override
	public double interest(double amount, int month) {
		return MONTHLY_INTEREST * month * amount;
	}

}
