package e.generic;

import java.util.*;

public class WildCardGeneric {
    // 코드 내부에서 T를 재사용한다면 아래 방식대로 사용할 것
    public static <T> void printList2(List<T> list){
        for(T t:list){
            System.out.println(t.toString());
        }
    }
    // 코드 내부에서 T를 재사용할 필요 없는 경우 와일드 카드 사용
    public static void printList(List<?> list){
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String[] args) {
        //int[] intList = {1, 2, 3};
        //배열 : 크기 고정
        //리스트: 크기 동적
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<String> stringList = Arrays.asList("A", "B", "C");
        printList(intList);
        printList(doubleList);
        printList(stringList);

        List<Number> numberList = Arrays.asList(1, 2, 3, 5.0, 4.3);
        // list는 Number 또는 그 이하만 가능
        // numberList는 Integer로 Number 이하로 읽기 가능
        // but list에 쓰기를 하려면 어떤 타입인지 알 수 없어서 오류 발생
        List<? extends Number> list = numberList;
        //list.add(4);// 쓰기 불가능(컴파일 오류)
        list.get(0);// 읽기 가능
        printList(list);//[1, 2, 3, 5.0, 4.3]

        List<Number> numberList2 = new ArrayList<>();
        // list2는 최소 Integer 이상이여야 됨
        // numberList2는 Number로 Integer 이상이라 쓰기 가능
        // but 읽을 때 어떤 타입인지 알 수 없어서 오류 발생
        List<? super Integer> list2 = numberList2;//최소 Integer 이상
        list2.add(1);//쓰기 가능
        list2.add(2);
//        list2.add(4.2);
        //list2.get(1);//읽기 불가능(컴파일 오류)
    }
}
