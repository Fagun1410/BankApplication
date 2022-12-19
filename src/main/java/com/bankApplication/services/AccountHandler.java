package com.bankApplication.services;

import com.bankApplication.dtos.Account;
import com.bankApplication.exception.InvalidAccountNoException;

public interface AccountHandler {
	public Account createAccount(Account account) throws InvalidAccountNoException;

}
