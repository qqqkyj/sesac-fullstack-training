package g.javaclass;

import java.util.*;

public class Temp {
    public static void main(String[] args) {
        List<Object> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2.5);
        numberList.add("Z");
        numberList.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));

        List<? super Integer> list = numberList;
        list.add(3);
        System.out.println(list);
    }
}
