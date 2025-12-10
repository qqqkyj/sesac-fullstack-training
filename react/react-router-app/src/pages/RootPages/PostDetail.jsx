import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

// 주소에 있는 경로 파라미터를 불러오는 훅(hook)
// /posts/:postId -> :postId 부분이 경로 파라미터
import { useParams } from "react-router-dom";

export default function PostDetail() {
  // 경로 파라미터 값 불러오기
  // 라우터 설정에서 설정한 파라미터명과 동일한 변수명을 사용
  const { postId } = useParams();
  const [post, setPost] = useState({});

  useEffect(() => {
    // postId 를 활용해서
    // Get a single product API를 요청 후 화면에 게시글 상세 정보 렌더링
    async function getPost() {
      const response = await axios(`https://dummyjson.com/posts/${postId}`);
      setPost(response.data);
    }
    getPost();
  }, [postId]);
  return (
    <div>
      <p>제목 - {post.title}</p>
      <p>내용</p>
      <div>{post.body}</div>
    </div>
  );
}
