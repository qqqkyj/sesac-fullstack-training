# 💡 React 이벤트 핸들링 정리

React에서 이벤트 핸들링은 **HTML 이벤트 속성(onClick, onChange, onSubmit 등)**과 **핸들러 함수**를 연결하여 동작합니다.

---

## 1️⃣ onChange 이벤트

### 🔹 특징

- `<input>`, `<textarea>`, `<select>` 등에서 값이 변경될 때 발생
- 핸들러 함수에서 이벤트 객체(`event`)를 받아 **사용자 입력값** 확인 가능

### 🔹 예제: 문자열 입력 값 확인

```jsx
function handleChange(event) {
	console.log(event.target.value); // 입력값 확인
}

<input type="text" onChange={handleChange} />;
```

### 🔹 예제: 조건부 처리

```jsx
function handleNumberChange(event) {
	const value = event.target.value;
	if (value < 10) {
		console.log("10보다 작은 수");
	}
}

<input type="text" onChange={handleNumberChange} />;
```

---

## 2️⃣ onSubmit 이벤트

### 🔹 특징

- **form 태그에서만 발생**
- submit 시 브라우저가 페이지를 새로고침하기 때문에, `event.preventDefault()`로 방지 필요
- `event.target`을 통해 form 안의 input 요소 접근 가능

### 🔹 예제

```jsx
function handleSubmit(event) {
	event.preventDefault(); // 새로고침 방지
	const email = event.target.email.value;
	const pwd = event.target.password.value;
	console.log(`이메일: ${email}`);
	console.log(`비밀번호: ${pwd}`);
}

<form onSubmit={handleSubmit}>
	<input type="text" name="email" />
	<input type="password" name="password" />
	<input type="submit" value="제출" />
</form>;
```

---

## 3️⃣ onClick 이벤트

### 🔹 특징

- 버튼, div 등 **클릭 가능한 요소에서 발생**
- 핸들러 함수에서 간단한 동작 수행 가능

### 🔹 예제

```jsx
function handleClick() {
	alert("클릭");
}

<button onClick={handleClick}>클릭</button>;
```

### 🔹 흐름

1. 사용자가 버튼 클릭
2. `onClick` 이벤트 발생
3. `handleClick` 함수 호출 → alert 표시

---

## 4️⃣ 이벤트 객체(`event`) 사용

- React 이벤트는 **SyntheticEvent** 객체로 래핑되어 있음
- 주요 속성:
  | 속성                     | 설명                                   |
  | ------------------------ | -------------------------------------- |
  | `event.target`           | 이벤트가 발생한 요소                   |
  | `event.preventDefault()` | 기본 동작 방지 (submit 시 새로고침 등) |
  | `event.type`             | 이벤트 종류 (click, change, submit 등) |
- 이벤트 객체는 **핸들러 함수 매개변수**로 전달됨

```jsx
onChange={(event) => handleChange(event)}

```

---

## 5️⃣ 요약 표

| 이벤트   | 발생 요소               | 주요 사용                            |
| -------- | ----------------------- | ------------------------------------ |
| onChange | input, textarea, select | 입력값 추적, 실시간 검증             |
| onSubmit | form                    | 폼 데이터 제출 처리, 새로고침 방지   |
| onClick  | button, div 등          | 클릭 시 동작 수행, 알림/상태 변경 등 |
