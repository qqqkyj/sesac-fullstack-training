# 📌 JavaScript 예외 처리 정리 (`try…catch…finally`)

---

## 1️⃣ 기본 구조

```jsx
try {
	// 예외가 발생할 가능성이 있는 코드
} catch (error) {
	// 예외가 발생하면 실행되는 코드
	// error 객체에 예외 정보가 저장됨
} finally {
	// 예외 발생 여부와 상관없이 항상 실행
}
```

---

## 2️⃣ 예제 1: const 재할당 예외

```jsx
try {
	const test = "test";
	test = "hi"; // ❌ const 재할당 → TypeError
} catch (error) {
	console.log(`${error.name} : ${error.message}`);
} finally {
	console.log("HELLO WORLD!");
}
```

### 출력 결과

```
TypeError : Assignment to constant variable.
HELLO WORLD!
```

### ✅ 포인트

1. `try`에서 오류 발생 → `catch` 실행
2. `catch`에서 오류 객체 사용 가능 (`name`, `message`)
3. `finally`는 항상 실행

---

## 3️⃣ 예제 2: 함수 내부 예외와 finally

```jsx
function errorFunction() {
	try {
		console.log(number); // ❌ 정의되지 않은 변수 → ReferenceError
	} catch (error) {
		console.log(`${error.name} : ${error.message}`);
		return false; // catch에서 return
	} finally {
		// return 이후에도 항상 실행
		console.log("무조건 실행되는 코드 ? 1");
	}

	// catch에서 return 했기 때문에 여기는 실행 X
	console.log("무조건 실행되는 코드 ? 2");
}

const result = errorFunction();
console.log(result);
```

### 출력 결과

```
ReferenceError : number is not defined
무조건 실행되는 코드 ? 1
false
```

### ✅ 포인트

1. `catch`에서 return 되어도 **finally 블록은 반드시 실행**
2. return 이후의 코드는 실행되지 않음
3. 함수 결과는 return 값(`false`)으로 출력됨

---

## 4️⃣ 동작 요약

| 블록             | 동작                                                                |
| ---------------- | ------------------------------------------------------------------- |
| try              | 예외가 발생할 가능성이 있는 코드                                    |
| catch            | try에서 예외 발생 시 실행, error 객체 사용 가능 (`name`, `message`) |
| finally          | try/catch 여부와 상관없이 항상 실행                                 |
| return + finally | finally 블록은 return 직전/후 모두 실행, return 이후 함수 종료      |
