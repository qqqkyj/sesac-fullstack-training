# 📘 함수(Function)

## 📖 함수란?

* 특정 기능을 수행하기 위해 미리 정의한(모아놓은) 코드 블록

---

## ✅ 우리가 사용해온 함수

* `console.log()`
* `String()` : 문자열 형 변환
* `Number()` : 숫자형 형 변환
* `Boolean()` : 불리언 형 변환

---

## ✨ 함수의 장점

* 코드를 **재사용**하기 좋다
* **유지보수**에 유리하다

---

## 📝 함수의 정의(Define)와 호출(Call)

* **호출(Call)** : `함수명()` → 함수 실행
* **정의(Define)** : 함수의 이름과 기능(코드)을 미리 작성

---

## 📌 함수 정의 방법

### 1. 함수 선언식

```jsx
function 함수명(매개변수) {
  return 반환값;
}
```

### 2. 함수 표현식

```jsx
const 변수명 = function(매개변수) {
  return 반환값;
};
```

### 3. 화살표 함수

```jsx
const 변수명 = (매개변수) => {
  return 반환값;
};
```

---

## 📊 매개변수 / 반환값 조합

| 매개변수 | 반환값 | 활용도   | 예시             |
| ---- | --- | ----- | -------------- |
| X    | X   | 낮음    | Hello World 출력 |
| X    | O   | 낮음    | 숫자 1 반환        |
| O    | X   | 높음    | 전달받은 값 판별 후 출력 |
| O    | O   | 매우 높음 | 값 계산 후 반환      |

---

# ✍️ 함수 실습

## 1. 매개변수 3개 → 합 반환

```javascript
function add(num1, num2, num3) {
  return num1 + num2 + num3;
}

const result1 = add(1, 2, 3);
const n1 = 1, n2 = 2, n3 = 3;
const result2 = add(n1, n2, n3);

console.log(`result1 = ${result1}`);
console.log(`result2 = ${result2}`);
```

---

## 2. 함수 표현식 → 두 수 뺄셈

```javascript
const sub = function (num1, num2) {
  return num1 - num2;
};
console.log(`sub = ${sub(1, 2)}`);
```

---

## 3. 화살표 함수 → 두 수 곱셈

```javascript
const multi = (num1, num2) => {
  return num1 * num2;
};
console.log(`multi = ${multi(2, 3)}`);
```

---

## 4. 매개변수 X / 반환값 X

```javascript
function sayHello() {
  console.log("Hello World");
}

const sayHelloArrow = () => {
  console.log("Hello World");
};

sayHello();
sayHelloArrow();
```

---

## 5. 매개변수 X / 반환값 O

```javascript
function createOne() {
  return 1;
}

const createOneArrow = () => {
  return 1;
};

console.log(createOne());       // 1
console.log(createOneArrow());  // 1
```

---

## 6. 매개변수 O / 반환값 X

```javascript
function determine(number) {
  if (number < 0) {
    console.log("음수");
  } else if (number > 0) {
    console.log("양수");
  } else {
    console.log("0");
  }
}

const determineArrow = (number) => {
  if (number < 0) {
    console.log("음수");
  } else if (number > 0) {
    console.log("양수");
  } else {
    console.log("0");
  }
};

determine(-3);  // 음수
determineArrow(5); // 양수
```

---

## 7. 매개변수 O / 반환값 O

짝수면 `true`, 홀수면 `false` 반환

```javascript
function evenOdd(number) {
  return number % 2 === 0;
}

const evenOddArrow = (number) => {
  return number % 2 === 0;
};

let number = 10;
console.log(`숫자 ${number}(은)는 ${evenOddArrow(number) ? "짝수" : "홀수"}입니다.`);
```

---

# ✅ 오늘 학습 요약

* 함수 정의 방식: **선언식 / 표현식 / 화살표 함수**
* 매개변수와 반환값 조합에 따라 활용도 달라짐
* 조건문, 반복문과 함께 다양한 형태의 함수 구현 연습 완료
