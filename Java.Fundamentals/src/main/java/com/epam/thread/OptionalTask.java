package com.epam.thread;

import java.util.concurrent.Semaphore;
/*В аэропорту есть 5 взлетно-посадочных полос. Самолету требуется 3 минуты чтобы выйти на полосу, набрать скорость и
взлететь. После этого полоса свободна для вылета следующего самолета. Реализовать симуляцию вылета 10 самолетов используя
все доступные полосы. 1 минуту реально времени заменить на 1 секунду в симуляции. Вывести в консоль информацию о следующих
событиях:

Самолет начал выход на полосу
Самолет взлетел
Полоса "приняла" самолет
Полоса освободилась*/

public class OptionalTask {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(5);
        for (int i = 1; i < 11; i++) {
            new Airplane(sem, i).start();
        }
    }
}

class Airplane extends Thread{
    Semaphore semaphore;
    int airplaneNumber;

    Airplane(Semaphore semaphore, int airplaneNumber){
        this.semaphore = semaphore;
        this.airplaneNumber = airplaneNumber;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Самолет " + airplaneNumber + " начал выход на полосу");
            sleep(1000);
            System.out.println("Полоса приняла самолет");
            sleep(1000);
            System.out.println("Самолет " + airplaneNumber + " взлетел");
            sleep(1000);
            System.out.println("Полоса освободилась");
            semaphore.release();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

