package org.example;

import java.util.concurrent.Semaphore;

public class Ping implements Runnable{

    private Semaphore semaforoPing;
    private Semaphore semaforoPong;

    public Ping(Semaphore semaforoPing, Semaphore semaforoPong) {
        this.semaforoPing = semaforoPing;
        this.semaforoPong = semaforoPong;
    }

    @Override
    public synchronized void run() {

        for (int i = 0; i < 10; i++) {
            try {
                semaforoPing.acquire();
                System.out.println("org.example.Ping!");
                semaforoPong.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
