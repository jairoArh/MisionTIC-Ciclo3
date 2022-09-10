package edu.udea.api.controllers;

import edu.udea.api.entities.Dish;
import edu.udea.api.services.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/views")
public class ControllerViews {

    private static final int SOLTERO = 1;
    private static final int CASADO = 2;
    private static final int SEPARADO = 3;
    private static final int VIUDO = 4;
    private static final int UNION_LIBRE = 5;
    private static final int OTRO = 6;

    private int state;

    private DishService dishService;

    public ControllerViews(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public String viewIndex(){
        return "index";
    }

    @GetMapping("/tests/{age}")
    public String tests(@PathVariable(required = false) int age, Model model){

        Dish dish = dishService.findById(4);

        List<Dish> dishes = List.of( new Dish(20,"Bisteck",23000.0,(short)345, false,null,null),
                new Dish(3,"Pollo",45000,(short)100, true,null,null),
                new Dish(1,"Pescado",50000,(short)400, false,null,null));

        //List<Dish> aux = new ArrayList<>();

        model.addAttribute( "name","Simón José Antonio");
        model.addAttribute( "age",age);
        model.addAttribute( "gender",true);
        model.addAttribute( "state",7);
        model.addAttribute( "title","Ejemplo de Thymeleaf");
        model.addAttribute( "dish",dish);
        model.addAttribute( "dishes",dishes);

        return "tests";
    }
}
