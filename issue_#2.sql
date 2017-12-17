-- Вывести 10 человек, которые получали какие-либо премии за фильмы, в которых участвовали в двух или более качествах
SELECT firstname, lastname, count(moviepeople.professionid) as count_prof
FROM moviepeople
  JOIN people on (people.peopleid = moviepeople.peopleid)
  WHERE awardid is not NULL
GROUP BY moviepeople.movieid , moviepeople.peopleid , firstname,lastname
ORDER BY count_prof DESC
LIMIT 10;


-- Вывести 10 самых успешных деятелей кино (максимальное количество наград) за заданный период времени.
-- При одинаковом количестве наград вторым показателем успешности необходимо считать общее количество фильмов,
-- в которых принималось участие.
SELECT people.peopleid, people.firstname , people.lastname, count (moviepeople.awardid) as award_count , count(moviepeople.movieid) as movie_count
FROM people
  JOIN moviepeople on (people.peopleid = moviepeople.peopleid)
  JOIN movie on (movie.movieid = moviepeople.movieid)
WHERE releaseyear BETWEEN 1917 and 2016
GROUP BY people.peopleid
  ORDER BY award_count DESC , movie_count DESC
LIMIT 10;
