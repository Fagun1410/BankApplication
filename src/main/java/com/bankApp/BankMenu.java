package com.bankApp;

import java.util.Scanner;

import com.bankApplication.dtos.Account;
import com.bankApplication.services.AccountHandler;
import com.bankApplication.services.AccountHandlerImp;
import com.bankApplication.services.AccountSuspendedException;
import com.bankApplication.services.InsufficientFundException;
import com.bankApplication.services.InvalidAccountNoException;
import com.bankApplication.services.InvalidAmoutException;
import com.bankApplication.services.TransactionHandler;
import com.bankApplication.services.TransactionHandlerImp;

public class BankMenu {

	public static void main(String[] args) {

		int choice;
		String cont;
		Scanner SC = new Scanner(System.in);

		AccountHandler accHan = new AccountHandlerImp();
		TransactionHandler tHan = new TransactionHandlerImp();
		Account account = new Account();

		do {
			System.out.println("Select Option");
			System.out.println("1. Create Account\n2. Withdraw Amount\n3. Deposit Amount\n4. View Balance");
			choice = SC.nextInt();
			switch (choice) {
			case 1:
				try {
					accHan.createAccount(account);
				} catch (InvalidAccountNoException iane) {
					System.out.println(iane.getMessage());
				}
				break;
			case 2:
			case 3:
			case 4:
				try {
					tHan.transaction(account, choice);
				} catch (InsufficientFundException | InvalidAmoutException | AccountSuspendedException ex) {
					System.out.println(ex.getMessage());
				}
				break;
			}
			System.out.println("Do you want to continue?(Y/N):");
			cont = SC.next();
		} while (cont.equalsIgnoreCase("Y"));

		System.out.println("Successfully Generated Account Details");
		for (Account a : account.getAccounts()) {
			System.out.println(a.getAccountNo() + " " + a.getAccountName() + " " + a.getAccountType());
		}
	}
}