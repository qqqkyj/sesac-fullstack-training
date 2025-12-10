package b.oop.practice;
// 문제 4: BankAccount 클래스
/*
요구사항:
필드: accountNumber (String), balance (int)
생성자: 계좌번호와 초기 잔액을 받는 생성자
메서드:
    deposit(int amount): 입금
    withdraw(int amount): 출금
    getBalance(): 잔액 반환
 */
public class BankAccount {
    private String accountNumber;
    private int balance;

    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int amount){
        this.balance += amount;
        System.out.println("입금: "+ amount + ", 잔액: "+this.balance+"원");
    }

    public void withdraw(int amount){
        if(this.balance >= amount){
            this.balance -= amount;
            System.out.println("출금: "+ amount + ", 잔액: "+this.balance+"원");
        }
        else{
            System.out.println("잔액이 부족합니다.");
        }
    }

    public void getBalance(){
        System.out.println("잔액: "+this.balance);
    }
}
