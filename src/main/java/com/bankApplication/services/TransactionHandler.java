package com.bankApplication.services;

import java.util.Scanner;

import com.bankApplication.dtos.Account;

public interface TransactionHandler {

	public void transaction(Account account, int choice) throws InsufficientFundException, InvalidAmoutException;

}
