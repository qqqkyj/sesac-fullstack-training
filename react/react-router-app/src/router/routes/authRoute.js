// AuthLayout과 AuthLayout에 중첩된 페이지 경로 배열을 정리

// 경로 상수 불러오기
import PATHS from "../../constants/paths";

import AuthLayout from "./../../layout/AuthLayout";
import AuthHome from "./../../pages/AuthPages/AuthHome";
import Login from "./../../pages/AuthPages/Login";
import Signup from "./../../pages/AuthPages/Signup";

// AuthLayout의 경로 배열을 작성
const authRoutes = [
	// AuthLayout 경로 설정
	{
		path: PATHS.AUTH.INDEX,
		Component: AuthLayout,
		children: [
			{
				index: true,
				Component: AuthHome,
			},
			// 로그인 경로(path)와 Component 설정
			{
				path: PATHS.AUTH.LOGIN,
				Component: Login,
			},
			// 회원가입 경로(path)와 Component 설정
			{
				path: PATHS.AUTH.SIGNUP,
				Component: Signup,
			},
		],
	},
];

export default authRoutes;
