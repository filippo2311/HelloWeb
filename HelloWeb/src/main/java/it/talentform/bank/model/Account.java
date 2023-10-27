package it.talentform.bank.model;

import it.talentform.bank.model.exceptions.InsufficentBalanceException;

public abstract class Account {
    protected double balance;
    private long id;


    public Account(double s){
        balance = s;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double withdraw(double cifra) throws InsufficentBalanceException { // dichiariamo di avere un eccezione
       if(balance+500 >= cifra){
         balance -= cifra;
         return balance;
       }
      InsufficentBalanceException e = new InsufficentBalanceException("Tentativo di prelievo superiore al saldo", balance, cifra);
       throw e; // lanciamo eccezione
    }
    public abstract double deposit(double cifra);


    public boolean trasferimento(double cifra, Account target){ // "account" sarebbe il collegamento ad altre istanze della classe, cosi che può modifcare
        if (balance >= cifra){
            balance -= cifra;
            target.balance += cifra;
            return true;
        }
        return false;
    }

    public long getId() {
        return id;
    }
}
