import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
// signup 액션: 회원가입 비동기 네트워트 처리 액션
// resetIsSignup 액션: isSignup 상태 초기화(false)액션
import { signup, resetIsSignup } from "../store/authSlice";
import { useNavigate } from "react-router-dom";

export default function Signup() {
	// 사용자 입력 이메일 관리 상태
	const [email, setEmail] = useState("");
	// 사용자 입력 비밀번호 관리 상태
	const [password, setPassword] = useState("");
	// dispatch함수
	const dispatch = useDispatch();
	// navigate함수
	const navigate = useNavigate();

	// 전역 상태 isSignup 불러오기
	const isSignup = useSelector((state) => state.auth.isSignup);

	// 전역 상태 error 불러오기
	const error = useSelector((state) => state.auth.error);

	function handleSubmit(e) {
		e.preventDefault(); //form의 기본 이벤트(동작) 막기
		// 비동기 처리 액션(authSlice에서 정의한 signup)을 디스패치(dispatch)로 실행
		dispatch(signup({ email: email, password: password }));
	}

	// 회원가입이 성공했을 때 알림창을 띄우고
	// useEffect를 활용해서 홈페이지로 이동 시키는 코드
	useEffect(() => {
		// 회원가입을 성공 했다면
		if (isSignup === true) {
			alert("회원가입을 성공했습니다. 메일함을 확인해 주세요.");
			dispatch(resetIsSignup);
			navigate("/");
		}
	}, [isSignup, dispatch]);

	// 회원가입 폼 구조
	return (
		<div>
			<form
				onSubmit={(e) => {
					handleSubmit(e);
				}}
			>
				<input
					className="border-2"
					type="email"
					value={email}
					onChange={(e) => {
						setEmail(e.target.value);
					}}
				/>
				<input
					className="border-2"
					type="password"
					value={password}
					onChange={(e) => {
						setPassword(e.target.value);
					}}
				/>
				<input className="border-2" type="submit" value="회원가입" />
			</form>
		</div>
	);
}
