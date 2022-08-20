package logic;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bill {
    private String number;

    private LocalDate dateBill;

    private ArrayList<Detail> details;

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

    public boolean addDetail(Detail detail ){

        if( detail.getCant()  <= (detail.getProduct().getStock() - detail.getProduct().getStockMin())){
            details.add( detail );
            //Actualizar las existencias (stock) del producto
            detail.getProduct().setStock( detail.getProduct().getStock() - detail.getCant() );

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
}
