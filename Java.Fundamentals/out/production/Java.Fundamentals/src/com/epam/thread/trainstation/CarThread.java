package com.epam.thread.trainstation;

import java.util.Random;

public class CarThread extends Thread {
    String carBrand;
    int carID;
    int parkingTime;
    int waitingTime = 5;
    int startingTime;

    @Override
    public void run() {
        Random random = new Random();
        this.carBrand = CarBrand.values()[random.nextInt(CarBrand.values().length)].carBrandName;
        this.parkingTime = random.nextInt(23) + 1;
        this.carID = CarCount.carID++;
        this.startingTime = CarCount.timeFromStart;
    }

    @Override
    public String toString() {
        return "CarThread{" +
                "carBrand='" + carBrand + '\'' +
                '}';
    }
}
