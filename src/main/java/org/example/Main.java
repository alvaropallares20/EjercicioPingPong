package org.example;

import java.util.concurrent.Semaphore;



public class Main {
    public static void main(String[] args) throws InterruptedException {

        Semaphore semaforoPing = new Semaphore(1);
        Semaphore semaforoPong = new Semaphore(1);
        semaforoPong.acquire();

        Thread hPing = new Thread(new Ping(semaforoPing, semaforoPong));
        Thread hPong = new Thread(new Pong(semaforoPing, semaforoPong));

        hPing.start();
        hPong.start();
    }
}