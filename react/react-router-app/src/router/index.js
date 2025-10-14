// React Router의 createBrowserRouter 불러오기
// createBrowserRouter 함수
// 라우터 설정을 생성하는 함수
// 라우터 : 주소(URL)와 컴포넌트를 매핑
import { createBrowserRouter } from "react-router-dom";

// 레이아웃 컴포넌트 불러오기
import RootLayout from "../layout/RootLayout";
import AuthLayout from "../layout/AuthLayout.jsx";
import DummyLayout from "../layout/DummyLayout.jsx";
import ProtectedLayout from "../layout/ProtectedLayout.jsx";

// 페이지 컴포넌트 불러오기
import Home from "../pages/RootPages/Home.jsx";
import About from "../pages/RootPages/About.jsx";
import Profile from "../pages/RootPages/Profile.jsx";
import PostList from "../pages/RootPages/PostList.jsx";
import PostDetail from "../pages/RootPages/PostDetail.jsx";

import AuthHome from "../pages/AuthPages/AuthHome.jsx";
import Signup from "../pages/AuthPages/Signup.jsx";
import Login from "../pages/AUthPages/Login.jsx";

// DummyJSON 실습 페이지 컴포넌트
import Carts from "../pages/DummyPages/Carts.jsx";
import Posts from "../pages/DummyPages/Posts.jsx";
import Products from "../pages/DummyPages/Products.jsx";
import ProductDetail from "../pages/DummyPages/ProductDetail.jsx";
import DummyHome from "../pages/DummyPages/DummyHome.jsx";

// 경로 상수 불러오기
import PATHS from "../constants/paths.js";

// 라우터 설정 생성
const router = createBrowserRouter([
	{
		path: PATHS.ROOT.INDEX,
		Component: RootLayout,
		children: [
			// 중첩할 자식 경로 객체를 정의하는 배열
			{
				index: true, // index: true -> 부모 경로의 기본(root) 경로
				// 완성되는 path : "/" (부모 경로와 동일)
				Component: Home,
			},
			{
				path: PATHS.ROOT.ABOUT,
				Component: About,
			},
			{
				path: PATHS.ROOT.POSTS,
				Component: PostList,
			},
			{
				path: PATHS.ROOT.POSTS_DETAIL,
				Component: PostDetail,
			},
			{
				// path 속성 X
				Component: ProtectedLayout,
				// 보호할 경로와 컴포넌트 정의
				children: [
					{
						path: PATHS.ROOT.PROFILE,
						Component: Profile,
					},
				],
			},
		],
	},
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
	{
		path: "/dummy",
		Component: DummyLayout,
		children: [
			{
				index: true,
				Component: DummyHome,
			},
			{
				path: "carts",
				Component: Carts,
			},
			{
				path: "posts",
				Component: Posts,
			},
			{
				path: "products",
				Component: Products,
			},
			{
				path: "products/:productId",
				Component: ProductDetail,
			},
		],
	},
]);

export default router;
