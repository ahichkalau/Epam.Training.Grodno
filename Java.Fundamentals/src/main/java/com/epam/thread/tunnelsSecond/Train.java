package com.epam.thread.tunnelsSecond;

import java.util.concurrent.Delayed;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Train extends Thread implements Delayed {
    Boolean trainDirection; // направление
    int tunnelNumber;
    int trainNumber;

    public Train(Boolean trainDirection, int tunnelNumber, int trainNumber) {
        this.trainDirection = trainDirection;
        this.tunnelNumber = tunnelNumber;
        this.trainNumber = trainNumber;
    }

    @Override
    public String toString() {
        return  "\n" + "Поезд{" +
                "направление" + trainDirection +
                ", номер туннеля" + tunnelNumber +
                ", номер поезда" + trainNumber +
                '}';
    }

    @Override
    public long getDelay(TimeUnit unit) {
          return 1;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
