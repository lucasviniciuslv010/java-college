package problem03.model.services;

public class BrazilTaxService implements TaxService {

	@Override
	public double tax(double amount) {
		if (amount <= 100) {
			return 0.2 * amount;
		}
		return 0.15 * amount;
	}

}