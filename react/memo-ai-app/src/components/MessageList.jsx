import { useRef, useEffect } from "react";
import ChatMessage from "./ChatMessage";

// Props messages : 사용자 / AI 메세지 저장 배열
export default function MessageList({ messages }) {
	// useRef 훅 : document.querySelector() -> 요소를 선택
	const messagesEndRef = useRef(null);

	useEffect(() => {
		// message가 변경될 때 마다 messagesEndRef가 가르키는 요소로 스크롤을 이동
		// 응답 메시지가 추가되면 최하단으로 스크롤
		messagesEndRef.current?.scrollIntoView({ behavior: "smooth" });
	}, [messages]);

	return (
		<div className="flex-1 overflow-y-auto p-4">
			{messages.map((message, index) => (
				<ChatMessage key={index} message={message} />
			))}
			{/* 하단 스크롤 유지를 위한 빈 div */}
			<div ref={messagesEndRef}></div>
		</div>
	);
}
