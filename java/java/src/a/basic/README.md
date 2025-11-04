# 💻 Java - 기초

---

## 🧩 Java란?

> 객체 지향 프로그래밍(OOP: Object Oriented Programming) 언어로,
>
> 코드의 **재사용성**과 **유지 보수성**을 높이는 데 중점을 둔 언어입니다.

- 운영체제에 **독립적**으로 실행 가능
- **정적 타입(Statically-Typed)** 언어 → 변수의 타입을 반드시 명시해야 함
- **컴파일 언어(Compiled Language)**
  → 실행 전 컴파일 과정을 거쳐 `.class` 바이트코드 생성
  → 문법 오류 등을 **사전에 확인** 가능

---

## ☕ JVM (Java Virtual Machine)

- Java 프로그램을 실제 OS 환경에 맞게 실행시켜 주는 **가상 머신**
- JVM이 설치되어 있다면 **Windows / macOS / Linux 어디서든 동일하게 실행 가능**

---

## ⚖️ Java vs JavaScript

| 구분            | **JavaScript**                        | **Java**                           |
| --------------- | ------------------------------------- | ---------------------------------- |
| **타입 시스템** | 동적 타입 (Dynamic Typing)            | 정적 타입 (Static Typing)          |
| **실행 환경**   | 브라우저, Node.js                     | JVM (Java Virtual Machine)         |
| **컴파일 방식** | 인터프리터 방식(실행 시 한 줄씩 해석) | 컴파일 후 실행(`.class` 파일 생성) |
| **클래스 구조** | ES6+ 지원, 프로토타입 기반            | 처음부터 클래스 기반 OOP           |
| **대표 용도**   | 웹, 서버 (Node.js)                    | 서버, 안드로이드, 엔터프라이즈 앱  |

---

### 💡 참고

- **JavaScript**
  - 인터프리터 언어
  - 개발자 입장에서는 컴파일 과정이 보이지 않음
  - V8 엔진 등은 내부적으로 **JIT(Just-In-Time) 컴파일** 수행
- **TypeScript**
  - JavaScript에 **정적 타입 시스템**을 추가한 언어

---

## 🧱 Java 개발 환경 구성

---

### 🔧 JDK / JRE / JVM 관계

| 구성 요소 | 설명                                  |
| --------- | ------------------------------------- |
| **JVM**   | Java 바이트코드를 실행하는 가상 머신  |
| **JRE**   | JVM + 표준 라이브러리 (실행 환경)     |
| **JDK**   | JRE + 개발 도구 (컴파일러, 디버거 등) |

> ✅ JDK(Java Development Kit) = 개발용 필수 도구 세트

---

### 📥 JDK 설치 방법

1. **JDK 다운로드**
   - Oracle JDK 👉 https://www.oracle.com/java/technologies/downloads/
   - OpenJDK 👉 https://adoptium.net/
2. **환경 변수 설정**
   - `JAVA_HOME` → JDK 설치 경로
   - `PATH` → JDK의 `bin` 디렉터리 추가
3. **설치 확인**

```bash
java -version
javac -version
```

---

## 🧰 개발 환경 (IDE) 설정

Java 개발에 자주 사용되는 IDE 비교 👇

| IDE                  | 특징                                                     |
| -------------------- | -------------------------------------------------------- |
| **IntelliJ IDEA** ⭐ | 강력한 자동완성, 리팩토링 기능Community Edition 무료     |
| **Eclipse**          | 오픈소스, 무료오랜 역사와 커뮤니티 보유                  |
| **VS Code**          | JavaScript 개발자에게 친숙“Extension Pack for Java” 필요 |

> ⚡ Node.js 환경에서 개발에 익숙하다면 VS Code + Java Extension도 가능하지만,
>
> **IntelliJ IDEA**를 **가장 추천**합니다.

---

📚 **정리**

- Java는 **정적 타입 + 컴파일 언어**
- JVM 위에서 **운영체제에 독립적으로 실행**
- **객체지향 설계(OOP)** 기반으로 대규모 프로젝트에 적합
- 개발 환경은 **JDK + IDE(IntelliJ/Eclipse)** 조합으로 구성

![alt text](img/image.png)

https://www.jetbrains.com/store/redeem/

- 위 경로에서 Coupon 등록

---

# ☕ **Java - 기초 정리**

---

## 💡 **프로젝트 생성 및 IntelliJ 설정**

- **Java 21 사용**
  ![alt text](img/image-1.png)

📁 **설정 경로:**

`파일 > 설정 > 모양 및 동작 > Presentation Assistant`
![alt text](img/image-2.png)

- 코드 실행: **`Ctrl + Shift + F10`**
- 디버깅:
  - **break point** 설정 후 상단의 🐞 버튼 클릭
  - `F8` → 다음 스텝 실행
    ![alt text](img/image-3.png)
- **out 폴더**: 컴파일된 `.class` 파일을 **디컴파일(decompile)** 해서 확인 가능

  ![alt text](img/image-4.png)

---

### ⚙️ **컴파일 과정**

```
HelloWorld.java (소스코드)
        ↓ javac (컴파일러)
HelloWorld.class (바이트코드)
        ↓ java (JVM)
    실행 결과
```

---

## 💡 **Java 코드 작성 규칙**

### 🧱 네이밍 규칙

| 구분         | 규칙                | 예시               |
| ------------ | ------------------- | ------------------ |
| **패키지명** | 모두 소문자         | `com.example.test` |
| **클래스명** | 파스칼(Pascal Case) | `HelloWorld`       |
| **메서드명** | 카멜(Camel Case)    | `printName()`      |
| **상수명**   | 모두 대문자         | `MAX_COUNT`        |

---

### 🖨️ **출력 예제**

```java
public class Test {
    public static void main(String[] args){
        // : 한 줄 주석 (Ctrl + /)
        /* 여러 줄 주석 */

        System.out.print("Hello");   // 기본 출력
        System.out.print("world");

        System.out.println("bye");   // 줄바꿈 출력
        System.out.println("world");

        // javascript: let name = "kim"
        String name = "kim";

        // 서식 지정자를 사용한 출력 (s: 문자열, c:문자, d:정수, f: 실수, n:줄바꿈)
        // javascript: console.log(`이름 : ${name}`);
        System.out.printf("이름 : %s", name);
    }
}
```

---

## 🧮 **변수 (Variable)**

> 데이터를 저장하는 메모리 공간에 이름을 붙인 것
>
> 프로그램에서 값을 저장하고 필요할 때 꺼내 쓰는 “상자” 역할

### 🪜 **명명 규칙**

- **카멜 케이스(Camel Case)** 사용
  - 첫 글자 소문자, 이후 단어의 첫 글자는 대문자
  - 예: `phoneNumber`, `teamMembersCount`
- **대소문자 구분**
- **길이 제한 없음**
- **예약어 사용 불가**
- **숫자로 시작 불가**
- **특수문자**는 `_`, `$`만 허용

---

### 🧾 **변수 선언 예제**

```java
package a.basic;

public class Variable {
    public static void main(String[] args){
        // 선언
        int age;

        // 할당
        age = 20;
        System.out.printf("나이: %d%n", age);

        // 선언과 동시에 초기화
        String name = "kim";
        System.out.printf("이름 : %s", name);
    }
}
```

---

## 🧩 **기본형 타입 (Primitive Types)**

| 분류   | 타입                   | 바이트     | 예시                   |
| ------ | ---------------------- | ---------- | ---------------------- |
| 정수형 | byte, short, int, long | 1, 2, 4, 8 | `int age = 20;`        |
| 실수형 | float, double          | 4, 8       | `double pi = 3.14;`    |
| 문자형 | char                   | 2          | `char grade = 'A';`    |
| 논리형 | boolean                | 1          | `boolean isOk = true;` |

```java
package a.basic;

public class Variable {
    public static void main(String[] args){
        byte b = 100;
        short s = 10000;
        int i = 10000000;
        long l = 10000000000L;

        float f = 3.14f;
        double d = 3.14;

        char c = 'A';
        boolean bool = true;

        System.out.println(b);
        System.out.println(d);
        System.out.println(c);
        System.out.println(bool);
    }
}
```

---

## 🧠 **참조형 타입 (Reference Types)**

> 기본형(primitive)이 아닌 모든 타입은 참조형(reference)
>
> 실제 데이터가 저장된 메모리의 **주소값을 참조**

- 대표: `String`, `Array`, `Class`, `Interface`, `null` 등
- **`String`은 불변(immutable)** 객체

```java
package a.basic;

public class Variable {
    public static void main(String[] args){
        String str = "Hello";
        String str2 = "world";
        String msg = String.join(" ", str, str2);
        System.out.println(msg);

        // null은 참조형 타입에만 가능
        String str3 = null;
        System.out.println(str3);
    }
}
```

---

## 🔄 **형 변환 (Type Casting)**

### ✅ 자동 타입 변환 (묵시적 변환)

> 작은 타입 → 큰 타입으로 자동 변환됨

```
byte → short → int → long → float → double
       char  →

```

### ⚠️ 강제 타입 변환 (명시적 변환)

> 큰 타입 → 작은 타입으로 변환할 때는 명시적 캐스팅 필요

```java
package a.basic;

public class Variable {
    public static void main(String[] args){
        int iA = 100;
        double dA = iA; // 자동 형변환

        double dB = 3.14;
        int iB = (int) dB; // 강제 형변환
        System.out.println(iB);
    }
}
```

---

## 🆕 **`var` 키워드 (Java 10+)**

> 타입 추론(type inference) 기능 제공
>
> 한 번 추론된 타입은 **변경 불가**

```java
package a.basic;

public class Variable {
    public static void main(String[] args){
        var myData = true;    // boolean myData = true;
        var myData2 = 100;    // int myData2 = 100;
        var myData3 = "hello"; // String myData3 = "hello";
    }
}
```

---

📘 **정리 요약**

| 항목        | 핵심 포인트                             |
| ----------- | --------------------------------------- |
| 실행 단축키 | `Ctrl + Shift + F10`                    |
| 디버깅      | Breakpoint → F8 (다음 단계)             |
| 기본 출력   | `System.out.print`, `println`, `printf` |
| 주요 타입   | 기본형(8개), 참조형(String 등)          |
| 형변환      | 자동/명시적 변환 구분                   |
| var 키워드  | Java 10 이후 타입 추론 지원             |

---

# 💡 **Java 연산자(Operator) 정리**

---

## 🧮 **1. 기본 산술 연산자**

| 연산자 | 의미   | 예시    | 결과 |
| ------ | ------ | ------- | ---- |
| +      | 덧셈   | 10 + 3  | 13   |
| -      | 뺄셈   | 10 - 3  | 7    |
| \*     | 곱셈   | 10 \* 3 | 30   |
| /      | 나눗셈 | 10 / 3  | 3    |
| %      | 나머지 | 10 % 3  | 1    |

> ⚠️ 정수끼리의 나눗셈(/) 은 정수 결과만 반환합니다.
>
> 실수 결과를 얻으려면 **형변환**이 필요합니다 → `(double) x / y`

```java
int x = 10, y = 3;
System.out.println(x / y);        // 3 (정수 나눗셈)
System.out.println((double)x / y); // 3.3333 (실수 나눗셈)
```

---

## 🔼 **2. 증감 연산자**

| 형태 | 설명              | 예시             | 결과                |
| ---- | ----------------- | ---------------- | ------------------- |
| ++a  | 먼저 증가 후 사용 | int a = 10; ++a; | a = 11              |
| a++  | 사용 후 증가      | int a = 10; a++; | a = 11 (출력 시 10) |
| --a  | 먼저 감소 후 사용 | int a = 10; --a; | a = 9               |
| a--  | 사용 후 감소      | int a = 10; a--; | a = 9 (출력 시 10)  |

```java
int x = 10;
System.out.println(x++); // 10
System.out.println(++x); // 12
```

---

## 🔁 **3. 복합 대입 연산자**

| 연산자 | 의미        | 예시     | 결과       |
| ------ | ----------- | -------- | ---------- |
| +=     | 더해서 대입 | x += 5;  | x = x + 5  |
| -=     | 빼서 대입   | x -= 3;  | x = x - 3  |
| \*=    | 곱해서 대입 | x \*= 2; | x = x \* 2 |
| /=     | 나눠서 대입 | x /= 4;  | x = x / 4  |
| %=     | 나머지 대입 | x %= 2;  | x = x % 2  |

```java
int x = 10;
x += 5; // x = 15
```

---

## ⚖️ **4. 비교 연산자**

비교 연산 결과는 항상 `boolean` (`true` / `false`) 입니다.

| 연산자 | 의미        | 예시   | 결과  |
| ------ | ----------- | ------ | ----- |
| ==     | 같다        | 5 == 5 | true  |
| !=     | 다르다      | 5 != 3 | true  |
| >      | 크다        | 5 > 3  | true  |
| <      | 작다        | 5 < 3  | false |
| >=     | 크거나 같다 | 5 >= 5 | true  |
| <=     | 작거나 같다 | 3 <= 5 | true  |

> ⚠️ 문자열 비교는 ==이 아닌 .equals() 사용!

```java
String strA = "hello";
String strB = new String("hello");

System.out.println(strA == strB);         // false (주소 비교)
System.out.println(strA.equals(strB));    // true (값 비교)
```

---

## 🔐 **5. 논리 연산자**

| 연산자       | 의미 | 설명                      |
| ------------ | ---- | ------------------------- |
| &&           | AND  | 모두 `true`일 때만 `true` |
| &#124;&#124; | OR   | 하나라도 `true`면 `true`  |
| !            | NOT  | 참 ↔ 거짓 반전            |

```java
boolean a = true, b = false;
System.out.println(!a);        // false
System.out.println(a && b);    // false
System.out.println(a || b);    // true
```

🧠 **단락 평가 (Short-Circuit Evaluation)**

- `&&` → 앞이 `false`면 뒤는 평가하지 않음
- `||` → 앞이 `true`면 뒤는 평가하지 않음

---

## ❓ **6. 삼항 연산자**

형식:

```java
조건식 ? 참일_때_값 : 거짓일_때_값;
```

예시:

```java
int age = 30;
String result = (age >= 20) ? "성인" : "청소년";
System.out.println(result); // 성인
```

---

## ⚙️ **7. 비트 연산자**

비트 단위(0과 1)로 연산합니다.

| 연산자 | 의미                    | 예시       | 결과    |
| ------ | ----------------------- | ---------- | ------- |
| &      | AND                     | 5 &#124; 3 | 1       |
| &#124; | OR                      | 5 &#124; 3 | 7       |
| ^      | XOR                     | 5 ^ 3      | 6       |
| ~      | NOT                     | ~5         | -6      |
| <<     | 왼쪽 시프트             | 5 << 1     | 10      |
| >>     | 오른쪽 시프트           | 5 >> 1     | 2       |
| >>>    | 부호 없는 오른쪽 시프트 | -5 >>> 1   | 큰 양수 |

```java
int a = 14; // 1110
int b = 6;  // 0110
System.out.println(a & b); // 6

// ex. num = 10; (1010)
// num << 2 : 왼쪽으로 2칸 이동 => 40 (101000)
// num >> 1 : 오른쪽으로 1칸 이동 => 5(101)
int num = 10;
System.out.println("num << 2 : " + (num << 2)); // 40
System.out.println("num >> 1 : " + (num >> 1)); // 5

int intC = 123456;
System.out.println(intC << 1); // 246912
System.out.println(intC >> 1); // 61728
```

---

## ✅ **정리 요약**

| 구분     | 대표 연산자                  | 반환형      | 특징                     |
| -------- | ---------------------------- | ----------- | ------------------------ |
| 산술     | +, -, \*, /, %               | 숫자형      | 기본 연산                |
| 증감     | ++, --                       | 숫자형      | 전위/후위 구분           |
| 복합대입 | +=, -= 등                    | 숫자형      | 자기 자신에 연산 후 대입 |
| 비교     | ==, !=, >, < 등              | boolean     | 항상 true/false          |
| 논리     | &&, &#124;&#124;, !          | boolean     | 조건 조합                |
| 삼항     | ? :                          | 다양한 타입 | 조건에 따라 값 선택      |
| 비트     | &, &#124;, ^, ~, <<, >>, >>> | 정수형      | 2진수 단위 연산          |

---

# 💡 **조건문 (Conditional Statements)**

## ✅ **1️⃣ if 문**

- 조건식이 **`boolean` 타입**이어야 함
- 조건이 `true`일 때만 실행

```java
package a.basic;

public class IfStatement {
    public static void main(String[] args) {
        int age = 20;

        if (age >= 20) {
            System.out.println("성인입니다.");
        }
    }
}
```

📌 **설명**

- `if` 뒤의 괄호 안에는 반드시 **논리식(true/false)**
- 한 줄만 실행할 때도 `{}` 중괄호 사용 권장 (가독성, 유지보수용)

---

## ✅ **2️⃣ if-else 문**

- 여러 조건을 순차적으로 검사할 때 사용
- 위에서부터 차례대로 검사 → **처음으로 true인 블록만 실행**

```java
package a.basic;

public class IfStatement {
    public static void main(String[] args) {
        int score = 80;

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("재수강");
        }
    }
}
```

📌 **설명**

- `if` → `else if` → `else` 순서
- 모든 조건이 `false`이면 `else` 블록 실행
- 조건이 복잡할 경우, 중첩 `if`문보다 **논리 연산자( `&&`, `||` )** 활용이 가독성 좋음

---

## ✅ **3️⃣ switch 문**

### 🧩 (1) 기본 switch (Java 13 이전)

```java
int num = 2;

switch (num) {
    case 1:
        System.out.println("One");
        break;
    case 2:
        System.out.println("Two");
        break;
    case 3:
        System.out.println("Three");
        break;
    default:
        System.out.println("기타");
}
```

📌 **설명**

- 각 `case` 실행 후 `break`문을 써야 **다음 case로 넘어가지 않음**
- `break`를 빼먹으면 **fall-through** 발생 (다음 case 연속 실행됨)

---

### 🧩 (2) 향상된 switch (Java 14 이상)

- `break` 생략 가능
- `→`(화살표) 사용
- 여러 case를 쉼표로 나열 가능
- 값을 반환하는 **표현식**으로도 사용 가능

```java
package a.basic;

public class IfStatement {
    public static void main(String[] args) {
        int month = 4;

        String season = switch (month) {
            case 3, 4, 5 -> "봄";
            case 6, 7, 8 -> "여름";
            case 9, 10, 11 -> "가을";
            case 12, 1, 2 -> "겨울";
            default -> "잘못된 월";
        };

        System.out.println(season); // 출력: 봄
    }
}
```

📌 **특징**

| 항목        | 설명                                    |
| ----------- | --------------------------------------- |
| `->`        | `case` 실행 후 자동 종료 (break 불필요) |
| 여러 case   | `case 3, 4, 5`처럼 쉼표로 묶기 가능     |
| 표현식 사용 | `switch` 자체가 값을 반환할 수 있음     |
| `default`   | 모든 case에 해당하지 않을 때 실행       |

---

## 🧠 **정리 요약**

| 구분                  | 문법                       | 특징                           |
| --------------------- | -------------------------- | ------------------------------ |
| `if`                  | `if (조건) { ... }`        | 단일 조건 판단                 |
| `if-else`             | `if ... else if ... else`  | 여러 조건 순차 판단            |
| `switch`              | `switch (값) { case ... }` | 값 기반 분기 (정수, 문자열 등) |
| `switch →` (Java 14+) | `case 1, 2 -> ...`         | 간결한 구문, break 불필요      |

---

- intellij에서 github 커밋
  ![alt text](img/image-5.png)

- 생성하고 커밋
  ![alt text](img/image-6.png)
- 원격 저장소 경로 설정
  ![alt text](img/image-7.png)
  ![alt text](img/image-8.png)

# 💡 **조건문 실습 정리 (Practice.java)**

https://github.com/SESAC-SD3/JAVA

`git clone <저장소 주소>`

```java
package a.basic;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {

        // ✅ 문제 1: 홀짝 판별
        int num = 17;
        String isEven = num % 2 == 0 ? "짝수" : "홀수";
        System.out.printf("%d는 %s입니다.%n", num, isEven);

        // ✅ 문제 2: 학점 계산
        int score = 85;
        String grade = score >= 90 ? "A" :
                       score >= 80 ? "B" :
                       score >= 70 ? "C" :
                       score >= 60 ? "D" : "F";
        System.out.println("학점: " + grade);

        // ✅ 문제 3: 윤년 판별
        int year = 2024;
        System.out.println(year + "년은 윤년" +
                (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                        ? "입니다." : "이 아닙니다."));

        // ✅ 문제 4: 삼각형 유효성 검사
        int a = 3, b = 4, c = 5;
        boolean flag = (a>0 && b>0 && c>0) && ((c < a+b) && (b < a+c) && (c < a+b));
        System.out.println("삼각형을 만들 수 " + (flag ? "있습니다." : "없습니다."));

        // ✅ 문제 5: 계절 판별 (향상된 switch문)
        int month = 7;
        String season = switch (month) {
            case 3, 4, 5 -> "봄";
            case 6, 7, 8 -> "여름";
            case 9, 10, 11 -> "가을";
            case 12, 1, 2 -> "겨울";
            default -> "";
        };
        System.out.printf(season.isEmpty()
                ? "존재하지 않는 월입니다.%n"
                : "%d월은 %s입니다.%n", month, season);

        // ✅ 문제 6: 요일 판별
        int day = 6;
        String dayName = switch (day) {
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };
        System.out.printf(dayName.isEmpty()
                ? "존재하지 않는 요일입니다.%n"
                : "%d: %s요일은 %s입니다.%n",
                day, dayName, (day == 6 || day == 7 ? "주말" : "평일"));

        // ✅ 문제 7: BMI 계산 및 판정
        double height = 175.0; // cm
        double weight = 70.0;  // kg
        double bmi = weight / (height / 100 * height / 100);
        String result = bmi >= 25 ? "비만" :
                        bmi >= 23 ? "과체중" :
                        bmi >= 18.5 ? "정상 체중" : "저체중";
        System.out.printf("BMI: %.2f%n%s입니다.%n", bmi, result);

        // ✅ 문제 8: 최댓값 구하기
        a = 10; b = 25; c = 17;
        if (a > b && a > c) {
            System.out.println("최댓값: " + a);
        } else if (b > a && b > c) {
            System.out.println("최댓값: " + b);
        } else {
            System.out.println("최댓값: " + c);
        }

        // ✅ 문제 9: 시험 합격 여부
        int math = 70, english = 80, science = 45;
        if (math >= 40 && english >= 40 && science >= 40) {
            int avg = (math + english + science) / 3;
            System.out.println(avg >= 60 ? "합격" : "불합격");
        } else {
            System.out.println("불합격(과목 낙제)");
        }

        // ✅ 문제 10: 할인율 계산
        int price = 120000;
        boolean isMember = true;
        int discount = price >= 100000 ? 10 :
                       price >= 50000 ? 5 : 0;
        double total = isMember
                ? price * (100 - discount) / 100 * 0.95
                : price * (100 - discount) / 100.0;

        System.out.println("원가: " + price + "원");
        System.out.println("할인율: " + discount + "%");
        System.out.println("최종 금액: " + total + "원");
    }
}
```

---

## 📘 **문제 요약**

| 번호 | 주제          | 주요 개념                 |
| ---- | ------------- | ------------------------- |
| 1    | 홀짝 판별     | 삼항 연산자               |
| 2    | 학점 계산     | 중첩 삼항 연산자          |
| 3    | 윤년 판별     | 논리 연산, 조건식         |
| 4    | 삼각형 유효성 | 논리 AND 연산             |
| 5    | 계절 판별     | `switch` (Java 14+ 문법)  |
| 6    | 요일 판별     | `switch` + 주말/평일 판단 |
| 7    | BMI 계산      | 수식, 조건 분기           |
| 8    | 최댓값        | `if-else if` 조건문       |
| 9    | 시험 합격     | 다중 조건 검사            |
| 10   | 할인율 계산   | 중첩 삼항 + boolean 조건  |
