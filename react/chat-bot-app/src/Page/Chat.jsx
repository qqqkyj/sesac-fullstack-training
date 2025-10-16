import { useState } from "react";
import MessageList from "../components/MessageList";
import ChatForm from "../components/ChatForm";
// ai, chat 객체, 응답 파라미터 설정 불러오기
import { ai, chat, config } from "../utils/genai";

export default function Chat() {
	const [prompt, setPrompt] = useState(""); // 사용자 입력 프롬프트 관리 상태
	const [message, setMessage] = useState([]); // 사용자 - AI 메시지 관리 상태
	const [isLoading, setIsLoading] = useState(false); // AI 요청 후 응답 대기 상태

	async function handleSubmit(event) {
		event.preventDefault();
		// 프롬프트가 비어있거나 AI 응답을 대기 중이라면
		// isLoading === true 라면 작업 X
		if (isLoading || prompt.trim() === "") return;

		// 대화 내역 상태를 업데이트
		// 사용자의 프롬프트를 대화 내역에 추가 (role: "user")
		// role 역할 : user라면 오른쪽에 배치, ai라면 왼쪽에 배치
		setMessage((prev) => [...prev, { role: "user", content: prompt }]);

		// currentPrompt 변수
		const currentPrompt = prompt;
		// 상태 promt 초기화
		setPrompt("");

		setIsLoading(true); //요청 시작
		await generateAiContent(currentPrompt); //AI 응답 생성 함수
		setIsLoading(false); // 요청 종료
	}

	// AI에게 요청을 보내서 응답을 생성하는 함수
	async function generateAiContent(currentPrompt) {
		try {
			const response = await chat.sendMessage({
				message: currentPrompt,
				config: config,
			});

			console.log(response.data);

			// 사용자 입력 프롬프트 초기화
			setPrompt("");

			// messages 상태에 AI의 응답을 저장
			setMessage((prev) => [...prev, { role: "ai", content: response.text }]);
		} catch (error) {
			console.log(error);
		}
	}

	return (
		<div>
			{/* 사용자 - AI 대화 내용 출력 컴포넌트 */}
			<MessageList messages={message} />
			{/* 사용자의 프롬프트 작성 폼 컴포넌트 */}
			<ChatForm
				prompt={prompt} // 사용자 입력 값 관리 상태
				setPrompt={setPrompt} //사용자 입력 값 상태 변경 함수
				isLoading={isLoading} // AI 응답 대기 상태
				onSubmit={handleSubmit} // form 요소 제출 이벤트 핸들러 함수
			/>
		</div>
	);
}
