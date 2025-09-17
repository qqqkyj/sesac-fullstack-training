# 💡JavaScript와 Node.js

## 🟢 JavaScript

- 원래는 **웹 페이지에 동적 기능 구현**을 위해 개발된 프로그래밍 언어
- 현재는 웹 프론트엔드뿐 아니라, 서버, 모바일, 데스크톱 앱까지 확장됨
  - 예: **Visual Studio Code** → Electron 프레임워크(자바스크립트 기반)로 개발

---

## 🟠 Node.js

- **구글 V8 엔진 기반 자바스크립트 런타임 환경**
- 자바스크립트를 브라우저 밖에서도 실행할 수 있게 해줌 (서버, CLI, PC 등)
- 주요 특징
  - 비동기 이벤트 기반 구조 → 네트워크 서버/실시간 서비스에 강점
  - **npm**(Node Package Manager)으로 방대한 오픈소스 생태계 활용 가능

# 💡JavaScript 실행 방법

폴더에 js형식의 파일을 만들고 터미널에서 js파일이 있는 폴더로 위치를 이동 하고 `node 파일명.js`

**`cd 폴더`**

**`node 파일명.js`**

### GUI를 통한 실행 방법

확장 프로그램의 **code runner**를 설치

**상단의 ▷ 버튼**을 클릭하여 실행

# 💡자료형 기초 정리

## 🔎 자료형 확인 방법

- **`typeof`** 키워드(예약어) 사용

```jsx
console.log(typeof "Hello World"); // string
```

- 개발 입문자는 데이터의 자료형을 자주 확인하는 습관이 필요

---

## 🟢 원시 자료형 (Primitive Types)

### 1. 문자열 (String)

- 문자들의 나열 (0개 이상의 문자)
- 빈 문자열(`""`)도 문자열로 취급
- 표현 방법 3가지
  - 큰따옴표 `"Hello"`
  - 작은따옴표 `'Hello'`
  - 백틱 `Hello`

```jsx
console.log(typeof ""); // string
```

---

### 2. 숫자 (Number)

- 정수, 0, 실수 모두 포함

```jsx
console.log(typeof 10); // number
console.log(typeof 0); // number
console.log(typeof -1); // number
console.log(typeof 1.1); // number
```

---

### 3. 불리언 (Boolean)

- 참/거짓을 표현하는 자료형
- 값: `true`, `false` (소문자로 작성)

```jsx
console.log(typeof true); // boolean
console.log(typeof false); // boolean
```

---

### 4. undefined

- "없다, 비어있다"를 표현
- **개발자가 의도하지 않은 비어있음**을 의미

```jsx
console.log(typeof undefined); // undefined
```

---

### 5. null

- "없다, 비어있다"를 표현
- **개발자가 의도적으로 비워둔 값**을 의미
- typeof 결과는 `object` → JavaScript 초창기 버그로 인한 현상

```jsx
console.log(typeof null); // object
```

---

## 📝 정리

- JavaScript 원시 자료형: **문자열, 숫자, 불리언, undefined, null** (총 5개, 실제로는 Symbol, BigInt까지 7개)
- 자료형 확인 시 `typeof` 활용
- `null`의 typeof는 `object` → 자바스크립트 초기 설계 오류지만 지금까지 유지됨

# 💡변수 기초

## 1️⃣ 변수에 데이터 할당

- **할당(Assignment)**: 데이터를 변수에 넣는 것 (`=` 사용)

```jsx
let message = "Hello World"; // 선언 + 할당
console.log(message);
console.log(message);
console.log(message);
```

---

## 2️⃣ 변수 선언과 할당 분리

- **선언과 할당 분리 가능** (Python은 불가)

```jsx
let message2; // 선언
message2 = "Hello JavaScript"; // 할당
```

---

## 3️⃣ 변수 선언 방식

### 🔹 let

- 재할당 가능
- 재선언 불가능

```jsx
let message3 = "Hello variable";
console.log(message3);

message3 = "Hello let variable"; // 재할당
console.log(message3);

// let message3 = "다시 선언"; -> ❌ 오류
```

### 🔹 const

- 재할당 불가 → 상수(constant)

```jsx
const message5 = "Hello Const";
// message5 = "Hello World"; -> ❌ 오류
```

### 🔹 let VS const

| 키워드 | 재할당 | 재선언 |
| ------ | ------ | ------ |
| let    | 가능   | 불가   |
| const  | 불가   | 불가   |

---

## 4️⃣ 변수 이름 규칙

- **대소문자 구분** → `message6` ≠ `MESSAGE6`
- **카멜 케이스(Camel Case)** 권장

```jsx
let helloMessage; // O
let hellomessage; // X
```

- 의미 있는 이름 사용

```jsx
let a = 1; // ❌ 의미 없음
let number1 = 1; // ✅ 의미 있음
```

---

## 5️⃣ 템플릿 리터럴

- 문자열 내 변수 삽입 가능
- 백틱(`) + `${변수}` 사용

```jsx
let name = "정우영";
let greet = `안녕하세요. ${name} 입니다.`;
console.log(greet); // 안녕하세요. 정우영 입니다.
```

---

## 6️⃣ var

- 재선언 가능, 재할당 가능
- 재선언의 단점: 기존 데이터가 덮어써질 수 있음

```jsx
var message7 = "비밀번호";
var message7 = "Hello World"; // 기존 데이터 덮어쓰기 가능

console.log(hoisting); // undefined (호이스팅)
var hoisting = "hello hoisting";
```

- **호이스팅(Hoisting)**: var 변수는 선언이 코드 최상단으로 끌어올려지는 현상

---

💡 **Tip**

- 변하지 않는 값 → `const`
- 변할 수 있는 값 → `let`
- 의미 없는 이름 지양, 카멜 케이스 사용
- 템플릿 리터럴 활용으로 문자열 결합 간편

# 💡연산자

## 1️⃣ 논리형(Boolean)

- **값**: `true` 또는 `false`

```jsx
const trueData = true;
const falseData = false;
```

---

## 2️⃣ AND 연산자 (`&&`)

- **설명**: 두 값이 모두 `true`일 때만 결과가 `true`
- **하나라도 `false`면 결과는 `false`**

```jsx
console.log(`true && true -> ${trueData && trueData}`); // true
console.log(`true && false -> ${trueData && falseData}`); // false
```

---

## 3️⃣ OR 연산자 (`||`)

- **설명**: 하나라도 `true`이면 결과가 `true`
- **둘 다 `false`일 때만 결과가 `false`**

```jsx
console.log(`true || false -> ${trueData || falseData}`); // true
console.log(`false || false -> ${falseData || falseData}`); // false
```

---

## 4️⃣ NOT 연산자 (`!`)

- **설명**: 단일 값의 논리를 반대로 뒤집음
- `true` → `false`, `false` → `true`

```jsx
console.log(`!true -> ${!trueData}`); // false
console.log(`!false -> ${!falseData}`); // true
```

---

## 5️⃣ 템플릿 리터럴 활용

- `${}` 안에는 **변수뿐만 아니라 표현식(expression)** 삽입 가능

```jsx
console.log(`true && false -> ${trueData && falseData}`); // false
```

---

💡 **Tip**

- 조건문, 반복문, 함수 반환값 등에서 **논리연산자를 적극 활용**
- 표현식을 사용하면 계산 결과를 바로 문자열에 삽입 가능

## 6️⃣ 비교 연산자

### 🔹 값만 비교 (`==`, `!=`)

- 값만 비교하며 자료형은 자동 변환됨
- **사용 권장하지 않음**

```jsx
const number = 1; // number
const str = "1"; // string

const bool1 = number == str; // true (자료형 자동 변환)
console.log(bool1);
```

### 🔹 값 + 자료형 비교 (`===`, `!==`)

- 값과 자료형 모두 같아야 true

```jsx
const bool2 = number === str; // false (자료형 다름)
console.log(bool2);
```

💡 **Tip**

- 항상 `===` / `!==` 사용 권장 → 자료형까지 일치 확인
- `==` / `!=`는 예기치 않은 결과가 나올 수 있음
