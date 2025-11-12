package e.generic.practice;

class Calculator<T>{
    private T first;
    private T second;

    public Calculator(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void printBoth(){
        System.out.println(
                "첫 번째: " + first +
                ", 두 번쨰: " + second);
    }

    public boolean areEqual(){
        return first.equals(second);
    }
}

public class CalculatorTest {
    public static void main(String[] args) {
        // Integer Calculator
        Calculator<Integer> intCalc = new Calculator<>(10, 20);
        intCalc.printBoth();
        System.out.println("같은 값? " + intCalc.areEqual());

        // String Calculator
        Calculator<String> strCalc = new Calculator<>("Hello", "Hello");
        strCalc.printBoth();
        System.out.println("같은 값? " + strCalc.areEqual());

        // Double Calculator
        Calculator<Double> doubleCalc = new Calculator<>(3.14, 2.71);
        System.out.println("첫 번째: " + doubleCalc.getFirst());
        System.out.println("두 번째: " + doubleCalc.getSecond());
        System.out.println("같은 값? " + doubleCalc.areEqual());
    }
}
