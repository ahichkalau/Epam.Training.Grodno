package com.epam.thread.trainstation.parking;

import com.epam.thread.trainstation.car.CarThread;


import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

public class Parking extends Thread{
    public LinkedBlockingDeque<CarThread> carsInTheParkingLot = new LinkedBlockingDeque<CarThread>();
    public LinkedBlockingDeque<CarThread> carsWaitingForParking = new LinkedBlockingDeque<CarThread>();
    public LinkedBlockingDeque<CarThread> carsLeftTheParkingLot = new LinkedBlockingDeque<CarThread>();
    static final int NUMBER_OF_PARKING_SPACES = 5;
    int freePlaces = NUMBER_OF_PARKING_SPACES;

    public Parking(LinkedBlockingDeque<CarThread> allCars) {
        carsWaitingForParking.addAll(allCars);
    }

    public void getResolution(CarThread carThread){
        if (freePlaces > 0){
            carsInTheParkingLot.add(carThread);
            freePlaces--;
            if (freePlaces >= 1){
            System.out.println("Машина " + carThread.getCarBrand() + " #" + carThread.getCarID() + " припарковалась на "
                    + carThread.getParkingTime() + " часов. Осталось " + freePlaces + " свободных мест");}
            else {
                System.out.println("Машина " + carThread.getCarBrand() + " #" + carThread.getCarID()
                        +  " припарковалась на " + carThread.getParkingTime() + " часов. Свободных мест не осталось");
            }
            carsWaitingForParking.remove(carThread);
            waitAndReleaseCar(1000);
        } else {
            waitAndReleaseCar(1000);
            if (freePlaces <= 0){
                Iterator<CarThread> carThreadIterator = carsWaitingForParking.iterator();
                while (carThreadIterator.hasNext()){
                    CarThread currentCarThread = carThreadIterator.next();
                    if (currentCarThread.getWaitingTime() <= 0){
                        System.out.println("Машина " + currentCarThread.getCarBrand() + " #" + carThread.getCarID()
                                + " не дождалась свободного места и уехала");
                        carsLeftTheParkingLot.add(currentCarThread);
                        carsWaitingForParking.remove(currentCarThread);
                    }
                }
            }

            if (freePlaces > 0){
                carsInTheParkingLot.add(carThread);
                freePlaces--;
                System.out.println("Машина " + carThread.getCarBrand() + " #" + carThread.getCarID()
                        + " припарковалась на " + carThread.getParkingTime() + " часов. Осталось "
                        + freePlaces + " свободных мест");
                carsLeftTheParkingLot.add(carThread);
                carsWaitingForParking.remove(carThread);
            }
        }
    }

    public void waitAndReleaseCar(int time){
        int releaseCount = time/1000;
        for (int i = 0; i < releaseCount; i++) {
            try {
                Thread.sleep(time/releaseCount);
                carReleaseWithOutParking();
                carReleaseAfterParking();
            } catch (InterruptedException e){
            }
        }

    }

    public void carReleaseAfterParking(){
        Iterator<CarThread> carThreadIterator = carsInTheParkingLot.iterator();
        while (carThreadIterator.hasNext()){
           CarThread currentCarThread = carThreadIterator.next();
           currentCarThread.setParkingTime(currentCarThread.getParkingTime() - 1);
            if (currentCarThread.getParkingTime() <= 0){
                System.out.println("Машина " + currentCarThread.getCarBrand() + " #" + currentCarThread.getCarID()
                        + " уехала после парковки");
                carsLeftTheParkingLot.add(currentCarThread);
                carsInTheParkingLot.remove(currentCarThread);
                freePlaces++;
            }
        }
    }

    public void carReleaseWithOutParking(){
        Iterator<CarThread> carThreadIterator = carsWaitingForParking.iterator();
        while (carThreadIterator.hasNext()){
            CarThread currentCarThread = carThreadIterator.next();
            currentCarThread.setWaitingTime(currentCarThread.getWaitingTime() - 1);
        }
    }


    @Override
    public void run() {
        while (CarCreator.carList.isEmpty()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
            }
        }

        while (!CarCreator.carList.isEmpty() || carsWaitingForParking.size() > 0){
            if (!CarCreator.carList.isEmpty()){
                carsWaitingForParking.add(CarCreator.carList.getFirst());
                getResolution(carsWaitingForParking.getFirst());
                CarCreator.carList.removeFirst();}
            else if (carsWaitingForParking.size() > 0){
                getResolution(carsWaitingForParking.getFirst());
            }
        }
    }
}
