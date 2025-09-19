// 객체
// 0개 이상의 속성을 저장하는 자료형
// 속성 = key(이름) + value(값)
// {} 중괄호로 생성

// 변수 emptyObject를 선언하고
// 빈 객체를 할당
let emptyObject = {};

// key는 name
// value는 "홍길동" 인
// 속성 -> key: value

// 변수 person1 할당
let person1 = {
	name: "홍길동",
};

// 객체 생성 기본구조
// let 변수명 = {
// 	key1: value1,
// 	key2: value2,
// 	key3: value3,
// 	key4: value4,
// 	  ...
// };

// 객체 속성 접근
// 대괄호[] 사용
// 객체데이터[key]

// 마침표 .사용
// 객체데이터.key

// 변수 person2를 선언하고
// 객체 데이터
// {
// name: "홍길동",
// score: 99,
// pass: true,
// }

let person2 = { name: "홍길동", score: 99, pass: true, "성적 우수자": true };
// 객체 데이터 person2에서
// score key(이름)에 접근해서 value(값)을 출력
console.log(person2["score"]);
console.log(person2["성적 우수자"]);

// 객체의 key(이름)에 사용가능한 자료형
// 문자열, 심볼
console.log(person2.score);
// console.log(person2.성적 우수자); //띄어쓰기로 인한 오류 발생
// 대괄호만 사용하는 것을 권장

// 객체 속성 수정
// 1. 수정할 속성 접근
// 2. value 데이터 재할당
person2["name"] = "장영실";

// 객체 속성 추가
// 1. 추가할 속성(key) 접근
// 2. value 데이터 할당
person2["주소"] = "한국";
console.log(person2);
// 출력값: { name: '장영실', score: 99, pass: true, '성적 우수자': true, '주소': '한국' }

// 객체 속성 제거
delete person2["주소"];
console.log(person2);
// 출력값: { name: '장영실', score: 99, pass: true, '성적 우수자': true }

// 객체 함수
// 모든 key를 배열로 반환
let keyArray = Object.keys(person2);
console.log(keyArray);
// 출력값: [ 'name', 'score', 'pass', '성적 우수자' ]

// 모든 value를 배열로 반환
let valueArray = Object.values(person2);
console.log(valueArray);
// 출력값:[ '장영실', 99, true, true ]

// 모든 key, value를 배열로 반환
let keyValueArray = Object.entries(person2);
console.log(keyValueArray);
// 출력값
// [
//   [ 'name', '장영실' ],
//   [ 'score', 99 ],
//   [ 'pass', true ],
//   [ '성적 우수자', true ]
// ]

