create table genres
(
genreid serial not null
constraint genres_pkey
primary key,
genrename varchar(40) not null
)
;

create unique index genres_genreid_uindex
on genres (genreid)
;

create unique index genres_genrename_uindex
on genres (genrename)
;

create table movie
(
movieid serial not null
constraint movie_pkey
primary key,
name varchar(100) not null,
releaseyear integer,
rating numeric,
movielength integer,
description varchar(300)
)
;

create table moviegenres
(
moviegenres serial not null
constraint moviegenres_pkey
primary key,
movieid serial not null
constraint moviegenres_movie_movieid_fk
references movie,
genreid serial not null
constraint moviegenres_genres_genreid_fk
references genres
)
;

create unique index moviegenres_moviegenres_uindex
on moviegenres (moviegenres)
;

create table people
(
peopleid serial not null
constraint people_pkey
primary key,
firstname varchar(50) not null,
lastname varchar(50) not null,
birth date
)
;

create unique index people_peopleid_uindex
on people (peopleid)
;

create table awards
(
awardsid serial not null
constraint awards_pkey
primary key,
name varchar(100) not null
)
;

create unique index awards_awardsid_uindex
on awards (awardsid)
;

create unique index awards_name_uindex
on awards (name)
;

create table moviepeople
(
moviepeopleid serial not null
constraint moviepeople_pkey
primary key,
movieid serial not null
constraint moviepeople_movie_movieid_fk
references movie,
peopleid serial not null
constraint moviepeople_people_peopleid_fk
references people
)
;

create unique index moviepeople_moviepeopleid_uindex
on moviepeople (moviepeopleid)
;

create table movieawards
(
movieawardsid serial not null
constraint movieawards_pkey
primary key,
movieid serial not null
constraint movieawards_movie_movieid_fk
references movie,
awardid serial not null
constraint movieawards_awards_awardsid_fk
references awards
)
;

create unique index movieawards_movieawardsid_uindex
on movieawards (movieawardsid)
;

create table profession
(
professionid serial not null
constraint profession_pkey
primary key,
name varchar(70) not null
)
;

create unique index profession_professionid_uindex
on profession (professionid)
;

create unique index profession_name_uindex
on profession (name)
;

create table peopleprofession
(
peopleprofessionid serial not null
constraint peopleprofession_pkey
primary key,
peopleid serial not null
constraint peopleprofession_people_peopleid_fk
references people,
professionid serial not null
constraint peopleprofession_profession_professionid_fk
references profession
)
;

create unique index peopleprofession_peopleprofessionid_uindex
on peopleprofession (peopleprofessionid)
;

create table peopleawards
(
peopleawardsid serial not null
constraint peopleawards_pkey
primary key,
peopleid serial not null
constraint peopleawards_people_peopleid_fk
references people,
awardsid serial not null
constraint peopleawards_awards_awardsid_fk
references awards
)
;

create unique index peopleawards_peopleawardsid_uindex
on peopleawards (peopleawardsid)
;
