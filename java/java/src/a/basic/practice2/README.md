## 💡 **반복문 (Loops)**

자바에서 반복문은 **특정 조건이 만족될 때까지 코드를 반복 실행**할 때 사용한다.

---

### 🔹 **1. for문 (for loop)**

> 반복 횟수가 명확할 때 사용

```java
/*
for (초기화; 조건식; 증감식) {
     반복 실행될 코드
}
*/

public class ForExample {
    public static void main(String[] args) {
        // 기본 for문
        for(int i = 0; i < 10 ; i++){
            System.out.println(i);
        }
        System.out.println();

        // 역순 반복
        for(int i = 10; i >= 1 ; i--){
            System.out.println(i);
        }
        System.out.println();

        // 2씩 증가
        for(int i = 0; i < 10 ; i += 2){
            System.out.println(i);
        }
    }
}
```

**실행 순서**

1. 초기화 (최초 1회만 실행)
2. 조건식 검사
3. 조건이 `true`면 코드 블록 실행
4. 증감식 실행
5. 2단계로 돌아감

---

### 🔹 **2. 중첩 for문 (Nested for loop)**

> 반복문 안에 또 다른 반복문을 포함시켜 이중 반복을 구현할 수 있다.

**예: 구구단**

```java
// 중첩 for문
for(int i = 2; i < 10; i++){
    System.out.printf("**** %d단 ****%n", i);
    for(int j = 1; j < 10; j++){
        System.out.printf("%d X %d = %d%n", i, j, i * j);
    }
}
```

---

### 🔹 **3. while문 (while loop)**

> 조건이 true인 동안 반복
>
> 반복 횟수가 명확하지 않을 때 사용

```java
// while문
int i = 0;

while(i < 10){
    System.out.println(i);
    i++;
}
```

💡 `for`는 반복 횟수가 정해졌을 때,

`while`은 조건이 중요할 때 사용.

---

### 🔹 **4. do-while문 (do-while loop)**

> 최소 1회는 실행되는 반복문
>
> 조건을 **나중에 검사**

```java
// do-while문
int j = 10;

do {
    System.out.println(j);
    j++;
} while (j < 10);
```

---

### 🔹 **5. 향상된 for문 (Enhanced for / for-each)**

> 배열이나 컬렉션의 모든 요소를 순회할 때 사용

```java
int[] numbers = {1, 2, 3, 4, 5};

// 기본 for문 (인덱스로 접근)
for(int i = 0; i < numbers.length; i++){
    System.out.println(numbers[i]);
}
System.out.println();

// 향상된 for문 (요소로 직접 접근)
for(int number : numbers){
    System.out.println(number);
}
```

**✅ 장점**

- 코드가 간결하고 가독성 좋음
- 인덱스 실수 방지
- 모든 요소 순회 보장

**⚠️ 단점**

- 인덱스 직접 접근 불가
- 원시 타입 값 변경 불가
- 역순 순회 불가

---

### 🔹 **6. break**

> 반복문을 즉시 종료

```java
for(int z = 0; z < 10; z++){
    System.out.println(z);
    if(z == 5) break; // 반복 종료
}
```

---

### 🔹 **7. continue**

> 현재 반복을 건너뛰고 다음 반복으로 진행

```java
for(int z = 0; z < 10; z++){
    if(z % 2 == 0) continue; // 짝수 건너뛰기
    System.out.println(z);
}
```

---

### 🔹 **8. Label (레이블)**

> 중첩 반복문에서 특정 반복문을 제어할 때 사용
>
> `break`나 `continue`와 함께 활용

```java
outer: // 레이블 이름
for(int x = 2; x < 10; x++){
    if(x > 4) break outer; // 4단까지만 출력
    System.out.printf("***** %d단 *****%n", x);
    for(int y = 1; y < 10; y++){
        System.out.printf("%d X %d = %d%n", x, y, x * y);
    }
}
```

---

### ✅ **정리 요약표**

| 문법       | 사용 목적               | 특징                       |
| ---------- | ----------------------- | -------------------------- |
| `for`      | 반복 횟수가 명확할 때   | 초기화, 조건, 증감 한 줄에 |
| `while`    | 조건이 중요할 때        | 조건만으로 제어            |
| `do-while` | 최소 1회 실행 필요할 때 | 조건 나중에 검사           |
| `for-each` | 배열, 컬렉션 순회       | 인덱스 접근 불가           |
| `break`    | 반복 즉시 종료          | 조건에 따라 탈출           |
| `continue` | 다음 반복으로 건너뜀    | 일부만 건너뛰기            |
| `label`    | 중첩 반복 제어          | break/continue와 함께 사용 |

# 🧩 Java 기본 실습 정리

> 패키지: a.basic.practice2
>
> 파일명: `Practice.java`

---

## 📘 문제 1. 구구단

2단부터 9단까지 구구단 출력

```java
for(int i = 2; i < 10; i++){
    System.out.printf("*****%d단*****%n", i);
    for(int j = 1; j < 10; j++){
        System.out.printf("%d X %d = %d%n", i, j, i*j);
    }
}
```

---

## ⭐ 문제 2. 별 찍기 패턴 1

```
*
**
***
****
*****
```

```java
for(int i = 1; i <= 5; i++){
    for(int j = 1; j <= i; j++){
        System.out.print("*");
    }
    System.out.println();
}
```

---

## ⭐ 문제 3. 별 찍기 패턴 2

```
*****
****
***
**
*
```

```java
for(int i = 5; i >= 1; i--){
    for(int j = i; j > 0; j--){
        System.out.print("*");
    }
    System.out.println();
}
```

---

## ⭐ 문제 4. 별 찍기 패턴 3 (피라미드)

```
    *
   ***
  *****
 *******
*********
```

```java
for(int i = 1; i <= 5; i++){
    for(int j = 5; j > i; j--){
        System.out.print(" ");
    }
    for(int x = 1; x <= 2*i - 1; x++){
        System.out.print("*");
    }
    System.out.println();
}
```

---

## 🔢 문제 5. 약수 구하기

```java
int num = 24;
for(int i = 1; i <= num; i++){
    if(num % i == 0)
        System.out.printf("%d ", i);
}
System.out.println();
```

---

## 🔍 문제 6. 소수 판별

```java
int num = 17;
boolean flag = true;

for(int x = 2; x < num; x++){
    if(num % x == 0){
        flag = false;
        break;
    }
}
System.out.println(flag ? "소수입니다." : "소수가 아닙니다.");
```

---

## ⚡ 문제 7. 소수 판별 (최적화 버전)

```java
int num = 17;
boolean flag = true;

for(int i = 2; i <= Math.sqrt(num); i++){
    if(num % i == 0){
        flag = false;
        break;
    }
}
System.out.println(flag ? "소수입니다." : "소수가 아닙니다.");
```

**번외 문제 (1 ~ num까지의 숫자 중 소수 구하기):**

```java
int[] isPrimeArr = new int[num+1];
isPrimeArr[0] = 1;
isPrimeArr[1] = 1;
int cnt = 0;

for(int i=2; i<=num; i++){
    if(isPrimeArr[i]!=1){
        cnt++; // 소수의 개수
        System.out.println(i); // 소수 출력
        for(int j=i; j<=num; j+=i){
            isPrimeArr[j] = 1;
        }
    }
}
System.out.println("1~"+num+"까지 소수의 개수: "+cnt);
```

---

## 💯 문제 8. 최대공약수 (GCD)

```java
int a = 48, b = 18;
while(b != 0){
    int tmp = a % b;
    a = b;
    b = tmp;
}
System.out.println("최대공약수: " + a);
```

---

## 💡 문제 9. 최소공배수 (LCM)

```java
int a = 12;
int b = 18;
Practice p = new Practice();
System.out.println("최소공배수: " + (long)a * b / p.gcd(a, b));
```

---

## 🌀 문제 10. 피보나치 수열

```java
int n = 10;
int[] array = new int[n];
array[0] = 0;
array[1] = 1;

for(int i = 2; i < n; i++){
    array[i] = array[i-1] + array[i-2];
}
System.out.printf("%d번째 피보나치 수: %d%n", n, array[n-1]);
```

---

## 🧮 문제 11. 팩토리얼

```java
int n = 5;
long result = 1;
for(int i = 1; i <= n; i++){
    result *= i;
}
System.out.printf("%d! = %d%n", n, result);
```

---

## 🔄 문제 12. 역순 숫자 출력

```java
int num = 12345;
String strNum = String.valueOf(num);
String revStrNum = new StringBuilder(strNum).reverse().toString();
int revNum = Integer.parseInt(revStrNum);
System.out.println(revNum);
```

---

## ➕ 문제 13. 숫자 자릿수 합

**방법 1 (문자열 이용):**

```java
int num = 12345;
String[] digits = String.valueOf(num).split("");
int total = 0;
for(String s : digits){
    total += Integer.parseInt(s);
}
System.out.println(total);
```

**방법 2 (수학적 방법):**

```java
int num2 = 12345;
int result = 0;
while(num2 != 0){
    result += num2 % 10;
    num2 /= 10;
}
System.out.println(result);
```

---

## 🚫 문제 14. 구구단 특정 단 건너뛰기

```java
for(int i = 2; i <= 9; i++){
    if(i == 5) continue; // 5단 건너뛰기
    System.out.printf("*****%d단*****%n", i);
    for(int j = 1; j <= 9; j++){
        System.out.printf("%d X %d = %d%n", i, j, i*j);
    }
}
```

---

## 🔧 gcd() 메서드 (최대공약수 계산)

```java
public int gcd(int a, int b) {
    while(b != 0){
        int tmp = a % b;
        a = b;
        b = tmp;
    }
    return a;
}
```

---

### ✅ 전체 요약

| 유형          | 주제               | 키워드                    |
| ------------- | ------------------ | ------------------------- |
| 반복문        | 구구단, 별 찍기    | `for`, `nested loop`      |
| 조건문        | 약수, 소수 판별    | `if`, `break`, `continue` |
| 수학 알고리즘 | GCD, LCM, 팩토리얼 | `while`, `method`         |
| 배열          | 피보나치 수열      | `array`, `index`          |
| 문자열        | 역순, 자릿수 합    | `StringBuilder`, `split`  |

---

## 💡 **인텔리제이 psvm 설정**

> psvm → public static void main(String[] args) 자동 완성 템플릿

---

### ⚙️ 설정 경로

**`설정 > 에디터 > 라이브 템플릿`**

1. 왼쪽에서 **Java 선택**

   ![alt text](../img/image-9.png)

2. 목록 중 **psvm 선택**

   ![alt text](../img/image-10.png)

3. 아래쪽 설명 부분을 클릭

   ![alt text](../img/image-11.png)

---

### ✅ 수정 방법

- `인스턴스 ‘main’ 메서드를 포함하는 일반 클래스 내의 선언`
- `인스턴스 ‘main’ 메서드를 포함하지 않는 일반 클래스 내의 선언`
  → **두 항목 모두 체크 후 [적용] 클릭**

이제 `psvm` 입력 후 `Tab` 누르면 자동으로

```java
public static void main(String[] args) {

}
```

이 생성됩니다 🎉

---

## 💡 **배열 (Array)**

> **같은 타입의 데이터**를 연속된 메모리 공간에 저장하는 자료구조

---

### 🔹 **배열 선언 및 초기화**

```java
package a.basic;

public class Array {
    public static void main(String[] args) {
        // 배열 선언 (크기 지정)
        int[] numbers = new int[5]; // 기본값은 0으로 초기화

        // 값 할당
        numbers[0] = 100;
        numbers[1] = 200;

        System.out.println(numbers.length); // 배열 길이
        System.out.println(numbers[0]);
        System.out.println(numbers[4]);

        // (1) 선언 후 한 칸씩 초기화
        int[] arr1 = new int[5];
        arr1[0] = 1;
        arr1[1] = 2;
        arr1[2] = 3;

        // (2) 선언과 동시에 초기화
        int[] arr2 = new int[]{1, 2, 3, 4, 5};

        // (3) new 생략 가능
        int[] arr3 = {1, 2, 3, 4, 5};

        // 문자열 배열
        String[] names = {"kim", "lee", "park"};
        System.out.println(names.length);

        // 배열 순회
        int[] scores = {80, 40, 80, 90, 100};

        // 인덱스로 접근
        for(int i = 0; i < scores.length; i++){
            System.out.println(scores[i]);
        }

        // 향상된 for문
        for(int score : scores){
            System.out.println(score);
        }
    }
}
```

---

### 🧠 **배열 특징**

| 항목   | 설명                                                     |
| ------ | -------------------------------------------------------- |
| 자료형 | 모든 요소는 같은 타입                                    |
| 인덱스 | 0부터 시작                                               |
| 길이   | `배열명.length`                                          |
| 초기값 | 정수형 → 0, 실수형 → 0.0, boolean → false, 참조형 → null |
| 크기   | 고정 (생성 후 변경 불가)                                 |

---

### 🔹 **다차원 배열 (2차원 배열)**

> **배열 안에 또 다른 배열**을 담을 수 있음

```java
// 2차원 배열 선언 및 초기화
int[][] matrix = {
    {1, 2, 3}, // 0행
    {4, 5, 6}, // 1행
    {7, 8, 9}  // 2행
};

// 인덱스로 접근
for(int i = 0; i < matrix.length; i++){
    for(int j = 0; j < matrix[i].length; j++){
        System.out.println(matrix[i][j]);
    }
}
```

---

### 🔹 **가변 배열 (Jagged Array)**

> 행마다 열의 길이가 다른 배열

```java
int[][] jagged = {
    {1},
    {2, 3},
    {4, 5, 6},
    {7, 8, 9, 10}
};

// 향상된 for문
for(int[] row : jagged){
    for(int item : row){
        System.out.println(item);
    }
}
```

---

### ✅ **정리 요약표**

| 구분        | 문법                              | 설명                   |
| ----------- | --------------------------------- | ---------------------- |
| 선언        | `int[] arr = new int[5];`         | 크기 5의 int 배열 생성 |
| 초기화      | `int[] arr = {1,2,3,4,5};`        | 선언과 동시에 초기화   |
| 접근        | `arr[0]`                          | 첫 번째 요소           |
| 길이        | `arr.length`                      | 배열 크기 확인         |
| 반복        | `for` / `for-each`                | 모든 요소 순회         |
| 다차원 배열 | `int[][] matrix = new int[3][3];` | 2차원 구조 표현 가능   |
