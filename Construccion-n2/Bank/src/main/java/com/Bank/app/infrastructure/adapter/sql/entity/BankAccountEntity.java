package main.java.com.Bank.app.infrastructure.adapter.sql.entity;

public class BankAccountEntity {
    private String number;
    private double balance;
    private String userId;

    public BankAccountEntity() {
    }

    public BankAccountEntity(String number, double balance, String userId) {
        this.number = number;
        this.balance = balance;
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
