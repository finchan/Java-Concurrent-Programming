package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class SemaphoreDrainPermits extends BaseSemaphore {
    public SemaphoreDrainPermits(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        try {
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + "\t" + semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + "\t" + semaphore.availablePermits());
            System.out.println(semaphore.drainPermits() + "\t" + semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
