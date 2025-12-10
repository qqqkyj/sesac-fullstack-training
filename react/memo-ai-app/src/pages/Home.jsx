import { Link, Outlet, useNavigate } from "react-router-dom";

// 로그아웃 버틈
// 로그인을 한 상태라면 사용자 정보를 출력
// (정상적으로 로그인 했을 경우)사용자 정보는 전역 상태 token에 저장된 상태

import { useSelector } from "react-redux";
import { jwtDecode } from "jwt-decode";
import { useEffect, useState } from "react";

export default function Home() {
	// 전역상태 token
	const token = useSelector((state) => state.auth.token);

	// 로그인 검증 로직
	// 사용자 정보 관리 상태
	const [decodeToken, setDecodeToken] = useState(null);
	useEffect(() => {
		if (token) {
			setDecodeToken(jwtDecode(token));
		}
	}, [token]);

	return (
		<div>
			<main className="container mx-auto p-6 text-center">
				<div className="max-w-3xl mx-auto py-24">
					<h1 className="text-6xl font-extrabold text-gray-900 mb-6 leading-tight">
						Memo AI
					</h1>
					<h2 className="text-4xl mb-6">지능형 메모 관리</h2>
					<p className="text-xl text-gray-600 mb-12">
						자연어로 할 일을 입력하면 AI가 자동으로 구조화된 메모로 변환해주는
						지능형 메모 관리 서비스입니다.
					</p>
					<div className="flex justify-center space-x-6">
						<Link
							to={token ? "/memo/stream-chat" : "/signup"}
							className="bg-gray-200 text-gray-800 font-bold px-8 py-4 rounded-lg hover:bg-blue-700 transition-transform transform hover:scale-105 duration-300"
						>
							{token ? "메모 작성" : "시작하기"}
						</Link>
						<Link
							to={token ? "/memo/profile" : "/login"}
							className="border-2 bg-gray-200 text-gray-800 font-bold px-8 py-4 rounded-lg hover:bg-gray-300 transition-transform transform hover:scale-105 duration-300"
						>
							{token ? "메모 목록" : "로그인"}
						</Link>
					</div>
				</div>
			</main>
		</div>
	);
}
