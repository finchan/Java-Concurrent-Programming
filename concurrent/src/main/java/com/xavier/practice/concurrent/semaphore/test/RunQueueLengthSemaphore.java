package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.QueueLengthSemaphore;

import java.util.concurrent.Semaphore;

public class RunQueueLengthSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        BaseSemaphore service = new QueueLengthSemaphore(semaphore);
        ThreadA[] threads = new ThreadA[4];
        for(int i = 0; i < 4; i++) {
            threads[i] = new ThreadA(service);
            threads[i].start();
        }
    }
}
