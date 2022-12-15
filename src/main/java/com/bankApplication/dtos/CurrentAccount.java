package com.bankApplication.dtos;

public class CurrentAccount extends Account {

	public CurrentAccount(long AccountNo, String AccountName, String AccountType, int pin) {
		super.setAccountType(AccountType);
		super.setAccountNo(AccountNo);
		super.setAccountName(AccountName);
		super.setPin(pin);
	}

}
