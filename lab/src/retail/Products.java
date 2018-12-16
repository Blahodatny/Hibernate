package retail;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Products {
    private String productId;
    private String producttype;
    private boolean isnew;
    private Collection<OrderItems> orderItemsByProductId;

    @Id
    @Column(name = "product_id")
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "producttype")
    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    @Basic
    @Column(name = "isnew")
    public boolean isIsnew() {
        return isnew;
    }

    public void setIsnew(boolean isnew) {
        this.isnew = isnew;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var products = (Products) o;
        return isnew == products.isnew &&
                Objects.equals(productId, products.productId) &&
                Objects.equals(producttype, products.producttype);
    }

    public int hashCode() {
        return Objects.hash(productId, producttype, isnew);
    }

    @OneToMany(mappedBy = "productsByProductId")
    public Collection<OrderItems> getOrderItemsByProductId() {
        return orderItemsByProductId;
    }

    public void setOrderItemsByProductId(Collection<OrderItems> orderItemsByProductId) {
        this.orderItemsByProductId = orderItemsByProductId;
    }
}