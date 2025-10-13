// a태그를 대체하는 Link 컴포넌트
import { Link, NavLink } from "react-router-dom";

export default function Home() {
	return (
		<div>
			{/* to : 이동할 경로 */}
			<NavLink to="/">홈</NavLink>
			<br />
			<NavLink to="/about">소개</NavLink>
			<br />
			{/* <a> : 외부 서비스 접근 시 사용 */}
			<a href="https://naver.com">외부 서비스 이동</a>
			<br />
			{/* profile 주소로 이동할 수 있는 Link 컴포넌트 */}
			<NavLink to="/profile">사용자 정보</NavLink>
		</div>
	);
}
