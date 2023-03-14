package hr.unizd.springprojekt.PizzaPerfetta.service;

import hr.unizd.springprojekt.PizzaPerfetta.create.PizzaCreateForm;
import hr.unizd.springprojekt.PizzaPerfetta.create.PizzaEditForm;
import hr.unizd.springprojekt.PizzaPerfetta.model.Pizza;

import java.util.List;

public interface PizzaService {

    List<Pizza> fetchAll();
    Pizza fetchDetails(Integer id);
    List<Pizza> create(PizzaCreateForm pizzaCreateForm);
    List<Pizza> edit(PizzaEditForm pizzaEditForm);
    List<Pizza> delite(Integer ID);

}
