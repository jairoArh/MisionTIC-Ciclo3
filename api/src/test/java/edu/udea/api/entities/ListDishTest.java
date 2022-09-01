package edu.udea.api.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListDishTest {
    private ListDish listDish;

    private void setup(){
        listDish = new ListDish("Carnes");
        listDish.addDish( new Dish(10,"Carne a la Plancha",32_500.0,(short)320,false,null));
        listDish.addDish( new Dish(20,"Tomahawk",72_000.0,(short)500,false,null));
    }

    @Test
    void findDish() {
        setup();
        assertEquals(2, listDish.getList().size());
        assertNotNull( listDish.findDish( 10 ) );
        assertNotNull( listDish.findDish( 20 ) );
        assertNull( listDish.findDish( 30 ) );
        assertEquals("Tomahawk",listDish.findDish( 20 ).getName());
    }

    @Test
    void addDish() {
        listDish = new ListDish("Carnes");
        assertTrue( listDish.addDish( new Dish(10,"Carne a la Plancha",32_500.0,(short)320,false,null)));
        assertFalse( listDish.addDish( new Dish(10,"Tomahawk",72_000.0,(short)500,false,null)));
        assertTrue( listDish.addDish( new Dish(20,"Tomahawk",72_000.0,(short)500,false,null)));
    }

    @Test
    void updateDish() {
        setup();
        Dish dish = new Dish(10,"Bisteck a Caballo",23_000,(short)270,false,null);
        assertNotNull( listDish.updateDish( dish ) );
        assertEquals("Bisteck a Caballo",listDish.findDish( 10 ).getName());
        dish = new Dish(30,"Bisteck a lo Pobre",23_000,(short)270,false,null);
        assertNull( listDish.updateDish( dish ));
    }

    @Test
    void deleteDish() {
        setup();
        assertNotNull( listDish.deleteDish( listDish.findDish( 10 ) ) );
        assertEquals(1,listDish.getList().size());
        assertNotNull( listDish.deleteDish(listDish.findDish( 20 ) ) );
        assertEquals(0,listDish.getList().size());
    }
}