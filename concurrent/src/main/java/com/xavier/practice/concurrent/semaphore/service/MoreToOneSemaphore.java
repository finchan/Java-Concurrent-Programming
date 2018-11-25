package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class MoreToOneSemaphore extends BaseSemaphore {
    private ReentrantLock lock = new ReentrantLock();
    public MoreToOneSemaphore(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        try {
            semaphore.acquire();
            lock.lock();
            System.out.println("Thread Name: "+ Thread.currentThread().getName() + " starts");
            for(int i=0; i < 5; i++) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " prints " + (i+1));
            }
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("Thread Name: " + Thread.currentThread().getName() + " ends");
        }
    }
}
