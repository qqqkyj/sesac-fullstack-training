import { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { signup, resetIsSignup } from "../store/authSlice";
import { useNavigate, Link } from "react-router-dom";

export default function Signup() {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const [passwordConfirm, setPasswordConfirm] = useState("");
	const dispatch = useDispatch();
	const navigate = useNavigate();

	const isSignup = useSelector((state) => state.auth.isSignup);
	const error = useSelector((state) => state.auth.error);

	function handleSubmit(e) {
		e.preventDefault();
		if (password !== passwordConfirm) {
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		dispatch(signup({ email: email, password: password }));
	}

	useEffect(() => {
		if (isSignup === true) {
			alert("회원가입을 성공했습니다. 메일함을 확인해 주세요.");
			dispatch(resetIsSignup());
			navigate("/");
		}
	}, [isSignup, dispatch, navigate]);

	return (
		<div className="flex items-center justify-center min-h-screen bg-gray-100">
			<div className="w-full max-w-md p-8 space-y-6 bg-white rounded-lg shadow-md">
				<h2 className="text-2xl font-bold text-center text-gray-900">
					회원가입
				</h2>
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
					<div>
						<label
							htmlFor="passwordConfirm"
							className="text-sm font-medium text-gray-700"
						>
							비밀번호 확인
						</label>
						<input
							id="passwordConfirm"
							type="password"
							value={passwordConfirm}
							onChange={(e) => setPasswordConfirm(e.target.value)}
							required
							className="w-full px-3 py-2 mt-1 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500"
						/>
					</div>
					<div className="flex flex-col space-y-2">
						<button
							type="submit"
							className="w-full px-4 py-2 font-medium text-white bg-indigo-600 rounded-md hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500"
						>
							회원가입
						</button>
						<Link
							to="/login"
							className="w-full px-4 py-2 font-medium text-center text-indigo-600 bg-white border border-indigo-600 rounded-md hover:bg-indigo-50"
						>
							로그인
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
