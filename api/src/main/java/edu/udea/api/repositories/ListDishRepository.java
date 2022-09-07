package edu.udea.api.repositories;

import edu.udea.api.entities.ListDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListDishRepository extends JpaRepository<ListDish, Integer> {

}
