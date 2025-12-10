package f.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMain {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        list.addAll(Arrays.asList("a", "b", "c"));
//        list.addFirst("d");
//        list.addLast("e");
//        System.out.println(list);
//
//        list.removeFirst();
//        System.out.println(list);

        int size = 100000;

        // ArrayList: 끝에 추가
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList 끝에 추가: " + (end - start) + "ms");

        // LinkedList: 끝에 추가
        LinkedList<Integer> linkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList 끝에 추가: " + (end - start) + "ms");

        // ArrayList: 중간에 삽입
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(arrayList.size() / 2, i);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList 중간 삽입: " + (end - start) + "ms");

        // LinkedList: 중간에 삽입
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(arrayList.size() / 2, i);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList 중간 삽입: " + (end - start) + "ms");
    }
}
