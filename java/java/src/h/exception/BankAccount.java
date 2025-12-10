package h.exception;

import java.io.IOException;

class InsufficientBalanceException extends RuntimeException{
    private int current;
    private int request;

    public InsufficientBalanceException(int current, int request) {
        super("잔액 부족 / " + current + " / " + request);
        this.current = current;
        this.request = request;
    }
}

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount){
        if(this.balance < amount)
            throw new InsufficientBalanceException(balance, amount);
        this.balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount(10000);
        ba.withdraw(100000);
        System.out.println(ba.getBalance());
    }
}
