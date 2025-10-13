import React from "react";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

export default function PostList() {
	const [posts, setPosts] = useState([]);
	useEffect(() => {
		async function getPosts() {
			const res = await axios.get("https://dummyjson.com/posts");
			setPosts(res.data.posts);
		}
		getPosts();
	}, []);
	return (
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
	);
}
