export default function Card({ onClick, title }) {
	return (
		<div>
			{/* 함수 호출 */}
			<button className="border-2 bg-amber-300" onClick={() => onClick(title)}>
				{title} 정보 보기
			</button>
		</div>
	);
}
