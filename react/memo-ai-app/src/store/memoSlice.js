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
			// AI가 생성한 메모 객체와 ID, 완료 상태를 추가
			const newMemo = {
				id: Date.now(), // 고유 ID 생성
				...action.payload, // AI가 생성한 메모 데이터
				completed: false, // 완료 여부 초기값
			};
			state.list.push(newMemo);
		},
		deleteMemo: (state, action) => {
			// id를 기준으로 메모를 삭제
			state.list = state.list.filter((memo) => memo.id !== action.payload);
		},
		toggleMemo: (state, action) => {
			// id로 메모를 찾아 completed 상태를 변경
			const memo = state.list.find((memo) => memo.id === action.payload);
			if (memo) {
				memo.completed = !memo.completed;
			}
		},
	},
});

// 액션 생성자 및 리듀서 내보내기
export const { addMemo, deleteMemo, toggleMemo } = memoSlice.actions;
export default memoSlice.reducer;