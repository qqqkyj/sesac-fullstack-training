package h.exception;

import java.util.Comparator;
import java.util.function.*;

public class LamdaMain {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        };

        // 람다 방식
        Comparator<Integer> comparator2 = (a, b) -> Integer.compare(a, b);

        //Runnable - 매개변수가 없는 형태
        Runnable task = () -> System.out.println("실행");
        task.run();

        //Consumer - 매개변수가 1개
        Consumer<String> print = (String s) -> System.out.println(s);
        print.accept("hello");

        //BiFunction - 매개변수가 2개
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(1,2));

        BiFunction<Integer, Integer, Integer> cal = (a, b) -> {
            int sum = a + b;
            System.out.println(sum);
            return sum;
        };
        cal.apply(1,2);
    }
}
