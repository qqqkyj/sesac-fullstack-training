import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { login } from "../store/authSlice";
import { useNavigate, Link } from "react-router-dom";

export default function Login() {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const dispatch = useDispatch();
	const navigate = useNavigate();

	const token = useSelector((state) => state.auth.token);
	const error = useSelector((state) => state.auth.error);

	useEffect(() => {
		if (token) {
			alert("로그인 상태입니다.");
			console.log(token);
			navigate("/");
		}
	}, [token]);

	useEffect(() => {
		if (error) {
			alert(
				` error code: ${error.code}\n error_code: ${error.error_code}\n msg: ${error.msg} \n 이메일 또는 비밀번호가 일치하지 않습니다.`
			);
		}
	}, [error]);

	function handleSubmit(e) {
		e.preventDefault();
		console.log(`email:${email}, pwd: ${password}`);
		dispatch(login({ email: email, password: password }));
	}

	return (
		<div className="flex items-center justify-center min-h-screen bg-gray-100">
			<div className="w-full max-w-md p-8 space-y-6 bg-white rounded-lg shadow-md">
				<h2 className="text-2xl font-bold text-center text-gray-900">로그인</h2>
				<form
					className="space-y-6"
					onSubmit={(e) => {
						handleSubmit(e);
					}}
				>
					<div>
						<label
							htmlFor="email"
							className="text-sm font-medium text-gray-700"
						>
							이메일 주소
						</label>
						<input
							id="email"
							type="email"
							value={email}
							onChange={(e) => setEmail(e.target.value)}
							required
							className="w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
						/>
					</div>
					<div>
						<label
							htmlFor="password"
							className="text-sm font-medium text-gray-700"
						>
							비밀번호
						</label>
						<input
							id="password"
							type="password"
							value={password}
							onChange={(e) => setPassword(e.target.value)}
							required
							className="w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
						/>
					</div>
					<div className="flex flex-col space-y-2">
						<button
							type="submit"
							className="w-full px-4 py-2 font-medium text-white bg-indigo-600 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
						>
							로그인
						</button>
						<Link
							to="/signup"
							className="w-full px-4 py-2 font-medium text-center text-indigo-600 bg-white border border-indigo-600 rounded-md hover:bg-indigo-50"
						>
							회원가입
						</Link>
						<Link
							to="/"
							className="w-full px-4 py-2 font-medium text-center text-gray-700 bg-gray-200 rounded-md hover:bg-gray-300"
						>
							처음으로
						</Link>
					</div>
				</form>
			</div>
		</div>
	);
}
