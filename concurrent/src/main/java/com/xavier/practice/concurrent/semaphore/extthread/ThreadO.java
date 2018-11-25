package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;

public class ThreadO  extends  Thread{
    private BaseSemaphore service;
    public ThreadO(BaseSemaphore service) {
        this.service = service;
    }

    public void run() {
        System.out.println("Thread Name: " + this.getName() + " starts!");
        service.testMethod();
    }
}
