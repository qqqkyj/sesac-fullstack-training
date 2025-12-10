import React from "react";

// isAdmin Props 데이터를 매개변수에서 받는다.
export default function AdminLink({ isAdmin }) {
	return (
		<div>
			{/* isAdmin 이 참(true) 이라면 "관리자" 문자열을 표시 */}
			{/* isAdmin 이 거짓(false) 이라면 "일반 사용자" 문자열을 표시 */}
			<div>{isAdmin ? "관리자" : "일반 사용자"}</div>

			{/* && 연산자를 활용 */}
			{/* isAdmin이 참이라면 <a>관리 페이지 이동</a> 라는 요소를 화면에 표시 */}
			{isAdmin && (
				<a className="text-blue-500 cursor-pointer">관리 페이지 이동</a>
			)}
		</div>
	);
}
