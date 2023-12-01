package org.java.controller;

import java.util.List;

import org.java.db.pojo.Pizza;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

		System.out.println(query);

		List<Pizza> pizzas = query != null ? pizzaService.findByName(query) : getAllPizzas();

		model.addAttribute("pizzasList", pizzas);

		return "index-home";

	}

	@GetMapping("/pizza/{id}")
	public String detailSong(Model model, @PathVariable int id) {

		// RECUPERO DAL DB LA PIZZA CERCADOLA CON IL ID PASSATO TRAMITE PARAMETRO AL
		// METODO
		Pizza p = pizzaService.findById(id);

		model.addAttribute("pizza", p);

		return "detail-pizza";

	}
}
