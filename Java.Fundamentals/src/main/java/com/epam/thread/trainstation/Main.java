package com.epam.thread.trainstation;


import com.epam.thread.trainstation.parking.CarCreator;
import com.epam.thread.trainstation.parking.Parking;

public class Main {
    public static void main(String[] args) {

        CarCreator carCreator = new CarCreator(20);
        carCreator.start();
        new Parking(CarCreator.carList).start();
    }
}
