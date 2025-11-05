package b.oop.practice;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("홍길동", 25);
        person.printInfo();
        System.out.println();

        Dog dog = new Dog("백구", "진돗개");
        dog.sit();
        dog.hand();
        System.out.println();

        Car car = new Car("Avante",0);
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.brake();
        car.printInfo();
        car.brake();
        System.out.println();

        BankAccount ba = new BankAccount("12345-123", 10000);
        ba.getBalance();
        ba.deposit(10000);
        ba.withdraw(3000);
        System.out.println();

        Counter cnt = new Counter();
        cnt.increment();
        cnt.decrement();
        cnt.decrement();
        cnt.reset();
        cnt.getCount();
    }
}
