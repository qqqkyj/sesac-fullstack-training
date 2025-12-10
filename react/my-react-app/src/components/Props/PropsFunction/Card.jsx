export default function Card({ user, OnClickProps }) {
	return (
		<div>
			{/* button 태그에 onClick 속성에 OnClickProps 함수를 실행*/}
			<button
				className="border-2 bg-blue-500"
				onClick={() => {
					OnClickProps(user);
				}}
			>
				클릭
			</button>
		</div>
	);
}
