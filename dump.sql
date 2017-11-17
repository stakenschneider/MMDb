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

create table actors
(
	actorid serial not null
		constraint actors_pkey
			primary key,
	firstname varchar(30) not null,
	lastname varchar(50),
	birth date
)
;

create unique index actors_actorid_uindex
	on actors (actorid)
;

create table movieactors
(
	movieactorsid serial not null
		constraint movieactors_pkey
			primary key,
	movieid serial not null
		constraint movieactors_movie_movieid_fk
			references movie,
	actorid serial not null
		constraint movieactors_actors_actorid_fk
			references actors
)
;

create unique index movieactors_movieactors_uindex
	on movieactors (movieactorsid)
;

create table moviedirectors
(
	moviedirectorsid serial not null
		constraint moviedirectors_pkey
			primary key,
	movieid serial not null
		constraint moviedirectors_movie_movieid_fk
			references movie,
	directorid serial not null
)
;

create unique index moviedirectors_moviedirectorsid_uindex
	on moviedirectors (moviedirectorsid)
;

create table directors
(
	directorsid serial not null
		constraint directors_pkey
			primary key,
	firstname varchar(30) not null,
	lastname varchar(50),
	birth date
)
;

create unique index directors_directorsid_uindex
	on directors (directorsid)
;

alter table moviedirectors
	add constraint moviedirectors_directors_directorsid_fk
		foreign key (directorid) references directors
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

create table imagines
(
	imaginesid serial not null
		constraint imagines_pkey
			primary key,
	imgine bytea not null
)
;

create unique index imagines_imaginesid_uindex
	on imagines (imaginesid)
;