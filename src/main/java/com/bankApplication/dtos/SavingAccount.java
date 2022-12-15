package com.bankApplication.dtos;

public class SavingAccount extends Account {

	public SavingAccount(long AccountNo, String AccountName, String AccountType, int pin) {
		super.setAccountType(AccountType);
		super.setAccountNo(AccountNo);
		super.setAccountName(AccountName);
		super.setPin(pin);
	}
}
