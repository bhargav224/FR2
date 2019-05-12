package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @Column(nullable = false, length = 255)
    private String id;

    @Column(nullable = false, length = 255)
    private String abbreviation;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "measurement", fetch = FetchType.LAZY)
    private List<RecipeIngredient> recipe_ingredients;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "measurement_nutrition_unit", fetch = FetchType.LAZY)
    private List<IngredientNutritionInformation> list_nutrition_unit;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "measurement_ingredient_unit", fetch = FetchType.LAZY)
    private List<IngredientNutritionInformation> list_ingredient_unit;

    @PreRemove
    public void preRemove() {

        for (RecipeIngredient k : recipe_ingredients) {
            k.setMeasurement(null);
        }

        for (IngredientNutritionInformation i : list_nutrition_unit) {
            i.setMeasurement_nutrition_unit(null);
        }

        for (IngredientNutritionInformation i : list_ingredient_unit) {
            i.setMeasurement_ingredient_unit(null);
        }
    }

    public List<IngredientNutritionInformation> getList_nutrition_unit() {
        return list_nutrition_unit;
    }

    public void setList_nutrition_unit(List<IngredientNutritionInformation> list_nutrition_unit) {
        this.list_nutrition_unit = list_nutrition_unit;
    }

    public List<IngredientNutritionInformation> getList_ingredient_unit() {
        return list_ingredient_unit;
    }

    public void setList_ingredient_unit(List<IngredientNutritionInformation> list_ingredient_unit) {
        this.list_ingredient_unit = list_ingredient_unit;
    }

    public Measurement() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<RecipeIngredient> getRecipe_ingredients() {
        return recipe_ingredients;
    }

    public void setRecipe_ingredients(List<RecipeIngredient> recipe_ingredients) {
        this.recipe_ingredients = recipe_ingredients;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Measurement other = (Measurement) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Measurement{" + "id=" + id + ", abbreviation=" + abbreviation + ", active=" + active + '}';
    }

}
