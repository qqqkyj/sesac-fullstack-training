package d.inheritance.practice;

class Account{
    String accountNumber;
    int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(int amount){
        balance += amount;
        System.out.println(amount + "원 입금되었습니다.");
    }

    void withdraw(int amount){
        if(balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원 출금되었습니다.");
        }
    }
}

class SavingsAccount extends Account{
    double interestRate;

    public SavingsAccount(String accountNumber, int balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void addInterest(){
        balance *= (1 + interestRate);
    }
}

class CheckingAccount extends Account{
    double overdraftLimit;

    public CheckingAccount(String accountNumber, int balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(int amount) {
        if(balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(amount + "원 출금되었습니다.");
        }
        else System.out.println("출금 한도를 초과했습니다. \n현재 인출 가능한 금액은 " + (int)(balance + overdraftLimit) + "원 입니다.");
    }
}

public class AccountMain {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA001", 1000000, 0.03);
        savings.deposit(500000);
        savings.addInterest();
        System.out.println("저축예금 잔액: " + savings.balance);

        CheckingAccount checking = new CheckingAccount("CA001", 100000, 500000);
        checking.withdraw(400000);
        System.out.println("입출금예금 잔액: " + checking.balance);
    }
}
