import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

// useSearchParams 훅 불러오기
// useSearchParams 훅 : 쿼리 파라미터 관리
import { useSearchParams } from "react-router-dom";
import PATHS from "../../constants/paths";

export default function PostList() {
	const [posts, setPosts] = useState([]);

	// 상태(State)로 API 요청 주소를 관리하는것과
	// 쿼리파라미터로 API 요청 주소를 관리하는것의 차이는 무엇인가?

	// searchParams: 쿼리 파라미터 값을 가진 객체
	// setSearchParams: 쿼리 파라미터 값을 변경하는 함수
	const [searchParams, setSearchParams] = useSearchParams();

	// useEffect 의존성 배열의 역할
	// useEffect 콜백 함수를 언제 실행할것이냐를 결정
	// 의존성 배열이 빈 배열이면 컴포넌트가 첫 렌더링될 때 콜백 함수 실행
	// 의존성 배열에 데이터가 있으면 해당 데이터가 변경될 때 콜백 함수 실행
	useEffect(() => {
		// searchParams.get(쿼리_파라미터_키)
		// 쿼리 파라미터(searchParams)에서 key가 order인 값을 불러오기
		const order = searchParams.get("order") ?? "asc"; // Nullish 연산자를 통해 기본값을 지정
		const sortBy = searchParams.get("sortBy") ?? "id";

		async function getPosts() {
			// https://dummyjson.com/posts?sortBy=title&order=asc
			const response = await axios.get(
				`https://dummyjson.com/posts?sortBy=${sortBy}&order=${order}`
			);
			setPosts(response.data.posts);
		}
		getPosts();
	}, [searchParams]);
	// 의존성 배열에 searchParams를 넣어서
	// 쿼리 파라미터가 변경되면 useEffect 콜백 함수를 실행한다
	// 쿼리 파라미터가 변경된다 -> setSearchParams() 실행

	return (
		<div>
			<div className="flex gap-2">
				<button
					className="border-2 p-2 cursor-pointer"
					onClick={() => {
						// id 를 기준(sortBy)으로 asc(오름차순) 순서(order)
						setSearchParams({ sortBy: "id", order: "asc" });
					}}
				>
					ID 오름차순
				</button>
				<button
					className="border-2 p-2 cursor-pointer"
					onClick={() => {
						// id 를 기준(sortBy)으로 desc(내림차순) 순서(order)
						setSearchParams({ sortBy: "id", order: "desc" });
					}}
				>
					ID 내림차순
				</button>
			</div>
			{posts.map((post) => {
				return (
					<div key={post.id}>
						{/* 아래 to 속성의 값은 항상 */}
						{/* "/posts/:postId" */}
						{/* 실제 값은 */}
						{/* `/posts/${post.id}` */}
						<Link to={PATHS.ROOT.getPostDetail(post.id)}>
							No. {post.id} - {post.title}
						</Link>
						<br />
					</div>
				);
			})}
		</div>
	);
}
