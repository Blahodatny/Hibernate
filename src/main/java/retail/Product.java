package retail;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products", schema = "public", catalog = "Retail_Service")
public class Product {
    private String id;
    private String type;
    private boolean secondHand;
    private Collection<OrderItem> orderItemsById;

    @Id
    @Column(name = "id", nullable = false, length = 20)
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    @Basic
    @Column(name = "type", nullable = false, length = -1)
    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    @Basic
    @Column(name = "second_hand", nullable = false)
    public boolean isSecondHand() { return secondHand; }

    public void setSecondHand(boolean secondHand) {
        this.secondHand = secondHand;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        var product = (Product) o;
        return secondHand == product.secondHand &&
                Objects.equals(id, product.id) &&
                Objects.equals(type, product.type);
    }

    public int hashCode() { return Objects.hash(id, type, secondHand); }

    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", secondHand=" + secondHand +
                '}';
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<OrderItem> getOrderItemsById() { return orderItemsById; }

    public void setOrderItemsById(Collection<OrderItem> orderItemsById) {
        this.orderItemsById = orderItemsById;
    }
}