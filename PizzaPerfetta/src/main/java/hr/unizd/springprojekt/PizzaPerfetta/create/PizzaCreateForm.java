package hr.unizd.springprojekt.PizzaPerfetta.create;

import jakarta.validation.constraints.NotEmpty;

public class PizzaCreateForm {
    @NotEmpty(message = "Pizza must have picture")
    private String pizzaPhotoLink;
    @NotEmpty(message = "Pizza must have name")
    private String name;

    @NotEmpty(message = "Pizza must have at least 1 ingredient")
    private String ingredients;

    public String getName() {
        return name;
    }

    public String getPizzaPhotoLink() {
        return pizzaPhotoLink;
    }

    public void setPizzaPhotoLink(String pizzaPhotoLink) {
        this.pizzaPhotoLink = pizzaPhotoLink;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
