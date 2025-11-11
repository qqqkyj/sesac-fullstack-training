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

