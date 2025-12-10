# 🌐 DOM 폼 처리

## 1️⃣ Submit 이벤트 처리

- **폼 전송 시 자동 발생**하는 이벤트
- 기본 동작은 서버로 데이터를 전송하는 것 → `event.preventDefault()`로 막을 수 있음
- 보통 자바스크립트에서는 이 이벤트를 가로채서 **클라이언트 측 유효성 검사**나 **AJAX 요청**에 활용

```jsx
form.addEventListener("submit", (event) => {
	event.preventDefault(); // 기본 전송 막기
	console.log("폼 제출 이벤트 발생!");
});
```

📌 **포인트**

- 무조건 `submit` 이벤트는 **form 태그에 등록**해야 함 (버튼 클릭 이벤트와 혼동 금지)
- 여러 input 데이터는 `form.elements["name값"].value`로 접근 가능

---

## 2️⃣ 데이터 유효성 검사 (Validation)

사용자가 입력한 값이 **규칙에 맞는지** 확인하는 과정

→ 서버에 전송하기 전에 잘못된 데이터를 걸러내는 역할

### 예시

1. **필수 입력 검사**

```jsx
if (!email.value) {
	alert("이메일을 입력하세요");
}
```

1. **비밀번호 일치 검사**

```jsx
if (pwd1.value !== pwd2.value) {
	alert("비밀번호가 다릅니다!");
}
```

1. **정규식 검사**

```jsx
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
if (!emailPattern.test(email.value)) {
	alert("이메일 형식이 올바르지 않습니다");
}
```

📌 **포인트**

- 간단한 검사는 `required`, `pattern` 같은 **HTML 속성**으로도 가능
- 복잡한 검사는 **자바스크립트**에서 처리

---

## 3️⃣ 실시간 입력 처리 (Input Event Handling)

- 사용자가 입력할 때마다 **즉시 반응**하도록 이벤트 처리
- 대표적인 이벤트:
  - `input` : 값이 입력될 때마다 발생
  - `change` : 값이 바뀌고 focus가 벗어날 때 발생
  - `keyup` : 키보드 입력이 끝날 때 발생

### 예시: 비밀번호 확인 실시간 검사

```jsx
const pwd1 = document.querySelector("input[name='pwd']");
const pwd2 = document.querySelector("input[name='pwd-confirm']");
const msg = document.createElement("p");
pwd2.after(msg);

pwd2.addEventListener("input", () => {
	msg.textContent =
		pwd1.value === pwd2.value ? "✅ 일치합니다" : "❌ 불일치합니다";
});
```

📌 **포인트**

- 실시간 피드백 제공 → UX 향상
- submit 전에 미리 알려주면 사용자 편리함

---

# ✅ 정리 표

| 범주               | 설명                                       | 주요 이벤트                | 활용 예시                                            |
| ------------------ | ------------------------------------------ | -------------------------- | ---------------------------------------------------- |
| Submit 이벤트      | 폼 제출 시 발생하는 이벤트를 가로채어 처리 | `submit`                   | `event.preventDefault()`로 기본 전송 막기, AJAX 호출 |
| 데이터 유효성 검사 | 입력 값이 규칙에 맞는지 확인               | 없음(검사 로직)            | 비밀번호 일치 검사, 이메일 형식 검사                 |
| 실시간 입력 처리   | 입력할 때마다 즉각 반응                    | `input`, `change`, `keyup` | 실시간 비밀번호 확인, 글자수 제한 안내               |

---

👉 요약하면,

1. **submit 이벤트**는 "제출 버튼 눌렀을 때" 실행되는 최종 체크
2. **유효성 검사**는 "제출 전" 데이터를 올바른지 확인
3. **실시간 입력 처리**는 "입력 중" 바로 피드백 주기
