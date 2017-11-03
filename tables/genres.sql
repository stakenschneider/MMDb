CREATE TABLE public.genres
(
    genreid integer DEFAULT nextval('genres_genreid_seq'::regclass) PRIMARY KEY NOT NULL,
    genrename varchar(40) NOT NULL
);
CREATE UNIQUE INDEX genres_genreid_uindex ON public.genres (genreid);
CREATE UNIQUE INDEX genres_genrename_uindex ON public.genres (genrename);
INSERT INTO public.genres (genreid, genrename) VALUES (1, 'anime');
INSERT INTO public.genres (genreid, genrename) VALUES (2, 'biographical');
INSERT INTO public.genres (genreid, genrename) VALUES (3, 'triller');
INSERT INTO public.genres (genreid, genrename) VALUES (4, 'western');
INSERT INTO public.genres (genreid, genrename) VALUES (5, 'war');
INSERT INTO public.genres (genreid, genrename) VALUES (6, 'detective');
INSERT INTO public.genres (genreid, genrename) VALUES (7, 'documentary');
INSERT INTO public.genres (genreid, genrename) VALUES (8, 'drama');
INSERT INTO public.genres (genreid, genrename) VALUES (9, 'historical');
INSERT INTO public.genres (genreid, genrename) VALUES (10, 'comedy');
INSERT INTO public.genres (genreid, genrename) VALUES (11, 'concert');
INSERT INTO public.genres (genreid, genrename) VALUES (12, 'short');
INSERT INTO public.genres (genreid, genrename) VALUES (13, 'crime');
INSERT INTO public.genres (genreid, genrename) VALUES (14, 'melodrama');
INSERT INTO public.genres (genreid, genrename) VALUES (15, 'mystic');
INSERT INTO public.genres (genreid, genrename) VALUES (16, 'musical');
INSERT INTO public.genres (genreid, genrename) VALUES (17, 'sci-fi');
INSERT INTO public.genres (genreid, genrename) VALUES (18, 'adventure');
INSERT INTO public.genres (genreid, genrename) VALUES (19, 'family');
INSERT INTO public.genres (genreid, genrename) VALUES (20, 'horror');
INSERT INTO public.genres (genreid, genrename) VALUES (21, 'fantastic');
INSERT INTO public.genres (genreid, genrename) VALUES (22, 'noir');
INSERT INTO public.genres (genreid, genrename) VALUES (23, 'fantasy');
INSERT INTO public.genres (genreid, genrename) VALUES (24, 'cartoon');