package com.xavier.practice.concurrent.semaphore.extthread;

import com.xavier.practice.concurrent.semaphore.service.ListPool;

public class MyThread extends Thread {
    private ListPool listPool;
    public MyThread(ListPool listPool) {
        this.listPool = listPool;
    }

    public void run() {
        for(int i = 0; i<Integer.MAX_VALUE; i++ ) {
            String getValue = listPool.get();
            System.out.println(getValue + "\t\t" + Thread.currentThread().getName());
            listPool.set(getValue);
        }
    }
}
