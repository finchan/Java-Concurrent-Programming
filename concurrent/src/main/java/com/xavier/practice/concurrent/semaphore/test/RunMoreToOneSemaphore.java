package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.MoreToMoreSemaphore;
import com.xavier.practice.concurrent.semaphore.service.MoreToOneSemaphore;

import java.util.concurrent.Semaphore;

public class RunMoreToOneSemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        BaseSemaphore service = new MoreToOneSemaphore(semaphore);

        ThreadA[] threads = new ThreadA[3];
        for(int i=0; i < threads.length; i++) {
            threads[i] = new ThreadA(service);
            threads[i].start();
        }
    }
}
