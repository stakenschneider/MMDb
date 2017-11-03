CREATE TABLE public.movie
(
    movieid integer DEFAULT nextval('movie_movieid_seq'::regclass) PRIMARY KEY NOT NULL,
    name varchar(100) NOT NULL,
    releaseyear integer,
    rating numeric,
    movielength integer,
    description varchar(300),
    tagline varchar(150)
);