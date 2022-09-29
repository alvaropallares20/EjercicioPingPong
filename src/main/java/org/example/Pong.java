package org.example;

import java.util.concurrent.Semaphore;

public class Pong implements Runnable{

    private Semaphore semaforoPing;
    private Semaphore semaforoPong;

    public Pong(Semaphore semaforoPing, Semaphore semaforoPong) {
        this.semaforoPing = semaforoPing;
        this.semaforoPong = semaforoPong;
    }

    @Override
    public synchronized void run() {

        for (int i = 0; i < 10; i++) {
            try {
                semaforoPong.acquire();
                System.out.println("org.example.Pong!");
                semaforoPing.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
