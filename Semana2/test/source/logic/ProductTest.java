package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getIVA() {
        Product jabon = new Product("3453","Jabon Rey",3500.0,400,(byte)5, TypeProduct.VIVERES);

        assertEquals(420, jabon.getIVA());
    }
}