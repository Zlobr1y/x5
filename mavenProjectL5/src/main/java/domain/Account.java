package domain;

public class Account {
    private int id;
    private double balance;

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account() {

    }

    public int getId(String ID) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance(String BALANCE) {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
