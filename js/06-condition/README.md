## **식과 문**

### **식(Expression)**

- 하나의 데이터를 생성하는 코드
- 예시

```
1; //1
1 + 1; //2
2 > 1; // true
true && true; //true
```

### **문(Statement)**

- 컴퓨터에게 전달하는 동작의 지시문
- 제어문: 조건문, 반복문, 함수
- 변수의 선언, 할당
- 예시

```
let number = 1;// 변수 number를 선언하고, 1을 할당하라는 동작의 지시문
let number2;// 변수 number2를 선언하라는 동작의 선언문
```

## **조건문(condition statement)**

- 조건 결과에 따라 코드의 실행을 결정하는 동작을 지시
- 조건식: 비교 연산자(>, <, >=, <=, ===, !==), 논리연산자(&&, ||, ! )의 조합을 통해 **true/false** 만드는 식
- 조건문: 조건식의 결과가 `true`면 코드를 실행, `false`면 코드를 실행하지 않는 동작을 지시

## 1. 조건문의 기본 구조

### 한 줄/여러 줄 주석

```jsx
// 한 줄 주석

/*
여러 줄 주석
*/
```

### 기본 if문

- 조건: `5 > 1`
- 조건이 참이면 블록 실행

```jsx
if (5 > 1) {
	console.log("5는 1보다 크다.");
}
```

---

## 2. if ~ else if 조건문

- 여러 조건 중 하나를 만족하면 실행
- 조건 순서에 따라 실행되는 블록 결정

```jsx
if (5 > 10) {
	// 조건1: 5 > 10 → 거짓
	console.log("5는 10보다 크다.");
} else if (5 > 7) {
	// 조건2: 5 > 7 → 거짓
	console.log("5는 7보다 크다.");
} else if (5 > 5) {
	// 조건3: 5 > 5 → 거짓
	console.log("5는 5보다 크다.");
} else if (5 > 3) {
	// 조건4: 5 > 3 → 참
	console.log("5는 3보다 크다.");
}
// 출력: "5는 3보다 크다."
```

---

## 3. if ~ else if ~ else 조건문

- 모든 조건을 순서대로 검사
- 마지막 else는 위 조건 모두 거짓일 때 실행

```jsx
let number = 1;
// 조건: number > 0 → 양수, 아니면 음수
if (number > 0) {
	console.log("양수");
} else {
	console.log("음수");
}

let number2 = 0;
// 조건:
// number2 > 0 → 양수
// number2 < 0 → 음수
// 모두 거짓 → 0
if (number2 > 0) {
	console.log("양수");
} else if (number2 < 0) {
	console.log("음수");
} else {
	console.log("0");
}
```

---

## 4. 중첩 조건문 (Nested if)

- 조건: 나이와 학생 여부에 따라 다른 메시지 출력
- 조건:
  1. `age >= 20`
     - `isStudent === true` → "학생인 성인"
     - `isStudent === false` → "성인"
  2. `age < 20`
     - `isStudent === true` → "미성년자 학생"
     - `isStudent === false` → "미성년자"

```jsx
let age = 25;
let isStudent = true;

if (age >= 20) {
	if (isStudent === true) {
		console.log("학생인 성인입니다.");
	} else {
		console.log("성인입니다.");
	}
} else {
	if (isStudent === true) {
		console.log("미성년자 학생입니다.");
	} else {
		console.log("미성년자입니다.");
	}
}
// 출력: "학생인 성인입니다."
```

---

## 5. 점수 구간별 학점 출력

- 조건:
  - `score >= 90` → "A"
  - `score >= 80` → "B"
  - `score >= 70` → "C"
  - `score >= 60` → "D"
  - 나머지 → "F"

```jsx
let score = 75;

if (score >= 90) {
	console.log("A");
} else if (score >= 80) {
	console.log("B");
} else if (score >= 70) {
	console.log("C");
} else if (score >= 60) {
	console.log("D");
} else {
	console.log("F");
}
// 출력: "C"
```

---

💡 **정리 포인트**

- `if` → 조건이 참이면 블록 실행
- `else if` → 앞 조건 모두 거짓일 때 다음 조건 검사
- `else` → 모든 조건 거짓일 때 실행
- **중첩 조건문** → 복잡한 조건을 분기별로 처리 가능
- **범위 판단** → 점수, 나이 등 구간에 따라 간단하게 처리 가능

---

### if문만 사용한 경우

```jsx
if (score >= 90) {
	console.log("A");
}
if (score >= 80) {
	console.log("B");
}
if (score >= 70) {
	console.log("C");
}
if (score >= 60) {
	console.log("D");
} else {
	console.log("F");
}
// 출력: C, D
```

**설명**

- 모든 조건을 독립적으로 체크
- 조건이 겹치면 여러 블록이 실행될 수 있음 → 불필요한 연산 발생
- 따라서 점수/범위 조건 같은 경우 `else if` 구조를 권장

---

## 6. 삼항 연산자 (Ternary Operator)

- 조건식 ? 참일 때 반환값 : 거짓일 때 반환값
- 데이터 생성(**표현식**)에서 주로 사용

```jsx
const message = 2 > 1 ? "2는 1보다 크다" : "2는 1보다 크지 않다";
console.log(message); // 출력: "2는 1보다 크다"

let isLoggined = true;
const user = isLoggined ? "회원 사용자 화면" : "비회원 사용자 화면";
console.log(user); // 출력: "회원 사용자 화면"
```

**설명**

- 조건식이 참/거짓 중 하나의 값을 반환
- 변수 할당, JSX 표현식 등에서 유용
- 간단한 조건일 때 `if-else` 대신 깔끔하게 사용 가능

---

### 💡 핵심 포인트

1. **if / else if / else**
   - 범위 구분, 단계적 조건 검사에 적합
   - 중첩 조건문 가능 → 복잡한 분기 처리
2. **if만 독립적 사용**
   - 조건이 겹치면 여러 블록 실행 가능 → 비효율적
3. **삼항 연산자**
   - 한 줄로 조건 판단 및 값 반환 가능
   - JSX/리액트에서 표현식으로 자주 사용
