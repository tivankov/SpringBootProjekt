package hr.unizd.springprojekt.PizzaPerfetta.service;

import hr.unizd.springprojekt.PizzaPerfetta.create.PizzaCreateForm;
import hr.unizd.springprojekt.PizzaPerfetta.create.PizzaEditForm;
import hr.unizd.springprojekt.PizzaPerfetta.exeption.EntityNotFoundException;
import hr.unizd.springprojekt.PizzaPerfetta.model.Pizza;
import hr.unizd.springprojekt.PizzaPerfetta.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService{

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> fetchAll() {
        return pizzaRepository.fetchAll();
    }

    public Pizza fetchDetails(Integer id) {
        Optional<Pizza> pizzaDetails = pizzaRepository.fetchDetails(id);
        if (pizzaDetails.isEmpty()) {
            throw new EntityNotFoundException("Entity with id " + id + " not found!");
        }

        return pizzaDetails.get();
    }

    public List<Pizza> create(PizzaCreateForm pizzaCreateForm) {
        List<Pizza> pizzaList = pizzaRepository.fetchAll();

        Pizza pizza = new Pizza();
        pizza.setId(pizzaList.size() + 1);
        pizza.setName(pizzaCreateForm.getName());
        pizza.setIngredients(pizzaCreateForm.getIngredients());

        pizzaRepository.create(pizza);

        return pizzaRepository.fetchAll();
    }

    public List<Pizza> edit(PizzaEditForm pizzaEditForm) {
        Pizza pizza = fetchDetails(pizzaEditForm.getId());
        pizza.setName(pizzaEditForm.getName());
        pizza.setIngredients(pizzaEditForm.getIngredients());

        pizzaRepository.edit(pizza);

        return pizzaRepository.fetchAll();
    }


    public List<Pizza> delite(Integer id) {
        pizzaRepository.delete(id);
        return pizzaRepository.fetchAll();
    }
}
