package com.xavier.practice.concurrent.semaphore.service;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProduceConsumeService {
    volatile private Semaphore setSemaphore = new Semaphore(10);
    volatile private Semaphore getSemaphore = new Semaphore(20);
    volatile private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getCondition = lock.newCondition();
    volatile  private Object[] producePosition = new Object[4];

    private boolean isEmpty() {
        boolean isEmpty = true;
        for(int i=0; i<producePosition.length;i++) {
            if(producePosition[i] != null) {
                isEmpty = false;
                break;
            }
        }
        if(isEmpty) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFull() {
        boolean isFull = true;
        for(int i=0; i< producePosition.length; i++) {
            if(producePosition[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void set() {
        try {
            setSemaphore.acquire();
            lock.lock();
            while(isFull()){
                setCondition.await();
            }
            for(int i=0; i< producePosition.length; i++) {
                if(producePosition[i] ==null) {
                    producePosition[i] = "Data";
                    System.out.println(Thread.currentThread().getName() + " produces " + producePosition[i]);
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setSemaphore.release();
        }
    }

    public void get() {
        try {
            getSemaphore.acquire();
            lock.lock();
            while(isEmpty()) {
                getCondition.await();
            }
            for(int i=0; i< producePosition.length; i++) {
                if(producePosition[i] !=null) {
                    System.out.println(Thread.currentThread().getName() + " consumes " + producePosition[i]);
                    producePosition[i] = null;
                    break;
                }
                setCondition.signalAll();
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getSemaphore.release();
        }
    }
}
