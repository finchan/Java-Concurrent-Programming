package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.ProduceConsumeService;

public class ThreadCon extends  Thread{
    private ProduceConsumeService service;
    public ThreadCon(ProduceConsumeService service) {
        this.service = service;
    }
    public void run() {
        service.get();
    }
}
