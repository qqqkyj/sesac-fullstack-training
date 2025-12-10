# 📌 JavaScript Promise & Fetch 정리

## 1️⃣ Promise 개념

- **Promise**: 비동기 작업의 **성공(Fulfilled) / 실패(Rejected)** 상태를 나타내는 객체
- **목적**: 비동기 작업 완료 후 결과를 나중에 처리할 수 있도록 약속(Promise) 제공
- **사용 사례**: 네트워크 통신, 파일 읽기, setTimeout 등

### 상태(State)

| 상태      | 의미                                     |
| --------- | ---------------------------------------- |
| Pending   | 비동기 작업이 아직 끝나지 않은 초기 상태 |
| Fulfilled | 비동기 작업이 성공적으로 완료된 상태     |
| Rejected  | 비동기 작업이 실패한 상태                |

---

## 2️⃣ Promise 생성 예제

```jsx
const randomPromise = new Promise((resolve, reject) => {
	// 비동기 작업 흉내
	setTimeout(() => {
		const random = Math.random(); // 랜덤 숫자 생성
		if (random > 0.5) {
			resolve("숫자가 0.5 이상! 성공"); // 성공 시 반환
		} else {
			reject("숫자가 0.5 이하! 실패"); // 실패 시 반환
		}
	}, 1000);
});

console.log(randomPromise); // Pending 상태 출력
```

- `resolve(value)` → 성공 시 반환 값
- `reject(error)` → 실패 시 반환 값

---

## 3️⃣ Promise 결과 처리

### 1. 성공 처리: `.then()`

```jsx
randomPromise.then((result) => {
	console.log(`성공 : ${result}`);
});
```

- `resolve()`의 인자가 `result`로 전달됨

### 2. 실패 처리: `.catch()`

```jsx
randomPromise.catch((error) => {
	console.log(`실패 : ${error}`);
});
```

- `reject()`의 인자가 `error`로 전달됨

### 3. 전체 예제

```jsx
randomPromise
	.then((result) => {
		console.log(`성공 : ${result}`);
	})
	.catch((error) => {
		console.log(`실패 : ${error}`);
	});
```

- 실행 결과는 **랜덤**:

```
성공 : 숫자가 0.5 이상! 성공
또는
실패 : 숫자가 0.5 이하! 실패

```

---

## 4️⃣ Fetch + Promise 체이닝

- **`fetch()`**: 브라우저에서 제공하는 **Promise 기반 네트워크 요청 함수**
- 반환값: 항상 **Promise 객체**
- 체이닝 가능: `.then()`과 `.catch()`로 순차 처리 및 에러 처리 가능

```jsx
fetch("https://www.naver.com")
	.then((res) => {
		console.log(res); // Response 객체
		return res.text(); // 다음 then 함수에 전달
	})
	.then((data) => {
		console.log(data); // HTML 문자열
	});
// .catch((error) => {
// 	console.log(error);    // 네트워크 실패 처리
// });
```

---

## 5️⃣ Promise 장점

1. **콜백 지옥 방지**: 중첩된 콜백 대신 `.then()` 체인으로 순차 처리 가능
2. **가독성 향상**: 비동기 처리 흐름이 코드 상에서 명확
3. **에러 처리 통합**: `.catch()`로 한 번에 처리 가능

---

# 📌 JavaScript async / await 정리

## 1️⃣ 개념

- **`async` / `await`**: **Promise 기반 비동기 처리를 더 직관적이고 동기식처럼** 작성할 수 있도록 도와주는 키워드
- 장점: **콜백 지옥 방지**, **가독성 향상**, **에러 처리 용이**

---

## 2️⃣ 키워드 설명

| 키워드          | 역할                                                                          |
| --------------- | ----------------------------------------------------------------------------- |
| **async**       | 함수 앞에 붙이는 키워드. 해당 함수가 비동기 처리 함수임을 명시.               |
| **await**       | Promise가 **완료될 때까지 기다리는 키워드**. async 함수 내부에서만 사용 가능. |
| **try / catch** | 비동기 처리 성공/실패에 따른 예외 처리 가능                                   |

---

## 3️⃣ 사용 예제

```jsx
async function func() {
	try {
		// Promise 기반 비동기 처리 수행
		const result = await randomPromise; // 완료될 때까지 대기
		console.log(result); // 성공 시 값 출력
	} catch (error) {
		console.log(error); // 실패 시 에러 처리
	}
}

func();
```

### 설명

1. `async function func()`
   - `func` 함수가 **비동기 처리 함수**임을 명시
2. `await randomPromise`
   - `randomPromise`가 **resolve / reject**될 때까지 함수 실행을 일시 중지
   - 완료되면 결과를 `result`에 반환
3. `try / catch`
   - `resolve` 시 → `try` 블록 실행
   - `reject` 시 → `catch` 블록 실행

---

## 4️⃣ Promise vs async/await 비교

| 구분      | Promise                | async/await                  |
| --------- | ---------------------- | ---------------------------- |
| 코드 구조 | `.then().catch()` 체인 | 동기식 코드처럼 직관적       |
| 가독성    | 중첩될수록 복잡        | 간결하고 읽기 쉬움           |
| 에러 처리 | `.catch()` 체인        | try / catch 블록 내에서 처리 |

---

## 5️⃣ 장점

- 콜백 지옥 완전히 방지 가능
- 비동기 처리를 **동기식 코드처럼 작성** 가능
- 에러 처리 간편 (`try / catch`)
