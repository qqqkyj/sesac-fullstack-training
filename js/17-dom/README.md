<aside>

**💡DOM(Document Object Model) API**

</aside>

- HTML 문서를 **트리 구조의 객체**로 표현

## 📌 DOM 조작 예제 – `appendChild`

### 📝 코드

```html
<html>
	<body>
		<div id="container">
			<h1>Hello, World!</h1>
		</div>
		<script>
			const container = document.querySelector("#container"); // id="container" 선택
			const newH1 = document.createElement("h1"); // <h1> 요소 생성
			newH1.textContent = "Hello, DOM!"; // 텍스트 지정
			container.appendChild(newH1); // container에 새로운 <h1> 추가
		</script>
	</body>
</html>
```

---

### ⚙️ 동작 과정

1. **요소 선택**

   ```jsx
   const container = document.querySelector("#container");
   ```

   - `id="container"`인 요소를 선택한다.

2. **새로운 요소 생성**

   ```jsx
   const newH1 = document.createElement("h1");
   ```

   - `<h1>` 태그를 새로 만든다.

3. **텍스트 지정**

   ```jsx
   newH1.textContent = "Hello, DOM!";
   ```

   - 생성한 `<h1>`에 텍스트를 넣는다.

4. **자식으로 추가**

   ```jsx
   container.appendChild(newH1);
   ```

   - `container` 내부에 새로 만든 `<h1>`을 자식으로 삽입한다.

---

### 🖼 실행 결과

```html
<div id="container">
	<h1>Hello, World!</h1>
	<h1>Hello, DOM!</h1>
</div>
```

<aside>

**💡노드(태그 or 요소) 선택 및 조작**

</aside>

- **노드 선택(Select)**
  - **`querySelector(selector)`**
  - **선택자와 일치하는 첫 번째 노드** 반환
  - **주의사항**: 텍스트 수정 시, 자식 노드가 모두 제거되므로 주의

# 📌 DOM 선택 & 조작 실습

## 📝 코드

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Document</title>
		<style>
			.red {
				color: red;
			}
			.green {
				color: green;
			}
		</style>
	</head>
	<body>
		<div class="parent">
			<div class="child" id="first">
				<p></p>
				<p></p>
				<p></p>
			</div>
			<div class="child">
				<p></p>
				<p></p>
				<p></p>
			</div>
			<div class="child">
				<p></p>
				<p></p>
				<p></p>
			</div>
			<div class="child">
				<p></p>
				<p></p>
				<p></p>
			</div>
			<p></p>
			<p></p>
			<p></p>
		</div>

		<a href="" id="naver">네이버</a>

		<h1 id="red">red</h1>
		<h1 id="green">green</h1>

		<!-- script -->
		<script>
			// 1. 특정 요소 선택
			const divEl1 = document.querySelector("div"); // 첫 번째 <div>
			const divEl2 = document.querySelectorAll("div"); // 모든 <div>

			// 2. 클래스가 child인 요소들 선택
			const divEl3 = document.querySelectorAll(".child");

			// 3. id가 first인 요소 선택 후 텍스트 변경
			const firstChild = document.querySelector("#first");
			firstChild.textContent = "첫 번째 자식";

			// 4. 3초 뒤 텍스트 변경
			setTimeout(() => {
				firstChild.textContent = "3초 뒤";
			}, 3000);

			// 5. id="first"의 자식 <p> 태그들 텍스트 변경
			const pChildEle = document.querySelectorAll("#first > p");
			pChildEle.forEach((p) => {
				p.textContent = "first의 자식 p 태그";
			});

			// 6. class="parent"인 div 내용 비우기
			const divParent = document.querySelector("div.parent");
			divParent.textContent = "";

			// 7. <a> 태그 href 속성 변경
			const link = document.querySelector("a");
			link.setAttribute("href", "https://naver.com");

			// 8. <h1> 요소에 class 지정
			const redH1 = document.querySelector("#red");
			const greenH1 = document.querySelector("#green");
			redH1.className = "red";
			greenH1.className = "green";
		</script>
	</body>
</html>
```

---

## ⚙️ 동작 과정 정리

1. **요소 선택**
   - `querySelector("div")` → 첫 번째 `<div>`만 선택
   - `querySelectorAll("div")` → 모든 `<div>` 선택
   - `querySelectorAll(".child")` → `.child` 클래스 가진 요소들 선택
   - `querySelector("#first")` → `id="first"` 선택
2. **텍스트 조작**
   - `element.textContent = "..."` → 요소 내부 텍스트 변경
   - `setTimeout`으로 일정 시간 뒤에 다시 텍스트 수정 가능
3. **자식 선택자**
   - `#first > p` → `id="first"`의 **직계 자식** `<p>`만 선택
4. **내용 삭제**
   - `divParent.textContent = ""` → 해당 요소 내부 내용 전부 삭제
5. **속성 조작**
   - `setAttribute("href", "https://naver.com")` → 링크 변경
6. **클래스 지정**
   - `element.className = "red"` → 클래스 직접 할당
   - CSS에서 정의된 `.red`, `.green` 스타일이 적용됨

---

## 🖼 실행 결과 요약

- 처음에 `id="first"`에 `"첫 번째 자식"` 표시
- 3초 뒤 `"3초 뒤"`로 변경
- `#first > p` 자식 `<p>`들에 `"first의 자식 p 태그"` 삽입
- `div.parent` 내부 전체 내용 삭제 → `<div class="parent"></div>`
- `<a>` 링크는 네이버로 연결
- `<h1>` 두 개는 각각 빨강/초록색으로 표시됨

---

# 📌 DOM 조작 실습 – 노드 생성 및 삭제

## 📝 코드

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Document</title>
	</head>
	<body>
		<div id="parent">
			<div id="child"></div>
		</div>

		<script>
			// 1. <div> 요소 생성 + id 지정
			const divTag = document.createElement("div");
			divTag.setAttribute("id", "container");

			// 2. <p> 요소 생성 + 텍스트 지정
			const pTag = document.createElement("p");
			pTag.textContent = "pTag";

			// 3. body에 divTag, pTag 추가
			const bodyTag = document.querySelector("body");
			bodyTag.append(divTag, pTag);

			// 4. <h1> 요소 생성 + 텍스트 지정
			const h1Tag = document.createElement("h1");
			h1Tag.textContent = "h1";

			// 5. 특정 위치에 삽입 (insertBefore)
			const childTag = document.querySelector("#child"); // 기준 자식
			const parentTag = document.querySelector("#parent"); // 부모
			parentTag.insertBefore(h1Tag, childTag); // child 앞에 h1 삽입

			// 6. 자식 제거 (removeChild)
			parentTag.removeChild(childTag);

			// 7. 자기 자신 제거 (remove)
			h1Tag.remove();
		</script>
	</body>
</html>
```

---

## ⚙️ 동작 과정

1. **요소 생성**
   - `document.createElement("div")` → 새로운 `<div>` 생성
   - `setAttribute("id", "container")` → id 속성 추가
   - 같은 방식으로 `<p>`, `<h1>` 생성 가능
2. **요소 추가**
   - `bodyTag.append(divTag, pTag)`
     → `<body>` 안에 새로 만든 div와 p 추가
3. **특정 위치에 삽입**
   - `parentTag.insertBefore(h1Tag, childTag)`
     → `#parent` 안에서 `#child` 앞에 `<h1>` 삽입
4. **요소 제거**
   - `parentTag.removeChild(childTag)` → 부모 기준으로 특정 자식 제거
   - `h1Tag.remove()` → 자기 자신 제거

---

## 🖼 실행 흐름 (변화 과정)

- 초기 상태

```html
<div id="parent">
	<div id="child"></div>
</div>
```

- body에 div#container, p 추가

```html
<body>
	<div id="parent">
		<div id="child"></div>
	</div>
	<div id="container"></div>
	<p>pTag</p>
</body>
```

- parent 안에 child 앞에 h1 삽입

```html
<div id="parent">
	<h1>h1</h1>
	<div id="child"></div>
</div>
```

- child 제거 후

```html
<div id="parent">
	<h1>h1</h1>
</div>
```

- h1 자신도 제거 후 최종

```html
<div id="parent"></div>
<div id="container"></div>
<p>pTag</p>
```

<aside>
💡

**이벤트**

</aside>

# 📌 이벤트(Event)와 바닐라 JS / React 비교

## 1️⃣ 바닐라(순수) JavaScript

- **정의** : React, Vue 등 프레임워크 없이 사용하는 **순수 JavaScript**
- **특징**
  - HTML과 JS를 **분리**하여 작성
  - DOM 요소 선택 → 이벤트 핸들러 등록
  - 이벤트 등록 방법:
    1. HTML 속성 직접 지정 (`onclick`)
    2. DOM 속성 (`element.onclick`)
    3. 표준 방식 (`addEventListener`)

**예시 (addEventListener)**

```jsx
const btn = document.querySelector("button");
btn.addEventListener("click", () => {
	alert("클릭됨");
});
```

---

## 2️⃣ React

- **정의** : JSX 문법을 활용하여 작성하는 JavaScript 라이브러리
- **특징**
  - HTML과 JS를 **함께 작성 가능** (JSX)
  - 구조와 동작을 **한 코드 안에서 모두 정의**
  - 코드가 길어질 수 있음

**예시**

```jsx
function App() {
	const handleClick = () => alert("클릭됨");
	return <button onClick={handleClick}>Click</button>;
}
```

---

### 🔎 비교 요약

| 구분        | 바닐라 JS                    | React(JSX)                           |
| ----------- | ---------------------------- | ------------------------------------ |
| 구조        | HTML과 JS 분리               | HTML + JS 결합 (JSX)                 |
| 이벤트 등록 | addEventListener, onclick 등 | JSX props (onClick, onInput 등)      |
| 장점        | 단순, 가벼움                 | 구조와 동작 통합 가능, 재사용성 높음 |
| 단점        | 코드 길어질수록 복잡         | JSX 문법 학습 필요, 코드 길어짐      |

# 📌 자바스크립트 이벤트 처리 방식 비교

---

## ✅ 1. HTML 속성에 직접 지정 (`event-1.html`)

```html
<button onclick="clickEvent()">클릭</button>
<input type="text" oninput="console.log('입력')" />

<script>
	function clickEvent() {
		alert("클릭");
	}
</script>
```

- `onclick`, `oninput` 같은 속성을 HTML에 직접 작성
- 구조(HTML)와 동작(JS)이 섞여 있어 유지보수 어려움
- 간단한 예제나 테스트에 주로 사용

---

## ✅ 2. DOM 속성으로 핸들러 등록 (`event-2.html`)

```jsx
const btnTag = document.querySelector("button");
btnTag.textContent = "Click";
btnTag.onclick = () => {
	alert("클릭 클릭");
};

const bodyTag = document.querySelector("body");
bodyTag.insertBefore(document.createElement("input"), btnTag);

const inputTag = document.querySelector("input");
inputTag.oninput = () => {
	console.log("입력");
};
```

- HTML은 구조만, JS는 동작만 담당 → 분리됨
- `element.onclick = function` 형태로 핸들러 지정
- 하나의 이벤트에 **한 개의 핸들러만 등록 가능** (기존 핸들러 덮어씀)

---

## ✅ 3. `addEventListener` 사용 (`event-3.html`)

```jsx
// input 이벤트
inputTag.addEventListener("input", (e) => {
	const value = e.target.value;
	const pTag = document.querySelector("#message");
	pTag.textContent = value.length < 8 ? "글자가 8글자 미만입니다" : "";
});

// 버튼 클릭 이벤트 (여러 개 등록 가능)
btnTag.addEventListener("click", () => {
	alert("첫 번째 핸들러");
	alert(btnTag.textContent);
});
btnTag.addEventListener("click", (event) => {
	console.log(event.type); // 이벤트 종류
	console.log(event.target); // 이벤트 발생 요소
});

// a 태그의 기본 동작 취소
link.addEventListener("click", (event) => {
	event.preventDefault();
});
```

- `addEventListener(event, handler)` 방식
- 같은 이벤트에 **여러 개의 핸들러 등록 가능**
- `event` 객체를 활용해 이벤트 정보 접근 가능
- `event.preventDefault()` 로 기본 동작 취소 가능 (예: a 태그 이동 막기)

---

## 🔎 세 가지 방식 비교

| 방식                      | 장점                                  | 단점                            |
| ------------------------- | ------------------------------------- | ------------------------------- |
| HTML 속성 직접 지정       | 가장 단순, 빠르게 작성 가능           | 구조/동작 섞임, 유지보수 어려움 |
| DOM 속성 지정 (`onclick`) | 구조와 동작 분리                      | 이벤트 1개만 등록 가능          |
| `addEventListener`        | 표준적, 다중 핸들러 가능, 세밀한 제어 | 문법이 조금 더 길다             |

# 📌 Axios + DOM 조작 + 이벤트 처리

## 1. Axios CDN 사용

- `Axios`는 브라우저에서 비동기 HTTP 요청을 간단하게 처리할 수 있게 해주는 라이브러리.
- Node.js 환경에서는 `import axios from "axios";` 형태로 쓰지만, HTML에서 직접 사용할 때는 **CDN**을 통해 로드해야 함.

```html
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
```

---

## 2. 기본 구조

```html
<body>
	<div id="parent"></div>
	<button>클릭</button>
</body>
```

- `#parent` : API 응답 데이터를 표시할 영역
- `<button>` : 클릭 이벤트로 API 호출을 실행할 트리거

---

## 3. Axios 요청 기본 패턴

```jsx
const config = { url: `${DOMAIN_NAME}/products`, method: "get" };
const res = await axios(config);
const data = res["data"]; // 응답 전체 데이터
```

- `axios(config)` 형태로 호출
- `config` 객체에 **url**과 **method**를 지정
- 결과는 `res.data`에 들어 있음

---

## 4. 상품 목록 가져오기 (p 태그 추가)

```jsx
async function getProducts() {
	const config = { url: `${DOMAIN_NAME}/products`, method: "get" };
	const res = await axios(config);
	const products = res["data"]["products"];

	products.forEach((element) => {
		const title = element["title"]; // 상품 이름
		const pTag = document.createElement("p"); // <p> 태그 생성
		pTag.textContent = title; // 텍스트 설정
		parentTag.append(pTag); // #parent에 추가
	});
}
```

- 상품 데이터를 가져와서 `forEach()`로 반복
- 각 상품의 `title`을 `<p>` 태그로 만들어 화면에 추가

---

## 5. 전체 상품 데이터 확인

```jsx
async function getAllProducts() {
	const config = { url: `${DOMAIN_NAME}/products`, method: "get" };
	const res = await axios(config);
	const products = res["data"]["products"];
	console.table(products); // 콘솔에서 테이블 형식으로 출력
}
```

- 데이터만 확인할 때는 `console.table()` 활용 가능

---

## 6. 이벤트 리스너 (버튼 클릭 시 함수 실행)

```jsx
const btnTag = document.querySelector("button");

btnTag.addEventListener("click", () => {
	// getProducts();   // 화면에 상품 제목 표시
	getAllProducts(); // 콘솔에 데이터 출력
});
```

- `addEventListener("click", handler)`로 버튼 클릭 이벤트 등록
- 버튼 클릭 시 원하는 함수 실행 가능

---

## 7. 전체 코드

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Axios + DOM Example</title>
		<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
	</head>
	<body>
		<div id="parent"></div>
		<button>클릭</button>

		<script>
			const DOMAIN_NAME = "https://dummyjson.com";
			const parentTag = document.querySelector("#parent");

			async function getProducts() {
				const config = { url: `${DOMAIN_NAME}/products`, method: "get" };
				const res = await axios(config);
				const products = res["data"]["products"];

				products.forEach((element) => {
					const pTag = document.createElement("p");
					pTag.textContent = element["title"];
					parentTag.append(pTag);
				});
			}

			async function getAllProducts() {
				const config = { url: `${DOMAIN_NAME}/products`, method: "get" };
				const res = await axios(config);
				const products = res["data"]["products"];
				console.table(products);
			}

			const btnTag = document.querySelector("button");
			btnTag.addEventListener("click", () => {
				// getProducts();
				getAllProducts();
			});
		</script>
	</body>
</html>
```

---

✅ 요약

- **Axios** : CDN을 통해 불러와 사용
- **DOM 조작** : `createElement`, `textContent`, `append`
- **이벤트 처리** : `addEventListener("click", handler)`
- **데이터 출력** : 화면 출력(`append`) / 콘솔 출력(`console.table`)
