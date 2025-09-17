// 논리연산자
// 논리형(boolean형, true/false)을 기반으로한 연산자
const trueData = true;
const falseData = false;

// && (AND)
// 2개의 논리형 데이터가 참이면 참(true) 생성
// 1개라도 논리형 데이터가 거짓이면 거짓(false) 생성

// 템플릿 리터럴에는 변수뿐만 아니라 표현식을 삽입 가능
// 표현식 : 데이터를 생성하는 코드
console.log(`true && true -> ${trueData && trueData}`); //true
console.log(`true && false -> ${trueData && falseData}`); //false

//  || (OR)
// 1개라도 논리형 데이터가 참이면 참(true) 생성
// 2개의 논리형 데이터가 거짓이면 거짓(false) 생성
console.log(`true || false -> ${trueData || falseData}`); // true
console.log(`false || false -> ${falseData || falseData}`); //false

// ! (NOT)
// 1개의 논리형 데이터만 필요
// 논리형 데이터가 거짓이면 참(true) 생성
// 논리형 데이터가 참이면 거짓(false) 생성
console.log(`!true -> ${!trueData}`); //false
console.log(`!false -> ${!falseData}`); //true

// 같다 : == VS === / 다르다 : != VS !==
// == / !=
// 동등 비교
// 값(데이터)만 비교
// 서로 다른 자료형을 비교하면 자료형을 동일하게 변환
// 절대 절대 사용 금지!!
const number = 1; //number
const str = "1"; //String
const bool1 = number == str;
console.log(bool1); //true

// === / !==
// 동등 비교
// 데이터와 데이터의 자료형을 비교
// 값이 같아도 자료형이 다르면 다른 데이터로 판별
const bool2 = number === str;
console.log(bool2); //false
