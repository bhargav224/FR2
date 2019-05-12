package fr;

import javax.persistence.*;

@Entity
@Table(name = "recipe_has_steps")
public class RecipeHasStep {

    @Id
    @GeneratedValue
    private int id;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Recipe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id", nullable = true)
    private Recipe recipe;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = RecipeStep.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_step_id", referencedColumnName = "id", nullable = true)
    private RecipeStep recipestep;

    public RecipeHasStep() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public RecipeStep getRecipestep() {
        return recipestep;
    }

    public void setRecipestep(RecipeStep recipestep) {
        this.recipestep = recipestep;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final RecipeHasStep other = (RecipeHasStep) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecipeHasStep{" + "id=" + id + '}';
    }

}
