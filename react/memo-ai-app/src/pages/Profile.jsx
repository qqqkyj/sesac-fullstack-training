// Profile.jsx
// 사용자 메모 목록 페이지
// Redux에서 memos를 불러와 필터링, 완료 체크, 삭제 기능 제공

import React, { useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { toggleMemo, deleteMemo } from "../store/memoSlice";

export default function Profile() {
	const dispatch = useDispatch();
	const memos = useSelector((state) => state.memo.list);

	// 상태: 필터 (all, incomplete, complete)
	const [filter, setFilter] = useState("all");

	// 메모 완료 상태 토글
	const handleToggle = (id) => {
		dispatch(toggleMemo(id));
	};

	// 메모 삭제
	const handleDelete = (id) => {
		dispatch(deleteMemo(id));
	};

	// 필터링된 메모 계산
	const filteredMemos = memos.filter((memo) => {
		if (filter === "incomplete") return !memo.completed;
		if (filter === "complete") return memo.completed;
		return true; // all
	});

	return (
		<div className="max-w-4xl mx-auto p-6 bg-gray-50 min-h-screen">
			{/* 페이지 타이틀 */}
			<h2 className="text-3xl font-bold mb-6 text-center">📝 메모 목록</h2>

			{/* 필터 버튼 그룹 */}
			<div className="flex justify-center mb-6 space-x-4">
				<button
					onClick={() => setFilter("all")}
					className={`px-5 py-2 rounded-md font-semibold transition ${
						filter === "all"
							? "bg-blue-500 text-white shadow-md"
							: "bg-gray-200 text-gray-700 hover:bg-gray-300"
					}`}
				>
					전체 ({memos.length})
				</button>
				<button
					onClick={() => setFilter("incomplete")}
					className={`px-5 py-2 rounded-md font-semibold transition ${
						filter === "incomplete"
							? "bg-blue-500 text-white shadow-md"
							: "bg-gray-200 text-gray-700 hover:bg-gray-300"
					}`}
				>
					미완료 ({memos.filter((m) => !m.completed).length})
				</button>
				<button
					onClick={() => setFilter("complete")}
					className={`px-5 py-2 rounded-md font-semibold transition ${
						filter === "complete"
							? "bg-blue-500 text-white shadow-md"
							: "bg-gray-200 text-gray-700 hover:bg-gray-300"
					}`}
				>
					완료 ({memos.filter((m) => m.completed).length})
				</button>
			</div>

			{/* 메모 리스트 */}
			{filteredMemos.length === 0 ? (
				// 필터링 결과가 없을 때 안내 메시지
				<p className="text-gray-500 text-center mt-12 whitespace-pre-line text-lg">
					{filter === "all"
						? "📝 아직 메모가 없습니다.\n메모 작성 페이지에서 새로운 할 일을 만들어보세요."
						: filter === "incomplete"
						? "📝 미완료 메모가 없습니다.\n다른 필터를 선택해보세요."
						: "📝 완료된 메모가 없습니다.\n다른 필터를 선택해보세요."}
				</p>
			) : (
				<div className="space-y-4">
					{filteredMemos.map((memo) => (
						// 개별 메모 카드
						<div
							key={memo.id}
							className="bg-white rounded-xl shadow-md p-5 border border-gray-200 hover:shadow-lg transition"
						>
							{/* 메모 제목 + 완료 체크박스 + 삭제 버튼 */}
							<div className="flex justify-between items-start">
								<div className="flex items-center space-x-3">
									<input
										type="checkbox"
										checked={memo.completed}
										onChange={() => handleToggle(memo.id)}
										className="h-5 w-5 accent-blue-500"
									/>
									<span
										className={`font-semibold text-gray-800 text-lg ${
											memo.completed ? "line-through text-gray-400" : ""
										}`}
									>
										{memo.content}
									</span>
								</div>
								<button
									onClick={() => handleDelete(memo.id)}
									className="text-red-500 hover:text-red-700 font-semibold transition"
								>
									삭제
								</button>
							</div>

							{/* 메모 상세 정보 */}
							<div className="mt-3 text-sm text-gray-600 space-y-1">
								<p>
									<strong>마감일:</strong> {memo.dueDate || "-"}
								</p>
								{memo.priority && (
									<p>
										<strong>우선순위:</strong>{" "}
										<span
											className={`font-semibold ${
												memo.priority === "높음"
													? "text-red-500"
													: memo.priority === "중간"
													? "text-yellow-500"
													: "text-green-500"
											}`}
										>
											{memo.priority}
										</span>
									</p>
								)}
								{memo.category && (
									<p>
										<strong>카테고리:</strong> {memo.category}
									</p>
								)}
							</div>
						</div>
					))}
				</div>
			)}
		</div>
	);
}
