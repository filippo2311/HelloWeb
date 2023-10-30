package it.talentform.bank.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CaymanAccount extends Account {
    private String segretCode;
    private LocalDate openDate;
    public CaymanAccount (double bal, String segretCode){
       super(bal); // parte madre
       //this.segretCode = segretCode; // parte figlia
      //  super();
      //  this.balance = bal;
        this.segretCode = segretCode;
        this.openDate = LocalDate.now();
    }

    public double evadeTax (){
        this.balance *= 1.05;
        return this.balance;
    }

    // Override
    @Override
    public double deposit(double amount){
        LocalDate todayDate = LocalDate.now();
        DayOfWeek today = todayDate.getDayOfWeek();
        if (today == DayOfWeek.SATURDAY || today == DayOfWeek.SUNDAY){
            balance += amount*1.1;
        } else {
            balance += amount;
        }
        return balance;
    }
    public LocalDate getOpenDate(){
        return openDate;
    }
// E' uno scherzo signori della finanza <3
}
