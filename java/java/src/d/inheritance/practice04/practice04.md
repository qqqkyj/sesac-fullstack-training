## 문제 1: 도형 그리기 시스템

`Drawable` 인터페이스를 구현하세요.

**요구사항:**

1. **`Drawable` 인터페이스 작성:**
    - `void draw()`: 도형 그리기 메서드

2. **`Circle` 클래스 작성:**
    - `Drawable` 구현
    - `private int radius` - 반지름
    - `Circle(int radius)` - 생성자
    - `draw()` 구현: "반지름 [radius]인 원을 그립니다" 출력

3. **`Rectangle` 클래스 작성:**
    - `Drawable` 구현
    - `private int width, height` - 가로, 세로
    - `Rectangle(int width, int height)` - 생성자
    - `draw()` 구현: "[width]x[height] 사각형을 그립니다" 출력

4. **`Triangle` 클래스 작성:**
    - `Drawable` 구현
    - `private int base, height` - 밑변, 높이
    - `Triangle(int base, int height)` - 생성자
    - `draw()` 구현: "밑변 [base], 높이 [height]인 삼각형을 그립니다" 출력

**테스트 코드:**
```java
public class Main {
    public static void main(String[] args) {
        Drawable[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Triangle(3, 4)
        };

        for (Drawable shape : shapes) {
            shape.draw();
        }
    }
}
```

**예상 출력:**
```
반지름 5인 원을 그립니다
4x6 사각형을 그립니다
밑변 3, 높이 4인 삼각형을 그립니다
```

## 문제 2: 결제 시스템 프로젝트

다양한 결제 수단을 지원하는 시스템을 구현하세요.

**요구사항:**

1. **`Payment` 인터페이스 작성:**
    - `void processPayment(int amount)`: 결제 처리 (추상 메서드)
    - `String getPaymentMethod()`: 결제 수단 이름 반환 (추상 메서드)
    - `default void printReceipt(int amount)`: 디폴트 메서드
        - "영수증: [amount]원 - [결제수단]" 출력

2. **`CreditCardPayment` 클래스 작성:**
    - `Payment` 구현
    - `private String cardNumber` - 카드 번호
    - `CreditCardPayment(String cardNumber)` - 생성자
    - `processPayment()` 구현: "신용카드([cardNumber])로 [amount]원 결제 완료" 출력
    - `getPaymentMethod()` 구현: "신용카드" 반환

3. **`CashPayment` 클래스 작성:**
    - `Payment` 구현
    - `processPayment()` 구현: "현금 [amount]원 결제 완료" 출력
    - `getPaymentMethod()` 구현: "현금" 반환

**테스트 코드:**
```java
public class Main {
    public static void main(String[] args) {
        Payment[] payments = {
            new CreditCardPayment("1234-5678"),
            new CashPayment()
        };

        int amount = 50000;
        for (Payment payment : payments) {
            payment.processPayment(amount);
            payment.printReceipt(amount);
            System.out.println();
        }
    }
}
```

**예상 출력:**
```
신용카드(1234-5678)로 50000원 결제 완료
영수증: 50000원 - 신용카드

현금 50000원 결제 완료
영수증: 50000원 - 현금
```

## 문제 3: 동물 능력 시스템

다중 인터페이스 구현을 연습하는 문제입니다.

**요구사항:**

1. **`Swimmable` 인터페이스 작성:**
    - `void swim()`: 수영 메서드

2. **`Flyable` 인터페이스 작성:**
    - `void fly()`: 비행 메서드

3. **`Duck` 클래스 작성:**
    - `Swimmable`, `Flyable` 모두 구현
    - `private String name` - 이름
    - `Duck(String name)` - 생성자
    - `swim()` 구현: "[name]이(가) 수영합니다" 출력
    - `fly()` 구현: "[name]이(가) 날아갑니다" 출력

4. **`Fish` 클래스 작성:**
    - `Swimmable`만 구현
    - `private String name` - 이름
    - `Fish(String name)` - 생성자
    - `swim()` 구현: "[name]이(가) 헤엄칩니다" 출력

5. **`Bird` 클래스 작성:**
    - `Flyable`만 구현
    - `private String name` - 이름
    - `Bird(String name)` - 생성자
    - `fly()` 구현: "[name]이(가) 하늘을 날아갑니다" 출력

**테스트 코드:**
```java
public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck("오리");
        duck.swim();
        duck.fly();
        System.out.println();

        Fish fish = new Fish("물고기");
        fish.swim();
        System.out.println();

        Bird bird = new Bird("참새");
        bird.fly();
    }
}
```

**예상 출력:**
```
오리이(가) 수영합니다
오리이(가) 날아갑니다

물고기이(가) 헤엄칩니다

참새이(가) 하늘을 날아갑니다
```