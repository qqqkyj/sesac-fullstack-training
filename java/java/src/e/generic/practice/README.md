# 💡 Java 제네릭(Generic) 정리

---

## 🧩 제네릭의 필요성

### ✅ 타입 안정성 문제

과거에는 **`Object` 타입**을 사용해 범용 클래스를 만들었습니다.

하지만 다음과 같은 **문제점**이 있었습니다 👇

- 형변환이 항상 필요함
- 잘못된 타입을 넣어도 **컴파일 시점에 에러가 발생하지 않음**
- 런타임에 `ClassCastException` 발생 가능

```java
package e.generic;

class Box {
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

public class WithoutGeneric {
    public static void main(String[] args) {
        Box box = new Box();
        box.setItem("hello");
        System.out.println(box.getItem());

        // 항상 형변환 필요
        String str = box.getItem().toString();

        box.setItem(123);
        System.out.println(box.getItem());

        // 잘못된 형변환 → 런타임 오류 가능
        int num = (int) box.getItem();
    }
}
```

---

## 🧠 제네릭 사용

### ✅ 장점

- **형변환 불필요**
- **컴파일 시점에 타입 체크 가능**
- **코드 재사용성 향상**

```java
package e.generic;

class Box2<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class WithGeneric {
    public static void main(String[] args) {
        Box2<String> b1 = new Box2<>();
        b1.setItem("hello");
        String str = b1.getItem(); // 형변환 불필요

        Box2<Integer> b2 = new Box2<>();
        b2.setItem(123);
        int i = b2.getItem();
    }
}
```

---

## 🧱 제네릭 클래스

### ✅ 단일 타입 매개변수

- 타입 매개변수는 **대문자 한 글자**를 사용하는 것이 관례입니다.

```java
package e.generic;

class Container<T> {
    private T value;

    public Container(T value) { this.value = value; }

    public T getValue() { return value; }

    public void setValue(T value) { this.value = value; }
}

public class SingleType {
    public static void main(String[] args) {
        Container<String> c1 = new Container<>("hello");
        Container<Integer> c2 = new Container<>(123);

        System.out.println(c1.getValue());
        System.out.println(c2.getValue());
    }
}
```

---

### ✅ 다중 타입 매개변수

- 여러 개의 타입 매개변수를 함께 사용할 수 있습니다.

```java
package e.generic;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class MultiType {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("gildong", 20);
        System.out.println(p1);

        Pair<String, String> p2 = new Pair<>("hi", "my name is gilja");
        System.out.println(p2);
    }
}
```

---

### 📘 타입 매개변수 명명 규칙

| 문자 | 의미 | 사용 예시 |
| --- | --- | --- |
| `T` | Type (타입) | `class Box<T>` |
| `E` | Element (요소) | `class List<E>` |
| `K` | Key (키) | `class Map<K, V>` |
| `V` | Value (값) | `class Map<K, V>` |
| `N` | Number (숫자) | `class Calculator<N>` |

---

## 🧮 제네릭 메서드

- 클래스 전체가 아닌 **특정 메서드만 제네릭**으로 만들 수 있습니다.

```java
import java.util.Arrays;

public class GenericUtility {

    // 배열의 두 요소를 교환
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 배열에서 특정 요소 찾기
    public static <T> int indexOf(T[] array, T target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(target)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("교환 전: " + Arrays.toString(numbers));
        swap(numbers, 0, 4);
        System.out.println("교환 후: " + Arrays.toString(numbers));

        String[] names = {"Alice", "Bob", "Charlie"};
        int index = indexOf(names, "Bob");
        System.out.println("Bob의 인덱스: " + index);
    }
}
```

---

## 🧬 제네릭 클래스 상속

```java
package e.generic;

class Parent<T> {
    private T value;

    public Parent(T value) { this.value = value; }

    public T getValue() { return value; }
}

class Child<T> extends Parent<T> {
    public Child(T value) { super(value); }
}

class StringChild extends Child<String> {
    public StringChild(String value) { super(value); }
}

class IntegerChild extends Child<Integer> {
    public IntegerChild(Integer value) { super(value); }
}

class ExtendChild<T, U> extends Child<T> {
    private U value2;

    public ExtendChild(T value, U value2) {
        super(value);
        this.value2 = value2;
    }

    public U getValue2() { return value2; }
}

public class Inheritance {
    public static void main(String[] args) {
        Parent<String> stringParent = new Parent<>("hello");
        Child<String> c1 = new Child<>("hi");
        StringChild stringChild = new StringChild("hihi");
        IntegerChild integerChild = new IntegerChild(20);
        ExtendChild<String, Integer> ec1 = new ExtendChild<>("kim", 10);

        System.out.println(stringParent.getValue());
        System.out.println(c1.getValue());
        System.out.println(stringChild.getValue());
        System.out.println(integerChild.getValue());
        System.out.println(ec1.getValue() + " " + ec1.getValue2());
    }
}
```

> ⚠️ 주의: 제네릭 타입은 공변(covariant) 하지 않습니다.
>
>
> 즉, `Parent<Object>` ≠ `Parent<String>`
>

---

## 💎 다이아몬드 연산자 (Diamond Operator)

- **Java 7 이상부터 지원**
- 제네릭 인스턴스 생성 시 **타입을 생략해도 컴파일러가 추론**

```java
Box2<String> box = new Box2<>(); // 타입 추론 자동 적용
```

---

## 🧭 요약

| 구분 | 설명 |
| --- | --- |
| 제네릭의 목적 | 타입 안정성 + 형변환 제거 + 코드 재사용성 향상 |
| 제네릭 클래스 | `<T>`로 타입을 매개변수화한 클래스 |
| 제네릭 메서드 | `<T>`를 메서드 단위로 정의 |
| 상속 시 주의 | 제네릭은 공변하지 않음 |
| 다이아몬드 연산자 | 타입 추론 기능 (Java 7+) |

---
# 💡 제네릭(Generic) 실습 정리

## 🧮 1️⃣ Calculator 실습

### 🧠 개념

제네릭을 사용하여 **두 값을 비교하거나 출력하는 범용 계산기 클래스**를 구현.

- `T` : 타입 매개변수 (Integer, String, Double 등 어떤 타입도 가능)
- `areEqual()` : 두 값이 같은지 비교
- `printBoth()` : 두 값을 출력

---

### 💻 코드

```java
package e.generic.practice;

class Calculator<T> {
    private T first;
    private T second;

    public Calculator(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public T getSecond() { return second; }

    public void printBoth() {
        System.out.println("첫 번째: " + first + ", 두 번째: " + second);
    }

    public boolean areEqual() {
        return first.equals(second);
    }
}

public class CalculatorTest {
    public static void main(String[] args) {
        // Integer 타입
        Calculator<Integer> intCalc = new Calculator<>(10, 20);
        intCalc.printBoth();
        System.out.println("같은 값? " + intCalc.areEqual());

        // String 타입
        Calculator<String> strCalc = new Calculator<>("Hello", "Hello");
        strCalc.printBoth();
        System.out.println("같은 값? " + strCalc.areEqual());

        // Double 타입
        Calculator<Double> doubleCalc = new Calculator<>(3.14, 2.71);
        System.out.println("첫 번째: " + doubleCalc.getFirst());
        System.out.println("두 번째: " + doubleCalc.getSecond());
        System.out.println("같은 값? " + doubleCalc.areEqual());
    }
}
```

---

### 🧾 실행 결과 예시

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

## 🔑 2️⃣ Pair 실습

### 🧠 개념

두 개의 서로 다른 타입(`K`, `V`)을 한 쌍으로 묶는 **제네릭 쌍 클래스**.

- `Pair<K, V>` : Key와 Value를 표현
- `swap()` : key와 value를 뒤집은 새로운 Pair 반환

---

### 💻 코드

```java
package e.generic.practice;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    public Pair<V, K> swap() {
        return new Pair<>(value, key);
    }
}

public class PairTest {
    public static void main(String[] args) {
        // String-Integer 쌍
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

---

### 🧾 실행 결과 예시

```
(나이, 25)
Key: 나이
Value: 25
Swapped: (25, 나이)
(이름, 홍길동)
```

---

## 🧱 3️⃣ ArrayUtil 실습

### 🧠 개념

**배열 관련 유틸리티 기능**을 제네릭 메서드로 구현.

- `<T>` : 배열의 요소 타입을 제네릭으로 처리
- `printArray()` : 배열 출력
- `getFirst()` : 첫 번째 요소 반환
- `getLast()` : 마지막 요소 반환

---

### 💻 코드

```java
package e.generic.practice;

import java.util.Arrays;

class ArrayUtil {
    public static <T> void printArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static <T> T getFirst(T[] array) {
        return array.length > 0 ? array[0] : null;
    }

    public static <T> T getLast(T[] array) {
        return array.length > 0 ? array[array.length - 1] : null;
    }
}

public class ArrayUtilTest {
    public static void main(String[] args) {
        // Integer 배열
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("=== Integer 배열 ===");
        ArrayUtil.printArray(numbers);
        System.out.println("첫 번째: " + ArrayUtil.getFirst(numbers));
        System.out.println("마지막: " + ArrayUtil.getLast(numbers));

        // String 배열
        String[] words = {"apple", "banana", "cherry"};
        System.out.println("\n=== String 배열 ===");
        ArrayUtil.printArray(words);
        System.out.println("첫 번째: " + ArrayUtil.getFirst(words));
        System.out.println("마지막: " + ArrayUtil.getLast(words));
    }
}
```

---

### 🧾 실행 결과 예시

```
=== Integer 배열 ===
[1, 2, 3, 4, 5]
첫 번째: 1
마지막: 5

=== String 배열 ===
[apple, banana, cherry]
첫 번째: apple
마지막: cherry
```

---

## 🧩 요약

| 실습명 | 주요 제네릭 개념 | 특징 |
| --- | --- | --- |
| `Calculator<T>` | 단일 타입 매개변수 | 다양한 타입 비교 및 출력 |
| `Pair<K, V>` | 다중 타입 매개변수 | key-value 쌍 및 swap 기능 |
| `ArrayUtil` | 제네릭 메서드 | 배열 다루기 (출력, 첫/마지막 요소) |
---

