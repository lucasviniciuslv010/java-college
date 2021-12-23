package problem05.model.services;

public class USAInterestService implements InterestService {

	private Double interestRate;

	public USAInterestService(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public Double getInterestRate() {
		return interestRate;
	}
	
}