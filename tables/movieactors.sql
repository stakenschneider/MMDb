CREATE TABLE public.movieactors
(
    movieactorsid integer DEFAULT nextval('movieactors_movieactors_seq'::regclass) PRIMARY KEY NOT NULL,
    movieid integer DEFAULT nextval('movieactors_movieid_seq'::regclass) NOT NULL,
    actorid integer DEFAULT nextval('movieactors_actorid_seq'::regclass) NOT NULL,
    CONSTRAINT movieactors_actors_actorid_fk FOREIGN KEY (movieactorsid) REFERENCES actors (actorid),
    CONSTRAINT movieactors_movie_movieid_fk FOREIGN KEY (movieactorsid) REFERENCES movie (movieid)
);
CREATE UNIQUE INDEX movieactors_movieactors_uindex ON public.movieactors (movieactorsid);