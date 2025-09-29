import React from "react";

// 함수의 첫 번째 매개변수는 props 객체가 들어온다
export default function Child(props) {
	console.log(props);
	return (
		<div>
			<h1>{props["name"]}</h1>
			<h1>{props["age"]}</h1>
		</div>
	);
}
