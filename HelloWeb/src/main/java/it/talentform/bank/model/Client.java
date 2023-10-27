package it.talentform.bank.model;

import java.time.LocalDate;

public class Client {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private Sex sex;
    private Account[] accounts;
    private int nmAccounts;
    private double maxTotalDeficit;
    private double deficit;
    public final static int MAX_ACCOUNTS = 5;
    public Client(String firstname, String lastname, LocalDate dateOfBirth, Sex sex, double maxTotalDeficit, double deficit){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.accounts = new Account[MAX_ACCOUNTS]; // per dare il massimo di 5
        this.maxTotalDeficit = maxTotalDeficit;
        this.deficit = deficit;
    }

    public boolean adAccount(Account a){ // questo metodo possiamo utilizzarlo anche per i caymanAccount, perché è
        if (nmAccounts == MAX_ACCOUNTS){ // equivalente, quindi in un array di account ci sta anche CaymanAccount
            return false;                // perché CaymanAccount estende Account quindi dello "stesso" tipo
        } else {
            a.deposit(10); // richiamo del metodo deposit della classe account
            accounts[nmAccounts] = a;
            nmAccounts++;
            return true;
        }
    }
    public boolean balanceMax(double balance){
        if (nmAccounts == 0){
            return false;
        }
        for (int i = 0; i<nmAccounts; i++){
            if(accounts[i].getBalance() < balance){
                return false;
            }
        }
        return true;
    }

    public boolean checkDeficit(){
        double negativeBalance = 0;
        for(int i = 0; i<nmAccounts;i++) {
            if (accounts[i].getBalance() < -deficit) { // 1000 < -100?; -150 < -100? più si allontana dallo 0 è minore
                return false;
            }
            if (accounts[i].getBalance() < 0) {
                negativeBalance = negativeBalance - accounts[i].getBalance();
                if (negativeBalance > maxTotalDeficit) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
    //  return firstname +" "+lastname;
        return String.format("Nome: %s, Cognome: %s, Data di nascita: %s, Sesso: %s, Deficit massimo complessivo: %s, " +
                "Deficit massimo per conto: %s",firstname,lastname, dateOfBirth, sex, maxTotalDeficit, deficit);
    }

    public boolean containsInName(String part){
        String target = part.toLowerCase();
        return firstname.toLowerCase().contains(target) || lastname.toLowerCase().contains(target);
    }
    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public Double getDeficit() {
        return deficit;
    }

    public Double getMaxTotalDeficit(){
        return maxTotalDeficit;
    }
}
