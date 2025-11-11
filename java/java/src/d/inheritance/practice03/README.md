# 🧩 추상화 (Abstraction)

> 세부적인 부분은 감추고 중요한 부분만 드러내는 것
>

### 💡 일상 속 예시

- 키보드를 누르면 글자가 나타나는 **방법**은 알지만, **원리**는 몰라도 된다.
- `Integer.parseInt()`를 사용할 때 **내부 구현**은 몰라도 **기능**만 알면 된다.

---

# 🧱 추상 클래스 (Abstract Class)

> 완성되지 않은 클래스로, 하나 이상의 추상 메서드를 포함하며 직접 인스턴스 생성이 불가능
>

### 🔹 특징

- `abstract` 키워드로 선언
- 인스턴스 생성 ❌
- 추상 메서드 + 일반 메서드 모두 포함 가능
- 생성자, 필드 가질 수 있음
- 일반 클래스처럼 상속 가능

---

### 📜 추상 클래스 규칙

| 규칙 | 설명 |
| --- | --- |
| 인스턴스 생성 | ❌ 불가능 |
| 추상 메서드 | 자식 클래스에서 반드시 구현 |
| 일반 메서드 | ✅ 가능 (선택적) |
| 필드 | ✅ 가능 |
| 생성자 | ✅ 가능 (`super()` 호출 가능) |

---

### 🧮 예시 코드

```java
package d.inheritance;

abstract class Shape4 {
    String color;

    public Shape4(String color) {
        this.color = color;
    }

    void display() {
        System.out.println(color);
    }

    abstract void getArea();
    abstract void getPerimeter();
}

class Circle4 extends Shape4 {
    int radius;

    public Circle4(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    void getArea() {
        System.out.println(radius * radius * Math.PI);
    }

    @Override
    void getPerimeter() {
        System.out.println(radius * 2 * Math.PI);
    }
}

public class AbstractMain {
    public static void main(String[] args) {
        Circle4 circle = new Circle4("red", 5);
        circle.display();
        circle.getArea();
        circle.getPerimeter();
    }
}
```

---

# 🧩 추상 클래스 상속 규칙

> 추상 클래스를 상속받는 자식 클래스는
>
>
> ① 모든 추상 메서드를 구현하거나
>
> ② 자신도 추상 클래스가 되어야 함
>

---

# 🧭 추상 메서드 (Abstract Method)

> 선언만 있고 구현이 없는 메서드
>
- `abstract` 키워드로 선언
- 중괄호 `{}` 없음 → 세미콜론(`;`)으로 끝남
- 추상 클래스나 인터페이스에서만 선언 가능

---

### 💻 예시

```java
abstract class Vehicle4 { // 완전 추상 클래스
    abstract void start();
    abstract void stop();
    abstract int getSpeed();
}

class Car4 extends Vehicle4 {
    int speed;

    @Override
    void start() {
        speed = 30;
        System.out.println("차가 출발했습니다.");
    }

    @Override
    void stop() {
        speed = 0;
        System.out.println("차가 멈췄습니다.");
    }

    @Override
    int getSpeed() {
        return speed;
    }
}

class Bicycle4 extends Vehicle4 {
    int speed;

    @Override
    void start() {
        speed = 10;
        System.out.println("자전거가 출발했습니다.");
    }

    @Override
    void stop() {
        speed = 0;
        System.out.println("자전거가 멈췄습니다.");
    }

    @Override
    int getSpeed() {
        return speed;
    }
}
```

---

# 🎯 추상 메서드의 목적

| 목적 | 설명 |
| --- | --- |
| 강제 구현 | 하위 클래스에서 반드시 구현하도록 강제 |
| 인터페이스 통일 | 모든 하위 클래스가 동일한 메서드 제공 |
| 다형성 활용 | 상위 타입으로 다양한 하위 타입 객체 다룸 |

---

### 💾 예시: 데이터베이스 연결 추상화

```java
abstract class DatabaseConnection {
    String connectionString;

    DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    // 공통 로직
    void log(String message) {
        System.out.println("[LOG] " + message);
    }

    // 강제 구현
    abstract void connect();
    abstract void disconnect();
    abstract void executeQuery(String query);
}

class MySQLConnection extends DatabaseConnection {
    MySQLConnection(String connectionString) {
        super(connectionString);
    }

    @Override
    void connect() {
        log("MySQL 연결: " + connectionString);
    }

    @Override
    void disconnect() {
        log("MySQL 연결 종료");
    }

    @Override
    void executeQuery(String query) {
        log("MySQL 쿼리 실행: " + query);
    }
}

class MongoDBConnection extends DatabaseConnection {
    MongoDBConnection(String connectionString) {
        super(connectionString);
    }

    @Override
    void connect() {
        log("MongoDB 연결: " + connectionString);
    }

    @Override
    void disconnect() {
        log("MongoDB 연결 종료");
    }

    @Override
    void executeQuery(String query) {
        log("MongoDB 쿼리 실행: " + query);
    }
}
```

---

# 🧩 템플릿 메서드 패턴 (Template Method Pattern)

> 알고리즘의 골격을 정의하고,
>
>
> 일부 단계를 **하위 클래스에서 구현**하도록 하는 디자인 패턴
>

---

### 💻 예시

```java
abstract class DataProcessor {
    // **템플릿 메서드** (final로 오버라이딩 방지)
    public final void process() {
        readData();
        processData();
        writeData();
    }

    // 추상 메서드: 하위 클래스에서 구현
    abstract void readData();
    abstract void processData();
    abstract void writeData();
}

class CSVProcessor extends DataProcessor {
    @Override
    void readData() {
        System.out.println("CSV 파일에서 데이터 읽기");
    }

    @Override
    void processData() {
        System.out.println("CSV 데이터 처리");
    }

    @Override
    void writeData() {
        System.out.println("결과를 CSV로 저장");
    }
}

class JSONProcessor extends DataProcessor {
    @Override
    void readData() {
        System.out.println("JSON 파일에서 데이터 읽기");
    }

    @Override
    void processData() {
        System.out.println("JSON 데이터 처리");
    }

    @Override
    void writeData() {
        System.out.println("결과를 JSON으로 저장");
    }
}

public class TemplateMethodExample {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.process();

        System.out.println();

        DataProcessor jsonProcessor = new JSONProcessor();
        jsonProcessor.process();
    }
}
```

---

# 🧠 추상 클래스를 사용해야 할 때

- 공통 코드 공유가 필요할 때
- 일부만 구현하고 나머지는 강제하고 싶을 때
- `protected` 멤버로 하위 클래스 접근을 제어할 때
- 생성자나 초기화 로직이 필요할 때

---

# ⚖️ 일반 클래스 vs 추상 클래스

| 구분 | 일반 클래스 | 추상 클래스 |
| --- | --- | --- |
| 인스턴스 생성 | 가능 | ❌ 불가능 |
| 추상 메서드 | 없음 | 가능 |
| 일반 메서드 | 가능 | 가능 |
| 필드 | 가능 | 가능 |
| 생성자 | 가능 | 가능 |
| 다중 상속 | 불가능 | 불가능 |
| 접근 제어자 | 모두 가능 | 모두 가능 |

---
# 💡 인터페이스 (Interface)

> 기능 명세서 역할을 하는 추상 타입
>
>
> “무엇을 할 것인가”를 정의하고, “어떻게 할 것인가”는 구현 클래스에 맡김
>

---

## 🧠 기본 개념

- **어원**
    - Interface = 서로 다른 대상이 맞닿은 면
    - 예:
        - GUI (Graphical User Interface)
        - CLI (Command Line Interface)
- **역할**
    - 클래스가 어떤 메서드를 **구현해야 하는지** 정의
    - 구현 클래스들을 **하나의 타입**으로 다루기 위한 규약
    - 자바의 단일 상속 제한을 **다중 구현**으로 보완

---

## ⚙️ 특징

- 모든 메서드는 기본적으로 `public abstract` (Java 8 이전)
- 모든 필드는 `public static final` (상수)
- 인스턴스 생성 불가
- 다중 구현 가능
- 인터페이스 간 **다중 상속** 가능

---

## ⚠️ 주의사항

- 인터페이스 메서드는 `public abstract` (생략 가능)
- 구현 시 **반드시 public** 으로 오버라이딩해야 함

---

# ⚔️ 인터페이스 vs 추상 클래스

| 구분 | 인터페이스 | 추상 클래스 |
| --- | --- | --- |
| 메서드 | 추상 메서드 (기본) | 추상 + 일반 메서드 |
| 필드 | 상수만 가능 | 모든 필드 가능 |
| 생성자 | 없음 | 있음 |
| 다중 상속 | 가능 (다중 구현) | 불가능 |
| 접근 제어자 | public (기본) | 모두 가능 |
| 목적 | 기능 명세 | 공통 기능 제공 |

---

# 🧩 implements 키워드

> implements 키워드를 사용하여 인터페이스를 구현합니다.
>

---

## 📜 구현 규칙

- 모든 추상 메서드를 **구현해야 함**
- 구현 메서드는 **public** 이어야 함
- 여러 인터페이스 **동시 구현 가능**
- 일부만 구현하려면 클래스에 `abstract` 선언

---

### 💻 예시

```java
interface Animal6 {
    void run();
    void sleep();
    void eat();
}

class Dog6 implements Animal6 {
    @Override
    public void run() {}

    @Override
    public void sleep() {}

    @Override
    public void eat() {}
}
```

---

# 🧬 다중 구현과 상속

> 클래스는 단일 상속, 인터페이스는 다중 구현 가능
>

```java
package d.inheritance;

interface Swimmable {
    void swim();
}

interface Flyable {
    void fly();
}

interface Walkable {
    void walk();
}

class Animal7 {
    void eat() { System.out.println("eating"); }
}

class Duck extends Animal7 implements Swimmable, Flyable, Walkable {
    @Override
    public void fly() {}

    @Override
    public void swim() {}

    @Override
    public void walk() {}
}

class Fish extends Animal7 implements Swimmable {
    @Override
    public void swim() {}
}

public class MultiInterfaceMain {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Fish fish = new Fish();
    }
}
```

---

# 🧱 인터페이스 상속

> 인터페이스는 다른 인터페이스를 상속할 수 있으며,
>
>
> **다중 상속**도 가능하다.
>

---

### 💻 예시

```java
interface Animal {
    void eat();
}

interface Mammal extends Animal {
    void giveBirth();
}

interface Pet extends Animal {
    void play();
}

// 여러 인터페이스 상속
interface DomesticAnimal extends Mammal, Pet {
    void followOwner();
}

class Dog implements DomesticAnimal {
    @Override
    public void eat() {
        System.out.println("먹이를 먹습니다");
    }

    @Override
    public void giveBirth() {
        System.out.println("새끼를 낳습니다");
    }

    @Override
    public void play() {
        System.out.println("놀이를 합니다");
    }

    @Override
    public void followOwner() {
        System.out.println("주인을 따라갑니다");
    }
}
```

---

# ⚙️ 디폴트 메서드 (Java 8+)

> 인터페이스에 구현이 포함된 메서드를 정의할 수 있음
>

---

### 🧩 등장 배경

- 부모 인터페이스에 메서드를 추가하면 기존 구현 클래스에서 **컴파일 오류 발생**
- 이를 방지하기 위해 `default` 메서드 도입

---

### ✅ 특징

- 구현 클래스는 선택적으로 **오버라이딩 가능**
- 기존 코드 수정 불필요
- **하위 호환성 유지** 및 **코드 재사용성 향상**

---

### 💻 예시

```java
public interface Parent {
    void method();

    **// default 메서드 - 구현 제공
    default void newMethod() {
        System.out.println("기본 구현");
    }**
}

public class Child1 implements Parent {
    @Override
    public void method() {
        System.out.println("Child1");
    }
    // newMethod()는 오버라이딩 안 해도 됨
}

public class Child2 implements Parent {
    @Override
    public void method() {
        System.out.println("Child2");
    }

    @Override
    public void newMethod() {  // 필요하면 오버라이딩
        System.out.println("Child2의 새로운 구현");
    }
}
```

---

# 🧮 정적 메서드 (Java 8+)

> 인터페이스에서도 static 메서드 정의 가능
>
>
> (이전에는 `Collections` 같은 별도 유틸 클래스 필요)
>

---

### 💻 예시

```java
interface Calculator {
    int calculate(int a, int b);

    // static 메서드
    static void printInfo() {
        System.out.println("계산기 인터페이스입니다.");
    }

    static int add(int a, int b) {
        return a + b;
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        Calculator.printInfo();  // 인터페이스명.메서드명()
        int result = Calculator.add(5, 3);
        System.out.println(result);  // 8
    }
}
```

---

### ⚖️ 정적 메서드 vs 디폴트 메서드

| 구분 | 정적 메서드 | 디폴트 메서드 |
| --- | --- | --- |
| 호출 방법 | 인터페이스명.메서드() | 인스턴스.메서드() |
| 오버라이딩 | 불가능 | 가능 |
| 목적 | 유틸리티 메서드 제공 | 기본 구현 제공 |

---

# 🔒 private 메서드 (Java 9+)

> default / static 메서드 간의 중복 코드 제거를 위해 사용 가능
>

---

### 💻 예시

```java
// 문제: default/static 메서드의 코드 중복
public interface Logger {
    default void logInfo(String message) {
        System.out.println("[INFO] " + message);
        System.out.println("시간: " + System.currentTimeMillis());
    }

    default void logError(String message) {
        System.out.println("[ERROR] " + message);
        System.out.println("시간: " + System.currentTimeMillis());  // 중복!
    }
}

// 해결: private 메서드 사용
public interface Logger {
    default void logInfo(String message) {
        log("INFO", message);
    }

    default void logError(String message) {
        log("ERROR", message);
    }

    **// private 메서드로 중복 제거
    private void log(String level, String message) {
        System.out.println("[" + level + "] " + message);
        System.out.println("시간: " + System.currentTimeMillis());
    }**
}
```

---

# 🧭 요약

| 기능 | 자바 버전 | 설명 |
| --- | --- | --- |
| 기본 인터페이스 | Java 1.0 | 추상 메서드만 가능 |
| 디폴트 메서드 | Java 8 | 기본 구현 제공 |
| 정적 메서드 | Java 8 | 유틸성 메서드 제공 |
| private 메서드 | Java 9 | 내부 코드 중복 제거 |

---

---

# **컴포지션(Composition) & 위임(Delegation)**

---

## **1. 컴포지션(Composition)**

- **정의**: 한 클래스가 다른 클래스의 인스턴스를 **필드로 포함**하는 설계 방식
- **관계 표현**: `has-a` (상속의 `is-a`와 대비)
- **장점**
    - 유연한 설계 가능 (런타임 동작 변경 가능)
    - 다중 기능 조합 가능
    - 캡슐화 유지

---

### **예제: 자동차와 엔진**

```java
class Engine {
    private int horsepower;
    private String type;

    Engine(int horsepower, String type) {
        this.horsepower = horsepower;
        this.type = type;
    }

    void start() {
        System.out.println(type + " 엔진 시작 (" + horsepower + "마력)");
    }

    void stop() {
        System.out.println("엔진 정지");
    }
}

class Car {
    private String model;
    **private Engine engine;  // 컴포지션: Car는 Engine을 포함**

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    void start() {
        System.out.println(model + " 시동 걸기");
        engine.start();  // Engine 기능 활용
    }

    void stop() {
        engine.stop();
        System.out.println(model + " 시동 끄기");
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Engine **v6Engine** = new Engine(300, "V6");
        Car myCar = new Car("제네시스", **v6Engine**);

        myCar.start();
        myCar.stop();
    }
}
```

---

### **예제: 캐릭터와 무기 (런타임 동작 변경)**

```java
interface WeaponBehavior {
    void useWeapon();
}

class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("검으로 베기!");
    }
}

class BowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("활로 쏘기!");
    }
}

class MagicBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("마법 시전!");
    }
}

class Character {
    private String name;
    private WeaponBehavior weapon;  // 컴포지션

    Character(String name, WeaponBehavior weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
        System.out.println(name + "이(가) 무기를 교체했습니다.");
    }

    void attack() {
        System.out.print(name + ": ");
        weapon.useWeapon();
    }
}

public class WeaponExample {
    public static void main(String[] args) {
        Character warrior = new Character("전사", new SwordBehavior());
        warrior.attack();

        warrior.setWeapon(new BowBehavior());  // 런타임에 무기 변경
        warrior.attack();

        warrior.setWeapon(new MagicBehavior());
        warrior.attack();
    }
}
```

---

## **2. 위임(Delegation)**

- **정의**: 컴포지션의 일종으로, **한 객체가 다른 객체에게 작업을 맡기는 것**
- **핵심 아이디어**: Logger가 Printer에게 실제 작업(`print`)을 넘겨서 처리하도록 함
- **장점**
    - 런타임에 동작 변경 가능 (`ConsolePrinter` → `FilePrinter`)
    - 책임 분리, 코드 재사용 가능

### **포인트**

1. `Logger`는 **인터페이스 타입 Printer**를 사용

    ```java
    private Printer printer;
    ```

   → 이렇게 하면 Logger는 Printer를 구현한 어떤 클래스든 사용할 수 있음

2. 실제 동작은 `Printer`를 구현한 객체에게 위임

    ```java
    printer.print(timestamp + " - " + message);
    ```

3. **제한 사항**
    - 만약 `ConsolePrinter`나 `FilePrinter`에 **인터페이스에 없는 커스텀 메서드**가 있다면

        ```java
        ConsolePrinter console = new ConsolePrinter();
        console.customMethod(); // 가능
        ```

    - Logger를 통해서는 사용할 수 없음

        ```java
        Logger logger = new Logger(new ConsolePrinter());
        logger.printer.customMethod(); // 불가 (printer는 Printer 타입이기 때문)
        ```


    → 따라서 커스텀 메서드는 별도 인스턴스를 만들어 직접 호출해야 함


---

### **예제: 로그 출력**

```java
interface Printer {
    void print(String message);
}

class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("[콘솔] " + message);
    }
}

class FilePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("[파일에 저장] " + message);
    }
}

class Logger {
    **private Printer printer;  // 위임 대상, 인터페이스도 하나의 자료형**

    Logger(Printer printer) {
        this.printer = printer;
    }

    void setPrinter(Printer printer) {
        this.printer = printer;
    }

    void log(String message) {
        String timestamp = java.time.LocalDateTime.now().toString();
        printer.print(timestamp + " - " + message);  // 위임
    }
}

public class DelegationExample {
    public static void main(String[] args) {
		    // **Printer** print = new **ConsolePrinter**(); 
		    // Logger logger = new Logger(print);
        Logger logger = new Logger(**new ConsolePrinter()**);
        logger.log("애플리케이션 시작");

				// **Printer** print = new **FilePrinter**(); 
		    // Logger logger = new Logger(print);
        logger.setPrinter(**new FilePrinter()**); // 런타임에 출력 방식 변경
        logger.log("파일로 로그 전환");
    }
}
```

---

### **정리**

| 개념 | 특징 | 장점 |
| --- | --- | --- |
| 컴포지션 | 한 클래스가 다른 클래스 인스턴스를 포함 (`has-a`) | 유연한 설계, 다중 기능 조합, 캡슐화 유지 |
| 위임 | 다른 객체에게 작업을 맡김 | 런타임 동작 변경 가능, 책임 분리, 코드 재사용 |
