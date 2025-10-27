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
