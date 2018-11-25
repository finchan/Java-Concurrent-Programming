package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class QueueLengthSemaphore extends BaseSemaphore {
    public QueueLengthSemaphore(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("There are " + semaphore.getQueueLength() + " threads are waiting for.");
            System.out.println("Is there a thread waiting for the signal?\t\t" + semaphore.hasQueuedThreads());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }
}
