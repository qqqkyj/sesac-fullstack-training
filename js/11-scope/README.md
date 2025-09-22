# 📝 let과 const 차이 정리

## 📌 예제 코드

```jsx
let globalVar = "전역 변수";
console.log(globalVar); // 전역 변수

const globalConst = "코드 블록 외부에서 선언한 상수";

if (true) {
	const conditionConst = "코드 블록 내부에서 선언한 상수";
	// globalConst = "전역 상수 재할당"; // ❌ TypeError: Assignment to constant variable.
	globalVar = "전역 변수 재할당"; // ✅ let 변수는 재할당 가능

	console.log(conditionConst); // "코드 블록 내부에서 선언한 상수"
}

console.log(globalVar); // "전역 변수 재할당"
// console.log(conditionConst); // ❌ ReferenceError: conditionConst is not defined
```

---

## 📌 정리

| 구분         | let                        | const                      |
| ------------ | -------------------------- | -------------------------- |
| **재할당**   | ✅ 가능                    | ❌ 불가능                  |
| **재선언**   | ❌ 불가능                  | ❌ 불가능                  |
| **스코프**   | 블록 스코프                | 블록 스코프                |
| **호이스팅** | 선언만 호이스팅 (TDZ 존재) | 선언만 호이스팅 (TDZ 존재) |

---

## 📌 주요 포인트

1. **`let`**
   - 값을 변경(재할당)할 수 있음
   - 블록 스코프를 가짐
   - 반복문, 조건문에서 자주 사용
2. **`const`**
   - 재할당 불가능 → 상수처럼 사용
   - 블록 스코프를 가짐
   - 객체나 배열을 `const`로 선언해도 내부 속성은 변경 가능
     ```jsx
     const arr = [1, 2, 3];
     arr.push(4); // ✅ 가능
     arr = [5, 6]; // ❌ TypeError
     ```
3. **공통점 (`let`, `const`)**
   - 모두 블록 스코프
   - 같은 스코프 내에서 재선언 불가능
   - 호이스팅 시 TDZ(Temporal Dead Zone)에 의해 선언 전에 접근하면 ReferenceError 발생

---

✅ **정리하면:**

- `값이 변할 수 있는 변수` → `let`
- `값을 절대 바꾸지 않을 변수` → `const`
- `var`는 특별한 이유가 없으면 사용 지양
