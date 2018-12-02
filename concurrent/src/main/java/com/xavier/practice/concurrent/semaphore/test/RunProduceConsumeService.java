package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadCon;
import com.xavier.practice.concurrent.semaphore.extthread.ThreadP;
import com.xavier.practice.concurrent.semaphore.service.ProduceConsumeService;

//It doesn't work.... Need to re-program it!!!!
public class RunProduceConsumeService {
    public static void main(String[] args) throws InterruptedException {
        ProduceConsumeService service = new ProduceConsumeService();
        int threadsCount = 2;
        ThreadP[] tp = new ThreadP[threadsCount];
        ThreadCon[] tc = new ThreadCon[threadsCount];
        for(int i=0; i<threadsCount; i++) {
            tp[i] = new ThreadP(service);
            tc[i] = new ThreadCon(service);
        }
        Thread.sleep(2000);
        for(int i=0; i< threadsCount; i++) {
            tp[i].start();
            tc[i].start();
        }
    }

}
