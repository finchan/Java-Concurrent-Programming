package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class SemaphoreAcquireInterruptibly extends BaseSemaphore {
    public SemaphoreAcquireInterruptibly(Semaphore semaphore) {
        super(semaphore);
    }

    public void testMethod() {
        semaphore.acquireUninterruptibly();
        System.out.println(Thread.currentThread().getName() + " begin timer = "
                + System.currentTimeMillis());
        for(int i=0; i<Integer.MAX_VALUE;i++) {
            String newString = new String();
            Math.random();
        }
        System.out.println(Thread.currentThread().getName() + " end timer = "
                + System.currentTimeMillis());
        semaphore.release();
    }
}
