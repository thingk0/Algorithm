SELECT
    COUNT(*) AS FISH_COUNT,
    MONTH(FI.TIME) AS MONTH
FROM
    FISH_INFO AS FI
GROUP BY
    MONTH(FI.TIME)
ORDER BY 
    MONTH
