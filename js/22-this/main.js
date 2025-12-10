// 중괄호로 표현되는 자료형
// 객체의 특징 : key - value 속성으로 구성
// 함수도 value가 될 수 있음. 이러한 함수를 메서드라고 한다
// 즉, 객체에 포함된 함수는 메서드라고 한다
const obj = {
	name: "홍길동",
	age: 20,
	// 함수명이 없다 -> 함수 표현식
	// 속성의 key가 func이고, value는 함수
	func: function () {
		console.log(this);
		// 여기서 this는 객체 obj와 동일하다
	},
};
//obj 객체의 func 메서드를 실행(호출)
obj.func(); //{ name: '홍길동', age: 20, func: [Function: func] }

const user = {
	name: "홍길동",
	age: 20,
	// 인사를 출력하는 함수(메서드)
	greet: function () {
		console.log(`Hello ${this.name}`);
	},
};
user.greet();

// 화살표 함수로 표현한 메서드는 함수 선언식(표현식, function 키워드를 사용한 함수) 작동 방식이 다르다
const user2 = {
	name: "홍길동",
	age: 20,
	// 화살표 함수로 메서드를 표현
	greet: () => {
		console.log(this); //{}
	},
};
user2.greet();

//function으로 표현한 메서드 결과 : { name: '홍길동', age: 20, func: [Function: func] }
// 화살표 함수로 표현한 메서드 결과 : {}
//console.log(this); //함수가 아닌 곳에서 실행한 this : {}

const user3 = {
	name: "홍길동",
	age: 20,
	greet: function () {
		// ① function 키워드로 정의한 메서드의 this
		console.log(this);
		// 👉 user3 객체를 가리킴
		// { name: '홍길동', age: 20, greet: [Function: greet] }

		// ② 메서드 안에서 선언된 화살표 함수
		const arrowFunc = () => {
			console.log(this);
			// 👉 화살표 함수는 자신만의 this를 가지지 않고
			// 상위 스코프(greet 함수)의 this를 그대로 사용
		};
		arrowFunc();
	},
};

user3.greet();
