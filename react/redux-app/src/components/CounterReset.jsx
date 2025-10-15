import React from "react";
import { useDispatch } from "react-redux";
import { reset } from "./../store/counterSlice";

export default function CounterReset() {
	const dispatch = useDispatch();

	return (
		<div>
			<button
				onClick={() => {
					dispatch(reset());
				}}
			>
				초기화
			</button>
		</div>
	);
}
