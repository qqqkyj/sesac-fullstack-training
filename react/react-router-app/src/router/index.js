// React Router의 createBrowserRouter 불러오기
// createBrowserRouter 함수
// 라우터 설정을 생성하는 함수
// 라우터 : 주소(URL)와 컴포넌트를 매핑
import { createBrowserRouter } from "react-router-dom";

// 레이아웃 컴포넌트 불러오기

import DummyLayout from "../layout/DummyLayout.jsx";

// DummyJSON 실습 페이지 컴포넌트
import Carts from "../pages/DummyPages/Carts.jsx";
import Posts from "../pages/DummyPages/Posts.jsx";
import Products from "../pages/DummyPages/Products.jsx";
import ProductDetail from "../pages/DummyPages/ProductDetail.jsx";
import DummyHome from "../pages/DummyPages/DummyHome.jsx";

// RootLayout 관련 경로 배열 불러오기
import rootRoutes from "./routes/rootRoutes.js";
import authRoutes from "./routes/authRoute.js";

// 라우터 설정 생성
const router = createBrowserRouter([
	// 스프레드 연산자(...)로 경로 배열을 복사
	...rootRoutes,
	...authRoutes,
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
