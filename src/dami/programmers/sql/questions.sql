/* 최솟값 구하기 */
/* https://programmers.co.kr/learn/courses/30/lessons/59038 */
SELECT  MIN(DATETIME) AS '시간'
FROM    ANIMAL_INS

/* 동물 수 구하기 */
/* https://programmers.co.kr/learn/courses/30/lessons/59406 */
SELECT  COUNT(*) AS count
FROM    ANIMAL_INS

/* 있었는데요 없었습니다 */
/* https://programmers.co.kr/learn/courses/30/lessons/59043 */
SELECT  ins.ANIMAL_ID, ins.NAME
FROM    ANIMAL_INS ins, ANIMAL_OUTS outs
WHERE   ins.ANIMAL_ID = outs.ANIMAL_ID
AND     ins.DATETIME > outs.DATETIME
ORDER BY ins.DATETIME

/* 오랜 기간 보호한 동물(1) */
/* https://programmers.co.kr/learn/courses/30/lessons/59044 */
/* 1. not in */
SELECT  NAME, DATETIME
FROM    ANIMAL_INS
WHERE   ANIMAL_ID NOT IN (  SELECT  ANIMAL_ID
                            FROM    ANIMAL_OUTS )
ORDER BY DATETIME
LIMIT 3

/* 2. left join */
SELECT  i.NAME, i.DATETIME
FROM    ANIMAL_INS i LEFT JOIN ANIMAL_OUTS o USING (ANIMAL_ID)
WHERE   o.DATETIME IS NULL
ORDER BY i.DATETIME
LIMIT 3

/* 보호소에서 중성화한 동물 */
/* https://programmers.co.kr/learn/courses/30/lessons/59045 */
SELECT  ins.ANIMAL_ID, ins.ANIMAL_TYPE, ins.NAME
FROM    ANIMAL_INS ins, ANIMAL_OUTS outs
WHERE   ins.ANIMAL_ID = outs.ANIMAL_ID
AND     ins.SEX_UPON_INTAKE REGEXP 'Intact'
AND     outs.SEX_UPON_OUTCOME REGEXP 'Spayed|Neutered'

/* 우유와 요거트가 담긴 장바구니 */
/* https://programmers.co.kr/learn/courses/30/lessons/62284 */
/* 1. 내 풀이 -> 항목 늘어날 때마다 서브쿼리도 늘려야하는 문제.. */
SELECT  m.CART_ID
FROM    CART_PRODUCTS m, (
    SELECT  CART_ID, NAME
    FROM    CART_PRODUCTS
    WHERE   NAME = 'Yogurt'
) y
WHERE   m.CART_ID = y.CART_ID
AND     m.NAME = 'Milk'
GROUP BY CART_ID
ORDER BY CART_ID

/* 2. 베스트 풀이인듯? */
SELECT  CART_ID
FROM    CART_PRODUCTS
WHERE   NAME IN ('Milk', 'Yogurt')
GROUP BY CART_ID
HAVING  COUNT(DISTINCT NAME) >= 2
ORDER BY CART_ID
