// 액세스 토큰 상태 관리
// 로그인, 회원가입, 로그아웃과 같은 네트워크 비동기 처리

import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import axios from "axios";

// 로그인 요청을 보낼 인증 서버에 대한 정보
const SUPABASE_URL = import.meta.env.VITE_SUPABASE_URL;
const SUPABASE_ANON_KEY = import.meta.env.VITE_SUPABASE_ANON_KEY;

// 회원가입 비동기 처리
const signup = createAsyncThunk(
	"auth/signup",
	// 비동기 처리 함수(async)
	async (data, { rejectWithValue }) => {
		// 매개변수 data : 액션의 페이로드 역할
		// 실제로 data 변수에 저장될 데이터 => 회원가입을 위해 필요한 데이터
		try {
			// config : 요청 정보(url, method, headers, ...)
			const config = {
				url: `${SUPABASE_URL}/auth/v1/signup`,
				method: "POST",
				headers: {
					"Content-type": "application/json",
					apikey: SUPABASE_ANON_KEY,
				},
				data: {
					// supabase기준
					// 회원가입을 위해 필요한 데이터(email, password)
					email: data.email,
					password: data.password,
				},
			};

			const res = await axios(config);
			// 비동기처리를 성공했을 때의 데이터
			console.log(res.data);
			return res["data"];
		} catch (error) {
			// 비동기처리를 실패했을 때의 데이터
			console.log("signup error:", error.res.data);
			return rejectWithValue(error.response.data);
		}
	}
);

// 로그인 비동기 처리 액션
const login = createAsyncThunk(
	"auth/login",
	// 비동기 처리 함수
	async (data, { rejectWithValue }) => {
		// 로그인 로직 코드
		try {
			const config = {
				url: `${SUPABASE_URL}/auth/v1/token?grant_type=password`,
				method: "POST",
				headers: {
					"Content-type": "application/json",
					apikey: SUPABASE_ANON_KEY,
				},
				data: {
					// 로그인 정보
					email: data.email,
					password: data.password,
				},
			};
			const res = await axios(config);
			console.log(res.data);
			return res.data;
		} catch (error) {
			console.log("login error:", error.res.data);
			return rejectWithValue(error.response.data);
		}
	}
);

// 로그아웃 비동기 처리 액션
const logout = createAsyncThunk(
	"auth/logout",
	async (_, { rejectWithValue, getState }) => {
		try {
			// axios 요청 설정(config)
			const config = {
				url: `${SUPABASE_URL}/auth/v1/logout`,
				method: "POST",
				headers: {
					"Content-type": "application/json",
					apikey: SUPABASE_ANON_KEY,
					// 사용자 인증 정보(토큰)를 함께 전송
					// 로그아웃 : 누가 로그아웃을 하는지에 대한 정보(토큰)가 필요
					Authorization: `Bearer ${getState().auth.token}`,
				},
			};
			const response = await axios(config);
			console.log("로그아웃 성공");
			return response.data;
		} catch (error) {
			console.error(error); // (임시) 디버깅용 코드
			return rejectWithValue(error["response"]["data"]);
		}
	}
);

// 비동기 처리 3개의 상태: 대기, 성공, 실패(거절)

// 초기 상태
const initialState = {
	token: null, //액세스 토큰 관리 상태
	error: null, //에러 여부 관리 상태
	isSignup: false, //회원가입 성공 여부 관리 상태
};

// 슬라이스(reducer + action) 생성
const authSlice = createSlice({
	name: "auth",
	initialState: initialState,
	reducers: {
		// 회원가입 성공 여부를 초기화(false)
		resetIsSignup: (state) => {
			state.isSignup = false;
		},
	},
	// 위에서 정의한 비동기 처리 함수(액션)를 처리할 reducer
	extraReducers: (builder) => {
		// 각 비동기처리에 대한
		// 대기(pending)/ 성공(fulfilled) /실패(reject)
		// 처리 로직
		builder
			.addCase(signup.fulfilled, (state) => {
				// signup 비동기 처리가 성공(fullfilled)일 때 실행되는 콜백 함수
				state.isSignup = true;
			})
			.addCase(signup.rejected, (state, action) => {
				// action.payload는 어디서 왔을까?
				// return rejectWithValue(error.res.data);
				state.error = action.payload.error;
			})
			.addCase(login.fulfilled, (state, action) => {
				// login 비동기 처리가 성공(fullfilled)일 때 실행되는 콜백 함수
				state.token = action.payload.access_token;
			})
			.addCase(logout.fulfilled, (state) => {
				// logout 비동기 처리가 성공일 때
				// token 상태 초기화
				console.log("로그아웃 성공");
				state.token = null;
			});
	},
});

// 액션과 리듀서, 비동기 처리 액션 내보내기
export const { resetIsSignup } = authSlice.actions;
export default authSlice.reducer;
export { signup, login, logout };
