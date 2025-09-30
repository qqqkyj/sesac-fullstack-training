import React from "react";

export default function Profile({ name, age, isAdmin }) {
	return (
		<div>
			{/* 저는 {props.name}이고, 나이는 {props.age}세 이며,
			{props.isAdmin ? "관리자 입니다." : "관리자가 아닙니다."} */}
			{/* 저는 {props.user.name}이고, 나이는 {props.user.age}세 이며,
			{props.user.isAdmin ? " 관리자 입니다." : " 관리자가 아닙니다."} */}
			저는 {name}이고, {age}세 이며, 관리자 여부는{" "}
			{isAdmin ? "관리자 입니다." : "관리자가 아닙니다."}
		</div>
	);
}
