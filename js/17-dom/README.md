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
