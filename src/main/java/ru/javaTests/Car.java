package ru.javaTests;

public class Car {
    private String brand;
    private int weight;
    private Boolean running;
    private Boolean sell;
    private CarOwner carOwner;

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public Car setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
        return this;
    }



    public static class CarOwner {
        private Boolean drunk;

        public Boolean getDrunk() {
            return drunk;
        }

        public CarOwner setDrunk(Boolean drunk) {
            if (drunk){
                System.out.println("Водитель бухой");
            }else {
                System.out.println("Водитель трезвый");
            }
            this.drunk = drunk;
            return this;
        }
    }


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

    public static int getPriceWithNDS20Prosent(int price) {
        System.out.print("Цена: ");
        return price / 120 * 20 + (price);
    }

    public Car() {

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
