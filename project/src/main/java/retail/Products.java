package retail;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Products {
    private String productId;
    private String producttype;
    private boolean isnew;

    @Id
    @Column(name = "product_id", nullable = false, length = 20)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "producttype", nullable = false, length = -1)
    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    @Basic
    @Column(name = "isnew", nullable = false)
    public boolean isIsnew() {
        return isnew;
    }

    public void setIsnew(boolean isnew) {
        this.isnew = isnew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return isnew == products.isnew &&
                Objects.equals(productId, products.productId) &&
                Objects.equals(producttype, products.producttype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, producttype, isnew);
    }
}
