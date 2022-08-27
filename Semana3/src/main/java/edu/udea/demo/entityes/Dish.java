package edu.udea.demo.entityes;

public class Dish {
    private String name;
    private boolean isVegetarian;
    private int calories;
    private double value;

    public Dish(String name, boolean isVegetarian, int calories, double value) {
        this.name = name;
        this.isVegetarian = isVegetarian;
        this.calories = calories;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", isVegetarian=" + isVegetarian +
                ", calories=" + calories +
                ", value=" + value +
                '}';
    }
}

