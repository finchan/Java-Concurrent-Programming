package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadO;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.FairSemaphore;

import java.util.concurrent.Semaphore;

public class RunFairSemaphore {
    public static void main(String[] args) {
        //Fair Semaphore
        Semaphore semaphore = new Semaphore(1, true);
        BaseSemaphore service = new FairSemaphore(semaphore);
        ThreadO [] threads = new ThreadO[4];
        for(int i=0; i<threads.length;i++) {
            threads[i] = new ThreadO(service);
            threads[i].start();
        }
    }
}
