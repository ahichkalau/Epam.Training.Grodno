package com.epam.thread.trainstation.parking;

import com.epam.thread.trainstation.car.CarThread;

import java.util.concurrent.LinkedBlockingDeque;

public class CarCreator extends Thread {
    public static LinkedBlockingDeque<CarThread> carList = new LinkedBlockingDeque<>();
    int quantityOfCars;

    public CarCreator(int quantityOfCars) {
        this.quantityOfCars = quantityOfCars;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantityOfCars; i++) {
            CarThread carThread = new CarThread();
            carThread.run();
            carList.add(carThread);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){

            }
        }
        System.out.println("Машин больше не будет");
    }
}
