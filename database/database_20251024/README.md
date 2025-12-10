## 1️⃣ **기본 조회 (SELECT, WHERE)**

### ✅ `world` 데이터베이스

```sql
USE world;

-- 특정 국가 조회
SELECT * FROM country WHERE Code = 'AFG';
SELECT * FROM country WHERE Name = 'South Korea';
SELECT * FROM country WHERE Continent = 'Asia';

-- 조건 검색
SELECT * FROM country WHERE LifeExpectancy >= 80;
SELECT * FROM country WHERE GNP < 10000;

-- 논리 연산자 (AND / OR)
SELECT * FROM country WHERE Continent = 'Asia' AND Population >= 100000000;
SELECT * FROM country WHERE Continent = 'Europe' OR Continent = 'North America';

-- 부정 조건 (NOT / !=)
SELECT * FROM country WHERE Continent != 'Asia';
SELECT * FROM country WHERE NOT Continent = 'Asia';

-- BETWEEN / IN
SELECT * FROM country WHERE LifeExpectancy BETWEEN 70 AND 80;
SELECT * FROM country WHERE Continent IN ('Asia', 'Europe');

-- LIKE 패턴 검색
SELECT * FROM country WHERE Name LIKE 'South%';     -- South로 시작
SELECT * FROM country WHERE Name LIKE '%States%';   -- States 포함
SELECT * FROM country WHERE Name LIKE '_____';      -- 5글자 이름
SELECT * FROM country WHERE Name LIKE '___land';    -- 3글자 + land로 끝

-- NULL / NOT NULL
SELECT * FROM country WHERE GNPOld IS NULL;
SELECT * FROM country WHERE IndepYear IS NOT NULL;
```

---

### ✅ `sakila` 데이터베이스

```sql
USE sakila;

-- 전체 영화 조회
SELECT * FROM film;

-- 특정 조건 검색
SELECT title, rental_rate
FROM film
WHERE rental_rate >= 4;  -- 대여료 4달러 이상

SELECT * FROM film WHERE length < 120;  -- 120분 미만
SELECT * FROM film WHERE rating = 'PG-13';

-- 복합 조건
SELECT * FROM film WHERE rating = 'PG' AND rental_rate >= 3;
SELECT * FROM film WHERE rating = 'G' OR rating = 'PG';
SELECT * FROM film WHERE length < 60 OR length >= 180;

-- LIKE 검색
SELECT * FROM film WHERE title LIKE '%LOVE%';  -- LOVE 포함
SELECT * FROM film WHERE title LIKE 'THE%';    -- THE로 시작
SELECT * FROM actor WHERE last_name LIKE '%SON';  -- 성이 SON으로 끝남

-- 다중 조건
SELECT * FROM film
WHERE rating = 'PG-13'
  AND rental_rate BETWEEN 2.99 AND 4.99
  AND length >= 90;
```

---

## 2️⃣ **정렬 (ORDER BY) 및 제한 (LIMIT)**

```sql
USE world;

-- 인구순 내림차순
SELECT * FROM country
ORDER BY Population DESC;

-- 이름 내림차순
SELECT * FROM country
ORDER BY Name DESC;

-- 대륙 내림차순, 인구순 정렬
SELECT * FROM country
ORDER BY Continent DESC, Population DESC;

-- 아시아 국가 중 GNP 오름차순
SELECT * FROM country
WHERE Continent = 'Asia'
ORDER BY GNP;

-- 상위 5개 인구 많은 국가
SELECT * FROM country
ORDER BY Population DESC
LIMIT 5;

-- 6~10번째 국가
SELECT * FROM country
ORDER BY Population DESC
LIMIT 5 OFFSET 5;

-- 또는 (LIMIT 5, 5) 구문
SELECT * FROM country
ORDER BY Population DESC
LIMIT 5, 5;
```

---

## 3️⃣ **집계 함수 (COUNT, SUM, AVG, MAX, MIN)**

### ✅ `world` 데이터베이스

```sql
USE world;

-- 기본 조회
SELECT COUNT(*) AS 총국가수 FROM country;
SELECT COUNT(LifeExpectancy) FROM country;
SELECT COUNT(DISTINCT Region) FROM country;

-- 합계(SUM)
SELECT SUM(Population) FROM country;
SELECT SUM(Population) FROM country WHERE Continent = 'Asia';
SELECT SUM(Population) FROM country WHERE Population >= 100000000;
SELECT ROUND(SUM(SurfaceArea) / 10000, 2) AS 면적합_만단위 FROM country;

-- 평균(AVG)
SELECT AVG(Population) FROM country;
SELECT AVG(Population) FROM country WHERE Continent = 'Asia';

-- 최댓값/최솟값과 해당 행
SELECT * FROM country WHERE Population = (SELECT MAX(Population) FROM country);
SELECT MAX(Population) FROM country;

-- 종합 통계
SELECT
    COUNT(*) AS 국가수,
    SUM(Population) AS 총인구,
    AVG(Population) AS 평균인구,
    MAX(Population) AS 최대인구,
    MIN(Population) AS 최소인구
FROM country;

-- NULL 처리 예시 (COALESCE)
SELECT AVG(LifeExpectancy) AS 원래평균 FROM country;
SELECT AVG(COALESCE(LifeExpectancy, 50)) AS 결측50치환평균 FROM country;
```

---

### ✅ `sakila` 데이터베이스

```sql
USE sakila;

-- 기본 통계
SELECT COUNT(*) AS 전체영화수 FROM film;
SELECT COUNT(*) FROM film WHERE rating = 'PG';
SELECT COUNT(DISTINCT rating) AS 등급종류수 FROM film;

-- 대여료 합계/평균
SELECT SUM(rental_rate) AS 총대여료 FROM film;
SELECT ROUND(AVG(rental_rate), 2) AS 평균대여료 FROM film;
SELECT AVG(rental_rate) AS R등급평균대여료 FROM film WHERE rating = 'R';

-- 최대/최소 값과 해당 영화
SELECT title FROM film WHERE rental_rate = (SELECT MAX(rental_rate) FROM film);
SELECT title FROM film WHERE length = (SELECT MAX(length) FROM film);
SELECT title FROM film WHERE length = (SELECT MIN(length) FROM film);

-- 종합 통계
SELECT
    COUNT(*) AS 영화수,
    SUM(rental_rate) AS 총대여료,
    ROUND(AVG(rental_rate), 2) AS 평균대여료,
    MAX(rental_rate) AS 최고대여료,
    MIN(rental_rate) AS 최저대여료,
    ROUND(AVG(length), 2) AS 평균상영시간
FROM film;
```

---

# 📊 **핵심 정리표**

| 구분                    | 함수          | 설명                                 |
| ----------------------- | ------------- | ------------------------------------ |
| **COUNT()**             | 행 수 계산    | `COUNT(*)`, `COUNT(DISTINCT column)` |
| **SUM()**               | 합계 계산     | 숫자형 컬럼의 총합                   |
| **AVG()**               | 평균 계산     | `ROUND(AVG(col), 2)`                 |
| **MAX() / MIN()**       | 최대 / 최소값 |                                      |
| **COALESCE()**          | NULL 대체     | `COALESCE(col, 기본값)`              |
| **ORDER BY**            | 정렬          | `ASC`(오름차순), `DESC`(내림차순)    |
| **LIMIT / OFFSET**      | 조회 제한     | `LIMIT n`, `LIMIT n OFFSET m`        |
| **BETWEEN / IN / LIKE** | 조건 검색     | 범위, 집합, 패턴 검색                |

## 🧩 1️⃣ 기본 조회 (SELECT / WHERE)

```sql
SELECT * FROM country WHERE Continent = 'Asia';
SELECT * FROM film WHERE rating = 'PG-13';
```

> 👉 조건 검색의 기본, =, !=, AND, OR, BETWEEN, IN, LIKE, IS NULL, IS NOT NULL 모두 포함되어 있습니다.

---

## 🧩 2️⃣ 정렬과 제한 (ORDER BY / LIMIT)

```sql
SELECT * FROM country ORDER BY Population DESC LIMIT 5;
SELECT * FROM country ORDER BY Population DESC LIMIT 5 OFFSET 10;
```

> 👉 정렬(ORDER BY)과 페이징(LIMIT, OFFSET) 완벽히 사용 중입니다.
>
> MySQL의 “LIMIT 5, 5” 구문도 익히셨네요 👏

---

## 🧩 3️⃣ 집계 함수 (COUNT, SUM, AVG, MAX, MIN)

```sql
SELECT COUNT(*) AS 총국가수 FROM country;
SELECT SUM(Population) FROM country WHERE Continent = 'Asia';
SELECT AVG(COALESCE(LifeExpectancy, 50)) FROM country;
```

> 👉 COALESCE를 사용해 NULL 값 처리까지 포함된 좋은 예제입니다.

---

## 🧩 4️⃣ 그룹화 (GROUP BY / HAVING)

```sql
SELECT Continent, COUNT(*) FROM country GROUP BY Continent;

SELECT Continent, AVG(Population)
FROM country
GROUP BY Continent
HAVING AVG(Population) > 20000000;
```

> 👉 HAVING절 사용도 올바르게 하고 있습니다.
>
> 그룹별 조건은 `WHERE` 대신 `HAVING`을 써야 한다는 점을 잘 적용하셨네요.

---

## 🧩 5️⃣ 조건부 논리 (CASE WHEN)

```sql
SELECT
	Name,
    CASE
		WHEN Population >= 100000000 THEN '큰국가'
        WHEN Population >= 50000000 THEN '중간국가'
        ELSE '작은국가'
    END AS 규모
FROM country;

```

> 👉 CASE문으로 분류(labeling)과 조건별 계산을 모두 구현하고 있습니다.
>
> 특히 아래처럼 “Continent별 기준이 다른 조건”도 아주 잘 쓰셨습니다:

```sql
WHERE Population >=
	CASE Continent
		WHEN 'Asia' THEN 50000000
        WHEN 'Europe' THEN 30000000
        ELSE 10000000
    END;
```

---

## 🧩 6️⃣ 조건 기반 통계 집계

```sql
SELECT
	Continent, COUNT(*),
    SUM(CASE WHEN Population > 50000000 THEN 1 ELSE 0 END) AS 대국가수
FROM country
GROUP BY Continent;
```

> 👉 SUM(CASE WHEN ... THEN 1 ELSE 0 END) 패턴은 그룹 내 조건부 카운팅의 정석입니다.
>
> 매우 잘 사용하셨습니다 👏👏

---

## 🧩 7️⃣ 영화(`sakila`) 예제

`film`과 `actor` 테이블을 활용해서 `WHERE`, `GROUP BY`, `HAVING`, `ORDER BY`를 모두 실습하셨고

**실무형 질의 (예: 평균 대여료, 등급별 통계)** 까지 잘 구성하셨습니다.

---

## ✅ 총평

- SQL 학습 단계 중 **“SELECT 문 완성 단계”** 에 해당합니다.
- 이제 이 다음 단계로는 아래 주제들을 연습하시면 좋습니다 👇

---

## 🚀 다음 단계 추천

| 주제                    | 설명                              | 예시                                                                                 |
| ----------------------- | --------------------------------- | ------------------------------------------------------------------------------------ |
| **JOIN**                | 두 테이블 결합                    | `SELECT * FROM country c JOIN city ci ON c.Code = ci.CountryCode;`                   |
| **서브쿼리 응용**       | SELECT 안에 SELECT                | `SELECT Name FROM country WHERE Population > (SELECT AVG(Population) FROM country);` |
| **뷰(View)**            | 자주 쓰는 쿼리를 가상 테이블로    | `CREATE VIEW AsianCountries AS SELECT * FROM country WHERE Continent='Asia';`        |
| **인덱스, 정렬 최적화** | ORDER BY, GROUP BY 성능 향상      | `CREATE INDEX idx_country_continent ON country(Continent);`                          |
| **데이터 변경문**       | `INSERT`, `UPDATE`, `DELETE` 실습 | `UPDATE country SET LifeExpectancy = 80 WHERE Name='South Korea';`                   |
