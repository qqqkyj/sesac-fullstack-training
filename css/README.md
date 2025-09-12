# 📘 CSS 기초 정리

## 💡 CSS(Cascading Style Sheets)

- **웹 페이지의 스타일**을 정의
- 워드, 파워포인트, 한글의 서식과 비슷한 개념
- **선택자, 속성, 값**으로 구성

---

## 📘 오늘 공부한 주요 내용

아래 항목들은 오늘 학습하고 실습한 CSS 핵심 개념입니다:

1. **CSS 기본 구조**

   - 선택자(selector), 속성(property), 값(value)의 구성
   - 외부 스타일 시트(External Stylesheet)의 사용법
   - 인라인, 내부(style 태그), 외부(css 파일) 스타일 적용 방식

2. **선택자(Selectors)**

   - 기본 선택자: 태그, 클래스(`.`), 아이디(`#`)
   - 속성 선택자 (`[attr]`, `[attr="value"]`)
   - 자식 선택자 (`부모 > 자식`), 자손 선택자 (`부모 자손`)
   - 형제 선택자: 인접(`A + B`), 일반(`A ~ B`)
   - 그룹 선택자, 혼합 선택자
   - 선택자 우선순위(rule specificity) — `!important`, 인라인, id, class/속성, 태그 순

3. **단위 (Units)**

   - 절대 단위: `px`
   - 상대 단위: `%`, `em`, `rem`, `vw`, `vh`

4. **색상 표현 방식**

   - 16진수(hex)
   - RGB / RGBA
   - OKLCH (혹은 다른 새 표현 방식)

5. **상속(Inheritance)**

   - 상속되는 속성: `color`, `font-family`, `font-size`, `line-height`, `text-align`, `visibility`
   - 상속되지 않는 속성: `margin`, `padding`, `border`, `width`, `height`, `background`

6. **박스 모델(Box Model)**

   - `content`, `padding`, `border`, `margin`의 구조 이해
   - Reset CSS의 필요성 및 사용

7. **디스플레이(Display) 속성**

   - `inline`, `block`, `inline-block`, `none` 등의 차이

8. **포지션(Position) 속성**
   - `static`
   - `relative`
   - `absolute`
   - `fixed`
   - `sticky`

---

## 🛠 파일 설명

- `css-basic/index.html` & `css-basic/styles.css`  
  CSS 기본 구조와 외부 스타일 시트 연결 예제

- `css-selector/index.html` & `css-selector/styles.css`  
  다양한 선택자 실습 예제 파일

- (추가실습 파일들)  
  display, position 등 각 개념별 실습 파일 존재 가능

---

## 📚 참고 자료

- [W3Schools CSS](https://www.w3schools.com/css/)
- [Flukeout / CSS Diner 선택자 연습](https://flukeout.github.io/)
- [Josh Comeau Reset CSS](https://www.joshwcomeau.com/css/custom-css-reset/)

---
