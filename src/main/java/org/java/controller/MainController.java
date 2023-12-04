package org.java.controller;

import java.util.List;

import org.java.db.pojo.Pizza;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;

	private List<Pizza> getAllPizzas() {
		List<Pizza> pizzasList = pizzaService.findAll();

		return pizzasList;
	}

	@GetMapping("/")
	public String getPizzas(Model model, @RequestParam(required = false) String query) {

		List<Pizza> pizzas = query != null ? pizzaService.findByNameOrDescription(query) : getAllPizzas();

		model.addAttribute("query", query);
		model.addAttribute("pizzasList", pizzas);

		return "index-home";

	}

	@GetMapping("/pizza/create")
	public String viewForm(Model model) {

		Pizza pizza = new Pizza();

		model.addAttribute("pizza", pizza);

		return "create-update-form";
	}

	@PostMapping("/pizza/create")
	public String storePizza(Model model, @Valid @ModelAttribute Pizza pizza, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("pizza", pizza);
			return "create-update-form";
		}

		try {
			pizzaService.save(pizza);
		} catch (Exception e) {
			bindingResult.addError(
					new FieldError("pizza", "name", pizza.getName(), false, null, null, "This pizza already exists"));
			model.addAttribute("pizza", pizza);
			return "create-update-form";
		}

		return "redirect:/";
	}

	@GetMapping("/pizza/{id}")
	public String detailSong(Model model, @PathVariable int id) {

		// RECUPERO DAL DB LA PIZZA CERCADOLA CON IL ID PASSATO TRAMITE PARAMETRO AL
		// METODO
		Pizza p = pizzaService.findById(id);

		model.addAttribute("pizza", p);

		return "detail-pizza";

	}

	@PostMapping("/pizza/{id}")
	public String deletePizza(Model model, @ModelAttribute Pizza pizza) {

		System.out.println(pizza);

		return "index-home";
	}

}
