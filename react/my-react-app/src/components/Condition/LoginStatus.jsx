import React from "react";

export default function LoginStatus({ isLogin, userName }) {
	return (
		<div>
			{/* 삼항연산자를 사용해서 표현 */}
			{/* 삼항연산자 문법 : 조건식 ? "참일 때 요소" : "거짓일 떄 요소" */}
			{/* isLogin이 참이면 <p>로그인 상태</P> */}
			{/* isLogin이 거짓이면 <p>비 로그인 상태</P> */}
			<p>로그인 상태 : {isLogin ? " 로그인" : "비 로그인"} 상태</p>
			{/* button 태그 내부에 삼항연산자를 사용한다 */}
			{/* 조건식은 isLogin이 */}
			{/* 참이면 문자열 "로그아웃" 생성 */}
			{/* 거짓이라면 문자열 "로그인" 생성 */}
			<button className="border-2 bg-gray-300">
				{isLogin ? "로그아웃" : "로그인"}
			</button>
			{/* isLogin이 true라면 `${userName}님 환영합니다 */}
			{/* isLogin이 false라면 '로그인 해주세요` */}
			<p>{isLogin ? `${userName}님 환영합니다` : `로그인 해주세요`}</p>
		</div>
	);
}
