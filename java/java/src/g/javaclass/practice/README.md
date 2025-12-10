## 🧵 **String 클래스**

> Java의 문자열은 불변(immutable) 객체이다.
>
>
> 한 번 생성된 문자열은 수정할 수 없으며,
>
> 문자열을 변경하는 모든 연산은 **새로운 `String` 객체를 생성**한다.
>

---

### ✅ **특징**

- **불변(Immutable)**: 한 번 생성된 문자열은 변경 불가
- 문자열 수정 시 **새로운 객체가 생성**됨
- `"문자열 리터럴"`은 **String Pool**에 저장되어 재사용 가능
- 문자열 비교 시 `==`은 **주소 비교**, `equals()`는 **값 비교**

---

### 🧱 **문자열 생성 방법**

| 방식 | 예시 | 특징 |
| --- | --- | --- |
| **리터럴 방식 (권장)** | `String str1 = "Hello";` | String Pool에 저장되어 재사용됨 |
| **new 연산자 방식** | `String str2 = new String("Hello");` | 새로운 객체가 생성됨 (Pool 사용 X) |

```java
String str1 = "Hello";
String str2 = "Hello";
System.out.println(str1 == str2); // true (같은 객체 참조)

String str3 = new String("Hello");
String str4 = new String("Hello");
System.out.println(str3 == str4); // false (서로 다른 객체)
```

---

### ⚖️ **문자열 비교**

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| `equals()` | 대소문자 구분 값 비교 | `"Hello".equals("hello") → false` |
| `equalsIgnoreCase()` | 대소문자 무시 비교 | `"Hello".equalsIgnoreCase("hello") → true` |

---

### 🧩 **주요 메서드 정리**

| 메서드 | 설명 | 예시 / 결과 |
| --- | --- | --- |
| `length()` | 문자열 길이 | `"Hello".length()` → `5` |
| `charAt(int index)` | 특정 인덱스의 문자 | `"Hello".charAt(1)` → `'e'` |
| `indexOf(String s)` | 지정한 문자/문자열의 첫 위치 | `"Hello".indexOf("l")` → `2` |
| `lastIndexOf(String s)` | 마지막 위치 반환 | `"Hello".lastIndexOf("l")` → `3` |
| `substring(int start, int end)` | 부분 문자열 추출 | `"Hello".substring(2, 4)` → `"ll"` |
| `contains(String s)` | 문자열 포함 여부 | `"Hello".contains("E")` → `false` |
| `startsWith(String s)` | 특정 문자로 시작 여부 | `"Hello".startsWith("H")` → `true` |
| `endsWith(String s)` | 특정 문자로 끝나는지 | `"Hello".endsWith("l")` → `false` |
| `isEmpty()` | 비어 있는지 확인 | `"".isEmpty()` → `true` |
| `isBlank()` *(Java 11+)* | 공백 문자열인지 확인 | `"   ".isBlank()` → `true` |
| `trim()` | 앞뒤 공백 제거 | `" Hello ".trim()` → `"Hello"` |
| `strip()` *(Java 11+)* | 유니코드 공백 포함 제거 | `" Hello ".strip()` → `"Hello"` |
| `replace(a, b)` | 문자열 치환 | `"Hello".replace("H", "J")` → `"Jello"` |
| `split(String regex)` | 구분자로 분리하여 배열 반환 | `"a,b,c".split(",")` → `["a","b","c"]` |
| `String.join()` | 문자열 배열 결합 | `String.join("-", "a","b","c")` → `"a-b-c"` |

---

### 💡 **예제 코드 요약**

```java
import java.util.Arrays;

public class StringMain {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        System.out.println(str1 == str2); // true (같은 리터럴)

        String str3 = "hello";
        System.out.println(str1.equals(str3));           // false
        System.out.println(str1.equalsIgnoreCase(str3)); // true

        System.out.println(str1.length());        // 5
        System.out.println(str1.charAt(2));       // l
        System.out.println(str1.indexOf("l"));    // 2
        System.out.println(str1.lastIndexOf("l"));// 3
        System.out.println(str1.substring(2, 4)); // ll

        String str4 = " Hello World ";
        System.out.println(str4.trim());          // "Hello World"
        System.out.println(str4.strip());         // "Hello World" (Java 11+)
        System.out.println(str4.replace("Hello", "Hi")); // " Hi World "

        String csv = "apple, banana, orange";
        System.out.println(Arrays.toString(csv.split(","))); // [apple,  banana,  orange]
        System.out.println(String.join(" ", csv.replace(",", ""))); // "apple  banana  orange"

        // StringBuilder로 문자열 결합
        StringBuilder sb = new StringBuilder();
        Arrays.stream(csv.split(","))
              .forEach(s -> sb.append(s).append(" "));
        System.out.println(sb); // "apple  banana  orange "
    }
}
```

---

### 🧱 **String vs StringBuilder vs StringBuffer**

| 구분 | **String** | **StringBuilder** | **StringBuffer** |
| --- | --- | --- | --- |
| **가변성** | ❌ 불변 | ✅ 가변 | ✅ 가변 |
| **속도** | 느림 | 빠름 | 느림 (동기화) |
| **Thread-Safe** | X | X | ✅ O |
| **사용 시기** | 일반 문자열 | 문자열 잦은 수정 시 | 멀티스레드 환경 |

---

### 🧠 **요약 정리**

| 항목 | 내용 |
| --- | --- |
| **특징** | 불변 객체 (immutable) |
| **비교 방법** | `equals()` / `equalsIgnoreCase()` |
| **수정 시 동작** | 새로운 `String` 객체 생성 |
| **효율적 수정** | `StringBuilder` / `StringBuffer` 사용 |
| **주요 메서드** | `substring`, `replace`, `split`, `trim`, `join` 등 |

---

## 🎯 **Wrapper 클래스 (포장 클래스)**

> 기본형(primitive type)을 객체(Object)로 감싸는 클래스
>
>
> Java는 객체지향 언어이지만, **성능과 메모리 효율**을 위해 기본형을 제공하며
>
> 필요 시 **객체 형태로 변환(박싱, 언박싱)** 가능하다.
>

---

### 🧱 **필요한 이유**

1. **컬렉션 사용 가능** (`List`, `Set`, `Map` 등은 객체만 저장 가능)
2. **null 표현 가능** (기본형은 불가)
3. **유틸리티 메서드 제공** (`parseInt`, `compare`, `MAX_VALUE` 등)

---

### 📘 **기본형 ↔ Wrapper 클래스 대응표**

| 기본형 | Wrapper 클래스 |
| --- | --- |
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| char | Character |
| boolean | Boolean |

---

### ⚙️ **Wrapper 주요 개념**

| 개념 | 설명 | 예시 |
| --- | --- | --- |
| **박싱(Boxing)** | 기본형 → Wrapper 객체 | `Integer num = Integer.valueOf(10);` |
| **언박싱(Unboxing)** | Wrapper 객체 → 기본형 | `int n = num.intValue();` |
| **오토박싱 / 오토언박싱** | 컴파일러가 자동 변환 | `Integer x = 10; int y = x;` |
| **캐싱 범위** | `-128 ~ 127` 범위는 동일 객체 재사용 | `Integer a=127, b=127 → a==b(true)` `Integer c=128, d=128 → c==d(false)` |

---

### 💡 **Wrapper 주요 메서드**

| 메서드 | 설명 | 예시 / 결과 |
| --- | --- | --- |
| `parseInt(String s)` | 문자열 → 정수 변환 | `Integer.parseInt("123") → 123` |
| `valueOf()` | 박싱 메서드 | `Integer.valueOf(10)` |
| `intValue()` | 언박싱 메서드 | `Integer.valueOf(10).intValue()` |
| `MAX_VALUE` / `MIN_VALUE` | 최대/최소값 상수 | `Integer.MAX_VALUE → 2147483647` |
| `compareTo()` | 크기 비교 | `10.compareTo(20) → -1` |
| `compare(x, y)` | 정적 비교 메서드 | `Integer.compare(100, 200) → -1` |

---

### 🧩 **Wrapper 예제 요약**

```java
int primitive = 10;
Integer wrapper = Integer.valueOf(primitive);  // 박싱
int primitive2 = wrapper.intValue();           // 언박싱

Integer a = 127, b = 127;
System.out.println(a == b); // true (캐싱)

Integer c = 128, d = 128;
System.out.println(c == d); // false (다른 객체)

int parsed = Integer.parseInt("123");
System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.MIN_VALUE);
System.out.println(Integer.compare(100, 200)); // -1
```

---

## 🧮 **Math 클래스**

> 수학 관련 유틸리티 메서드를 제공하는 java.lang.Math 클래스
>
>
> **모든 메서드가 static**으로 선언되어 있어 객체 생성 없이 사용 가능
>

---

### ⚙️ **Math 주요 메서드**

| 메서드 | 설명 | 예시 / 결과 |
| --- | --- | --- |
| `abs(x)` | 절대값 | `Math.abs(-10)` → `10` |
| `max(a, b)` / `min(a, b)` | 최대 / 최소값 | `Math.max(10,20)` → `20` |
| `ceil(x)` | 올림 | `Math.ceil(3.7)` → `4.0` |
| `floor(x)` | 내림 | `Math.floor(3.7)` → `3.0` |
| `round(x)` | 반올림 | `Math.round(3.7)` → `4` |
| `pow(a, b)` | 제곱 | `Math.pow(2,3)` → `8.0` |
| `sqrt(x)` | 제곱근 | `Math.sqrt(9)` → `3.0` |
| `PI`, `E` | 수학 상수 | `Math.PI` → `3.1415…`, `Math.E` → `2.7182…` |

---

## 🎲 **Random 클래스**

> 난수(무작위 수) 생성을 위한 클래스
>
>
> `java.util.Random`을 사용하거나 `Math.random()`도 가능
>

---

### ⚙️ **Random 주요 메서드**

| 메서드 | 설명 | 결과 예시 |
| --- | --- | --- |
| `nextInt(n)` | 0 ~ (n-1) 난수 | `random.nextInt(100)` → `0~99` |
| `nextInt(min, max)` *(Java 17+)* | 지정 범위 난수 | `random.nextInt(10,20)` → `10~19` |
| `nextDouble()` | 0.0 ≤ x < 1.0 | 예: `0.345` |
| `nextBoolean()` | true/false | 랜덤 불리언값 |

---

### 💡 **Random 활용 예시**

```java
Random random = new Random();

// 0~99
System.out.println(random.nextInt(100));

// 10~19
int min = 10, max = 20;
System.out.println(random.nextInt(max - min) + min);

// Java 17+
System.out.println(random.nextInt(10, 20));

// 배열에서 무작위 요소 선택
String[] colors = {"빨강", "파랑", "노랑", "초록"};
String selected = colors[random.nextInt(colors.length)];
System.out.println("선택된 색: " + selected);

// 배열 섞기
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
Collections.shuffle(list);
System.out.println(list);

// 확률 이벤트 (30% 성공)
boolean success = random.nextDouble() < 0.3;
System.out.println(success ? "성공!" : "실패!");

// 주사위 (1~6)
int dice = random.nextInt(6) + 1;
System.out.println("주사위: " + dice);

// 로또 (1~45 중 6개 중복 없이)
Set<Integer> lotto = new HashSet<>();
while (lotto.size() < 6)
    lotto.add(random.nextInt(45) + 1);

List<Integer> sorted = new ArrayList<>(lotto);
Collections.sort(sorted);
System.out.println("로또 번호: " + sorted);
```

---

## 🧠 **핵심 요약 표**

| 구분 | 주요 기능 | 특징 |
| --- | --- | --- |
| **Wrapper** | 기본형 ↔ 객체 변환 | 컬렉션/유틸리티/`null` 표현 가능 |
| **Math** | 수학 연산 (abs, pow, sqrt 등) | `static` 메서드, 객체 생성 불필요 |
| **Random** | 난수 생성 | 범위 지정, 중복 제거, 확률 이벤트 등 활용 |
---
