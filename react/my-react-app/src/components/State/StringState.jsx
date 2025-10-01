import { useState } from "react";

export default function StringState() {
	// 초기 값이 문자열 ""인 상태를 생성한다
	const [stringState, setStringState] = useState("");

	const updateStringState = () => {
		// 상태는 직접 수정할 수 없다
		// ❎ stringState = "추가"

		// 새로운 문자열을 생성해서 상태를 변경
		let newString = `${stringState} 추가`;
		setStringState(newString);
	};

	return (
		<div>
			<p>{stringState}</p>
			<button
				onClick={() => {
					updateStringState();
				}}
			>
				문자열 추가
			</button>
		</div>
	);
}
