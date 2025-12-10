import { useState } from "react";

export default function ArrayState() {
	const [array, setArray] = useState([
		{ id: 1, name: "철수" },
		{ id: 2, name: "영희" },
		{ id: 3, name: "동수" },
	]);

	const handleAdd = () => {
		let newId = array.length + 1;
		let newName = `친구${newId}`;

		const newArray = [...array, { id: newId, name: newName }];

		setArray(newArray);
	};

	const handleRemove = () => {
		// 친구가 없으면 제거하지 않는다
		if (array.length === 0) {
			alert("친구가 없습니다.");
			return;
		}

		// 마지막 id 계산
		let lastId = array.length;

		// 기존 배열에서 마지막 id와 같은 데이터를 제외한 새로운 배열 생성
		const newArray = array.filter((item) => {
			if (item.id !== lastId) {
				return true;
			}
		});

		// 새로운 배열로 상태 업데이트
		setArray(newArray);
	};

	return (
		<div>
			<ul>
				{array.map((item) => (
					<li key={item.id}>{item.name}</li>
				))}
			</ul>
			<button
				onClick={() => {
					handleAdd();
				}}
			>
				친구 추가
			</button>
			<button
				onClick={() => {
					handleRemove();
				}}
			>
				친구 제거
			</button>
		</div>
	);
}
