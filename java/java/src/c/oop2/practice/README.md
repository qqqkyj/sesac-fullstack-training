## 🧩 메서드 (Method)

- 특정 **작업을 수행하는 코드 블록**
- **클래스 내부**에 있으면 → 메서드
  **클래스 외부**에 있으면 → 함수

```java
접근제어자 반환타입 메서드명(매개변수목록) {
    // 메서드 본문
    return 반환값;  // 반환타입이 void가 아닌 경우
}
```

---

## 🔹 매개변수(Parameter)

### 1️⃣ 기본형 매개변수 (값 전달)

- **값이 복사되어 전달** → 원본 데이터는 영향 없음

```java
public class Calculator {
    int add(int a, int b) { return a + b; }
    int sub(int a, int b) { return a - b; }
    int mul(int a, int b) { return a * b; }
    int div(int a, int b) { return a / b; }

    void printResult(int result) {
        System.out.println(result);
    }
}
```

---

### 2️⃣ 참조형 매개변수 (참조 전달)

- **주소값(참조)이 전달** → 원본 데이터 변경 가능

```java
class Data {
    int value;
}

public class ReferParams {
    void changeValue(Data d) {
        d.value = 99;
        System.out.println(d.value);
    }

    public static void main(String[] args) {
        ReferParams ref = new ReferParams();
        Data d = new Data();
        d.value = 10;
        ref.changeValue(d);
        System.out.println(d.value); // 99
    }
}
```

---

## 🔹 반환값(Return Value)

- 메서드는 **값, 객체, 배열, 문자열, 조건식 결과 등**을 반환할 수 있음
- `void` → 반환값 없음

```java
class Sample { int value; }

public class Calculator {
    int add(int a, int b) { return a + b; }
    void printResult(int result) { System.out.println(result); }

    // String 반환
    String printValue(int score) {
        return score >= 50 ? "pass" : "fail";
    }

    // 배열 반환
    int[] getArray() {
        return new int[]{1, 3, 5, 7, 9};
    }

    // 객체 반환
    Sample getSample() {
        return new Sample();
    }
}
```

---

## 🔹 오버로딩 (Overloading)

### ✅ 정의

같은 이름의 **메서드나 생성자**를 **매개변수를 다르게** 여러 개 정의하는 것

### ✅ 조건

- 메서드 이름 같음
- 매개변수의 **개수, 타입, 순서** 중 하나 이상 달라야 함
- **반환 타입은 영향 없음**

```java
int add(int a, int b) { return a + b; }
int add(int a, int b, int c) { return a + b + c; }
```

---

## 🔹 생성자 오버로딩

- 매개변수가 다른 **여러 생성자 정의 가능**
- `this()` 로 **다른 생성자 호출 가능**
- **코드 중복 제거**, **유지보수 용이**

```java
public class Rectangle {
    int width;
    int height;

    public Rectangle() {
        this(1, 1);
    }

    public Rectangle(int size) {
        this(size, size);
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```

---

## 🔹 가변 인자 (Varargs)

- 매개변수의 **개수를 유동적으로** 받을 수 있음 (`Java 5+`)

```java
int add(int... numbers) {
    int sum = 0;
    for (int n : numbers) sum += n;
    return sum;
}

String concat(String... strings) {
    StringBuilder sb = new StringBuilder();
    for (String s : strings) sb.append(s).append(" ");
    return sb.toString();
}
```

### 📌 규칙

- 가변 인자는 **가장 마지막에 위치**
- **한 메서드당 하나만** 선언 가능

---

## 🔹 static 메서드

### ✅ 특징

- **객체 생성 없이** 호출 가능 (`클래스명.메서드명()` 형태)
- **인스턴스 변수 사용 불가**, static 변수만 접근 가능

```java
public class MethodType {
    int instanceField = 10;
    static int staticField = 20;

    void instanceMethod() {
        System.out.println("instanceMethod");
        System.out.println("instanceField = " + instanceField);
        System.out.println("staticField = " + staticField);
    }

    static void staticMethod() {
        System.out.println("staticMethod");
        System.out.println("staticField = " + staticField);
    }

    public static void main(String[] args) {
        MethodType mt = new MethodType();
        mt.instanceMethod();          // 인스턴스 필요
        MethodType.staticMethod();    // 인스턴스 불필요
    }
}
```

| 구분                | 호출 방식         | 접근 가능 멤버    |
| ------------------- | ----------------- | ----------------- |
| **instance 메서드** | 객체로 호출       | instance + static |
| **static 메서드**   | 클래스명으로 호출 | static만 가능     |

---

✅ **정리 요약**

| 개념                | 설명                                    |
| ------------------- | --------------------------------------- |
| **메서드**          | 특정 기능을 수행하는 코드 블록          |
| **기본형 매개변수** | 값 복사 전달                            |
| **참조형 매개변수** | 주소값 전달 (원본 변경 가능)            |
| **반환값**          | 연산 결과를 반환 (`void`는 없음)        |
| **오버로딩**        | 같은 이름, 다른 매개변수                |
| **생성자 오버로딩** | 매개변수에 따라 다양한 초기화 가능      |
| **가변 인자**       | 매개변수 개수 유동적                    |
| **static 메서드**   | 객체 없이 호출, static 필드만 접근 가능 |

---
