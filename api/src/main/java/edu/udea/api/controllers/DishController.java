package edu.udea.api.controllers;

import edu.udea.api.entities.Dish;
import edu.udea.api.services.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/dishes")
public class DishController {
    private DishService dishService;

    public DishController() {
        dishService = new DishService();
    }

    @GetMapping
    public ArrayList<Dish> getAll(){
        return dishService.getAll();
    }

    @GetMapping("/{id}")
    public Dish findById(@PathVariable int id ){
        return dishService.findById( id );
    }

    @PostMapping
    public Dish addDish(@RequestBody Dish dish ){

        return dishService.addDish( dish );
    }

    @PutMapping("/{id}")
    public Dish updateDish(@RequestBody Dish dish ){

        return dishService.updateDish( dish );
    }

    @DeleteMapping("/{id}")
    public Dish deleteDish( @PathVariable int id ){
        return dishService.deleteDish( id );
    }
}
