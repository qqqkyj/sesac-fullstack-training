// a태그를 대체하는 Link 컴포넌트
import { Link, NavLink } from "react-router-dom";

export default function About() {
	return (
		<div>
			<h1 className="font-bold text-4xl">소개 페이지</h1>
			{/* to : 이동할 경로 */}
			<NavLink to="/">홈</NavLink>
			<br />
			<NavLink
				to="/about"
				className={({ isActive }) => {
					return isActive ? "text-red-900 font-blod text-5xl" : "";
				}}
			>
				소개
			</NavLink>
			<br />
			{/* profile 주소로 이동할 수 있는 Link 컴포넌트 */}
			<NavLink to="/profile">사용자 정보</NavLink>
		</div>
	);
}
