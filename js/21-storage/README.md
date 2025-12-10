
# 🌐 Axios HTTP 요청 정리 (POST, PUT, DELETE)


## 1️⃣ POST 요청

- **용도**: 서버에 **새로운 리소스 생성**
- **데이터 전송 방식**: 요청 본문(body)에 JSON 데이터 전송
- **특징**:
  - 서버에 새로운 데이터를 추가할 때 사용
  - 일반적으로 응답으로 **추가된 데이터 정보**를 반환

### 예제

```jsx
import axios from "axios";

const BASE_URL = "https://dummyjson.com";

// 새로운 레시피 추가
const addRecipe = async () => {
	try {
		const res = await axios.post(`${BASE_URL}/recipes/add`, {
			name: "Kimbap",
			cuisine: "Korean",
		});
		console.log("추가된 레시피:", res.data);
	} catch (err) {
		console.error(err);
	}
};

addRecipe();
```

**출력 예시**

```json
{ "id": 51, "name": "Kimbap", "cuisine": "Korean" }
```

---

## 2️⃣ PUT 요청

- **용도**: 서버에 존재하는 리소스를 **수정(전체 업데이트)**
- **데이터 전송 방식**: 요청 본문(body)에 수정할 전체 데이터 전송
- **특징**:
  - 기존 데이터가 없으면 생성(Create)되는 경우도 있음
  - 일부 필드만 수정할 경우 PATCH가 더 적합

### 예제

```jsx
import axios from "axios";

const BASE_URL = "https://dummyjson.com";

// id가 51인 레시피 수정
const updateRecipe = async () => {
	try {
		const res = await axios.put(`${BASE_URL}/recipes/51`, {
			name: "Kimbap Deluxe",
			cuisine: "Korean",
		});
		console.log("수정된 레시피:", res.data);
	} catch (err) {
		console.error(err);
	}
};

updateRecipe();
```

**출력 예시**

```json
{ "id": 51, "name": "Kimbap Deluxe", "cuisine": "Korean" }
```

---

## 3️⃣ DELETE 요청

- **용도**: 서버의 리소스를 **삭제**
- **데이터 전송 방식**: URL에 삭제할 리소스 식별자(ID) 포함
- **특징**:
  - 응답으로 삭제 성공 여부를 반환
  - body를 전송할 필요 없음

### 예제

```jsx
import axios from "axios";

const BASE_URL = "https://dummyjson.com";

// id가 51인 레시피 삭제
const deleteRecipe = async () => {
	try {
		const res = await axios.delete(`${BASE_URL}/recipes/51`);
		console.log("삭제 결과:", res.data);
	} catch (err) {
		console.error(err);
	}
};

deleteRecipe();
```

**출력 예시**

```json
{ "id": 51, "name": "Kimbap Deluxe", "cuisine": "Korean" }
```

---

## 4️⃣ 요약 표

| 요청 메서드 | 용도                  | 전송 데이터     | URL 사용 예시  | 특징                                            |
| ----------- | --------------------- | --------------- | -------------- | ----------------------------------------------- |
| POST        | 새로운 리소스 생성    | body(JSON)      | `/recipes/add` | 서버에 데이터 추가, 응답으로 추가된 데이터 반환 |
| PUT         | 기존 리소스 전체 수정 | body(JSON)      | `/recipes/51`  | 존재하면 수정, 없으면 생성 가능                 |
| DELETE      | 리소스 삭제           | 없음 (URL에 ID) | `/recipes/51`  | 삭제 성공 여부 반환                             |

---

## 🌐 Web Storage 정리

### 1️⃣ Local Storage (로컬 스토리지)

- **데이터 보존 기간**: 영구적 (사용자가 직접 삭제하기 전까지 유지)
- **탭/창 공유**: 같은 도메인이라면 모든 탭/창에서 공유됨
- **활용 예시**:
  - 로그인 상태 유지
  - 다크 모드/테마 설정 저장
  - 장바구니 데이터 저장

```jsx
// 저장
localStorage.setItem("theme", "dark");
// 조회
localStorage.getItem("theme"); // "dark"
// 삭제
localStorage.removeItem("theme");
// 전체 삭제
localStorage.clear();
```

---

### 2️⃣ Session Storage (세션 스토리지)

- **데이터 보존 기간**: 브라우저 탭이 열려 있는 동안만 (탭 닫으면 사라짐)
- **탭/창 공유**: 공유되지 않음 (같은 도메인이라도 탭마다 독립적)
- **활용 예시**:
  - 임시 폼 데이터 저장
  - 일회성 상태값 저장 (ex. 페이지 이동 시 유지, 탭 닫으면 삭제)

```jsx
// 저장
sessionStorage.setItem("draft", "hello");
// 조회
sessionStorage.getItem("draft"); // "hello"
// 삭제
sessionStorage.removeItem("draft");
// 전체 삭제
sessionStorage.clear();
```

✅ 요약

| 구분        | Local Storage          | Session Storage        |
| ----------- | ---------------------- | ---------------------- |
| 데이터 보존 | 영구적 (삭제 전까지)   | 탭 닫으면 삭제         |
| 공유 범위   | 같은 도메인 모든 탭/창 | 탭마다 독립            |
| 대표 활용   | 장바구니, 사용자 설정  | 임시 입력값, 세션 상태 |
