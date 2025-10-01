import React from "react";
// 개별 Product의 UI(컴포넌트)
// 구조 분해 할당을 활용해서 객체 props를 분해
// product: 개별 상품 정보를 저장하고 있는 객체
export default function Product({ product }) {
	return (
		<div className="p-4 m-2 border rounded-lg shadow-lg">
			<p className="text-lg font-bold">
				{product["id"]}-{product["title"]}
			</p>
			<p className="mt-2 text-gray-700">{product["description"]}</p>
		</div>
	);
}