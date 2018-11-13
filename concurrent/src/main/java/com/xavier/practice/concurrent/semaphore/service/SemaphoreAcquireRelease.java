package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class SemaphoreAcquireRelease extends BaseSemaphore {
    public SemaphoreAcquireRelease(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        try {
            semaphore.acquire(2);
            System.out.println(Thread.currentThread().getName() + " begin timer = "
                    + System.currentTimeMillis());
            int sleepValue = (int) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + " stops for "
                    + sleepValue/1000 + " seconds.");
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName() + " end timer = "
                    + System.currentTimeMillis());
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
