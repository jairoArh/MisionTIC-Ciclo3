package edu.udea.demo.services;

import edu.udea.demo.entityes.Dish;
import edu.udea.demo.entityes.ListEdge;

import java.util.ArrayList;

public class ServiceDish {
    private ListEdge menu;

    public ServiceDish() {
        menu = new ListEdge("Carnes");
        menu.addDish( new Dish("Bisteck",false,450,32_000));
        menu.addDish( new Dish("Tomahowk",false,560,72_000));
    }

    public Dish findDish( String name ){

        return menu.findDish( name );
    }

    public ArrayList<Dish> getMenu(){

        return (ArrayList<Dish>) menu.getList().clone();
    }
}
