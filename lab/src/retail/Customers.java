package retail;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customers {
    private String phone;
    private String firstname;
    private String lastname;
    private String street;
    private String city;
    private Collection<Orders> ordersByPhone;

    @Id
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var customers = (Customers) o;
        return Objects.equals(phone, customers.phone) &&
                Objects.equals(firstname, customers.firstname) &&
                Objects.equals(lastname, customers.lastname) &&
                Objects.equals(street, customers.street) &&
                Objects.equals(city, customers.city);
    }

    public int hashCode() {
        return Objects.hash(phone, firstname, lastname, street, city);
    }

    @OneToMany(mappedBy = "customersByPhone")
    public Collection<Orders> getOrdersByPhone() {
        return ordersByPhone;
    }

    public void setOrdersByPhone(Collection<Orders> ordersByPhone) {
        this.ordersByPhone = ordersByPhone;
    }
}