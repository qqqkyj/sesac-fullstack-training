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
