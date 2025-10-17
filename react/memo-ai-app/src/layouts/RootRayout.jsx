import { Link, Outlet, useNavigate } from "react-router-dom";

// 로그아웃 버틈
// 로그인을 한 상태라면 사용자 정보를 출력
// (정상적으로 로그인 했을 경우)사용자 정보는 전역 상태 token에 저장된 상태

import { useDispatch, useSelector } from "react-redux";
import { jwtDecode } from "jwt-decode";
import { useEffect, useState } from "react";
import { logout } from "../store/authSlice";

export default function RootLayout() {
	// 전역상태 token
	const token = useSelector((state) => state.auth.token);
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
		dispatch(logout());
	}

	return (
		<div>
			<header className="bg-white shadow-md">
				<div className="container mx-auto px-6 py-4">
					<div className="flex items-center justify-between">
						<div className="flex items-center">
							<Link to="/" className="text-2xl font-bold text-gray-800">
								Memo AI
							</Link>
							<nav className="ml-10 flex space-x-8">
								<Link
									to="/memo/stream-chat"
									className="text-gray-600 hover:text-gray-900"
								>
									메모작성
								</Link>
								<Link
									to="/memo/profile"
									className="text-gray-600 hover:text-gray-900"
								>
									메모 목록
								</Link>
							</nav>
						</div>
						<div className="flex items-center">
							{token ? (
								<div>
									<button
										className="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-60"
										onClick={() => {
											handleLogout();
										}}
									>
										로그아웃
									</button>
								</div>
							) : (
								<div>
									<Link
										to="/login"
										className="text-gray-900 hover:bg-gray-600 x-4 p-2 rounded-lg  mr-6"
									>
										로그인
									</Link>
									<Link
										to="/signup"
										className="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600"
									>
										회원가입
									</Link>
								</div>
							)}
						</div>
					</div>
				</div>
			</header>

			<main>
				<Outlet />
			</main>
		</div>
	);
}
