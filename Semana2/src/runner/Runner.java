package runner;

import logic.Product;
import logic.TypeProduct;

public class Runner {
    public static void main(String[] args) {
        Product jabon = new Product("3453","Jabon Rey",3500.0,400,(byte)5, TypeProduct.VIVERES);

        jabon.setTypeProduct( TypeProduct.LICORES);

        System.out.println("El valor del IVA es " + jabon.getIVA() );
    }
}
