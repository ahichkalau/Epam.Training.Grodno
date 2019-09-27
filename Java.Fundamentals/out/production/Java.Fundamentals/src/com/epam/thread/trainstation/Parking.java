package com.epam.thread.trainstation;

import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

public class Parking extends Thread{
    public LinkedBlockingDeque<CarThread> carsInTheParkingLot = new LinkedBlockingDeque<>();
    public LinkedBlockingDeque<CarThread> carsWaitingForParking = new LinkedBlockingDeque<>();
    public LinkedBlockingDeque<CarThread> carsLeftTheParkingLot = new LinkedBlockingDeque<>();
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
            System.out.println("Машина " + carThread.carBrand + " #" + carThread.carID + " припарковалась на "
                    + carThread.parkingTime + " часов. Осталось " + freePlaces + " свободных мест" + carThread.startingTime);}
            else {
                System.out.println("Машина " + carThread.carBrand + " #" + carThread.carID
                        +  " припарковалась на " + carThread.parkingTime + " часов. Свободных мест не осталось" + carThread.startingTime);
            }
            carsWaitingForParking.remove(carThread);
            waitAndReleaseCar(1000);
        } else {
            waitAndReleaseCar(1000);
            if (freePlaces <= 0){
                Iterator<CarThread> carThreadIterator = carsWaitingForParking.iterator();
                while (carThreadIterator.hasNext()){
                    CarThread currentCarThread = carThreadIterator.next();
                    if (currentCarThread.waitingTime <= 0){
                        System.out.println("Машина " + currentCarThread.carBrand + " #" + carThread.carID
                                + " не дождалась свободного места и уехала" + carThread.startingTime);
                        carsLeftTheParkingLot.add(currentCarThread);
                        carsWaitingForParking.remove(currentCarThread);
                    }
                }
            }

            if (freePlaces > 0){
                carsInTheParkingLot.add(carThread);
                System.out.println("Машина " + carThread.carBrand + " #" + carThread.carID
                        + " припарковалась на " + carThread.parkingTime + " часов. Осталось " + freePlaces + " свободных мест" + carThread.startingTime);
                freePlaces--;
                carsLeftTheParkingLot.add(carThread);
                carsWaitingForParking.remove(carThread);
            }
        }
    }

    public void waitAndReleaseCar(int time){
        System.out.println(CarCount.timeFromStart++);
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
           currentCarThread.parkingTime--;
            if (currentCarThread.parkingTime <= 0){
                System.out.println("Машина " + currentCarThread.carBrand + " #" + currentCarThread.carID
                        + " уехала после парковки" + currentCarThread.startingTime);
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
            currentCarThread.waitingTime--;
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
