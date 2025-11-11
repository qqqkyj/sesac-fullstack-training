package d.inheritance.practice04;

interface Payment{
    void processPayment(int amount);
    String getPaymentMethod();
    default void printReceipt(int amount){
        System.out.printf("영수증: [%d]원 - [%s]%n", amount, getPaymentMethod());
    }
}

class CreditCardPayment implements Payment{
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(int amount) {
        System.out.printf("신용카드([%s])로 [%d]원 결제 완료%n", cardNumber, amount);
    }

    @Override
    public String getPaymentMethod() {
        return "신용카드";
    }
}

class CashPayment implements Payment{
    @Override
    public void processPayment(int amount) {
        System.out.printf("현금 [%d]원 결제 완료%n", amount);
    }

    @Override
    public String getPaymentMethod() {
        return "현금";
    }
}

public class PaymentMain {
    public static void main(String[] args) {
        Payment[] payments = {
                new CreditCardPayment("1234-5678"),
                new CashPayment()
        };

        int amount = 50000;
        for (Payment payment : payments) {
            payment.processPayment(amount);
            payment.printReceipt(amount);
            System.out.println();
        }
    }
}
