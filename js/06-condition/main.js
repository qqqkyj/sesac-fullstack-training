// 조건문의 기본 구조

// 여러줄 주석 : /* */
/*
if(조건식)
{
  //조건식이 참이면 실행되는 코드 영역
}
*/
if (5 > 1) {
	console.log("5는 1보다 크다.");
}

/* if ~ else if 조건문 기본 구조
if(조건식1)
{
  조건식1이 참이면 실행되는 코드 영역
}
else if(조건식2)
{
  조건식1이 거짓이고 조건식2가 참이면 실행되는 코드 영역
}
else if(조건식3)
{
  조건식1과 조건식2가 거짓이고 조건식3이 참이면 실행되는 코드 영역
}
*/

if (5 > 10) {
	console.log("5는 10보다 크다.");
} else if (5 > 7) {
	console.log("5는 7보다 크다.");
} else if (5 > 5) {
	console.log("5는 5보다 크다.");
} else if (5 > 3) {
	console.log("5는 3보다 크다.");
}

/* if ~ else if ~ else 조건문 기본 구조
if(조건식1)
{
  조건식1이 참이면 실행되는 코드 영역
}
else if(조건식2)
{
  조건식1이 거짓이고 조건식2가 참이면 실행되는 코드 영역
}
else
{
  위의 모든 조건식이 거짓인 경우 실행되는 코드 영역
}
---
if(조건식)
{
  조건식1이 참이면 실행되는 코드 영역
}
else
{
  조건식이 거짓인 경우 실행되는 코드 영역
}
*/

//변수 number를 선언하고, 숫자 1을 할당
let number = 1;

// number가 0보다 크면 "양수"를 콘솔에 출력
// number가 0보다 큰게 아니라면 음수"를 콘솔에 출력
//  if ~ else문 구현
if (number > 0) {
	console.log("양수");
} else {
	console.log("음수");
}

// 변수 number2를 선언하고, 0을 할당

// 만약에 변수 number2가 0보다 크면, "양수" 출력
// 만약에 변수 number2가 0보다 작으면, "음수" 출력
// 그런데 모두 아니라면, "0" 출력

// 조건문 코드 작성
let number2 = 0;

if (number2 > 0) {
	console.log("양수");
} else if (number2 < 0) {
	console.log("음수");
} else {
	console.log("0");
}

// 중첩 조건문
// 조건문 내부에 조건문을 중첩하는 조건문

// 만약에 숫자가 10보다 크고, 짝수이고, 5의 배수이고, 소수이고, -3을 했을 때..
// 위처럼 조건식이 복잡할 때 사용

// 변수 age를 선언하고, 숫자 25를 할당한다.
// 변수 isStudent를 선언하고, 불리언 true를 할당한다.

// 1. 변수 age가 20이상이라면
// 1-1. 변수 isStudent가 true라면
// 1-2. 변수 isStudent가 true가 아니라면

// 2. 변수 age가 20이상이 아니라면
// 2-1. 변수 isStudent가 true라면
// 2-2. 변수 isStudent가 true가 아니라면

let age = 25;
let isStudent = true;

if (age >= 20) {
	if (isStudent === true) {
		console.log("학생인 성인입니다.");
	} else {
		console.log("성인입니다.");
	}
} else {
	if (isStudent === true) {
		console.log("미성년자 학생입니다.");
	} else {
		console.log("미성년자입니다.");
	}
}

// 변수 score를 선언하고, 숫자 75를 할당한다
// 만약 변수 score가 90 이상이라면
// 그런데 만약 변수 score가 90 미만 그리고(&&), 80 이상이라면
// 그런데 만약 변수 score가 80 미만 그리고(&&), 70 이상이라면
// 그런데 만약 변수 score가 70 미만 그리고(&&), 60 이상이라면
// 그런데 모두 아니라면

let score = 75;

if (score >= 90) {
	console.log("A");
} else if (score >= 80) {
	console.log("B");
} else if (score >= 70) {
	console.log("C");
} else if (score >= 60) {
	console.log("D");
} else {
	console.log("F");
}
