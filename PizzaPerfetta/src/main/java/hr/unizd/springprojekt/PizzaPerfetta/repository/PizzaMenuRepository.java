package hr.unizd.springprojekt.PizzaPerfetta.repository;

import hr.unizd.springprojekt.PizzaPerfetta.model.Pizza;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PizzaMenuRepository implements PizzaRepository{

    private List<Pizza> pizzaList = new ArrayList<>(
            List.of(
                    new Pizza(1, "Margarita", "Tomato sauce, fresh mozzarella cheese, basil leaves, thin crust.", "margarita.jpg"),
                    new Pizza(2, "Pepperoni", "Tomato sauce, mozzarella cheese, pepperoni sausage, thick crust", "pepperoni.jpg"),
                    new Pizza(3, "Hawaiian", "Tomato sauce, mozzarella cheese, ham, pineapple chunks, thin crust.", "hawaiian.jpg"),
                    new Pizza(4, "BBQ Chicken", "Barbecue sauce base, cooked chicken, red onions, mozzarella cheese, thick crust", "bbqChicken.webp"),
                    new Pizza(5, "Vegetarian", "Tomato sauce, mozzarella cheese, bell peppers, onions, mushrooms, olives, thin crust", "vegetarian.jpg"),
                    new Pizza(6, "Meat Lovers", "Tomato sauce, mozzarella cheese, pepperoni, sausage, bacon, sometimes ham, thick crust", "meatLovers.jpg")
            )
    );

    public List<Pizza> fetchAll() {
        return pizzaList;
    }

    public Optional<Pizza> fetchDetails(Integer id) {
        Pizza foundPizza = null;
        for (Pizza pizza : pizzaList) {
            if (pizza.getId().equals(id)) {
                foundPizza = pizza;
                break;
            }
        }
        return Optional.ofNullable(foundPizza);
    }

    public boolean create(Pizza newPizza) {
        return pizzaList.add(newPizza);
    }

    public void edit(Pizza pizza) {
        int listIndex = fetchObjectListIndex(pizza.getId());
        pizzaList.set(listIndex, pizza);
    }

    public void delete(Integer id) {
        int listIndex = fetchObjectListIndex(id);
        pizzaList.remove(listIndex);
    }

    private Integer fetchObjectListIndex(Integer id) {
        int index = -1;

        for (int k = 0; k < pizzaList.size(); k++) {
            if (pizzaList.get(k).getId().equals(id)) {
                index = k;
                break;
            }
        }

        return index;
    }
}
