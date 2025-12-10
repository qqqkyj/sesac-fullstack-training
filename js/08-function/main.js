// 숫자를 3개를 매개변수로 받아서 더한 숫자를 반환하는 함수

// 함수 선언은 function 키워드로 시작

// 매개변수가 3개인 함수
function add(num1, num2, num3) {
	// 함수를 호출할 때 실행될 코드 블럭
	// 숫자를 3개를 매개변수로 받아서 더한 숫자를 반환(생성)하는 함수
	// 함수가 생성하는 데이터 => 반환값
	return num1 + num2 + num3;
}

// 함수의 호출(call)
// 함수에 전달하는 데이터를 인자(argument)
const result1 = add(1, 2, 3);

const n1 = 1;
const n2 = 2;
const n3 = 3;
const result2 = add(n1, n2, n3);

console.log(`result1 = ${result1}`);
console.log(`result2 = ${result2}`);

// 매개변수 : 외부에서 들어온 데이터를 저장한 변수
// 인자 : 외부에서 전달한 데이터(값,변수)

// 함수 표현식 정의
// 두 숫자를 매개변수로 받아서 뺀 값을 반환하는 함수
const sub = function (num1, num2) {
	return num1 - num2;
};
console.log(`sub = ${sub(1, 2)}`);

const multi = (num1, num2) => {
	return num1 + num2;
};

// 매개변수와 반환값으로 구분한 함수 정의
// 매개변수 X, 반환값 X => 활용도가 극히 낮음
// "Hello World" 출력 함수
function sayHello() {
	console.log("Hello World");
}

const sayHelloArrow = () => {
	console.log("Hello World");
};

// 매개변수 X, 반환값 O => 활용도가 낮음
function createOne() {
	return 1;
}

const createOneArrow = () => {
	return 1;
};

// 매개변수 O, 반환값 X => 활용도가 높음
// 전달받은 매개변수(number)가 음수, 0, 양수 인지를 판단해서 출력
function determine(number) {
	if (number < 0) {
		console.log("음수");
	} else if (number > 0) {
		console.log("양수");
	} else {
		console.log("0");
	}
}

// 화살표 함수 표현 코드 작성
// 화살표 함수 : function X, 함수명 X

// 함수 선언식 -> 화살표 함수
// 1. function 키워드를 지운다
// 2. 함수명을 지운다
// 3. 매개변수 와 함수 몸체(코드블럭)를 => 연결한다
// 4. 변수를 선언하고 변수에 화살표 함수를 할당한다
const determineArrow = (number) => {
	if (number < 0) {
		console.log("음수");
	} else if (number > 0) {
		console.log("양수");
	} else {
		console.log("0");
	}
};

// 매개변수 O, 반환값 O => 활용도가 매우 높음

// 함수 선언식
// 매개변수가 짝수면 true 반환
// 매개변수가 홀수면 false 반환

// 1. 변수 선언
let number;
// 2. 기능 코드 작성
if (number % 2 == 0) {
	// 짝수
} else {
	// 홀수
}
// 3. 함수를 선언한다
// 4. 변수 -> 매개변수
// 5. 기능 코드 -> 함수 코드 블럭
// 6. 반환값을 작성
function evenOdd(number) {
	// 함수 코드 블럭
	if (number % 2 == 0) {
		// 짝수
		return true;
	} else {
		// 홀수
		return false;
	}
}

// 화살표 함수 표현 코드
const evenOddArrow = (number) => {
	if (number % 2 == 0) {
		// 짝수
		return true;
	} else {
		// 홀수
		return false;
	}
};

number = 10;
console.log(`숫자 ${number}(은)는 ${evenOddArrow ? "짝수" : "홀수"}입니다.`);
