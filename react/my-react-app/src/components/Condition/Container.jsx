import LoginStatus from "./LoginStatus";
import AdminLink from "./AdminLink";

// Container 컴포넌트에
// LoginStatus 컴포넌트를 불러와서
// <div> 태그 사이에 2개의 LoginStatus를 배치

export default function Container() {
	return (
		<div>
			{/* 첫 번째 컴포넌트에는 isLogin 속성에 true전달 */}
			{/* userName 속성에 "홍길동" 전달 */}
			{/* <LoginStatus isLogin={true} userName="홍길동" /> */}
			{/* 첫 번째 컴포넌트에는 isLogin 속성에 false전달 */}
			{/* userName 속성에 "김철수" 전달 */}
			{/* <LoginStatus isLogin={false} userName="김철수" /> */}

			{/* isAdmin 속성에 true 전달 */}
			<AdminLink isAdmin={true}></AdminLink>

			{/* isAdmin 속성에 false 전달 */}
			<AdminLink isAdmin={false}></AdminLink>
		</div>
	);
}
