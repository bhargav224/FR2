package fr;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "recipe_steps")
public class RecipeStep {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String instruction;

    @Column(nullable = false, length = 255)
    private String path;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipestep", fetch = FetchType.LAZY)
    private List<RecipeHasStep> recipe_has_steps;

    @PreRemove
    public void preRemove() {
        for (RecipeHasStep i : recipe_has_steps) {
            i.setRecipestep(null);
        }

    }

    public RecipeStep() {
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

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<RecipeHasStep> getRecipe_has_steps() {
        return recipe_has_steps;
    }

    public void setRecipe_has_steps(List<RecipeHasStep> recipe_has_steps) {
        this.recipe_has_steps = recipe_has_steps;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
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
        final RecipeStep other = (RecipeStep) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecipeStep{" + "id=" + id + ", name=" + name + ", instruction=" + instruction + ", path=" + path + '}';
    }

}
