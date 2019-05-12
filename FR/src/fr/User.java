package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean authenticated;

    @Column(nullable = false)
    private Date email_confirmation_sent_on;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean email_confirmed;

    @Column(nullable = false)
    private Date email_confirmed_on;

    @Column(nullable = false)
    private Date registered_on;

    @Column(nullable = false)
    private Date last_logged_in;

    @Column(nullable = false)
    private Date current_logged_in;

    @Column(nullable = false, length = 255)
    private String role;

    @Column(nullable = false, length = 255)
    private String fname;

    @Column(nullable = false, length = 255)
    private String mname;

    @Column(nullable = false, length = 255)
    private String lname;

    @Column(nullable = false, length = 255)
    private String photo;

    @Column(nullable = false)
    private long contact;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "invitedBy", fetch = FetchType.LAZY)
    private List<User> invites;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "invited_By", referencedColumnName = "id", nullable = true)
    private User invitedBy;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<InviteEmail> invite_emails;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id", nullable = true)
    private Restaurant restaurant;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<FootNote> footnotes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "share_by_userid", fetch = FetchType.LAZY)
    private List<ShareRecipe> shareByRecipes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "share_to_userid", fetch = FetchType.LAZY)
    private List<ShareRecipe> shareToRecipes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RecipeLike> recipe_likes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RecipeRating> recipe_ratings;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<RecipeComment> recipe_comments;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "rateByUser", fetch = FetchType.LAZY)
    private List<UserRating> rateByUserList;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "rateToUser", fetch = FetchType.LAZY)
    private List<UserRating> rateToUserList;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<InviteContact> invite_contacts;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private ChefProfile chefprofile;

    @PreRemove
    public void preRemove() {

        if (chefprofile != null) {
            chefprofile.setUser(null);
        }

        for (FootNote i : footnotes) {
            i.setUser(null);
        }

        for (ShareRecipe j : shareByRecipes) {
            j.setShare_by_userid(null);
        }

        for (ShareRecipe k : shareToRecipes) {
            k.setShare_to_userid(null);
        }

        for (RecipeLike l : recipe_likes) {
            l.setUser(null);
        }

        for (RecipeRating rr : recipe_ratings) {
            rr.setUser(null);
        }

        for (RecipeComment rc : recipe_comments) {
            rc.setUser(null);
        }

        for (UserRating urb : rateByUserList) {
            urb.setRateByUser(null);
        }
        for (UserRating urt : rateToUserList) {
            urt.setRateToUser(null);
        }

        for (InviteEmail i : invite_emails) {
            i.setUser(null);
        }

        for (InviteContact j : invite_contacts) {
            j.setUser(null);
        }

        for (User i : invites) {
            i.setInvitedBy(null);
        }

    }

    public List<User> getInvites() {
        return invites;
    }

    public void setInvites(List<User> invites) {
        this.invites = invites;
    }

    public User getInvitedBy() {
        return invitedBy;
    }

    public void setInvitedBy(User invitedBy) {
        this.invitedBy = invitedBy;
    }

    public ChefProfile getChefprofile() {
        return chefprofile;
    }

    public void setChefprofile(ChefProfile chefprofile) {
        this.chefprofile = chefprofile;
    }

    public List<InviteEmail> getInvite_emails() {
        return invite_emails;
    }

    public void setInvite_emails(List<InviteEmail> invite_emails) {
        this.invite_emails = invite_emails;
    }

    public List<FootNote> getFootnotes() {
        return footnotes;
    }

    public void setFootnotes(List<FootNote> footnotes) {
        this.footnotes = footnotes;
    }

    public List<ShareRecipe> getShareByRecipes() {
        return shareByRecipes;
    }

    public void setShareByRecipes(List<ShareRecipe> shareByRecipes) {
        this.shareByRecipes = shareByRecipes;
    }

    public List<ShareRecipe> getShareToRecipes() {
        return shareToRecipes;
    }

    public void setShareToRecipes(List<ShareRecipe> shareToRecipes) {
        this.shareToRecipes = shareToRecipes;
    }

    public List<RecipeLike> getRecipe_likes() {
        return recipe_likes;
    }

    public void setRecipe_likes(List<RecipeLike> recipe_likes) {
        this.recipe_likes = recipe_likes;
    }

    public List<RecipeRating> getRecipe_ratings() {
        return recipe_ratings;
    }

    public void setRecipe_ratings(List<RecipeRating> recipe_ratings) {
        this.recipe_ratings = recipe_ratings;
    }

    public List<RecipeComment> getRecipe_comments() {
        return recipe_comments;
    }

    public void setRecipe_comments(List<RecipeComment> recipe_comments) {
        this.recipe_comments = recipe_comments;
    }

    public List<InviteContact> getInvite_contacts() {
        return invite_contacts;
    }

    public void setInvite_contacts(List<InviteContact> invite_contacts) {
        this.invite_contacts = invite_contacts;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public List<UserRating> getRateByUserList() {
        return rateByUserList;
    }

    public void setRateByUserList(List<UserRating> rateByUserList) {
        this.rateByUserList = rateByUserList;
    }

    public List<UserRating> getRateToUserList() {
        return rateToUserList;
    }

    public void setRateToUserList(List<UserRating> rateToUserList) {
        this.rateToUserList = rateToUserList;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public Date getEmail_confirmation_sent_on() {
        return email_confirmation_sent_on;
    }

    public void setEmail_confirmation_sent_on(Date email_confirmation_sent_on) {
        this.email_confirmation_sent_on = email_confirmation_sent_on;
    }

    public boolean isEmail_confirmed() {
        return email_confirmed;
    }

    public void setEmail_confirmed(boolean email_confirmed) {
        this.email_confirmed = email_confirmed;
    }

    public Date getEmail_confirmed_on() {
        return email_confirmed_on;
    }

    public void setEmail_confirmed_on(Date email_confirmed_on) {
        this.email_confirmed_on = email_confirmed_on;
    }

    public Date getRegistered_on() {
        return registered_on;
    }

    public void setRegistered_on(Date registered_on) {
        this.registered_on = registered_on;
    }

    public Date getLast_logged_in() {
        return last_logged_in;
    }

    public void setLast_logged_in(Date last_logged_in) {
        this.last_logged_in = last_logged_in;
    }

    public Date getCurrent_logged_in() {
        return current_logged_in;
    }

    public void setCurrent_logged_in(Date current_logged_in) {
        this.current_logged_in = current_logged_in;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", authenticated=" + authenticated + ", email_confirmation_sent_on=" + email_confirmation_sent_on + ", email_confirmed=" + email_confirmed + ", email_confirmed_on=" + email_confirmed_on + ", registered_on=" + registered_on + ", last_logged_in=" + last_logged_in + ", current_logged_in=" + current_logged_in + ", role=" + role + ", fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", photo=" + photo + ", contact=" + contact + '}';
    }

}
