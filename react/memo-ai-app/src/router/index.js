import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import Login from "../pages/Login";
import Signup from "../pages/Signup";
import Profile from "../pages/Profile";

// PrivateLayout(로그인),AuthLayout(비로그인) 불러오기
import PrivateLayout from "./../layouts/PrivateLayout";
import AuthLayout from "../layouts/AuthLayout";
import RootLayout from "../layouts/RootRayout";
import ChatContainer from "./../components/ChatContainer";
import { Component } from "react";

const router = createBrowserRouter([
	{
		path: "/",
		Component: RootLayout,
		children: [
			{
				index: true,
				Component: Home,
			},
			// PrivateLayout 적용
			{
				Component: PrivateLayout,
				children: [
					{
						path: "memo/profile",
						Component: Profile,
					},
					{
						path: "memo/stream-chat",
						Component: ChatContainer,
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
		],
	},
]);
export default router;
