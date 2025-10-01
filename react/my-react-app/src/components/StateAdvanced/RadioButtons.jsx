// src/components/StateAdvanced/RadioButtons.jsx
import { useState } from "react";

export default function RadioButtons() {
	const [selectedLevel, setSelectedLevel] = useState("");

	const levels = [
		{ id: 1, value: "입문" },
		{ id: 2, value: "초급" },
		{ id: 3, value: "중급" },
		{ id: 4, value: "고급" },
		{ id: 5, value: "전문가" },
	];

	function handleRadioChange(e) {
		setSelectedLevel(e.target.value);
	}

	return (
		<div>
			{/* 라디오 버튼 목록을 리스트 렌더링을 활용해서 표현 */}
			{levels.map((level) => (
				<label key={level.id}>
					<input
						type="radio"
						name="level" // 모든 라디오 버튼을 같은 그룹으로 묶는다
						value={level.value} // 라디오 버튼의 값
						// 상태 데이터와 현재 라디오 버튼의 value가 같으면 체크 되어 있다
						checked={selectedLevel === level.value}
						// 라디오 버튼의 값이 변경되면 handleRadioChange 함수를 호출한다
						onChange={(e) => {
							handleRadioChange(e);
						}}
					/>
					{level.value}
				</label>
			))}
			<p>선택된 레벨: {selectedLevel}</p>
		</div>
	);
}
