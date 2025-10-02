import { useEffect, useState } from "react";
import axios from "axios";

const BASE_URL = `https://api.themoviedb.org/3`;
const API_KEY = import.meta.env["VITE_TMDB_API_KEY"];

export default function MovieList() {
	const [movies, setMovies] = useState([]);

	useEffect(() => {
		async function fetchData() {
			const config = {
				method: "GET",
				url: `${BASE_URL}/movie/popular`,
				headers: {
					"Content-Type": "application/json",
					accept: "application/json",
					Authorization: `Bearer ${API_KEY}`,
				},
				params: {
					language: "ko-KR",
					page: 1,
				},
			};

			const res = await axios(config);
			setMovies(res["data"]["results"]);
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
