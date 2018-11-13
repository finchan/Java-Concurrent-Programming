package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;

public class ThreadA extends Thread {
    private BaseSemaphore service;

    public ThreadA(BaseSemaphore service ) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
