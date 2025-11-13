package f.collection.practice;

import java.util.*;

public class Practice02 {
    public static void main(String[] args) {
        // 테스트 1
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("원본: " + list1);
        int result1 = findAfterRotation(list1, 2, 1);
        System.out.println("2번 회전 후: " + list1);
        System.out.println("1의 인덱스: " + result1);

        // 테스트 2
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        System.out.println("\n원본: " + list2);
        int result2 = findAfterRotation(list2, 1, 40);
        System.out.println("1번 회전 후: " + list2);
        System.out.println("40의 인덱스: " + result2);

        // 테스트 3
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("\n원본: " + list3);
        int result3 = findAfterRotation(list3, 5, 2);
        System.out.println("5번 회전 후 (5%3=2): " + list3);
        System.out.println("2의 인덱스: " + result3);
    }

    public static int findAfterRotation(ArrayList<Integer> list, int k, int target) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[((i - k%list.size() + list.size())%list.size())] = list.get(i);
        }

        for(int i = 0; i < arr.length; i++){
            list.set(i, arr[i]);
        }

        return list.indexOf(target);
    }

    // T
    public static void rotateLeft(ArrayList<Integer> list, int k) {
        if(list == null || list.isEmpty()){
            return;
        }

        int size = list.size();
        k = k % size;

        //k번 반복
        for(int i = 0; i < k; i++){
            int first = list.remove(0);
            list.add(first);
        }
    }

    public static int findAfterRotation2(ArrayList<Integer> list, int k, int target) {
        if(list == null || list.isEmpty()){
            return -1;
        }
        rotateLeft(list, k);
        return list.indexOf(target);
    }
}
