package edu.udea.api.services;

import edu.udea.api.entities.Dish;
import edu.udea.api.entities.ListDish;

import java.util.ArrayList;

public class DishService {
    private ListDish listDish;

    public DishService() {
        listDish = new ListDish("Carnes");
    }

    public ArrayList<Dish> getAll(){
        return listDish.getList();
    }

    public Dish findById( int id ){
        return listDish.findDish( id );
    }

    public Dish addDish( Dish dish ){
        return listDish.addDish( dish ) ? dish : null;
    }

    public Dish updateDish( Dish dish ){
        return listDish.updateDish( dish );
    }

    public Dish deleteDish( int id ){

        return listDish.deleteDish( listDish.findDish( id ) );
    }
}
