package com.bankApplication.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.bankApplication.dtos.Account;
import com.bankApplication.dtos.CurrentAccount;
import com.bankApplication.dtos.SavingAccount;
import com.bankApplication.exception.InvalidAccountNoException;

public class AccountHandlerImp implements AccountHandler {
	
	AccountNoGenerator accountnogenerator = new AccountNoGenerator();
	@Override
	public Account createAccount(Account account) throws InvalidAccountNoException{
		int choice;
		int pin;
		String accname;
		long accno;
		ArrayList<Account> acc=new ArrayList<Account>();
		Scanner SC = new Scanner(System.in);
		System.out.println("Select Account Type");
		System.out.println("1. Saving Account\n2. Current Account");
		choice = SC.nextInt();
		switch (choice) {
		case 1:
			accno = accountnogenerator.generateAccountNo();
			account.setAccountNo(accno);
			String ss = String.valueOf(accno);
			if(ss.startsWith("0")) {
				throw new InvalidAccountNoException("Invalid Account Number");
			}
			System.out.println("Generated Account Number: "+account.getAccountNo());
			System.out.println("Enter Account Holder Name");
			accname = SC.next();
			System.out.println("Set Pin");
			pin = SC.nextInt();
			if(!String.valueOf(pin).matches("\\d{4}")) {
				System.out.println("PIN must contains 4 digits");
				break;
			}
			acc = account.getAccounts();
			acc.add(new SavingAccount(accno,accname,"Saving",pin));
			account.setAccounts(acc);
			break;
		case 2:
			accno = accountnogenerator.generateAccountNo();
			account.setAccountNo(accno);
			String sc = String.valueOf(accno);
			if(sc.startsWith("0")) {
				throw new InvalidAccountNoException("Invalid Account Number");
			}
			System.out.println("Generated Account Number: "+account.getAccountNo());
			System.out.println("Enter Account Holder Name");
			accname = SC.next();
			System.out.println("Set Pin");
			pin = SC.nextInt();
			if(!String.valueOf(pin).matches("\\d{4}")) {
				System.out.println("PIN must contains 4 digits");
				break;
			}
			acc = account.getAccounts();
			acc.add(new CurrentAccount(accno,accname,"Current",pin));
			account.setAccounts(acc);
			break;
		}
		return account;
	}
}