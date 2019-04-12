package retail;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders", schema = "public", catalog = "Retail_Service")
public class Order {
    private Long id;
    private String toStreet;
    private String toCity;
    private Timestamp shipDate;
    private Collection<OrderItem> orderItemsById;
    private Customer customersByPhone;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "to_street", nullable = false, length = -1)
    public String getToStreet() {
        return toStreet;
    }

    public void setToStreet(String toStreet) {
        this.toStreet = toStreet;
    }

    @Basic
    @Column(name = "to_city", nullable = false, length = -1)
    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @Basic
    @Column(name = "ship_date", nullable = false)
    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        var order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(toStreet, order.toStreet) &&
                Objects.equals(toCity, order.toCity) &&
                Objects.equals(shipDate, order.shipDate);
    }

    public int hashCode() {
        return Objects.hash(id, toStreet, toCity, shipDate);
    }

    public String toString() {
        return "Order{" +
                "id=" + id +
                ", toStreet='" + toStreet + '\'' +
                ", toCity='" + toCity + '\'' +
                ", shipDate=" + shipDate +
                '}';
    }

    @OneToMany(mappedBy = "orderByOrderId")
    public Collection<OrderItem> getOrderItemsById() {
        return orderItemsById;
    }

    public void setOrderItemsById(Collection<OrderItem> orderItemsById) {
        this.orderItemsById = orderItemsById;
    }

    @ManyToOne
    @JoinColumn(name = "phone", referencedColumnName = "phone",
            nullable = false)
    public Customer getCustomersByPhone() {
        return customersByPhone;
    }

    public void setCustomersByPhone(Customer customersByPhone) {
        this.customersByPhone = customersByPhone;
    }
}