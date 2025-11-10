# 💡 **상속 (Inheritance)**

## 📘 개념

- **상속**이란, 기존 클래스(**부모 클래스**)의 멤버를 새로운 클래스(**자식 클래스**)가 물려받아 사용하는 기능입니다.
- 상속을 통해 **코드의 중복을 줄이고**, **관련 있는 클래스들을 계층적으로 구조화**할 수 있습니다.
- `extends` 키워드를 사용하여 상속을 구현합니다.
  → “부모 클래스의 기능을 확장한다(extend)”는 의미입니다.

---

## 🧩 기본 구조 예시

```java
class Phone {
    String brand;
    String model;
    int batteryLevel;

    public Phone(String brand, String model, int batteryLevel) {
        this.brand = brand;
        this.model = model;
        this.batteryLevel = batteryLevel;
    }

    void powerOn() {
        System.out.println(model + " is powering on!");
    }

    void charge() {
        batteryLevel = 100;
        System.out.println("finish!");
    }
}

class Iphone extends Phone {
    String ios;

    public Iphone(String brand, String model, int batteryLevel, String ios) {
        super(brand, model, batteryLevel);
        this.ios = ios;
    }

    void useFaceID() {
        System.out.println("using FaceID");
    }
}

class Galaxy extends Phone {
    String android;

    public Galaxy(String brand, String model, int batteryLevel, String android) {
        super(brand, model, batteryLevel);
        this.android = android;
    }

    void useSPen() {
        System.out.println("using SPen");
    }
}

public class PhoneMain {
    public static void main(String[] args) {
        Iphone i = new Iphone("apple", "16 pro", 0, "26.1");
        Galaxy g = new Galaxy("samsung", "s25", 0, "25");

        i.powerOn();
        i.charge();
        i.useFaceID();

        g.powerOn();
        g.charge();
        g.useSPen();
    }
}
```

📍

- **`Phone`** → 부모 클래스
- **`Iphone`, `Galaxy`** → 자식 클래스
- 부모 클래스는 **공통 속성과 기능**을, 자식 클래스는 **개별 기능**을 정의합니다.

---

## ⚙️ 상속의 규칙

| 항목                                     | 설명                                                                                              |
| ---------------------------------------- | ------------------------------------------------------------------------------------------------- |
| **단일 상속만 가능**                     | 자바는 다이아몬드 문제를 방지하기 위해 **하나의 부모 클래스만 상속** 가능                         |
| **생성자 & 초기화 블록은 상속되지 않음** | 자식 클래스에서 반드시 부모 생성자를 `super()`로 명시적으로 호출해야 함 (기본 생성자가 없는 경우) |
| **`super()`는 생성자의 첫 줄**           | 부모 생성자를 반드시 첫 번째 줄에서 호출해야 함                                                   |
| **상속되는 것**                          | 멤버 변수(필드), 메서드                                                                           |
| **상속되지 않는 것**                     | 생성자, 초기화 블록                                                                               |
| **private 멤버**                         | 상속은 되지만 직접 접근 불가 → `getter/setter`로 접근해야 함                                      |

---

## 🔑 `super` 키워드

| 키워드  | 의미                                   |
| ------- | -------------------------------------- |
| `this`  | 현재 객체 자신을 참조                  |
| `super` | 부모 클래스(상위 클래스)의 멤버를 참조 |

### 📍 예시

```java
class Animal2 {
    String name;
    int age;

    Animal2(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Dog2 extends Animal2 {
    String breed;

    Dog2(String name, int age, String breed) {
        super(name, age); // 부모 클래스의 생성자 호출
        this.breed = breed;
    }
}

public class SuperMain {
    public static void main(String[] args) {
        Animal2 a = new Animal2("동물", 0);
        Dog2 d = new Dog2("강아지", 3, "진돗개");
    }
}
```

📍 **생성자 호출 순서**

자식 생성자 → 부모 생성자 순으로 호출됩니다.

즉, **부모가 먼저 초기화된 후 자식이 초기화**됩니다.

---

## 🧱 필드 / 메서드 참조

### 📘 필드 이름이 같을 때

- `this.field` → 자식 클래스의 필드
- `super.field` → 부모 클래스의 필드

### 📘 메서드를 확장(재정의)할 때

- `super.method()` → 부모 클래스의 메서드 호출
- `this.method()` → 자식 클래스의 메서드 호출

```java
class Animal2 {
    String name;
    int age;
    String breed;

    Animal2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.println("Hello " + this.name + " " + this.age);
    }
}

class Dog2 extends Animal2 {
    String breed;

    Dog2(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    void display() {
        System.out.println(this.breed);  // 자식 클래스의 breed
        System.out.println(super.breed); // 부모 클래스의 breed
    }

    @Override
    void introduce() {
        super.introduce(); // 부모 메서드 호출
        System.out.println("멍멍");
    }
}

public class SuperMain {
    public static void main(String[] args) {
        Animal2 a = new Animal2("동물", 0);
        Dog2 d = new Dog2("강아지", 3, "진돗개");

        System.out.println(a.breed);
        System.out.println(d.breed);
        d.display();
        d.introduce();
        a.introduce();
    }
}
```

---

## 🔁 오버로딩(Overloading) vs 오버라이딩(Overriding)

| 구분          | 오버로딩 (Overloading)                                | 오버라이딩 (Overriding)                        |
| ------------- | ----------------------------------------------------- | ---------------------------------------------- |
| 정의          | 같은 이름의 메서드를 **다른 매개변수**로 여러 개 정의 | 부모 클래스의 메서드를 **재정의**              |
| 적용 위치     | 같은 클래스 내                                        | 부모-자식 관계 클래스 간                       |
| 시그니처      | 매개변수 목록이 달라야 함                             | 메서드 이름, 매개변수, 반환 타입이 동일해야 함 |
| 접근 제어자   | 상관 없음                                             | 부모보다 좁은 범위로 변경 불가                 |
| static 메서드 | 가능                                                  | 재정의 불가 (별도의 메서드로 취급)             |

### 📘 오버라이딩 조건 정리

| 조건                           | 설명                                      |
| ------------------------------ | ----------------------------------------- |
| 1️⃣ 메서드 시그니처 동일        | 이름과 매개변수 정보가 같아야 함          |
| 2️⃣ 반환 타입 동일              | 동일하거나 하위 타입(공변 반환 타입) 가능 |
| 3️⃣ 접근 제어자 제한 불가       | 부모보다 좁게 변경할 수 없음              |
| 4️⃣ static 메서드는 재정의 불가 | 별도의 메서드로 간주됨                    |
| 5️⃣ `@Override` 권장            | 컴파일 시 검증 + 가독성 향상              |

---

## 📚 정리

| 항목            | 요약                                     |
| --------------- | ---------------------------------------- |
| **상속 목적**   | 코드 재사용성, 계층적 구조화             |
| **핵심 키워드** | `extends`, `super`, `@Override`          |
| **상속 범위**   | 필드, 메서드 (생성자/초기화 블록은 제외) |
| **주의점**      | 단일 상속만 가능, private 접근 불가      |

---
