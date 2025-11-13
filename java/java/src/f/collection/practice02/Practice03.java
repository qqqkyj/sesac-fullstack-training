package f.collection.practice02;

import java.util.*;
import java.util.stream.Stream;

public class Practice03 {
    public static void main(String[] args) {
        // 테스트 1
        String str1 = "hello";
        Map<Character, List<Integer>> result1 = findCharacterPositions(str1);
        System.out.println("테스트 1: " + result1);
        // {h=[0], e=[1], l=[2, 3], o=[4]}

        // 테스트 2
        String str2 = "programming";
        Map<Character, List<Integer>> result2 = findCharacterPositions(str2);
        System.out.println("테스트 2: " + result2);

        // 테스트 3: 모두 같은 문자
        String str3 = "aaa";
        Map<Character, List<Integer>> result3 = findCharacterPositions(str3);
        System.out.println("테스트 3: " + result3);
        // {a=[0, 1, 2]}

        // 테스트 4: 빈 문자열
        String str4 = "";
        Map<Character, List<Integer>> result4 = findCharacterPositions(str4);
        System.out.println("테스트 4: " + result4);
        // {}
    }

    // 여기에 메서드 구현
    public static Map<Character, List<Integer>> findCharacterPositions(String str) {
        // 구현 필요
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<str.length();i++){
            char c =  str.charAt(i);
            map.putIfAbsent(c, new ArrayList<>()); // key가 없으면 추가
            map.get(c).add(i);//key값 있으면 value에 i 추가
        }
        return map;
    }

    // T
    public static Map<Character, List<Integer>> findCharacterPositions2(String str) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<str.length();i++){
            if(!map.containsKey(str.charAt(i))) map.put(str.charAt(i), new ArrayList<>());
            map.get(str.charAt(i)).add(i);
        }
        return map;
    }
}
