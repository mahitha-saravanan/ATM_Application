package com.atmApplication;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		 // Print welcome message
        System.out.println(" ");
        System.out.println("Welcome to Online Banking !! ");
        System.out.println(" ");
        System.out.println(" ");
        
        Scanner scanner = new Scanner(System.in);
        
        // Account number input
        System.out.println("Enter your 12-digit Account Number : ");
        String accNo = scanner.nextLine();
        System.out.println();
        
        // Validate and process the account
        CustomerAccount customerAccount = new CustomerAccount();
        if (customerAccount.isValidAccount(accNo)) {
            if (customerAccount.isAccountExists(accNo)) {
                String[] details = customerAccount.getAccountDetails(accNo);
                String storedPin = details[0];
                String name = details[1];
                String age = details[2];

                // PIN input and validation
                System.out.println("Enter your PIN : ");
                int PIN = scanner.nextInt();
                System.out.println();
                if (customerAccount.isValidPin(PIN, storedPin)) {
                    System.out.println("Welcome Mr/Mrs." + name + "!");
                    System.out.println();
                    boolean continueOperation = true;

                    // Loop to allow the user to perform multiple operations
                    while (continueOperation) {
                        displayMenu();
                        int op = scanner.nextInt();
                        continueOperation = handleOperations(op);
                    }
                } else {
                    System.out.println("Incorrect PIN.");
                }
            } else {
                System.out.println("Account Not Found!");
            }
        } else {
            System.out.println("Invalid Account Number.");
        }
        
    }

    // Method to display the menu
    private static void displayMenu() {
        System.out.println("1. Deposit.");
        System.out.println("2. Withdraw.");
        System.out.println("3. Balance Enquiry.");
        System.out.println("4. Mini Statement.");
        System.out.println();
        System.out.println("Enter the respective number for operations or press 0 to exit.");
        System.out.println();
    }

    // Method to handle operations
    private static boolean handleOperations(int op) {
        Scanner scanner = new Scanner(System.in);
        switch (op) {
            case 1:
                Features.deposit();
                break;
            case 2:
                Features.withdraw();
                break;
            case 3:
                Features.balanceCheck();
                break;
            case 4:
                Features.statement();
                break;
            case 0:
                System.out.println("Exiting... Thank you for using Online Banking.");
                return false; // Exits the loop if 0 is pressed
            default:
                System.out.println("Invalid operation.");
                break;
        }
        return true; // Continue the loop for another operation
        
	}

}
