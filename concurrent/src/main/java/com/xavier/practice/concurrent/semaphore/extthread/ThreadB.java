package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.ASemaphore;

public class ThreadB extends Thread {
    private ASemaphore service;

    public ThreadB(ASemaphore service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
