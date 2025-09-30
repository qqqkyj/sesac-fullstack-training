# 💡 상태(State)와 Hook

### 1️⃣ Hook이란?

- **함수형 컴포넌트에서 상태 관리, 생명주기, 기타 React 기능을 사용할 수 있게 해주는 특수한 함수**
- React 16.8 이후 도입
- 특징
  - 이름이 `use`로 시작 (`useState`, `useEffect`, `useContext` 등)
  - **함수형 컴포넌트 최상위 레벨에서만 호출 가능**
    → 조건문, 반복문 안에서는 사용 불가

---

### 2️⃣ useState Hook

- 함수형 컴포넌트에서 **상태(state)를 관리**할 수 있는 가장 기본적인 Hook
- `useState(초기값)` → `[상태값, 상태 변경 함수]` 반환
- 상태는 컴포넌트 내부에서 **독립적으로 관리**
- 상태가 변경되면 해당 컴포넌트가 **리렌더링**
- 상태는 **직접 수정 불가**
  → 반드시 `setState` 함수(`setString`, `setArray` 등)를 통해 변경
- 리렌더링 시 새로운 값은 **새로운 메모리에 저장**, 이전 값은 **GC에 의해 정리**

```jsx
import { useState } from "react";

export default function StateExample() {
	// 문자열 상태
	const [string, setString] = useState("문자열");
	// 배열 상태
	const [array, setArray] = useState([1, 2, 3]);

	// 문자열 변경 함수
	const changeString = () => {
		setString("변경된 문자열");
	};

	// 배열에 새로운 값 추가
	const addToArray = () => {
		setArray([...array, array.length + 1]);
		// 기존 배열 복사 후 새로운 값 추가
	};

	return (
		<div>
			<h2>문자열 상태</h2>
			<p>{string}</p>
			<button onClick={changeString}>문자열 변경</button>

			<h2>배열 상태</h2>
			<ul>
				{array.map((item, index) => (
					<li key={index}>{item}</li>
				))}
			</ul>
			<button onClick={addToArray}>배열에 값 추가</button>
		</div>
	);
}
```

✅ 핵심 포인트

- `useState`는 **상태 변수 + setter 함수**를 반환
- setter 함수를 호출하면 React가 **리렌더링을 스케줄링**
- 리렌더링 시 UI가 **새로운 상태를 반영**
- 배열/객체 상태를 변경할 때는 **불변성 유지** 필요 (`...array` 등)
