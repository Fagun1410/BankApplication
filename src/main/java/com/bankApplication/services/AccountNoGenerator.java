package com.bankApplication.services;

import java.util.Random;

public class AccountNoGenerator {
	public long generateAccountNo() {

		Random r = new Random();
		int numbers = 1000000000 + (int) (r.nextDouble() * 999999999);
		return numbers;
	}
}
