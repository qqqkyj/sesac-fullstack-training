// promise
// resolve() : 성공 시 값을 반환하는 함수
// reject() : 실패 시 값을 반환하는 함수
const randomPromise = new Promise((resolve, reject) => {
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

// promise 두 가지 상태
// 비동기 처리의 성공과 실패
// 예시) 네트워크 통신의 성공과 실패

// 성공 상태일 때 수행할 처리 메서드
// Promise.then(콜백함수)

// 실패 상태일 때 수행할 처리 메서드
// Promise데이터.catch(콜백함수)

// 콜백함수는 매개변수를 하나 받는다
// randomPromise
// 	.then((result) => {
// 		//resovle의 인자
// 		console.log(`성공 : ${result}`);
// 	})
// 	.catch((error) => {
// 		//reject의 인자
// 		console.log(`실패 : ${error}`);
// 	});

// fetch : Promise 자료형 기반 네트워크 통신 함수
// 필수품 : 웹 서비스의 주소
// promise 체이닝 : 여러 비동기 작업을 순차적으로 실행
// fetch("https://example.com")
// 	.then((res) => {
// 		console.log(res);
// 		return res.text(); //다음 then 함수의 인자로 전달
// 	})
// 	.then((data) => {
// 		console.log(data); //data : 위에서 전달받은 인자
// 	});
// .catch((error) => {
// 	console.log(error);
// });

// async/await
// Promise 자료형을 쉽게 사용하게 도와주는 키워드

// async 키워드
// 함수앞에 붙는 키워드.
// 해당 함수가 비동기를 처리하는 함수란 것을 표기
async function func() {
	// await 키워드
	// Promise의 완료(성공 or 실패)를 대기하는 키워드
	// async 함수 내부에서 Promise가 완료될 때까지 기다리는 키워드

	try {
		// 비동기처리를 수행하는 코드

		// await 키워드
		// Promise 기반 비동기처리 수행
		// 수행 결과 resolve() 함수 인자를 반환
		const result = await randomPromise;
		console.log(result);
	} catch (error) {
		// 비동기처리를 실패했을 때 수행하는 코드
		console.log(error);
	}
}

func();
