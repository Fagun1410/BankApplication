package com.bankApplication.services;

import com.bankApplication.dtos.Account;
import com.bankApplication.exception.AccountSuspendedException;
import com.bankApplication.exception.InsufficientFundException;
import com.bankApplication.exception.InvalidAmoutException;

public interface TransactionHandler {

	public void transaction(Account account, int choice) throws InsufficientFundException, InvalidAmoutException, AccountSuspendedException;

}
