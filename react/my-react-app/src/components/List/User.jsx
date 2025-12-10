import React from "react";

export default function User({ user }) {
	return (
		<div>
			<li>
				{user["id"]} - {user["name"]}
			</li>
		</div>
	);
}
