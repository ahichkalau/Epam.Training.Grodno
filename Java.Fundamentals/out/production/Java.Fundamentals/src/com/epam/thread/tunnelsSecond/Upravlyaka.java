package com.epam.thread.tunnelsSecond;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Upravlyaka implements Runnable{

    Train train;
    Tunnel tunnel;
    Semaphore semaphore;
    LinkedBlockingDeque<Train> arrayTrainStation;


    public Upravlyaka() {
    }

    public Upravlyaka(Tunnel tunnel, Semaphore semaphore, LinkedBlockingDeque<Train> arrayTrainStation) {
        this.arrayTrainStation = arrayTrainStation;
        this.tunnel = tunnel;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (!arrayTrainStation.isEmpty()){
            Train train = arrayTrainStation.getFirst();//получем первый элемент из массива
            arrayTrainStation.remove(train);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            new Thread(new TrainThread(train, tunnel, semaphore)).start();

            for (Train checkedTrain : arrayTrainStation) {
                if (train.trainDirection == checkedTrain.trainDirection){

                    new Thread(new TrainThread(checkedTrain, tunnel, semaphore)).start();

                    arrayTrainStation.remove(checkedTrain);

                }
            }
        }
    }
}




