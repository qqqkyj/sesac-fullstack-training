# 🎬 TMDB API 사용 가이드

## 1. TMDB API 키 발급하기

1. [TMDB 공식 사이트](https://www.themoviedb.org/) 접속
2. 회원가입 및 로그인 진행
3. [API 키 발급 페이지](https://www.themoviedb.org/settings/api) 이동
4. **API 키 신청 절차**
   - **어플리케이션 이름**: 원하는 이름 입력 (예: Test)
   - **어플리케이션 URL**: 임시로 [http://test.com](http://test.com/) 입력 가능
   - **어플리케이션 개요**: 일정 길이 이상 작성 필요
     - 예시: _"API 호출 학습을 위해 TMDB API Key 발급 신청"_
   - **이름 및 성**: 반드시 영문으로 입력
   - 나머지 정보는 적당히 작성 후 제출
5. 승인 후 [API 키 확인 페이지](https://www.themoviedb.org/settings/api)에서 확인 가능
   - `API Key (v3 auth)`
   - `API Read Access Token (v4 auth)`

---

## 2. 환경 변수(.env) 설정

1. 프로젝트 루트 디렉토리에 `.env` 파일 생성

   ![alt text](image.png)

2. `.gitignore` 파일에 `.env` 추가 (보안상 GitHub 등에 노출 방지)
3. `.env` 파일에 키 등록

   ```
   VITE_TMDB_API_KEY=발급받은_API_KEY
   ```

4. 코드에서 불러오기

   ```jsx
   const TMDB_API_KEY = import.meta.env.VITE_TMDB_API_KEY;
   ```

---

## 3. API 요청 예시

### 📌 Axios 설치

```bash
npm install axios
```

### 📌 TMDB API 호출 예제

```jsx
import { useEffect, useState } from "react";
import axios from "axios";

const BASE_URL = `https://api.themoviedb.org/3`;
**const API_KEY = import.meta.env["VITE_TMDB_API_KEY"];**
const IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

export default function MovieDetail() {
	// 리액트의 상태(state) : 화면을 결정한다. 화면에 보여질 데이터를 관리한다
	// movie : 상태 데이터를 저장하고 있는 변수
	// setMovies : 상태 데이터를 바꾸는 함수
	const [movie, setMovie] = useState(null);
	const [movieID, setMovieID] = useState(550); // 'Fight Club' ID for a good default example
	const [loading, setLoading] = useState(false);
	const [error, setError] = useState(null);

	// Fetch on initial load with a default ID
	useEffect(() => {
		fetchData();
	}, []);

	async function fetchData() {
		if (!movieID) {
			setError("영화 ID를 입력해주세요.");
			setMovie(null);
			return;
		}
		setLoading(true);
		setError(null);
		// Keep previous movie data while loading new one for better UX
		// setMovie(null);

		const config = {
			method: "GET",
			url: `${BASE_URL}/movie/${movieID}`,
			headers: {
				accept: "application/json",
				**Authorization: `Bearer ${API_KEY}`,**
			},
			params: {
				language: "ko-KR",
			},
		};

		try {
			const res = await axios(config);
			// setMovie(data) : 상태 변수 movies에 저장된 데이터가 data로 변경된다
			setMovie(res.data);
		} catch (err) {
			setError(`'${movieID}' ID에 해당하는 영화를 찾을 수 없습니다.`);
			setMovie(null);
		} finally {
			setLoading(false);
		}
	}

	return (
		<div className="container mx-auto p-4 md:p-8 bg-gray-50 min-h-screen font-sans">
			<h1 className="text-3xl md:text-4xl font-bold text-center text-gray-800 mb-8">
				영화 상세 정보 검색
			</h1>
			<div className="max-w-lg mx-auto mb-8">
				<div className="flex flex-col sm:flex-row items-center gap-3 p-2 bg-white rounded-lg shadow-md">
					<label htmlFor="movieID" className="sr-only">
						영화 번호
					</label>
					<input
						type="number"
						id="movieID"
						name="movieID"
						placeholder="영화 ID를 입력하세요 (예: 550)"
						value={movieID}
						className="flex-grow w-full px-4 py-2 text-base text-gray-700 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500 transition-shadow"
						onChange={(e) => setMovieID(e.target.value)}
						onKeyDown={(e) => {
							if (e.key === "Enter") fetchData();
						}}
					/>
					<button
						className="w-full sm:w-auto px-6 py-2.5 text-base font-semibold text-white bg-blue-600 rounded-md shadow-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500 transition-all duration-200 ease-in-out transform hover:scale-105 disabled:bg-gray-400 disabled:scale-100"
						onClick={fetchData}
						disabled={loading}
					>
						{loading ? "검색 중..." : "검색"}
					</button>
				</div>
			</div>

			{/* Loading Spinner */}
			{loading && (
				<div className="flex justify-center items-center">
					<div className="animate-spin rounded-full h-16 w-16 border-t-4 border-b-4 border-blue-500"></div>
				</div>
			)}

			{/* Error Message */}
			{error && !loading && (
				<div
					className="max-w-2xl mx-auto p-4 bg-red-100 text-red-800 border-l-4 border-red-500 rounded-md shadow-lg"
					role="alert"
				>
					<p className="font-bold">오류</p>
					<p>{error}</p>
				</div>
			)}

			{/* Movie Card */}
			{movie && !loading && (
				<div className="max-w-4xl mx-auto bg-white rounded-xl shadow-2xl overflow-hidden md:flex transition-opacity duration-500 ease-in-out opacity-100">
					<div className="md:flex-shrink-0">
						<img
							className="h-full w-full object-cover md:w-80"
							src={
								movie.poster_path
									? `${IMAGE_BASE_URL}${movie.poster_path}`
									: "https://via.placeholder.com/500x750.png?text=No+Image"
							}
							alt={`${movie.title} 포스터`}
						/>
					</div>
					<div className="p-8 flex flex-col justify-between">
						<div>
							<div className="uppercase tracking-wide text-sm text-indigo-600 font-semibold">
								{movie.release_date}
							</div>
							<h2 className="block mt-1 text-3xl leading-tight font-extrabold text-gray-900">
								{movie.title}
							</h2>
							{movie.tagline && (
								<p className="mt-2 text-gray-500 italic">"{movie.tagline}"</p>
							)}
							<p className="mt-4 text-gray-600 text-base">{movie.overview}</p>
						</div>

						<div className="mt-6">
							<div className="flex items-center mt-4">
								<span className="font-bold text-gray-700">평점:</span>
								<span className="ml-2 px-3 py-1 bg-yellow-400 text-yellow-900 rounded-full text-sm font-bold">
									{movie.vote_average ? movie.vote_average.toFixed(1) : "N/A"}
								</span>
							</div>

							<div className="mt-4">
								<span className="font-bold text-gray-700">장르:</span>
								<span className="ml-2 text-gray-600">
									{movie.genres && movie.genres.length > 0
										? movie.genres.map((genre) => genre.name).join(", ")
										: "정보 없음"}
								</span>
							</div>
						</div>
					</div>
				</div>
			)}
		</div>
	);
}

```

### 📌 호출 결과

![alt text](image-1.png)

---

## ✅ 요약

1. **TMDB 회원가입 → API 키 발급**
2. **`.env` 파일에 API 키 저장 & `.gitignore` 처리**
3. **Axios 등으로 API 호출**
4. **React 등에서 데이터 활용**

---

# 🎬 TMDB 영화 검색 실습 (React + TailwindCSS)

## 1️⃣ 개요

- TMDB API를 활용하여 영화 정보를 검색하고 결과를 화면에 표시
- TailwindCSS로 레이아웃과 스타일 적용
- 줄거리(`overview`)는 **3줄까지만 표시**, 넘치면 `…` 처리

---

## 2️⃣ 프로젝트 구조

```
src/
└─ components/
   ├─ Movie.jsx        // 단일 영화 카드 컴포넌트
   └─ MovieSearch.jsx  // 검색 기능 + 영화 목록 표시
```

---

## 3️⃣ Movie.jsx (단일 영화 컴포넌트)

```jsx
import React from "react";

const IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

export default function Movie({ movie }) {
  return (
    <div>
      <p className="font-bold mb-2">{movie.title}</p>
      <imgsrc={
          movie.poster_path
            ? `${IMAGE_BASE_URL}${movie.poster_path}`
            : "https://placehold.co/500x750/000000/FFFFFF.png?text=No+Image"
        }
        alt={`${movie.title} 포스터`}
      />
      <p className="line-clamp-3 mb-2">{movie.overview}</p>
      <p>Release: {movie.release_date}</p>
      <p>Rating: {movie.vote_average}</p>
    </div>
  );
}
```

### ✨ 포인트

- `line-clamp-3` → TailwindCSS line-clamp 플러그인을 활용, 3줄까지만 보여주고 나머지는 `…` 처리
- 포스터 없을 경우 **대체 이미지** 사용

---

## 4️⃣ MovieSearch.jsx (검색 + 목록)

```jsx
import { useEffect, useState } from "react";
import axios from "axios";
import Movie from "./Movie";

const BASE_URL = "https://api.themoviedb.org/3";
const API_KEY = import.meta.env["VITE_TMDB_API_KEY"];

export default function MovieSearch() {
  const [movies, setMovies] = useState([]);
  const [search, setSearch] = useState("");

  useEffect(() => {
    getMoviesByTitle();
  }, []);

  async function getMoviesByTitle() {
    if (!search.trim()) {
      setMovies([]);
      return;
    }

    const config = {
      method: "GET",
      url: `${BASE_URL}/search/movie`,
      headers: {
        accept: "application/json",
        Authorization: `Bearer ${API_KEY}`,
      },
      params: {
        query: search,
        language: "ko-KR",
        page: 1,
      },
    };

    try {
      const res = await axios(config);
      setMovies(res.data.results);
    } catch (error) {
      console.error("Error fetching movies:", error);
      setMovies([]);
    }
  }

  return (
    <div className="p-4 md:p-8 max-w-screen-2xl mx-auto bg-gray-50 min-h-screen">
      <h1 className="text-3xl md:text-4xl font-extrabold text-center mb-8 text-gray-800">
        🎬 영화 정보 검색
      </h1>

      <formclassName="flex gap-2 mb-10 max-w-2xl mx-auto"
        onSubmit={(e) => {
          e.preventDefault();
          getMoviesByTitle();
        }}
      >
        <inputclassName="flex-grow p-3 border border-gray-300 rounded-l-full focus:outline-none focus:ring-2 focus:ring-indigo-500 transition shadow-sm"
          type="text"
          placeholder="영화 제목을 검색해보세요..."
          onChange={(e) => setSearch(e.target.value)}
          value={search}
        />
        <inputtype="submit"
          value="검색"
          className="bg-indigo-600 text-white px-8 py-3 rounded-r-full hover:bg-indigo-700 cursor-pointer transition shadow-sm font-semibold"
        />
      </form>

      <ul className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 xl:grid-cols-5 gap-8">
        {movies.length > 0 ? (
          movies.map((movie) => (
            <li key={movie.id} className="transform hover:scale-105 transition duration-300">
              <Movie movie={movie} />
            </li>
          ))
        ) : (
          <p className="col-span-full text-center text-gray-500 text-lg mt-10">
            검색 결과가 없습니다.
          </p>
        )}
      </ul>
    </div>
  );
}
```

### ✨ 포인트

- 검색어가 없으면 목록 초기화
- TailwindCSS Grid로 반응형 영화 카드 레이아웃 구현
- 영화 카드 hover 시 확대 효과

---

## 5️⃣ TailwindCSS line-clamp 설정

1. 설치

```bash
npm install @tailwindcss/line-clamp
```

1. `tailwind.config.js`에 플러그인 추가

```jsx
plugins: [
  require('@tailwindcss/line-clamp'),
],
```

1. 줄거리 요소에 클래스 적용

```jsx
<p className="line-clamp-3">{movie.overview}</p>
```

---

## 6️⃣ 결과 화면

- 영화 검색 후 카드 형태로 표시
- 줄거리는 최대 3줄까지만 표시되고 `…` 처리
- 포스터 없으면 placeholder 이미지 표시

![alt text](image-2.png)
