// 비동기 처리 함수
// setTimeout, setInterval, fetch

// setTimeout(콜백, 밀리초)
// 밀리초 뒤에 콜백함수를 실행하는 비동기처리 함수

console.log("setTimeout 전 코드");
setTimeout(() => {
	console.log("5000ms 후 실행"); //5초 후 실행
}, 5000);
setTimeout(() => {
	console.log("1000ms 후 실행"); //1초 후 실행
}, 1000);
setTimeout(() => {
	console.log("3000ms 후 실행"); //3초 후 실행
}, 3000);
console.log("setTimeout 후 코드");

// 출력 결과
// setTimeout 전 코드
// setTimeout 후 코드
// 1000ms 후 실행
// 3000ms 후 실행
// 5000ms 후 실행

// 콜백 지옥
// setTimeout(() => {
// 	setTimeout(() => {
// 		setTimeout(() => {
// 			console.log("콜백 지옥.1000ms 후 실행"); //1초 후 실행
// 		}, 1000);
// 		console.log("콜백 지옥.2000ms 후 실행"); //2초 후 실행
// 	}, 2000);
// 	console.log("콜백 지옥.3000ms 후 실행"); //3초 후 실행
// }, 3000);

// promise
// resolve() : 성공 시 값을 반환하는 함수
// reject() : 실패 시 값을 반환하는 함수
const promise = new Promise((resolve, reject) => {
	// 비동기 작업 흉내
	setTimeout(() => {
		const random = Math.random(); // 랜덤 숫자 생성

		if (random > 0.5) {
			resolve("숫자가 0.5 이상! 성공"); // 성공 시  반환
		} else {
			reject("숫자가 0.5 이하! 실패"); // 실패 시  반환
		}
	}, 1000);
});
console.log(promise);
