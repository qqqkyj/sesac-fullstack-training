package e.generic;

import java.util.Arrays;

public class GenericMethod{
    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static <T> T[] swap(T[] array, int index1, int index2){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        printArray(intArray);
        swap(intArray, 2, 4);
        printArray(intArray);

        String[] stringArray = {"a", "b", "c", "d"};
        printArray(stringArray);
        swap(stringArray, 2, 3);
        printArray(stringArray);
    }
}
