// 로그아웃 버틈
// 로그인을 한 상태라면 사용자 정보를 출력
// (정상적으로 로그인 했을 경우)사용자 정보는 전역 상태 token에 저장된 상태

import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";

import { jwtDecode } from "jwt-decode";
import { useEffect, useState } from "react";
import { logout } from "../store/authSlice";

export default function Profile() {
	// 전역상태 token
	const token = useSelector((state) => state.auth.token);
	const navigate = useNavigate();
	const dispatch = useDispatch();

	// 로그인 검증 로직
	// 사용자 정보 관리 상태
	const [decodeToken, setDecodeToken] = useState(null);
	useEffect(() => {
		if (token) {
			setDecodeToken(jwtDecode(token));
		}
	}, [token]);

	function handleLogout() {
		console.log("handleLogout시작");
		dispatch(logout());
	}

	return (
		<div>
			{decodeToken ? (
				`이메일: ${decodeToken.email}`
			) : (
				<Link to="/login">로그인</Link>
			)}
			<div>
				<button
					className="border-2"
					onClick={() => {
						handleLogout();
					}}
				>
					로그아웃
				</button>
			</div>
		</div>
	);
}
