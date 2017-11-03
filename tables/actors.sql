CREATE TABLE public.actors
(
    actorid integer DEFAULT nextval('actors_actorid_seq'::regclass) PRIMARY KEY NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(50),
    birth date
);
CREATE UNIQUE INDEX actors_actorid_uindex ON public.actors (actorid);