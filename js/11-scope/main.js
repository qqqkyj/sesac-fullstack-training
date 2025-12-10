let globalVar = "전역 변수";
console.log(globalVar); //전역 변수

const globalConst = "코드 블록 외부에서 선안한 상수";

if (true) {
	const conditionConst = "코드 블록 내부에서 선언한 상수";
	//globalConst = "전역 상수 재할당"; //TypeError: Assignment to constant variable.
	globalVar = "전역 변수 재할당"; //전역 변수의 const는 재할당 불가능, let은 가능

	console.log(conditionConst); //블록 상수
}

console.log(globalVar); //전역 변수
//console.log(conditionConst); //ReferenceError: conditionConst is not defined
