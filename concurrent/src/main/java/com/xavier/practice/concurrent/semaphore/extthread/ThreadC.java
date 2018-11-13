package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;

public class ThreadC extends Thread {
    private BaseSemaphore service;

    public ThreadC(BaseSemaphore service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
