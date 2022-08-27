package edu.udea.demo.entityes;

import java.util.ArrayList;

public class ListEdge {
    private String description;
    private ArrayList<Dish> list;

    public ListEdge(String description) {
        this.description = description;
        list = new ArrayList<>();
    }

    public Dish findDish( String name ){
        for ( Dish dish : list){
            if ( dish.getName().equals( name ) ){
                return dish;
            }
        }

        return null;
    }

    public boolean addDish( Dish dish){

        if ( findDish( dish.getName()) == null ){
            list.add( dish);

            return true;
        }

        return false;
    }

    public ArrayList<Dish> getList() {
        return (ArrayList<Dish>) list.clone();
    }
}
