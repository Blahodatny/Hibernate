package retail;

import javax.persistence.Column;
import javax.persistence.Basic;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "customers", schema = "public", catalog = "Retail_Service")
public class Customer {
    private String phone;
    private String firstName;
    private String lastName;
    private String street;
    private String city;

    public Customer(String phone, String firstName, String lastName, String street, String city) {
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
    }

    public Customer() {
    }

    @javax.persistence.Id
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "firstName", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "street", length = -1)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "city", nullable = false, length = -1)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var customer = (Customer) o;
        return Objects.equals(phone, customer.phone) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(city, customer.city);
    }

    public int hashCode() {
        return Objects.hash(phone, firstName, lastName, street, city);
    }

    public String toString() {
        return "Customer{" +
                "phone='" + phone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}