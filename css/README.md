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

## 🛠 파일 설명

- `css-basic/index.html` & `css-basic/styles.css`
  CSS 기본 구조와 외부 스타일 시트 연결 예제

- `css-selector/index.html` & `css-selector/styles.css`
  다양한 선택자 실습 예제 파일

- (추가실습 파일들)
  display, position 등 각 개념별 실습 파일 존재 가능

## 📚 참고 자료

- [W3Schools CSS](https://www.w3schools.com/css/)
- [Flukeout / CSS Diner 선택자 연습](https://flukeout.github.io/)
- [Josh Comeau Reset CSS](https://www.joshwcomeau.com/css/custom-css-reset/)

---

## 🧩 Flexbox

- **레이아웃**: 요소들을 유연하게 배치
- **Flex Container** (부모): `display: flex;`
- **Flex Items** (자식): 플렉스 컨테이너 내 배치 대상

### 주요 속성

| 속성              | 설명                                                                    |
| ----------------- | ----------------------------------------------------------------------- |
| `flex-direction`  | row, row-reverse, column, column-reverse                                |
| `justify-content` | flex-start, flex-end, center, space-between, space-around, space-evenly |
| `align-items`     | flex-start, flex-end, center, stretch, baseline                         |
| `align-self`      | 개별 아이템의 교차축 정렬                                               |
| `flex-wrap`       | nowrap, wrap, wrap-reverse                                              |
| `flex-basis`      | 기본 크기                                                               |
| `flex-grow`       | 남는 공간 차지 비율                                                     |
| `flex-shrink`     | 공간 부족 시 축소 비율                                                  |
| `gap`             | 아이템 간 간격                                                          |

- **주축(Main Axis)**: `row` → 가로, `column` → 세로
- **교차축(Cross Axis)**: 주축에 수직

### 예시

```css
.flex-container {
  flex-direction: row; /* 주축: row, 교차축: column */
  justify-content: center; /* 주축 기준 정렬 */
  align-items: center; /* 교차축 기준 정렬 */
  gap: 10px; /* 아이템 간 간격 */
}
```

## 📐 반응형 디자인 (Responsive Design)

- 미디어 쿼리(Media Query)

```css
@media (max-width: 767px) {
  .flex-container {
    flex-direction: column; /* 화면이 좁으면 세로 배치 */
  }
}
```

- 화면 너비/높이에 따라 레이아웃 조정

- 화면 방향 조건

  - landscape : 가로가 세로보다 넓음

  - portrait : 세로가 가로보다 넓음

## 🅰️ Google Fonts

- [Google Font](https://fonts.google.com/?lang=ko_Kore) 사용
- HTML `<head>`에 링크 추가 후 CSS에서 클래스 지정

```html
<link
  href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
  rel="stylesheet"
/>
```

```css
body {
  font-family: "Roboto", sans-serif;
}
```

## 🅱️ Bootstrap

- 컴포넌트 기반 UI 라이브러리 (버튼, 폼 등)
- 그리드 시스템: 12칸 기준 배치
- Breakpoints: `col-`, `col-sm-`, `col-md-`, `col-lg-`, `col-xl-`, `col-xxl-`

```html
<div class="row">
  <div class="col-md-6">왼쪽</div>
  <div class="col-md-6">오른쪽</div>
</div>
```

## 🟩 Tailwind CSS

- 유틸리티 클래스 기반 스타일링
- 반응형 웹 지원
- 설치: CDN 스크립트

```html
<script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
<div class="flex gap-4">
  <div class="w-20 h-12 bg-red-500"></div>
  <div class="w-20 h-12 bg-blue-500"></div>
</div>
```

## 🟦 Google Stitch

- Google의 UI 구성 툴
- 빠른 UI 프로토타이핑 가능
- [Stitch](https://stitch.withgoogle.com/)

## 🛠 파일 설명

- `flexbox-practice/index.html` & `flexbox-practice/styles.css`
- `responsive-design/index.html` & `responsive-design/styles.css`
- `bootstrap-tailwind/index.html` & `bootstrap-tailwind/styles.css`

## 📚 참고 자료

- [Flexbox Froggy](https://flexboxfroggy.com/#ko) - 게임으로 Flexbox 학습
- [CSS-Tricks Flexbox Guide](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) - Flexbox 속성 가이드
- [Google Fonts](https://fonts.google.com/)
- [Bootstrap](https://getbootstrap.com/)
- [Tailwind CSS](https://tailwindcss.com/docs/installation/play-cdn)

---
