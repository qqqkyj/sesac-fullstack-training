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

# 💡 **final & Object 클래스 정리**

## 🔒 **final 키워드**

`final`은 **상속과 오버라이딩을 제어**하고, **불변성**을 보장하기 위해 사용됩니다.

### ✅ 사용 목적

| 사용 위치  | 의미                              |
| ---------- | --------------------------------- |
| **변수**   | 값을 변경할 수 없음 (상수로 사용) |
| **메서드** | 오버라이딩 불가                   |
| **클래스** | 상속 불가                         |

### 🧩 주요 특징

- `final` **메서드** → 자식 클래스에서 **재정의(오버라이딩)** 할 수 없음
- `final` **클래스** → 다른 클래스가 **상속할 수 없음**
- **불변성 보장** → 값이나 동작을 변경하지 못하도록 보호
- **보안 강화** 및 **설계 의도 명확화**에 사용됨

### 📘 예시

```java
final class Constants {
    final int MAX_VALUE = 100;
}

// ❌ 상속 불가
// class ExtendedConstants extends Constants { } // 컴파일 에러 발생

class Base {
    final void print() {
        System.out.println("Cannot override this method.");
    }
}

class Derived extends Base {
    // ❌ 오버라이딩 불가
    // void print() { ... } // 컴파일 에러 발생
}
```

---

## 🧱 **Object 클래스**

자바에서 **모든 클래스는 암묵적으로 `Object` 클래스를 상속**합니다.

즉, `Object`는 **클래스 계층 구조의 최상위 클래스**입니다.

```java
class MyClass {
    // 내부적으로는 class MyClass extends Object
}
```

---

### 🧩 **Object 클래스의 주요 메서드**

| 메서드               | 설명                                                      |
| -------------------- | --------------------------------------------------------- |
| `toString()`         | 객체의 문자열 표현 반환                                   |
| `equals(Object obj)` | 객체의 **내용(동등성)** 비교                              |
| `hashCode()`         | 객체의 **해시 코드** 반환 (equals와 함께 오버라이드 권장) |
| `getClass()`         | 객체의 클래스 타입 정보 반환                              |
| `clone()`            | 객체 복사 (얕은 복사)                                     |

---

## 🧪 **예제: Object 메서드 오버라이딩**

```java
package d.inheritance;

import java.util.Objects;

class MyObject /* extends Object */ {
    String name;
    int value;

    public MyObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // ✅ 객체의 문자열 표현
    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    // ✅ 객체 동등성 비교
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return value == myObject.value && Objects.equals(name, myObject.name);
    }

    // ✅ equals()와 함께 항상 오버라이드해야 함
    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }
}

public class ObjectMain {
    public static void main(String[] args) {
        MyObject obj = new MyObject("test", 100);
        System.out.println(obj); // 자동으로 toString() 호출
        // 출력: MyObject{name='test', value=100}

        MyObject obj2 = new MyObject("test", 101);
        System.out.println(obj.equals(obj2)); // false (값 비교)
    }
}
```

---

## 🔍 실행 결과

```
MyObject{name='test', value=100}
false
```

---

## ⚙️ equals()와 hashCode()의 관계

- `equals()`를 오버라이드하면 **항상 `hashCode()`도 함께 오버라이드**해야 합니다.
- 그 이유는, 두 객체가 `equals()`로 같다고 판정되면
  → 반드시 같은 `hashCode()` 값을 가져야 하기 때문입니다.

| 메서드       | 역할                                                      |
| ------------ | --------------------------------------------------------- |
| `equals()`   | 객체의 **내용이 같은지** 비교                             |
| `hashCode()` | 객체의 **식별 코드** 반환 (해시 기반 자료구조에서 사용됨) |

---

## 🧠 정리 요약

| 구분                          | 설명                              |
| ----------------------------- | --------------------------------- |
| **`final` 변수**              | 값 변경 불가 (상수)               |
| **`final` 메서드**            | 오버라이딩 불가                   |
| **`final` 클래스**            | 상속 불가                         |
| **`Object` 클래스**           | 자바 클래스 계층의 최상위 클래스  |
| **`toString()`**              | 객체 정보를 문자열로 표현         |
| **`equals()` / `hashCode()`** | 객체 동등성 비교 / 해시 코드 계산 |
| **`getClass()`**              | 클래스 정보 반환                  |
| **`clone()`**                 | 객체 복사                         |

---

# 💡 **다형성 (Polymorphism)**

## 📘 개념

- \*다형성(Polymorphism)\*\*이란
  상위 타입의 참조 변수가 **하위 타입 객체를 참조할 수 있는 특성**을 말합니다.
- “여러 형태(Poly + Morph)를 가진다”는 의미로,
  하나의 타입으로 여러 객체를 **유연하게 처리**할 수 있습니다.

---

## 🧩 다형성의 장점

| 특징              | 설명                                           |
| ----------------- | ---------------------------------------------- |
| **코드의 유연성** | 다양한 객체를 한 타입으로 다룰 수 있음         |
| **확장성**        | 새로운 타입 추가 시 기존 코드 수정 최소화      |
| **재사용성**      | 배열, 컬렉션 등으로 여러 객체를 일괄 관리 가능 |

---

## ⚙️ 업캐스팅 (Upcasting)

### 🔹 정의

- 하위 타입의 객체를 **상위 타입으로 참조**하는 것
- 형 변환 **생략 가능 (자동 변환)**
- **안전한 형변환** — 컴파일러가 타입 호환을 보장
- 단, **하위 타입 고유 멤버에는 접근 불가**

### 📘 예제

```java
package d.inheritance;

class Animal3 {
    void makeSound() {
        System.out.println("소리를 냅니다.");
    }
}

class Dog3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("멍멍!");
    }
}

class Cat3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("야옹!");
    }
}

class Bird3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("짹짹!");
    }
}

class Rabbit3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("깡총!");
    }
}

public class PolyMain {
    public static void main(String[] args) {
        // 다양한 하위 클래스 객체를 상위 타입(Animal3) 배열에 담기
        Animal3[] animals = { new Dog3(), new Cat3(), new Bird3(), new Rabbit3() };

        for (Animal3 animal : animals) {
            soundAnimal(animal);
        }
    }

    static void soundAnimal(Animal3 animal) {
        animal.makeSound(); // 각 타입의 오버라이딩된 메서드 실행
    }
}
```

### 🧠 실행 결과

```
멍멍!
야옹!
짹짹!
깡총!
```

📍

- 같은 `makeSound()` 호출이지만,
  실제 객체의 타입에 따라 **다르게 동작**합니다. (→ **동적 바인딩**)

---

## ⚙️ 다운캐스팅 (Downcasting)

### 🔹 정의

- 상위 타입으로 참조된 객체를 **다시 하위 타입으로 변환**하는 것
- 형 변환 **명시 필요 (수동 변환)**
- 잘못된 변환 시 `ClassCastException` 발생 가능
- 하위 타입의 **고유 멤버(필드, 메서드)** 접근 가능

### 📘 예제

```java
package d.inheritance;

class Animal3 {
    void makeSound() {
        System.out.println("소리를 냅니다.");
    }
}

class Dog3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("멍멍!");
    }

    void bark() {
        System.out.println("왈왈!!");
    }
}

class Cat3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("야옹!");
    }

    void meow() {
        System.out.println("미야오!");
    }
}

class Bird3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("짹짹!");
    }
}

class Rabbit3 extends Animal3 {
    @Override
    void makeSound() {
        System.out.println("깡총!");
    }
}

public class PolyMain {
    public static void main(String[] args) {
        // ✅ 업캐스팅
        Animal3 a = new Dog3();
        a.makeSound();   // 멍멍!

        // ✅ 다운캐스팅 (명시적 형변환)
        ((Dog3) a).bark(); // 왈왈!!

        Animal3 c1 = new Cat3();
        Cat3 c2 = (Cat3) c1; // 다운캐스팅
        c2.meow();           // 미야오!
    }
}
```

### 🧠 실행 결과

```
멍멍!
왈왈!!
미야오!
```

---

## ⚠️ 다운캐스팅 주의사항

잘못된 타입으로 캐스팅하면 예외 발생!

```java
Animal3 a = new Dog3();
Cat3 c = (Cat3) a; // ❌ 런타임 오류 (ClassCastException)
```

> 💡 안전하게 캐스팅하려면 instanceof 연산자를 사용해야 합니다.

```java
if (a instanceof Dog3) {
    ((Dog3) a).bark();
}
```

---

## 🧠 다형성 정리

| 구분           | 업캐스팅 (Upcasting) | 다운캐스팅 (Downcasting)        |
| -------------- | -------------------- | ------------------------------- |
| 변환 방향      | 하위 → 상위          | 상위 → 하위                     |
| 형변환 여부    | 자동 변환            | 명시적 변환 필요                |
| 안전성         | 안전 (컴파일러 보장) | 위험 (런타임 예외 가능)         |
| 접근 가능 범위 | 부모 클래스 멤버만   | 자식 클래스 고유 멤버 접근 가능 |
| 주요 사용 목적 | 다형성 구현          | 특정 타입 기능 사용             |

---

## 🧩 정리 요약

| 항목                     | 설명                                                    |
| ------------------------ | ------------------------------------------------------- |
| **다형성(Polymorphism)** | 상위 타입으로 다양한 하위 타입 객체를 다룰 수 있는 특성 |
| **장점**                 | 코드 유연성, 확장성, 재사용성 향상                      |
| **업캐스팅**             | 하위 → 상위, 자동 변환, 안전                            |
| **다운캐스팅**           | 상위 → 하위, 명시적 변환, 예외 위험 있음                |
| **핵심 키워드**          | `extends`, `@Override`, `instanceof`                    |

---

## 🧩 **instanceof 연산자**

### ✅ 개념

- 객체가 **특정 타입인지 확인**할 때 사용하는 연산자
- 상속 구조에서 **안전한 다운캐스팅**을 위해 자주 사용됨

### 🔹 사용법

```java
object instanceof Type
```

- 결과값:
  - `true` → 해당 타입이거나 **그 하위 타입**
  - `false` → 해당 타입이 아님

---

### 📘 예제

```java
public class PhoneProcessor {
    public static void usePhone(Phone phone) {
        phone.powerOn();  // ✅ 다형성

        if (phone instanceof iPhone) {
            iPhone iPhone = (iPhone) phone;
            iPhone.useFaceID(); // iPhone 전용 기능
        } else if (phone instanceof Galaxy) {
            Galaxy galaxy = (Galaxy) phone;
            galaxy.useSPen();   // Galaxy 전용 기능
        }
    }

    public static void main(String[] args) {
        Phone[] phones = {
            new iPhone(),
            new Galaxy(),
            new iPhone()
        };

        for (Phone phone : phones) {
            usePhone(phone);
            System.out.println();
        }
    }
}
```

### 🧠 동작 설명

1. `usePhone()`은 `Phone` 타입 하나로 모든 하위 객체 처리 가능 (다형성)
2. 실제 객체 타입이 무엇인지 `instanceof`로 확인
3. 안전하게 다운캐스팅 후, 각 객체의 고유 기능 사용 가능

---

### ⚙️ 실행 결과 (예시)

```
iPhone is powering on!
using FaceID

Galaxy is powering on!
using SPen

iPhone is powering on!
using FaceID
```

---

### 🧠 요약

| 구분          | 설명                       |
| ------------- | -------------------------- |
| **연산자**    | `instanceof`               |
| **목적**      | 객체 타입 검사             |
| **반환값**    | boolean (`true` / `false`) |
| **주요 용도** | 다운캐스팅 전 타입 체크    |
| **주의점**    | 상속 관계에서만 의미 있음  |

---

## ⚡ **정적 바인딩(Static Binding) vs 동적 바인딩(Dynamic Binding)**

### 📘 개념 비교

| 구분          | 정적 바인딩 (Static Binding) | 동적 바인딩 (Dynamic Binding) |
| ------------- | ---------------------------- | ----------------------------- |
| **시점**      | 컴파일 타임                  | 런타임                        |
| **대상**      | 오버로딩된 메서드, 필드      | 오버라이딩된 메서드           |
| **결정 기준** | 참조 변수의 타입             | 실제 객체의 타입              |
| **성능**      | 빠름                         | 상대적으로 느림               |
| **대표 예시** | 필드, 오버로딩               | 오버라이딩 (다형성)           |

---

## 🐾 **동적 바인딩 예제**

```java
class Animal {
    void makeSound() {
        System.out.println("동물 소리");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("멍멍!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("야옹!");
    }
}

public class DynamicBinding {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog(),
            new Cat(),
            new Dog()
        };

        for (Animal animal : animals) {
            // 컴파일 시점: Animal.makeSound() 호출 계획 (정적 바인딩)
            // 런타임 시점: 실제 객체의 makeSound() 실행 (동적 바인딩)
            animal.makeSound();
        }
    }
}
```

### 🧠 실행 결과

```
멍멍!
야옹!
멍멍!
```

📍

- **컴파일 시점**에는 `Animal`의 `makeSound()`가 호출될 것처럼 보이지만
- **실행 시점**에는 실제 객체(`Dog`, `Cat`)의 오버라이딩된 메서드가 실행됨
  → 이것이 **동적 바인딩(Dynamic Binding)**

---

## 📘 **정적 바인딩 예제 (필드)**

```java
class Parent {
    String field = "Parent field";
}

class Child extends Parent {
    String field = "Child field";
}

public class FieldBinding {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.field);  // Parent field → 정적 바인딩

        Child c = (Child) p;
        System.out.println(c.field);  // Child field
    }
}
```

### 🧠 실행 결과

```
Parent field
Child field
```

📍

- \*필드(Field)\*\*는 오버라이딩이 불가능하므로
  **참조 타입 기준으로 접근** → **정적 바인딩**

---

## 🔍 정리 요약

| 구분              | 설명                                        |
| ----------------- | ------------------------------------------- |
| **instanceof**    | 객체 타입 확인 연산자 (`true`/`false` 반환) |
| **정적 바인딩**   | 컴파일 시점에 결정 (필드, 오버로딩)         |
| **동적 바인딩**   | 런타임 시점에 결정 (오버라이딩된 메서드)    |
| **다형성과 관계** | 다형성은 **동적 바인딩**을 통해 구현됨      |
| **주의사항**      | 다운캐스팅 시 `instanceof`로 타입 체크 필수 |

---
