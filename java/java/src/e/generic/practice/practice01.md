## 문제 1: 제네릭 Calculator 클래스

두 개의 같은 타입 값을 받아 계산하는 제네릭 Calculator 클래스를 작성하세요.

**요구사항:**

- `Calculator<T>` 클래스 작성
- 생성자로 두 개의 값을 받아 저장
- `getFirst()`: 첫 번째 값 반환
- `getSecond()`: 두 번째 값 반환
- `printBoth()`: 두 값을 "첫 번째: X, 두 번째: Y" 형식으로 출력
- `areEqual()`: 두 값이 같은지 비교 (equals 사용)

**테스트 코드:**

```java
public class CalculatorTest {
    public static void main(String[] args) {
        // Integer Calculator
        Calculator<Integer> intCalc = new Calculator<>(10, 20);
        intCalc.printBoth();
        System.out.println("같은 값? " + intCalc.areEqual());

        // String Calculator
        Calculator<String> strCalc = new Calculator<>("Hello", "Hello");
        strCalc.printBoth();
        System.out.println("같은 값? " + strCalc.areEqual());

        // Double Calculator
        Calculator<Double> doubleCalc = new Calculator<>(3.14, 2.71);
        System.out.println("첫 번째: " + doubleCalc.getFirst());
        System.out.println("두 번째: " + doubleCalc.getSecond());
        System.out.println("같은 값? " + doubleCalc.areEqual());
    }
}
```

**예상 출력:**

```
첫 번째: 10, 두 번째: 20
같은 값? false
첫 번째: Hello, 두 번째: Hello
같은 값? true
첫 번째: 3.14
두 번째: 2.71
같은 값? false
```

---

## 문제 2: 제네릭 Pair 클래스

두 개의 서로 다른 타입 값을 저장할 수 있는 Pair 클래스를 작성하세요.

**요구사항:**

- `Pair<K, V>` 클래스 작성 (K: key 타입, V: value 타입)
- 생성자로 두 값을 받아 저장
- `getKey()`: 첫 번째 값 반환
- `getValue()`: 두 번째 값 반환
- `toString()`: "(key, value)" 형식으로 출력
- `swap()`: key와 value를 바꾼 새로운 Pair 반환

**테스트 코드:**

```java
public class PairTest {
    public static void main(String[] args) {
        // String과 Integer 쌍
        Pair<String, Integer> pair1 = new Pair<>("나이", 25);
        System.out.println(pair1);
        System.out.println("Key: " + pair1.getKey());
        System.out.println("Value: " + pair1.getValue());

        // swap 테스트
        Pair<Integer, String> swapped = pair1.swap();
        System.out.println("Swapped: " + swapped);

        // 같은 타입 쌍
        Pair<String, String> pair2 = new Pair<>("이름", "홍길동");
        System.out.println(pair2);
    }
}
```

**예상 출력:**

```
(나이, 25)
Key: 나이
Value: 25
Swapped: (25, 나이)
(이름, 홍길동)
```

---

## 문제 3: 제네릭 배열 유틸리티

배열을 다루는 제네릭 메서드들을 작성하세요.

**요구사항:**

`ArrayUtil` 클래스에 다음 제네릭 메서드들을 작성:

1. `printArray(T[] array)`: 배열의 모든 요소 출력
2. `getFirst(T[] array)`: 첫 번째 요소 반환 (빈 배열이면 null)
3. `getLast(T[] array)`: 마지막 요소 반환 (빈 배열이면 null)

**테스트 코드:**

```java
public class ArrayUtilTest {
    public static void main(String[] args) {
        // Integer 배열 테스트
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.println("=== Integer 배열 ===");
        ArrayUtil.printArray(numbers);
        System.out.println("첫 번째: " + ArrayUtil.getFirst(numbers));
        System.out.println("마지막: " + ArrayUtil.getLast(numbers));

        // String 배열 테스트
        String[] words = {"apple", "banana", "cherry"};

        System.out.println("\n=== String 배열 ===");
        ArrayUtil.printArray(words);
        System.out.println("첫 번째: " + ArrayUtil.getFirst(words));
        System.out.println("마지막: " + ArrayUtil.getLast(words));
    }
}
```

**예상 출력:**

```
=== Integer 배열 ===
1 2 3 4 5
첫 번째: 1
마지막: 5

=== String 배열 ===
apple banana cherry
첫 번째: apple
마지막: cherry
```
