## 💡 **반복문 (Loops)**

자바에서 반복문은 **특정 조건이 만족될 때까지 코드를 반복 실행**할 때 사용한다.

---

### 🔹 **1. for문 (for loop)**

> 반복 횟수가 명확할 때 사용
>

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
>

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
>
> 반복 횟수가 명확하지 않을 때 사용
>

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
>
> 조건을 **나중에 검사**
>

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
>

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
>

```java
for(int z = 0; z < 10; z++){
    System.out.println(z);
    if(z == 5) break; // 반복 종료
}
```

---

### 🔹 **7. continue**

> 현재 반복을 건너뛰고 다음 반복으로 진행
>

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
>
> `break`나 `continue`와 함께 활용
>

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

| 문법 | 사용 목적 | 특징 |
| --- | --- | --- |
| `for` | 반복 횟수가 명확할 때 | 초기화, 조건, 증감 한 줄에 |
| `while` | 조건이 중요할 때 | 조건만으로 제어 |
| `do-while` | 최소 1회 실행 필요할 때 | 조건 나중에 검사 |
| `for-each` | 배열, 컬렉션 순회 | 인덱스 접근 불가 |
| `break` | 반복 즉시 종료 | 조건에 따라 탈출 |
| `continue` | 다음 반복으로 건너뜀 | 일부만 건너뛰기 |
| `label` | 중첩 반복 제어 | break/continue와 함께 사용 |

# 🧩 Java 기본 실습 정리

> 패키지: a.basic.practice2
>
>
> 파일명: `Practice.java`
>

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
int result = 1;
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

| 유형 | 주제 | 키워드 |
| --- | --- | --- |
| 반복문 | 구구단, 별 찍기 | `for`, `nested loop` |
| 조건문 | 약수, 소수 판별 | `if`, `break`, `continue` |
| 수학 알고리즘 | GCD, LCM, 팩토리얼 | `while`, `method` |
| 배열 | 피보나치 수열 | `array`, `index` |
| 문자열 | 역순, 자릿수 합 | `StringBuilder`, `split` |

---
