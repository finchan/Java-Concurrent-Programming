package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.SemaphoreAcquireRelease;

import java.util.concurrent.Semaphore;

public class RunSemaphoreAcquireRelease {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        BaseSemaphore service = new SemaphoreAcquireRelease(semaphore);
        ThreadA[] threads = new ThreadA[10];
        for(int i = 0; i< threads.length; i++) {
            threads[i] = new ThreadA(service);
            threads[i].setName("Thread-" +(i+1));
            threads[i].start();
        }
    }
}
