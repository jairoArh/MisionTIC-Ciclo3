package edu.udea.api.controllers;

import edu.udea.api.entities.Dish;
import edu.udea.api.entities.ListDish;
import edu.udea.api.services.DishService;
import edu.udea.api.services.ListDishService;
import edu.udea.api.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
    private UserService userService;

    public ControllerViews(DishService dishService, ListDishService listDishService, UserService userService) {
        this.dishService = dishService;
        this.listDishService = listDishService;
        this.userService = userService;
    }

    @GetMapping
    public String viewIndex(Model model, @AuthenticationPrincipal OidcUser principal){

        if( principal != null ){
            System.out.println( principal.getClaims());
            model.addAttribute("title","Página Principal");
            model.addAttribute("nick",principal.getClaims().get("nickname"));

            userService.saveUser( principal.getClaims( ));

        }

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

    @GetMapping("/showForm")
    public String showForm( Model model ){
        model.addAttribute("title","Adicionar Plato");
        model.addAttribute("dish",new Dish());
        model.addAttribute("listDish", listDishService.getAllListDish());

        return "newDish";
    }

    @GetMapping("/{id}")
    public String updateDish(@PathVariable int id, Model model){

        model.addAttribute("title","Actualizar Plato");
        Dish dish = dishService.findById( id );
        model.addAttribute("id",id);
        model.addAttribute("dish",dish);
        model.addAttribute("listDish", listDishService.getAllListDish());

        return "updateDish";
    }

}
