export default function Form({ onSubmit, onChange }) {
	return (
		<>
			<div>
				<h1 className="text-2xl font-bold">Form</h1>
			</div>
			<form onSubmit={(event) => onSubmit(event)}>
				<input
					className="border-2 border-gray-300 rounded-md p-2"
					type="text"
					name="name"
					placeholder="이름"
					onChange={(event) => onChange(event)}
				/>
				<input
					className="border-2 border-gray-300 rounded-md p-2"
					type="email"
					name="email"
					placeholder="이메일"
					onChange={(event) => onChange(event)}
				/>
				<input
					className="border-2 border-gray-300 rounded-md p-2"
					type="password"
					name="password"
					placeholder="비밀번호"
					onChange={(event) => onChange(event)}
				/>
				<button className="bg-blue-500 text-white rounded-md p-2" type="submit">
					제출
				</button>
			</form>
		</>
	);
}
