import { useState } from "react";

export default function ObjectState() {
	const [objectState, setObjectState] = useState({
		age: 19,
		name: "홍길동",
	});

	const updateObjectState = () => {
		// ... 연산자로 새로운 객체를 생성해서 변경
		// 수정할 속성만 새로운 값으로 변경
		let newObjectState = {
			...objectState,
			age: objectState.age + 1,
		};

		setObjectState(newObjectState);
  };
  
  const deleteObjectState = () => {
    // 구조 분해 할당과 나머지 연산자를 사용해서 삭제할 속성을 분리
    // age 속성만 분리
    const { age, ...rest } = objectState;

    // 삭제할 속성을 제외(rest)한 새로운 객체로 상태 업데이트
    setObjectState(rest);
  };

	return (
		<div>
			<p>이름 : {objectState.name}</p>
			<p>나이 : {objectState.age}</p>
			<button
				onClick={() => {
					updateObjectState();
				}}
			>
				나이 증가
			</button>
		</div>
	);
}
