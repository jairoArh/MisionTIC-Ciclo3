package edu.udea.api.controllers;

import edu.udea.api.entities.Dish;
import edu.udea.api.entities.ListDish;
import edu.udea.api.services.DishService;
import edu.udea.api.services.ListDishService;
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

    private DishService dishService;
    private ListDishService listDishService;

    public ControllerViews(DishService dishService, ListDishService listDishService) {
        this.dishService = dishService;
        this.listDishService = listDishService;
    }

    @GetMapping
    public String viewIndex(Model model){
        model.addAttribute("title","Página Principal");

        return "index";
    }

    @GetMapping("/listDishes")
    public String getListAll( Model model ){

        model.addAttribute("listDishes", listDishService.getAllListDish());
        model.addAttribute("title","Listado de Platos");

        return "listDishes";
    }

    @GetMapping("/dishes")
    public String dishes(Model model){
        model.addAttribute("title","Gestión de Platos");
        model.addAttribute("dishes",dishService.getAllDishes());

        return "dishes";
    }

}
