package com.epam.thread.trainstation.car;

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
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getCarID() {
        return carID;
    }

    public int getParkingTime() {
        return parkingTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setParkingTime(int parkingTime) {
        this.parkingTime = parkingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    @Override
    public String toString() {
        return "CarThread{" +
                "carBrand='" + carBrand + '\'' +
                '}';
    }
}
