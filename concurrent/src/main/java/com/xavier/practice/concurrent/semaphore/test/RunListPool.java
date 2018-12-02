package com.xavier.practice.concurrent.semaphore.test;

import com.xavier.practice.concurrent.semaphore.extthread.MyThread;
import com.xavier.practice.concurrent.semaphore.service.ListPool;

public class RunListPool {
    public static void main(String[] args) {
        ListPool listPool = new ListPool();
        MyThread[] threads = new MyThread[12];
        for(int i=0; i< threads.length; i++) {
            threads[i] = new MyThread(listPool);
        }
        for(int i=0; i< threads.length; i++) {
            threads[i].start();
        }
    }
}
