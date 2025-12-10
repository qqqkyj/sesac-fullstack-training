// Counter.jsx
import { useState } from "react";

export default function Counter() {
	const [count, setCount] = useState(0);

	function handleIncrement() {
		setCount(count + 1);
		setCount(count + 1);
		setCount(count + 1);
		setCount(count + 1);
		console.log(count);
	}

	function handleIncrementFunctional() {
		setCount((prevCount) => prevCount + 1);
		setCount((prevCount) => prevCount + 1);
		setCount((prevCount) => prevCount + 1);
		setCount((prevCount) => prevCount + 1);
		console.log(count);
	}

	return (
		<div>
			<p>Count: {count}</p>
			<button onClick={handleIncrement}>상태 변경의 비동기성</button>
			<button onClick={handleIncrementFunctional}>함수형 업데이트</button>
		</div>
	);
}
