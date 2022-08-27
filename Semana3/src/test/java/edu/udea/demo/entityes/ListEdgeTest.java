package edu.udea.demo.entityes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListEdgeTest {

    private ListEdge listChiceken;
    private ListEdge listBeef;

    private void setup(){
        listChiceken = new ListEdge("Pollo");
        listChiceken.addDish( new Dish("Pollo Frito",false,360,28_000));
        listBeef = new ListEdge("Carnes");
        listBeef.addDish( new Dish("Bisteck",false,450,23_000));
    }

    @Test
    void findDish() {
        setup();
        assertNull(listBeef.findDish("Tomahowk"));
        assertNull(listChiceken.findDish("Pollo a la Cazadora"));
        assertNotNull(listBeef.findDish("Bisteck"));
        assertNotNull(listChiceken.findDish("Pollo Frito"));
    }

    @Test
    void addDish() {
        setup();
        assertFalse( listBeef.addDish( new Dish("Bisteck",false,450,23_000) ) );
        assertFalse( listChiceken.addDish( new Dish("Pollo Frito",false,450,23_000) ) );
        assertTrue( listBeef.addDish( new Dish("Tomahowk",false,500,78_000)));
        assertTrue( listChiceken.addDish( new Dish("Pollo a la Cazadora",false,340, 34_600)));
    }

    @Test
    void getList() {
        setup();
        assertEquals(1,listBeef.getList().size());
        assertEquals(1,listChiceken.getList().size());
        assertEquals("Bisteck",listBeef.getList().get(0).getName());
    }
}