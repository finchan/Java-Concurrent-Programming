package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public abstract class ASemaphore {

    private Semaphore semaphore;

    public ASemaphore (Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void testMethod() {
        try{
            semaphore.acquire();
            //<----------------------------------------------------------
            System.out.println(Thread.currentThread().getName() +
                    " begin timer = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName()+
                    " end timer = " + System.currentTimeMillis());
            //---------------------------------------------------------->
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
