import axios from "axios";

const API_KEY = import.meta.env["VITE_TMDB_API_KEY"];

// create() : axios 객체 데이터를 생성
// 객체 : 속성(key - value) 구성된 자료형
const axiosInstance = axios.create({
	// axios 객체가 가질 속성의 정보
	baseURL: "https://dummyjson.com",
	headers: {},
	timeout: 5000,
});

// axios.get("/posts")
// 만들어지는 URL : baseURL 속성 값 + "/posts"
// https://dummyjson.com/posts

const axiosInstance2 = axios.create({
	baseURL: "https://api.themoviedb.org/3",
	headers: {
		"Content-Type": "application/json",
		accept: "application/json",
		Authorization: `Bearer ${API_KEY}`,
	},
	params: {
		language: "ko-KR",
	},
	timeout: 5000,
});

// 응답 인터셉터 : 서버가 사용자에게 돌려주는 응답 데이터를 가로채서 추가 작업을 수행한다
axiosInstance2["interceptors"]["response"].use(
	// 2개의 함수 전달
	// 통신(요청-응답)이 성공했을 때의 화살표 함수
	// 매개변수 response
	(response) => {
		console.log("통신 성공 응답 인터셉터");

		// 응답 데이터 반환(return)
		// 서버의 실제 응답 데이터를 반환
		return response["data"];
	},

	// 통신(요청-응답)이 실패했을 때의 화살표 함수
	// 매개변수 error
	(error) => {
		if (error.response) {
			// 401: 인증 오류(API 키, 인증 토큰 문제)
			// 테스트 시 캐시 초기화(Ctrl + Shift + R) 필수
			if (error.response.status === 401) {
				alert("인증에 문제가 있습니다.");
			}

			// 404 : Not Found(없는 주소 요청)
			if (error.response.status === 404) {
				alert("Not Found");
			}
		}

		// Promise : 3가지(성공/실패/대기중) 상태를 가진다
		return Promise.reject(error);
	}
);

export default axiosInstance2;
