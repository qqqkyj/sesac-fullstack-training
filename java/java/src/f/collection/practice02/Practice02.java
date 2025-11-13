package f.collection.practice02;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Practice02 {
    public static void main(String[] args) {
        // 테스트 1
        String[] words1 = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String, Integer> result1 = countWordFrequency(words1);
        System.out.println("테스트 1: " + result1);
        // {apple=3, banana=2, cherry=1}

        // 테스트 2
        String[] words2 = {"hello", "world"};
        Map<String, Integer> result2 = countWordFrequency(words2);
        System.out.println("테스트 2: " + result2);
        // {hello=1, world=1}

        // 테스트 3: 빈 배열
        String[] words3 = {};
        Map<String, Integer> result3 = countWordFrequency(words3);
        System.out.println("테스트 3: " + result3);
        // {}

        // 테스트 4: 모두 같은 단어
        String[] words4 = {"test", "test", "test"};
        Map<String, Integer> result4 = countWordFrequency(words4);
        System.out.println("테스트 4: " + result4);
        // {test=3}
    }

    // 여기에 메서드 구현
    public static Map<String, Integer> countWordFrequency(String[] words) {
        // 구현 필요
        Map<String, Integer> map = new HashMap<>();
        Stream.of(words).forEach(word -> {map.put(word, map.getOrDefault(word, 0) + 1);});
        return map;
    }

    // T
    public static Map<String, Integer> countWordFrequency2(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        // 1.
        //for(String word : words){map.put(word, map.getOrDefault(word, 0) + 1);}

        // 2.
        for(String word : words){
            if(!map.containsKey(word)){map.put(word,1);} //최초
            else{map.put(word,map.get(word)+1);} //이미 존재
        }
        return map;
    }
}
