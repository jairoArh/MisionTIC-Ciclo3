package logic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {
    private Bill bill;
    private Product soap;
    private Product whisky;
    private Product ibuprofeno;
    private Product rice;
    private Product ron;

    void setup(){
        bill = new Bill("34534", LocalDate.of(2019, Month.JANUARY,30));

        soap = new Product("3535","Jabón Rey",3500,320,(byte)20,TypeProduct.VIVERES);
        rice = new Product("7654","Arroz Diana",48_000.0,132,(byte)10,TypeProduct.VIVERES);
        whisky = new Product("3463","Buchannas",120_000,18,(byte)3,TypeProduct.LICORES);
        ron = new Product("7654","Ron Boyacá",65_000,30,(byte)5,TypeProduct.LICORES);
        ibuprofeno = new Product("3646","Ibuprofeno",12_500,76,(byte)10,TypeProduct.MEDICAMENTOS);
    }

    @Test
    void addDetail() {
        setup();
        assertTrue(bill.addDetail( new Detail( soap,(short)2 )));
        assertTrue(bill.addDetail( new Detail(ron,(short)25)));
        assertFalse( bill.addDetail( new Detail(rice,(short)130)));
        assertEquals( 318,soap.getStock());
        assertEquals( 5,ron.getStock());
    }

    @Test
    void getTotal() {
        setup();
        assertTrue(bill.addDetail( new Detail( soap,(short)10 )));
        assertTrue(bill.addDetail( new Detail(ron,(short)5)));
        assertFalse( bill.addDetail( new Detail(rice,(short)130)));
        assertEquals(2, bill.getDetails().size());
        assertEquals(360_000, bill.getTotal());
    }

    @Test
    void getIVA(){
        setup();
        bill.addDetail( new Detail( soap,(short)10 ));
        bill.addDetail( new Detail(ron,(short)5));
        bill.addDetail( new Detail(rice,(short)1));
        assertEquals(71_710, bill.getIVA());
    }
}