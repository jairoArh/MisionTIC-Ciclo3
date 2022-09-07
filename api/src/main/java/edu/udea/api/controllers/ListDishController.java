package edu.udea.api.controllers;

import edu.udea.api.entities.ListDish;
import edu.udea.api.services.ListDishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("listdishes")
public class ListDishController {

    private ListDishService listDishService;

    public ListDishController(ListDishService listDishService) {
        this.listDishService = listDishService;
    }

    @GetMapping
    public List<ListDish> getAllListDish(){
        return listDishService.getAllListDish();
    }

    @PostMapping
    public ListDish addListDish(@RequestBody ListDish listDish ){

        return listDishService.addListDish( listDish );

    }

    @GetMapping("/{id}")
    public ListDish findById( @PathVariable  int id ){

        return listDishService.findById( id );
    }
}
