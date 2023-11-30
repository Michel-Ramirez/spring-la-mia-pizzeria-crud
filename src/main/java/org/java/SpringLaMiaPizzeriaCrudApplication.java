package org.java;

import java.math.BigDecimal;

import org.java.db.pojo.Pizza;
import org.java.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		pizzaService.save(new Pizza("Capricciosa", "Prosciutto, funghi, carciofi",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("11.50")));

		pizzaService.save(new Pizza("Margherita", "Mozzarella, pomodoro, basilico",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("9.99")));

		pizzaService.save(new Pizza("Quattro Stagioni", "Prosciutto cotto, funghi, olive, carciofi",

				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("12.75")));

		pizzaService.save(new Pizza("Diavola", "Salsiccia piccante, peperoncino, cipolla",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("10.25")));

		pizzaService.save(new Pizza("Quattro Formaggi", "Mozzarella, gorgonzola, taleggio, parmigiano",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("13.20")));

		pizzaService.save(new Pizza("Napoletana", "Acciughe, capperi, olive",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("11.75")));

		pizzaService.save(new Pizza("Calzone", "Ripieno di mozzarella, ricotta, salame, pomodoro",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("10.99")));

		pizzaService.save(new Pizza("Hawaiian", "Prosciutto cotto, ananas", "https://picsum.photos/seed/picsum/700/500",
				new BigDecimal("10.50")));

		pizzaService.save(new Pizza("Vegetariana", "Peperoni, zucchine, melanzane, pomodoro",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("11.00")));

		pizzaService.save(new Pizza("Bianca", "Mozzarella, rosmarino, olio d'oliva",
				"https://picsum.photos/seed/picsum/700/500", new BigDecimal("9.75")));

	}

}
