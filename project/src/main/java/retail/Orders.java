package retail;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Orders {
    private int orderNumber;
    private String tostreet;
    private String tocity;
    private Timestamp shipdate;
    private Customers customersByPhone;

    @Id
    @Column(name = "order_number", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "tostreet", nullable = false, length = -1)
    public String getTostreet() {
        return tostreet;
    }

    public void setTostreet(String tostreet) {
        this.tostreet = tostreet;
    }

    @Basic
    @Column(name = "tocity", nullable = false, length = -1)
    public String getTocity() {
        return tocity;
    }

    public void setTocity(String tocity) {
        this.tocity = tocity;
    }

    @Basic
    @Column(name = "shipdate", nullable = false)
    public Timestamp getShipdate() {
        return shipdate;
    }

    public void setShipdate(Timestamp shipdate) {
        this.shipdate = shipdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderNumber == orders.orderNumber &&
                Objects.equals(tostreet, orders.tostreet) &&
                Objects.equals(tocity, orders.tocity) &&
                Objects.equals(shipdate, orders.shipdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, tostreet, tocity, shipdate);
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
