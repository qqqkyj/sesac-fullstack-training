import React from "react";
import { Link } from "react-router-dom";

export default function AuthHome() {
	return (
		<div>
			인증 홈페이지
			<div className="flex flex-col gap-4">
				{/* 로그인 페이지 이동 Link */}
				<Link to="/auth/login">로그인 페이지 이동</Link>
				{/* 회원가입 페이지 이동 Link */}
				<Link to="/auth/signup">회원가입 페이지 이동</Link>
			</div>
		</div>
	);
}
