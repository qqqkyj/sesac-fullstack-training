// useEffect hook 불러오기
import { useEffect, useState } from "react";

export default function Basic() {
	const [number, setNumber] = useState(0);
	const [number2, setNumber2] = useState(0);

	useEffect(() => {
		// API 요청
		// axios 사용할 때 async 함수를 사용
	});

	// useEffect 훅은 데이터를 생성하는 훅 X
	// 컴포넌트가 화면에 렌더링 될 때 useEffect가 실행
	useEffect(() => {
		// 콜백 함수
		// 화면 렌더링과 관련 없는 일을 한다
		// API 요청하기, 타이머 시작하기 등등
		console.log("의존성 배열이 없는 useEffect");
	});
	useEffect(() => {
		console.log("의존성 배열이 있는데 빈 배열인 useEffect");
	}, []);

	useEffect(() => {
		console.log("의존성 배열에 number 상태가 저장");
	}, [number]);

	useEffect(() => {
		console.log("의존성 배열에 number2 상태가 저장");
	}, [number2]);

	useEffect(() => {
		const intervalId = setInterval(() => {
			console.log("1");
		}, 1000);
		return () => {
			// 정리 함수
			// 컴포넌트가 인마운트(죽을 때) 실행되는 함수
			clearInterval(intervalId);
		};
	});

	return (
		<div>
			{/* onClick 속성의 화살표 함수에 setNumber(number + 1) 실행 */}
			<button
				className="border"
				onClick={() => {
					setNumber(number + 1);
				}}
			>
				{number}
			</button>

			{/* onClick 속성의 화살표 함수에서 setNumber2(number2 +1 ) 실행 */}
			<button
				className="border"
				onClick={() => {
					setNumber2(number2 + 1);
				}}
			>
				{number2}
			</button>
		</div>
	);
}
