package f.collection;

import java.util.*;

public class ArrayListMain {
    public static void main(String[] args) {
        String[] a = new String[3];
        ArrayList<String> l = new ArrayList<>();
        l.add("apple");
        l.add("orange");
        l.add(1, "cherry");
        System.out.println(l);

        String f = l.get(0);
        System.out.println(f);

        l.set(2, "grape");
        System.out.println(l);
        l.remove(1);
        l.remove("grape");
        System.out.println(l.size());
        System.out.println(l.isEmpty());

        ArrayList<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(1, 2, 3, 4, 5, 9, 9));
        System.out.println(intList);
        // 가장 첫번째 9의 index, 없다면 -1
        int index = intList.indexOf(9);
        int lastIndex = intList.lastIndexOf(9);
        System.out.println(index);
        System.out.println(lastIndex);

        List<Integer> subList = intList.subList(2,5);
        System.out.println(subList);

        Integer[] array = intList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));

//        intList.clear();
        System.out.println(intList);

        //===================================
        System.out.println("for-each");
        for(Integer num : intList){
            System.out.println(num);
        }

        System.out.println("index for");
        for(int i=0; i<intList.size(); i++){
            System.out.println(intList.get(i));
        }

        System.out.println("iterator");
        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("forEach");
        intList.forEach(num -> System.out.println(num));

        System.out.println("Stream");
        intList.stream().forEach(num -> System.out.println(num));
    }
}
