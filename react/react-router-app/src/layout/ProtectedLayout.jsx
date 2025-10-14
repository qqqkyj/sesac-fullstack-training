// 레이아웃의 역할
// 비로그인 사용자는 로그인 페이지로 리다이렉트
import { useEffect } from "react";
import { Outlet, useNavigate } from "react-router-dom";
import { Navigate } from "react-router-dom";
export default function ProtectedLayout() {
  // 로그인 상태
  const isLogin = true;
  // 로그인 상태가 false라면
  // Navigate 컴포넌트로 "/auth/login" 리다이렉트
  if (isLogin === false) {
    return <Navigate to="/auth/login"></Navigate>;
  }

  return <Outlet />;
}
