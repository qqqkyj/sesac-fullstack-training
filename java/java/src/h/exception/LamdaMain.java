package h.exception;

import java.util.Comparator;
import java.util.function.*;

// 함수형 인터페이스
// 추상 메서드가 딱 하나만 있는 인터페이스
@FunctionalInterface
interface Calculator{
    int calculate(int a, int b);
//    int calculate2(int a, int b); //컴파일 에러 발생
}

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

        //Calculator - 함수형 인터페이스
        Calculator calAdd = (a, b) -> a + b;
        System.out.println(calAdd.calculate(2,3));
        Calculator calMul = (a, b) -> a * b;
        System.out.println(calMul.calculate(2,3));

        //Supplier - 매개변수 없이 값 반환
        Supplier<String> supplier = () -> "hi";
        System.out.println(supplier.get());

        //Consumer - 매개변수가 1개
        Consumer<String> c = (s) -> System.out.println(s);
        c.accept("hello");

        //Function - 값을 받아서 다른 값 반환
        Function<String, Integer> f = (str) -> str.length();
        System.out.println(f.apply("hello"));

        //Predicate - 값을 받아서 true/false 반환
        Predicate<Integer> predicate = (a) -> a % 2==0;
        System.out.println(predicate.test(1));

        // 메서드 참조(::)
        Function<String, Integer> f1 = (str) -> Integer.parseInt(str);
        Function<String, Integer> f2 = Integer::parseInt;

        String prefix = "sesac_";
        Function<String, String> greeter1 = name -> prefix.concat(name);
        System.out.println(greeter1.apply("gildong"));
        Function<String, String> greeter2 = prefix::concat;
        System.out.println(greeter2.apply("juyoung"));
    }
}
