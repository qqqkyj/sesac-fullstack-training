// 형 변환
// 명시적 형 변환 : 개발자가 한 것
// 임시적 형 변환 : JS 엔진(번역기)이 자동으로 한 것

// 문자열로의 명시적 변환
// String() 함수 : 문자열로 변환하는 도구
// 함수 : 프로그래밍 언어의 특정 기능을 수행하는 도구

// String(데이터)/ String(변수)
console.log(String(123)); //숫자형 -> 문자열
console.log(String(123) === "123"); // true

// true, undefined, null을 문자열로 형변환 코드 작성
console.log(String(true));
console.log(String(undefined));
console.log(String(null));

// 숫자형 명시적 형 변환
// Number() 함수 : 숫자형으로 변환하는 도구
// Number(데이터) / Number(변수)
// 문자열 "123"을 숫자형으로 변환해서 출력(console.log())하는 코드 작성
console.log(Number("123") === 123); //true

// 만약, 숫자 형태가 아닌 문자열을 형변환하면?
// 0~9 숫자인데 알파벳? 한글?
// a1b2
//console.log(Number(a1b2)); // NaN(Not a Number)

// 불리언 명시적 형 변환
// 불리언 데이터 : 맞다(true) / 틀리다(false)
// Boolean() 함수 : 불리언으로 형변환하는 도구
console.log(Boolean("정우영"));

// 불리언 형 변환 규칙
// 각 자료형마다 최소 1개는 틀리다(false)로 변환 -> 0, -0, null, ""(빈문자열), 공백
// false가 아닌 데이터는 모두 맞다(true)로 변환
// 숫자형 -> 불리언 형 변환
console.log(Boolean(-1)); //true
console.log(Boolean(-1.1)); //true
console.log(Boolean(0)); //false
console.log(Boolean(99999999999)); //true

// 문자열 형 변환
console.log(Boolean("")); // false
console.log(Boolean(" ")); // false
