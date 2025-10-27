USE world;

SELECT * FROM city WHERE CountryCode = 'KOR';
SELECT * FROM country;

-- INNER JOIN (교집합)
-- Alias
SELECT 
	ci.Name AS 도시명,
    co.Name AS 나라이름,
    co.continent AS 대륙,
    ci.population AS 도시인구,
    co.population AS 국가인구,
    ROUND(ci.population/co.population * 100, 2) AS 도시인구비율
FROM city ci
INNER JOIN country co
ON ci.CountryCode = co.Code
WHERE co.Name = 'South Korea'
ORDER BY 도시인구비율 DESC;

-- 국가별 도시 개수
SELECT
	co.Name,
    COUNT(*)
FROM city ci
INNER JOIN country co
ON ci.CountryCode = co.Code
GROUP BY co.Name
ORDER BY COUNT(*) DESC;

-- 대륙별 도시 통계
SELECT 
	co.continent,
    COUNT(*),
    AVG(ci.Population)
FROM city ci
INNER JOIN country co
ON ci.CountryCode = co.Code
GROUP BY co.continent;

SELECT 
	COUNT(DISTINCT co.Code) AS 전체국가수_JOIN,
    (SELECT COUNT(*) FROM country) AS 전체국가수_COUNTRY
FROM city ci
INNER JOIN country co
ON ci.CountryCode = co.Code;

-- LEFT JOIN
-- 왼쪽 테이블(JOIN 절)의 모든 행 포함
SELECT
	*
FROM country co
LEFT JOIN city ci
ON co.Code = ci.CountryCode
ORDER BY co.Population;

-- RIGHT JOIN
-- 오른쪽 테이블(JOIN 절)의 모든 행 포함
SELECT
	*
FROM country co
RIGHT JOIN city ci
ON co.Code = ci.CountryCode
ORDER BY co.Population;

-- FULL OUTER JOIN (MySQL에서 지원 X)
-- 양쪽 테이블의 모든 행 포함
--  LEFT JOIN + RIGHT JOIN + UNION으로 구현
SELECT
    co.Name AS 국가명,
    ci.Name AS 도시명
FROM country co
LEFT JOIN city ci ON co.Code = ci.CountryCode

UNION

SELECT
    co.Name AS 국가명,
    ci.Name AS 도시명
FROM country co
RIGHT JOIN city ci ON co.Code = ci.CountryCode
LIMIT 50;

-- SELF JOIN
-- 같은 테이블을 자기 자신과 조인
SELECT 
	c1.Name,
    c2.Name
FROM city c1 
INNER JOIN city c2
ON c1.CountryCode = c2.CountryCode
-- AND c1.ID < c2.ID
WHERE c1.CountryCode = 'KOR';

-- 다중 JOIN
SELECT 
	*
FROM country co
INNER JOIN city ci ON co.Code = ci.CountryCode
INNER JOIN countrylanguage cl ON ci.CountryCode = cl.CountryCode;

-- 실습
USE sakila;
-- 영화(`film`)와 언어(`language`) 테이블을 조인하여 다음을 조회하세요:
-- - 영화 제목 (`film.title`), 언어 이름 (`language.name`)
SELECT
	film.title,
    language.name
FROM film
INNER JOIN language
ON film.language_id = language.language_id;

-- 영화와 카테고리를 조인하여 다음을 조회하세요:
-- - 영화 제목, 카테고리 이름, 대여료
SELECT
	f.title,
    c.name,
    f.replacement_cost
FROM film f
INNER JOIN film_category fc ON f.film_id = fc.film_id
INNER JOIN category c ON fc.category_id = c.category_id;

-- 모든 고객(`customer`)과 그들의 대여 내역(`rental`)을 조회하세요.
-- - 고객 이름 (first_name, last_name), 대여 ID (rental_id), 대여 날짜 (rental_date)
SELECT
	c.first_name,
    c.last_name,
    r.rental_id,
    r.rental_date
FROM customer c 
LEFT JOIN rental r ON c.customer_id = r.customer_id;

-- 고객별 대여 횟수를 조회하세요. (대여 횟수 0인 고객도 포함)
-- - 고객 이름, 대여 횟수, 대여 횟수가 많은 순서
SELECT
	CONCAT(c.first_name, "_", c.last_name) AS full_name,
    COUNT(rental_id) AS rentalCnt
FROM customer c
LEFT JOIN rental r ON c.customer_id = r.customer_id
GROUP BY full_name
ORDER BY rentalCnt DESC;

-- 같은 상영 시간(`length`)을 가진 영화 쌍을 찾으세요.
-- - 영화1 제목, 영화2 제목, 상영 시간, 상위 10개
SELECT 
	f1.title,
    f2.title,
    f1.length
FROM film f1
INNER JOIN film f2 ON f1.length = f2.length
WHERE f1.film_id < f2.film_id -- 중복 제거
ORDER BY f1.length DESC
LIMIT 10;