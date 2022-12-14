package com.bankApplication.dtos;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
	private long AccountNo;
	private String AccountName;
	private String AccountType;
	private double Balance=1000;
	private int Pin;
	private double interestRate;
	
	@Override
	public int hashCode() {
		return Objects.hash(AccountNo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return AccountNo == other.AccountNo;
	}
}
