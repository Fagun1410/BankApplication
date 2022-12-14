package com.bankApplication.dtos;

public class SavingAccount extends Account {
	public SavingAccount() {
	super.setAccountType("Saving");
	super.setInterestRate(6.4);
	}
}
