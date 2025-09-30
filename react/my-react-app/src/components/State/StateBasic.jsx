// 상태(State)를 사용하기 위한 모듈
import { useState } from "react";

// 리액트 훅(Hook)
// JS 함수와 유사한 개념이지만 함수는 아니다
// 함수 : 특정 동작을 수행하는 "코드 뭉치"
// 훅 : 리액트에서 특정 동작을 수행하는 "도구"
// useState 훅 : 리액트에서 상태 관리를 수행하는 "도구"

export default function StateBasic() {
	// useState 훅 사용
	// useState 훅은 배열[]을 생성한다
	// 배열에는 2개의 원소가 존재
	// [상태를 저장할 변수, 상태를 설정(변경)할 함수]

	// 배열의 구조 분해 할당을 활용
	/*
  let array = [1,2]
  const [one, two] = array
  one // 1
  two // 2
  */

	// const [one, two] = [상태를 저장할 변수, 상태(State)를 설정(변경)할 함수]
	const [somethingState, setSomethingState] = useState();
	const [something, setSomething] = useState();

	// 문자열 데이터로 관리하는 상태(State)
	// string은 상태 데이터를 저장할 변수
	// setString은 상태 데이터를 변경할 함수
	const [string, setString] = useState("문자열");

	function handleClick() {
		// 새로운 배열 데이터를 생성해서
		// 변수 newArray에 할당
		const newArray = [...array, array.length + 1];
		setArray(newArray);

		console.log("상태 변경");
		// 상태 데이터를 변경하는 코드

		// 상태 데이터를 저장한 변수를 직접 수정해서는 절대 안된다
		// string = "변경"

		// 변경할 데이터를 상태 변경 함수(setString)에 전달해야 한다
		setString("상태 변경");
	}

	const [array, setArray] = useState([1, 2, 3]);

	// 상태 변수의 이름은 number
	// 상태 업데이트 함수의 이름은 setNumber
	const [number, setNumber] = useState(0);

	function updateState() {
		setNumber(number + 1);
	}

	// 초기값 : 생성될 때 최초의 값
	return (
		<div>
			{string}
			{/* button 태그의 onClick 속성에서 함수 handleClick() 함수 실행 */}
			<button
				className="border-2 bg-violet-400"
				onClick={() => {
					handleClick();
				}}
			>
				상태 변경
			</button>

			<div>
				{array.map((e) => {
					return <li>{e}</li>;
				})}
			</div>

			<p>{number}</p>
			<button
				className="border-2 bg-violet-400"
				onClick={() => {
					// setNumber(number + 1);
					updateState();
				}}
			>
				증가
			</button>
		</div>
	);
}
