package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "levels")
public class Level {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean active;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
    private List<Recipe> recipes;

    @PreRemove
    public void preRemove() {

        for (Recipe i : recipes) {
            i.setLevel(null);
        }

    }

    public Level() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final Level other = (Level) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Level{" + "id=" + id + ", description=" + description + ", active=" + active + '}';
    }

}
