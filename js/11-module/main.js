//모듈을 불러오기
//import / from

//from : 어디서 불러올 것인지
//import : 무엇을 불러올 것 인지
//import {함수명1, 함수명2...} from "파일";
// as로 alias 가능
// 여러개 내보내기/불러오기는 일부만 불러오기가 가능
// 일부 불러오기
// 트리 세이킹(사용하지 않는 코드를 제거함으로써 최적화)
// 프로덕션 환경을 위한 파일을 생성(빌드)할 때 사용하지 않은 코드는 제거하는 기술
import { add as addAdd, substract, multiply, devide, PI } from "./math.js";

console.log(addAdd(20, 10));
console.log(substract(20, 10));
console.log(multiply(20, 10));
console.log(devide(20, 10));

// 하나만 불러오기(Default Export)
// 내가 불러온 함수의 이름을 결정

// 대표성을 띈다는 특징
import plus from "./calculator.js";

console.log(plus(1, 2));

// 대표성을 띈다는 특징
import calculator2 from "./calculator2.js";
console.log(calculator2);
// {
//   add: [Function: add],
//   substract: [Function: substract],
//   multiply: [Function: multiply],
//   multiplyArrow: [Function: multiplyArrow]
// }

console.log(calculator2.add(1, 2));
console.log(calculator2.substract(4, 2));
