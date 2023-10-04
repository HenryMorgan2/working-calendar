DO $$
DECLARE
	countday int := 730;--Задать количество дней для заполнения
	myday date;
	myid int;
	dayweek int;
	is_holiday boolean;

BEGIN
	FOR counter IN 0..countday

	LOOP
		myday:= now() + counter * interval '1 day';
		myid:= counter + 1;
		dayweek:= EXTRACT(DOW FROM myday);

		IF dayweek = 6 OR dayweek = 0 THEN
    		is_holiday:= true;
		ELSE
			is_holiday:= false;
		END IF;

		INSERT INTO public.working_calendar(
			id, calendar_date, is_holiday)
			VALUES (myid, myday, is_holiday);

END LOOP;
END;
$$ LANGUAGE plpgsql