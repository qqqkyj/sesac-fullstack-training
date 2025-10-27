USE world;

SELECT * FROM country
ORDER BY Population DESC;

SELECT * FROM country 
ORDER BY Name DESC;

SELECT * FROM country
ORDER BY Continent DESC, Population DESC;

SELECT * FROM country
WHERE Continent = 'Asia'
ORDER BY GNP;

SELECT * FROM country
ORDER BY Population DESC
LIMIT 5;

SELECT * FROM country
ORDER BY Population DESC
LIMIT 5 OFFSET 10;

SELECT * FROM country
ORDER BY Population DESC
LIMIT 5, 5;




