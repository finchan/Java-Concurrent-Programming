package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.MoreToMoreSemaphore;

import java.util.concurrent.Semaphore;

public class RunMoreToMoreSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        BaseSemaphore service = new MoreToMoreSemaphore(semaphore);

        ThreadA[] threads = new ThreadA[3];
        for(int i=0; i < threads.length; i++) {
            threads[i] = new ThreadA(service);
            threads[i].start();
        }
    }
}
