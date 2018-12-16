package retail;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Orders {
    private int orderNumber;
    private String tostreet;
    private String tocity;
    private Timestamp shipdate;
    private Collection<OrderItems> orderItemsByOrderNumber;
    private Customers customersByPhone;

    @Id
    @Column(name = "order_number")
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "tostreet")
    public String getTostreet() {
        return tostreet;
    }

    public void setTostreet(String tostreet) {
        this.tostreet = tostreet;
    }

    @Basic
    @Column(name = "tocity")
    public String getTocity() {
        return tocity;
    }

    public void setTocity(String tocity) {
        this.tocity = tocity;
    }

    @Basic
    @Column(name = "shipdate")
    public Timestamp getShipdate() {
        return shipdate;
    }

    public void setShipdate(Timestamp shipdate) {
        this.shipdate = shipdate;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var orders = (Orders) o;
        return orderNumber == orders.orderNumber &&
                Objects.equals(tostreet, orders.tostreet) &&
                Objects.equals(tocity, orders.tocity) &&
                Objects.equals(shipdate, orders.shipdate);
    }

    public int hashCode() {
        return Objects.hash(orderNumber, tostreet, tocity, shipdate);
    }

    @OneToMany(mappedBy = "ordersByOrderNumber")
    public Collection<OrderItems> getOrderItemsByOrderNumber() {
        return orderItemsByOrderNumber;
    }

    public void setOrderItemsByOrderNumber(Collection<OrderItems> orderItemsByOrderNumber) {
        this.orderItemsByOrderNumber = orderItemsByOrderNumber;
    }

    @ManyToOne
    @JoinColumn(name = "phone", referencedColumnName = "phone", nullable = false)
    public Customers getCustomersByPhone() {
        return customersByPhone;
    }

    public void setCustomersByPhone(Customers customersByPhone) {
        this.customersByPhone = customersByPhone;
    }
}