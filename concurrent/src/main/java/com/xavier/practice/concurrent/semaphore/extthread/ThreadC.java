package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.ASemaphore;

public class ThreadC extends Thread {
    private ASemaphore service;

    public ThreadC(ASemaphore service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
