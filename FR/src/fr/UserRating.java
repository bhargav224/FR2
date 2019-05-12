package fr;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "user_ratings")
public class UserRating {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private int rating;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_by_userid", referencedColumnName = "id", nullable = true)
    private User rateByUser;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_to_userid", referencedColumnName = "id", nullable = true)
    private User rateToUser;

    public UserRating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User getRateByUser() {
        return rateByUser;
    }

    public void setRateByUser(User rateByUser) {
        this.rateByUser = rateByUser;
    }

    public User getRateToUser() {
        return rateToUser;
    }

    public void setRateToUser(User rateToUser) {
        this.rateToUser = rateToUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
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
        final UserRating other = (UserRating) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserRating{" + "id=" + id + ", date=" + date + ", rating=" + rating + '}';
    }

}
