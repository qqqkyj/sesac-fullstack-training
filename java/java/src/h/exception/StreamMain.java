package h.exception;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // 기존 방식
        int sum = 0;
        for(Integer i : list){
            if(i % 2 == 0){
                sum += i*i;
            }
        }
        System.out.println(sum);

        //스트림
        int sum2 = list.stream()
                .filter(i -> i % 2 == 0) //filter - 조건(짝수)에 맞는 요소만 선택
                .map(i -> i*i) //map - 특정연산(제곱)
                .reduce(0, Integer::sum);//누적 합계
        System.out.println(sum2);

        List<String> nameList = Arrays.asList("kim", "lee", "park");
        Stream<String> stream = nameList.stream();
        System.out.println(stream);

        String[] nameArray = {"kim", "lee", "park"};
        Stream<String> stream1 = Arrays.stream(nameArray);

        //1. filter - 조건에 맞는 요소 필더링
        List<Integer> numbers = Arrays.asList(5, 3, 1, 7, 5, 3, 2, 9, 4, 8);
        List<Integer> evens = numbers.stream()
                .filter(i -> i % 2 == 0) // true/false
                .toList();
        System.out.println(evens);

        List<Integer> greaterThan5 = numbers.stream()
                .filter(i -> i > 5) // true/false
                .toList();
        System.out.println(greaterThan5);

        List<Integer> filtered = numbers.stream()
                .filter(i -> i > 5)
                .filter(i -> i % 2 == 0)
                .toList();
        System.out.println(filtered);

        List<String> words = Arrays.asList("Apple", "Banana", "Cherry");
        List<String> longWords = words.stream()
                .filter(s -> s.length() > 5)
                .toList();
        System.out.println(longWords); // [Banana, Cherry]

        // map
        List<Integer> squares = numbers.stream()
                .map(i -> i * i)
                .toList();
        System.out.println(squares);// [25, 9, 1, 49, 25, 9, 4, 81, 16, 64]

        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upper);//[APPLE, BANANA, CHERRY]

        //sorted
        List<Integer> sorted = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sorted);//[1, 2, 3, 3, 4, 5, 5, 7, 8, 9]

        //distinct
        List<Integer> distinct = numbers.stream()
                .distinct()
                .sorted()
                .toList();
        System.out.println(distinct);

        //forEach
        numbers.stream().forEach(System.out::println);
        numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.printf(n + " "));

        //collect
        Map<String, Integer> map = words.stream()
                .collect(Collectors.toMap(s -> s, String::length));
        System.out.println(map);

        //reduce
        int result = numbers.stream()
                .reduce(1, Integer::sum);
        System.out.println(result);

        int result2 = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println(result2);

        //count
        long count = numbers.stream().count();
        System.out.println(count);
    }
}
