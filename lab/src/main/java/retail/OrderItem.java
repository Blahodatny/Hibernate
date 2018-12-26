package retail;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "public", catalog = "Retail_Service")
public class OrderItem {
    private int itemId;
    private int quantity;
    private Order ordersByOrderNumber;
    private Product productsByProductId;

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var orderItem = (OrderItem) o;
        return itemId == orderItem.itemId &&
                quantity == orderItem.quantity;
    }

    public int hashCode() {
        return Objects.hash(itemId, quantity);
    }

    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", ordersByOrderNumber=" + ordersByOrderNumber +
                ", productsByProductId=" + productsByProductId +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "order_number", referencedColumnName = "order_number", nullable = false)
    public Order getOrdersByOrderNumber() {
        return ordersByOrderNumber;
    }

    public void setOrdersByOrderNumber(Order ordersByOrderNumber) {
        this.ordersByOrderNumber = ordersByOrderNumber;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public Product getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Product productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}