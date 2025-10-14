import axios from "axios";
import { useState, useEffect } from "react";

export default function PostsList() {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    async function getPosts() {
      const response = await axios.get("https://dummyjson.com/posts");
      const data = response.data.posts;
      setPosts(data);
    }
    getPosts();
  }, [posts]);
  return (
    <div>
      {posts.map((post) => {
        return (
          <div key={post.id}>
            No.{post.id} - {post.title}
          </div>
        );
      })}
    </div>
  );
}
