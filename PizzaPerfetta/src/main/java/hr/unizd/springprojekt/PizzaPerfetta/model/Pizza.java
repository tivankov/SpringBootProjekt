package hr.unizd.springprojekt.PizzaPerfetta.model;

public class Pizza {

    private Integer id;
    private String name;
    private String ingredients;
    private String PizzaPictureLocation;

    public Pizza() {
    }

    public Pizza(Integer id, String name, String ingredients, String PizzaPictureLocation) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.PizzaPictureLocation = PizzaPictureLocation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getPizzaPictureLocation() {
        return PizzaPictureLocation;
    }

    public void setPizzaPictureLocation(String pizzaPictureLocation) {
        this.PizzaPictureLocation = pizzaPictureLocation;
    }
}