package edu.udea.api.repositories;

import edu.udea.api.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {

}
