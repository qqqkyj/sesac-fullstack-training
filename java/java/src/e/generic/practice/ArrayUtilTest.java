package e.generic.practice;

import java.util.Arrays;

class ArrayUtil{
    public static <T> void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }

    public static <T> T getFirst(T[] array){
        return array.length > 0 ? array[0] : null;
    }

    public static <T> T getLast(T[] array){
        return array.length > 0 ? array[array.length - 1] : null;
    }
}

public class ArrayUtilTest {
    public static void main(String[] args) {
        // Integer 배열 테스트
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.println("=== Integer 배열 ===");
        ArrayUtil.printArray(numbers);
        System.out.println("첫 번째: " + ArrayUtil.getFirst(numbers));
        System.out.println("마지막: " + ArrayUtil.getLast(numbers));

        // String 배열 테스트
        String[] words = {"apple", "banana", "cherry"};

        System.out.println("\n=== String 배열 ===");
        ArrayUtil.printArray(words);
        System.out.println("첫 번째: " + ArrayUtil.getFirst(words));
        System.out.println("마지막: " + ArrayUtil.getLast(words));
    }
}
