package org.java.db.repo;

import java.util.List;

import org.java.db.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	List<Pizza> findByNameContainingIgnoreCase(String value);

}
