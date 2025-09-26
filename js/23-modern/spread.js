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

// 새로운 객체를 생성하고, age 속성 수정
obj4 = { ...obj1 };
obj4["age"] = 21;

// 편한 방법
// 객체를 생성하면서 age 속성 수정,  planet 속성 추가
obj5 = { ...obj1, age: 21, planet: "지구" };
console.log(obj5);
// {
//   name: '홍길동',
//   age: 21,
//   job: '개발자',
//   location: '대구',
//   country: '대한민국',
//   planet: '지구'
// }

// 배열 데이터의 스프레드 연산자
let arr1 = [1, 2, 3, 4, 5];

// arr1의 "메모리 주소를 복사" (참조 자료형)
let arr2 = arr1;
arr2[0] = 0;
console.log(arr1); //[ 0, 2, 3, 4, 5 ]
console.log(arr2); //[ 0, 2, 3, 4, 5 ]

// 스프레드 연산자를 활용한 복사
// 스프레드 연산자로 "새로운 배열을 생성"해서 arr3에 할당(저장)
let arr3 = [...arr1];
arr3[0] = -1;
console.log(arr1); //[ 0, 2, 3, 4, 5 ]
console.log(arr3); //[ -1, 2, 3, 4, 5 ]

// 스프레드 연산자를 활요한 원소를 추가
let arr4 = [...arr1, 6, 7, 8];
console.log(arr4);
// [
//   0, 2, 3, 4,
//   5, 6, 7, 8
// ]

// react에서는 스프레드 연산자를 어떻게 사용할까?
// 원소가 객체인 배열
// 객체를 저장한 배열
let objectArr = [{ name: "철수", age: 20 }];

// 새로운 객체를 추가한 "새로운 배열" 생성
let newObjectArr = [...objectArr, { name: "영희", age: 20 }];
objectArr.push({ name: "영희", age: 20 });

console.log(objectArr); //[ { name: '철수', age: 20 }, { name: '영희', age: 20 } ]
console.log(newObjectArr); //[ { name: '철수', age: 20 }, { name: '영희', age: 20 } ]
