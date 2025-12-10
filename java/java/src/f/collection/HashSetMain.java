package f.collection;

import java.util.*;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet();
        set.addAll(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println(set);

        set.add("Apple");// 중복X
        System.out.println(set);
        System.out.println(set.contains("Melon"));

        set.remove("Apple");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
//        set.clear();
//        System.out.println(set);

        for(String s: set){
            System.out.println(s);
        }
        //Iterator
        Iterator<String> iterator = set.iterator();
        if(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //forEach
        set.forEach(s -> System.out.println(s));
        //stream
        set.stream().forEach(s -> System.out.println(s));

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
        set1.addAll(set2);//합집합
        System.out.println(set1);
        set1.retainAll(set2);//교집합
        System.out.println(set1);
        set1.retainAll(set2);//차집합
        System.out.println(set1);
        System.out.println(set1.containsAll(set2));//부분집합
    }
}
