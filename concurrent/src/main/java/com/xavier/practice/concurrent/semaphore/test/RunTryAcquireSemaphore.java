package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.TryAcquireSemaphore;

import java.util.concurrent.Semaphore;

public class RunTryAcquireSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        BaseSemaphore service = new TryAcquireSemaphore(semaphore);
        ((TryAcquireSemaphore) service).setMethodName("1");
        ThreadA t1 = new ThreadA(service);
        t1.setName("Thread One");
        t1.start();
        ThreadA t2 = new ThreadA(service);
        t2.setName("Thread Two");
        t2.start();
        Thread.sleep(5000);

        semaphore.release(3);
        ((TryAcquireSemaphore) service).setMethodName("2");
        ThreadA t3 = new ThreadA(service);
        t3.setName("Thread Three");
        t3.start();
        ThreadA t4 = new ThreadA(service);
        t4.setName("Thread Four");
        t4.start();
        Thread.sleep(5000);

        ThreadA t5 = new ThreadA(service);
        t5.setName("Thread Five");
        t5.start();
        ThreadA t6 = new ThreadA(service);
        t6.setName("Thread Six");
        t6.start();
        Thread.sleep(5000);
    }
}
