-- выборка всех данных из каждой таблицы
SELECT * FROM actors;
SELECT * FROM directors;
SELECT * FROM genres;
SELECT * FROM movie;
SELECT * FROM movieactors;
SELECT * FROM moviedirectors;
SELECT * FROM moviegenres;

--выборка данных из одной таблицы при нескольких условиях, с использованием логических операций, LIKE, BETWEEN, IN
SELECT firstname FROM actors WHERE lastname LIKE 'Deckow';
SELECT name FROM movie WHERE description LIKE '%war%';
SELECT firstname  FROM actors WHERE firstname LIKE 'Al%';
SELECT name FROM movie WHERE rating BETWEEN 3 and 5;
SELECT name FROM movie WHERE movielength BETWEEN 77 and 100;
SELECT directors.firstname , directors.lastname FROM    directors WHERE    birth BETWEEN '1949-06-10' AND '1997-11-28';

-- Создайте в запросе вычисляемое поле

-- Сделайте выборку всех данных с сортировкой по нескольким полям
SELECT * FROM movie ORDER BY name ASC;
SELECT * FROM movieactors ORDER BY movieid;
SELECT * FROM actors ORDER BY birth DESC;
SELECT * FROM movie ORDER BY rating;

-- Создайте запрос, вычисляющий несколько совокупных характеристик таблиц
SELECT AVG(movie.rating) FROM movie;
SELECT SUM(movie.movielength) FROM movie WHERE rating BETWEEN 5 AND 10;
SELECT MAX(movie.rating) FROM movie;
SELECT MIN(movie.rating) FROM movie;
SELECT COUNT(actors.firstname) FROM actors WHERE birth BETWEEN '1990-01-01' AND '2000-01-01';

-- Сделайте выборку данных из связанных таблиц
SELECT movie.name , genres.genrename FROM movie, genres WHERE genrename = 'sci-fi';
SELECT actors.firstname , actors.lastname FROM movie , actors WHERE movie.description LIKE '%war%';

-- Создайте запрос, рассчитывающий совокупную характеристику с использованием группировки, наложите ограничение на результат группировки

-- Придумайте и реализуйте пример использования вложенного запроса

-- С помощью оператора INSERT добавьте в каждую таблицу по одной записи
INSERT INTO movie (name, releaseyear, rating, movielength, description) VALUES ('dataBase', '2017', '10', '90', 'bla bla');
INSERT INTO directors (firstname, lastname, birth) VALUES ('masha', 'volkova', '1949-06-10');
INSERT INTO actors (firstname, lastname, birth) VALUES ('masha', 'volkova', '1949-06-10');
INSERT INTO movieactors (movieid, actorid) VALUES ('1', '1');
INSERT INTO moviedirectors (movieid, directorid) VALUES ('1', '1');
INSERT INTO moviegenres (movieid, genreid) VALUES ('1', '1');

--измените значения нескольких полей у всех записей, отвечающих заданному условию
UPDATE actors SET firstname = 'masha' WHERE firstname LIKE 'Bettye';

--удалите запись, имеющую максимальное/минимальное значение некоторой совокупной характеристики
DELETE FROM movieactors WHERE movieid = (SELECT MAX(movieid) FROM movieactors);
DELETE FROM movieactors WHERE movieid = (SELECT MIN(movieid) FROM movieactors);

--удалите записи в главной таблице, на которые не ссылается подчиненная таблица
DELETE FROM movie WHERE rating = '10';
DELETE FROM movie USING genres WHERE genres.genrename <> 'Musical';
