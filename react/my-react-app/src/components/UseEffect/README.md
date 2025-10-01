# 💡 useEffect Hook

- **기본 구조**
  ```jsx
  useEffect(() => {
  	// 실행할 코드
  	return () => {
  		// cleanup 함수 (옵션, 언마운트 시 실행)
  	};
  }, [dependencies]);
  ```
  - 첫 번째 인자: 실행할 **콜백 함수**
  - 두 번째 인자: **의존성 배열 (dependencies)**
- 데이터를 감시하고, 데이터가 변경될 때마다 콜백 함수를 실행
  - `[]` → 컴포넌트가 **처음 마운트될 때만 실행** (1회 실행)
  - `[state]` → `state` 값이 바뀔 때마다 실행
  - 배열이 없는 경우 → **모든 렌더링마다 실행**되므로 보통 권장 ❌
- `useEffect()` 는 콜백 함수, 의존성 배열을 필수 인자로 받는다

# 📦 React에서 API 데이터 요청하기 (axios + useEffect)

## 🔹 **useEffect 규칙**

- useEffect의 콜백 함수는 직접 `async` 함수로 정의할 수 없다
- 콜백 함수 **내부에 `async` 함수를 정의해서 호출**한다
  **❌ 콜백 함수를 async 함수로 정의하면 안된다**

## 🔹 목표

- 컴포넌트가 **첫 렌더링될 때** DummyJSON API에서 상품 데이터를 요청
- 요청한 데이터를 상태(state)에 저장
- map()을 이용해 컴포넌트 반복 렌더링

---

## 🔹 핵심 포인트

1. **useEffect**
   - 의존성 배열 `[]`을 주면 → **컴포넌트 최초 마운트 시 1회 실행**
   - API 호출 같은 부수효과(side-effect)에 사용
2. **axios**
   - 비동기 요청을 쉽게 처리할 수 있는 라이브러리
   - async/await 문법과 함께 사용
3. **props 전달**
   - map으로 반복된 데이터를 **자식 컴포넌트(Product)** 에 props로 전달

---

## 🔹 코드

```jsx
import React, { useEffect, useState } from "react";
import axios from "axios";
import Product from "./Product";

export default function RequestData() {
	const [products, setProducts] = useState([]);

	useEffect(() => {
		// 데이터 요청 함수 정의
		async function getProducts() {
			const res = await axios("https://dummyjson.com/products");
			const data = res.data;
			console.log(data);
			// 상태에 products 배열 저장
			setProducts(data.products);
		}

		// 함수 실행
		getProducts();
	}, []); // 빈 배열: 첫 렌더링 시 한 번만 실행

	return (
		<div>
			{products.map((product) => (
				<Product product={product} key={product.id} />
			))}
		</div>
	);
}
```

---

## 🔹 실행 흐름

1. `RequestData` 컴포넌트가 렌더링됨
2. `useEffect` 실행 → `getProducts()` 호출
3. axios로 DummyJSON API(`https://dummyjson.com/products`) 호출
4. 응답 데이터에서 `products` 배열을 상태에 저장
5. `products.map()`으로 각 상품을 `<Product />` 컴포넌트에 props로 전달하여 렌더링

---

## 🔹 요약

- **useEffect** → 컴포넌트 라이프사이클 제어 (마운트 시 실행)
- **axios** → 비동기 API 호출
- **map + props** → 반복된 데이터 컴포넌트화
