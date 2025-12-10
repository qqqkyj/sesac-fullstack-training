// TMDB API 요청 함수 관리 파일
// axios를 활용한 TMDB API 요청 함수를 별도로 정의하고,
// 내보내는 파일
import axiosInstance2 from "./index";

// TMDB Popular API 요청 함수
// 응답 데이터를 반환하는 함수
// export : 모듈 내보내기
export async function getPopularMovies() {
	const config = {
		method: "GET",
		url: `/movie/popular`,
		params: {
			page: 1,
		},
	};

	// 응답 데이터 res 반환
	const res = await axiosInstance2(config);
	return res;
}

async function getMovieDetails(movieID) {
	const config = {
		method: "GET",
		url: `/movie/${movieID}`,
	};

	const res = await axiosInstance2(config);
	return res;
}
