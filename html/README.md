# HTML 기초 정리

HTML(HyperText Markup Language)은 웹 페이지를 구성하는 **기본 마크업 언어**입니다.
웹 문서를 작성할 때 HTML 요소(Element)를 사용하여 구조를 만들고, 속성(Attribute)으로 추가 정보를 부여하며, 콘텐츠(Content)를 표시합니다.

---

## 1. HTML 요소(Element)를 구성하는 3가지

1. **태그(Tag)**

   - 요소의 기능을 나타냄
   - 시작 태그 `<태그명>`과 종료 태그 `</태그명>`으로 구성

2. **속성(Attribute)**

   - 요소에 추가적인 정보를 제공
   - 시작 태그 내부에 작성
   - 예: `<a href="https://example.com">링크</a>`

3. **내용(Content)**

   - 화면에 표시될 텍스트 또는 다른 요소

---

## 2. 링크를 생성하는 태그와 필수 속성

- **태그:** `<a>`
- **필수 속성:** `href` → 링크 대상(URL)을 지정
- 예시:

```html
<a href="https://www.example.com">Example 사이트</a>
```

---

## 3. id 속성

- **목적:** 요소에 **고유한 식별자**를 부여
- **규칙:** 문서 내에서 중복 불가
- **작성 방법:** `id="고유값"`
- **예시:**

```html
<div id="main-header">메인 헤더</div>
```

- **활용 예:** CSS 스타일링, JavaScript에서 특정 요소 선택

---

## 4. class 속성

- **목적:** 여러 요소를 **그룹화**
- **특징:**

  - 한 요소에 여러 클래스 지정 가능
  - 여러 요소가 동일 클래스 공유 가능

- **작성 방법:** 공백으로 구분하여 여러 클래스 지정 가능

  - 예: `class="class-1 class-2"`

- **예시:**

```html
<p class="text-bold text-red">중요한 문단</p>
```

- **활용 예:** CSS 스타일링, JavaScript에서 그룹 선택

---

## 5. form 태그와 input 태그

- **목적:** 사용자와 웹 페이지 간 상호작용
- **태그 설명:**

  - `<form>` : 폼 컨테이너, 클라이언트 입력값을 서버로 전송
  - `<input>` : 사용자 입력 필드

- **예시:**

```html
<form action="/submit" method="post">
  <input type="text" name="username" placeholder="이름" />
  <input type="submit" value="제출" />
</form>
```

---

## 6. input 태그의 주요 속성

- **type** : 입력 필드의 용도를 결정
- **주요 타입:**

  - `text` : 일반 텍스트 입력
  - `number` : 숫자 입력
  - `date` : 날짜 입력
  - `password` : 비밀번호 입력
  - `submit` : 폼 제출 버튼
  - `checkbox` : 체크박스
  - `radio` : 라디오 버튼
  - `email` : 이메일 입력

- **예시:**

```html
<input type="email" name="user-email" placeholder="이메일 입력" />
```

---

## 7. 추가 팁

- HTML5에서 새롭게 등장한 시맨틱 태그 활용 추천:

  - `<header>`, `<footer>`, `<main>`, `<section>`, `<article>` 등

- 시맨틱 태그는 검색엔진 최적화(SEO)와 접근성 향상에 도움

---

> 💡 이 문서는 HTML 기본 개념과 태그, 속성, 입력 필드 등을 정리한 학습용 자료입니다.
