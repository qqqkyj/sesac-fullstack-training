package h.exception;

import java.util.*;
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
    }
}
