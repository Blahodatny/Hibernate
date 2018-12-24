package project.retail;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "products", schema = "public", catalog = "Retail_Service")
public class Product {
    private String productId;
    private String productType;
    private boolean _new;

    @javax.persistence.Id
    @Column(name = "product_id", nullable = false, length = 20)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "productType", nullable = false, length = -1)
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "isNew", nullable = false)
    public boolean is_new() {
        return _new;
    }

    public void set_new(boolean _new) {
        this._new = _new;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var product = (Product) o;
        return _new == product._new &&
                Objects.equals(productId, product.productId) &&
                Objects.equals(productType, product.productType);
    }

    public int hashCode() {
        return Objects.hash(productId, productType, _new);
    }

    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productType='" + productType + '\'' +
                ", _new=" + _new +
                '}';
    }
}