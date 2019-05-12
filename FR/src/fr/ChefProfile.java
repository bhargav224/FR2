package fr;

import javax.persistence.*;

@Entity
@Table(name = "chef_profiles")
public class ChefProfile {

    @Id
    @GeneratedValue
    private int chef_id;

    @Column(nullable = false, length = 255)
    private String photo;

    @Column(nullable = false, length = 255)
    private String website;

    @Column(nullable = false, length = 255)
    private String type;

    @Column(nullable = false, length = 255)
    private String speciality;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true, referencedColumnName = "id")
    private User user;

    public ChefProfile() {
    }

    public int getChef_id() {
        return chef_id;
    }

    public void setChef_id(int chef_id) {
        this.chef_id = chef_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.chef_id;
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
        final ChefProfile other = (ChefProfile) obj;
        if (this.chef_id != other.chef_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ChefProfile{" + "chef_id=" + chef_id + ", photo=" + photo + ", website=" + website + ", type=" + type + ", speciality=" + speciality + '}';
    }

}
