// configureStore 함수
// 리듀서를 받아서 스토어를 생성하는 함수
import { configureStore } from "@reduxjs/toolkit";
// 리듀서 불러오기
import counterReducer from "./counterSlice";

// 스토어 생성
export const store = configureStore({
	reducer: {
		counter: counterReducer,
	},
});
