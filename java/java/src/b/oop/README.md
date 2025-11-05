## 🧱 객체지향 프로그래밍 (OOP: Object Oriented Programming)

### 💡 핵심 개념

> OOP(Object Oriented Programming)
>
> → 프로그램을 데이터(속성)와 기능(동작)을 **하나의 객체(Object)** 단위로 묶어 설계하는 프로그래밍 패러다임.

---

### 🎯 OOP의 주요 특징

| 특징                      | 설명                                           | 예시                                                     |
| ------------------------- | ---------------------------------------------- | -------------------------------------------------------- |
| **캡슐화(Encapsulation)** | 데이터(필드)와 기능(메서드)을 하나로 묶는 것   | `class Rectangle { int width; int height; int area(); }` |
| **상속(Inheritance)**     | 기존 클래스를 확장해 새로운 클래스를 만드는 것 | `class Square extends Rectangle`                         |
| **다형성(Polymorphism)**  | 같은 이름의 메서드가 다른 동작을 수행          | `draw()`가 도형마다 다르게 동작                          |
| **추상화(Abstraction)**   | 복잡한 내부 구현은 숨기고, 필요한 부분만 노출  | `Car.start()`는 내부 엔진 구조를 몰라도 사용 가능        |

---

### ⚙️ OOP의 장점

- ✅ **코드의 중복 감소**
- ✅ **유지보수 용이**
- ✅ **확장성(재사용성) 향상**
- ✅ **현실 세계의 개념을 코드로 표현하기 쉬움**

---

## 🧩 클래스(Class)란?

> 클래스는 **비슷한 속성(데이터)**과 **기능(동작)**을 하나로 묶어
>
> 새로운 **사용자 정의 타입**을 만드는 **설계도(blueprint)** 역할을 합니다.

### 클래스 구성 요소

| 구성 요소               | 설명                | 예시                                       |
| ----------------------- | ------------------- | ------------------------------------------ |
| **필드(Field)**         | 객체의 속성(데이터) | `int width;`                               |
| **메서드(Method)**      | 객체의 동작(기능)   | `int calArea() { return width * height; }` |
| **생성자(Constructor)** | 객체 초기화 시 사용 | `Rectangle(int w, int h) { ... }`          |

---

## 🧮 예제 비교: 절차지향 → 객체지향

### ❌ 절차지향 방식 (OOP 이전)

```java
// 각 사각형의 면적을 계산 (중복 발생)
int width1 = 100, height1 = 200;
int area1 = width1 * height1;

int width2 = 10, height2 = 20;
int area2 = width2 * height2;

System.out.println(area1);
System.out.println(area2);
```

➡️ **문제점**:

- 데이터(`width`, `height`)와 기능(`area 계산`)이 분리되어 있음
- 중복 코드 많음
- 관리/수정이 어려움

---

### ✅ 개선 1. 메서드 사용

```java
public class Intro {
    public static void main(String[] args) {
        int rec1 = calArea(10, 10);
        int rec2 = calArea(20, 20);
        int rec3 = calArea(30, 30);

        System.out.println(rec1);
        System.out.println(rec2);
        System.out.println(rec3);
    }

    // 메서드: 클래스 내부의 함수
    public static int calArea(int width, int height) {
        return width * height;
    }
}
```

📌 **장점:** 중복된 계산식 제거

📌 **단점:** 여전히 `width`, `height`가 **객체로 묶이지 않음**

➡️ 데이터와 기능이 분리된 상태 유지

---

### ✅ 개선 2. 클래스(Class) 도입

```java
// 사각형 클래스 정의
class Rectangle {
    int width;   // 속성(필드)
    int height;  // 속성(필드)

    // 생성자: 초기화 메서드
    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // 동작(메서드)
    int calArea() {
        return width * height;
    }
}
```

```java
// 실행 클래스
public class Intro {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 20);
        Rectangle r3 = new Rectangle(30, 30);

        System.out.println(r1.calArea());
        System.out.println(r2.calArea());
        System.out.println(r3.calArea());
    }
}
```

📌 **장점:**

- 관련된 데이터(`width`, `height`)와 기능(`calArea`)이 한 객체 안에 포함
- `Rectangle`이라는 **새로운 타입** 생성
- 코드 재사용 및 유지보수 용이
