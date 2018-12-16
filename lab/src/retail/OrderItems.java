package retail;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "public", catalog = "Retail_Service")
public class OrderItems {
    private int itemId;
    private int quantity;
    private Orders ordersByOrderNumber;
    private Products productsByProductId;

    @Id
    @Column(name = "item_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (OrderItems) o;
        return itemId == that.itemId &&
                quantity == that.quantity;
    }

    public int hashCode() {
        return Objects.hash(itemId, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "order_number", referencedColumnName = "order_number", nullable = false)
    public Orders getOrdersByOrderNumber() {
        return ordersByOrderNumber;
    }

    public void setOrdersByOrderNumber(Orders ordersByOrderNumber) {
        this.ordersByOrderNumber = ordersByOrderNumber;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public Products getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Products productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}