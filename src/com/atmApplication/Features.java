package com.atmApplication;

import java.util.*;

public class Features {
	static int Balance = 0;
	static List<String> transactionHistory = new ArrayList<>();

	// deposit method
	static void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Deposit Amount : ");
		int amount = sc.nextInt();
		if (amount < 50000 && amount > 0) {
			System.out.println("Amount of " + amount + " rupees got deposited Succesfully .");
			Balance += amount;
			System.out.println("Your Current Balance is " + Balance + " Rupees .");
			System.out.println();
			System.out.println();
			transactionHistory.add("Deposited: " + amount + " Rs | Balance: " + Balance);
		} else {
			System.out.println("Deposit amount should be less than 50,000 Rupees .");
			System.out.println();
		}
	}

	//withdraw method
	public static void withdraw() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the amount to withdraw : ");
		int amo = s.nextInt();
		if (amo > 0 && amo <= Balance) {
			System.out.println("Amount of " + amo + " Rupees Withdrwan Successfully .");
			Balance = Balance - amo;
			System.out.println("Your Current Balance is " + Balance + " Rupees .");
			System.out.println();
			System.out.println();
			transactionHistory.add("Withdrawn: " + amo + " Rs | Balance: " + Balance);
		} else {
			System.out.println("Insufficient Balance .");
			System.out.println();
		}
	}

	//balance checking method
	public static void balanceCheck() {
		System.out.println("Your Current Balance is " + Balance + " Rupees .");
		System.out.println();
		System.out.println();
	}

	//statement printing
	public static void statement() {
		System.out.println("\n==== Mini Statement ====");
		int size = transactionHistory.size();
		if (size == 0) {
			System.out.println("No transactions available.");
		} else {
			int start = Math.max(0, size - 5);
			for (int i = start; i < size; i++) {
				System.out.println(transactionHistory.get(i));
			}
		}
		System.out.println("========================\n");
		System.out.println();
	}

}
