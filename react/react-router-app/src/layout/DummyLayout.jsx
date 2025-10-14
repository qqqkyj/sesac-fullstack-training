import { Link } from "react-router-dom";

// Outlet 컴포넌트 불러오기
import { Outlet } from "react-router-dom";

export default function RootLayout() {
  return (
    <div>
      <div className="flex gap-4 p-2 border-2 border-gray-300">
        <Link to="/dummy">DummyJSON 홈페이지</Link>
        <Link to="/dummy/carts">장바구니 페이지</Link>
        <Link to="/dummy/posts">게시글 페이지</Link>
        <Link to="/dummy/products">상품 페이지</Link>
      </div>
      <Outlet />
    </div>
  );
}
