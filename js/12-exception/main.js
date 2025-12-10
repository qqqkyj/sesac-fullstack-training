// try {
// 	const constVar = "상수";
// 	constVar = "상수 재할당";
// } catch (error) {
// 	//오류 예외 처리
// 	console.log(`오류 발생: ${error}`);
// }

// console.log("야호");

// 예외 처리
try {
	// try 코드 블럭
	// 원래 실행할 코드
	// 내가 실행할 코드

	// 오류가 발생할만한 코드를 작성
	const test = "test";
	test = "hi";
} catch (error) {
	// catch 코드 블럭
	// try 코드 블럭이 오류가 발생할 때 실행할 코드
	// 오류의 정보를 저장하고 있는 객체
	console.log(`${error.name} : ${error.message}`);
} finally {
	// finally 코드 블럭
	// try ~ catch와 상관없이 무조건 실행되는 코드
	// try 코드 블럭의 오류 발생 여부와 관계없이 실행
	console.log("HELLO WORLD!");
}

function errorFunction() {
	try {
		console.log(number);
	} catch (error) {
		console.log(`${error.name} : ${error.message}`);
		return false;
	} finally {
		// return에 의해서 함수가 종료되어도 무조건 실행
		console.log("무조건 실행되는 코드 ? 1"); //실행 O
	}
	console.log("무조건 실행되는 코드 ? 2"); //실행 X
}

const result = errorFunction();
console.log(result);
