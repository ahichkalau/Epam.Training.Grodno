package com.epam.thread.tunnelsSecond;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //Создаем 2 туннеля
        Tunnel tunnel = new Tunnel(0);
        Tunnel tunnelFalse = new Tunnel(1);
        //Создаем семафор
        Semaphore semaphore = new Semaphore(2, true);
        //Создаем поезда
        Thread train = new Thread(new TrainGenerator());

        train.start();
        try {
            train.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(TrainStation.arrayFirstTunnel);
        Upravlyaka upravlyaka = new Upravlyaka(tunnel, semaphore, TrainStation.arrayFirstTunnel);
        new Thread(upravlyaka).start();


    }
}
