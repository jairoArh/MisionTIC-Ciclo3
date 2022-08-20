package logic;

public class Product {
    private String idProduct;
    private String description;
    private double value;
    private int stock;
    private byte stockMin;
    private TypeProduct typeProduct;

    public Product(String idProduct, String description, double value, int stock, byte stockMin, TypeProduct typeProduct) {
        this.idProduct = idProduct;
        this.description = description;
        this.value = value;
        this.stock = stock;
        this.stockMin = stockMin;
        this.typeProduct = typeProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public byte getStockMin() {
        return stockMin;
    }

    public void setStockMin(byte stockMin) {
        this.stockMin = stockMin;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public double getIVA(){

        return switch (typeProduct){
            case LICORES -> getValue() * 0.19;

            case VIVERES -> getValue() * 0.12;

            case MEDICAMENTOS -> getValue() * 0.14;

            default -> 0.0;
        };
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", stock=" + stock +
                ", stockMin=" + stockMin +
                ", typeProduct=" + typeProduct +
                '}';
    }
}
