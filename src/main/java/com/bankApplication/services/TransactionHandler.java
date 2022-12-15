package com.bankApplication.services;

import com.bankApplication.dtos.Account;

public interface TransactionHandler {

	public void transaction(Account account, int choice) throws InsufficientFundException, InvalidAmoutException, AccountSuspendedException;

}
