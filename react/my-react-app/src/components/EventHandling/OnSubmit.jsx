// submit 이벤트는 form 태그만 발생한다
export default function OnSubmit() {
	// submit 이벤트 핸들러 함수
	// 핸들러 함수 이름 규칙: handle이벤트명
	function handleSubmit(event) {
		event.preventDefault(); //새로고침 방지
		const email = event["target"]["email"];
		const pwd = event["target"]["password"];
		console.log(`이메일 : ${email["value"]}`);
		console.log(`비밀번호 : ${pwd["value"]}`);
	}
	return (
		<div>
			{/* form 태그의 onSubmit 속성에서 handleSubmit함수를 호출하는 코드를 작성 */}
			<form
				onSubmit={(e) => {
					handleSubmit(e);
				}}
			>
				<input type="text" name="email" className="border-2" />
				<input type="password" name="password" className="border-2" />
				<input type="submit" value="제출" className="border-2" />
			</form>
		</div>
	);
}
