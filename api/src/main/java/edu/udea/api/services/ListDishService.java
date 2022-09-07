package edu.udea.api.services;

import edu.udea.api.entities.Dish;
import edu.udea.api.entities.ListDish;
import edu.udea.api.repositories.ListDishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListDishService {
    private ListDishRepository listDishRepository;

    public ListDishService(ListDishRepository listDishRepository) {
        this.listDishRepository = listDishRepository;
    }

    public ListDish addListDish( ListDish listDish ){
        return listDishRepository.save( listDish );
    }

    public List<ListDish> getAllListDish(){
        return listDishRepository.findAll();
    }

    public ListDish findById( int id ){
        Optional<ListDish> optDish = listDishRepository.findById( id );
        if( optDish.isPresent()){

            return optDish.get();
        }

        return null;
    }

}
