import { useEffect, useState } from "react";

// 모듈화된 API요청 함수 불러오기
import { getPopularMovies } from "./../../api/tmdb";

export default function MovieList() {
	const [movies, setMovies] = useState([]);

	useEffect(() => {
		async function fetchData() {
			const res = await getPopularMovies();
			setMovies(res["results"]); //응답 인터셉터에서 res["data"]를 return
		}

		fetchData();
	}, []);

	return (
		<div>
			<h1>인기 영화 목록</h1>
			<ul>
				{movies.map((movie) => (
					<li key={movie.id}>{movie.title}</li>
				))}
			</ul>
		</div>
	);
}
