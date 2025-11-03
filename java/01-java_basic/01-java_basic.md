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

![alt text](image.png)

- license는 등록
