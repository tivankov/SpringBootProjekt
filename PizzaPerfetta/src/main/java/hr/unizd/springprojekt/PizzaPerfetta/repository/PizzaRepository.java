package hr.unizd.springprojekt.PizzaPerfetta.repository;

import hr.unizd.springprojekt.PizzaPerfetta.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository {
    List<Pizza> fetchAll();

    Optional<Pizza> fetchDetails(Integer id);

    boolean create(Pizza pizza);

    void edit(Pizza pizza);

    void delete(Integer id);

}
