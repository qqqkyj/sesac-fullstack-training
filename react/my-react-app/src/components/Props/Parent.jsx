import Child from "./Child";

// 1. Child 컴포넌트를 불러오기
// 2. Child 컴포넌트를 Parent 컴포넌트 내부에 배치
export default function Parent() {
	return (
		<div>
			{/* 데이터(Props)를 전달하는 방법 */}
			{/* Child 컴포넌트의 name 속성 */}
			{/* 문자열 속성은 따옴표("") 사이에 넣고 */}
			{/* 숫자 속성은 중괄호({}) 사이에 넣는다 */}
			<Child name="홍길동" age={43} />
			<Child name="김철수" age={20} />
			<Child name="영희" age={25} />
		</div>
	);
}
