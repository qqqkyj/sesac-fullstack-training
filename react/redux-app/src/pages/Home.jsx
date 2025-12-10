import React from "react";
import { Link } from "react-router-dom";

export default function Home() {
	return (
		<div>
			<Link to="/signup">회원가입 페이지</Link>
			<Link to="/login">로그인 페이지</Link>
			<Link to="/profile">프로필 페이지</Link>
		</div>
	);
}
