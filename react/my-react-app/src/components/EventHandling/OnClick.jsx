export default function OnClick() {
	function handleClick() {
		alert("클릭");
	}
	return (
		<div>
			{/* 아래 버튼을 클릭(onClick)했을 때 handleClick() 함수가 실행 되도록 코드를 작성 */}
			<button
				className="border-2 bg-amber-200"
				onClick={() => {
					handleClick();
				}}
			>
				클릭
			</button>
		</div>
	);
}
