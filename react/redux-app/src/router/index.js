import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import Login from "../pages/Login";
import Signup from "../pages/Signup";
import Profile from "../pages/Profile";

// PrivateLayout(로그인),AuthLayout(비로그인) 불러오기
import PrivateLayout from "./../layouts/PrivateLayout";
import AuthLayout from "../layouts/AuthLayout";

const router = createBrowserRouter([
	{
		path: "/",
		Component: Home,
	},
	// PrivateLayout 적용
	{
		Component: PrivateLayout,
		children: [
			{
				path: "/profile",
				Component: Profile,
			},
		],
	},
	// 비로그인 사용자만 접근
	{
		Component: AuthLayout,
		children: [
			{
				path: "/login",
				Component: Login,
			},
			{
				path: "/signup",
				Component: Signup,
			},
		],
	},
]);
export default router;
