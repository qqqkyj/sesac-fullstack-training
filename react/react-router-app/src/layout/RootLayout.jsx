import React from "react";
import { Link } from "react-router-dom";

// Outlet 컴포넌트 불러오기
import { Outlet } from "react-router-dom";

export default function RootLayout() {
	return (
		<div>
			<div className="flex gap-4 p-2 border-2 border-gray-300">
				<Link to="/">홈페이지</Link>
				<Link to="/about">소개페이지</Link>
				<Link to="/profile">사용자 정보 페이지</Link>
				<Link to="/auth">인증 페이지</Link>
			</div>
			{/* Outlet 컴포넌트 : 중첩된 자식 컴포넌트가 위치할 구멍*/}
			<Outlet />
		</div>
	);
}
