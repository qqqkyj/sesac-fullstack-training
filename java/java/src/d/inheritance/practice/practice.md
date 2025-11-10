## 문제 1: 학생 클래스 상속

`Person` 클래스를 상속받는 `Student` 클래스를 작성하세요.

**요구사항:**
- `Person` 클래스: `name`, `age` 필드와 `introduce()` 메서드
- `Student` 클래스: `studentId`, `major` 필드 추가
- `Student`의 생성자는 모든 필드를 초기화
- `introduce()` 메서드를 오버라이딩하여 학생 정보 출력

**예상 출력:**
```
안녕하세요, 저는 김철수입니다. 20살이고, 학번은 2024001이며, 컴퓨터공학을 전공합니다.
```

## 문제 2: 계좌 시스템

은행 계좌 시스템을 구현하세요.

**요구사항:**
- `Account` 클래스: `accountNumber`, `balance` 필드
    - `deposit(double amount)`: 입금
    - `withdraw(double amount)`: 출금
- `SavingsAccount` 클래스: `Account` 상속
    - `interestRate` 필드 추가
    - `addInterest()`: 이자 추가 메서드
- `CheckingAccount` 클래스: `Account` 상속
    - `overdraftLimit` 필드 추가 (마이너스 한도)
    - `withdraw()` 오버라이딩: 마이너스 한도까지 출금 가능

**테스트 코드:**
```java
SavingsAccount savings = new SavingsAccount("SA001", 1000000, 0.03);
savings.deposit(500000);
savings.addInterest();
System.out.println("저축예금 잔액: " + savings.balance);

CheckingAccount checking = new CheckingAccount("CA001", 100000, 500000);
checking.withdraw(400000);
System.out.println("입출금예금 잔액: " + checking.balance);
```
## 문제 3: 차량 렌탈 시스템

차량 렌탈 시스템을 구현하세요.

**요구사항:**
- `Vehicle` 클래스: `model`, `dailyRate` 필드
    - `calculateRentalCost(int days)`: 대여 비용 계산
- `Car` 클래스: `Vehicle` 상속
    - `hasGPS` 필드 (GPS 장착 여부)
    - GPS 장착 시 하루당 10000원 추가
- `Truck` 클래스: `Vehicle` 상속
    - `capacity` 필드 (적재량, 톤)
    - 1톤당 하루 5000원 추가
- 모든 클래스에 `toString()` 오버라이딩

**테스트 코드:**
```java
Car car = new Car("소나타", 50000, true);
Truck truck = new Truck("포터", 70000, 1.5);

System.out.println(car);
System.out.println("3일 대여료: " + car.calculateRentalCost(3) + "원");

System.out.println(truck);
System.out.println("5일 대여료: " + truck.calculateRentalCost(5) + "원");
```

**예상 출력:**
```
Car{model='소나타', dailyRate=50000, hasGPS=true}
3일 대여료: 180000원
Truck{model='포터', dailyRate=70000, capacity=1.5톤}
5일 대여료: 387500원
```
