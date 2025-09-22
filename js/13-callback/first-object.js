// 함수 선언식
function 함수명() {}

// 함수 표현식
// 함수명이 없고 ,
// 변수에 할당
const functionExpression = function () {};

// 화살표 함수
// 함수명이 없고,
// 변수에 할당
const functionArrow = () => {};

// 일급 객체
// 2. 함수의 반환값으로 사용 가능하다
function calculator(operator) {
	if (operator === "더하기") {
		return (n1, n2) => {
			return n1 + n2;
		};
	}
	if (operator === "빼기") {
		return (n1, n2) => {
			return n1 - n2;
		};
	}
}

// 화살표 함수를 반환값으로 저장
const add = calculator("더하기");
// 아래와 같다고 볼 수 있음
// const add = (n1, n2) => {
// 			return n1 + n2;
// 		};
const sub = calculator("빼기");
console.log(add(10, 3));
console.log(sub(32, 13));

// 일급 객체
// 3. 함수의 인자로 전달
// 매개변수로 받은 연산 함수를 수행하고,
// 결과를 출력하는 함수
function calculator2(operatorFunction, n1, n2) {
	// 연산 함수를 수행
	const result = operatorFunction(n1, n2);

	// 연산 함수의 결과를 출력
	console.log(`{연산 결과 : ${result}}`);
}

calculator2(
	(a, b) => {
		return a + b;
	},
	1,
	2
);

// 더하기 연산을 수행하고 출력하는 함수
function addLog(a, b) {}
// 빼기 연산을 수행하고 출력하는 함수
function subLog(a, b) {}
// 곱하기 연산을 수행하고 출력하는 함수
function mulLog(a, b) {}
// 나누기 연산을 수행하고 출력하는 함수
function divLog(a, b) {}

// 비유

// 만약 각각의 함수로 만들었다면 (면_준비하기 X 소스_준비하기)개수의 함수 생성이 필요
// 즉, a: 면_준비하기, b: 소스_준비하기, c: 향신료_준비하기... 더 늘어난다면
// (a X b X c)개 만큼의 각각의 함수 생성이 필요
// 파스타 만들기: 어떤 면과 어떤 소스를 쓸지 "함수"로 전달
function 파스타_만들기(면_준비하기, 소스_준비하기) {
	면_준비하기();
	소스_준비하기();
	console.log("🍝 파스타 완성!");
}

// 면 준비 함수
function 스파게티면_준비하기() {
	console.log("➡️ 스파게티면 준비 완료");
}
function 푸실리면_준비하기() {
	console.log("➡️ 푸실리면 준비 완료");
}

// 소스 준비 함수
function 토마토소스() {
	console.log("➡️ 토마토소스 준비 완료");
}
function 크림소스() {
	console.log("➡️ 크림소스 준비 완료");
}

// 서로 다른 조합
파스타_만들기(스파게티면_준비하기, 토마토소스);
파스타_만들기(푸실리면_준비하기, 크림소스);
