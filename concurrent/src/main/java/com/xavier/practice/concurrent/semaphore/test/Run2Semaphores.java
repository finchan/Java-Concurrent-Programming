package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.extthread.ThreadB;
import com.xavier.practice.concurrent.semaphore.extthread.ThreadC;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.SemaphorePermits;
import java.util.concurrent.Semaphore;

public class Run2Semaphores {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        BaseSemaphore service = new SemaphorePermits(semaphore);

        ThreadA a = new ThreadA(service);
        a.setName("A");

        ThreadB b = new ThreadB(service);
        b.setName("B");

        ThreadC c = new ThreadC(service);
        c.setName("C");

        a.start();
        b.start();
        c.start();
    }
}
