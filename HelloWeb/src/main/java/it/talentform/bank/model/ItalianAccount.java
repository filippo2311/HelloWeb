package it.talentform.bank.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ItalianAccount extends Account {
   private String favoriteSoccetTeam;

   public ItalianAccount(double balance, String favoriteSoccetTeam){
       super(balance);
       this.favoriteSoccetTeam = favoriteSoccetTeam;
   }
    @Override
    public double deposit(double amount){
        LocalDate today = LocalDate.now();
        DayOfWeek day = today.getDayOfWeek();
        if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY){
            balance += amount;
        } else {
            balance+=0.9*amount;
        }
        return balance;
    }
}
