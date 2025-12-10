package f.collection.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice01 {
    public static void main(String[] args) {
        // 테스트 1
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 7));
        System.out.println("입력: " + list1);
        System.out.println("출력: " + findSecondLargest(list1));

        // 테스트 2
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(10, 10, 10));
        System.out.println("\n입력: " + list2);
        System.out.println("출력: " + findSecondLargest(list2));

        // 테스트 3
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(5, 5, 3, 3, 1));
        System.out.println("\n입력: " + list3);
        System.out.println("출력: " + findSecondLargest(list3));

        // 테스트 4
        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(5));
        System.out.println("\n입력: " + list4);
        System.out.println("출력: " + findSecondLargest(list4));
    }

    public static int findSecondLargest(ArrayList<Integer> list) {
        int first = -1;
        int second = -1;
        if(!list.isEmpty()){
            for(int num : list){
                if(num > first){
                    second = first;
                    first = num;
                }
                else if(num > second && num < first){
                    second = num;
                    System.out.println("first: " + first + " second: " + second + " num: " + num);
                }
            }
        }
        return second;
    }
}
