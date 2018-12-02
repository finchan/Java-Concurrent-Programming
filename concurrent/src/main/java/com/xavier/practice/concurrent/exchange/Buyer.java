package com.xavier.practice.concurrent.exchange;

import java.util.concurrent.Exchanger;

public class Buyer implements Runnable {
    private Exchanger<Exchangable> exchanger;
    private Exchangable money;
    public Buyer(Exchanger<Exchangable> exchanger) {
        this.exchanger = exchanger;
        this.money = new Money(88);
    }
    public void run(){
        try {
            System.out.println("I am buyer, I get " + exchanger.exchange(money));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
