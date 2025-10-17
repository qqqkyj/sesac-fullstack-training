import { createSlice } from "@reduxjs/toolkit";

// 초기 상태
const initialState = {
	list: [],
};

// 메모 저장
const memoSlice = createSlice({
	name: "memo",
	initialState: initialState,
	reducers: {
		addMemo: (state, action) => {
			state.list.push(action, payload);
		},
	},
});
