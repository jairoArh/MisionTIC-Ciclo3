package edu.udea.api.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ListDish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false, length = 30)
    private String description;

    /*
    @OneToOne
    @JoinColumn(name = "ref_list",nullable = false, foreignKey = @ForeignKey(name="fk_list_dish"))
    private Dish dish;
     */

    /*@OneToMany(mappedBy = "dish")
    @JoinColumn(name = "ref_list",nullable = false, foreignKey = @ForeignKey(name="fk_list_dish"))*
*/
    @Transient
    private List<Dish> list;

    public ListDish() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Dish> getList() {
        return (ArrayList<Dish>) list;
    }

    public void setList(List<Dish> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ListDish{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
