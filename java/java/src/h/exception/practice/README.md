# 📌 자바 예외(Exception) 정리

## 1. Error vs Exception

| 구분 | **Error** | **Exception** |
| --- | --- | --- |
| 의미 | 시스템 레벨의 치명적 문제 | 프로그램 실행 중 발생하는 문제 |
| 복구 가능성 | 불가능 | 가능 |
| 원인 | JVM 내부 문제 | 개발자 실수, 외부 환경 문제 |
| 예시 | OutOfMemoryError, StackOverflowError | NullPointerException, IOException |
| 처리 여부 | 처리 안 함 | try-catch로 처리 |

---

## 2. 예외 클래스 계층 구조

```
Throwable
├── Error (시스템 오류)
│   ├── OutOfMemoryError
│   ├── StackOverflowError
│   └── ...
└── Exception (예외)
    ├── RuntimeException (Unchecked)
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   ├── ArithmeticException
    │   ├── IllegalArgumentException
    │   └── ...
    └── IOException (Checked)
        ├── FileNotFoundException
        ├── EOFException
        └── ...
```

---

## 3. Checked Exception vs Unchecked Exception

| 구분 | **Unchecked Exception** | **Checked Exception** |
| --- | --- | --- |
| 상속 | RuntimeException | Exception (단, RuntimeException 제외) |
| 컴파일 체크 | X | O |
| 예외 처리 강제 | 선택 | 필수 |
| 주 원인 | 개발자의 실수 | 외부 환경(파일, DB, 네트워크 등) |
| 예방 가능 여부 | 가능 | 어려움 |
| 대표 예시 | NullPointerException | IOException |

---

## 4. Unchecked Exception (런타임 예외)

- `RuntimeException` 상속
- 컴파일러가 예외 처리 강제하지 않음
- 개발자가 로직을 잘못 작성한 경우 발생
- 예외 처리 **선택적**

### 주요 예외

- **NullPointerException**
- **ArrayIndexOutOfBoundsException**
- **IllegalArgumentException**
- **ArithmeticException**
- **NumberFormatException**

### 예시 코드

```java
public class ErrorException {
    public static void main(String[] args) {

        // NullPointerException
        String str = null;
        System.out.println(str.length());

        // ArrayIndexOutOfBoundsException
        int[] arr = {1, 2, 3};
        System.out.println(arr[99]);

        // NumberFormatException
        int num = Integer.parseInt("asdf");

        // IllegalArgumentException
        int age = -10;
        if(age < 0){
            throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.");
        }
    }
}
```

---

## 5. 예외 처리 문법

### ✔ try-catch-finally

- **try**: 예외 가능 코드
- **catch**: 예외 발생 시 처리
- **finally**: 무조건 실행 (리소스 정리)

```java
FileReader fr = null;

try {
    fr = new FileReader("data.txt");
    System.out.println("파일을 불러왔습니다.");
} catch (IOException e) {
    System.out.println("파일이 존재하지 않습니다.");
} finally {
    try {
        fr.close();
    } catch (IOException e) {
        System.out.println("파일 닫기 실패");
    }
}
```

---

## 6. 다중 catch

- **위 → 아래 순서로 검사**
- **더 구체적인 예외를 먼저 작성**

```java
try {
    String input = "123";
    int num = Integer.parseInt(input);
    int result = 100 / num;
}
catch (NumberFormatException e) {
    System.out.println("형변환 불가: " + e.getMessage());
}
catch (ArithmeticException e) {
    System.out.println("계산 오류: " + e.getMessage());
}
catch (Exception e) {
    System.out.println("모르는 예외: " + e.getMessage());
}
```

### ✔ Java 7 이후: 멀티 catch

```java
try {
    // 코드
} catch (NumberFormatException | IllegalArgumentException e) {
    System.out.println("입력 오류: " + e.getMessage());
}
```

---

## 7. throws 키워드

- 메서드 내부에서 예외를 처리하지 않고 **호출한 쪽으로 예외를 던짐**
- Checked 예외에서 주로 사용

```java
public class ThrowsExample {

    public static void readFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);
    }

    public static void main(String[] args) {
        try {
            readFile("data.txt");
        } catch (IOException e) {
            System.out.println("파일 읽기 실패: " + e.getMessage());
        }
    }
}
```

---

# 📘 총정리

- **Error**: 시스템 치명적 문제 → 처리 X
- **Exception**: 프로그램 레벨 문제 → try-catch 가능
- **Unchecked 예외**: RuntimeException, 개발자 실수
- **Checked 예외**: 외부 환경, 반드시 처리
- **try-catch-finally**, **멀티 catch**, **throws** 문법을 활용해 예외 제어

---

# 🧩 8. 사용자 정의 예외 (Custom Exception)

### ✔ Unchecked 예외 버전(RuntimeException)

```java
class InsufficientBalanceException extends **RuntimeException** {
    public InsufficientBalanceException(int current, int request) {
        super("잔액 부족 / " + current + " / " + request);
    }
}

public class BankAccount {
    private int balance;

    public BankAccount(int balance) { this.balance = balance; }

    public void withdraw(int amount) {
        if (balance < amount)
            **throw new InsufficientBalanceException(balance, amount);**

        balance -= amount;
    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount(10000);
        ba.withdraw(100000);  // 예외 발생
    }
}
```

---

# ⚡ **9. 람다식 (Lambda Expression)**

## ✔ 람다식이란?

- **익명 함수를 간결하게 표현하는 문법**
- Java 8부터 도입
- JavaScript 화살표 함수와 유사:

  `x -> x * 2`


---

## ✔ 람다식 기본 형태

```java
(매개변수) -> 표현식
(매개변수) -> { 실행문; }
```

### 👉 매개변수 없음

```java
() -> System.out.println("Hello");
() -> 42
```

### 👉 매개변수 1개

```java
x -> x * x
x -> { return x * x; }
```

### 👉 매개변수 2개 이상

```java
(a, b) -> a + b
(a, b) -> { return a + b; }
```

---

## ✔ 익명 클래스 → 람다식 비교

```java
Comparator<Integer> comparator = new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
};

// 람다식
Comparator<Integer> comparator2 = (a, b) -> Integer.compare(a, b);
```

---

# 🔧 **10. 함수형 인터페이스 (Functional Interface)**

- 람다식은 반드시 **함수형 인터페이스**에 대입됨
- 조건: **추상 메서드가 딱 하나**

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
```

### 사용 예

```java
Calculator add = (a, b) -> a + b;
Calculator mul = (a, b) -> a * b;
```

---

# 📦 **11. 표준 함수형 인터페이스 (java.util.function)**

| 인터페이스 | 메서드 | 설명 | 예제 |
| --- | --- | --- | --- |
| Supplier<T> | `T get()` | 값을 생성해 반환 | `() -> "Hello"` |
| Consumer<T> | `void accept(T t)` | 값을 소비 | `s -> println(s)` |
| Function<T,R> | `R apply(T t)` | 값을 변환 | `x -> x * 2` |
| Predicate<T> | `boolean test(T t)` | 조건 검사 | `x -> x > 0` |
| UnaryOperator<T> | `T apply(T t)` | 같은 타입 반환 | `x -> x + 1` |
| BinaryOperator<T> | `T apply(T,T)` | 두 값 받아 동일 타입 반환 | `(a,b)->a+b` |
| BiFunction<T,U,R> | `R apply(T,U)` | 두 값 → 다른 타입 | `(a,b)->a+b` |

---

# 🪞 **12. 메서드 참조 (::)**

람다식을 더 간단하게 표현하는 방법

**이미 존재하는 메서드의 형태가 정확히 일치할 때만 사용 가능**

---

## ✔ 종류

### ① 정적 메서드 참조

`클래스명::메서드명`

```java
Function<String, Integer> parser = Integer::parseInt;
```

### ② 특정 객체의 인스턴스 메서드 참조

`객체참조::메서드명`

```java
String prefix = "Hello, ";
Function<String, String> greeter = prefix::concat;
```

### ③ 특정 타입의 인스턴스 메서드 참조

`클래스명::메서드명`

```java
Function<String, String> upper = String::toUpperCase;
```

### ④ 생성자 참조

`클래스명::new`

```java
Supplier<ArrayList<String>> listSupplier = ArrayList::new;
```

### ✔ 리스트 출력 시 활용

```java
names.forEach(System.out::println);
```

---

# 🌊 **13. Stream API**

컬렉션을 **함수형 방식으로 처리**하기 위한 도구

---

## ✔ 스트림의 특징

- **원본 데이터 변경 없음**
- **1회성**
- **지연 실행(lazy evaluation)**

  → 최종 연산이 실행될 때 중간 연산이 수행됨


---

## ✔ 스트림 예제 (기본 vs Stream)

### 기존 방식

```java
int sum = 0;
for (Integer i : list) {
    if (i % 2 == 0)
        sum += i * i;
}
System.out.println(sum);
```

### Stream 방식

```java
int sum2 = list.stream()
        .filter(i -> i % 2 == 0)   // 짝수만
        .map(i -> i * i)           // 제곱
        .reduce(0, Integer::sum);  // 누적 합
```

---

## ✔ 스트림 생성

```java
List<String> list = Arrays.asList("kim", "lee", "park");
Stream<String> stream = list.stream();

String[] arr = {"kim", "lee", "park"};
Stream<String> stream2 = Arrays.stream(arr);
```

---

## ✔ 중간 연산 (Intermediate Operations)

- `filter()`

    ```java
    				List<Integer> numbers = Arrays.asList(5, 3, 1, 7, 5, 3, 2, 9, 4, 8);
            List<Integer> evens = numbers.stream()
                    .filter(i -> i % 2 == 0) // true/false
                    .toList();
            System.out.println(evens); // [2, 4, 8]
    
            List<Integer> greaterThan5 = numbers.stream()
                    .filter(i -> i > 5) // true/false
                    .toList();
            System.out.println(greaterThan5); // [7, 9, 8]
    
            List<Integer> filtered = numbers.stream()
                    .filter(i -> i > 5)
                    .filter(i -> i % 2 == 0)
                    .toList();
            System.out.println(filtered); // [8]
            
            List<String> words = Arrays.asList("Apple", "Banana", "Cherry");
            List<String> longWords = words.stream()
                    .filter(s -> s.length() > 5)
                    .toList();
            System.out.println(longWords); // [Banana, Cherry]
    ```

- `map()`

    ```java
    				// map
            List<Integer> squares = numbers.stream()
                    .map(i -> i * i)
                    .toList();
            System.out.println(squares);// [25, 9, 1, 49, 25, 9, 4, 81, 16, 64]
    
            List<String> upper = words.stream()
                    .map(String::toUpperCase)
                    .toList();
            System.out.println(upper);//[APPLE, BANANA, CHERRY]
    ```

- `sorted()`

    ```java
    				//sorted
            List<Integer> sorted = numbers.stream()
                    .sorted() //.sorted(Comparator.reverseOrder()) => 내림차순
                    .toList();
            System.out.println(sorted);//[1, 2, 3, 3, 4, 5, 5, 7, 8, 9] => 오름차순
    ```

- `distinct()`

    ```java
    				//distinct
            List<Integer> distinct = numbers.stream()
                    .distinct()
                    .sorted()
                    .toList();
            System.out.println(distinct);
    ```

- `limit()`, `skip()`

→ **새로운 스트림을 반환하며 지연 실행됨**

---

## ✔ 최종 연산 (Terminal Operations)

- `forEach()`

    ```java
    //forEach
            numbers.stream().forEach(System.out::println);
            numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.printf(n + " "));
    ```

- `reduce()`

    ```java
    				//reduce
            int result = numbers.stream()
                    .reduce(1, Integer::sum);
            System.out.println(result);
    
            int result2 = numbers.stream()
                    .reduce(1, (a, b) -> a * b);
            System.out.println(result2);
    ```

- `collect()`

    ```java
    				//collect
            Map<String, Integer> map = words.stream()
                    .collect(Collectors.toMap(s -> s, String::length));
            System.out.println(map);
    ```

- `count()`

    ```java
    				//count
            long count = numbers.stream().count();
            System.out.println(count);
    ```

- `anyMatch()`, `allMatch()`

→ 스트림을 **소진하고 결과를 반환**

---

# 📌 전체 요약

- **람다식**: 코드를 간결하게 표현
- **함수형 인터페이스**: 추상 메서드 1개
- **표준 함수형 인터페이스**: 자주 쓰는 기본 제공 인터페이스
- **메서드 참조 (::)**: 기존 메서드를 람다 대신 사용
- **Stream API**: 컬렉션을 함수형 스타일로 처리하는 기능
---

