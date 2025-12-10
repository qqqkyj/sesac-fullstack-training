# 📘 JavaScript 배열(Array) 기초 정리

## 1. 배열 생성

- **빈 배열**

```jsx
let emptyArray = [];
```

- **원소 하나**

```jsx
let oneArray = [1];
```

- **원소 여러 개**

```jsx
let manyArray = [1, 2, 3, 4];
```

> ⚡ 배열의 생성 요약
>
> - 빈 배열 : `[]`
> - 원소 하나 : `[1]`
> - 원소 여러 개 : `[1, 2, 3]` (쉼표로 구분)

---

## 2. 배열의 인덱스

- 배열 내부 원소의 **위치 번호**
- 시작: `0`
- 마지막: `배열 길이 - 1`

### 예시

```jsx
let array2 = [1, "2", 3];

console.log(array2[0]); // 첫 번째 원소
console.log(array2[1]); // 두 번째 원소
console.log(array2[2]); // 세 번째 원소

// 값 재할당
array2[0] = -1;
console.log(array2[0]); // -1
```

---

## 3. 원소 추가와 제거

### push() : 배열 끝에 원소 추가

```jsx
let array3 = [0];
array3.push(1);
console.log(array3); // [0, 1]
```

### pop() : 배열 마지막 원소 제거

```jsx
array3.pop();
console.log(array3); // [0]
```

> ⚡ push/pop → 스택(Stack) 구조 활용 가능

---

## 4. 배열 반복

### 4-1. for 반복문 (인덱스 활용)

```jsx
let array4 = [1, 2, 3];

for (let index = 0; index <= array4.length - 1; index++) {
	console.log(`${index} : ${array4[index]}`);
}
```

### 4-2. for...of 반복문 (원소 직접 접근)

```jsx
for (let element of array4) {
	console.log(element);
}
```

> ⚡ for...of → 인덱스 없이 배열 원소만 반복 가능

---

### 5. 배열 주요 속성/메서드 요약

| 속성 / 메서드  | 설명                  |
| -------------- | --------------------- |
| `.length`      | 배열의 길이           |
| `[index]`      | 특정 위치 원소 접근   |
| `.push(value)` | 배열 끝에 원소 추가   |
| `.pop()`       | 배열 마지막 원소 제거 |
