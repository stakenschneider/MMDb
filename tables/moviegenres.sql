CREATE TABLE public.moviegenres
(
    moviegenres integer DEFAULT nextval('moviegenres_moviegenres_seq'::regclass) PRIMARY KEY NOT NULL,
    movieid integer DEFAULT nextval('moviegenres_movieid_seq'::regclass) NOT NULL,
    genreid integer DEFAULT nextval('moviegenres_genreid_seq'::regclass) NOT NULL,
    CONSTRAINT moviegenres_genres_genreid_fk FOREIGN KEY (moviegenres) REFERENCES genres (genreid),
    CONSTRAINT moviegenres_movie_movieid_fk FOREIGN KEY (moviegenres) REFERENCES movie (movieid)
);
CREATE UNIQUE INDEX moviegenres_moviegenres_uindex ON public.moviegenres (moviegenres);