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

## 📦 패키지 (Package)

### ✅ 정의

> 관련된 클래스들을 그룹화하여 관리하는 네임스페이스(namespace)
>
> → 클래스 이름 충돌 방지, 코드 구조화 및 관리 용이

```java
package c.oop2;

import java.util.*;
// import java.util.ArrayList;
// import java.util.HashMap;

public class PackageExample {
    public static void main(String[] args) {
        String.join(",");
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
    }
}
```

---

## 💡 패키지가 필요한 이유

| 이유                    | 설명                                                 |
| ----------------------- | ---------------------------------------------------- |
| **이름 충돌 방지**      | 동일한 클래스명이라도 다른 패키지에 있으면 구분 가능 |
| **접근 제어**           | 접근제어자와 함께 사용해 캡슐화 구현                 |
| **코드 구조화 및 관리** | 대규모 프로젝트의 코드 조직화에 유리                 |

예시 구조:

```java
com/example/
├── user/
│   ├── User.java
│   ├── UserService.java
│   └── UserRepository.java
├── product/
│   ├── Product.java
│   └── ProductService.java
└── utils/
    ├── Validator.java
    └── DateFormatter.java
```

---

## 🧭 패키지 네이밍 규칙

| 규칙                     | 설명                                | 예시                                        |
| ------------------------ | ----------------------------------- | ------------------------------------------- |
| **소문자 사용**          | 클래스와 구분 위해 모두 소문자 사용 | `package com.example.myapp;`                |
| **역방향 도메인명 사용** | 도메인 소유자 기반 네임스페이스     | `org.apache.commons` / `io.github.username` |
| **의미 있는 이름 사용**  | 클래스 역할이 명확히 드러나야 함    | `package com.example.utils;`                |
| **예약어 사용 금지**     | Java 예약어는 패키지명으로 불가     | ❌ `package int.class;`                     |

---

## 🧩 일반적인 패키지 구조

### 🏗️ 1️⃣ 계층별 구조 (Layered Architecture)

> 역할(Controller, Service, Repository, Model)에 따라 구분

```
com/example/myapp/
├── controller/
│   ├── UserController.java
│   └── ProductController.java
├── service/
│   ├── UserService.java
│   └── ProductService.java
├── repository/
│   ├── UserRepository.java
│   └── ProductRepository.java
└── model/
    ├── User.java
    └── Product.java
```

---

### 🧠 2️⃣ 기능별 구조 (Feature-based)

> 기능 단위로 묶어 관리 — 독립적인 모듈 구성에 유리

```
com/example/myapp/
├── user/
│   ├── User.java
│   ├── UserController.java
│   ├── UserService.java
│   └── UserRepository.java
└── product/
    ├── Product.java
    ├── ProductController.java
    ├── ProductService.java
    └── ProductRepository.java
```

---

## ✅ 요약 정리

| 항목            | 내용                                                    |
| --------------- | ------------------------------------------------------- |
| **정의**        | 관련 클래스들을 그룹화하는 네임스페이스                 |
| **목적**        | 이름 충돌 방지, 접근 제어, 코드 구조화                  |
| **네이밍 규칙** | 소문자, 역방향 도메인명, 의미 있는 이름                 |
| **구조 유형**   | 계층별 구조 / 기능별 구조                               |
| **import 문**   | 다른 패키지 클래스 사용 시 필요 (`import java.util.*;`) |

---

## 🔐 접근 제어자 (Access Modifier)

### ✅ 개념

> 클래스, 필드, 메서드 등에 대한 접근 범위를 제한하는 키워드
>
> → 객체지향의 **정보 은닉(Information Hiding)** 구현 수단

---

### 📋 Java의 4가지 접근 제어자

| 접근 제어자          | 같은 클래스 | 같은 패키지 | 자식 클래스 | 전체(외부) | 설명                                  |
| -------------------- | ----------- | ----------- | ----------- | ---------- | ------------------------------------- |
| `private`            | ✅          | ❌          | ❌          | ❌         | 클래스 내부에서만 접근 가능           |
| (default) _(명시 X)_ | ✅          | ✅          | ❌          | ❌         | 같은 패키지 내에서만 접근 가능        |
| `protected`          | ✅          | ✅          | ✅          | ❌         | 상속 관계의 자식 클래스에서 접근 가능 |
| `public`             | ✅          | ✅          | ✅          | ✅         | 모든 곳에서 접근 가능                 |

---

### 💻 예시 코드

```java
package c.oop2;

public class AccessModifier {
    public static void main(String[] args) {
        PrivateClass pc = new PrivateClass(10);
        pc.resetValue();          // public 메서드 → 접근 가능
        pc.value2 = "test msg";   // public 필드 → 접근 가능

        System.out.println(pc.getValue()); // getter 통해 접근
        System.out.println(pc.value2);
    }
}
```

```java
package c.oop2;

public class PrivateClass {
    private int value;      // 외부 직접 접근 불가
    public String value2;   // 외부 접근 가능

    public PrivateClass(int value) {
        this.value = value;
    }

    public void resetValue() {
        this.value = 0;
    }

    public int getValue() {
        return value;
    }
}
```

---

## 🧱 캡슐화 (Encapsulation)

### ✅ 개념

> **데이터(필드)**와 **메서드(기능)**를 하나로 묶고,
>
> 외부에서 **직접 접근을 제한**하여 데이터를 보호하는 기법

---

### 💡 구현 방법

1. **필드를 `private`으로 선언**
2. **외부 접근은 `getter` / `setter` 메서드로 제한**

```java
public class Rectangle {
    private int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("너비는 0보다 커야 합니다.");
        }
        this.width = width;
    }
}
```

---

### 🌟 캡슐화의 장점

| 장점                    | 설명                                       |
| ----------------------- | ------------------------------------------ |
| **데이터 무결성 보장**  | 잘못된 값의 직접 수정 방지                 |
| **유지보수 용이**       | 내부 구현 변경 시 외부 코드 영향 최소화    |
| **부가 기능 추가 용이** | setter/getter 안에 검증, 로그 등 추가 가능 |
| **보안성 향상**         | 민감한 데이터 외부 접근 차단 가능          |

---

## ✅ 요약 정리

| 항목                 | 내용                                           |
| -------------------- | ---------------------------------------------- |
| **접근 제어자 종류** | `private`, (default), `protected`, `public`    |
| **private**          | 클래스 내부에서만 접근 가능                    |
| **default**          | 같은 패키지 내에서 접근 가능                   |
| **protected**        | 자식 클래스에서도 접근 가능                    |
| **public**           | 어디서나 접근 가능                             |
| **캡슐화 핵심**      | 데이터는 `private`, 접근은 `getter/setter`     |
| **장점**             | 데이터 보호, 유지보수성 향상, 코드 안정성 증가 |

---

# 💡 **정적 멤버 (Static Member)**

### 📘 개념

- `static` 키워드를 사용하여 **클래스 레벨의 멤버**를 선언
- 인스턴스(객체)에 속하지 않고, **클래스 자체에 속함**

---

### 🔍 인스턴스 멤버 vs 정적 멤버

| 구분      | 인스턴스 멤버              | 정적 멤버 (`static`)      |
| --------- | -------------------------- | ------------------------- |
| 소속      | 각 객체(인스턴스)에 속함   | 클래스 전체에 속함        |
| 개수      | 객체마다 별도로 존재       | 클래스당 하나만 존재      |
| 접근 방법 | 객체 생성 후 `this`로 접근 | 클래스 이름으로 직접 접근 |
| 사용 시점 | 객체 생성 필요             | 객체 생성 없이 사용 가능  |

---

### 🧩 예제

```java
package c.oop2;

public class Student {
    private String name;
    private int score;

    private static int totalStudent = 0;
    private static int totalScore = 0;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        totalStudent++;
        totalScore += score;
    }

    public static int getTotalStudent() {
        return totalStudent;
    }

    public static double getAverageScore() {
        return (double) totalScore / totalStudent;
    }

    // Getter & Setter
    public String getName() { return name; }
    public int getScore() { return score; }
    public void setName(String name) { this.name = name; }
    public void setScore(int score) { this.score = score; }
}
```

```java
package c.oop2;

public class StudentMain {
    public static void main(String[] args) {
        Student s1 = new Student("kim", 100);
        Student s2 = new Student("lee", 30);
        Student s3 = new Student("jack", 70);

        System.out.println(s1.getName());                // kim
        System.out.println(Student.getTotalStudent());   // 3
        System.out.println(Student.getAverageScore());   // 66.666...
    }
}
```

---

# 💡 **싱글톤 패턴 (Singleton Pattern)**

### 📘 개념

- **클래스의 인스턴스가 오직 하나만 생성**되도록 보장하는 디자인 패턴
- 주로 **공유 리소스**(DB 연결, 설정, 캐시 등)에 사용

---

### 🧱 구현 방법

```java
package c.oop2;

// 공유 리소스
public class Singleton {
    // 1. 클래스 내부에서 단 하나의 인스턴스를 저장
    private static Singleton instance = null;

    // 2. 생성자를 private으로 → 외부에서 new 불가
    private Singleton() {}

    // 3. 인스턴스를 얻는 public static 메서드
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(); // 최초 1회만 생성
                }
            }
        }
        return instance;
    }
}
```

```java
package c.oop2;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); // true → 같은 인스턴스
    }
}
```

---

### ✅ 장점

- 메모리 절약 (인스턴스 1개만 존재)
- 전역 접근 가능 (`getInstance()`로 어디서든 접근)
- 공유 리소스 관리 용이

### ⚠️ 단점

- 테스트 어려움 (상태 공유로 인한 격리 어려움)
- 전역 상태로 인해 **결합도 증가**
- 멀티스레드 환경에서 **동기화 주의 필요**

### 💡 사용 예시

- 애플리케이션 설정
- 로깅 시스템
- 데이터베이스 연결 풀
- 캐시
- 스레드 풀

---

# 💡 **ENUM (열거형)**

### 📘 개념

- **관련된 상수들을 하나의 타입으로 묶은 것**
- 코드의 **가독성과 안정성**을 높임

---

### 🧩 예제

```java
package c.oop2;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;
}
```

```java
package c.oop2;

import java.util.Arrays;

public class EnumExample {
    public static void main(String[] args) {
        Direction direction = Direction.WEST;

        System.out.println(direction);                  // WEST
        System.out.println(direction.name());           // "WEST"
        System.out.println(direction.ordinal());        // 3 (인덱스)
        System.out.println(Arrays.toString(Direction.values())); // [NORTH, EAST, SOUTH, WEST]
        System.out.println(Direction.valueOf("NORTH")); // NORTH
    }
}
```

---

### 🧭 요약

| 기능                | 설명                       |
| ------------------- | -------------------------- |
| `name()`            | 열거형 상수의 이름 반환    |
| `ordinal()`         | 선언 순서(0부터 시작) 반환 |
| `values()`          | 모든 상수를 배열로 반환    |
| `valueOf("문자열")` | 해당 이름의 상수를 반환    |

---

✅ **정리 요약**

| 개념        | 키워드      | 핵심 포인트                          |
| ----------- | ----------- | ------------------------------------ |
| 정적 멤버   | `static`    | 클래스당 하나, 객체 없이 접근 가능   |
| 싱글톤 패턴 | `Singleton` | 인스턴스 단 하나, 전역 공유 가능     |
| 열거형      | `enum`      | 상수 묶음, 안전하고 가독성 높은 코드 |

---
