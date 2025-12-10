// 인증 관련 페이지 관리 레이아웃
// 로그인 사용자의 접근을 막는다

import React from "react";
import { useSelector } from "react-redux";
import { Outlet, Navigate } from "react-router-dom";

export default function AuthLayout() {
	const token = useSelector((state) => state.auth.token);
	if (token) {
		// 로그인 사용자라면 스트리밍 채팅 페이지로 이동
		return <Navigate to="/"></Navigate>;
	} else {
		return <Outlet></Outlet>;
	}
}
