# 📘 객체(Object) 기초 정리

## 1. 객체 생성

- **빈 객체**

```jsx
let emptyObject = {};
```

- **속성 1개**

```jsx
let person1 = {
	name: "홍길동",
};
```

- **속성 여러 개**

```jsx
let person2 = {
	name: "홍길동",
	score: 99,
	pass: true,
	"성적 우수자": true,
};
```

> ⚡ 객체 생성 기본 구조
>
> ```jsx
> let 변수명 = {
>     key1: value1,
>     key2: value2,
>     ...
> };
> ```

---

## 2. 객체 속성 접근

- **대괄호 `[]` 사용**

```jsx
console.log(person2["score"]); // 99
console.log(person2["성적 우수자"]); // true
```

- **마침표 `.` 사용**

```jsx
console.log(person2.score); // 99
// console.log(person2.성적 우수자); // 오류 발생 (띄어쓰기 포함 key)
```

> ⚡ key에는 문자열(String)과 심볼(Symbol) 사용 가능
>
> ⚡ 띄어쓰기 있는 key는 대괄호 사용을 권장

---

## 3. 객체 속성 수정/추가/삭제

- **수정**

```jsx
person2["name"] = "장영실";
```

- **추가**

```jsx
person2["주소"] = "한국";
console.log(person2);
// { name: '장영실', score: 99, pass: true, '성적 우수자': true, '주소': '한국' }
```

- **삭제**

```jsx
delete person2["주소"];
console.log(person2);
// { name: '장영실', score: 99, pass: true, '성적 우수자': true }
```

---

## 4. 객체 관련 함수

| 함수                  | 설명                          | 예시                                       |
| --------------------- | ----------------------------- | ------------------------------------------ |
| `Object.keys(obj)`    | 모든 key를 배열로 반환        | `['name', 'score', 'pass', '성적 우수자']` |
| `Object.values(obj)`  | 모든 value를 배열로 반환      | `['장영실', 99, true, true]`               |
| `Object.entries(obj)` | 모든 key, value를 배열로 반환 | `[['name','장영실'], ['score',99], ...]`   |

```jsx
let keyArray = Object.keys(person2);
let valueArray = Object.values(person2);
let keyValueArray = Object.entries(person2);

console.log(keyArray); // [ 'name', 'score', 'pass', '성적 우수자' ]
console.log(valueArray); // [ '장영실', 99, true, true ]
console.log(keyValueArray);
// [
//   [ 'name', '장영실' ],
//   [ 'score', 99 ],
//   [ 'pass', true ],
//   [ '성적 우수자', true ]
// ]
```
