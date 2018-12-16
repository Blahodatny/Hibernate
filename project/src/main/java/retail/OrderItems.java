package retail;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "public", catalog = "Retail_Service")
public class OrderItems {
    private int itemId;
    private int quantity;

    @Id
    @Column(name = "item_id", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems that = (OrderItems) o;
        return itemId == that.itemId &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, quantity);
    }
}
