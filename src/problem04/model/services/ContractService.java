package problem04.model.services;

import java.util.Calendar;
import java.util.Date;

import problem04.model.entities.Contract;
import problem04.model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int numberOfInstallments) {
		double basicQuota = contract.getTotalValue() / numberOfInstallments;
		for (int i = 1; i <= numberOfInstallments; i++) {
			Date date = addMonths(contract.getDate(), i);
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			contract.addInstallment(new Installment(date, fullQuota));
		}
	}
	
	public Date addMonths(Date date, int quantity) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, quantity);
		return cal.getTime();
	}
	
}