package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "food_categories")
public class FoodCategorie {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 255)
    private String category;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(nullable = false)
    private boolean active;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "foodcategorie", fetch = FetchType.LAZY)
    private List<Recipe> recipes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "foodcategorie", fetch = FetchType.LAZY)
    private List<MenuItem> menuitems;

    @PreRemove
    public void preRemove() {
        for (Recipe i : recipes) {
            i.setFoodcategorie(null);
        }

        for (MenuItem i : menuitems) {
            i.setFoodcategorie(null);
        }

    }

    public FoodCategorie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<MenuItem> getMenuitems() {
        return menuitems;
    }

    public void setMenuitems(List<MenuItem> menuitems) {
        this.menuitems = menuitems;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
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
        final FoodCategorie other = (FoodCategorie) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FoodCategorie{" + "id=" + id + ", category=" + category + ", active=" + active + '}';
    }

}
