package edu.udea.api.services;

import edu.udea.api.entities.Dish;
import edu.udea.api.entities.ListDish;
import edu.udea.api.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    private DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes(){
        return dishRepository.findAll();
    }

    public Dish addDish( Dish dish ){
        return dishRepository.save( dish );
    }

    public Dish findById(int id ){
        Optional<Dish> optDish = dishRepository.findById( id );
        if( optDish.isPresent()){

            return optDish.get();
        }

        return null;
    }

    /***
     * Permite actualizar un objeto
     * Precondicion: El objeto existe
     * Poscondicion: si existe se modifica
     * @param dish referencia del objeto que se actualiza
     * @return objeto actualizado
     */
    public Dish updateDish( Dish dish ){
        return dishRepository.save( dish );
    }

    /***
     * Permite eliminar un objeto
     * precondicion: el objeto existe
     * Poscondicion: si existe se elimina
     * @param dish referencia del objeto que se elimina
     * @return objeto eliminado
     */
    public void deleteDish( Dish dish ){

        dishRepository.delete( dish );
    }
}
