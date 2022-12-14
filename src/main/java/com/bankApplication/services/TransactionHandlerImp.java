package com.bankApplication.services;

import java.util.Scanner;

import com.bankApplication.dtos.Account;

public class TransactionHandlerImp implements TransactionHandler {

	Scanner SC = new Scanner(System.in);

	@Override
	public void transaction(Account account, int choice) throws InsufficientFundException, InvalidAmoutException {
		if (choice == 2)
			withdrawMoney(account);
		else if (choice == 3)
			depositMoney(account);
		else if (choice == 4)
			viewBalance(account);
	}

	private void withdrawMoney(Account account) throws InsufficientFundException {
		System.out.println("Enter amount to withdraw");
		double amt = SC.nextDouble();
		double balance = account.getBalance();
		// balance = 1000;
		if (amt > balance) {
			throw new InsufficientFundException("You don't have enough fund to withdraw " + amt);
		} else if (amt <= 0) {
			throw new InsufficientFundException("Withdral amount must be greater than zero");
		}
		// System.out.println("Balance before withdraw:"+balance);
		balance = balance - amt;
		account.setBalance(balance);
		// System.out.println("Balance after withdraw:"+account.getBalance());
		System.out.println("Your available balance is " + balance + " after withdrawal of " + amt);
	}

	private void depositMoney(Account account) throws InvalidAmoutException {
		System.out.println("Enter amount to deposit");
		double amt = SC.nextDouble();
		double balance = account.getBalance();
		// balance = 1000;
		if (amt <= 0) {
			throw new InvalidAmoutException("Enter valid amount to deposit");
		}
		// System.out.println("Balance before deposit:"+balance);
		balance = balance + amt;
		account.setBalance(balance);
		// System.out.println("Balance after deposit:"+account.getBalance());
		System.out.println("Your available balance is " + balance + " after deposit of " + amt);
	}

	private void viewBalance(Account account) {

	}
}