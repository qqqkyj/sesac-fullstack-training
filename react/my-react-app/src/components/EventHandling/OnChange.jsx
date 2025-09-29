export default function OnChange() {
	//change 이벤트의 핸들러 함수 정의
	// 핸들러 함수 이름 규칙: handle 이벤트명

	// 이벤트 핸들러의 event 객체 : 이벤트 정보를 저장한 객체
	function handleChange(event) {
		console.log(event["target"]["value"]);
	}

	// 실습 1.
	function handleNumberChange(event) {
		// 사용자 입력 값이 10보다 작으면
		// console.log()를 사용해서 "10보다 작은 수"라고 출력
		const value = event["target"]["value"];
		if (value < 10) {
			console.log("10보다 작은 수 ");
		}
	}

	return (
		<div>
			{/* 실습 2. */}
			{/* onChange 이벤트 속성에서 handleNumberChange 호출 */}
			{/*  */}
			<input
				className="border-1 border-amber-400"
				type="text"
				onChange={(e) => {
					handleNumberChange(e);
				}}
			/>

			{/* onChange 이벤트 속성 적용 */}
			<input
				className="border-1 border-amber-400"
				type="text"
				// 이벤트 객체 event는 화살표 함수의 매개변수
				onChange={(event) => {
					// handleChange 함수 호출
					// event 인자는 그럼 어디서? 화살표 함수의 매개변수 event에서 가져온다
					handleChange(event);
				}}
			/>
		</div>
	);
}
