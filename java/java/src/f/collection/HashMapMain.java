package f.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        // 요소 추가
        map.put("Apple", 1000);
        map.put("Banana", 2000);
        map.put("Cherry", 3000);
        System.out.println(map);
        // 값 가져오기
        for(String key:map.keySet()){
            System.out.println(key+":"+map.get(key));
        }
        // 키 존재 여부
        System.out.println(map.containsKey("Apple"));
        // 값 존재 여부
        System.out.println(map.containsValue(5000));
        // 값 수정 (같은 키로 put하면 덮어씀)
        map.put("Apple", 1500);
        System.out.println(map.get("Apple"));
        // 요소 삭제
        map.remove("Banana");
        // 크기 확인
        System.out.println(map.size());
        // 비어있는지 확인
        System.out.println(map.isEmpty());
        // 모든 요소 삭제
        map.clear();
        System.out.println(map.isEmpty());

        map.put("Apple", 1000);

        //getOrDefault() - 키가 없으면 기본값 반환
        System.out.println(map.get("Durian"));//null
        System.out.println(map.getOrDefault("Durian", 0));//0

        //containsKey()
        if(map.containsKey("Durian")){
            System.out.println(map.get("Durian"));
        }

        // putIfAbsent() - 키가 없을 때만 추가
        map.putIfAbsent("Durian", 10000);//없으면 추가
        map.putIfAbsent("Apple", 15000);
        System.out.println(map);

        //1.keySet() - 키들의 Set
        for(String key:map.keySet()){
            System.out.println(key+":"+map.get(key));
        }

        //2.values() - 값들의 Colleciton
        for(int v : map.values()){
            System.out.println(v);
        }

        //3. entrySet() - 키-값 쌍들의 Set(가장 효율적)
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }

        //4.forEach() - Java8+
        map.forEach((key, value)->{
            System.out.println(key+":"+value);
        });

        TreeMap<String, Integer> map2 = new TreeMap<>();

        // 요소 추가 (자동 정렬)
        map2.put("Banana", 1500);
        map2.put("Apple", 1000);
        map2.put("Cherry", 2000);
        map2.put("Durian", 2500);

        System.out.println(map2); // 키 기준 오름차순 정렬

        // TreeMap 특화 메서드
        System.out.println("첫 번째 키: " + map2.firstKey());
        System.out.println("마지막 키: " + map2.lastKey());

        System.out.println("첫 번째 엔트리: " + map2.firstEntry());
        System.out.println("마지막 엔트리: " + map2.lastEntry());

        // 특정 키보다 작은 맵
        System.out.println("Cherry 이전: " + map2.headMap("Cherry"));

        // 특정 키보다 큰 맵
        System.out.println("Cherry 이후: " + map2.tailMap("Cherry"));

        // 범위 맵
        System.out.println("Apple~Durian: " + map2.subMap("Apple", "Durian"));
    }
}
