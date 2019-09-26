package com.epam.thread.tunnelsSecond;


import java.util.concurrent.*;

public class Tunnel {
    int number;
    ArrayBlockingQueue<Train> trainsInTunnel = new ArrayBlockingQueue(3);

    public Tunnel(int number) {
        this.number = number;
    }

    public void addTrainInTunnel(Train train) {
        if (trainsInTunnel.size() == 3) {
            System.out.println(Thread.currentThread());

            System.out.println("Отправляются поезда ");
            for (Train checkedTrain : trainsInTunnel) {
                System.out.println("Чух-чух поезд №" + checkedTrain.trainNumber);
                try {
                    TimeUnit.MILLISECONDS.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Поезда прибыли к месту назначения, формирование новой колонны");
            trainsInTunnel.clear();

        } else if (trainsInTunnel.size() < 3) {
            try {
                System.out.println("К колонне добавлен поезд №" + train.trainNumber);
                trainsInTunnel.add(train);
                TimeUnit.MILLISECONDS.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




