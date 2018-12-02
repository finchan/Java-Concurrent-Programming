package com.xavier.practice.concurrent.exchange;

import java.util.concurrent.Exchanger;

public class Seller implements Runnable {
    private Exchanger<Exchangable> exchanger;
    private Exchangable book;
    public Seller(Exchanger<Exchangable> exchanger){
        this.exchanger = exchanger;
        this.book = new Book("Java Concurrency", 70);
    }

    public void run() {
        try {
            System.out.println("Hi, I am seller, I get " + exchanger.exchange(book));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
