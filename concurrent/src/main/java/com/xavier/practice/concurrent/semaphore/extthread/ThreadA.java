package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.ASemaphore;

public class ThreadA extends Thread {
    private ASemaphore service;

    public ThreadA(ASemaphore service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
