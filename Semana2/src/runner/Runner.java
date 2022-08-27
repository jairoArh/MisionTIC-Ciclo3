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

        //System.out.println("El valor del IVA es " + jabon.getIVA() );

        Bill bill = new Bill("324235", LocalDate.of(2020, Month.JULY,20));

        Product soap = new Product("3535","Jabón Rey",3500,320,(byte)20,TypeProduct.VIVERES);
        Product rice = new Product("7654","Arroz Diana",48_000.0,132,(byte)10,TypeProduct.VIVERES);
        Product whisky = new Product("3463","Buchannas",120_000,18,(byte)3,TypeProduct.LICORES);
        Product ron = new Product("7654","Ron Boyacá",65_000,30,(byte)5,TypeProduct.LICORES);
        Product ibuprofeno = new Product("3646","Ibuprofeno",12_500,76,(byte)10,TypeProduct.MEDICAMENTOS);


        bill.addDetail( new Detail( soap,(short)10 ));
        bill.addDetail( new Detail(ron,(short)5));
        bill.addDetail( new Detail(rice,(short)1));

        String[][] data = bill.printBill();

        System.out.printf("%-30s %5s %10s %8s %12s\n","DESCRIPCION","CANT.","V. UNIT.","IVA","SUBTTOTAL");
        System.out.println("=====================================================================================");
        for( int i = 0; i < data.length ; i++ ){
            System.out.printf("%-30s %5s %10s %8s %12s\n",data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]);
        }

    }
}
