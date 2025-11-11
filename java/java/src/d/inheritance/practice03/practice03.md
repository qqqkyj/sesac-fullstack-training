## 문제 1: 동물원 시스템


**요구사항:**

1. **`Animal` 추상 클래스 작성:**
    - `protected String name` - 동물 이름
    - `protected int age` - 동물 나이
    - `public Animal(String name, int age)` - 생성자
    - `public void displayInfo()` - 일반 메서드 (구현 필요)
        - "이름: [name], 나이: [age]살" 형식으로 출력
    - `public abstract void makeSound()` - 추상 메서드 (선언만)
    - `public abstract void eat()` - 추상 메서드 (선언만)

2. **`Dog` 클래스 작성:**
    - `Animal` 상속
    - 생성자: `super(name, age)` 호출
    - `makeSound()` 구현: "멍멍!" 출력
    - `eat()` 구현: "사료를 먹습니다" 출력

3. **`Cat` 클래스 작성:**
    - `Animal` 상속
    - 생성자: `super(name, age)` 호출
    - `makeSound()` 구현: "야옹~" 출력
    - `eat()` 구현: "생선을 먹습니다" 출력

4. **`Bird` 클래스 작성:**
    - `Animal` 상속
    - 생성자: `super(name, age)` 호출
    - `makeSound()` 구현: "짹짹!" 출력
    - `eat()` 구현: "모이를 먹습니다" 출력

**테스트 코드:**
```java
public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("바둑이", 3),
            new Cat("나비", 2),
            new Bird("짹짹이", 1)
        };

        for (Animal animal : animals) {
            animal.displayInfo();
            animal.makeSound();
            animal.eat();
            System.out.println();
        }
    }
}
```

**예상 출력:**
```
이름: 바둑이, 나이: 3살
멍멍!
사료를 먹습니다

이름: 나비, 나이: 2살
야옹~
생선을 먹습니다

이름: 짹짹이, 나이: 1살
짹짹!
모이를 먹습니다
```

## 문제 2: 도형 그리기 프로그램


**요구사항:**

1. **`Shape` 추상 클래스 작성:**
    - `protected int x, y` - 도형의 위치
    - `protected String color` - 도형의 색상
    - `Shape(int x, int y, String color)` - 생성자
    - `public final void draw()` - 템플릿 메서드 (final로 선언)
        - 실행 순서: moveTo() → setColor() → drawShape()
    - `void moveTo()` - 일반 메서드
        - "위치 이동: (x, y)" 출력
    - `void setColor()` - 일반 메서드
        - "색상 설정: [color]" 출력
    - `abstract void drawShape()` - 추상 메서드
        - 각 도형마다 다르게 구현

2. **`Circle` 클래스 작성:**
    - `Shape` 상속
    - `private int radius` - 반지름
    - `Circle(int x, int y, String color, int radius)` - 생성자
    - `drawShape()` 구현: "반지름 [radius]인 원 그리기" 출력

3. **`Rectangle` 클래스 작성:**
    - `Shape` 상속
    - `private int width, height` - 가로, 세로
    - `Rectangle(int x, int y, String color, int width, int height)` - 생성자
    - `drawShape()` 구현: "[width]x[height] 사각형 그리기" 출력

4. **`Triangle` 클래스 작성:**
    - `Shape` 상속
    - `private int side1, side2, side3` - 세 변의 길이
    - `Triangle(int x, int y, String color, int side1, int side2, int side3)` - 생성자
    - `drawShape()` 구현: "변 [side1], [side2], [side3]인 삼각형 그리기" 출력

**테스트 코드:**
```java
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(0, 0, "빨강", 5),
            new Rectangle(10, 10, "파랑", 4, 6),
            new Triangle(20, 20, "초록", 3, 4, 5)
        };

        for (Shape shape : shapes) {
            shape.draw();
            System.out.println();
        }
    }
}
```

**예상 출력:**
```
위치 이동: (0, 0)
색상 설정: 빨강
반지름 5인 원 그리기

위치 이동: (10, 10)
색상 설정: 파랑
4x6 사각형 그리기

위치 이동: (20, 20)
색상 설정: 초록
변 3, 4, 5인 삼각형 그리기
```

## 문제 3: 게임 캐릭터 시스템


**요구사항:**

1. **`GameCharacter` 추상 클래스 작성:**
    - `protected String name` - 캐릭터 이름
    - `protected int attackPower` - 공격력
    - `GameCharacter(String name, int attackPower)` - 생성자
    - `public final void attack()` - 템플릿 메서드 (final로 선언)
        - 실행 순서: `prepare()` → `executeAttack()` → `finish()`
    - `void prepare()` - 일반 메서드
        - "[name]이(가) 공격 준비!" 출력
    - `abstract void executeAttack()` - 추상 메서드
        - 각 캐릭터의 고유 공격 실행
    - `void finish()` - 일반 메서드
        - "공격 완료!" 출력

2. **`Warrior` 클래스 작성:**
    - `GameCharacter` 상속
    - 생성자: `Warrior(String name)` → `super(name, 50)` 호출
    - `executeAttack()` 구현: "검으로 베기! 데미지: [attackPower]" 출력

3. **`Mage` 클래스 작성:**
    - `GameCharacter` 상속
    - 생성자: `Mage(String name)` → `super(name, 80)` 호출
    - `executeAttack()` 구현: "마법 공격! 데미지: [attackPower]" 출력

**테스트 코드:**
```java
public class Main {
    public static void main(String[] args) {
        GameCharacter warrior = new Warrior("전사");
        warrior.attack();

        System.out.println();

        GameCharacter mage = new Mage("마법사");
        mage.attack();
    }
}
```

**예상 출력:**
```
전사이(가) 공격 준비!
검으로 베기! 데미지: 50
공격 완료!

마법사이(가) 공격 준비!
마법 공격! 데미지: 80
공격 완료!
```
