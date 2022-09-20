package edu.udea.api.controllers;

import edu.udea.api.entities.Dish;
import edu.udea.api.services.DishService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dishes")
public class DishController {
    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAll(){
        return dishService.getAllDishes();
    }

    @PostMapping
    public RedirectView addDish(@ModelAttribute Dish dish, Model model ){

        dishService.addDish( dish );

        return new RedirectView("/views/dishes");
    }
    /*public Dish addDish(@RequestBody Dish dish ){

        return dishService.addDish( dish );
    }*/


    @GetMapping("/{id}")
    public Dish findById(@PathVariable int id ){
        return dishService.findById( id );
    }

    @PutMapping("/{id}")
    public Dish updateDish(@RequestBody Dish dish ){

        if ( dishService.findById( dish.getId() ) != null ){
            return dishService.updateDish( dish );
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public RedirectView deleteDish(@PathVariable int id){

            Dish dish = dishService.findById( id );

            if( dish != null){
                dishService.deleteDish( dish );
            }

        return new RedirectView("/views/dishes");
    }
    /*public Dish deleteDish( @PathVariable int id ){

        Dish dish = dishService.findById( id );

        if( dish != null){
            dishService.deleteDish( dish );

            return dish;
        }

        return null;
    }*/

    @PatchMapping("/{id}")
    public RedirectView updateDish( @PathVariable int id, @ModelAttribute Dish dish, Model model ){

        System.out.println( dish );

        return null;
    }
}
