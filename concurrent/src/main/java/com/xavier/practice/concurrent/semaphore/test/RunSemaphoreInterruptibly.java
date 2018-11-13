package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.ThreadA;
import com.xavier.practice.concurrent.semaphore.extthread.ThreadB;
import com.xavier.practice.concurrent.semaphore.service.BaseSemaphore;
import com.xavier.practice.concurrent.semaphore.service.SemaphoreAcquireInterruptibly;

import java.util.concurrent.Semaphore;

public class RunSemaphoreInterruptibly {
    public static void main(String[] args) throws InterruptedException{
        Semaphore semaphore = new Semaphore(1);
        BaseSemaphore service = new SemaphoreAcquireInterruptibly(semaphore);

        ThreadA threadA = new ThreadA(service);
        threadA.setName("Thread A");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("Thread B");
        threadB.start();

        Thread.sleep(1000);

        //It doesn't work anymore
        threadB.interrupt();
        System.out.println("Main thread is done. And Thread A is still running!");

    }
}
