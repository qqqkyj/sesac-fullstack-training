// ChatContainer.jsx
// 로그인을 한 상태라면 사용자 정보를 출력
// (정상적으로 로그인 했을 경우) 사용자 정보는 전역 상태 token에 저장된 상태

import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import { logout } from "../store/authSlice";
import { addMemo } from "../store/memoSlice";
import { useEffect, useRef, useState } from "react";
// chat 객체 불러오기
import { chat, config } from "../utils/genai";
import ChatMessage from "./ChatMessage";
import ChatForm from "../components/ChatForm";
import MemoCard from "./MemoCard";

export default function ChatContainer() {
	// 전역상태 token
	const token = useSelector((state) => state.auth.token);
	const error = useSelector((state) => state.auth.error);
	const navigate = useNavigate();
	const dispatch = useDispatch();

	// 로그인 검증 로직
	// 사용자 정보 관리 상태
	const [decodeToken, setDecodeToken] = useState(null);
	useEffect(() => {
		console.log("token:", token);
		if (token) setDecodeToken(jwtDecode(token));
	}, [token]);

	// 로그인 오류 처리
	useEffect(() => {
		if (error) {
			alert(
				`error code: ${error.code}\nerror_code: ${error.error_code}\nmsg: ${error.msg}\n다시 로그인 해주세요.`
			);
		}
	}, [error]);

	// 로그아웃 핸들링 함수
	function handleLogout() {
		console.log("handleLogout시작");
		console.log("logout error:", error);
		dispatch(logout());
	}

	// querySelector 메서드 대신 React useRef 훅 사용
	const messagesEndRef = useRef(null);

	// 상태 관리
	const [prompt, setPrompt] = useState(""); // 사용자 입력 값
	const [messages, setMessages] = useState([]); // 사용자 - AI 채팅 메시지 내역
	const [isLoading, setIsLoading] = useState(false); // AI 요청 응답 로딩 상태
	const [pendingMemos, setPendingMemos] = useState([]); // AI가 생성한 JSON 메모 후보

	// 메시지 내역 변화 시 스크롤 이동
	useEffect(() => {
		messagesEndRef.current.scrollIntoView({ behavior: "smooth" });
	}, [messages, pendingMemos]);

	// AI 응답 생성 함수
	async function generateAiResponse() {
		try {
			// AI 응답 스트리밍
			const stream = await chat.sendMessageStream({
				message: prompt,
				config: config,
			});

			// 빈 AI 메시지 먼저 추가
			setMessages((prev) => [...prev, { role: "ai", content: "" }]);
			let accumulatedResponse = "";

			for await (const chunk of stream) {
				// 스트림 청크 누적
				accumulatedResponse += chunk.text || "";
			}

			// 최종 AI 응답 JSON 파싱
			try {
				const parsed = JSON.parse(accumulatedResponse);

				if (parsed.isMemo) {
					// 1️⃣ 안내 메시지
					setMessages((prev) => [
						...prev,
						{
							role: "ai",
							content: "사용자의 입력을 처리했습니다. 아래 메모를 생성할까요?",
						},
					]);

					// 2️⃣ pendingMemos에 추가 (중복 제거)
					setPendingMemos((prev) => {
						const exists = prev.some((m) => m.content === parsed.content);
						if (exists) return prev;
						return [...prev, parsed];
					});
				} else {
					// isMemo=false일 때 안내 메시지
					setMessages((prev) => [
						...prev,
						{ role: "ai", content: "❌ 메모로 생성할 수 없는 내용입니다." },
					]);
				}
			} catch (err) {
				console.error("JSON 파싱 실패:", err);
				setMessages((prev) => [
					...prev,
					{ role: "ai", content: "❌ AI 응답 파싱 오류가 발생했습니다." },
				]);
			}
		} catch (error) {
			console.error(error);
			setMessages((prev) => [
				...prev,
				{ role: "ai", content: "❌ AI 요청 중 오류가 발생했습니다." },
			]);
		}
	}

	// 사용자 프롬프트 제출 핸들링
	async function handleSubmit(event) {
		event.preventDefault();

		// 프롬프트가 비어있거나 로딩중이면 중지
		if (!prompt.trim() || isLoading) return;

		// 사용자 입력 메시지 추가
		setMessages((prev) => [...prev, { role: "user", content: prompt }]);

		setPrompt("");
		setIsLoading(true);

		// AI 응답 생성
		await generateAiResponse();
		setIsLoading(false);
	}

	// 메모 생성
	const handleConfirmMemo = (memo) => {
		dispatch(addMemo(memo));
		setPendingMemos((prev) => prev.filter((m) => m !== memo));
		// AI 답변 메시지로 추가
		setMessages((prev) => [
			...prev,
			{ role: "ai", content: "✅ 메모가 생성되었습니다." },
		]);
	};

	// 메모 취소
	const handleCancelMemo = (memo) => {
		setPendingMemos((prev) => prev.filter((m) => m !== memo));
		// AI 답변 메시지로 추가
		setMessages((prev) => [
			...prev,
			{ role: "ai", content: "⚠️ 메모가 취소되었습니다." },
		]);
	};

	return (
		<div className="max-w-4xl mx-auto p-6 space-y-6">
			{/* 초기 안내 영역 */}
			{messages.length === 0 && (
				<div className="flex flex-col items-center justify-center h-64 text-center py-12 space-y-4">
					<h3 className="text-2xl font-semibold text-gray-900">
						AI 메모 생성기
					</h3>
					<p className="text-gray-600 max-w-md">
						자연어로 할 일을 입력하면 AI가 자동으로 메모를 생성합니다.
					</p>
					<div className="bg-gray-50 p-5 rounded-lg w-full max-w-md">
						<h4 className="font-semibold text-gray-900 mb-2">예시</h4>
						<ul className="text-sm text-gray-600 space-y-1 list-disc list-inside">
							<ol>내일 오후 3시에 회의 준비하기</ol>
							<ol>다음 주까지 프로젝트 보고서 작성</ol>
							<ol>금요일에 병원 예약하기</ol>
						</ul>
					</div>
				</div>
			)}

			{/* 메시지 영역 */}
			<div className="space-y-4 max-h-[400px] overflow-y-auto px-2">
				{messages.map((message, idx) => (
					<ChatMessage key={idx} message={message} />
				))}
				{/* 스크롤 하단 유지를 위한 ref */}
				<div ref={messagesEndRef} />
			</div>

			{/* pending 메모 카드 */}
			<div className="space-y-4">
				{pendingMemos.map((memo, idx) => (
					<MemoCard
						key={idx}
						memo={memo}
						onConfirm={() => handleConfirmMemo(memo)}
						onCancel={() => handleCancelMemo(memo)}
					/>
				))}
			</div>

			{/* 사용자의 프롬프트 작성 폼 */}
			<div className="sticky bottom-0 bg-white pt-4 border-t border-gray-300">
				<ChatForm
					prompt={prompt}
					setPrompt={setPrompt}
					isLoading={isLoading}
					onSubmit={handleSubmit}
				/>
			</div>
		</div>
	);
}
