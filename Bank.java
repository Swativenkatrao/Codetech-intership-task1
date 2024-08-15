package com.codetech.main;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int accountNumberCounter = 1;

    public void createAccount(String name, double initialDeposit) {
        Account newAccount = new Account(accountNumberCounter++, name, initialDeposit);
        accounts.put(newAccount.getAccountNumber(), newAccount);
        System.out.println("Account created successfully. Account Number: " + newAccount.getAccountNumber());
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited " + amount + " to account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrew " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println("Transferred " + amount + " from account " + fromAccountNumber + " to account " + toAccountNumber);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void viewTransactionHistory(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.printTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updatePersonalInfo(int accountNumber, String newName) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setName(newName);
            System.out.println("Updated personal information for account " + accountNumber);
        } else {
            System.out.println("Account not found.");
        }
    }
}

