package com.atmApplication;

import java.util.HashMap;
import java.util.Map;

public class CustomerAccount {

	private static Map<String, String> customers = new HashMap<>();

	// Static block to populate customer data
	static {
		customers.put("123456789012", "1234,Mahitha,25");
		customers.put("234567890123", "2345,Saadhu,30");
		customers.put("345678901234", "3456,Pugazh,17");
		customers.put("456789012345", "4567,Ruthra,28");
		customers.put("567890123456", "5678,Sudha,16");
	}

	// Validate account number (must be 12 digits)
	public boolean isValidAccount(String accNo) {
		return accNo.length() == 12;
	}

	// Check if account exists in the map
	public boolean isAccountExists(String accNo) {
		return customers.containsKey(accNo);
	}

	// Get account details (pin, name, and age)
	public String[] getAccountDetails(String accNo) {
		String details = customers.get(accNo);
		return details.split(",");
	}

	// Validate PIN (4 digits)
	public boolean isValidPin(int enteredPin, String storedPin) {
		return String.valueOf(enteredPin).length() == 4 && Integer.parseInt(storedPin) == enteredPin;
	}
}
