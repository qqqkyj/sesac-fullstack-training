// React Router의 createBrowserRouter 불러오기
// createBrowserRouter 함수
// 라우터 설정을 생성하는 함수
// 라우터 : 주소(URL)와 컴포넌트를 매핑
import { createBrowserRouter } from "react-router-dom";

// RootLayout 관련 경로 배열 불러오기
import rootRoutes from "./routes/rootRoutes.js";
import authRoutes from "./routes/authRoute.js";
import dummyRoutes from "./routes/dummyRoutes.js";

//404처리 페이지
import NotFound from "../pages/NotFound.jsx";

// 라우터 설정 생성
const router = createBrowserRouter([
	// 스프레드 연산자(...)로 경로 배열을 복사
	...rootRoutes,
	...authRoutes,
	...dummyRoutes,
]);

export default router;
