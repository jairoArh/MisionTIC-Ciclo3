package runner;

import logic.Bill;
import logic.Detail;
import logic.Product;
import logic.TypeProduct;

import java.time.LocalDate;
import java.time.Month;

public class Runner {
    public static void main(String[] args) {
        Product jabon = new Product("3453","Jabon Rey",3500.0,400,(byte)5, TypeProduct.VIVERES);

        jabon.setTypeProduct( TypeProduct.LICORES);

        System.out.println("El valor del IVA es " + jabon.getIVA() );

        Bill bill = new Bill("324235", LocalDate.of(2020, Month.JULY,20));
        Product soap = new Product("3535","Jabón Rey",3500,320,(byte)20,TypeProduct.VIVERES);

        System.out.println(bill.addDetail( new Detail( soap,(short)100 ) ) );

        System.out.println( soap.getStock());
    }
}
