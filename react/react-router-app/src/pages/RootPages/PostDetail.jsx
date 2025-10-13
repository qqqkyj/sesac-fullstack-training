import axios from "axios";
import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

// 주소에 있는 경로 파라미터를 불러오는 훅(hook)
// posts/:postId -> :postId 부분이 경로 파라미터
import { useParams } from "react-router-dom";

export default function PostDetail() {
	// 경로 파라미터 값 불러오기
	// 라우터에서 설정한 파라미터명과 동일한 변수명을 사용
	const { postId } = useParams();
	const [post, setPost] = useState({});
	useEffect(() => {
		console.log(postId);

		async function getAPostById() {
			const res = await axios.get(`https://dummyjson.com/posts/${postId}`);
			console.log(res.data);
			setPost(res.data);
		}
		getAPostById();
	}, [postId]);

	return (
		<div>
			<li>No. {post.id}</li>
			<li>{post.title}</li>
			<li>{post.body}</li>
			<li>views: {post.views}</li>
		</div>
	);
}
