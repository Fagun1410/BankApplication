package com.bankApplication.services;

public class InsufficientFundException extends Exception {
	public InsufficientFundException (String str)  
    {  
        super(str);  
    }  
}
