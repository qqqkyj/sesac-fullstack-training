USE world;

SELECT 
	Name,
    Continent,
	CASE Continent
		WHEN 'Asia' THEN '아시아'
        WHEN 'Europe' THEN '유럽'
		ELSE 'etc'
	END 
FROM country;

SELECT
	Name,
    Population,
    CASE
		WHEN Population >= 100000000 THEN '큰국가'
        WHEN Population >= 50000000 THEN '중간국가'
        ELSE '작은국가'
    END
FROM country;



SELECT
	Name, Population, GNP, GNP / Population,
    CASE
		WHEN (GNP / Population) >= 0.02 THEN '선진국'
        ELSE '선진국아님'
    END
FROM country;



SELECT
	Name, Continent, Population
FROM Country
WHERE Population >= 
	CASE Continent
		WHEN 'Asia' THEN 50000000
        WHEN 'Europe' THEN 30000000
        ELSE 10000000
    END;



SELECT 
	Name, Continent, Population
FROM country
ORDER BY 
	CASE Continent
		WHEN 'Asia' THEN Population
        WHEN 'Europe' THEN GNP
        ELSE Population
    END;
    
SELECT
	Continent, COUNT(*),
    SUM(CASE WHEN Population > 50000000 THEN 1 ELSE 0 END)
FROM country
GROUP BY Continent;








