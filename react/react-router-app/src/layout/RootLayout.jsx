import React from "react";
import { Link } from "react-router-dom";

// Outlet 컴포넌트 불러오기
import { Outlet } from "react-router-dom";

// 경로 상수 객체 불러오기
import PATHS from "../constants/paths";

export default function RootLayout() {
	return (
		<div>
			<div className="flex gap-4 p-2 border-2 border-gray-300">
				<Link to={PATHS.ROOT.INDEX}>홈페이지</Link>
				{/* 절대 경로 로 표현한 경로(path) */}
				{/* "/"로 시작하는 경로 표현 : 절대 경로 */}
				<Link to={PATHS.ROOT.ABOUT}>소개페이지</Link>
				<Link to={PATHS.ROOT.PROFILE}>사용자 정보 페이지</Link>
				<Link to={PATHS.AUTH.INDEX}>인증 페이지</Link>
				<Link to="/dummy">DummyJSON 실습 페이지</Link>
				<Link to={PATHS.ROOT.POSTS}>Post 목록 페이지</Link>
			</div>
			{/* Outlet 컴포넌트 : 중첩된 자식 컴포넌트가 위치할 구멍 */}
			<Outlet />
		</div>
	);
}
