package ru.javaTests;

public class Car {

    private String brand;
    private int weight;
    private Boolean running;
    private Boolean sell;

    public Boolean getSell() {
        return sell;
    }

    public void sellCar(Boolean sell) {
        this.sell = sell;
    }

    public Car(String brand, int weight, Boolean running) {
        this.brand = brand;
        this.weight = weight;
        this.running = running;
    }

    public static int getPriceWithNDS20Prosent(int price){
        System.out.print("Цена: ");
        return price / 120 * 20 + (price);
    }

    public Car(){

    }

    public String getBrand() {
        return brand;
    }

    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Car setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public Boolean getRunning() {
        return running;
    }

    public Car setRunning(Boolean running) {
        this.running = running;
        return this;
    }
}
