package com.epam.thread.trainstation;


public class Main {
    public static void main(String[] args) {

        CarCreator carCreator = new CarCreator(20);
        carCreator.start();
        new Parking(CarCreator.carList).start();
    }
}
