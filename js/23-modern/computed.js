let key = "name";

const user = {
	//key는 문자열, 변수가 아니다
	key: "홍길동", //의도 - name: "홍길동"
};
console.log(user); //실제 데이터 - { key: '홍길동' }

// 템플릿 리터럴을 사용 X
// const user = {
// 	`${key}`: "홍길동",
// };

// 계산된 속성명(key) : [속성으로 사용할 변수]
// 변수를 속성의 key로 사용하고 싶을 때 사용하는 문법
const user3 = {
	// 변수를 대괄호로 감싸서 key로 표현
	[key]: "홍길동", //name: "홍길동"
};
console.log(user3); //{ name: '홍길동' }
