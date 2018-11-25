package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class MoreToMoreSemaphore extends BaseSemaphore {
    public MoreToMoreSemaphore(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println("Thread Name: "+ Thread.currentThread().getName() + " starts");
            for(int i=0; i < 5; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " prints " + (i+1));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " ends");
        }
    }
}
