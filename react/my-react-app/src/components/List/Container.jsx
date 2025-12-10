import React from "react";
import User from "./User";

export default function Container() {
	// 반복 랜더링 할 배열 데이터
	const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

	// 객체 원소를 저장한 배열
	// id 속성의 값은 중복되지 않고, name 속성의 값은 중복될 수 있다
	// 객체의 id 속성은 서로 다른 객체들을 구별(식별)하기 위한 속성
	const userArray = [
		{ id: 1, name: "우영" },
		{ id: 2, name: "길동" },
		{ id: 3, name: "철수" },
		{ id: 4, name: "짱구" },
		{ id: 5, name: "영희" },
	];

	return (
		<div>
			{/* array 배열을 map()메서드로 반복 */}
			{array.map((element) => {
				// 원소(element)를 li태그에 감싸서 반환(return)
				return <li>{element}</li>;
			})}

			{/* userArray 객체 배열을 map()메서드로 반복 */}
			{userArray.map((user, index) => {
				// 원소(user)를 User태그에 감싸서 반환(return)
				// 반복의 대상이 되는 요소에 key라는 이름의 속성과 값을 설정해야 한다
				// key에 설정되는 값은 고유값(객체의 속성)이다
				// 반복 렌더리엥서 key 속성의 역할은
				// 동일하게 반복 생성된 컴포넌트를 구별(식별)하기 위한 구성
				return <User user={user} key={user["id"]}></User>;
			})}

			{/* map() X 표현 */}
			<User key={1} user={user[0]} />
			<User key={2} user={user[1]} />
			<User key={3} user={user[2]} />
			<User key={4} user={user[3]} />
			<User key={5} user={user[4]} />
		</div>
	);
}
