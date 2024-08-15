package com.codetech.main;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int accountNumber;
    private String name;
    private double balance;
    private List<Transaction> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String name, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = initialDeposit;
        addTransaction(new Transaction("Initial deposit", initialDeposit));
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            addTransaction(new Transaction("Withdrawal", -amount));
            return true;
        }
        return false;
    }

    private void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
