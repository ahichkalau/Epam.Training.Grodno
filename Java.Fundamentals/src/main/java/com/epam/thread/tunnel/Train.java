package com.epam.thread.tunnel;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Train extends Thread{
    Tunnel tunnel;
    TrainDirection trainDirection;
    int trainNumber;
    int tunnelNumber;
    Semaphore semaphore;

    public Train(Tunnel tunnel, TrainDirection trainDirection, int trainNumber, int tunnelNumber, Semaphore semaphore) {
        this.tunnel = tunnel;
        this.trainDirection = trainDirection;
        this.trainNumber = trainNumber;
        this.tunnelNumber = tunnelNumber;
        this.semaphore = semaphore;
    }

    public TrainDirection getTrainDirection() {
        return trainDirection;
    }

    @Override
    public void run() {
        super.run();
    }
}
class TrainInTunnel extends Thread{
    Tunnel tunnel;
    TrainDirection trainDirection;
    Semaphore semaphore;
    int trainNumber;
    int tunnelNumber;

    public TrainInTunnel(int trainNumber, int tunnelNumber, Semaphore semaphore, TrainDirection trainDirection) {
        this.semaphore = semaphore;
        this.trainNumber = trainNumber;
        this.tunnelNumber = tunnelNumber;
        this.trainDirection = trainDirection;
    }

    @Override
    public void run() {
        try {
            if (this.trainDirection == trainDirection){

            TimeUnit.SECONDS.sleep(1);
            semaphore.acquire();
            System.out.println("Поезд " + trainNumber + " ожидает разрешения на въезд в туннель " + tunnelNumber);
            System.out.println("Поезд " + trainNumber + " въехал в туннель");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Поезд " + trainNumber + " выехал из туннеля");
            TimeUnit.SECONDS.sleep(1);
            semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
class TrainLeftTunnel extends Thread{
    Semaphore semaphore;
    int trainNumber;
    int tunnelNumber;

    public TrainLeftTunnel(int trainNumber, int tunnelNumber, Semaphore semaphore) {
        this.semaphore = semaphore;
        this.trainNumber = trainNumber;
        this.tunnelNumber = tunnelNumber;
    }
    @Override
    public void run() {
        
    }
}
