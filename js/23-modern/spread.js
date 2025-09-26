const obj1 = {
	name: "홍길동",
	age: 20,
	job: "개발자",
	location: "서울",
	country: "대한민국",
};

// 객체 복사
const obj2 = obj1; // obj1이 가리키는 "객체의 참조(주소값)를 그대로 복사"
console.log(obj1); //{ name: '홍길동', age: 20, job: '개발자', location: '서울', country: '대한민국' }
console.log(obj2); //{ name: '홍길동', age: 20, job: '개발자', location: '서울', country: '대한민국' }

obj2["location"] = "대구";
console.log(obj2); //{ name: '홍길동', age: 20, job: '개발자', location: '대구', country: '대한민국' }
console.log(obj1); //{ name: '홍길동', age: 20, job: '개발자', location: '대구', country: '대한민국' }

// ...스프레드 연산자를 활용한 복사
const obj3 = { ...obj1 }; //obj1의 속성을 펼쳐서(spread) "새로운 객체를 생성"
console.log(obj3); //{ name: '홍길동', age: 20, job: '개발자', location: '대구', country: '대한민국' }

obj3["name"] = "고길동";
console.log(obj3); //{ name: '고길동', age: 20, job: '개발자', location: '대구', country: '대한민국' }
console.log(obj1); //{ name: '홍길동', age: 20, job: '개발자', location: '대구', country: '대한민국' }

// 객체의 속성을 수정하면서 새로운 객체를 생성
