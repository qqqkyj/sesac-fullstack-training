## 문제 1: Person 클래스 만들기 

이름(name), 나이(age)를 속성으로 가지는 `Person` 클래스를 구현하세요.

**요구사항:**
- 생성자로 이름과 나이 초기화
- 정보를 출력하는 `printInfo()` 메서드 작성

**예상 출력:**
```
이름: 홍길동, 나이: 25세
```

**테스트 코드:**
```java
Person person = new Person("홍길동", 25);
person.printInfo();
```

## 문제 2: Dog 클래스 만들기

견종(breed), 이름(name)을 속성으로 가지고, "앉아"(`sit()`), "손"(`hand()`) 기능을 가진 `Dog` 클래스를 구현하세요.

**예상 출력:**
```
진돗개 백구가 앉았습니다.
진돗개 백구가 손을 내밀었습니다.
```

**테스트 코드:**
```java
Dog dog = new Dog("진돗개", "백구");
dog.sit();
dog.hand();
```

## 문제 3: Car 클래스 

다음 요구사항에 맞는 `Car` 클래스를 구현하세요.

**속성:**
- 모델명(model)
- 속도(speed)

**기능:**
- `accelerate()`: 속도 10 증가
- `brake()`: 속도 10 감소
- `printInfo()`: 모델명과 현재 속도 출력

**테스트 코드:**
```java
Car car = new Car("Avante", 0);
car.accelerate();  // 속도 10
car.accelerate();  // 속도 20
car.accelerate();  // 속도 30
car.brake();       // 속도 20
car.printInfo();   // 모델: Avante, 속도: 20km/h
```

## 문제 4: BankAccount 클래스

은행 계좌를 나타내는 클래스를 만드세요.

**요구사항:**
- 필드: accountNumber (String), balance (int)
- 생성자: 계좌번호와 초기 잔액을 받는 생성자
- 메서드:
    - deposit(int amount): 입금
    - withdraw(int amount): 출금
    - getBalance(): 잔액 반환

**예상 출력:**
```
입금 10000원, 잔액: 10000원
출금 3000원, 잔액: 7000원
```

## 문제 5: Counter 클래스

카운터를 나타내는 클래스를 만드세요.

**요구사항:**
- 필드: count (int)
- 생성자: 기본값 0으로 초기화
- 메서드:
    - increment(): count 1 증가
    - decrement(): count 1 감소
    - getCount(): count 반환
    - reset(): count를 0으로 리셋
