// Navigate 컴포넌트 불러오기
import { Navigate } from "react-router-dom";

//useNavigate 훅 불러오기
import { useNavigate } from "react-router-dom";

export default function Profile() {
	// 로그인 상태 표시 가정용 변수
	const isLogin = true;

	// 로그인 상태가 아니라면
	// "/" 주소로 리다이렉트
	if (!isLogin) {
		// Navigate는 컴포넌트로 return 내부에 있어야 한다
		// replace 속성 : history(사용자가 페이지를 이동한 내역)에 쌓이지 않는다
		return <Navigate to="/"></Navigate>;
	}

	const navigate = useNavigate();

	return (
		<div>
			{/* onClick 속성에서 navigate 함수로 "/" 이동시키기 */}
			사용자 정보
			<button
				className="border p-2"
				onClick={() => {
					alert("홈페이지로 이동합니다.");
					// 페이지 이동 전 특정 로직을 수행할 때 사용
					navigate("/");
				}}
			>
				홈페이지로 이동
			</button>
		</div>
	);
}
