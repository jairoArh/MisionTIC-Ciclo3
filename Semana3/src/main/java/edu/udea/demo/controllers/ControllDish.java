package edu.udea.demo.controllers;

import edu.udea.demo.entityes.Dish;
import edu.udea.demo.services.ServiceDish;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllDish {
    private ServiceDish service;



    @GetMapping("/")
    public String getAllDish(){
        service = new ServiceDish();

        return service.getMenu().toString();
    }

    @GetMapping("/getDish")
    public String getFindByName(@RequestParam(value = "name", defaultValue = "") String name){
        service = new ServiceDish();

        Dish dish = service.findDish(name);

        if ( dish != null ){
            return dish.toString();
        }

        return null;

    }
}

