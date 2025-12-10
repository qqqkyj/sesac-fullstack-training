## 🧩 **Set (집합)**

> 중복을 허용하지 않고, 순서가 없는 컬렉션.
>
>
> 수학의 집합 개념과 유사하며, **고유한 값들의 모음**을 저장할 때 사용.
>

---

### ✅ **특징**

- **중복 불허**: 동일한 값을 두 번 저장 불가
- **순서 없음**: 저장 순서를 보장하지 않음 (단, 일부 구현체는 예외)
- **`null` 허용**: 구현체에 따라 최대 1개 가능
- **인덱스 접근 불가**: `get()` 메서드 없음

---

### 🧱 **Set 계층 구조**

```java
Set (인터페이스)
├── HashSet (클래스)
│   └── LinkedHashSet (클래스)
└── SortedSet (인터페이스)
    └── TreeSet (클래스)
```

---

### ⚖️ **List vs Set 비교**

| 구분 | List | Set |
| --- | --- | --- |
| **중복** | 허용 | ❌ 불허 |
| **순서** | 있음 | ❌ 없음 (구현체에 따라 다름) |
| **인덱스 접근** | 가능 (`get()`) | 불가능 |
| **null 허용** | 여러 개 가능 | 최대 1개 |
| **사용 예시** | 순서가 중요한 데이터 | 고유한 값 저장 시 |

---

## 🌿 **Set 주요 구현체**

### 1️⃣ **HashSet**

- 내부적으로 **해시 테이블(Hash Table)** 사용
- **가장 빠른 Set 구현체 (O(1))**
- **순서 보장 X**, **null 1개 허용**

```java
import java.util.*;

public class HashSetMain {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println(set);

        set.add("Apple"); // 중복X
        System.out.println(set);

        System.out.println(set.contains("Melon")); // 포함 여부
        set.remove("Apple");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.isEmpty());

        // 반복문
        for (String s : set) System.out.println(s);

        // Iterator
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());

        // forEach (람다)
        set.forEach(s -> System.out.println(s));

        // Stream
        set.stream().forEach(System.out::println);
    }
}
```

---

### 2️⃣ **TreeSet**

- **자동 정렬된 순서**로 요소 저장
- 내부적으로 **Red-Black Tree** 구조 사용
- **정렬 순서 유지**, **null 저장 불가**, 성능: `O(log n)`

```java
import java.util.*;

public class TreeSetBasic {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(Arrays.asList(5, 2, 8, 1, 9));
        System.out.println(set); // [1, 2, 5, 8, 9]

        System.out.println("첫 번째: " + set.first());    // 1
        System.out.println("마지막: " + set.last());      // 9
        System.out.println("5보다 작은 값: " + set.headSet(5));   // [1, 2]
        System.out.println("5보다 큰 값: " + set.tailSet(5));     // [5, 8, 9]
        System.out.println("2~8 사이: " + set.subSet(2, 8));      // [2, 5]

        System.out.println("floor(5): " + set.floor(5));   // 5보다 작거나 같은 최댓값
        System.out.println("higher(5): " + set.higher(5)); // 5보다 큰 최솟값
        System.out.println("lower(5): " + set.lower(5));   // 5보다 작은 최댓값
        System.out.println("ceiling(5): " + set.ceiling(5)); // 5보다 크거나 같은 최솟값
    }
}
```

---

### 3️⃣ **LinkedHashSet**

- **HashSet + LinkedList 구조**
- **삽입 순서 유지**
- 성능은 `HashSet`과 유사 (`O(1)`), 메모리 사용은 다소 많음

---

### 🧮 **Set 구현체 비교**

| 구분 | **HashSet** | **LinkedHashSet** | **TreeSet** |
| --- | --- | --- | --- |
| **순서** | 없음 | 삽입 순서 유지 | 정렬 순서 유지 |
| **중복 허용** | ❌ | ❌ | ❌ |
| **null 허용** | O | O | ❌ |
| **성능** | O(1) | O(1) | O(log n) |
| **메모리 사용량** | 적음 | 중간 | 많음 |
| **사용 시기** | 순서 무관 | 삽입 순서 필요 | 정렬 필요 |

---

## 🔢 **집합 연산 (Set 연산 예시)**

```java
import java.util.*;

public class SetOperationExample {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // 합집합
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("합집합: " + union);

        // 교집합
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("교집합: " + intersection);

        // 차집합
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("차집합: " + difference);

        // 부분집합 확인
        System.out.println("부분집합 여부: " + set1.containsAll(set2));
    }
}
```

---

### 🧠 **요약**

| 개념 | 설명 |
| --- | --- |
| **Set** | 중복 없이 고유한 값 저장 |
| **HashSet** | 순서 없음, 빠른 성능 |
| **LinkedHashSet** | 삽입 순서 유지 |
| **TreeSet** | 자동 정렬, 비교 가능 객체 필요 |
| **주요 활용** | 중복 제거, 고유 값 관리, 집합 연산 등 |

---
## 🗺️ **Map (맵)**

> Key-Value(키-값) 쌍으로 데이터를 저장하는 컬렉션
>
>
> 키는 중복될 수 없고, 값은 중복될 수 있습니다.
>

---

### ✅ **특징**

- **키-값 쌍**으로 데이터 저장
- **키 중복 불가**, **값 중복 가능**
- **순서 없음** (단, 구현체에 따라 다름)
- **null 허용 여부**는 구현체마다 다름
- `Collection` 인터페이스를 **상속하지 않음**

---

### 🧱 **Map 계층 구조**

```java
Map (인터페이스)
├── HashMap (클래스)
│   └── LinkedHashMap (클래스)
├── TreeMap (클래스)
└── Hashtable (클래스)
    └── Properties (클래스)
```

---

### ⚖️ **Map vs List vs Set**

| 구분 | List | Set | **Map** |
| --- | --- | --- | --- |
| **저장 단위** | 단일 값 | 단일 값 | **키-값 쌍** |
| **중복 허용** | O | ❌ | **키만 중복 불가** |
| **순서** | 있음 | 없음 | 구현체에 따라 다름 |
| **접근 방식** | 인덱스로 접근 | 요소 탐색 | **키로 접근** |

---

## 🌿 **Map 주요 구현체**

### 1️⃣ **HashMap**

- 가장 많이 쓰이는 `Map` 구현체
- 내부적으로 **Hash Table** 사용
- **순서 없음**, **키 1개 null 허용**, **빠른 성능 (O(1))**

```java
import java.util.HashMap;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // 요소 추가
        map.put("Apple", 1000);
        map.put("Banana", 2000);
        map.put("Cherry", 3000);
        System.out.println(map);

        // 값 조회
        for (String key : map.keySet())
            System.out.println(key + " : " + map.get(key));

        // 키/값 존재 여부
        System.out.println(map.containsKey("Apple"));   // true
        System.out.println(map.containsValue(5000));    // false

        // 값 수정 (같은 키로 put 시 덮어씀)
        map.put("Apple", 1500);
        System.out.println(map.get("Apple")); // 1500

        // 삭제
        map.remove("Banana");

        // 크기/비어있는지 확인
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        // 모든 요소 삭제
        map.clear();
        System.out.println(map.isEmpty());

        // getOrDefault() : 키 없을 때 기본값 반환
        System.out.println(map.get("Durian")); // null
        System.out.println(map.getOrDefault("Durian", 0)); // 0

        // putIfAbsent() : 키가 없을 때만 추가
        map.putIfAbsent("Durian", 10000);
        map.putIfAbsent("Apple", 15000);
        System.out.println(map);
    }
}
```

---

### 🔁 **HashMap 순회 방법**

```java
// 1. keySet() : 키 집합
for (String key : map.keySet())
    System.out.println(key + " : " + map.get(key));

// 2. values() : 값 집합
for (int value : map.values())
    System.out.println(value);

// 3. entrySet() : 키-값 쌍 집합 (가장 효율적)
for (Map.Entry<String, Integer> entry : map.entrySet())
    System.out.println(entry.getKey() + " = " + entry.getValue());

// 4. forEach() : Java 8+
map.forEach((key, value) -> System.out.println(key + " : " + value));
```

---

### 2️⃣ **LinkedHashMap**

- **HashMap + LinkedList 구조**
- **삽입 순서 유지**
- 성능은 `HashMap`과 유사 (`O(1)`)

```java
Map<String, Integer> map = new LinkedHashMap<>();
map.put("Apple", 1000);
map.put("Banana", 2000);
map.put("Cherry", 3000);
System.out.println(map); // {Apple=1000, Banana=2000, Cherry=3000}
```

---

### 3️⃣ **TreeMap**

- **자동 정렬된 순서(키 기준)** 로 저장
- 내부적으로 **Red-Black Tree** 구조 사용
- **정렬된 탐색, 범위 검색 가능**
- **null 키 불가**, **성능 O(log n)**

```java
import java.util.TreeMap;

public class TreeMapMain {
    public static void main(String[] args) {
        TreeMap<String, Integer> map2 = new TreeMap<>();

        // 요소 추가 (자동 정렬)
        map2.put("Banana", 1500);
        map2.put("Apple", 1000);
        map2.put("Cherry", 2000);
        map2.put("Durian", 2500);

        System.out.println(map2); // 키 기준 오름차순

        // TreeMap 특화 메서드
        System.out.println("첫 번째 키: " + map2.firstKey());
        System.out.println("마지막 키: " + map2.lastKey());
        System.out.println("첫 번째 엔트리: " + map2.firstEntry());
        System.out.println("마지막 엔트리: " + map2.lastEntry());

        // 부분 맵 조회
        System.out.println("Cherry 이전: " + map2.headMap("Cherry"));
        System.out.println("Cherry 이후: " + map2.tailMap("Cherry"));
        System.out.println("Apple~Durian: " + map2.subMap("Apple", "Durian"));
    }
}
```

---

## 📊 **Map 구현체 비교**

| 구분 | **HashMap** | **LinkedHashMap** | **TreeMap** |
| --- | --- | --- | --- |
| **저장 순서** | 없음 | 삽입 순서 | **정렬 순서(키 기준)** |
| **null 키 허용** | ✅ (1개) | ✅ (1개) | ❌ |
| **null 값 허용** | ✅ | ✅ | ✅ |
| **성능** | ⚡ O(1) | ⚡ O(1) | 🕓 O(log n) |
| **메모리 사용량** | 적음 | 중간 | 많음 |
| **정렬 지원** | ❌ | ❌ | ✅ |
| **사용 시기** | 일반적 | 순서 필요 | 정렬 필요 |

---

## 🧠 **요약 정리**

| 항목 | 내용 |
| --- | --- |
| **Map 역할** | 키로 값에 접근하는 자료구조 |
| **주요 구현체** | `HashMap`, `LinkedHashMap`, `TreeMap` |
| **중복 허용 여부** | 키 ❌ / 값 ✅ |
| **핵심 메서드** | `put()`, `get()`, `remove()`, `containsKey()`, `putIfAbsent()`, `getOrDefault()` |
| **순회 방법** | `keySet()`, `values()`, `entrySet()`, `forEach()` |
---