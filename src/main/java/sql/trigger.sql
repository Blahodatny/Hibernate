CREATE OR REPLACE FUNCTION update_order_item()
  RETURNS TRIGGER AS
$$
DECLARE
  curs CURSOR FOR SELECT *
                  FROM ORDER_ITEMS
                  WHERE Order_Id = NEW.Order_Id;
BEGIN
  FOR r IN curs
    LOOP
      IF r.Product_Id = NEW.Product_Id THEN
        UPDATE ORDER_ITEMS
        SET Quantity = Quantity + NEW.Quantity
        WHERE Id = r.Id;

        RETURN NULL;
      END IF;
    END LOOP;
  RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER update_quantity
  BEFORE INSERT
  ON ORDER_ITEMS
  FOR EACH ROW
EXECUTE PROCEDURE update_order_item();

INSERT INTO order_items (Order_Id, Product_Id, Quantity)
VALUES (1, 'BMW', 67);

DROP TRIGGER IF EXISTS update_quantity ON ORDER_ITEMS;
DROP FUNCTION IF EXISTS update_order_item()