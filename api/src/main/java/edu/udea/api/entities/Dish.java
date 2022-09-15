package edu.udea.api.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="dishes")
public class Dish {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private short calories;

    @Column(nullable = false,name = "is_vegetarian")
    private boolean isVegetarian;

    private String image;

    @ManyToOne
    @JoinColumn(name = "ref_list",nullable = false, foreignKey = @ForeignKey(name="fk_list_dish",value = ConstraintMode.PROVIDER_DEFAULT))
    private ListDish listDish;

    public Dish() {
    }

    public Dish(int id, String name, double price, short calories, boolean isVegetarian, String image, ListDish listDish) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.isVegetarian = isVegetarian;
        this.image = image;
        this.listDish = listDish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public short getCalories() {
        return calories;
    }

    public void setCalories(short calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ListDish getListDish() {
        return listDish;
    }

    public void setListDish(ListDish listDish) {
        this.listDish = listDish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && Double.compare(dish.price, price) == 0 && name.equals(dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                ", isVegetarian=" + isVegetarian +
                ", listDish=" + listDish +
                '}';
    }
}
