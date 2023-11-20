package models.entities;

import models.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit (double amount){
        balance += amount;
    }

    public void withdraw (double amount){
        if (balance == 0 || balance < amount){
            throw new DomainException ("Insufficient balance");
        }
        else if (amount > withdrawLimit) {
            throw new DomainException ("This amount exceeds withdraw limit");
        }
        balance -= amount;
        withdrawLimit -= amount;
    }

    @Override
    public String toString() {
        return "Name: " + holder +
                ", Number: " + number +
                ", Balance: " + String.format("%.2f", balance) +
                ", Withdraw Limit: " + String.format("%.2f", withdrawLimit);
    }
}
