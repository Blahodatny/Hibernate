CREATE OR REPLACE FUNCTION for_loop_through_dyn_query(sort_type INTEGER, n INTEGER)
  RETURNS VOID AS
$$
DECLARE
  rec   RECORD;
  query TEXT;
BEGIN
  query := 'SELECT Id, Type FROM PRODUCTS ';
  IF sort_type = 1 THEN
    query := query || 'ORDER BY Id';
  ELSIF sort_type = 2 THEN
    query := query || 'ORDER BY Type';
  ELSE
    RAISE EXCEPTION 'Invalid sort type %s', sort_type;
  END IF;

  query := query || ' LIMIT $1';

  FOR rec IN EXECUTE query USING n
    LOOP
      RAISE NOTICE '% - %', rec.Id, rec.Type;
    END LOOP;

END;
$$ LANGUAGE plpgsql;

SELECT for_loop_through_dyn_query(2, 5);

DROP FUNCTION IF EXISTS for_loop_through_dyn_query(sort_type INTEGER, n INTEGER)