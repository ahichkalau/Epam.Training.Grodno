package com.epam.thread.tunnelsSecond;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TrainThread extends Thread {
    Train train;
    Tunnel tunnel;
    Semaphore semaphore;

    public TrainThread(Train train, Tunnel tunnel, Semaphore semaphore) {
        this.semaphore = semaphore;
        this.train = train;
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tunnel.addTrainInTunnel(train);
        semaphore.release();
    }
}
