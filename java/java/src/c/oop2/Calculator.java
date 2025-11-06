package c.oop2;

import java.util.Arrays;

class Sample{
    int value;
}

public class Calculator {
    int add (int a, int b)  {return a + b;}
    int add (int a, int b, int c)  {return a + b + c;}
    int add (int... numbers){
        if(numbers.length == 0) return numbers[0];
        else{
            int sum = 0;
            for(int number: numbers){
                sum += number;
            }
            return sum;
        }
    }

    // 반환값 X
    void printResult(int result) {
        System.out.println(result);
    }

    // String 반환
    String printValue(int score){
        return score >= 50 ? "pass" : "fail";
    }

    // 배열 반환
    int[] getArray(){
        return new int[]{1, 3, 5, 7, 9};
    }

    // 객체 반환
    Sample getSample(){
        return new Sample();
    }
}
