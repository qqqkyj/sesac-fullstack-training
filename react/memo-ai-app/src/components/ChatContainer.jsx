// 로그인을 한 상태라면 사용자 정보를 출력
// (정상적으로 로그인 했을 경우) 사용자 정보는 전역 상태 token에 저장된 상태
import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { jwtDecode } from "jwt-decode";
import { logout } from "../store/authSlice";
import { useEffect, useRef, useState } from "react";
// chat 객체 불러오기
import { chat } from "../utils/genai";
import ChatMessage from "./ChatMessage";
import ChatForm from "../components/ChatForm";

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
		if (token) {
			setDecodeToken(jwtDecode(token));
		}
	}, [token]);

	useEffect(() => {
		if (error) {
			alert(
				` error code: ${error.code}\n error_code: ${error.error_code}\n msg: ${error.msg} \n 다시 로그인 해주세요.`
			);
		}
	}, [error]);

	// 로그아웃 핸들링 함수
	function handleLogout() {
		console.log("handleLogout시작");
		console.log("logout error:", error);
		dispatch(logout());
	}

	// querySelector 메서드 처럼 요소를 조작(참조)하기 위한 훅
	// querySelector는 React 제어에서 벗어난 방법이기에 useRef 훅을 대신 사용
	const messagesEndRef = useRef(null);
	const [prompt, setPrompt] = useState(""); // 사용자 입력 요소 값
	const [messages, setMessages] = useState([]); // 사용자 - AI 채팅 메시지 내역
	const [isLoading, setIsLoading] = useState(false); // AI 요청 응답 로딩 상태

	//useEffect 훅을 사용해서 메시지 내역 상태(message)가 변경될 때 스크롤 이동
	useEffect(() => {
		messagesEndRef.current.scrollIntoView({ behavior: "smooth" });
	}, [messages]);

	//응답 생성 함수
	async function generateAiResponse() {
		try {
			// AI 응답 생성
			const stream = await chat.sendMessageStream({
				message: prompt,
			});

			// 스트림 응답을 위한 빈 AI 메시지 먼저 추가
			setMessages((prev) => [...prev, { role: "ai", content: "" }]);

			// 청크 누적용 문자열 변수
			let accumulatedResponse = "";

			for await (const chunk of stream) {
				// 스트림 청크 누적
				accumulatedResponse += chunk.text || "";

				// 메시지 상태 변경(함수형 업데이트)
				// prev 매개변수 : 이전 상태 데이터
				setMessages((prev) => {
					// newMessages : 새로운 배열 생성(복사)
					const newMessages = [...prev];

					// lastMessage : 마지막 메시지 메모리 주소 참조
					const lastMessage = newMessages[newMessages.length - 1];

					// AI 메시지인 경우 누적된 청크로 마지막 메세지 변경
					if (lastMessage["role"] === "ai") {
						lastMessage.content = accumulatedResponse;
					}

					// 마지막 메세지만 변경된 새로운 배열 반환
					return newMessages;
				});
			}
		} catch (error) {
			console.error(error);
		}
	}

	//폼 제출 핸들링 함수
	async function handleSubmit(event) {
		event.preventDefault();

		// 프롬프트가 비어있거나 로딩중이면 중지(return)
		if (!prompt.trim() || isLoading) return;

		// 메세지 내역 상태에 사용자 입력 프롬프트 추가(함수형 업데이트)
		setMessages((prev) => [...prev, { role: "user", content: prompt }]);

		setPrompt("");
		setIsLoading(true);

		// AI 응답 생성
		await generateAiResponse();
		setIsLoading(false);
	}

	return (
		<div>
			<div>
				{decodeToken ? (
					`이메일: ${decodeToken.email}`
				) : (
					<div>
						<Link to="/login">로그인</Link>
						<button></button>
					</div>
				)}
				<div>
					<button
						className="border-px-4 py-2 border border-gray-300 cursor-pointer"
						onClick={() => {
							handleLogout();
						}}
					>
						로그아웃
					</button>
				</div>
			</div>

			{/* 메시지 표현 영역 */}
			<div>
				{messages.map((message, index) => (
					<ChatMessage key={index} message={message} />
				))}
				{/* 하단 스크롤 유지를 위한 빈 div */}
				<div ref={messagesEndRef}></div>
			</div>

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
