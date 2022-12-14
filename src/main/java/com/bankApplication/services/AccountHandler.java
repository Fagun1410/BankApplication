package com.bankApplication.services;

import com.bankApplication.dtos.Account;

public interface AccountHandler {
	public Account createAccount(Account account) throws InvalidAccountNoException;

}
