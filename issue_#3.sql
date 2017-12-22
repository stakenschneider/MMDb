-- В виде триггера реализовать проверку: должно быть нельзя дважды добавить одного человека в один фильм в одном качестве.
CREATE OR REPLACE FUNCTION func() RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT' OR TG_OP = 'UPDATE') THEN
        IF EXISTS (SELECT * FROM moviepeople AS mp WHERE mp.movieid = NEW.movieid AND mp.professionid  = NEW.professionid AND
               mp.peopleid = NEW.peopleid)
          THEN
          RAISE EXCEPTION '┐(￣ヘ￣;)┌';
        END IF;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER trggr_1 ON moviepeople;
CREATE TRIGGER trggr_1
BEFORE INSERT OR UPDATE ON moviepeople
FOR EACH ROW EXECUTE PROCEDURE func ();



-- При суммарном количестве наград более заданного присуждать фильму премию за лучший фильм.
CREATE OR REPLACE FUNCTION func_2() RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (SELECT * from movieawards WHERE movieid = new.movieid and movieawards.awardid = 12) THEN RETURN new; END IF ;

	    IF ((SELECT COUNT(ma.awardid) FROM movieawards as ma WHERE ma.movieid = NEW.movieid ) > 3)
  THEN
      INSERT INTO movieawards (movieid , awardid) VALUES (new.movieid , 12);
	END IF;
      RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER trggr_2 ON movieawards;
CREATE TRIGGER trggr_2
AFTER INSERT OR UPDATE ON movieawards
FOR EACH ROW EXECUTE PROCEDURE func_2 ();

