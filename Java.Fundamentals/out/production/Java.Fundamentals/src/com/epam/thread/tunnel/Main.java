package com.epam.thread.tunnel;


import com.epam.thread.tunnelsSecond.TrainGenerator;
import com.epam.thread.tunnelsSecond.Upravlyaka;

import java.util.Random;
import java.util.RandomAccess;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        Random random = new Random();
        Tunnel tunnel = new Tunnel();

    }
}
