package ru.javaTests;


import static ru.javaTests.Car.getPriceWithNDS20Prosent;

public class CarParks {


    public static void main(String[] arg){
        Car car = new Car("BMW",1500,true);
        car.sellCar(true);
        System.out.println(getPriceWithNDS20Prosent(300000));
    }
}
