CREATE TABLE public.moviedirectors
(
    moviedirectorsid integer DEFAULT nextval('moviedirectors_moviedirectorsid_seq'::regclass) PRIMARY KEY NOT NULL,
    movieid integer DEFAULT nextval('moviedirectors_movieid_seq'::regclass) NOT NULL,
    directorid integer DEFAULT nextval('moviedirectors_directorid_seq'::regclass) NOT NULL,
    CONSTRAINT moviedirectors_directors_directorsid_fk FOREIGN KEY (moviedirectorsid) REFERENCES directors (directorsid),
    CONSTRAINT moviedirectors_movie_movieid_fk FOREIGN KEY (moviedirectorsid) REFERENCES movie (movieid)
);
CREATE UNIQUE INDEX moviedirectors_moviedirectorsid_uindex ON public.moviedirectors (moviedirectorsid);