// 배열 고차 메서드
// 배열 원소에 콜백 함수를 순차적으로 적용하는 메서드

// 매개변수에 곱하기 2 후 반환
function multiTwo(value) {
	return value * 2;
}

function higherOrderFunction(array, callbackFunction) {
	// 배열의 반복
	for (let element of array) {
		// 배열 내부 원소에 콜백 함수를 적용
		const result = callbackFunction(element);

		// 콜백 함수 결과를 출력
		console.log(result);
	}
}

numbers = [1, 2, 3, 4, 5];

// 각 원소에 곱하기 2를 출력
higherOrderFunction(numbers, multiTwo);
console.log("____________");

// 각 원소에 더하기 1을 출력
higherOrderFunction(numbers, (value) => {
	return value + 1;
});
console.log("____________");

// 각 원소를 제곱해서 출력
higherOrderFunction(numbers, (value) => {
	return value * value;
});
console.log("____________");

let numbers2 = [1, 2, 3, 4, 5];

// 배열 고차 메서드 forEach()
// 배열을 단순 반복

// 배열 고차 메서드 표현
function 콜백함수(element) {
	console.log("element");
}

numbers2.forEach(콜백함수);
console.log("____________");

// 콜백함수 => 배열을 순회하면서 원소 데이터 + 1 을 출력한다
// for...of 표현
for (let element of numbers2) {
	console.log(element + 1);
}

//_______________________________________________
// 배열 고차 메서드는
// 배열의 반복문을 함수화

let numbers3 = [1, 2, 3, 4, 5];

// 인덱스 반복문의 문제
// 1. 조건식 실수
// 2. 인덱스를 통해서 원소에 접근
for (let index = 0; index <= numbers3.length - 1; index++) {}

// for...of
// 1. 조건식 X
// 2. 원소에 바로 직접 접근
// for...of 문제점
// 1. 내부 로직 관리의 어려움
// for (let element of array) {
// 	// 내부 로직
// }

// 배열 고차메서드
// 1. 문법이 간결
// 2. 콜백함수로 반복작업을 유연하게 제어 가능
numbers3.forEach(콜백함수);

// 각 원소에 +1을 한 결과를 출력
let numbers4 = [1, 2, 3, 4, 5];

numbers4.forEach((element) => {
	// 배열의 원소에 반복적으로 수행할 로직 코드
	console.log(element + 1);
});
console.log("---------------------");

// 각 원소 중 2로 나눴을 때 나머지가 2인 원소만 출력
numbers4.forEach((element) => {
	// 배열의 원소에 반복적으로 수행할 로직 코드
	if (element % 2 == 0) console.log(element);
});
console.log("---------------------");

// 각 원소에 +1을 한 결과를 모아서 새로운 배열
const newArray = [];
numbers4.forEach((element) => {
	newArray.push(element + 1);
});
console.log(newArray);
console.log("---------------------");

// map() 활용
// 콜백 함수의 반환값을 원소로 모아서 새로운 배열 생성
const newArray2 = numbers4.map((element) => {
	// 반환값을 모아서 새로운 배열을 만듦
	return element + 1;
});
console.log(newArray2);
console.log("---------------------");

// map()을 활용해서 원소 * 2를 한 데이터를 모은 새 배열 생성
const newArray3 = numbers4.map((element) => {
	return element * 2;
});
console.log(newArray3);
console.log("---------------------");

// filter()
// 콜백 함수의 반환값이 true인 원소만 모아 새로운 배열 생성
const evenArray = numbers4.filter((element) => {
	return element % 2 == 0;
});
console.log(evenArray);
console.log("---------------------");

let todos = [
	{ task: "숙제하기", priority: "high", completed: false },
	{ task: "운동하기", priority: "medium", completed: true },
	{ task: "독서하기", priority: "high", completed: false },
	{ task: "청소하기", priority: "low", completed: false },
];

let highPriorityTodos = todos.filter((todo) => {
	return todo.priority === "high";
});

let incompleteTodos = todos.filter((todo) => {
	return !todo.completed;
});

console.log(highPriorityTodos); // 우선순위가 높은 할 일들
console.log(incompleteTodos); // 완료되지 않은 할 일들
console.log("---------------------");

// find()
//콜백 함수의 반환값이 true인 첫 번째 원소 반환
let findHightPriorityFirstTodo = todos.find((element) => {
	return element.priority === "high";
});

console.log(findHightPriorityFirstTodo);
console.log("---------------------");

// 1. 원소 중 짝수인 경우만 모아서 새로운 배열을 만든다 => filter
// 2. 새로운 배열의 원소+1 모아서 새로운 배열을 만든다 => map
// 아래 처럼 연속적으로 사용가능
let numbers5 = numbers4
	.filter((element) => {
		return element % 2 == 0;
	})
	.map((element) => {
		return element + 1;
	});

console.log(numbers5);
console.log("---------------------");

// reduce()
// 배열의 누적을 반환
const numbers10 = [1, 2, 3, 4, 5];
const result = numbers10.reduce((accValue, currElement) => {
	// accValue : 이전 반복동안 반환된 값을 누적한 데이터
	// currElement : 현재 원소

	// 반환값들이 누적된다
	return accValue + currElement;
	// accValue + 1
	//--------------
	// 0        + currElement(1) , => accValue = 1
	// 1        + currElement(2) , => accValue = 3
	// 3        + currElement(3) , => accValue = 6
	// 6        + currElement(4) , => accValue = 10
	// 10       + currElement(5) , => accValue = 15
});
console.log(result);
console.log("---------------------");

// sort()
// 배열을 정렬하는 고차 메서드
// 원소를 2개씩 비교하며 정렬
const numbers11 = [2, 6, 1, 9, 7];
numbers11.sort((a, b) => {
	// 정렬 기준
	// 반환값이 양수라면 a가 뒤로 이동
	// 반환값이 음수라면 a가 앞으로 이동
	// 반환값이 0이라면 이동X

	// 오름차순 (return a - b;와 같음 => 오름차순 축약형)
	// if (a < b) {
	// 	return -1; //작은 값이 앞으로 이동
	// }
	// if (b > a) {
	// 	return 1;
	// }
	// return 0;

	// 내림차순(return b-a;와 같음 => 내림차순 축약형)
	// if (a < b) {
	// 	return 1;
	// }
	// if (b > a) {
	// 	return -1;
	// }
	// return 0;
	return b - a;
});
console.log(numbers11);
console.log("---------------------");
