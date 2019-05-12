package fr;

import javax.persistence.*;

@Entity
@Table(name = "ingredient_nutrition_informations")
public class IngredientNutritionInformation {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private double nutrition_amount;

    @Column(nullable = false)
    private double ingredient_amount;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Ingredient.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", nullable = true)
    private Ingredient ingredient;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = NutritionInformation.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "nutrion_information_id", referencedColumnName = "id", nullable = true)
    private NutritionInformation nutritioninformation;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Measurement.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "nutrition_unit", referencedColumnName = "id", nullable = true)
    private Measurement measurement_nutrition_unit;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Measurement.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_unit", referencedColumnName = "id", nullable = true)
    private Measurement measurement_ingredient_unit;

    public IngredientNutritionInformation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public NutritionInformation getNutritioninformation() {
        return nutritioninformation;
    }

    public void setNutritioninformation(NutritionInformation nutritioninformation) {
        this.nutritioninformation = nutritioninformation;
    }

    public double getNutrition_amount() {
        return nutrition_amount;
    }

    public void setNutrition_amount(double nutrition_amount) {
        this.nutrition_amount = nutrition_amount;
    }

    public double getIngredient_amount() {
        return ingredient_amount;
    }

    public void setIngredient_amount(double ingredient_amount) {
        this.ingredient_amount = ingredient_amount;
    }

    public Measurement getMeasurement_nutrition_unit() {
        return measurement_nutrition_unit;
    }

    public void setMeasurement_nutrition_unit(Measurement measurement_nutrition_unit) {
        this.measurement_nutrition_unit = measurement_nutrition_unit;
    }

    public Measurement getMeasurement_ingredient_unit() {
        return measurement_ingredient_unit;
    }

    public void setMeasurement_ingredient_unit(Measurement measurement_ingredient_unit) {
        this.measurement_ingredient_unit = measurement_ingredient_unit;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final IngredientNutritionInformation other = (IngredientNutritionInformation) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IngredientNutritionInformation{" + "id=" + id + '}';
    }

}
