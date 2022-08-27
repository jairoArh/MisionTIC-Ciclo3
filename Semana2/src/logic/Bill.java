package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
    private String number;

    private LocalDate dateBill;

    private ArrayList<Detail> details;

    private static String typePay = "EFECTIVO";

    public Bill(String number, LocalDate dateBill) {
        this.number = number;
        this.dateBill = dateBill;
        details = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDateBill() {
        return dateBill;
    }

    public void setDateBill(LocalDate dateBill) {
        this.dateBill = dateBill;
    }

    public ArrayList<Detail> getDetails() {
        return (ArrayList<Detail>) details.clone();
    }

    public static String getTypePay() {
        return typePay;
    }

    public boolean addDetail(Detail detail ){

        Product product = detail.getProduct();

        if( detail.getCant()  <= (product.getStock() - product.getStockMin())){
            details.add( detail );
            //Actualizar las existencias (stock) del producto
            product.setStock( product.getStock() - detail.getCant() );

            return true;
        }

        return false;
    }

    public double getTotal(){

        double total = 0.0;

        for( Detail detail : details ){
            total += detail.getSubtotal();
        }

        return total;

    }

    public double getIVA(){
        double total = 0.0;

        for( Detail detail : details ){
            total += detail.getIVA();
        }

        return total;
    }

    public String[][] printBill(){
        //Datos primitivos byte, short, int, long, float, double, boolean
        //Clases Wrapper Byte, Short, Integer, Long, Float, Double

        String[][] data = new String[details.size() + 1][5];

        int cont = 0;

        for( Detail detail : details ){
            data[cont][0] = detail.getProduct().getDescription();
            data[cont][1] = Short.toString( detail.getCant() );
            data[cont][2] = Double.toString( detail.getProduct().getValue());
            data[cont][3] = Double.toString( detail.getIVA());
            data[cont++][4] = Double.toString( detail.getSubtotal());
        }

        data[cont][0] = null;
        data[cont][1] = null;
        data[cont][2] = Double.toString( getIVA());
        data[cont][3] = Double.toString( getTotal());
        data[cont][4] = Double.toString( getIVA() + getTotal( ) );

        return data;
    }
}
