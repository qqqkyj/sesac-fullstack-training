## 문제 1: 동물원 관리

다형성을 활용하여 동물원 관리 프로그램을 작성하세요.

**요구사항:**
- `Animal` 클래스: `name`, `age` 필드, `makeSound()` 메서드
- `Lion`, `Elephant`, `Monkey` 클래스: `Animal` 상속, `makeSound()` 오버라이딩
- `Zoo` 클래스: `Animal` 배열을 관리하고 모든 동물의 소리를 출력하는 `feedingTime()` 메서드

**예상 출력:**
```
=== 먹이 시간 ===
사자 심바: 어흥!
코끼리 덤보: 뿌우우!
원숭이 조조: 끼끼!
```

## 문제 2: 영화 정보 시스템

영화 정보 관리 시스템을 구현하세요.

**요구사항:**
- `Movie` 클래스: `title`, `rating` 필드
    - `displayInfo()`: 정보 출력 메서드
- `ActionMovie` 클래스: `specialEffects` 필드 추가 (특수효과 수준)
- `Comedy` 클래스: `humorStyle` 필드 추가 (유머 스타일)
- `Drama` 클래스: `theme` 필드 추가 (주제)
- 각 클래스는 `displayInfo()` 오버라이딩하여 고유한 정보 출력
- `instanceof`를 사용하여 타입별로 다른 처리

**테스트 코드:**
```java
Movie[] movies = {
    new ActionMovie("어벤져스", 4.5, "최고급 CG"),
    new Comedy("극한직업", 4.7, "상황 코미디"),
    new Drama("기생충", 4.9, "계급 갈등")
};

for (Movie movie : movies) {
    movie.displayInfo();
}
```

**예상 출력:**
```
[액션] 어벤져스 (평점: 4.5) - 특수효과: 최고급 CG
[코미디] 극한직업 (평점: 4.7) - 유머: 상황 코미디
[드라마] 기생충 (평점: 4.9) - 주제: 계급 갈등
```
