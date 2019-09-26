package com.epam.thread.tunnelsSecond;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrainGenerator extends Upravlyaka implements Runnable{
    Random random = new Random();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Train train = new Train(random.nextBoolean(), random.nextInt(2), random.nextInt(1000));

            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (train.tunnelNumber == 0){
                TrainStation.arrayFirstTunnel.addLast(train);
            }

            if (train.tunnelNumber == 1){
                TrainStation.arraySecondTunnel.addLast(train);
            }
        }
    }
}

