package org.java.controller;

import java.util.List;

import org.java.db.pojo.Pizza;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@Autowired
	private PizzaService pizzaService;

	private List<Pizza> getAllPizzas() {
		List<Pizza> pizzasList = pizzaService.findAll();

		return pizzasList;
	}

	@GetMapping("/")
	public String getPizzas(Model model) {

		List<Pizza> pizzas = getAllPizzas();

		model.addAttribute("pizzasList", pizzas);

		return "index-home";

	}

	@GetMapping("/pizza/{id}")
	public String detailSong(Model model, @PathVariable int id) {

		// TRASFORMO IL ID IN NUMERO
		int intId = Integer.valueOf(id);

		// RECUPERO TUTTE LE PIZZE
		List<Pizza> pizzasList = getAllPizzas();

		// ISTANZIO UN OGGETTO A NULL
		Pizza p = null;

		// GIRO SU TUTTE LE PIZZE E CONTROLLO, MATCHO IL ID DAL URL CON QUELLO NELLA
		// LISTA E ASSEGNO L'OGGETTO TROVATO IN MODO DA PASSARLO COME ATTRIBUTO
		for (Pizza pizza : pizzasList) {

			if (pizza.getId() == intId) {
				p = pizza;
			}
		}

		model.addAttribute("pizza", p);

		return "detail-pizza";

	}
}
