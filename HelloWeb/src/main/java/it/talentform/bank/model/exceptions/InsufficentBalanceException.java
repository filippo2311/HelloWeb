package it.talentform.bank.model.exceptions;

public class InsufficentBalanceException extends Exception {
    private double balance;
    private double amount;

    public InsufficentBalanceException (String message, double balance, double amount){
        super(message);
        this.balance = balance;
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }
}
