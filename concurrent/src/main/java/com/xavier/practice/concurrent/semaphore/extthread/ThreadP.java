package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.ProduceConsumeService;

public class ThreadP extends Thread {
    private ProduceConsumeService service;
    public ThreadP(ProduceConsumeService service) {
        this.service = service;
    }

    public void run() {
        service.set();
    }
}
