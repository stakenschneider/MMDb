CREATE TABLE public.datastorage
(
    dataid integer DEFAULT nextval('datastorage_dataid_seq'::regclass) PRIMARY KEY NOT NULL,
    path varchar(255)
);
CREATE UNIQUE INDEX datastorage_dataid_uindex ON public.datastorage (dataid);