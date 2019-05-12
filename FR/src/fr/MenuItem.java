package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String image_path;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Cusine.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "cusine_id", referencedColumnName = "id", nullable = true)
    private Cusine cusine;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "menuitem", fetch = FetchType.LAZY)
    private List<MenuRecipe> menu_recipes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "menuitem", fetch = FetchType.LAZY)
    private List<RestaurantMenu> restaurant_menus;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = true)
    private Course course;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = FoodCategorie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "food_categorie_id", referencedColumnName = "id", nullable = true)
    private FoodCategorie foodcategorie;

    @PreRemove
    public void preRemove() {
        for (MenuRecipe i : menu_recipes) {
            i.setMenuitem(null);
        }

        for (RestaurantMenu j : restaurant_menus) {
            j.setMenuitem(null);
        }
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public FoodCategorie getFoodcategorie() {
        return foodcategorie;
    }

    public void setFoodcategorie(FoodCategorie foodcategorie) {
        this.foodcategorie = foodcategorie;
    }

    public List<MenuRecipe> getMenu_recipes() {
        return menu_recipes;
    }

    public void setMenu_recipes(List<MenuRecipe> menu_recipes) {
        this.menu_recipes = menu_recipes;
    }

    public List<RestaurantMenu> getRestaurant_menus() {
        return restaurant_menus;
    }

    public void setRestaurant_menus(List<RestaurantMenu> restaurant_menus) {
        this.restaurant_menus = restaurant_menus;
    }

    public MenuItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Cusine getCusine() {
        return cusine;
    }

    public void setCusine(Cusine cusine) {
        this.cusine = cusine;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final MenuItem other = (MenuItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "id=" + id + ", name=" + name + ", description=" + description + ", image_path=" + image_path + ", active=" + active + '}';
    }

}
