# 💡 State Advanced

# 📌 React Form 상태 관리 정리

## 1. 개별 상태 관리 방식

```jsx
const [username, setUsername] = useState("");
const [age, setAge] = useState(0);
const [email, setEmail] = useState("");
```

- 입력 필드마다 `useState`를 따로 선언
- 상태가 많아지면 코드가 길어짐

---

## 2. 객체로 상태 관리 방식 (권장)

```jsx
const [form, setForm] = useState({
  username: "",
  age: 0,
  email: "",
});
```

- 모든 입력 필드를 하나의 `form` 객체로 묶어서 관리
- 확장성 ↑, 코드 간결 ↑

---

## 3. 이벤트 핸들러 (handleChange)

```jsx
function handleChange(event) {
  const { name, value } = event.target;

  // 스프레드 연산자로 기존 form 복사 + 변경된 값만 업데이트
  setForm({
    ...form,
    [name]: value, // key를 동적으로 할당 (계산된 속성명)
  });

  console.log(name, value);
}
```

- `event.target`에서 `name`, `value`를 추출
- `[name]: value` → `input`의 `name` 속성에 따라 동적으로 값이 업데이트됨

---

## 4. 최종 Form 컴포넌트

```jsx
import React, { useState } from "react";

export default function Form() {
  const [form, setForm] = useState({
    username: "",
    age: 0,
    email: "",
  });

  function handleChange(event) {
    const { name, value } = event.target;
    setForm({
      ...form,
      [name]: value,
    });
  }

  return (
    <form>
      <inputclassName="border-2"
        type="text"
        name="username"
        value={form.username}
        placeholder="이름"
        onChange={handleChange}
      />
      <inputclassName="border-2"
        type="number"
        name="age"
        value={form.age}
        onChange={handleChange}
      />
      <inputclassName="border-2"
        type="email"
        name="email"
        value={form.email}
        placeholder="이메일"
        onChange={handleChange}
      />
    </form>
  );
}
```

---

## 5. 특징

✅ 모든 `input`을 하나의 상태(`form`)로 관리

✅ 코드 중복 ↓, 유지보수 ↑

✅ `input` 필드가 늘어나도 `form` 객체에만 key/value 추가하면 됨

---

# 📌 React 라디오 버튼 상태 관리 (RadioButtons.jsx)

## 1. 상태 선언

```jsx
const [selectedLevel, setSelectedLevel] = useState("");

```

- `selectedLevel`: 현재 선택된 라디오 버튼 값
- `setSelectedLevel`: 선택 변경 시 업데이트하는 함수

---

## 2. 라디오 버튼 데이터 배열

```jsx
const levels = [
  { id: 1, value: "입문" },
  { id: 2, value: "초급" },
  { id: 3, value: "중급" },
  { id: 4, value: "고급" },
  { id: 5, value: "전문가" },
];
```

- 라디오 버튼 항목을 객체 배열로 관리
- 나중에 항목이 늘어나도 배열만 수정하면 됨 → 확장성 👍

---

## 3. 이벤트 핸들러

```jsx
function handleRadioChange(e) {
  setSelectedLevel(e.target.value);
}
```

- 라디오 버튼의 값(`value`)을 읽어 상태에 저장

---

## 4. 최종 컴포넌트

```jsx
import { useState } from "react";

export default function RadioButtons() {
  const [selectedLevel, setSelectedLevel] = useState("");

  const levels = [
    { id: 1, value: "입문" },
    { id: 2, value: "초급" },
    { id: 3, value: "중급" },
    { id: 4, value: "고급" },
    { id: 5, value: "전문가" },
  ];

  function handleRadioChange(e) {
    setSelectedLevel(e.target.value);
  }

  return (
    <div>
      {levels.map((level) => (
        <label key={level.id}>
          <inputtype="radio"
            name="level"
            value={level.value}
            checked={selectedLevel === level.value}
            onChange={handleRadioChange}
          />
          {level.value}
        </label>
      ))}

      <p>선택된 레벨: {selectedLevel}</p>
    </div>
  );
}
```

---

## 5. 핵심 포인트

✅ `checked={selectedLevel === level.value}` → 상태와 동기화

✅ `name="level"` → 같은 그룹으로 묶어서 하나만 선택 가능

✅ `levels.map(...)` → 반복 렌더링으로 깔끔한 코드

---

# 📌 React 체크박스 다중 선택 관리 (MultipleCheckboxes.jsx)

## 1. 상태 선언

```jsx
const [checkedItems, setCheckedItems] = useState([]);
```

- `checkedItems`: 선택된 체크박스 값들을 저장하는 배열
- 여러 항목 선택이 가능하므로 배열로 관리

---

## 2. 체크박스 데이터 배열

```jsx
const options = [
  { id: 1, value: "스포츠" },
  { id: 2, value: "음악" },
  { id: 3, value: "영화" },
  { id: 4, value: "여행" },
];
```

- 체크박스 항목을 객체 배열로 관리
- 추후 항목 추가 시 이 배열만 수정하면 됨

---

## 3. 이벤트 핸들러

```jsx
function handleCheckboxChange(e) {
  const { value, checked } = e.target;

  if (checked) {
    // 체크 → 배열에 값 추가
    setCheckedItems((prev) => [...prev, value]);
  } else {
    // 체크 해제 → 해당 값 제거
    setCheckedItems((prev) => prev.filter((item) => item !== value));
  }
}
```

- 체크 여부에 따라 배열 업데이트
- `setCheckedItems`는 항상 **불변성 유지(새로운 배열 반환)**

---

## 4. 최종 컴포넌트

```jsx
import { useState } from "react";

export default function MultipleCheckboxes() {
  const options = [
    { id: 1, value: "스포츠" },
    { id: 2, value: "음악" },
    { id: 3, value: "영화" },
    { id: 4, value: "여행" },
  ];

  const [checkedItems, setCheckedItems] = useState([]);

  function handleCheckboxChange(e) {
    const { value, checked } = e.target;

    if (checked) {
      setCheckedItems((prev) => [...prev, value]);
    } else {
      setCheckedItems((prev) => prev.filter((item) => item !== value));
    }
  }

  return (
    <div>
      {options.map((option) => (
        <label key={option.id}>
          <inputtype="checkbox"
            value={option.value}
            checked={checkedItems.includes(option.value)}
            onChange={handleCheckboxChange}
          />
          {option.value}
        </label>
      ))}

      <div>
        <span>선택한 관심사</span>
        {checkedItems.map((item) => (
          <p key={item}>{item}</p>
        ))}
      </div>
    </div>
  );
}
```

---

## 5. 핵심 포인트

✅ 체크 여부(`checked`)에 따라 배열에 추가/제거

✅ `checked={checkedItems.includes(option.value)}` → 배열과 UI 동기화

✅ 불변성 유지(`prev.filter`, `prev.concat`) 필수

---