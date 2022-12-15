package com.bankApplication.services;

import java.util.Scanner;

import com.bankApplication.dtos.Account;

public class TransactionHandlerImp implements TransactionHandler {

	Scanner SC = new Scanner(System.in);
	int cnt = 0;

	@Override
	public void transaction(Account account, int choice)
			throws InsufficientFundException, InvalidAmoutException, AccountSuspendedException {
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
		if (amt > balance) {
			throw new InsufficientFundException("You don't have enough fund to withdraw " + amt);
		} else if (amt <= 0) {
			throw new InsufficientFundException("Withdral amount must be greater than zero");
		}
		balance = balance - amt;
		account.setBalance(balance);
		System.out.println("Your available balance is " + balance + " after withdrawal of " + amt);
	}

	private void depositMoney(Account account) throws InvalidAmoutException {
		System.out.println("Enter amount to deposit");
		double amt = SC.nextDouble();
		double balance = account.getBalance();
		if (amt <= 0) {
			throw new InvalidAmoutException("Enter valid amount to deposit");
		}
		balance = balance + amt;
		account.setBalance(balance);
		System.out.println("Your available balance is " + balance + " after deposit of " + amt);
	}

	private void viewBalance(Account account) throws AccountSuspendedException {

		System.out.println("Enter Account Number to view balance:");
		long accno = SC.nextLong();
		System.out.println("Enter PIN:");
		int pin = SC.nextInt();

		if (cnt > 3) {
			throw new AccountSuspendedException("Account Suspened for next 24 hours due to maximum attempt");
		}

		for (Account a : account.getAccounts()) {
			if (a.getAccountNo() == accno && a.getPin() == pin)
				System.out.println("Hello " + a.getAccountName());
			else if (a.getAccountNo() == accno && a.getPin() != pin)
				System.out.println("Enter Valid PIN");
			cnt++;
		}
	}
}