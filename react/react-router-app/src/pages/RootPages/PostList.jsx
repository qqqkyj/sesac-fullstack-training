import React from "react";
import { useState, useEffect } from "react";
// useSearchParams 훅 : 쿼리 파라미터 관리
import { Link, useSearchParams } from "react-router-dom";
import axios from "axios";

export default function PostList() {
	const [posts, setPosts] = useState([]);
	// searchParams: 쿼리 파라미터 값을 가진 객체
	// setSearchParams: 쿼리 파라미터 값을 변경하는 함수
	const [searchParams, setSearchParams] = useSearchParams();

	// useEffect 의존성 배열의 역할
	// useEffect 콜백 함수를 언제 실행할 것인가를 결정
	// 의존성 배열이 빈 배열이면 컴포넌트가 첫 렌더링될 때 콜백 함수 실행
	// 의존성 배열에 데이터가 있으면 해당 데이터가 변경될 때 콜백 함수 실행
	useEffect(() => {
		//쿼리 파라미터에서 key로 값을 불러오기
		//Nullish 연산자를 통해 기본값을 지정
		const order = searchParams.get("order") ?? "asc";
		const sortBy = searchParams.get("sortBy") ?? "id";

		async function getPosts() {
			const res = await axios.get(
				`https://dummyjson.com/posts?sortBy=${sortBy}&order=${order}`
			);
			setPosts(res.data.posts);
		}
		getPosts();
	}, [searchParams]);
	// 의존성 배열에 searchParams를 넣어서
	// 쿼리 파라미터가 변경되면 useEffect 콜백 함수를 실행
	// 쿼리 파라미터가 변경된다 -> setSearchParams()함수 실행

	function handleSortChange(sortBy, order) {
		// 주소(URL)의 쿼리 파라미터(sortBy, order) 설정
		setSearchParams({ sortBy: sortBy, order: order });
	}

	return (
		<div>
			<div className="flex gap-2">
				<button
					className="border-2 p-2 cursor-pointer"
					onClick={() => {
						// id를 기준(sortBy)으로 asc(오름차순) 정렬
						handleSortChange("id", "asc");
						// setSearchParams({ sortBy: "id", order: "asc" });
					}}
				>
					ID 오름차순
				</button>
				<button
					className="border-2 p-2 cursor-pointer"
					onClick={() => {
						// id를 기준(sortBy)으로 desc(내림차순) 정렬
						handleSortChange("id", "desc");
						// setSearchParams({ sortBy: "id", order: "desc" });
					}}
				>
					ID 내림차순
				</button>
				<button
					className="border-2 p-2 cursor-pointer"
					onClick={() => {
						handleSortChange("title", "asc");
					}}
				>
					제목 오름차순
				</button>
				<button
					className="border-2 p-2 cursor-pointer"
					onClick={() => {
						handleSortChange("title", "desc");
					}}
				>
					제목 내림차순
				</button>
			</div>
			<div>
				{posts.map((post) => {
					return (
						<li>
							<Link key={post.id} to={`/posts/${post.id}`}>
								No.{post.id} - {post.title}
							</Link>
						</li>
					);
				})}
			</div>
		</div>
	);
}
