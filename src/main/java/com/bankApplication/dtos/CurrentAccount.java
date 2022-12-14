package com.bankApplication.dtos;

public class CurrentAccount extends Account{
	public CurrentAccount() {
		super.setAccountType("Current");
		super.setInterestRate(2.5);
		}
}
