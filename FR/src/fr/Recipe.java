package fr;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "recipes")
public class Recipe {

//    @id means pk is not auto increment
    @Id
    @Column(length = 255)
    private String recipe_id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    private int prep_time;

    @Column(nullable = false)
    private int cook_time;

    @Column(nullable = false)
    private int ready_in;

    @Column(nullable = false)
    private int yields;

    @Column(nullable = false)
    private int calories_per_servings;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false, length = 255)
    private String video;

    @Column(nullable = false, columnDefinition = "boolean default true")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean published;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeHasStep> recipe_has_steps;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeImage> recipe_images;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Level.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", referencedColumnName = "id", nullable = true)
    private Level level;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Cusine.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "cusine_id", referencedColumnName = "id", nullable = true)
    private Cusine cusine;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id", nullable = true)
    private Course course;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(targetEntity = FoodCategorie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "Food_Categorie_id", referencedColumnName = "id", nullable = true)
    private FoodCategorie foodcategorie;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<MenuRecipe> menu_recipes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<FootNote> footnotes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeIngredient> recipe_ingredients;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<ShareRecipe> share_recipes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeLike> recipe_likes;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeRating> recipe_ratings;

    @org.hibernate.annotations.Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    private List<RecipeComment> recipe_comments;

    @PreRemove
    public void preRemove() {

        for (RecipeImage i : recipe_images) {
            i.setRecipe(null);
        }

        for (RecipeHasStep j : recipe_has_steps) {
            j.setRecipe(null);
        }

        for (MenuRecipe m : menu_recipes) {
            m.setRecipe(null);
        }

        for (FootNote n : footnotes) {
            n.setRecipe(null);
        }

        for (RecipeIngredient o : recipe_ingredients) {
            o.setRecipe(null);
        }

        for (ShareRecipe q : share_recipes) {
            q.setRecipe(null);
        }

        for (RecipeLike rl : recipe_likes) {
            rl.setRecipe(null);
        }

        for (RecipeRating rr : recipe_ratings) {
            rr.setRecipe(null);
        }

        for (RecipeComment rc : recipe_comments) {
            rc.setRecipe(null);
        }

    }

    public List<RecipeHasStep> getRecipe_has_steps() {
        return recipe_has_steps;
    }

    public void setRecipe_has_steps(List<RecipeHasStep> recipe_has_steps) {
        this.recipe_has_steps = recipe_has_steps;
    }

    public List<RecipeImage> getRecipe_images() {
        return recipe_images;
    }

    public void setRecipe_images(List<RecipeImage> recipe_images) {
        this.recipe_images = recipe_images;
    }

    public List<MenuRecipe> getMenu_recipes() {
        return menu_recipes;
    }

    public void setMenu_recipes(List<MenuRecipe> menu_recipes) {
        this.menu_recipes = menu_recipes;
    }

    public List<FootNote> getFootnotes() {
        return footnotes;
    }

    public void setFootnotes(List<FootNote> footnotes) {
        this.footnotes = footnotes;
    }

    public List<RecipeIngredient> getRecipe_ingredients() {
        return recipe_ingredients;
    }

    public void setRecipe_ingredients(List<RecipeIngredient> recipe_ingredients) {
        this.recipe_ingredients = recipe_ingredients;
    }

    public List<ShareRecipe> getShare_recipes() {
        return share_recipes;
    }

    public void setShare_recipes(List<ShareRecipe> share_recipes) {
        this.share_recipes = share_recipes;
    }

    public List<RecipeLike> getRecipe_likes() {
        return recipe_likes;
    }

    public void setRecipe_likes(List<RecipeLike> recipe_likes) {
        this.recipe_likes = recipe_likes;
    }

    public List<RecipeRating> getRecipe_ratings() {
        return recipe_ratings;
    }

    public void setRecipe_ratings(List<RecipeRating> recipe_ratings) {
        this.recipe_ratings = recipe_ratings;
    }

    public List<RecipeComment> getRecipe_comments() {
        return recipe_comments;
    }

    public void setRecipe_comments(List<RecipeComment> recipe_comments) {
        this.recipe_comments = recipe_comments;
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

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Cusine getCusine() {
        return cusine;
    }

    public void setCusine(Cusine cusine) {
        this.cusine = cusine;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(String recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(int prep_time) {
        this.prep_time = prep_time;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getCook_time() {
        return cook_time;
    }

    public void setCook_time(int cook_time) {
        this.cook_time = cook_time;
    }

    public int getReady_in() {
        return ready_in;
    }

    public void setReady_in(int ready_in) {
        this.ready_in = ready_in;
    }

    public int getYields() {
        return yields;
    }

    public void setYields(int yields) {
        this.yields = yields;
    }

    public int getCalories_per_servings() {
        return calories_per_servings;
    }

    public void setCalories_per_servings(int calories_per_servings) {
        this.calories_per_servings = calories_per_servings;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.recipe_id);
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
        final Recipe other = (Recipe) obj;
        if (!Objects.equals(this.recipe_id, other.recipe_id)) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "{" + "\"recipe_id\":" + "\""+recipe_id + "\""+", \"title\":" + "\""+title + "\""+", \"description\":" + "\""+description + "\""+", \"prep_time\":" + prep_time + ", \"cook_time\":" + cook_time + ", \"ready_in\":" + ready_in + ", \"yields\":" + yields + ", \"calories_per_servings\":" + calories_per_servings + ", \"chef_id\":" + chef_id + ", \"rating\":" + rating + ", \"amount\":" + amount + ", \"video\":" + video + "}";
//    }
    @Override
    public String toString() {
        return "Recipe{" + "recipe_id=" + recipe_id + ", title=" + title + ", description=" + description + ", prep_time=" + prep_time + ", cook_time=" + cook_time + ", ready_in=" + ready_in + ", yields=" + yields + ", calories_per_servings=" + calories_per_servings + ", rating=" + rating + ", amount=" + amount + ", video=" + video + ", published=" + published + '}';
    }

}
