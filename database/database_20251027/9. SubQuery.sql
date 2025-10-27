USE world;

-- 단일 행 서브쿼리(Single-Row)
-- 서울 인구보다 많은 도시
SELECT
	*
FROM city
WHERE Population > (SELECT Population FROM city WHERE Name = 'SEOUL');
-- 평균보다 큰 값
SELECT 
	Name, Population
FROM country
WHERE Population > (SELECT AVG(Population) FROM country)
ORDER BY Population DESC;

-- 다중 행 서버쿼리(Multi-Row)
-- 아시아 국가의 모든 도시 (IN)
SELECT 
	Name, CountryCode, Population
FROM city
WHERE CountryCode IN (SELECT Code FROM country WHERE Continent = 'Asia');

-- 도시가 하나도 없는 국가 (NOT IN)
SELECT 
	*
FROM country
WHERE Code NOT IN (SELECT DISTINCT(CountryCode) FROM city);

-- ANY(하나라도 조건을 만족하면 TRUE)
-- 유럽의 어떤 국가보다 인구가 많은 아시아 국가
SELECT
    Name AS 국가명,
    Population AS 인구
FROM country
WHERE
    Continent = 'Asia'
    AND Population > ANY (
        SELECT Population FROM country WHERE Continent = 'Europe'
    )
ORDER BY Population DESC
LIMIT 10;

-- ALL(모든 값에 대해 조건을 만족하면 TRUE)
-- 유럽의 모든 국가보다 인구가 많은 아시아 국가
SELECT
    Name AS 국가명,
    Population AS 인구
FROM country
WHERE
    Continent = 'Asia'
    AND Population > ALL (
        SELECT Population FROM country WHERE Continent = 'Europe'
    )
ORDER BY Population DESC;

-- EXIST(존재하면 TRUE, 행의 존재 여부만 확인)
-- 도시가 등록된 국가만 조회
SELECT
    Name AS 국가명,
    Continent AS 대륙,
    Population AS 인구
FROM country co
WHERE
    EXISTS (
        SELECT 1 FROM city ci WHERE ci.CountryCode = co.Code
    )
ORDER BY Population DESC
LIMIT 10;

-- FROM절의 서브쿼리 (인라인 뷰)
-- FROM 절의 서브쿼리는 가상 테이블처럼 동작
SELECT *
FROM (
	SELECT Continent, COUNT(*) AS co_count
	FROM country
	GROUP BY Continent
) AS continent_table
WHERE co_count > 40;

-- JOIN VS 서브쿼리
-- 같은 결과, 다른 방식
-- 서브쿼리 방식: 아시아 국가의 도시
SELECT Name
FROM city
WHERE CountryCode IN (
    SELECT Code FROM country WHERE Continent = 'Asia'
)
LIMIT 10;

-- JOIN 방식
SELECT ci.Name
FROM city ci
INNER JOIN country co ON ci.CountryCode = co.Code
WHERE co.Continent = 'Asia'
LIMIT 10;


USE sakila;
-- 평균 대여료(`rental_rate`)보다 비싼 영화를 조회하세요.
-- - 영화 제목, 대여료. 대여료 내림차순 정렬
-- - 상위 10개
SELECT 
	title, rental_rate
FROM film
WHERE rental_rate > (SELECT ROUND(AVG(rental_rate),2) FROM film)
ORDER BY rental_rate DESC
LIMIT 10;

-- 'Action' 카테고리에 속한 영화를 조회하세요.
-- - 영화 제목
SELECT
	title
FROM film
WHERE film_id in (
	SELECT 
		film_id
	FROM film_category 
    WHERE category_id = (SELECT category_id FROM category WHERE name='Action') 
);

-- 대여 기록이 있는 고객만 조회하세요.
-- - 고객 이름 (first_name, last_name), 이메일
-- 서브쿼리 결과가 존재하면 TRUE (행의 존재 여부만 확인) 
SELECT
	first_name, last_name, email
FROM customer
WHERE EXISTS (SELECT * FROM rental WHERE customer.customer_id = rental.customer_id);

-- 고객별 대여 횟수를 구한 뒤, 대여 횟수가 30회 이상인 고객만 조회하세요.
-- - 고객 이름, 대여 횟수, 대여 횟수 내림차순
SELECT
	c_name, c_id, c_count
FROM(
	SELECT
		CONCAT(c.first_name, "_", c.last_name) AS c_name,
		c.customer_id AS c_id,
		COUNT(*) AS c_count
	FROM customer c 
	INNER JOIN rental r ON c.customer_id = r.customer_id
	GROUP BY c.customer_id
) AS customer_rental
WHERE c_count >= 30
ORDER BY c_count DESC;