-- Вывести 10 человек, которые получали какие-либо премии за фильмы, в которых участвовали в двух или более качествах
SELECT p.firstname , p.lastname ,  count(pp.peopleprofessionid) as count
FROM peopleprofession pp , people p , peopleawards a
WHERE p.peopleid = pp.peopleid AND a.peopleid = p.peopleid
GROUP BY p.peopleid , pp.peopleid
ORDER BY count DESC
LIMIT 10;


-- Вывести 10 самых успешных деятелей кино (максимальное количество наград) за заданный период времени. 
-- При одинаковом количестве наград вторым показателем успешности необходимо считать общее количество фильмов,
-- в которых принималось участие.
SELECT pep.firstname , pep.lastname  , count(peopleawardsid) as count
FROM peopleawards p , people pep
WHERE pep.peopleid = p.peopleid
GROUP BY p.peopleid , pep.peopleid
ORDER BY count DESC 
LIMIT 10;