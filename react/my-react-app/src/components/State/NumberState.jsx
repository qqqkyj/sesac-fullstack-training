import { useState } from "react";

export default function NumberState() {
	// 초기 값이 숫자 0인 상태를 생성한다
	const [numberState, setNumberState] = useState(0);

	const updateNumberState = () => {
		// 상태는 직접 수정할 수 없다
		// ❎ numberState = numberState + 1;

		// 새로운 숫자형 데이터를 생성해서 상태를 변경
		let newNumber = numberState + 1;
		setNumberState(newNumber);
	};

	return (
		<div>
			<p>{numberState}</p>
			<button
				onClick={() => {
					updateNumberState();
				}}
			>
				카운트 증가
			</button>
		</div>
	);
}
