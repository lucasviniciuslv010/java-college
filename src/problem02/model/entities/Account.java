package problem02.model.entities;

import problem02.model.exceptions.BusinessException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawalLimit;
	
	public Account() {}

	public Account(Integer number, String holder, Double balance, Double withdrawalLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawalLimit = withdrawalLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public void setWithdrawalLimit(Double withdrawalLimit) {
		this.withdrawalLimit = withdrawalLimit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdrawal(double amount) {
		validateWithdrawal(amount);
		balance -= amount;
	}
	
	private void validateWithdrawal(double amount) {
		if (amount > getWithdrawalLimit()) {
			throw new BusinessException("The amount exceeds withdrawal limit");
		}
		if (amount > getBalance()) {
			throw new BusinessException("Not enough balance");
		}
	}
	
}