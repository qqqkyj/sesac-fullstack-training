import Card from "./Card";

export default function CardContainer() {
	// 함수 정의
	function handleClick(titleParam) {
		alert(`${titleParam} 카드 정보를 표시합니다.`);
	}

	return (
		<div>
			{/* 함수 Props와 데이터 Props 전달 */}
			<Card onClick={handleClick} title="상품 카드" />
			<Card onClick={handleClick} title="프로필 카드" />
		</div>
	);
}
