import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
// signup 액션: 회원가입 비동기 네트워트 처리 액션
// resetIsSignup 액션: isSignup 상태 초기화(false)액션
import { login } from "../store/authSlice";
import { useNavigate } from "react-router-dom";

export default function Login() {
	// 사용자 입력 이메일 관리 상태
	const [email, setEmail] = useState("");
	// 사용자 입력 비밀번호 관리 상태
	const [password, setPassword] = useState("");
	// dispatch함수
	const dispatch = useDispatch();
	// navigate함수
	const navigate = useNavigate();
	//token 상태는 로그인을 성공하면 값이 존재
	// 로그인을 안했다면 값이 null
	const token = useSelector((state) => state.auth.token);

	useEffect(() => {
		if (token) {
			alert("로그인 상태입니다.");
			console.log(token);
			//navigate("/profile");
		}
	}, [token]);

	function handleSubmit(e) {
		e.preventDefault(); //form의 기본 이벤트(동작) 막기
		// 비동기 처리 액션(authSlice에서 정의한 signup)을 디스패치(dispatch)로 실행
		console.log(`email:${email}, pwd: ${password}`);
		dispatch(login({ email: email, password: password }));
	}

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
				<input className="border-2" type="submit" value="로그인" />
			</form>
		</div>
	);
}
