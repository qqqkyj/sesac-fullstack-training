// 반복문이 없는 코드
// 변수 number를 선언하고, 0을 할당
// 변수 number를 5번 출력
// 1씩 증가하면서
let number = 0;
console.log(++number);
console.log(++number);
console.log(++number);
console.log(++number);
console.log(++number);

// for 반복문 기본 형태
// for (초기화; 조건식; 증감식) { 실행할 코드 }
for (let i = 0; i < 5; i++) {
	console.log(number++); //반복 실행할 코드
}

// for(초기화; 조건식; 증감문)
for (let number2 = 0; number2 < 3; number2++) {
	console.log(number2); //반복 실행할 코드
}

// 내가 원하는 횟수(N번) 반복하기
let N = 5;
for (let i = 0; i < N; i++) {
	console.log(`${i + 1}번 실행`); //반복 실행할 코드
}

// 숫자를 0부터 5까지 출력
for (let i = 0; i < 6; i++) {
	console.log(i);
}

// while 반복문 (조건식이 true일 동안 반복)
let i = 0;
while (i < 5) {
	console.log(i);
	i++;
}

console.log("______");

// do...while 반복문 (조건과 상관없이 최소 1번은 실행)
let j = 0;
do {
	console.log(j);
	j++;
} while (j < 5);

console.log("______");

// break 예제 (반복문 강제 종료)
for (let k = 0; k < 10; k++) {
	if (k === 5) {
		break; // k가 5일 때 반복문 종료
	}
	console.log(k); // 0, 1, 2, 3, 4
}

console.log("______");

// continue 예제 (해당 반복만 건너뜀)
for (let m = 0; m < 10; m++) {
	if (m % 2 === 0) {
		continue; // 짝수일 때는 건너뛰고 다음 반복으로 넘어감
	}
	console.log(m); // 1, 3, 5, 7, 9
}
