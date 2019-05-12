package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @Column(nullable = false, length = 255)
    private String id;

    @Column(nullable = false, length = 255, name = "ingredient")
    private String ingredient;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
    private List<RecipeIngredient> recipe_ingredients;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
    private List<IngredientNutritionInformation> ingredient_nutrition_informations;

    @PreRemove
    public void preRemove() {
        for (RecipeIngredient i : recipe_ingredients) {
            i.setIngredient(null);
        }

        for (IngredientNutritionInformation k : ingredient_nutrition_informations) {
            k.setIngredient(null);
        }

    }

    public List<RecipeIngredient> getRecipe_ingredients() {
        return recipe_ingredients;
    }

    public void setRecipe_ingredients(List<RecipeIngredient> recipe_ingredients) {
        this.recipe_ingredients = recipe_ingredients;
    }

    public List<IngredientNutritionInformation> getIngredient_nutrition_informations() {
        return ingredient_nutrition_informations;
    }

    public void setIngredient_nutrition_informations(List<IngredientNutritionInformation> ingredient_nutrition_informations) {
        this.ingredient_nutrition_informations = ingredient_nutrition_informations;
    }

    public Ingredient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

  

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Ingredient other = (Ingredient) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient{" + "id=" + id + ", ingredient=" + ingredient + ", active=" + active + '}';
    }

}
