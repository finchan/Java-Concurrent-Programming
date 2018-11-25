package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class FairSemaphore extends BaseSemaphore {
    public FairSemaphore(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
