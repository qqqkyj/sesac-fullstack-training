# 🖱️ 이벤트 전파 (Event Propagation)

## 1. 이벤트 전파의 3단계

### ① 캡처링 (Capturing Phase)

- **최상위 요소 → 이벤트가 발생한 요소까지 내려가는 과정**
- 흐름:
    
    `window` → `document` → `<html>` → `<body>` → `div` → ... → **이벤트 발생 요소**
    

📄 **예제 (capture.html)**

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
		<div id="child">
			<button id="button">클릭</button>
		</div>
	</div>
	<script>
		const parent = document.querySelector("#parent");
		const child = document.querySelector("#child");
		const button = document.querySelector("#button");

		// { capture: true } 옵션 추가
		parent.addEventListener("click", () => {
			console.log("parent 클릭");
		}, { capture: true });

		child.addEventListener("click", () => {
			console.log("child 클릭");
		}, { capture: true });

		button.addEventListener("click", () => {
			console.log("button 클릭");
		}, { capture: true });
	</script>
</body>
</html>

```

📌 **결과 (클릭 시 실행 순서)**

```
parent 클릭
child 클릭
button 클릭

```

---

### ② 타겟 (Target Phase)

- **실제 이벤트가 발생한 요소(button 등)에서 이벤트가 처리되는 과정**

---

### ③ 버블링 (Bubbling Phase)

- **이벤트 발생 요소 → 최상위 요소로 올라가는 과정**
- 흐름:
    
    이벤트 발생 요소 → `div` → `<body>` → `<html>` → `document` → `window`
    

📄 **예제 (버블링)**

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
		<div id="child">
			<button id="button">클릭</button>
		</div>
	</div>
	<script>
		const parent = document.querySelector("#parent");
		const child = document.querySelector("#child");
		const button = document.querySelector("#button");

		// 기본값: { capture: false }
		parent.addEventListener("click", () => {
			console.log("parent 클릭");
		});

		child.addEventListener("click", () => {
			console.log("child 클릭");
		});

		button.addEventListener("click", () => {
			console.log("button 클릭");
		});
	</script>
</body>
</html>

```

📌 **결과 (클릭 시 실행 순서)**

```
button 클릭
child 클릭
parent 클릭

```

---

## 2. 이벤트 위임 (Event Delegation)

- 여러 개의 **자식 요소**에 각각 이벤트 핸들러를 등록하는 대신,
    
    **부모 요소에 이벤트 핸들러를 한 번만 등록**하는 방식
    
- 이벤트 버블링을 활용
- **React**에서는 이벤트 위임이 기본적으로 적용됨

📄 **예제**

```jsx
const parent = document.querySelector("#parent");

parent.addEventListener("click", (e) => {
	if (e.target.tagName === "BUTTON") {
		console.log(`${e.target.innerText} 버튼 클릭됨`);
	}
});

```