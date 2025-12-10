import React, { use } from "react";
import { useState } from "react";

export default function Form() {
	// 입력 요소를 객체로 관리할 상태
	const [form, setForm] = useState({
		username: "",
		age: 0,
		email: "",
	});


	// 입력 요소의 값을 관리하는 3개의 상태
	// const [username, setUsername] = useState("");
	// const [age, setAge] = useState(0);
	// const [email, setEmail] = useState("");

	// event 객체 : 발생한 이벤트의 정보를 속성으로 저장한 객체
	function handleChange(event) {
		// target에서 name속성과 value 속성을 꺼내서 출력
		const { name, value } = event["target"];

		console.log(name, value);

		// 계산된 속성명을 사용해서 속성명(key)을 변수 name으로 대체
		const newForm = { ...form, [name]: value };

		// form 상태 변경(업데이트)
		setForm(newForm);
	}

	return (
		<div>
			<form>
				{/* 3개의 input 요소의 값(value)을 상태로 관리 */}
				{/* input 요소의 value 속성은 사용자가 입력한 값 */}
				{/* 왼쪽 value: 속성/ 오른쪽 {변수} : 상태 변수 */}
				<input
					className="border-2"
					type="text"
					name="username"
					value={form["username"]}
					placeholder="이름"
					onChange={(event) => {
						handleChange(event);
					}}
				/>
				<input
					className="border-2"
					type="number"
					name="age"
					value={form["age"]}
					onChange={(event) => {
						handleChange(event);
					}}
				/>
				<input
					className="border-2"
					type="email"
					name="email"
					value={form["email"]}
					placeholder="이메일"
					onChange={(event) => {
						handleChange(event);
					}}
				/>
				<input type="radio" name="level"/>
				<input type="radio" name="level"/>
				<input type="radio" name="level"/>
			</form>
		</div>
	);
}
