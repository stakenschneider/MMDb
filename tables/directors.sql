CREATE TABLE public.directors
(
    directorsid integer DEFAULT nextval('directors_directorsid_seq'::regclass) PRIMARY KEY NOT NULL,
    firstname varchar(30) NOT NULL,
    lastname varchar(50),
    birth date
);
CREATE UNIQUE INDEX directors_directorsid_uindex ON public.directors (directorsid);