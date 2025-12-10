-- 인덱스(INDEX)
-- 데이터베이스 테이블의 검색 속도를 향상시키기 위한 자료구조
-- MySQL의 기본 인덱싱 방식 : B-Tree (Binary-Tree)
USE world;
-- index 조회
SHOW INDEX FROM city;

DESC city;

-- index 생성
CREATE INDEX idx_city_name ON city(Name);
EXPLAIN SELECT * FROM city WHERE Name = 'Seoul';

SHOW INDEX FROM city;

-- index 삭제
DROP INDEX idx_city_name ON city;
SHOW INDEX FROM city;

-- 뷰(View)
-- 하나 이상의 테이블로부터 유도된 가상 테이블(Virtual Table)
-- 재사용성, 보안 및 권한, 독립성
USE world;
-- 뷰 생성
CREATE VIEW large_country AS
SELECT *
FROM country
WHERE Population >= 50000000;

SELECT * FROM large_country;

CREATE VIEW country_view AS
SELECT 
	co.Name AS co_name, ci.Name AS ci_name
FROM country co
INNER JOIN city ci
ON co.Code = ci.CountryCode;

SELECT * FROM country_view;
-- 뷰 테이블만 조회
SHOW FULL TABLES WHERE Table_type='VIEW';
-- 뷰 테이블 삭제
DROP VIEW large_country;