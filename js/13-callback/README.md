# 💡 자바스크립트 함수와 일급 객체 정리

---

## 1️⃣ 함수 선언 방식

### 1. 함수 선언식

```jsx
function 함수명() {}
```

### 2. 함수 표현식

```jsx
const functionExpression = function () {};
```

- 이름이 없는 함수를 변수에 할당

### 3. 화살표 함수

```jsx
const functionArrow = () => {};
```

- 이름이 없는 함수를 변수에 할당
- 간결한 문법 제공

---

## 2️⃣ 일급 객체(First-class Object)

### 특징

1. **변수에 할당 가능**
2. **함수의 반환값으로 사용 가능**
3. **다른 함수의 인자로 전달 가능**

---

### 2-1. 함수 반환값으로 사용

```jsx
function calculator(operator) {
	if (operator === "더하기") {
		return (n1, n2) => n1 + n2;
	}
	if (operator === "빼기") {
		return (n1, n2) => n1 - n2;
	}
}

const add = calculator("더하기");
const sub = calculator("빼기");

console.log(add(10, 3)); // 13
console.log(sub(32, 13)); // 19
```

---

### 2-2. 함수의 인자로 전달

```jsx
function calculator2(operatorFunction, n1, n2) {
	const result = operatorFunction(n1, n2);
	console.log(`연산 결과: ${result}`);
}

calculator2((a, b) => a + b, 1, 2); // 연산 결과: 3
```

- 기존의 `addLog`, `subLog` 등 여러 함수 없이도 **공통 로직** 하나로 다양한 연산 가능

---

## 3️⃣ 실생활 비유: 파스타 만들기 🍝

### 문제점

- 면 종류 × 소스 종류 × 향신료 종류 → 각각 함수 만들면 조합마다 함수가 필요
- 함수 수가 기하급수적으로 증가

### 해결: 함수를 매개변수로 전달

```jsx
function 파스타_만들기(면_준비하기, 소스_준비하기) {
	면_준비하기();
	소스_준비하기();
	console.log("🍝 파스타 완성!");
}

// 면 준비 함수
function 스파게티면_준비하기() {
	console.log("➡️ 스파게티면 준비 완료");
}
function 푸실리면_준비하기() {
	console.log("➡️ 푸실리면 준비 완료");
}

// 소스 준비 함수
function 토마토소스() {
	console.log("➡️ 토마토소스 준비 완료");
}
function 크림소스() {
	console.log("➡️ 크림소스 준비 완료");
}

// 다양한 조합 가능
파스타_만들기(스파게티면_준비하기, 토마토소스);
파스타_만들기(푸실리면_준비하기, 크림소스);
```

### 장점

- **재사용성 증가**: 면, 소스 함수를 재사용 가능
- **유지보수 용이**: 새로운 면/소스 추가 시 기존 로직 수정 최소화
- **가독성 향상**: 핵심 로직(`파스타_만들기`)이 깔끔

---

# 💡 배열 고차 함수(Higher-order Function)

## 1️⃣ 고차 함수(Higher-order Function)란?

- 함수를 **인자로 받거나, 함수를 반환하는 함수**
- 배열 메서드와 함께 자주 사용
- 코드 **재사용성**과 **가독성** 향상

---

## 2️⃣ 직접 구현한 고차 함수 예제

```jsx
// 콜백 함수: 매개변수 값에 2를 곱해서 반환
function multiTwo(value) {
	return value * 2;
}

// 고차 함수: 배열과 콜백 함수를 인자로 받음
function higherOrderFunction(array, callbackFunction) {
	for (let element of array) {
		const result = callbackFunction(element);
		console.log(result);
	}
}

const numbers = [1, 2, 3, 4, 5];

// 각 원소에 곱하기 2 적용
higherOrderFunction(numbers, multiTwo);

// 각 원소에 더하기 1 적용
higherOrderFunction(numbers, (value) => value + 1);

// 각 원소 제곱 적용
higherOrderFunction(numbers, (value) => value * value);
```

---

## 3️⃣ 배열 내장 고차 메서드

### 3-1. `forEach()`

- 배열을 반복하며 콜백 함수를 실행
- 반환값은 없음(`undefined`)

```jsx
const numbers2 = [1, 2, 3, 4, 5];

function 콜백함수(element) {
	console.log(element);
}

// 배열 순회
numbers2.forEach(콜백함수);
```

---

### 3-2. `for` vs `for...of` vs `forEach`

```jsx
// for 반복문
for (let index = 0; index <= numbers2.length - 1; index++) {
	console.log(numbers2[index]);
}

// for...of 반복문
for (let element of numbers2) {
	console.log(element);
}
```

| 반복문   | 장점                                | 단점                               |
| -------- | ----------------------------------- | ---------------------------------- |
| for      | 전통적인 반복문, 자유로운 조건 설정 | 인덱스 접근 필요, 조건식 실수 가능 |
| for...of | 원소 직접 접근 가능, 코드 간결      | 내부 로직 관리 어려움              |
| forEach  | 콜백 함수로 반복 제어, 문법 간결    | break, continue 사용 불가          |

---

## 4️⃣ `map()` – 배열 변환

- 배열 각 원소를 변환하여 **새 배열 생성**
- 원본 배열 변경 없음

```jsx
const numbers4 = [1, 2, 3, 4, 5];

// 각 원소 +1 적용
const newArray = numbers4.map((element) => element + 1);
console.log(newArray); // [2,3,4,5,6]

// 각 원소 *2 적용
const newArray2 = numbers4.map((element) => element * 2);
console.log(newArray2); // [2,4,6,8,10]
```

---

## 5️⃣ `filter()` – 조건 만족 원소 추출

- 조건(predicate)을 만족하는 원소만 새 배열로 반환

```jsx
const numbers5 = [1, 2, 3, 4, 5];

// 짝수만 추출
const evenArray = numbers5.filter((element) => element % 2 === 0);
console.log(evenArray); // [2,4]

// 3 이상만 추출
const biggerThanThree = numbers5.filter((element) => element >= 3);
console.log(biggerThanThree); // [3,4,5]
```

---

## 6️⃣ 배열 고차 메서드 요약표

| 메서드        | 기능                                | 반환값                | 활용도 | 원본 배열 변경 |
| ------------- | ----------------------------------- | --------------------- | ------ | -------------- |
| `forEach()`   | 각 원소에 콜백 함수 적용            | `undefined`           | 높음   | ❌             |
| `map()`       | 각 원소 변환 → 새 배열 생성         | 새 배열               | 높음   | ❌             |
| `filter()`    | 조건 만족 원소만 추출               | 새 배열               | 높음   | ❌             |
| `find()`      | 조건 만족 첫 번째 원소 반환         | 원소 또는 `undefined` | 높음   | ❌             |
| `reduce()`    | 모든 원소를 하나의 값으로 축약      | 단일 값               | 중간   | ❌             |
| `sort()`      | 원소 정렬                           | 정렬된 배열           | 중간   | ✅             |
| `some()`      | 조건 만족 원소 하나라도 있는지 확인 | true/false            | 낮음   | ❌             |
| `every()`     | 모든 원소 조건 만족 확인            | true/false            | 낮음   | ❌             |
| `findIndex()` | 조건 만족 첫 원소 인덱스            | 인덱스 또는 -1        | 낮음   | ❌             |

---

## 7️⃣ 핵심 포인트

1. 배열 반복을 **함수화** → 코드 간결, 재사용 가능
2. 콜백 함수를 통해 반복 로직 **유연하게 제어**
3. `map`과 `filter`는 **새 배열 생성 → 원본 유지**
