CREATE OR REPLACE FUNCTION for_loop_through_dyn_query(sort_type INTEGER,
                                                      n INTEGER)
  RETURNS VOID AS
$$
DECLARE
  rec   RECORD;
  query text;
BEGIN
  query := 'SELECT product_id, productType FROM products ';
  IF sort_type = 1 THEN
    query := query || 'ORDER BY product_id';
  ELSIF sort_type = 2 THEN
    query := query || 'ORDER BY productType';
  ELSE
    RAISE EXCEPTION 'Invalid sort type %s', sort_type;
  END IF;

  query := query || ' LIMIT $1';

  FOR rec IN EXECUTE query USING n
    LOOP
      RAISE NOTICE '% - %', rec.product_id, rec.productType;
    END LOOP;

END;
$$ LANGUAGE plpgsql;

SELECT for_loop_through_dyn_query(2, 5)