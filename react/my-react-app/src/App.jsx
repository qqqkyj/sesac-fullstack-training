import React from "react";
import Parent from "./components/PropsChildren/Parent";

// 파일과 동일한 함수는 컴포넌트 함수
// 컴포넌트 함수 : 태그(HTML 문서)를 생성하는 함수
// 컴포넌트 함수는 파일 당 하나만 존재
export default function App() {
	// 영역 1. 내부 기능 로직을 작성하는 영역
	// 이벤트 핸들러 함수를 정의
	// 이벤트 핸들러 함수 : 이벤트가 발생할 때 실행될 기능

	// ---------------------------------------------
	// 영역 2. 태그(HTML 문서)를 생성(return)하는 영역

	return (
		<div>
			{/* 컴포넌트 사용 */}
			<Parent></Parent>
		</div>
	);
}
