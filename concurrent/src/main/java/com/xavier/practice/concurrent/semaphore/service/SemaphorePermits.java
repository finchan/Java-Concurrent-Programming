package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;

public class SemaphorePermits extends BaseSemaphore {
    public SemaphorePermits(Semaphore semaphore) {
        super(semaphore);
    }

}
