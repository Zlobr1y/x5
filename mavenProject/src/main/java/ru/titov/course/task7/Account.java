package ru.titov.course.task7;


import javax.persistence.*;

public class Account {


    private int id;
    private double balance;
    private Holder holder;

    public Account() {
    }

    public Account(int id, double balance, Holder holder) {
        this.id = id;
        this.balance = balance;
        this.holder = holder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Holder getHolder() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }
}
