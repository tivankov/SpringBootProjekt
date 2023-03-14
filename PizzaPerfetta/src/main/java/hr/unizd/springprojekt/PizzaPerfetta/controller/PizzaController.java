package hr.unizd.springprojekt.PizzaPerfetta.controller;

import hr.unizd.springprojekt.PizzaPerfetta.create.PizzaCreateForm;
import hr.unizd.springprojekt.PizzaPerfetta.create.PizzaEditForm;
import hr.unizd.springprojekt.PizzaPerfetta.model.Pizza;
import hr.unizd.springprojekt.PizzaPerfetta.service.PizzaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("pizzas")
    public String fatchAll(Model model) {
        model.addAttribute("pizzaList", pizzaService.fetchAll());
        return "pizzaPerfettaPage";
    }

    @GetMapping("/pizzas/{id}")
    public String fetchDetails(Model model, @PathVariable Integer id) {
        Pizza pizza = pizzaService.fetchDetails(id);
        model.addAttribute("pizzaDetails", pizza);

        return "pizzaAdmin";
    }

    @GetMapping("/pizzas/create")
    public String fetchCreate(Model model) {
        model.addAttribute("pizza", new Pizza());

        return "pizzaCreate";
    }

    @PostMapping("/pizzas")
    public String create(@ModelAttribute(name = "pizza") @Valid PizzaCreateForm pizza, BindingResult validationInformation) {
        if (validationInformation.hasErrors()) {
            return "pizzaCreate";
        }
        pizzaService.create(pizza);

        return "redirect:/pizzas";
    }


    @GetMapping("pizzas/edit/{id}")
    public String fetchEdit(Model model, @PathVariable Integer id) {
        Pizza pizza = pizzaService.fetchDetails(id);
        model.addAttribute("pizza", pizza);

        return "pizzaEdit";
    }

    @PostMapping("/pizza/edit")
    public String edit(@ModelAttribute(name="pizza") @Valid PizzaEditForm pizza, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return "pizzaEdit";
        }

        pizzaService.edit(pizza);

        return "redirect:/pizzass";
    }

    @GetMapping("/pizzas/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pizzaService.delite(id);

        return "redirect:/pizzas";
    }

}