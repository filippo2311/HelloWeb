package it.talentform.bank.model;

public class ThailandAccount extends Account{
    private int nmDays;
    public ThailandAccount(double balance, int nmDays) {
        super(balance);
        this.nmDays = nmDays;
    }

    @Override
    public double deposit(double cifra) {
        if(cifra > 10000){
            System.out.println("Hai vinto un viaggio in Thailandia!!");
        }
        balance += cifra;
        return balance;
    }
}
