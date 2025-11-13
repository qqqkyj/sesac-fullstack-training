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
