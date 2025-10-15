# 📦 Redux 쉽게 정리

## 💡 Redux란?

> 리액트 앱에서 전역 상태를 효율적으로 관리해주는 라이브러리

---

## 🎯 왜 Redux를 쓰는가?

### ✅ 전역 상태 관리

- 단일 컴포넌트가 아닌 **앱 전체에서 공유되는 상태**를 관리

### ❌ 지역 상태 관리의 한계

1. **Props Drilling**
   - 컴포넌트 깊이가 깊을수록 props를 계속 전달해야 함
2. **상태 동기화 문제**
   - 여러 컴포넌트가 같은 상태를 공유할 때, 동기화가 어려움
3. **디버깅 어려움**
   - 상태가 언제, 왜 바뀌었는지 추적하기 어려움

---

## 🧩 Redux의 주요 구성 요소

| 구성 요소            | 설명                                               |
| -------------------- | -------------------------------------------------- |
| **Action (액션)**    | 상태를 **어떻게 바꿔야 하는지**를 설명하는 객체    |
| **Reducer (리듀서)** | 액션을 받아서 **새로운 상태를 반환하는 순수 함수** |
| **Store (스토어)**   | 전역 상태(state)를 보관하는 **중앙 저장소**        |

### 🎯 용어 설명

- **액션 객체**:
  ```jsx
  { type: 'INCREMENT', payload: 1 }
  ```
  - `type`: 어떤 일이 일어났는지
  - `payload`: 필요한 데이터 (선택적)
- **순수 함수란?**
  - 같은 입력(state + action)에 대해 **항상 같은 출력(state)**
  - 외부 상태를 변경하지 않음 (불변성 유지)
  - **비동기 작업은 포함 X**

---

## 🔄 상태 흐름 요약

```
컴포넌트 → 액션 디스패치 → 리듀서 → 새 상태 생성 → 스토어 → UI 업데이트
```

1. 컴포넌트에서 **액션 디스패치(dispatch)**
2. 리듀서가 액션을 보고 상태를 업데이트
3. 새로운 상태가 스토어에 저장됨
4. 상태를 사용하는 컴포넌트는 자동으로 리렌더링

---

## 🧪 주요 Hook

| Hook          | 설명                            |
| ------------- | ------------------------------- |
| `useSelector` | 스토어에서 상태를 꺼내오는 함수 |
| `useDispatch` | 액션을 스토어에 전달하는 함수   |

---

## 🛠 Redux Toolkit

> Redux를 더 쉽고 간단하게 사용하도록 도와주는 공식 툴킷
>
> **Redux 팀도 권장함**

### ✅ 장점

- 복잡한 설정 없이 **더 간단한 문법**
- 액션, 리듀서를 **자동으로 생성**
- 내장된 **Immer** 라이브러리로 상태 불변성 자동 처리

### 주요 구성 요소

| 구성 요소        | 설명                                         |
| ---------------- | -------------------------------------------- |
| `createSlice`    | 액션 + 리듀서를 한 번에 만들 수 있는 함수    |
| `configureStore` | 여러 slice들을 합쳐서 스토어를 생성하는 함수 |

---

## 📁 Redux Toolkit 예시 (간단 카운터)

```jsx
// 1. Slice 만들기
import { createSlice } from "@reduxjs/toolkit";

const counterSlice = createSlice({
	name: "counter",
	initialState: { value: 0 },
	reducers: {
		increment: (state) => {
			state.value += 1;
		}, // Immer가 불변성 자동 유지
		decrement: (state) => {
			state.value -= 1;
		},
	},
});

export const { increment, decrement } = counterSlice.actions;
export default counterSlice.reducer;
```

```jsx
// 2. Store 설정
import { configureStore } from "@reduxjs/toolkit";
import counterReducer from "./counterSlice";

const store = configureStore({
	reducer: {
		counter: counterReducer,
	},
});

export default store;
```

```jsx
// 3. 컴포넌트에서 사용
import { useSelector, useDispatch } from "react-redux";
import { increment, decrement } from "./counterSlice";

function Counter() {
	const count = useSelector((state) => state.counter.value);
	const dispatch = useDispatch();

	return (
		<div>
			<button onClick={() => dispatch(decrement())}>-</button>
			{count}
			<button onClick={() => dispatch(increment())}>+</button>
		</div>
	);
}
```

```jsx
//src/main.jsx
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";

// Provider 컴포넌트 불러오기
// Redux 스토어 설정을 주입(제공)하는 컴포넌트
import { Provider } from "react-redux";
// 스토어 설정
import { store } from "./store";

createRoot(document.getElementById("root")).render(
	<StrictMode>
		<Provider store={store}>
			<App />
		</Provider>
	</StrictMode>
);
```

---

## ✅ 정리 요약

| 개념          | 설명                                                  |
| ------------- | ----------------------------------------------------- |
| Redux         | 전역 상태 관리 라이브러리                             |
| 문제 해결     | props 드릴링, 상태 동기화, 디버깅 문제                |
| 핵심 구성     | Action, Reducer, Store                                |
| 흐름          | dispatch → reducer → store 업데이트                   |
| Redux Toolkit | Redux를 더 쉽게 쓰기 위한 공식 도구                   |
| 주요 기능     | createSlice, configureStore, useSelector, useDispatch |

---

# 🚀 Redux 프로젝트 생성 & Redux Toolkit 설치 가이드

## 1️⃣ 프로젝트 생성 (Vite + React)

```bash
npm create vite@latest redux-app -- --template react
```

- `redux-app`: 프로젝트 폴더 이름
- `-template react`: Vite로 React 프로젝트 생성

### 👉 결과

Vite + React 기반의 빠르고 가벼운 React 프로젝트 생성됨

---

## 2️⃣ 프로젝트 폴더 이동

```bash
cd redux-app
```

---

## 3️⃣ 의존성 설치

```bash
npm install
```

- Vite, React 관련 기본 패키지 설치

---

## 4️⃣ Redux 관련 패키지 설치

```bash
npm install react-redux
npm install @reduxjs/toolkit
```

### 설치된 주요 패키지

| 패키지             | 설명                                              |
| ------------------ | ------------------------------------------------- |
| `react-redux`      | React에서 Redux를 사용할 수 있게 해주는 연결 도구 |
| `@reduxjs/toolkit` | Redux 사용을 간편하게 만들어주는 공식 툴킷        |

---

### 🚀 `Slice 생성` \*\*\*\*

1. toolkit에서 `createSlice` 불러오기
2. Slice 생성
3. 생성한 action과 reducer 내보내기
4. toolkit를 통해 `configureStore` 불러오기
5. `configureStore`로 `reducer` 연결하기

![alt text](image.png)

### **🚀 `useSelector(읽기)`**

1. `useSelector` 훅을 통해 store의 정보 불러오기
   - `useSelector`는 Redux store의 상태에서 필요한 **값만 꺼내오는 훅**입니다.
   - 위 코드에서 `state`는 **Redux 전체 store의 상태 트리**를 의미합니다.
   - `state.counter`는 **`configureStore()`에서 등록한 리듀서 이름**입니다.
   - `state.counter.value`는 `counter` 슬라이스의 현재 숫자 값입니다.
2. state.counter는 `state.counter`는 오른쪽 `store/index.js`에서 `counter`라는 이름으로 등록한 **슬라이스 리듀서**를 의미

![alt text](image-1.png)

### 🚀 `useDispatch(쓰기)`

1. `useDispatch` 훅을 통해 store의 액션을 실행할 준비
2. counterSlice의 `increment` 액션을 import하고 dispatch로 실행

- 내부 값으로 count 증가
  ![alt text](image-2.png)
- 외부 값(payload) 값 만큼 count 증가
  ![alt text](image-3.png)
