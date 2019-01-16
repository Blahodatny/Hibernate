package retail;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "public", catalog = "Retail_Service")
public class Order {
    private int orderNumber;
    private String toStreet;
    private String toCity;
    private Timestamp shipDate;
    private Customer customersByPhone;


    @Id
    @Column(name = "order_number", nullable = false)
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "toStreet", nullable = false, length = -1)
    public String getToStreet() {
        return toStreet;
    }

    public void setToStreet(String toStreet) {
        this.toStreet = toStreet;
    }

    @Basic
    @Column(name = "toCity", nullable = false, length = -1)
    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    @Basic
    @Column(name = "shipDate", nullable = false)
    public Timestamp getShipDate() {
        return shipDate;
    }

    public void setShipDate(Timestamp shipDate) {
        this.shipDate = shipDate;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var order = (Order) o;
        return orderNumber == order.orderNumber &&
                Objects.equals(toStreet, order.toStreet) &&
                Objects.equals(toCity, order.toCity) &&
                Objects.equals(shipDate, order.shipDate);
    }

    public int hashCode() {
        return Objects.hash(orderNumber, toStreet, toCity, shipDate);
    }

    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", toStreet='" + toStreet + '\'' +
                ", toCity='" + toCity + '\'' +
                ", shipDate=" + shipDate +
                ", customersByPhone=" + customersByPhone +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "phone", referencedColumnName = "phone", nullable = false)
    public Customer getCustomersByPhone() {
        return customersByPhone;
    }

    public void setCustomersByPhone(Customer customersByPhone) {
        this.customersByPhone = customersByPhone;
    }
}