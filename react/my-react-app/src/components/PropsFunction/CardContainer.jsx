import Card from "./Card";

// Card 컴포넌트를
// CardContainer 컴포넌트에 배치

export default function CardContainer() {
	// 자식 컴포넌트에게 전달할 데이터
	// 매개변수를 받는 함수로 수정
	// 해당 매개변수를 console에 출력하는 코드를 작성
	function handleClick(user) {
		console.log(`이름은 ${user.name}이고, 나이는 ${user.age}입니다.`);
	}
	const user = {
		name: "홍길동",
		age: 30,
	};

	return (
		<div>
			{/* Card 컴포넌트에 user 데이터 전달 */}
			{/* Card 컴포넌트에 handleClick 함수 전달 */}
			{/* 함수를 전달할 때는 이름만 전달 */}
			<Card user={user} OnClickProps={handleClick}></Card>
		</div>
	);
}
