package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.extthread.ThreadB;
import com.xavier.practice.concurrent.semaphore.extthread.ThreadC;
import com.xavier.practice.concurrent.semaphore.service.ASemaphore;
import com.xavier.practice.concurrent.semaphore.service.JSemaphore;

public class Run {
    public static void main(String[] args) {
        ASemaphore service = new JSemaphore();

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
