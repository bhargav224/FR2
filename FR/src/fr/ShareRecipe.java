package fr;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "share_recipes")
public class ShareRecipe {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Date date;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "share_by_userid", referencedColumnName = "id", nullable = true)
    private User share_by_userid;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "share_to_userid", referencedColumnName = "id", nullable = true)
    private User share_to_userid;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id", nullable = true)
    private Recipe recipe;

    public ShareRecipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getShare_by_userid() {
        return share_by_userid;
    }

    public void setShare_by_userid(User share_by_userid) {
        this.share_by_userid = share_by_userid;
    }

    public User getShare_to_userid() {
        return share_to_userid;
    }

    public void setShare_to_userid(User share_to_userid) {
        this.share_to_userid = share_to_userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
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
        final ShareRecipe other = (ShareRecipe) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ShareRecipe{" + "id=" + id + ", date=" + date + '}';
    }

}
