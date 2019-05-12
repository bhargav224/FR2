package fr;

import javax.persistence.*;

@Entity
@Table(name="addresses")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 255)
    private String street_name;

    @Column(nullable = false, length = 255)
    private String city;

    @Column(nullable = false)
    private int zip_code;

    @Column(nullable = false, length = 255)
    private String state;

    @Column(nullable = false, length = 255)
    private String country;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = true)
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Address() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip_code() {
        return zip_code;
    }

    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    @Override
//    public String toString() {
//        return "{" + "\"id\":" + id + ", \"street_name\":" + "\""+street_name+"\"" + ", \"city\":" + "\""+city+"\"" + ",\"zip_code\":" + zip_code + ", \"state\":" + "\""+state +"\""+ ", \"country\":" + "\""+country+"\"" + ", \"groceryStore\":" + groceryStore.getId() + "}";
//    }
    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street_name=" + street_name + ", city=" + city + ", zip_code=" + zip_code + ", state=" + state + ", country=" + country + '}';
    }

}
