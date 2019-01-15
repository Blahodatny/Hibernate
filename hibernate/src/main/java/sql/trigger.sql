CREATE OR REPLACE FUNCTION update_order_item()
  RETURNS TRIGGER AS
$$
DECLARE
  curs CURSOR FOR SELECT *
                  FROM order_items
                  WHERE order_number = NEW.order_number;
BEGIN
  FOR r IN curs
    LOOP
      IF r.product_id = NEW.product_id THEN
        UPDATE order_items
        SET quantity = quantity + NEW.quantity
        WHERE item_id = r.item_id;

        RETURN NULL;
      END IF;
    END LOOP;
  RETURN NEW;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER update_quantity
  BEFORE INSERT
  ON order_items
  FOR EACH ROW
EXECUTE PROCEDURE update_order_item();

INSERT INTO order_items (Order_number, Product_ID, Quantity)
VALUES (1, 'BMW', 67);

DROP TRIGGER IF EXISTS update_quantity ON order_items;
DROP FUNCTION IF EXISTS update_order_item()