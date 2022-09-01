package edu.udea.api.entities;

import java.util.ArrayList;

public class ListDish {
    private String description;

    private ArrayList<Dish> list;

    public ListDish(String description) {
        this.description = description;
        list = new ArrayList<>();
    }

    public Dish findDish( int id ){

        for ( Dish dish : list ){
            if ( Integer.compare( dish.getId(), id ) == 0 ){
                return dish;
            }
        }

        return null;
    }

    public boolean addDish( Dish dish ){

        if( findDish( dish.getId( ) ) == null ){
            list.add( dish );

            return true;
        }

        return false;
    }

    public Dish updateDish( Dish dish ){

        Dish dishAux = findDish( dish.getId());
        if( dishAux != null ){
            list.set( list.indexOf( dishAux), dish );

            return list.get( list.indexOf( dish ) );
        }

        return null;
    }

    public Dish deleteDish( Dish dish ){

        if ( list.contains( dish ) ){
            list.remove( dish );

            return dish;
        }

        return null;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Dish> getList() {
        return (ArrayList<Dish>) list.clone();
    }
}
