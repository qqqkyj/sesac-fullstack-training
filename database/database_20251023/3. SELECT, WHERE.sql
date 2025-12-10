USE world;
SELECT * FROM country;
-- alias
SELECT name AS 국가명, population AS 인구 FROM country LIMIT 5;
-- distinct (중복 제거)
SELECT DISTINCT continent, region FROM country;
-- 테이블 구조 확인
DESC country;
SHOW COLUMNS FROM country;
-- where
SELECT name, population FROM country WHERE population >= 10000000;
-- and
SELECT name, population FROM country WHERE population >= 10000000 AND continent='Asia';
-- or 
SELECT name, population FROM country WHERE continent='Asia' OR continent='Europe' LIMIT 10;
-- not
SELECT name, population FROM country WHERE NOT continent='Asia' LIMIT 10;
