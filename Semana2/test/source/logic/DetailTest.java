package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetailTest {
    Detail detail;
    Detail detail2;

    void setup(){
        Product jabon = new Product("3453","Jabon Rey",3500.0,400,(byte)5, TypeProduct.VIVERES);
        Product whisky = new Product("7654","Buchannas",120_000.0,35,(byte)2, TypeProduct.LICORES);

        detail = new Detail( jabon, (short)10 );
        detail2 = new Detail( whisky,(short)2);
    }

    @Test
    void getSubtotal() {
        setup();

        assertEquals( 35_000, detail.getSubtotal());
        assertEquals( 240_000,detail2.getSubtotal());
    }

    @Test
    void getIVA(){
        setup();

        assertEquals( 4200, detail.getIVA());
        assertEquals( 45_600,detail2.getIVA());
    }
}