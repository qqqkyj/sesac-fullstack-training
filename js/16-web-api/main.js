// axios 불러오기
import axios from "axios";

// async/await
// 비동기처리(async) 방식의 함수
async function connectTest() {
	// axios.get(url) : 데이터 요청에 대한 응답 데이터를 반환
	const res = await axios.get("https://jsonplaceholder.typicode.com/posts");
	//console.log(res);
	console.table(Object.entries(res));
	console.table(Object.keys(res));
	console.log(res["config"]);
}
connectTest();
