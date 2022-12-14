package com.bankApplication.services;

import java.util.Random;
import java.util.Scanner;

import com.bankApplication.dtos.Account;
import com.bankApplication.dtos.CurrentAccount;
import com.bankApplication.dtos.SavingAccount;

public class AccountHandlerImp implements AccountHandler {

	@Override
	public Account createAccount(Account account) throws InvalidAccountNoException{
		int choice;
		int pin;
		Scanner SC = new Scanner(System.in);
		System.out.println("Select Account Type");
		System.out.println("1. Saving Account\n2. Current Account");
		choice = SC.nextInt();
		switch (choice) {
		case 1:
			account = new SavingAccount();
			//long saccno = generateAccountNo();
			long saccno = 329125273;
			String ss = String.valueOf(saccno);
			if(ss.startsWith("1")) {
				throw new InvalidAccountNoException("Invalid Account Number");
			}
			account.setAccountNo(saccno);
			System.out.println(account.getAccountNo());
			System.out.println("Set Pin");
			pin = SC.nextInt();
			account.setPin(pin);
			break;
		case 2:
			account = new CurrentAccount();
			long caccno = generateAccountNo();
			System.out.println(caccno);
			String sc = String.valueOf(caccno);
			if(sc.startsWith("1")) {
				throw new InvalidAccountNoException("Invalid Account Number");
			}
			account.setAccountNo(caccno);
			System.out.println(account.getAccountNo());
			System.out.println("Set Pin");
			pin = SC.nextInt();
			account.setPin(pin);
			break;
		}
		return account;
	}

	private long generateAccountNo() {
		Random r = new Random();
	    int numbers = 1000000000 + (int)(r.nextDouble() * 999999999);
		return numbers;
	}
}