package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class SemaphoreReleaseToAddPermitCounts extends BaseSemaphore{
    public SemaphoreReleaseToAddPermitCounts(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod(){
        try {
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            System.out.println(semaphore.availablePermits());
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            semaphore.release();
            System.out.println(semaphore.availablePermits());
            semaphore.release(5);
            System.out.println(semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
