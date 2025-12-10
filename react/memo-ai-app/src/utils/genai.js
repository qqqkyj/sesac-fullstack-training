// 기본 컨텐츠 생성형 AI
import { GoogleGenAI } from "@google/genai";
// 환경 변수 GEMINI API KEY
const GEMINI_API_KEY = import.meta.env.VITE_GEMINI_API_KEY;
// AI 객체 생성
const ai = new GoogleGenAI({ apiKey: GEMINI_API_KEY });

// AI Chat 객체 생성
const chat = ai.chats.create({
	model: "gemini-2.5-flash",
});

// 응답 스키마
const responseSchema = {
	type: "object",
	properties: {
		// 객체의 속성들
		isMemo: {
			type: "boolean",
			description: "할 일, 메모, 업무, 계획 등 관련 여부",
		},
		content: {
			type: "string",
			description: "할 일 내용",
		},
		dueDate: {
			type: "string",
			description: "마감 날짜(YYYY-MM-DD)",
		},
		priority: {
			type: "string",
			enum: ["높음", "중간", "낮음"],
			description: "우선 순위",
		},
		category: {
			type: "string",
			description: "할 일 종류",
		},
	},
	required: ["isMemo", "content", "dueDate"], //응답 필수 속성
	additionalProperties: false, //false로 설정하면 위에 설정된 구조로만 답변
};

// 시스템 지침
const systemInstruction = [
	`오늘 날짜: ${new Date().toISOString().split("T")[0]}`,
	"당신은 '할 일 관리 AI'입니다. 사용자의 입력을 분석하여 할 일(To-do)만 JSON 형식으로 처리합니다.",
	"할 일이나 업무 관련 내용이 아닌 일반적인 대화, 인사말, 질문 등은 isMemo를 false로 설정하고, content 필드에 '메모로 생성할 수 없는 내용입니다.'라고 응답합니다.",
];

const config = {
	responseMimeType: "application/json", //응답 형식(확장자)
	responseJsonSchema: responseSchema, //응답 JSON 구조
	systemInstruction: systemInstruction,
};

// 응답 파라미터 설정
// const config = {
// 	temperature: 1, // 창의성 수준(0 ~ 1)
// 	maxOutputToken: 1000, //응답 최대 토큰 수
// 	stopSquences: "\\n\\n", //응답 생성 중단 문자열
// 	// 시스템 지침 속성
// 	systemInstruction: systemInstruction,
// };

export { ai, chat, config };
