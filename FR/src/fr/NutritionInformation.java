package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "nutrition_informations")
public class NutritionInformation {

    @Id
    @Column(nullable = false, length = 255)
    private String id;

    @Column(nullable = false, length = 255)
    private String nutrition;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "nutritioninformation", fetch = FetchType.LAZY)
    private List<IngredientNutritionInformation> ingredient_nutrition_informations;

    @PreRemove
    public void preRemove() {
        for (IngredientNutritionInformation i : ingredient_nutrition_informations) {
            i.setNutritioninformation(null);
        }

    }

    public List<IngredientNutritionInformation> getIngredient_nutrition_informations() {
        return ingredient_nutrition_informations;
    }

    public void setIngredient_nutrition_informations(List<IngredientNutritionInformation> ingredient_nutrition_informations) {
        this.ingredient_nutrition_informations = ingredient_nutrition_informations;
    }

    public NutritionInformation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final NutritionInformation other = (NutritionInformation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NutritionInformation{" + "id=" + id + ", nutrition=" + nutrition + ", active=" + active + '}';
    }

}
